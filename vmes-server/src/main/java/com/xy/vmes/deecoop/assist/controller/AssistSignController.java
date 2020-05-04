package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistSignService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_sign:外协签收单Controller
* @author 陈刚 自动生成
* @date 2020-05-04
*/
@RestController
@Slf4j
public class AssistSignController {
    private Logger logger = LoggerFactory.getLogger(AssistSignController.class);

    @Autowired
    private AssistSignService assistSignService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-04
    */
    @PostMapping("/assist/assistSign/listPageAssistSign")
    public ResultModel listPageAssistSign() throws Exception {
        logger.info("################/assist/assistSign/listPageAssistSign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignService.listPageAssistSign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSign/listPageAssistSign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



