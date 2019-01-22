package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.xy.vmes.service.MobileProductService;
import com.xy.vmes.service.ProductService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class MobileProductController {
    private Logger logger = LoggerFactory.getLogger(MobileProductController.class);

    @Autowired
    private MobileProductService mobileProductService;

    @PostMapping("/mobile/mobileProduct/listPageProducts")
    public ResultModel listPageProducts() throws Exception {
        logger.info("################/mobile/mobileProduct/listPageProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        //List<Map> varMapList = new ArrayList();

        //List<Map> varList = productService.getDataListPage(pd,pg);
        List<Map> varList = mobileProductService.findListPageProduct(pd,pg);


        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProduct/listPageProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;


    }
}