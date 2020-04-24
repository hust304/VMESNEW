package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistOrderService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_order:外协订单表Controller
* @author 陈刚 自动生成
* @date 2020-04-24
*/
@RestController
@Slf4j
public class AssistOrderController {
    private Logger logger = LoggerFactory.getLogger(AssistOrderController.class);

    @Autowired
    private AssistOrderService assistOrderService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-24
    */
    @PostMapping("/assist/assistOrder/listPageAssistOrder")
    public ResultModel listPageAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderService.listPageAssistOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



