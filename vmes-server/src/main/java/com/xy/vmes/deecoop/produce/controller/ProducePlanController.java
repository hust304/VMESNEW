package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.service.ProducePlanService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


}

