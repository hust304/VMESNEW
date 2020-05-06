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

    /**
     * 获取(质量-外协检验)外协签收明细检验
     * 菜单路径:(质量-外协检验) 当前外协签收明细(执行)按钮弹出框查询调用方法
     *
     * 模块菜单路径:质量-外协检验
     *
     * @author 陈刚
     * @date 2020-05-04
     */
    @PostMapping("assist/assistSignDetail/listPageAssistSignDetailByQualityExecute")
    public ResultModel listPageAssistSignDetailByQualityExecute() throws Exception {
        logger.info("################assist/assistSignDetail/listPageAssistSignDetailByQualityExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignDetailService.listPageAssistSignDetailByQualityExecute(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################assist/assistSignDetail/listPageAssistSignDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //外协签收明细-检验执行
    @PostMapping("assist/assistSignDetail/assistSignDetailByQualityExecute")
    public ResultModel assistSignDetailByQualityExecute() throws Exception {
        logger.info("################assist/assistSignDetail/assistSignDetailByQualityExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSignDetailService.assistSignDetailByQualityExecute(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################assist/assistSignDetail/assistSignDetailByQualityExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

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



