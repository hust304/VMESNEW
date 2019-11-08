package com.xy.vmes.deecoop.finance.controller;

import com.xy.vmes.service.FinancePeriodService;
import com.xy.vmes.entity.FinancePeriod;

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
* 说明：vmes_finance_period:应收应付期间表Controller
* @author 刘威 自动生成
* @date 2019-11-05
*/
@RestController
@Slf4j
public class FinancePeriodController {

    private Logger logger = LoggerFactory.getLogger(FinancePeriodController.class);

    @Autowired
    private FinancePeriodService financePeriodService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @GetMapping("/finance/financePeriod/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financePeriod/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        FinancePeriod financePeriod = financePeriodService.selectById(id);
        model.putResult(financePeriod);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financePeriod/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/finance/financePeriod/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinancePeriod financePeriod = (FinancePeriod)HttpUtils.pageData2Entity(pd, new FinancePeriod());
        financePeriodService.save(financePeriod);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financePeriod/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/finance/financePeriod/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinancePeriod financePeriod = (FinancePeriod)HttpUtils.pageData2Entity(pd, new FinancePeriod());
        financePeriodService.update(financePeriod);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @GetMapping("/finance/financePeriod/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financePeriod/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        financePeriodService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financePeriod/listPageFinancePeriods")
    public ResultModel listPageFinancePeriods()  throws Exception {
        logger.info("################/finance/financePeriod/listPageFinancePeriods 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financePeriodService.listPageFinancePeriods(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/listPageFinancePeriods 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financePeriod/exportExcelFinancePeriods")
    public void exportExcelFinancePeriods() throws Exception {
        logger.info("################/finance/financePeriod/exportExcelFinancePeriods 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        financePeriodService.exportExcelFinancePeriods(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/exportExcelFinancePeriods 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financePeriod/importExcelFinancePeriods")
    public ResultModel importExcelFinancePeriods(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/finance/financePeriod/importExcelFinancePeriods 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = financePeriodService.importExcelFinancePeriods(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financePeriod/importExcelFinancePeriods 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



