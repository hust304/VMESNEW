package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_assist_sign:外协签收单Controller
* @author 陈刚 自动生成
* @date 2020-05-04
*/
@RestController
@Slf4j
public class AssistSignController {
    private Logger logger = LoggerFactory.getLogger(AssistSignController.class);

    @Autowired
    private AssistSignService assistSignService;
    @Autowired
    private AssistSignDetailService assistSignDetailService;
    @Autowired
    private AssistOrderDetailService assistOrderDetailService;
    @Autowired
    private AssistPlanDetailService assistPlanDetailService;

    @Autowired
    private WarehouseInService inService;
    @Autowired
    private WarehouseInDetailService inDetailService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-04
    */
    @PostMapping("/assist/assistSign/listPageAssistSign")
    public ResultModel listPageAssistSign() throws Exception {
        logger.info("################/assist/assistSign/listPageAssistSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignService.listPageAssistSign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSign/listPageAssistSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/assist/assistSign/addAssistSign")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistSign() throws Exception {
        logger.info("################/assist/assistSign/addPurchaseSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //获取基本参数 数据非空验证
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //orderId 采购订单id
        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购订单id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一行数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收单明细Json字符串-转换成List错误！");
            return model;
        }

        //创建(复杂版,简版)仓库-入库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }
        //供应商(供应商id,供应商名称)
        String supplierName = pageData.getString("supplierName");
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //创建签收单 (签收单-签收单明细)
        String addSignId = Conv.createUuid();

        //创建签收单明细
        List<AssistSignDetail> signDtlList = new ArrayList<>();
        String orderDtlIds = new String();
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> objectMap : jsonMapList) {
                AssistSignDetail addSignDtl = (AssistSignDetail)HttpUtils.pageData2Entity(objectMap, new AssistSignDetail());
                addSignDtl.setId(Conv.createUuid());
                objectMap.put("signDtlId", addSignDtl.getId());
                ///////////////////////////////////////////////////////////////////////////////////////////////
                addSignDtl.setParentId(addSignId);
                //quality 质检属性 (1:免检 2:检验)
                String quality = "1";
                if (addSignDtl.getQuality() != null && addSignDtl.getQuality().trim().length() > 0
                    && "1,2".indexOf(addSignDtl.getQuality().trim()) != -1
                ) {
                    quality = addSignDtl.getQuality().trim();
                }
                addSignDtl.setQuality(quality);

                //state 状态(1:检验中 2:已完成 -1:已取消)
                //quality:质检属性:1:免检  state:2:已完成
                //quality:质检属性:2:检验  state:1:检验中
                if ("1".equals(addSignDtl.getQuality().trim())) {
                    addSignDtl.setState("2");
                    addSignDtl.setQualityType(null);

                    //signFineCount 收货合格数(签收数)
                    addSignDtl.setSignFineCount(addSignDtl.getArriveCount());
                    //qualityFineCount (实际)检验合格数
                    addSignDtl.setQualityFineCount(addSignDtl.getArriveCount());

                } else if ("2".equals(addSignDtl.getQuality().trim())) {
                    addSignDtl.setState("1");
                }

                //采购订单明细ID orderDetailId
                String orderDetailId = addSignDtl.getOrderDetailId();
                orderDtlIds = orderDtlIds + orderDetailId + ",";

                signDtlList.add(addSignDtl);
                assistSignDetailService.save(addSignDtl);
            }
        }

        //创建签收单
        AssistSign addSign = new AssistSign();
        addSign.setId(addSignId);
        addSign.setCompanyId(companyId);
        addSign.setCuser(cuser);
        //签收人(系统用户id)
        addSign.setSignId(cuser);
        addSign.setSignDate(new Date());

        //外协订单id orderId
        addSign.setOrderId(orderId);
        //sysCode 签收单号(系统生成)
        String sysCode = coderuleService.createCoderCdateOnShortYearByDate(companyId,
                "vmes_assist_sign",
                "S",
                Common.CODE_RULE_LENGTH_SHORTYEAR);
        addSign.setSysCode(sysCode);

