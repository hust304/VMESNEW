package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseQualityDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_purchase_quality_detail:采购质检项明细Controller
* @author 陈刚 自动生成
* @date 2020-01-09
*/
@RestController
@Slf4j
public class PurchaseQualityDetailController {
    private Logger logger = LoggerFactory.getLogger(PurchaseQualityDetailController.class);

    @Autowired
    private PurchaseQualityDetailService purchaseQualityDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-01-09
    */
    @PostMapping("/purchase/purchaseQualityDetail/listPagePurchaseQualityDetail")
    public ResultModel listPagePurchaseQualityDetail() throws Exception {
        logger.info("################/purchase/purchaseQualityDetail/listPagePurchaseQualityDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseQualityDetailService.listPagePurchaseQualityDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseQualityDetail/listPagePurchaseQualityDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 获取(质量-采购检验)采购签收明细检验项目
//     * 菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
//     * @author 陈刚
//     * @date 2020-01-09
//     */
//    @PostMapping("/purchase/purchaseQualityDetail/listPagePurchaseQualityDetailByQualityExecute")
//    public ResultModel listPagePurchaseQualityDetailByQualityExecute() throws Exception {
//        logger.info("################/purchase/purchaseQualityDetail/listPagePurchaseQualityDetailByQualityExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        ResultModel model = purchaseQualityDetailService.listPagePurchaseQualityDetailByQualityExecute(pd);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/purchase/purchaseQualityDetail/listPagePurchaseQualityDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

}



