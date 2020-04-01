package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.FinanceBillService;
import com.xy.vmes.service.PurchaseByFinanceBillService;
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
import java.util.Date;
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
     * 审核(采购)FinanceBill
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/auditFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/auditFinanceBillByPurchase 执行开始 ################# ");
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
        editFinanceBill.setState("2");
        financeBillService.update(editFinanceBill);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/auditFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核退回(采购)FinanceBill
     * @author 陈刚
     * @date 2020-02-26
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
     * @date 2020-02-26
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
     * @date 2020-02-26
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
     * 添加(采购)FinanceBill
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePayment/addFinanceBillByPurchase")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addFinanceBillByPurchase() throws Exception {
        logger.info("################/purchase/purchasePayment/addFinanceBillByPurchase 执行开始 ################# ");
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
        logger.info("################/purchase/purchasePayment/addFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消(采购)FinanceBill
     * @author 陈刚
     * @date 2020-02-26
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
     * @date 2020-02-26
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
     * @date 2020-02-26
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePayment/updateFinanceBillByPurchase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
