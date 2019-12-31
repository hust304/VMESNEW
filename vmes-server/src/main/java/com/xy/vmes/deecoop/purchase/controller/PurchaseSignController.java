package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseSignService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private PurchaseSignService purchaseSignService;

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/listPagePurchaseSign")
    public ResultModel listPagePurchaseSign() throws Exception {
        logger.info("################/purchase/purchaseSign/listPagePurchaseSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseSignService.listPagePurchaseSign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/listPagePurchaseSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



