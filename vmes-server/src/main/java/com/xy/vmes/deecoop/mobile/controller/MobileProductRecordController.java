package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.MobileProductRecordService;
import com.xy.vmes.service.MobileProductService;
import com.xy.vmes.service.ProductService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileProductRecordController {
    private Logger logger = LoggerFactory.getLogger(MobileProductRecordController.class);

    @Autowired
    private MobileProductRecordService mobileProductRecordService;

    @PostMapping("/mobile/mobileProductRecord/listPageProductRecords")
    public ResultModel listPageProducts() throws Exception {
        logger.info("################/mobile/mobileProductRecord/listPageProductRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = mobileProductRecordService.listPageProductRecords(pd,pg);
        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/listPageProductRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
