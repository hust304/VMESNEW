package com.xy.vmes.deecoop.mobile.controller;


import com.xy.vmes.service.MobileWarehouseService;
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
 * 说明：(手机端)vmes_warehouse:仓库货位表Controller
 */
@RestController
@Slf4j
public class MobileWarehouseController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseController.class);

    @Autowired
    private MobileWarehouseService mobileWarehouseService;

    @PostMapping("/mobile/mobileWarehouse/findEmployeeInfo")
    public ResultModel findEmployeeInfo()  throws Exception {
        logger.info("################/mobile/mobileWarehouseService/findEmployeeInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseService.findEmployeeInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseService/findEmployeeInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

}
