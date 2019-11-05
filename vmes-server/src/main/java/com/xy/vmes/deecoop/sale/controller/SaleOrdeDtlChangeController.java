package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleOrdeDtlChangeService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_saleOrdeDtl_change:订单明细变更记录表Controller
* @author 陈刚 自动生成
* @date 2019-11-05
*/
@RestController
@Slf4j
public class SaleOrdeDtlChangeController {
    private Logger logger = LoggerFactory.getLogger(SaleOrdeDtlChangeController.class);

    @Autowired
    private SaleOrdeDtlChangeService saleOrdeDtlChangeService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/sale/saleOrdeDtlChange/listPageSaleOrdeDtlChange")
    public ResultModel listPageSaleOrdeDtlChange() throws Exception {
        logger.info("################/sale/saleOrdeDtlChange/listPageSaleOrdeDtlChange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrdeDtlChangeService.listPageSaleOrdeDtlChange(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrdeDtlChange/listPageSaleOrdeDtlChange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



