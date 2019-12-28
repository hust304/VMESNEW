package com.xy.vmes.deecoop.quality.controller;

import com.xy.vmes.service.QualityService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_quality:质量检验项目Controller
* @author 陈刚 自动生成
* @date 2019-12-28
*/
@RestController
@Slf4j
public class QualityController {
    private Logger logger = LoggerFactory.getLogger(QualityController.class);

    @Autowired
    private QualityService qualityService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-12-28
    */
    @PostMapping("/quality/quality/listPageQuality")
    public ResultModel listPageQuality() throws Exception {
        logger.info("################/quality/quality/listPageQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = qualityService.listPageQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/quality/quality/listPageQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




}



