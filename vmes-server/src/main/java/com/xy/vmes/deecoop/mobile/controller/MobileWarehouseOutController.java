package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MobileWarehouseOutController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseOutController.class);
    @Autowired
    private MobileWarehouseOutService mobileWarehouseOutService;

    @PostMapping("/mobileWarehouseOut/findWarehouseOutByDetailId")
    //@GetMapping("/mobileWarehouseOut/findWarehouseOutByDetailId")
    public ResultModel findWarehouseOutByDetailId()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehouseOutByDetailId(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    @PostMapping("/mobileWarehouseOut/findWarehousePathByQrcode")
    public ResultModel findWarehousePathByQrcode()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehousePathByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehousePathByQrcode(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehousePathByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobileWarehouseOut/listWarehousePathByProduct")
    public ResultModel listWarehousePathByProduct()  throws Exception {
        logger.info("################/mobileWarehouseOut/listWarehousePathByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.listWarehousePathByProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/listWarehousePathByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobileWarehouseOut/listWarehouseCodeByWarehouseId")
    public ResultModel listWarehouseCodeByWarehouseId()  throws Exception {
        logger.info("################/mobileWarehouseOut/listWarehouseCodeByWarehouseId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.listWarehouseCodeByWarehouseId(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/listWarehouseCodeByWarehouseId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobileWarehouseOut/findWarehouseCodeByQrcode")
    public ResultModel findWarehouseCodeByQrcode()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehouseCodeByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehouseCodeByQrcode(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehouseCodeByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    @PostMapping("/mobileWarehouseOut/addWarehouseOutExecute")
    @Transactional
    public ResultModel addWarehouseOutExecute() throws Exception {
        logger.info("################/mobileWarehouseOut/addWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.addWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/addWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    @PostMapping("/mobileWarehouseOut/rebackWarehouseOutDetail")
    @Transactional
    public ResultModel rebackWarehouseOutDetail() throws Exception {
        logger.info("################/mobileWarehouseOut/rebackWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.rebackWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/rebackWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
