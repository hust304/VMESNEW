package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistDiscardService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_discard:外协报废单Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistDiscardController {
    private Logger logger = LoggerFactory.getLogger(AssistDiscardController.class);

    @Autowired
    private AssistDiscardService AssistDiscardService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistDiscard/listPageassistDiscard")
    public ResultModel listPageassistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/listPageassistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = AssistDiscardService.listPageassistDiscard(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/listPageassistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



