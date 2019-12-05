package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleWaresRetreatService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_sale_wares_retreat:无订单退货单Controller
* @author 陈刚 自动生成
* @date 2019-12-05
*/
@RestController
@Slf4j
public class SaleWaresRetreatController {
    private Logger logger = LoggerFactory.getLogger(SaleWaresRetreatController.class);

    @Autowired
    private SaleWaresRetreatService saleWaresRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-12-05
    */
    @PostMapping("/sale/saleWaresRetreat/listPageSaleWaresRetreat")
    public ResultModel listPageSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/listPageSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.listPageSaleWaresRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/listPageSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



