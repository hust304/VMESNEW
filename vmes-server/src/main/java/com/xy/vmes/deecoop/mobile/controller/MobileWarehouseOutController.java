package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseOutController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseOutController.class);
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @PostMapping("/mobileWarehouseOut/listPageWarehouseOutDetailByDetail")
    //@GetMapping("/mobileWarehouseOut/listPageWarehouseOutDetailByDetail")
    public ResultModel listPageWarehouseOutDetailByDetail()  throws Exception {
        logger.info("################/mobileWarehouseOut/listPageWarehouseOutDetailByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varList = warehouseOutDetailService.findListPageWarehouseOutDetail(pd,pg);


        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/listPageWarehouseOutDetailByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

    @PostMapping("/mobileWarehouseOut/getWarehouseOutWarehouseByDetail")
    //@GetMapping("/mobileWarehouseOut/getWarehouseOutWarehouseByDetail")
    public ResultModel getWarehouseOutWarehouseByDetail()  throws Exception {
        logger.info("################/mobileWarehouseOut/getWarehouseOutWarehouseByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();






        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/getWarehouseOutWarehouseByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}
