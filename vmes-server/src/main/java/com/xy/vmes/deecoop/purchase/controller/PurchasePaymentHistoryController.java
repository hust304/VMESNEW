package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePaymentHistoryService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_purchase_payment_history:供应商账期汇总Controller
* @author 陈刚 自动生成
* @date 2019-03-11
*/
@RestController
@Slf4j
public class PurchasePaymentHistoryController {
    private Logger logger = LoggerFactory.getLogger(PurchasePaymentHistoryController.class);

    @Autowired
    private PurchasePaymentHistoryService purchasePaymentHistoryService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-11
    */
    @PostMapping("/purchase/purchasePaymentHistory/listPagePurchasePaymentHistory")
    public ResultModel listPagePurchasePaymentHistory() throws Exception {
        logger.info("################/purchase/purchasePaymentHistory/listPagePurchasePaymentHistory 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePaymentHistoryService.listPagePurchasePaymentHistory(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentHistory/listPagePurchasePaymentHistory 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



