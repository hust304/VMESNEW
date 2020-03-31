package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseByFinanceBillService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
