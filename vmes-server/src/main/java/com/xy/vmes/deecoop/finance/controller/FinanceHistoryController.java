package com.xy.vmes.deecoop.finance.controller;

import com.xy.vmes.service.FinanceHistoryService;
import com.xy.vmes.entity.FinanceHistory;

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
* 说明：vmes_finance_history:历史账单Controller
* @author 刘威 自动生成
* @date 2019-11-20
*/
@RestController
@Slf4j
public class FinanceHistoryController {

    private Logger logger = LoggerFactory.getLogger(FinanceHistoryController.class);

    @Autowired
    private FinanceHistoryService financeHistoryService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-20
    */
    @GetMapping("/finance/financeHistory/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeHistory/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        FinanceHistory financeHistory = financeHistoryService.selectById(id);
        model.putResult(financeHistory);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-20
    */
    @PostMapping("/finance/financeHistory/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/finance/financeHistory/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceHistory financeHistory = (FinanceHistory)HttpUtils.pageData2Entity(pd, new FinanceHistory());
        financeHistoryService.save(financeHistory);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-20
    */
    @PostMapping("/finance/financeHistory/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/finance/financeHistory/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceHistory financeHistory = (FinanceHistory)HttpUtils.pageData2Entity(pd, new FinanceHistory());
        financeHistoryService.update(financeHistory);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-20
    */
    @GetMapping("/finance/financeHistory/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeHistory/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        financeHistoryService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-20
    */
    @PostMapping("/finance/financeHistory/listPageFinanceHistorys")
    public ResultModel listPageFinanceHistorys()  throws Exception {
        logger.info("################/finance/financeHistory/listPageFinanceHistorys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeHistoryService.listPageFinanceHistorys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/listPageFinanceHistorys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-20
    */
    @PostMapping("/finance/financeHistory/exportExcelFinanceHistorys")
    public void exportExcelFinanceHistorys() throws Exception {
        logger.info("################/finance/financeHistory/exportExcelFinanceHistorys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        financeHistoryService.exportExcelFinanceHistorys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/exportExcelFinanceHistorys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-20
    */
    @PostMapping("/finance/financeHistory/importExcelFinanceHistorys")
    public ResultModel importExcelFinanceHistorys(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/finance/financeHistory/importExcelFinanceHistorys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = financeHistoryService.importExcelFinanceHistorys(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeHistory/importExcelFinanceHistorys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



