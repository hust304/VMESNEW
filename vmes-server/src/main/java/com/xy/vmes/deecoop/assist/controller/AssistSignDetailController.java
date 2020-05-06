package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistSignDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_assist_sign_detail:外协签收单明细Controller
* @author 陈刚 自动生成
* @date 2020-05-04
*/
@RestController
@Slf4j
public class AssistSignDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistSignDetailController.class);

    @Autowired
    private AssistSignDetailService assistSignDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-04
    */
    @PostMapping("/assist/assistSignDetail/listPageAssistSignDetail")
    public ResultModel listPageAssistSignDetail() throws Exception {
        logger.info("################/assist/assistSignDetail/listPageAssistSignDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignDetailService.listPageAssistSignDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSignDetail/listPageAssistSignDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    //外协签收明细-检验执行
//    @PostMapping("/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute")
//    public ResultModel purchaseSignDetailByQualityExecute() throws Exception {
//        logger.info("################/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        ResultModel model = purchaseSignDetailService.purchaseSignDetailByQualityExecute(pd);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/purchase/purchaseSignDetail/purchaseSignDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    //外协签收明细-免检
    @PostMapping("/assist/assistSignDetail/updateAssistSignDetailByQuality")
    public ResultModel updateAssistSignDetailByQuality() throws Exception {
        logger.info("################/assist/assistSignDetail/updateAssistSignDetailByQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignDetailService.updateAssistSignDetailByQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSignDetail/updateAssistSignDetailByQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



