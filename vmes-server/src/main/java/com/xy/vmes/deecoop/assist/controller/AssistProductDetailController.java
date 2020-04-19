package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistProductDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_product_detail:外协件原材料Controller
* @author 陈刚 自动生成
* @date 2020-04-19
*/
@RestController
@Slf4j
public class AssistProductDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistProductDetailController.class);

    @Autowired
    private AssistProductDetailService assistProductDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-19
    */
    @PostMapping("/assist/assistProductDetail/listPageAssistProductDetail")
    public ResultModel listPageAssistProductDetail() throws Exception {
        logger.info("################/assist/assistProductDetail/listPageAssistProductDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistProductDetailService.listPageAssistProductDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProductDetail/listPageAssistProductDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



