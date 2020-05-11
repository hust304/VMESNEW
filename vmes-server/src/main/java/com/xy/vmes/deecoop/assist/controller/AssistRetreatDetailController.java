package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistRetreatDetailByEditService;
import com.xy.vmes.service.AssistRetreatDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_retreat_detail:外协退货明细Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistRetreatDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistRetreatDetailController.class);

    @Autowired
    private AssistRetreatDetailService retreatDetailService;
    @Autowired
    private AssistRetreatDetailByEditService retreatDetailByEditService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistRetreatDetail/listPageAssistRetreatDetail")
    public ResultModel listPageAssistRetreatDetail() throws Exception {
        logger.info("################/assist/assistRetreatDetail/listPageAssistRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatDetailService.listPageAssistRetreatDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreatDetail/listPageAssistRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 外协-退料管理-退料列表(编辑)功能
     * @author 陈刚
     * @date 2020-05-07
     */
    @PostMapping("/assist/assistRetreatDetail/listPageAssistRetreatDetailEditByProduct")
    public ResultModel listPageAssistRetreatDetailEditByProduct() throws Exception {
        logger.info("################/assist/assistRetreatDetail/listPageAssistRetreatDetailEditByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatDetailByEditService.listPageAssistRetreatDetailEditByProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreatDetail/listPageAssistRetreatDetailEditByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //供应商原材料退回-检验执行
//    @PostMapping("assist/assistRetreatDetail/updateAssistRetreatDetailByProductQualityExecute")
//    public ResultModel assistRetreatDetailByProductQualityExecute() throws Exception {
//        logger.info("################assist/assistRetreatDetail/assistRetreatDetailByProductQualityExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        ResultModel model = retreatDetailService.assistRetreatDetailByProductQualityExecute(pd);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################assist/assistRetreatDetail/assistRetreatDetailByProductQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    //供应商原材料退回-免检
    @PostMapping("/assist/assistRetreatDetail/updateAssistRetreatDetailByProductQuality")
    public ResultModel updateAssistRetreatDetailByProductQuality() throws Exception {
        logger.info("################/assist/assistRetreatDetail/updateAssistRetreatDetailByProductQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatDetailService.updateAssistRetreatDetailByProductQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreatDetail/updateAssistRetreatDetailByProductQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



