package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistCraftService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_assist_craft:工艺名称Controller
* @author 陈刚 自动生成
* @date 2020-04-19
*/
@RestController
@Slf4j
public class AssistCraftController {
    private Logger logger = LoggerFactory.getLogger(AssistCraftController.class);

    @Autowired
    private AssistCraftService assistCraftService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-19
    */
    @PostMapping("/assist/assistCraft/listPageAssistCraft")
    public ResultModel listPageAssistCraft()  throws Exception {
        logger.info("################/assist/assistCraft/listPageAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistCraftService.listPageAssistCraft(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/listPageAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



