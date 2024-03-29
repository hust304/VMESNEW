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

    /**
     * 获取(质量-采购检验)采购签收明细检验
     * 菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
     *
     * 模块菜单路径:质量-采购检验
     *
     * @author 陈刚
     * @date 2020-01-13
     */
    @PostMapping("/purchase/purchaseSignDetail/listPagePurchaseSignDetailByQualityExecute")
    public ResultModel listPagePurchaseSignDetailByQualityExecute() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByQualityExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseSignDetailService.listPagePurchaseSignDetailByQualityExecute(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

    //采购签收明细-检验执行
    @PostMapping("/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute")
    public ResultModel purchaseSignDetailByQualityExecute() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseSignDetailService.purchaseSignDetailByQualityExecute(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //采购签收明细-免检
    @PostMapping("/purchase/purchaseSignDetail/updateSignDetailByQuality")
    public ResultModel updateSignDetailByQuality() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/updateSignDetailByQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseSignDetailService.updateSignDetailByQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/updateSignDetailByQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



