package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
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
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseInController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);
    @Autowired
    private MobileWarehouseInService mobileWarehouseInService;

    //获得入库任务详细信息
    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInByDetailId")
    public ResultModel findWarehouseInByDetailId()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.findWarehouseIn(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    /**
     * 手机端
     * 新增入库单明细执行
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.addWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行___手机端复用
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.rebackWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 通过Pid查找下级库位信息
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/listWarehouseNodeByPid")
    public ResultModel listWarehouseNodeByPid()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.listWarehouseNodeByPid(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
