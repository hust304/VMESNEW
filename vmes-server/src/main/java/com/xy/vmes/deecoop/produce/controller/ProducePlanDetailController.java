package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.service.ProducePlanDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_produce_plan_detail:生产计划明细Controller
* @author 陈刚 自动生成
* @date 2020-02-27
*/
@RestController
@Slf4j
public class ProducePlanDetailController {
    private Logger logger = LoggerFactory.getLogger(ProducePlanDetailController.class);

    @Autowired
    private ProducePlanDetailService producePlanDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-02-27
    */
    @PostMapping("/produce/producePlanDetail/listPageProducePlanDetail")
    public ResultModel listPageProducePlanDetail() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageProducePlanDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



