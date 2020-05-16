package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistOrderDetailByRetreatService;
import com.xy.vmes.service.AssistOrderDetailQueryBySignService;
import com.xy.vmes.service.AssistOrderDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_order_detail:外协订单明细Controller
* @author 陈刚 自动生成
* @date 2020-04-24
*/
@RestController
@Slf4j
public class AssistOrderDetailController {
    private Logger logger = LoggerFactory.getLogger(AssistOrderDetailController.class);

    @Autowired
    private AssistOrderDetailService assistOrderDetailService;
    @Autowired
    private AssistOrderDetailQueryBySignService orderDetailQueryBySignService;
    @Autowired
    private AssistOrderDetailByRetreatService orderDetailByRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-24
    */
    @PostMapping("/assist/assistOrderDetail/listPageAssistOrderDetail")
    public ResultModel listPageAssistOrderDetail() throws Exception {
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailService.listPageAssistOrderDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 外协-收货管理-生成收货单-收货-弹出界面查询
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrderDetail/listPageAssistOrderDetaiQueryBySign")
    public ResultModel listPageAssistOrderDetaiQueryBySign() throws Exception {
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetaiQueryBySign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderDetailQueryBySignService.listPageAssistOrderDetaiQueryBySign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetaiQueryBySign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 外协-外协件退货-生成退货(成品退货)
     * 外协-外协件报废-生成报废(成品报废)
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrderDetail/listPageAssistOrderDetailByRetreat")
    public ResultModel listPageAssistOrderDetailByRetreat() throws Exception {
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetailByRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderDetailByRetreatService.listPageAssistOrderDetailByRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetailByRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //外协订单明细(外协件)详情查询
    @PostMapping("/assist/assistOrderDetail/listPageAssistOrderDetailInfo")
    public ResultModel listPageAssistOrderDetailInfo() throws Exception {
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetailInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailService.listPageAssistOrderDetailInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetail/listPageAssistOrderDetailInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



