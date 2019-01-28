package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByInvoiceService;
import com.xy.vmes.service.SaleOrderByInvoiceService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：查询订单(开票管理-勾选订单)
 * @author 陈刚
 * @date 2019-01-13
 */
@RestController
@Slf4j
public class SaleOrderByInvoiceController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderByInvoiceController.class);

    @Autowired
    private SaleOrderByInvoiceService orderByInvoiceService;



    @PostMapping("/sale/saleOrder/listPageOrderByInvoice")
    public ResultModel listPageOrderByInvoice() throws Exception {
        logger.info("################/sale/saleOrder/listPageOrderByInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = orderByInvoiceService.listPageOrderByInvoice(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/listPageOrderByInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
