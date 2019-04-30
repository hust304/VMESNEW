package com.xy.vmes.deecoop.timer.purchase;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.xy.vmes.entity.PurchasePaymentBuild;
import com.xy.vmes.entity.PurchasePaymentHistory;
import com.xy.vmes.service.PurchaseCompanyPeriodService;
import com.xy.vmes.service.PurchaseOrderService;
import com.xy.vmes.service.PurchasePaymentBuildService;
import com.xy.vmes.service.PurchasePaymentHistoryService;
import com.yvan.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.*;

/**
 * 采购-采购应付款-定时任务
 *
 * 秒 分 时 月中的某天 月 每周的某天
 * Seconds Minutes Hours DayofMonth Month DayofWeek
 *
 * 每天12点30分执行        (0 30 12 * * ?)
 * 每月1号凌晨1点执行       (0 0 1 1 * ?)
 *
 */
@Component
@EnableScheduling
public class PurchasePaymentTask {
    private Logger logger = LoggerFactory.getLogger(PurchasePaymentTask.class);

    //PurchasePaymentTask.initTimer(yyyy-MM-dd HH:mm:ss):开始执行
    private String begin_logger_msg_temp = "{0}.{1}({2}):{3}";
    //PurchasePaymentTask.initTimer(yyyy-MM-dd HH:mm:ss):结束执行:总耗时()毫秒
    private String end_logger_msg_temp = "{0}.{1}({2}):{3}:总耗时({4})毫秒";


    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseCompanyPeriodService purchaseCompanyPeriodService;
    @Autowired
    private PurchasePaymentBuildService purchasePaymentBuildService;
    @Autowired
    private PurchasePaymentHistoryService purchasePaymentHistoryService;

    /**
     * 采购-采购应付款-定时任务
     * 每月1号凌晨1点执行：(0 0 1 1 * ?)
     *
     * 1. 查询系统所有企业-是否采购企业付款期设定-未设定系统设定默认值
     * 2. 查询系统所有企业-该企业下所有供应商-是否设定供应商付款初期值-未设定系统设定默认值
     *      获取汇总日期(yyyyMM)-当前系统日期前一个月
     *      查询系统所有企业-该企业下所有供应商-(当前系统日期前一个月)是否有采购订单
     *      是否设定供应商付款初期值-未设定系统设定默认值
     * 3. 系统所有企业-该企业下所有供应商-汇总查询(当前系统日期前一个月)-保存添加供应商付款汇总(vmes_purchase_payment_history)
     *
     */
    @Scheduled(cron = "0 0 1 1 * ?")
    public void initTimer() {
        Long startTime = System.currentTimeMillis();
        String dateTimeStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT);
        String begin_logger_msg = MessageFormat.format(begin_logger_msg_temp,
                "PurchasePaymentTask",
                "initTimer",
                dateTimeStr,
                "开始执行");
        logger.info(begin_logger_msg);

