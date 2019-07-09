package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.SaleOrderDetailByInvoiceService;
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
 * 说明：查询订单明细(开票管理-勾选订单)
 * @author 陈刚
 * @date 2019-01-13
 */
@RestController
@Slf4j
public class SaleOrderDetailByInvoiceController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderDetailByInvoiceController.class);

    @Autowired
    private SaleOrderDetailByInvoiceService orderDetailByInvoiceService;


    /**
     * 订单明细列表(开票管理-勾选订单)
     * @author 陈刚
     * @date 2019-01-13
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetailByInvoice")
    public ResultModel listPageOrderDetailByInvoice() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = orderDetailByInvoiceService.listPageOrderDetailByInvoice(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
