package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleWaresRetreatDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_sale_wares_retreat_detail:无订单退货明细Controller
* @author 陈刚 自动生成
* @date 2019-12-05
*/
@RestController
@Slf4j
public class SaleWaresRetreatDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleWaresRetreatDetailController.class);

    @Autowired
    private SaleWaresRetreatDetailService saleWaresRetreatDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-12-05
    */
    @PostMapping("/sale/saleWaresRetreatDetail/listPageSaleWaresRetreatDetail")
    public ResultModel listPageSaleWaresRetreatDetail() throws Exception {
        logger.info("################/sale/saleWaresRetreatDetail/listPageSaleWaresRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatDetailService.listPageSaleWaresRetreatDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreatDetail/listPageSaleWaresRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