        //1. 查询系统所有企业-是否采购企业付款期设定-未设定系统设定默认值
        List<Map> mapList = null;
        try {
            PageData findMap = new PageData();
            mapList = purchaseCompanyPeriodService.getDataListPage(findMap);
        } catch (Exception e){
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {
            String end_logger_msg = this.endLoggerMsg(startTime);
            logger.info(end_logger_msg);
            return;
        }

        //获取系统日期 (yyyyMM)
        String initialPeriodDate_str = DateFormat.date2String(new Date(), "yyyyMM");
        Date initialPeriodDate = DateFormat.dateString2Date((initialPeriodDate_str + "01"), "yyyyMMdd");

        //设定采购企业付款期 (vmes_purchase_company_period)
        Map<String, String> companyMap = new HashMap<String, String>();
        for (Map mapObj : mapList) {
            String companyId = (String)mapObj.get("companyId");
            companyMap.put(companyId, companyId);

            //isBuild Y:已设定 N:未设定
            String isBuild = (String)mapObj.get("isBuild");
            if (isBuild != null && "N".equals(isBuild.trim())) {
                PurchaseCompanyPeriod companyPeriod = new PurchaseCompanyPeriod();
                companyPeriod.setCompanyId(companyId);
                companyPeriod.setInitialPeriod(initialPeriodDate_str);
                companyPeriod.setInitialPeriodDate(initialPeriodDate);
                companyPeriod.setPaymentPeriod(companyPeriod.getInitialPeriod());
                companyPeriod.setPaymentPeriodDate(companyPeriod.getInitialPeriodDate());
                companyPeriod.setCuser("admin");
                try {
                    purchaseCompanyPeriodService.save(companyPeriod);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("companyMap.size():" + companyMap.size());

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //2. 查询系统所有企业-该企业下所有供应商-是否设定供应商付款初期值-未设定系统设定默认值
        //获取系统日期 (yyyyMM)
        String dateMonth = DateFormat.date2String(new Date(), "yyyyMM");
        String beforeMonth = dateMonth;
        //获取汇总日期(yyyyMM)-当前系统日期前一个月
        try {
            beforeMonth = DateFormat.getAddDay(dateMonth, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String, String> companyMapByPurchaseOrder = new HashMap<String, String>();
        for (Iterator iterator = companyMap.keySet().iterator(); iterator.hasNext();) {
            String companyId = (String) iterator.next();

            //查询系统所有企业-该企业下所有供应商-(当前系统日期前一个月)是否有采购订单
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("dateByNow", beforeMonth);
            List<Map<String, Object>> mapObjectList = purchaseOrderService.findPurchaseOrderBySupplier(findMap);
            //查询系统所有企业-该企业下所有供应商-(当前系统日期前一个月)无采购订单--无需设置供应商付款初期值
            if (mapObjectList == null || mapObjectList.size() == 0) {continue;}

            companyMapByPurchaseOrder.put(companyId, companyId);
            Map<String, String> supplierMap = new HashMap<String, String>();
            for (Map<String, Object> mapObj : mapObjectList) {
                String supplierId = (String)mapObj.get("supplierId");
                BigDecimal amount = (BigDecimal)mapObj.get("amount");
                if (supplierId != null && supplierId.trim().length() > 0
                        && amount != null && amount.doubleValue() > 0
                ) {
                    supplierMap.put(supplierId, supplierId);
                }
            }

            StringBuffer supplierIdBuf = new StringBuffer();
            for (Iterator iterator_1 = supplierMap.keySet().iterator(); iterator_1.hasNext();) {
                String supplierId = (String) iterator_1.next();
                supplierIdBuf.append(supplierId).append(",");
            }

            //查询系统所有企业-该企业下所有供应商-是否设定供应商付款初期值-未设定系统设定默认值
            List<Map> supplierMapList = new ArrayList<Map>();
            try {
                findMap = new PageData();
                findMap.put("currentCompanyId", companyId);
                if (supplierIdBuf.toString().trim().length() > 0) {
                    String supplierIdsByNotIn = supplierIdBuf.toString().trim();
                    supplierIdsByNotIn = StringUtil.stringTrimSpace(supplierIdsByNotIn);
                    supplierIdsByNotIn = "'" + supplierIdsByNotIn.replace(",", "','") + "'";
                    findMap.put("supplierIds", supplierIdsByNotIn);
                }
                supplierMapList = purchasePaymentBuildService.getDataListPage(findMap);
            } catch (Exception e){
                e.printStackTrace();
            }

            for (Map mapObj : supplierMapList) {
                //supplierId 供应商id
                String supplierId = (String)mapObj.get("supplierId");

                //isBuild Y:已设定 N:未设定
                String isBuild = (String)mapObj.get("isBuild");
                if (isBuild != null && "N".equals(isBuild.trim())) {
                    PurchasePaymentBuild supplierPaymentBuild = new PurchasePaymentBuild();
                    supplierPaymentBuild.setSupplierId(supplierId);
                    supplierPaymentBuild.setPaymentPeriod(initialPeriodDate_str);
                    supplierPaymentBuild.setPaymentPeriodDate(initialPeriodDate);
                    supplierPaymentBuild.setBeginPlus(BigDecimal.valueOf(0D));
                    supplierPaymentBuild.setBeginMinus(BigDecimal.valueOf(0D));
                    supplierPaymentBuild.setBeginValue(BigDecimal.valueOf(0D));
                    supplierPaymentBuild.setCuser("admin");
                    try {
                        purchasePaymentBuildService.save(supplierPaymentBuild);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 系统所有企业-该企业下所有供应商-汇总查询(当前系统日期前一个月)-保存添加供应商付款汇总(vmes_purchase_payment_history)
        //System.out.println("companyMapByPurchaseOrder.size():" + companyMapByPurchaseOrder.size());
        for (Iterator iterator = companyMapByPurchaseOrder.keySet().iterator(); iterator.hasNext();) {
            String companyId = (String) iterator.next();

            List<Map> paymentHistoryList = new ArrayList<Map>();
            try {
                PageData findMap = new PageData();
                findMap.put("currentCompanyId", companyId);
                //系统日期 (yyyyMM)
                findMap.put("dateByNow", initialPeriodDate_str);
                //系统日期前一个月(yyyyMM)
                findMap.put("dateByBefore", beforeMonth);
                findMap.put("paymentPeriod", initialPeriodDate_str);
                paymentHistoryList = purchasePaymentHistoryService.findListPurchasePaymentHistoryByPaymentPeriod(findMap);
            } catch (Exception e){
                e.printStackTrace();
            }

            for (Map mapObj : paymentHistoryList) {
                //periodType 付款结转类型('paymentPeriod':当前付款期间 'history':结转历史数据)
                String periodType = (String)mapObj.get("periodType");
                if (periodType == null || "history".equals(periodType)) {continue;}

                PurchasePaymentHistory paymentHistory = new PurchasePaymentHistory();
                //supplierId 供应商ID
                String supplierId = (String)mapObj.get("supplierId");
                paymentHistory.setSupplierId(supplierId);
                //paymentPeriod 付款期(yyyymm)
                String paymentPeriod = (String)mapObj.get("paymentPeriod");
                paymentHistory.setPaymentPeriod(paymentPeriod);

                //beginPlus 应付款(期初)
                paymentHistory.setBeginPlus(BigDecimal.valueOf(0D));
                //beginMinus 预付款(期初)
                paymentHistory.setBeginMinus(BigDecimal.valueOf(0D));
                //beginValue 付款值(期初)
                paymentHistory.setBeginValue(BigDecimal.valueOf(0D));

                //isPaymentBuild 是否设定供应商付款初期值(vmes_purchase_payment_build)(Y:已设定 N:未设定)
                String isPaymentBuild = (String)mapObj.get("isPaymentBuild");
                if ("Y".equals(isPaymentBuild)) {
                    BigDecimal buildBeginValue = BigDecimal.valueOf(0D);
                    if (mapObj.get("buildBeginValue") != null) {
                        buildBeginValue = (BigDecimal)mapObj.get("buildBeginValue");
                        paymentHistory.setBeginValue(buildBeginValue);
                    }

                    if (buildBeginValue.doubleValue() > 0) {
                        //beginPlus 应付款(期初)
                        paymentHistory.setBeginPlus(buildBeginValue);
                    } else if (buildBeginValue.doubleValue() < 0) {
                        //beginMinus 预付款(期初)
                        buildBeginValue = BigDecimal.valueOf(buildBeginValue.doubleValue() * -1);
                        paymentHistory.setBeginMinus(buildBeginValue);
                    }
                }

                //nowOrderSum 采购订单金额(本期)
                paymentHistory.setNowOrderSum(BigDecimal.valueOf(0D));
                if (mapObj.get("nowOrderSum") != null) {
                    paymentHistory.setNowOrderSum((BigDecimal)mapObj.get("nowOrderSum"));
                }
                //nowPaymentSum 付款金额(本期)
                paymentHistory.setNowPaymentSum(BigDecimal.valueOf(0D));
                if (mapObj.get("nowPaymentSum") != null) {
                    paymentHistory.setNowPaymentSum((BigDecimal)mapObj.get("nowPaymentSum"));
                }

                //endPlus 应付款(期末)
                paymentHistory.setEndPlus(BigDecimal.valueOf(0D));
                //endMinus 预付款(期末)
                paymentHistory.setEndMinus(BigDecimal.valueOf(0D));
                //endValue 付款值(期末) := (本期)订单金额 - (本期)付款 + (初期)应付款-(初期)预付款
                BigDecimal endValue = BigDecimal.valueOf(paymentHistory.getNowOrderSum().doubleValue()
                            - paymentHistory.getNowPaymentSum().doubleValue()
                            + paymentHistory.getBeginValue().doubleValue()
                );
                //四舍五入到2位小数
                endValue = endValue.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                paymentHistory.setEndValue(endValue);

                if (paymentHistory.getEndValue().doubleValue() > 0) {
                    //endPlus 应付款(期末)
                    paymentHistory.setEndPlus(paymentHistory.getEndValue());
                } else if (paymentHistory.getEndValue().doubleValue() < 0) {
                    //endValue_Big = BigDecimal.valueOf(endValue_Big.doubleValue() * -1);
                    //endMinus 预付款(期末)
                    paymentHistory.setEndMinus(BigDecimal.valueOf(paymentHistory.getEndValue().doubleValue() * -1));
                }

                try {
                    String logger_msg_temp = "{{0}}:付款期({1}) 企业id({2}) 供应商id({3}) 采购付款结转完成";
                    String logger_msg = MessageFormat.format(logger_msg_temp,
                            "PurchasePaymentTask.initTimer",
                            paymentPeriod,
                            companyId,
                            supplierId);
                    logger.info(logger_msg);
                    purchasePaymentHistoryService.save(paymentHistory);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        String end_logger_msg = this.endLoggerMsg(startTime);
        logger.info(end_logger_msg);
    }

    ///////////////////////////////////////////////////////////////////////////////
    private String endLoggerMsg(Long startTime) {
        Long endTime = System.currentTimeMillis();
        String dateTimeStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT);
        return MessageFormat.format(end_logger_msg_temp,
                "PurchasePaymentTask",
                "initTimer",
                dateTimeStr,
                "结束执行",
                (endTime-startTime));
    }

}
