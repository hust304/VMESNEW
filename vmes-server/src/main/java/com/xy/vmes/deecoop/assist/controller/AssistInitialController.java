package com.xy.vmes.deecoop.assist.controller;


import com.xy.vmes.service.AssistInitialService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：:外协初始化Controller
 * @author 陈刚
 * @date 2020-05-13
 */
@RestController
@Slf4j
public class AssistInitialController {
    private Logger logger = LoggerFactory.getLogger(AssistInitialController.class);

    @Autowired
    private AssistInitialService assistInitialService;

    /**
     * @author 陈刚
     * @date 2020-05-13
     */
    @PostMapping("/assist/assistInitial/deleteAssistByInitial")
    public ResultModel deleteAssistByInitial() throws Exception {
        logger.info("################/assist/assistInitial/deleteAssistByInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        assistInitialService.deleteAssistByInitial(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistInitial/deleteAssistByInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
