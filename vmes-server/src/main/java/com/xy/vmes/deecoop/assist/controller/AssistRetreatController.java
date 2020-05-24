package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

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
import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_assist_retreat:外协退货单Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistRetreatController {
    private Logger logger = LoggerFactory.getLogger(AssistRetreatController.class);

    @Autowired
    private AssistRetreatService retreatService;
    @Autowired
    private AssistRetreatDetailService retreatDetailService;

    @Autowired
    private AssistPlanDetailService planDetailService;
    @Autowired
    private AssistOrderService assistOrderService;
    @Autowired
    private AssistOrderDetailService assistOrderDetailService;
    @Autowired
    private AssistOrderDetailChildService assistOrderChildService;

    @Autowired
    private PurchaseByFinanceBillService purchaseByFinanceBillService;
    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistRetreat/listPageAssistRetreat")
    public ResultModel listPageAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatService.listPageAssistRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协退料单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/addAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/addAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        List<AssistRetreatDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协退料单表
        AssistRetreat addRetreat = new AssistRetreat();
        addRetreat.setCuser(cuser);
        addRetreat.setCompanyId(companyID);
        addRetreat.setSupplierId(supplierId);

        //type 退货类型(1:外协件 2:外协原材料)
        String type = pageData.getString("type");
        if (type != null && type.trim().length() > 0) {
            addRetreat.setType(type);
        }

        //attribute 退货属性(1:系统生成 2:用户生成)
        String attribute = new String("2");
        if (pageData.getString("attribute") != null) {
            attribute = pageData.getString("attribute").trim();
        }
        addRetreat.setAttribute(attribute);

        //amount:金额(外协订单)
        BigDecimal amount = retreatDetailService.findTotalAmount(retreatDtlList);
        if (amount != null && amount.doubleValue() != 0) {
            addRetreat.setAmount(amount);
        }

        //外协订单编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_retreat",
                "R",
                Common.CODE_RULE_LENGTH_3);
        addRetreat.setSysCode(code);

        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        addRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addRetreat.setState("1");
        }

        retreatService.save(addRetreat);

        //2. 添加外协退料单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(addRetreat.getId());
                addDetail.setCuser(addRetreat.getCuser());
                addDetail.setState(addRetreat.getState());
                retreatDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/addAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交(审核)外协退料单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/submitAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/submitAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退料单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("1", parentId);

        //修改抬头表状态
        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreat.setState("1");
        editRetreat.setRemark("");
        retreatService.update(editRetreat);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/submitAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回(审核)外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/rebackSubmitAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/rebackSubmitAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("0");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/rebackSubmitAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/cancelAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/cancelAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("-1");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/cancelAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/rebackCancelAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/rebackCancelAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("0");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/rebackCancelAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/deleteAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/deleteAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //删除外协退料单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        retreatDetailService.deleteByColumnMap(columnMap);

        //删除外协退料单表
        retreatService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/deleteAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/updateAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/updateAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //外协退料单id
        String retreatId = pageData.getString("id");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协退料单id为空或空字符串！");
            return model;
        }
        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        List<AssistRetreatDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 修改外协退料单表
        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(retreatId);
        editRetreat.setSupplierId(supplierId);

        //amount:金额(外协订单)
        BigDecimal amount = retreatDetailService.findTotalAmount(retreatDtlList);
        if (amount != null && amount.doubleValue() != 0) {
            editRetreat.setAmount(amount);
        }

        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            editRetreat.setState("1");
        }

        retreatService.update(editRetreat);

        //外协退料明细采用先删除后添加方式
        //删除外协退料明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", retreatId);
        retreatDetailService.deleteByColumnMap(columnMap);

        //2. 添加外协退料单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(editRetreat.getId());
                addDetail.setCuser(editRetreat.getCuser());
                addDetail.setState(editRetreat.getState());
                retreatDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/updateAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 审核通过:外协退货(原材料, 成品)
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/auditPassAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/auditPassAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //外协退货单id
        String retreatId = pageData.getString("id");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协退货单id为空或空字符串！");
            return model;
        }
        //type:退货类型(1:外协件 2:外协原材料)
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货类型(type)为空或空字符串！");
            return model;
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String companyID = pageData.getString("currentCompanyId");
        String supplierId = pageData.getString("supplierId");
        String supplierName = pageData.getString("supplierName");
        String roleId = pageData.getString("roleId");
        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);

        //type:退货类型(1:外协件 2:外协原材料)
        if ("1".equals(type)) {
            if (companyID == null || companyID.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("企业id为空或空字符串！");
                return model;
            }

            if (supplierId == null || supplierId.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("供应商id为空或空字符串！");
                return model;
            }

            if (roleId == null || roleId.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前用户角色id为空或空字符串！");
                return model;
            }

            if (warehouse == null || warehouse.trim().length() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
                return model;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(retreatId);

        //state:状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        String state = "2";
        //type:退货类型(1:外协件 2:外协原材料)
        if ("1".equals(type)) {
            state = "3";
        } else if ("2".equals(type)) {
            state = "2";
        }

        editRetreat.setState(state);
        editRetreat.setAuditId(cuser);
        retreatService.update(editRetreat);

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail(state, retreatId);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //type:退货类型(1:外协件 2:外协原材料)
        if ("1".equals(type)) {
            //生成出库单
            List<AssistRetreatDetail> retreatDtlList = retreatDetailService.findAssistRetreatDetailListByParentId(retreatId);

            String retreatCode = pageData.getString("retreatCode");
            if (retreatDtlList != null && retreatDtlList.size() > 0) {
                Map<String, Map<String, Object>> businessByOutMap = retreatDetailService.findProductBusinessMapByOut(retreatDtlList);
                if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                    //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                    warehouseOutCreateService.createWarehouseOutBusinessByComplex(supplierId,
                            supplierName,
                            //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                            Common.DICTIONARY_MAP.get("warehouseEntity"),
                            cuser,
                            companyID,
                            //外协退货出库 75338f5acdcb40e2ac3fc5a0069229d0:assistRetreatOut
                            Common.DICTIONARY_MAP.get("assistRetreatOut"),
                            retreatCode,
                            businessByOutMap);
                } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
                    //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                    warehouseOutCreateService.createWarehouseOutBusinessBySimple(supplierId,
                            supplierName,
                            //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                            Common.DICTIONARY_MAP.get("warehouseEntity"),
                            cuser,
                            companyID,
                            //外协退货出库 75338f5acdcb40e2ac3fc5a0069229d0:assistRetreatOut
                            Common.DICTIONARY_MAP.get("assistRetreatOut"),
                            retreatCode,
                            businessByOutMap);
                }

                //反写业务出库单id
                if (businessByOutMap != null) {
                    for (Iterator iterator = businessByOutMap.keySet().iterator(); iterator.hasNext();) {
                        String businessId = iterator.next().toString().trim();
                        Map<String, Object> objectMap = businessByOutMap.get(businessId);
                        if (objectMap != null && objectMap.get("outDtlId") != null && objectMap.get("outDtlId").toString().trim().length() > 0) {
                            String outDtlId = objectMap.get("outDtlId").toString().trim();

                            AssistRetreatDetail editDetail = new AssistRetreatDetail();
                            editDetail.setId(businessId);
                            editDetail.setOutDtlId(outDtlId);
                            retreatDetailService.update(editDetail);
                        }
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //推送(外协)退款单
            BigDecimal totalAmount = retreatDetailService.findTotalAmount(retreatDtlList);
//单据类型 ( 0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购) 10:应付单(采购) 11:收货账单(外协) 12:退款单(外协) 13:扣款单(外协))
//销售(客户)  : 0:收款单(销售) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 8:应收单(销售)
//采购(供应商): 1:付款单(采购) 6:收货账单(采购) 7:扣款单(采购) 9:退款单(采购) 10:应付单(采购)
//外协(供应商): 11:收货账单(外协) 12:退款单(外协) 13:扣款单(外协)
            purchaseByFinanceBillService.addFinanceBillByAssist(retreatId,
                    companyID,
                    supplierId,
                    cuser,
                    //外协(供应商): 11:收货账单(外协) 12:退款单(外协) 13:扣款单(外协)
                    "12",
                    //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                    "2",
                    null,
                    totalAmount,
                    retreatCode);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改外协订单状态
        PageData findMap = new PageData();
        findMap.put("parentId", retreatId);

        Map<String, String> orderMap = new HashMap<>();
        //SQL: AssistRetreatDetailMapper.getDataListPage
        List<Map> varList = retreatDetailService.getDataListPage(findMap, null);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                String orderId = (String)mapObject.get("orderId");
                if (orderId != null && orderId.trim().length() > 0) {
                    orderMap.put(orderId, orderId);
                }
            }
        }

        for (Iterator iterator_1 = orderMap.keySet().iterator(); iterator_1.hasNext();) {
            String orderId = (String)iterator_1.next();

            //根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
            //查询SQL:AssistOrderDetailChildMapper.findCheckAssistOrderChild
            List<Map<String, Object>> orderChildList = assistOrderChildService.findCheckAssistOrderChild(orderId);
            String finishOrderId = assistOrderChildService.finishOrderByAssistOrderChild(orderChildList);

            if (finishOrderId != null && finishOrderId.trim().length() > 0) {
                AssistOrder editOrder = new AssistOrder();
                editOrder.setId(finishOrderId);
                //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
                editOrder.setState("4");
                assistOrderService.update(editOrder);

                //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
                assistOrderDetailService.updateStateByDetail("4", finishOrderId);

                Map<String, String> planMap = new HashMap<>();
                Map<String, String> planDtlMap = new HashMap<>();
                if (orderChildList != null && orderChildList.size() > 0) {
                    for (Map<String, Object> objectMap : orderChildList) {
                        //planId 外协计划id
                        String planId = (String)objectMap.get("planId");
                        if (planId != null && planId.trim().length() > 0) {
                            planMap.put(planId, planId);
                        }

                        //planDtlId 外协计划明细id
                        String planDtlId = (String)objectMap.get("planDtlId");
                        if (planDtlId != null && planDtlId.trim().length() > 0) {
                            planDtlMap.put(planDtlId, planDtlId);
                        }
                    }
                }

                //外协计划明细
                if (planDtlMap != null) {
                    for (Iterator iterator = planDtlMap.keySet().iterator(); iterator.hasNext();) {
                        String planDtlId = (String)iterator.next();
                        if (planDtlId != null && planDtlId.trim().length() > 0) {
                            AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                            editPlanDtl.setId(planDtlId);
                            //状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                            editPlanDtl.setState("4");
                            planDetailService.update(editPlanDtl);
                        }
                    }
                }

                if (planMap != null) {
                    for (Iterator iterator = planMap.keySet().iterator(); iterator.hasNext();) {
                        String planId = (String)iterator.next();
                        if (planId != null && planId.trim().length() > 0) {
                            AssistPlan editPlan = new AssistPlan();
                            editPlan.setId(planId);
                            planDetailService.updateParentStateByDetailList(editPlan, null);
                        }
                    }
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/auditPassAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不通过:外协退货(原材料, 成品)
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/auditDisagreeAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/auditDisagreeAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //外协退货单id
        String retreatId = pageData.getString("id");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协退货单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(retreatId);

        String msgTemp = "审核退回：{0}";
        String remarkStr = MessageFormat.format(msgTemp, remark);
        editRetreat.setRemark(remarkStr);

        //state:状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreat.setState("0");
        //审核人ID
        editRetreat.setAuditId(cuser);
        retreatService.update(editRetreat);

        //明细状态状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("0", retreatId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/auditDisagreeAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<AssistRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<AssistRetreatDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            AssistRetreatDetail detail = (AssistRetreatDetail)HttpUtils.pageData2Entity(mapObject, new AssistRetreatDetail());

            //退货数量(订单单位)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setOrderCount(orderCount);

            //price 单价(外协件)
            BigDecimal price = BigDecimal.valueOf(0D);
            if (detail.getPrice() != null) {
                price = detail.getPrice();
            }
            //四舍五入到4位小数
            price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setPrice(price);

            //amount 金额(外协件)
            BigDecimal amount = BigDecimal.valueOf(orderCount.doubleValue() * price.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setAmount(amount);

            objectList.add(detail);
        }

        return objectList;
    }

}



