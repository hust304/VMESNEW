package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByQueryService;
import com.xy.vmes.service.SaleOrderByQueryService;
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

@RestController
@Slf4j
public class SaleOrderQueryController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderQueryController.class);

    @Autowired
    private SaleOrderByQueryService saleOrderByQueryService;

    @PostMapping("/sale/saleOrderQuery/listPageSaleOrderQuery")
    public ResultModel listPageSaleOrderQuery() throws Exception {
        logger.info("################/sale/saleOrderQuery/listPageSaleOrderQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleOrderByQueryService.listPageSaleOrderQuery(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderQuery/listPageSaleOrderQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