        //获取签收单状态-根据签收单明细
        String parentState = assistSignDetailService.findParentStateByDetailList(signDtlList);
        addSign.setState(parentState);
        assistSignService.save(addSign);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //反写 (采购订单明细,采购订单)状态
        //根据(采购订单明细id) 查询
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //获取外协订单明细(订单数量, 签收合格数量)
            //查询SQL:AssistOrderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign
            PageData findMap = new PageData();
            findMap.put("orderDtlIds", detailIds);
            orderDetailMap = assistOrderDetailService.findCheckAssistOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 采购计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDtlList != null && signDtlList.size() > 0) {
            for (AssistSignDetail signDetail : signDtlList) {
                AssistOrderDetail editOrderDtl = new AssistOrderDetail();

                //orderDetailId 采购订单明细ID
                String orderDetailId = signDetail.getOrderDetailId();
                editOrderDtl.setId(orderDetailId);

                Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
                if (valueMap == null) {continue;}

                //orderCount 订单数量
                BigDecimal detailCount = BigDecimal.valueOf(0D);
                if (valueMap.get("orderCount") != null) {
                    detailCount = (BigDecimal)valueMap.get("orderCount");
                }

                //signFineCount 收货合格数(签收数-(检验)退货数)
                BigDecimal signFineCount = BigDecimal.valueOf(0D);
                if (valueMap.get("signFineCount") != null) {
                    signFineCount = (BigDecimal)valueMap.get("signFineCount");
                }

                //采购单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收(无此状态) 4:已完成 -1:已取消)
                if (signFineCount.doubleValue() >= detailCount.doubleValue()) {
                    editOrderDtl.setState("4");
                    assistOrderDetailService.update(editOrderDtl);

                    //planDtlId 采购计划明细id
                    String planDtlId = (String)valueMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //外协计划明细状态 (0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        assistPlanDetailService.update(editPlanDtl);
                    }
                }

                //planId 采购计划id
                if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                    String planId = (String)valueMap.get("planId");
                    planIdMap.put(planId.trim(), planId.trim());
                }
            }
        }

        //反写外协订单状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);
        assistOrderDetailService.updateParentStateByDetailList(editOrder, null);
        //反写 (采购计划明细,采购计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    AssistPlan editPlan = new AssistPlan();
                    editPlan.setId(planId);
                    assistPlanDetailService.updateParentStateByDetailList(editPlan, null);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //质检属性:1:免检 (1:免检 2:检验) --推送入库单
        List<Map<String, String>> notQualityList = new ArrayList<>();

        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> objectMap : jsonMapList) {
                //quality 质检属性 (1:免检 2:检验)
                String quality = objectMap.get("quality");
                if ("1".equals(quality)) {
                    notQualityList.add(objectMap);
                }
            }
        }

        if (notQualityList.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            String businessCode = addSign.getSysCode();
            Map<String, Map<String, Object>> businessByInMap = assistSignDetailService.findBusinessProducMapByIn(notQualityList);
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    businessCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDetail = new AssistSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    editSignDetail.setInDetailId(inDtlId);

                    assistSignDetailService.update(editSignDetail);
                }
            }

        } else if (notQualityList.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            String businessCode = addSign.getSysCode();
            Map<String, Map<String, Object>> businessByInMap = assistSignDetailService.findBusinessProducMapByIn(notQualityList);
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    businessCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDetail = new AssistSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    editSignDetail.setInDetailId(inDtlId);

                    assistSignDetailService.update(editSignDetail);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //生成免检:收货账单(采购)
//        //获取该签收单(免检)明细
//        //List<Map<String, String>> notQualityList //质检属性:1:免检 (1:免检 2:检验)
//        BigDecimal amountSum = BigDecimal.valueOf(0D);
//        if (notQualityList != null && notQualityList.size() > 0) {
//            for (Map<String, String> objectMap : notQualityList) {
//                // arriveCount:签收数量
//                BigDecimal arriveCount = BigDecimal.valueOf(0D);
//                String arriveCountStr = objectMap.get("arriveCount");
//                if (arriveCountStr != null && arriveCountStr.trim().length() > 0) {
//                    try {
//                        arriveCount = new BigDecimal(arriveCountStr);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                //price: 单价(采购订单明细)
//                BigDecimal price = BigDecimal.valueOf(0D);
//                String priceStr = objectMap.get("price");
//                if (priceStr != null && priceStr.trim().length() > 0) {
//                    try {
//                        price = new BigDecimal(priceStr);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                //amount 签收金额 = 签收数量 * 单价
//                BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * arriveCount.doubleValue());
//                amountSum = BigDecimal.valueOf(amountSum.doubleValue() + amount.doubleValue());
//            }
//        }
//
//        if (amountSum.doubleValue() > 0) {
//            //四舍五入到2位小数
//            amountSum = amountSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            //生成采购付款单(vmes_finance_bill)
//            purchaseByFinanceBillService.addFinanceBillByPurchase(addSign.getId(),
//                    companyId,
//                    supplierId,
//                    cuser,
//                    //type单据类型(0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购))
//                    "6",
//                    //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
//                    "2",
//                    null,
//                    amountSum,
//                    addSign.getSysCode());
//        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSign/addPurchaseSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消(外协)签收单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/assist/assistSign/cancelAssistSign")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistSign() throws Exception {
        logger.info("################/assist/assistSign/cancelAssistSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //signId 采购签收单id
        String signId = pageData.getString("signId");
        if (signId == null || signId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收单id为空或空字符串！");
            return model;
        }

        //获取免检入库单id-根据(签收单id,quality:质检属性:1:免检)查询
        PageData findMap = new PageData();
        findMap.put("parentId", signId);
        findMap.put("quality", "1");
        List<Map> mapList = assistSignDetailService.getDataListPage(findMap, null);

        //获取(入库单id)Map-遍历查询结构集
        Map<String, String> inParentMap = new HashMap<>();
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                //inParentId (免检)入库单
                String inParentId = (String)objectMap.get("inParentId");

                if (inParentId != null && inParentId.trim().length() > 0) {
                    inParentMap.put(inParentId.trim(), inParentId.trim());
                }
            }
        }

        //取消入库单
        if (inParentMap != null) {
            for (Iterator iterator = inParentMap.keySet().iterator(); iterator.hasNext();) {
                //inParentId 入库单id
                String inParentId = (String)iterator.next();

                //修改入库单明细状态
                PageData mapDetail = new PageData();
                mapDetail.put("parentId", inParentId);
                //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                mapDetail.put("state", "-1");
                inDetailService.updateStateByDetail(mapDetail);

                //修改入库单状态
                WarehouseIn editWarehouseIn = new WarehouseIn();
                editWarehouseIn.setId(inParentId);
                //状态(0:未完成 1:已完成 -1:已取消)
                editWarehouseIn.setState("-1");
                inService.update(editWarehouseIn);
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //取消外协签收单
        //明细状态:状态(1:检验中 2:已完成 -1:已取消)
        assistSignDetailService.updateStateByDetail("-1", signId);

        AssistSign editSign = new AssistSign();
        editSign.setId(signId);
        //状态(1:检验中 2:已完成 -1:已取消)
        editSign.setState("-1");
        assistSignService.update(editSign);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSign/cancelAssistSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



