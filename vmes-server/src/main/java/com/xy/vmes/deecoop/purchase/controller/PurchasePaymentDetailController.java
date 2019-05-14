package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePaymentDetailService;
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
* 说明：vmes_purchase_payment_detail:采购订单付款单明细Controller
* @author 陈刚 自动生成
* @date 2019-05-14
*/
@RestController
@Slf4j
public class PurchasePaymentDetailController {
    private Logger logger = LoggerFactory.getLogger(PurchasePaymentDetailController.class);

    @Autowired
    private PurchasePaymentDetailService purchasePaymentDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-05-14
    */
    @PostMapping("/purchase/purchasePaymentDetail/listPagePurchasePaymentDetails")
    public ResultModel listPagePurchasePaymentDetails()  throws Exception {
        logger.info("################/purchase/purchasePaymentDetail/listPagePurchasePaymentDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePaymentDetailService.listPagePurchasePaymentDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentDetail/listPagePurchasePaymentDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



