package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.WarehouseInDetailService;
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
public class MobileWarehouseInController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @PostMapping("/mobileWarehouseIn/listPageWarehouseInDetailByDetail")
    //@GetMapping(" /mobileWarehouseIn/listPageWarehouseInDetailByDetail")
    public ResultModel listPageWarehouseInDetailByDetail()  throws Exception {
        logger.info("################  /mobileWarehouseIn/listPageWarehouseInDetailByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varList = warehouseInDetailService.findListPageWarehouseInDetail(pd,pg);


        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################ /mobileWarehouseIn/listPageWarehouseInDetailByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}
