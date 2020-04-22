package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.entity.FinanceHistory;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_finance_bill (采购)应付Controller
 * @author 陈刚
 * @date 2020-03-31
 */
@RestController
@Slf4j
public class PurchaseByFinanceBillController {
    private Logger logger = LoggerFactory.getLogger(PurchaseByFinanceBillController.class);

    @Autowired
    private PurchaseByFinanceBillService purchaseByFinanceBillService;
    @Autowired
    private FinanceBillService financeBillService;
    @Autowired
    private PurchaseCompanyPeriodService purchaseCompanyPeriodService;

    @Autowired
    private FinanceHistoryService financeHistoryService;

    @Autowired
    private CoderuleService coderuleService;

    @PostMapping("/purchase/purchasePayment/listPagePurchaseByFinanceBill")
    public ResultModel listPagePurchaseByFinanceBill() throws Exception {
        logger.info("################/purchase/purchasePayment/listPagePurchaseByFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseByFinanceBillService.listPagePurchaseByFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/listPagePurchaseByFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (采购-采购应付款-应付款查询) 列表查询
     * 采购应付 FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/listPageFinanceBillByPurchaseView")
    public ResultModel listPageFinanceBillByPurchaseView() throws Exception {
        logger.info("################/purchase/purchasePayment/listPageFinanceBillByPurchaseView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseByFinanceBillService.listPageFinanceBillByPurchaseView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/listPageFinanceBillByPurchaseView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (采购-采购应付款-应付款查询)-当前期间期末(应付款,预付款)合计
     * 采购应付 FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/findFinanceBillByPurchaseView")
    public ResultModel findFinanceBillByPurchaseView() throws Exception {
        logger.info("################/purchase/purchasePayment/findFinanceBillByPurchaseView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        pd.put("companyId", companyId);

        //系统时间(yyyymm)
        String sysMonthStr = DateFormat.date2String(new Date(), "yyyyMM");
        //查询付款期
        String queryPeriod = sysMonthStr;

        //paymentPeriod:当前付款期(yyyymm)
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        PurchaseCompanyPeriod companyPeriod = purchaseCompanyPeriodService.findPurchaseCompanyPeriod(findMap);
        if (companyPeriod != null && companyPeriod.getPaymentPeriod() != null) {
            queryPeriod = companyPeriod.getPaymentPeriod();
        }

        //查询语句与(采购-采购应付款-应付款查询)模块查询相同
        //FinanceBillByPurchaseMapper.findFinanceBillByPurchaseView
        Map<String, String> periodMap = purchaseByFinanceBillService.findQueryPeriodMap(queryPeriod);
        if (periodMap != null && periodMap.size() > 0) {
            pd.put("period", periodMap.get("period"));
            pd.put("forePeriod", periodMap.get("forePeriod"));
        }

        List<Map> varList = purchaseByFinanceBillService.findFinanceBillByPurchaseView(pd, null);
        purchaseByFinanceBillService.modifyCheckOutFinanceBillByPurchase(varList, queryPeriod);

        //当前期间期末(应付款,预付款)合计
        //endPlusSum 应付款合计
        BigDecimal endPlusSum = BigDecimal.valueOf(0D);
        //endMinusSum 预付款合计
        BigDecimal endMinusSum = BigDecimal.valueOf(0D);

        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //endPlus 当前应付
                BigDecimal endPlus = BigDecimal.valueOf(0D);
                try {
                    //转换字符串
                    String endPlusStr = (String)mapObject.get("endPlus");
                    try {
                        endPlus = new BigDecimal(endPlusStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } catch (ClassCastException e) {
                    //转换BigDecimal
                    endPlus = (BigDecimal)mapObject.get("endPlus");
                }
                endPlusSum = BigDecimal.valueOf(endPlusSum.doubleValue() + endPlus.doubleValue());

                //endMinus 当前预付
                BigDecimal endMinus = BigDecimal.valueOf(0D);
                try {
                    //转换字符串
                    String endMinusStr = (String)mapObject.get("endMinus");
                    try {
                        endMinus = new BigDecimal(endMinusStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } catch (ClassCastException e) {
                    //转换BigDecimal
                    endMinus = (BigDecimal)mapObject.get("endMinus");
                }
                endMinusSum = BigDecimal.valueOf(endMinusSum.doubleValue() + endMinus.doubleValue());
            }
        }

        //endPlusSum 应付款合计 四舍五入到2位小数
        endPlusSum = endPlusSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        model.put("endPlusSum", endPlusSum.toString());

        //endMinusSum 预付款合计 四舍五入到2位小数
        endMinusSum = endMinusSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        model.put("endMinusSum", endMinusSum.toString());

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/findFinanceBillByPurchaseView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 采购应付(付款单)明细 FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/listPageFinanceBillDetailByPurchase")
    public ResultModel listPageFinanceBillDetailByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/listPageFinanceBillDetailByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseByFinanceBillService.listPageFinanceBillDetailByPurchase(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/listPageFinanceBillDetailByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 审核(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/auditFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/auditFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String userId = pageData.getString("cuser");
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("2");

        //suser:审核用户id
        editFinanceBill.setSuser(userId);
        //sdate:审核时间
        editFinanceBill.setSdate(new Date());

        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/auditFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核退回(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/rebackAuditFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackAuditFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/rebackAuditFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("0");

        String remark = pageData.getString("remark");
        editFinanceBill.setRemark(remark);
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/rebackAuditFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 提交审核(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/submitFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/submitFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("1");
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/submitFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回提交审核(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/rebackSubmitFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/rebackSubmitFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("0");
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/rebackSubmitFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 批量添加-(采购)付款FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/addBatchFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addBatchFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/addBatchFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据类型Type为空或空字符串！");
            return model;
        }

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        for (Map<String, String> mapObject : mapList) {
            FinanceBill addFinanceBill = new FinanceBill();
            addFinanceBill.setCompanyId(companyId);
            addFinanceBill.setCuser(cuser);

            BigDecimal amount = BigDecimal.valueOf(0D);
            String amountStr = mapObject.get("amount");
            if (amountStr != null && amountStr.trim().length() > 0) {
                try {
                    amount = new BigDecimal(amountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            addFinanceBill.setAmount(amount);

            String remark = new String();
            if (mapObject.get("remark") != null) {
                remark = mapObject.get("remark").trim();
            }
            addFinanceBill.setRemark(remark);

            String customerId = mapObject.get("id");
            addFinanceBill.setCustomerId(customerId);

            String code = coderuleService.createCoderCdateOnShortYearByDate(
                    companyId,
                    "finance_bill_purchase",
                    "R",
                    Common.CODE_RULE_LENGTH_3);
            addFinanceBill.setCode(code);

            String period = DateFormat.date2String(new Date(), "yyyyMM");
            addFinanceBill.setPeriod(period);
            addFinanceBill.setType(type);

            //状态（0：待提交 1：待审核 2：已审核 -1：已取消）
            addFinanceBill.setState("0");
            if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                addFinanceBill.setState("1");
            }

            financeBillService.save(addFinanceBill);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/addBatchFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/cancelFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/cancelFinanceBillByPurchase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("-1");
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/cancelFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复(取消)(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/rebackCancelFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelProducePlan() throws Exception {
        logger.info("################/purchase/purchasePayment/rebackCancelFinanceBillByPurchase执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        //状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        editFinanceBill.setState("0");
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/rebackCancelFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除(采购)FinanceBill
     * @author 陈刚
     * @date 2020-04-01
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/deleteFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/deleteFinanceBillByPurchase执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        financeBillService.deleteById(id);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/deleteFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/purchase/purchasePayment/updateFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/updateFinanceBillByPurchase执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("单据id为空或空字符串！");
            return model;
        }

        String remark = new String();
        if (pageData.getString("remark") != null && pageData.getString("remark").trim().length() > 0) {
            remark = pageData.getString("remark").trim();
        }

        FinanceBill editFinanceBill = new FinanceBill();
        editFinanceBill.setId(id);
        editFinanceBill.setRemark(remark);

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");

        //状态（0：待提交 1：待审核 2：已审核 -1：已取消）
        editFinanceBill.setState("0");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            editFinanceBill.setState("1");
        }

        BigDecimal amount = BigDecimal.valueOf(0D);
        String amountStr = pageData.getString("amount");
        if (amountStr != null && amountStr.trim().length() > 0) {
            try {
                amount = new BigDecimal(amountStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        editFinanceBill.setAmount(amount);

        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/updateFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //(添加)扣款单:质量-采购检验
    @PostMapping("/purchase/purchasePayment/addFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/addFinanceBillByPurchase ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String signId = pageData.getString("signId");
        if (signId == null || signId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("签收单id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //供应商id
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        BigDecimal amount = BigDecimal.valueOf(0D);
        String amountStr = pageData.getString("amount");
        if (amountStr != null && amountStr.trim().length() > 0) {
            try {
                amount = new BigDecimal(amountStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        //sysCode 签收单号
        String sysCode = pageData.getString("sysCode");
        purchaseByFinanceBillService.addFinanceBillByPurchase(signId,
                companyId,
                supplierId,
                cuser,
                //单据类型 ( 0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购))
                "7",
                //state 状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                "1",
                null,
                amount,
                sysCode);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/addFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //结账:采购付款
    @PostMapping("/purchase/purchasePayment/updateFinanceHistoryByCheckOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateFinanceHistoryByCheckOut() throws Exception {
        logger.info("################/purchase/purchasePayment/updateFinanceHistoryByCheckOut ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        pageData.put("companyId", companyId);

        //系统时间(yyyymm)
        String sysMonthStr = DateFormat.date2String(new Date(), "yyyyMM");
        //查询付款期
        String queryPeriod = sysMonthStr;

        //paymentPeriod:当前付款期(yyyymm)
        String paymentPeriod = new String();
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        PurchaseCompanyPeriod companyPeriodDB = purchaseCompanyPeriodService.findPurchaseCompanyPeriod(findMap);
        if (companyPeriodDB != null && companyPeriodDB.getPaymentPeriod() != null) {
            paymentPeriod = companyPeriodDB.getPaymentPeriod();
            queryPeriod = paymentPeriod;
        }

        //验证当前付款期间(yyyyMM)+ 1个月 与系统时间(yyyyMM) 比较
        String msgStr = this.checkPaymentPeriodBySysDate(paymentPeriod, sysMonthStr);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //删除(企业id,付款期间)采购财务结账历史(vmes_finance_history)
        financeHistoryService.deleteFinanceHistoryByPurchase(companyId, queryPeriod);
        Map<String, String> periodMap = purchaseByFinanceBillService.findQueryPeriodMap(queryPeriod);
        if (periodMap != null && periodMap.size() > 0) {
            pageData.put("period", periodMap.get("period"));
            pageData.put("forePeriod", periodMap.get("forePeriod"));
            List<Map> varList = purchaseByFinanceBillService.findFinanceBillByPurchaseView(pageData, null);
            if (varList != null && varList.size() > 0) {
                purchaseByFinanceBillService.modifyCheckOutFinanceBillByPurchase(varList, queryPeriod);
                for (Map<String, Object> mapData : varList) {
                    FinanceHistory addDinanceHistory = (FinanceHistory) HttpUtils.pageData2Entity(mapData, new FinanceHistory());
                    addDinanceHistory.setId(null);
                    addDinanceHistory.setCompanyId(companyId);
                    addDinanceHistory.setCuser(cuser);
                    addDinanceHistory.setUuser(cuser);
                    financeHistoryService.save(addDinanceHistory);
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //删除(企业id,付款期间)采购付款结账当前期间(vmes_purchase_company_period)
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("company_id", companyId);
        purchaseCompanyPeriodService.deleteByColumnMap(columnMap);

        //更新当前期间(vmes_purchase_company_period:采购应付期间表)
        //当前期间(yyyymm) 加1个月
        String afterPaymentPeriodStr = DateFormat.getAddDay(queryPeriod, DateFormat.DEFAULT_MONTH, 1, "yyyyMM");
        Date afterPaymentPeriodDate = DateFormat.dateString2Date(afterPaymentPeriodStr+"01", "yyyyMMdd");

        PurchaseCompanyPeriod addCompanyPeriod = new PurchaseCompanyPeriod();
        addCompanyPeriod.setCompanyId(companyId);
        addCompanyPeriod.setCuser(cuser);
        addCompanyPeriod.setUuser(cuser);

        addCompanyPeriod.setInitialPeriod(afterPaymentPeriodStr);
        addCompanyPeriod.setInitialPeriodDate(afterPaymentPeriodDate);

        addCompanyPeriod.setPaymentPeriod(afterPaymentPeriodStr);
        addCompanyPeriod.setPaymentPeriodDate(afterPaymentPeriodDate);

        purchaseCompanyPeriodService.save(addCompanyPeriod);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/updateFinanceHistoryByCheckOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //反结账:采购付款
    @PostMapping("/purchase/purchasePayment/updateFinanceHistoryByUnCheckOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateFinanceHistoryByUnCheckOut() throws Exception {
        logger.info("################/purchase/purchasePayment/updateFinanceHistoryByUnCheckOut ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //系统时间(yyyymm)
        String sysMonthStr = DateFormat.date2String(new Date(), "yyyyMM");
        //查询付款期
        String queryPeriod = sysMonthStr;

        //paymentPeriod:当前付款期(yyyymm)
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        PurchaseCompanyPeriod companyPeriodDB = purchaseCompanyPeriodService.findPurchaseCompanyPeriod(findMap);
        if (companyPeriodDB != null && companyPeriodDB.getPaymentPeriod() != null) {
            queryPeriod = companyPeriodDB.getPaymentPeriod();
        }

        //删除(企业id,付款期间)采购财务结账历史(vmes_finance_history)
        financeHistoryService.deleteFinanceHistoryByPurchase(companyId, queryPeriod);

        //删除(企业id,付款期间)采购付款结账当前期间(vmes_purchase_company_period)
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("company_id", companyId);
        purchaseCompanyPeriodService.deleteByColumnMap(columnMap);

        //更新当前期间(vmes_purchase_company_period:采购应付期间表)
        //当前期间(yyyymm) 减1个月
        String frontPaymentPeriodStr = DateFormat.getAddDay(queryPeriod, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
        Date frontPaymentPeriodDate = DateFormat.dateString2Date(frontPaymentPeriodStr+"01", "yyyyMMdd");
        PurchaseCompanyPeriod addCompanyPeriod = new PurchaseCompanyPeriod();
        addCompanyPeriod.setCompanyId(companyId);
        addCompanyPeriod.setCuser(cuser);
        addCompanyPeriod.setUuser(cuser);

        addCompanyPeriod.setInitialPeriod(frontPaymentPeriodStr);
        addCompanyPeriod.setInitialPeriodDate(frontPaymentPeriodDate);

        addCompanyPeriod.setPaymentPeriod(frontPaymentPeriodStr);
        addCompanyPeriod.setPaymentPeriodDate(frontPaymentPeriodDate);

        purchaseCompanyPeriodService.save(addCompanyPeriod);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/updateFinanceHistoryByUnCheckOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 验证当前付款期间(yyyyMM)+ 1个月 与系统时间(yyyyMM) 比较
     *
     * @param paymentPeriod
     * @param sysMonth
     * @return
     */
    private String checkPaymentPeriodBySysDate(String paymentPeriod, String sysMonth) throws ParseException {
        String msgStr = new String();

        long sysMonthLong = 0L;
        if (sysMonth != null && sysMonth.trim().length() > 0) {
            Date sysMonthDate = DateFormat.dateString2Date(sysMonth, "yyyyMM");
            if (sysMonthDate != null) {
                sysMonthLong = sysMonthDate.getTime();
            }
        }

        long paymentPeriodLong = 0L;
        if (paymentPeriod != null && paymentPeriod.trim().length() > 0) {

            //当前期间(yyyymm) 加1个月
            String paymentPeriodStr = DateFormat.getAddDay(paymentPeriod, DateFormat.DEFAULT_MONTH, 1, "yyyyMM");
            Date paymentPeriodDate = DateFormat.dateString2Date(paymentPeriodStr, "yyyyMM");

            if (paymentPeriodDate != null) {
                paymentPeriodLong = paymentPeriodDate.getTime();
            }

            if (sysMonthLong != 0L
                && paymentPeriodLong != 0L
                && (sysMonthLong < paymentPeriodLong)
            ) {
                String msgTemp = "结账期间({0})不可大于当前自然月！";
                msgStr = MessageFormat.format(msgTemp, paymentPeriodStr);
            }
        }

        return msgStr;
    }
}
