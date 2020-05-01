package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistPlanDetailByAssistOrderService;
import com.xy.vmes.service.AssistPlanDetailService;
import com.xy.vmes.entity.AssistPlanDetail;

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
* 说明：vmes_assist_plan_detail:外协订单明细Controller
* @author 刘威 自动生成
* @date 2020-04-25
*/
@RestController
@Slf4j
public class AssistPlanDetailController {

    private Logger logger = LoggerFactory.getLogger(AssistPlanDetailController.class);

    @Autowired
    private AssistPlanDetailService assistPlanDetailService;
    @Autowired
    private AssistPlanDetailByAssistOrderService assistPlanDetailByOrderService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlanDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlanDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        AssistPlanDetail assistPlanDetail = assistPlanDetailService.selectById(id);
        model.putResult(assistPlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/assist/assistPlanDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlanDetail assistPlanDetail = (AssistPlanDetail)HttpUtils.pageData2Entity(pd, new AssistPlanDetail());
        assistPlanDetailService.save(assistPlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/assist/assistPlanDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlanDetail assistPlanDetail = (AssistPlanDetail)HttpUtils.pageData2Entity(pd, new AssistPlanDetail());
        assistPlanDetailService.update(assistPlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlanDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlanDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        assistPlanDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetail/listPageAssistPlanDetails")
    public ResultModel listPageAssistPlanDetails()  throws Exception {
        logger.info("################/assist/assistPlanDetail/listPageAssistPlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanDetailService.listPageAssistPlanDetails(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/listPageAssistPlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //添加外协订单:(外协-订单管理-订单列表) 从计划中勾选
    @PostMapping("/assist/assistPlanDetail/listPageAssistPlanDetailByAssistOrder")
    public ResultModel listPageAssistPlanDetailByAssistOrder() throws Exception {
        logger.info("################/assist/assistPlanDetail/listPageAssistPlanDetailByAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanDetailByOrderService.listPageAssistPlanDetailByAssistOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetail/listPageAssistPlanDetailByAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}



