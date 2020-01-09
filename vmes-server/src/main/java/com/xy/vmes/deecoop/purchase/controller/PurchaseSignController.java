package com.xy.vmes.deecoop.purchase.controller;

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
* 说明：vmes_purchase_sign:采购签收Controller
* @author 刘威 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchaseSignController {
    private Logger logger = LoggerFactory.getLogger(PurchaseSignController.class);

    @Autowired
    private PurchaseSignService signService;
    @Autowired
    private PurchaseSignDetailService signDetailService;
    @Autowired
    private PurchaseOrderDetailToolService orderDetailToolService;

    @Autowired
    private PurchaseOrderService orderService;
    @Autowired
    private PurchaseOrderDetailService orderDetailService;

    @Autowired
    private PurchasePlanService planService;
    @Autowired
    private PurchasePlanDetailService planDetailService;

    @Autowired
    private QualityService qualityService;
    @Autowired
    private PurchaseQualityDetailService purchaseQualityDetailService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 刘威
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/listPagePurchaseSign")
    public ResultModel listPagePurchaseSign() throws Exception {
        logger.info("################/purchase/purchaseSign/listPagePurchaseSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = signService.listPagePurchaseSign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/listPagePurchaseSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/purchase/purchaseSign/addPurchaseSign")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addPurchaseSign() throws Exception {
        logger.info("################/purchase/purchaseSign/addPurchaseSign 执行开始 ################# ");
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
        List<PurchaseSignDetail> signDtlList = new ArrayList<>();
        String orderDtlIds = new String();
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> objectMap : jsonMapList) {
                PurchaseSignDetail addSignDtl = (PurchaseSignDetail)HttpUtils.pageData2Entity(objectMap, new PurchaseSignDetail());
                addSignDtl.setId(Conv.createUuid());

                ///////////////////////////////////////////////////////////////////////////////////////////////
                //单位换算
                //p2nFormula 单位换算公式:计价单位转换计量单位:
                String p2nFormula = new String();
                if (objectMap.get("p2nFormula") != null) {
                    p2nFormula = objectMap.get("p2nFormula").trim();
                }
                addSignDtl.setP2nFormula(p2nFormula);

                //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String p2nIsScale = new String();
                if (objectMap.get("p2nIsScale") != null) {
                    p2nIsScale = objectMap.get("p2nIsScale").trim();
                }
                addSignDtl.setP2nIsScale(p2nIsScale);

                //小数位数 (最小:0位 最大:4位)
                Integer p2nDecimalCount = Integer.valueOf(2);
                String p2nDecimalCountStr = objectMap.get("p2nDecimalCount");
                if (p2nDecimalCountStr != null) {
                    try {
                        p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                addSignDtl.setP2nDecimalCount(p2nDecimalCount);

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
                } else if ("2".equals(addSignDtl.getQuality().trim())) {
                    addSignDtl.setState("1");
                }

                //采购订单明细ID orderDetailId
                String orderDetailId = addSignDtl.getOrderDetailId();
                orderDtlIds = orderDtlIds + orderDetailId + ",";

                signDtlList.add(addSignDtl);
                signDetailService.save(addSignDtl);
            }
        }

        //创建签收单
        PurchaseSign addSign = new PurchaseSign();
        addSign.setId(addSignId);
        addSign.setCompanyId(companyId);
        addSign.setCuser(cuser);
        //签收人(系统用户id)
        addSign.setSignId(cuser);

        //采购订单id orderId
        addSign.setOrderId(orderId);
        //sysCode 签收单号(系统生成)
        String sysCode = coderuleService.createCoderCdateOnShortYearByDate(companyId,
                "vmes_purchase_sign",
                "S",
                Common.CODE_RULE_LENGTH_SHORTYEAR);
        addSign.setSysCode(sysCode);

        //获取签收单状态-根据签收单明细
        String parentState = signDetailService.findParentStateByDetailList(signDtlList);
        addSign.setState(parentState);
        signService.save(addSign);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //反写 (采购订单明细,采购订单)状态
        //根据(采购订单明细id) 查询
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //SQL语句: PurchaseOrderDetailCollectMapper.findPurchaseOrderDetailCollect
            PageData findMap = new PageData();
            findMap.put("detailIds", detailIds);
            orderDetailMap = orderDetailToolService.findPurchaseOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 采购计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDtlList != null && signDtlList.size() > 0) {
            for (PurchaseSignDetail signDetail : signDtlList) {
                PurchaseOrderDetail editOrderDtl = new PurchaseOrderDetail();

                //orderDetailId 采购订单明细ID
                String orderDetailId = signDetail.getOrderDetailId();
                editOrderDtl.setId(orderDetailId);

                Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
                //detailCount 采购数量
                BigDecimal detailCount = BigDecimal.valueOf(0D);
                if (valueMap.get("detailCount") != null) {
                    detailCount = (BigDecimal)valueMap.get("detailCount");
                }

                //arriveCount 签收数量:= (已完成)签收数量 - (已完成)退货数量
                BigDecimal arriveCount = BigDecimal.valueOf(0D);
                if (valueMap.get("arriveCount") != null) {
                    arriveCount = (BigDecimal)valueMap.get("arriveCount");
                }

                //采购单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
                if (arriveCount.doubleValue() >= detailCount.doubleValue()) {
                    editOrderDtl.setState("4");
                    orderDetailService.update(editOrderDtl);

                    //planDtlId 采购计划明细id
                    String planDtlId = (String)valueMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        PurchasePlanDetail editPlanDtl = new PurchasePlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //采购计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        planDetailService.update(editPlanDtl);
                    }
                }

                //planId 采购计划id
                if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                    String planId = (String)valueMap.get("planId");
                    planIdMap.put(planId.trim(), planId.trim());
                }
            }
        }

        //反写采购订单状态
        orderService.updateState(orderId);
        //反写 (采购计划明细,采购计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    planService.updateState(planId);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据质检属性 (1:免检 2:检验) 过滤出两个结构体
        List<PurchaseSignDetail> notQualityList = new ArrayList<>();
        List<PurchaseSignDetail> qualityList = new ArrayList<>();
        String productIds = new String();
        if (signDtlList != null && signDtlList.size() > 0) {
            for (PurchaseSignDetail signDetail : signDtlList) {
                //quality 质检属性 (1:免检 2:检验)
                String quality = signDetail.getQuality();

                //quality 质检属性:1:免检 (1:免检 2:检验)
                if ("1".equals(quality)) {
                    notQualityList.add(signDetail);

                    //quality 质检属性:2:检验 (1:免检 2:检验)
                } else if ("2".equals(quality)) {
                    qualityList.add(signDetail);
                }

                //productId 货品id
                String productId = signDetail.getProductId();
                if (productId != null && productId.trim().length() > 0) {
                    productIds = productIds + productId.trim() + ",";
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //质检属性:1:免检 (1:免检 2:检验) --推送入库单
        if (notQualityList.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX

            Map<String, Map<String, Object>> businessByInMap = signDetailService.findBusinessProducMapByIn(notQualityList);
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    editSignDetail.setInDetailId(inDtlId);

                    signDetailService.update(editSignDetail);
                }
            }

        } else if (notQualityList.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE

            Map<String, Map<String, Object>> businessByInMap = signDetailService.findBusinessProducMapByIn(notQualityList);
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    editSignDetail.setInDetailId(inDtlId);

                    signDetailService.update(editSignDetail);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //质检属性:2:检验 (1:免检 2:检验) --推送采购检验项
        Map<String, List<Quality>> prodQualityMap = new HashMap<>();

        if (productIds != null && productIds.trim().length() > 0) {
            productIds = StringUtil.stringTrimSpace(productIds);
            productIds = "'" + productIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("productIds", productIds);
            //业务名称 (purchase:采购)
            findMap.put("business", "purchase");
            findMap.put("orderStr", "product_id asc");
            List<Quality> prodQualityList = qualityService.findQualityList(findMap);

            if (prodQualityList != null && prodQualityList.size() > 0) {
                for (Quality quality : prodQualityList) {
                    String productId = quality.getProductId();

                    if (prodQualityMap.get(productId) == null) {
                        List<Quality> tempList = new ArrayList<>();
                        tempList.add(quality);
                        prodQualityMap.put(productId, tempList);
                    } else if (prodQualityMap.get(productId) != null) {
                        List<Quality> tempList = prodQualityMap.get(productId);
                        tempList.add(quality);
                    }
                }
            }
        }

        if (signDtlList != null && signDtlList.size() > 0) {
            for (PurchaseSignDetail signDetail : signDtlList) {
                PurchaseQualityDetail addQualityDtl = new PurchaseQualityDetail();
                addQualityDtl.setSignDetailId(signDetail.getId());
                addQualityDtl.setOrderUnit(signDetail.getOrderUnit());

                //货品id productId
                String productId = signDetail.getProductId();
                addQualityDtl.setProductId(productId);

                //qualityId 质检项id
                List<Quality> prodQualityList = prodQualityMap.get(productId);
                if (prodQualityList != null && prodQualityList.size() > 0) {
                    for (Quality quality : prodQualityList) {
                        addQualityDtl.setQualityId(quality.getId());
                    }
                }

                purchaseQualityDetailService.save(addQualityDtl);
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/addPurchaseSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



