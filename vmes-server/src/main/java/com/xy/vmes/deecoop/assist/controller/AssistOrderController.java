package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistOrderService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    //新增外协订单
    @PostMapping("/assist/assistOrder/addAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/addAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/addAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //提交(审核)外协订单
    @PostMapping("/assist/assistOrder/submitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/submitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/submitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //撤回(审核)外协订单
    @PostMapping("/assist/assistOrder/rebackSubmitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //取消外协订单
    @PostMapping("/assist/assistOrder/cancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    //恢复(取消)外协订单
    @PostMapping("/assist/assistOrder/rebackCancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //删除外协订单
    @PostMapping("/assist/assistOrder/deleteAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //修改外协订单
    @PostMapping("/assist/assistOrder/updateAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/updateAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/updateAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/assist/assistOrder/auditPassAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/assist/assistOrder/auditDisagreeAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}



