package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistDeliverDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_deliver_detail:外协发货明细Controller
* @author 陈刚 自动生成
* @date 2020-04-27
*/
@RestController
@Slf4j
public class AssistDeliverDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistDeliverDetailController.class);

    @Autowired
    private AssistDeliverDetailService assistDeliverDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-27
    */
    @PostMapping("/assist/assistDeliverDetail/listPageAssistDeliverDetail")
    public ResultModel listPageAssistDeliverDetail() throws Exception {
        logger.info("################/assist/assistDeliverDetail/listPageAssistDeliverDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistDeliverDetailService.listPageAssistDeliverDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliverDetail/listPageAssistDeliverDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



