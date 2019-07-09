package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleOrderDetailQueryByDeliveService;
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
 * 说明：订单明细查询汇总 Controller
 * (先计价)销售-发货管理-生成发货单-(订单明细勾选后界面)
 *
 * @author 陈刚
 * @date 2018-12-29
 */
@RestController
@Slf4j
public class SaleOrderDetailQueryByDeliverController {private Logger logger = LoggerFactory.getLogger(SaleOrderDetailQueryByDeliverController.class);

    @Autowired
    private SaleOrderDetailQueryByDeliveService orderDetailQueryByDeliveService;


    @PostMapping("/sale/saleOrderDetailQueryByDeliver/listPageOrderDetailQueryByDeliver")
    public ResultModel listPageOrderDetailQueryByDeliver() throws Exception {
        logger.info("################/sale/saleOrderDetailQueryByDeliver/listPageOrderDetailQueryByDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderDetailQueryByDeliveService.listPageOrderDetailQueryByDeliver(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetailQueryByDeliver/listPageOrderDetailQueryByDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
