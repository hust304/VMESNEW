package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistPlanDetailChildService;
import com.xy.vmes.entity.AssistPlanDetailChild;

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
* 说明：vmes_assist_plan_detail_child:外协订单明细原材料Controller
* @author 刘威 自动生成
* @date 2020-04-25
*/
@RestController
@Slf4j
public class AssistPlanDetailChildController {

    private Logger logger = LoggerFactory.getLogger(AssistPlanDetailChildController.class);

    @Autowired
    private AssistPlanDetailChildService assistPlanDetailChildService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlanDetailChild/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlanDetailChild/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        AssistPlanDetailChild assistPlanDetailChild = assistPlanDetailChildService.selectById(id);
        model.putResult(assistPlanDetailChild);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetailChild/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/assist/assistPlanDetailChild/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlanDetailChild assistPlanDetailChild = (AssistPlanDetailChild)HttpUtils.pageData2Entity(pd, new AssistPlanDetailChild());
        assistPlanDetailChildService.save(assistPlanDetailChild);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetailChild/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/assist/assistPlanDetailChild/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        AssistPlanDetailChild assistPlanDetailChild = (AssistPlanDetailChild)HttpUtils.pageData2Entity(pd, new AssistPlanDetailChild());
        assistPlanDetailChildService.update(assistPlanDetailChild);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-25
    */
    @GetMapping("/assist/assistPlanDetailChild/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/assist/assistPlanDetailChild/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        assistPlanDetailChildService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetailChild/listPageAssistPlanDetailChilds")
    public ResultModel listPageAssistPlanDetailChilds()  throws Exception {
        logger.info("################/assist/assistPlanDetailChild/listPageAssistPlanDetailChilds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistPlanDetailChildService.listPageAssistPlanDetailChilds(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/listPageAssistPlanDetailChilds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetailChild/exportExcelAssistPlanDetailChilds")
    public void exportExcelAssistPlanDetailChilds() throws Exception {
        logger.info("################/assist/assistPlanDetailChild/exportExcelAssistPlanDetailChilds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        assistPlanDetailChildService.exportExcelAssistPlanDetailChilds(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/exportExcelAssistPlanDetailChilds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-25
    */
    @PostMapping("/assist/assistPlanDetailChild/importExcelAssistPlanDetailChilds")
    public ResultModel importExcelAssistPlanDetailChilds(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/assist/assistPlanDetailChild/importExcelAssistPlanDetailChilds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = assistPlanDetailChildService.importExcelAssistPlanDetailChilds(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistPlanDetailChild/importExcelAssistPlanDetailChilds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



