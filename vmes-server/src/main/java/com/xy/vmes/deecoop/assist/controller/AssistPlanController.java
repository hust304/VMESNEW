package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistPlanService;
import com.xy.vmes.entity.AssistPlan;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
* 说明：vmes_assist_plan:应收/应付单Controller
* @author 刘威 自动生成
* @date 2020-04-25
*/
@RestController
@Slf4j
public class AssistPlanController {

    private Logger logger = LoggerFactory.getLogger(AssistPlanController.class);

    @Autowired
    private AssistPlanService assistPlanService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlan/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlan/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        AssistPlan assistPlan = assistPlanService.selectById(id);
        model.putResult(assistPlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlan/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/assist/assistPlan/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlan assistPlan = (AssistPlan)HttpUtils.pageData2Entity(pd, new AssistPlan());
        assistPlanService.save(assistPlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlan/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/assist/assistPlan/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlan assistPlan = (AssistPlan)HttpUtils.pageData2Entity(pd, new AssistPlan());
        assistPlanService.update(assistPlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlan/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlan/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        assistPlanService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlan/listPageAssistPlans")
    public ResultModel listPageAssistPlans()  throws Exception {
        logger.info("################/assist/assistPlan/listPageAssistPlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.listPageAssistPlans(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/listPageAssistPlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/addAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/addAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.addAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/addAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/updateAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/updateAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.updateAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/updateAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/auditPassAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/auditPassAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.auditPassAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/auditPassAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/auditDisagreeAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/auditDisagreeAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.auditDisagreeAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/auditDisagreeAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/recoveryAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/recoveryAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.recoveryAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/recoveryAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/submitAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/submitAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.submitAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/submitAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/deleteAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/deleteAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.deleteAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/deleteAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/assist/assistPlan/cancelAssistPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistPlan()  throws Exception {
        logger.info("################/assist/assistPlan/cancelAssistPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanService.cancelAssistPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/cancelAssistPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlan/exportExcelAssistPlans")
    public void exportExcelAssistPlans() throws Exception {
        logger.info("################/assist/assistPlan/exportExcelAssistPlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        assistPlanService.exportExcelAssistPlans(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/exportExcelAssistPlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlan/importExcelAssistPlans")
    public ResultModel importExcelAssistPlans(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/assist/assistPlan/importExcelAssistPlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = assistPlanService.importExcelAssistPlans(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlan/importExcelAssistPlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



