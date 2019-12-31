package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseSignDetailOnInService;
import com.xy.vmes.service.PurchaseSignDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_purchase_sign_detail:采购签收明细Controller
* @author 刘威 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchaseSignDetailController {
    private Logger logger = LoggerFactory.getLogger(PurchaseSignDetailController.class);

    @Autowired
    private PurchaseSignDetailService purchaseSignDetailService;
    @Autowired
    private PurchaseSignDetailOnInService signDetailOnInService;

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/listPagePurchaseSignDetail")
    public ResultModel listPagePurchaseSignDetail() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseSignDetailService.listPagePurchaseSignDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取采购签收单明细-根据入库单id
    @PostMapping("/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn")
    public ResultModel listPagePurchaseSignDetailByIn() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = signDetailOnInService.listPagePurchaseSignDetailByIn(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



