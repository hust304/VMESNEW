package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.service.ProducePlanService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_produce_plan:生产计划Controller
* @author 陈刚 自动生成
* @date 2020-02-26
*/
@RestController
@Slf4j
public class ProducePlanController {
    private Logger logger = LoggerFactory.getLogger(ProducePlanController.class);

    @Autowired
    private ProducePlanService producePlanService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-02-26
    */
    @PostMapping("/produce/producePlan/listPageProducePlan")
    public ResultModel listPageProducePlan() throws Exception {
        logger.info("################/produce/producePlan/listPageProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/listPageProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/addProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addProducePlan() throws Exception {
        logger.info("################/produce/producePlan/addProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/addProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/submitProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitProducePlan() throws Exception {
        logger.info("################/produce/producePlan/submitProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/submitProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回提交
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/rebackSubmitProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitProducePlan() throws Exception {
        logger.info("################/produce/producePlan/rebackSubmitProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/rebackSubmitProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/cancelProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelProducePlan() throws Exception {
        logger.info("################/produce/producePlan/cancelProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/cancelProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/deleteProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteProducePlan() throws Exception {
        logger.info("################/produce/producePlan/deleteProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/deleteProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/updateProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateProducePlan() throws Exception {
        logger.info("################/produce/producePlan/updateProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/updateProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}

