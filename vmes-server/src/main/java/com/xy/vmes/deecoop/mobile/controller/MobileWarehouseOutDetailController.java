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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseOutDetailController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseOutDetailController.class);
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    //@PostMapping("/MobileWarehouseOutDetailController/listPageWarehouseOutDetailByDetail")
    @GetMapping("/MobileWarehouseOutDetailController/listPageWarehouseOutDetailByDetail")
    public ResultModel listPageWarehouseOutDetailByDetail()  throws Exception {
        logger.info("################/MobileWarehouseOutDetailController/listPageWarehouseOutDetailByDetail 执行开始 ################# ");
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
        logger.info("################/MobileWarehouseOutDetailController/listPageWarehouseOutDetailByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}
