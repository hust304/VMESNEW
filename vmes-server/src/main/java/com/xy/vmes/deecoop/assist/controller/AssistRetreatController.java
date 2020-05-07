package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistRetreatService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_assist_retreat:外协退货单Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistRetreatController {
    private Logger logger = LoggerFactory.getLogger(AssistRetreatController.class);

    @Autowired
    private AssistRetreatService assistRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistRetreat/listPageAssistRetreat")
    public ResultModel listPageAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistRetreatService.listPageAssistRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



