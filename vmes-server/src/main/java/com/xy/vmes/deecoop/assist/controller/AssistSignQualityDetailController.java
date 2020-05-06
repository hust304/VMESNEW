package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistSignQualityDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_sign_quality_detail:外协质检项明细Controller
* @author 陈刚 自动生成
* @date 2020-05-06
*/
@RestController
@Slf4j
public class AssistSignQualityDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistSignQualityDetailController.class);

    @Autowired
    private AssistSignQualityDetailService assistSignQualityDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-06
    */
    @PostMapping("/assist/assistSignQualityDetail/listPageAssistSignQualityDetail")
    public ResultModel listPageAssistSignQualityDetail() throws Exception {
        logger.info("################/assist/assistSignQualityDetail/listPageAssistSignQualityDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignQualityDetailService.listPageAssistSignQualityDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSignQualityDetail/listPageAssistSignQualityDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



