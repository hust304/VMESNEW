package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.MobileWarehouseMoveService;
import com.xy.vmes.service.WarehouseMoveDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseMoveController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseMoveController.class);
    @Autowired
    private MobileWarehouseMoveService mobileWarehouseMoveService;

    // 获得移库任务详细信息
    @PostMapping("/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId")
    //@GetMapping("/mobileWarehouseMove/findWarehouseMoveByDetailId")
    public ResultModel findWarehouseMoveByDetailId()  throws Exception {

        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.findWarehouseMove(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }



    @PostMapping("/mobile/mobileWarehouseMove/addWarehouseMoveExecute")
    @Transactional
    public ResultModel addWarehouseMoveExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseMove/addWarehouseMoveExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.addWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/addWarehouseMoveExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail")
    @Transactional
    public ResultModel rebackWarehouseMoveDetail() throws Exception {
        logger.info("################/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.rebackWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
