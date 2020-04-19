package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistProductService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_assist_product:外协件Controller
* @author 陈刚 自动生成
* @date 2020-04-19
*/
@RestController
@Slf4j
public class AssistProductController {
    private Logger logger = LoggerFactory.getLogger(AssistProductController.class);

    @Autowired
    private AssistProductService assistProductService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-19
    */
    @PostMapping("/assist/assistProduct/listPageAssistProduct")
    public ResultModel listPageAssistProduct()  throws Exception {
        logger.info("################/assist/assistProduct/listPageAssistProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistProductService.listPageAssistProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/listPageAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



