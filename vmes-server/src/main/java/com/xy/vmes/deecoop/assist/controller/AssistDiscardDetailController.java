package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistDiscardDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_assist_discard_detail:外协报废明细Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistDiscardDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistDiscardDetailController.class);

    @Autowired
    private AssistDiscardDetailService AssistDiscardDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistDiscardDetail/listPageassistDiscardDetail")
    public ResultModel listPageassistDiscardDetail() throws Exception {
        logger.info("################/assist/assistDiscardDetail/listPageassistDiscardDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = AssistDiscardDetailService.listPageassistDiscardDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscardDetail/listPageassistDiscardDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



