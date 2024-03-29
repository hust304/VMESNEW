package com.xy.vmes.deecoop.assist.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.AssistOrder;
import com.xy.vmes.entity.AssistOrderDetail;
import com.xy.vmes.entity.AssistPlan;
import com.xy.vmes.entity.AssistPlanDetail;
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
* 说明：vmes_assist_order:外协订单表Controller
* @author 陈刚 自动生成
* @date 2020-04-24
*/
@RestController
@Slf4j
public class AssistOrderController {
    private Logger logger = LoggerFactory.getLogger(AssistOrderController.class);

    @Autowired
    private AssistOrderService orderService;
    @Autowired
    private AssistOrderDetailService orderDtlService;
    @Autowired
    private AssistOrderDetailChildService orderDetailChildService;

    @Autowired
    private AssistPlanDetailService planDetailService;

    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-24
    */
    @PostMapping("/assist/assistOrder/listPageAssistOrder")
    public ResultModel listPageAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderService.listPageAssistOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协订单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/addAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/addAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String makeId = pageData.getString("makeId");
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

        List<AssistOrderDetail> orderDtlList = orderDtlService.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协订单表
        AssistOrder addOrder = new AssistOrder();
        addOrder.setCuser(cuser);
        addOrder.setCompanyId(companyID);
        addOrder.setOrderDate(new Date());

        addOrder.setSupplierId(supplierId);
        addOrder.setMakeId(cuser);
        if (makeId != null && makeId.trim().length() > 0) {
            addOrder.setMakeId(makeId.trim());
        }

        //amount:金额(外协订单)
        BigDecimal amount = orderDtlService.findTotalAmount(orderDtlList);
        addOrder.setAmount(amount);

        //外协订单编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_order",
                "O",
                Common.CODE_RULE_LENGTH_3);
        addOrder.setSysCode(code);

        //expectDate 约定交期(yyyy-MM-dd)
        Date expectDate = this.findMaxExpectDate(orderDtlList);
        addOrder.setExpectDate(expectDate);

        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        addOrder.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addOrder.setState("1");
        }

        orderService.save(addOrder);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 添加外协订单明细表
        if (orderDtlList != null && orderDtlList.size() > 0) {
            for (AssistOrderDetail addDetail : orderDtlList) {
                addDetail.setParentId(addOrder.getId());
                addDetail.setCuser(addOrder.getCuser());
                addDetail.setState(addOrder.getState());
                orderDtlService.save(addDetail);

                orderDetailChildService.insertAssistOrderDetailChild(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/addAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交(审核)外协订单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/submitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/submitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("1", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("1");
        editOrder.setRemark("");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/submitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回(审核)外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/rebackSubmitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/cancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("-1");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/rebackCancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/deleteAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //删除外协订单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        orderDtlService.deleteByColumnMap(columnMap);

        //删除外协订单明细子表
        columnMap = new HashMap();
        columnMap.put("order_id", parentId);
        orderDetailChildService.deleteByColumnMap(columnMap);

        //删除外协订单表
        orderService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/updateAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/updateAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String makeId = pageData.getString("makeId");

        //外协订单id
        String orderId = pageData.getString("id");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协订单id为空或空字符串！");
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

        List<AssistOrderDetail> orderDtlList = orderDtlService.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 修改外协订单表
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);

        editOrder.setSupplierId(supplierId);
        editOrder.setMakeId(cuser);
        if (makeId != null && makeId.trim().length() > 0) {
            editOrder.setMakeId(makeId.trim());
        }

        //amount:金额(外协订单)
        BigDecimal amount = orderDtlService.findTotalAmount(orderDtlList);
        editOrder.setAmount(amount);

        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            editOrder.setState("1");
        }

        orderService.update(editOrder);

        //外协订单明细采用先删除后添加方式
        //删除外协订单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", orderId);
        orderDtlService.deleteByColumnMap(columnMap);

        //删除外协订单明细子表
        columnMap = new HashMap();
        columnMap.put("order_id", orderId);
        orderDetailChildService.deleteByColumnMap(columnMap);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 添加外协订单明细表
        if (orderDtlList != null && orderDtlList.size() > 0) {
            for (AssistOrderDetail addDetail : orderDtlList) {
                addDetail.setParentId(editOrder.getId());
                addDetail.setCuser(cuser);
                addDetail.setState(editOrder.getState());
                orderDtlService.save(addDetail);

                orderDetailChildService.insertAssistOrderDetailChild(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/updateAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 审核通过:外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/auditPassAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //外协订单id
        String orderId = pageData.getString("id");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协订单id为空或空字符串！");
            return model;
        }

        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);
        //state:订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("2");
        editOrder.setAuditId(cuser);
        orderService.update(editOrder);

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("2", orderId);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //如果有外协计划-更改外协计划状态
        //根据(外协订单id)获取外协订单明细List
        PageData findMap = new PageData();
        findMap.put("parentId", orderId);
        List<Map> mapList = orderDtlService.getDataListPage(findMap, null);

        Map<String, String> planMap = new HashMap<>();
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                //外协计划id
                String planId = (String)objectMap.get("planId");
                if (planId != null && planId.trim().length() > 0) {
                    planMap.put(planId, planId);
                }

                //外协计划明细id
                String planDetailId = (String)objectMap.get("planDetailId");
                AssistPlanDetail editPlanDetail = new AssistPlanDetail();
                editPlanDetail.setId(planDetailId);
                //状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                editPlanDetail.setState("3");
                planDetailService.update(editPlanDetail);
            }
        }

        //修改外协计划状态
        for (Iterator iterator = planMap.keySet().iterator(); iterator.hasNext();) {
            String planId = iterator.next().toString().trim();

            AssistPlan editPlan = new AssistPlan();
            editPlan.setId(planId);
            planDetailService.updateParentStateByDetailList(editPlan, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不通过:外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/auditDisagreeAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //外协订单id
        String orderId = pageData.getString("id");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协订单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);

        String msgTemp = "审核退回：{0}";
        String remarkStr = MessageFormat.format(msgTemp, remark);
        editOrder.setRemark(remarkStr);

        //state:订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        //审核人ID
        editOrder.setAuditId(cuser);
        orderService.update(editOrder);

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("0", orderId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Date findMaxExpectDate(List<AssistOrderDetail> orderDtlList) {
        Date maxExpectDate = new Date();

        if (orderDtlList != null && orderDtlList.size() > 0) {
            long maxDateLong = -1;
            for (int i = 0; i < orderDtlList.size(); i++) {
                AssistOrderDetail detail = orderDtlList.get(i);

                //expectDate 约定交期(yyyy-MM-dd)
                Date expectDate = detail.getExpectDate();
                if (i == 0) {
                    maxDateLong = expectDate.getTime();
                } else if (i > 0) {
                    if (expectDate.getTime() > maxDateLong) {maxDateLong = expectDate.getTime();}
                }
            }
            maxExpectDate = new Date(maxDateLong);
        }

        String maxExpectDateStr = DateFormat.date2String(maxExpectDate, DateFormat.DEFAULT_DATE_FORMAT);
        maxExpectDate = DateFormat.dateString2Date(maxExpectDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        return maxExpectDate;
    }
}

