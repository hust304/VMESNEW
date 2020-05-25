package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistOrderDetailChildByAssistDeliverService;
import com.xy.vmes.service.AssistOrderDetailChildByRetreatService;
import com.xy.vmes.service.AssistOrderDetailChildService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_order_detail_child:外协订单明细子表Controller
* @author 陈刚 自动生成
* @date 2020-04-24
*/
@RestController
@Slf4j
public class AssistOrderDetailChildController {
    private Logger logger = LoggerFactory.getLogger(AssistOrderDetailChildController.class);
    @Autowired
    private AssistOrderDetailChildService assistOrderDetailChildService;
    @Autowired
    private AssistOrderDetailChildByRetreatService assistOrderDetailChildByRetreatService;
    @Autowired
    private AssistOrderDetailChildByAssistDeliverService assistOrderDetailChildByDeliverService;
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-24
    */
    @PostMapping("/assist/assistOrderDetailChild/listPageAssistOrderDetailChild")
    public ResultModel listPageAssistOrderDetailChild() throws Exception {
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChild 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailChildService.listPageAssistOrderDetailChild(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChild 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //外协-发货管理-生成发货单 (订单明细中-生成发货单)
    @PostMapping("/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByDeliver")
    public ResultModel listPageAssistOrderDetailChildByDeliver() throws Exception {
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailChildByDeliverService.listPageAssistOrderDetailChildByDeliver(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2020-04-24
     */
    @PostMapping("/assist/assistOrderDetailChild/listPageAssistOrderDetailChildInfo")
    public ResultModel listPageAssistOrderDetailChildInfo() throws Exception {
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailChildService.listPageAssistOrderDetailChildInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //外协-退货管理-生成退货单(退料)
    //外协-报废管理-生成报废单(报废原料)
    @PostMapping("/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByRetreat")
    public ResultModel listPageAssistOrderDetailChildByRetreat() throws Exception {
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistOrderDetailChildByRetreatService.listPageAssistOrderDetailChildByRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrderDetailChild/listPageAssistOrderDetailChildByRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



