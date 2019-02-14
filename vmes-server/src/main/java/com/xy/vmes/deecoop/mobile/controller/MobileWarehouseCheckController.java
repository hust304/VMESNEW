package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
import java.util.*;

@RestController
@Slf4j
public class MobileWarehouseCheckController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseCheckController.class);
    @Autowired
    private MobileWarehouseCheckService mobileWarehouseCheckService;


    //获得盘点任务详细信息
    @PostMapping("/mobile/mobileWarehouseCheck/listWarehouseCheckByAduited")
    public ResultModel listWarehouseCheckByAduited()  throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/listWarehouseCheckByAduited 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = mobileWarehouseCheckService.listWarehouseCheckByAduited(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/listWarehouseCheckByAduited  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获得盘点任务详细信息
    @PostMapping("/mobile/mobileWarehouseCheck/listWarehouseCheckByAduiting")
    public ResultModel listWarehouseCheckByAduiting()  throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/listWarehouseCheckByAduiting 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = mobileWarehouseCheckService.listWarehouseCheckByAduiting(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/listWarehouseCheckByAduiting  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获得盘点任务详细信息
    @PostMapping("/mobile/mobileWarehouseCheck/findWarehouseCheckById")
    //@GetMapping("/mobileWarehouseCheck/findWarehouseCheckByDetailId")
    public ResultModel findWarehouseCheckByDetailId()  throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckByDetailId执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.findWarehouseCheck(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    //获得盘点任务详细信息
    @PostMapping("/mobile/mobileWarehouseCheck/findWarehouseCheckById")
    public ResultModel findWarehouseCheckById()  throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.findWarehouseCheckById(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckById  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 新增盘点单明细执行_____复用
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseCheck/addWarehouseCheckExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheckExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.addWarehouseCheckExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增盘点单明细执行_____复用
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseCheck/rebackWarehouseCheckByDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseCheckByDetail() throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.rebackWarehouseCheckByDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseCheck/auditDisagreeWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeWarehouseCheck() throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/auditDisagreeWarehouseCheck ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.auditDisagreeWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/auditDisagreeWarehouseCheck 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseCheck/auditPassWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassWarehouseCheck() throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/auditPassWarehouseCheck ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseCheckService.auditPassWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/auditPassWarehouseCheck 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
