package com.xy.vmes.deecoop.finance.controller;

import com.xy.vmes.service.FinanceInvoiceService;
import com.xy.vmes.entity.FinanceInvoice;

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
* 说明：vmes_finance_invoice:销售开票Controller
* @author 刘威 自动生成
* @date 2019-12-03
*/
@RestController
@Slf4j
public class FinanceInvoiceController {

    private Logger logger = LoggerFactory.getLogger(FinanceInvoiceController.class);

    @Autowired
    private FinanceInvoiceService financeInvoiceService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-12-03
    */
    @GetMapping("/finance/financeInvoice/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeInvoice/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        FinanceInvoice financeInvoice = financeInvoiceService.selectById(id);
        model.putResult(financeInvoice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-12-03
    */
    @PostMapping("/finance/financeInvoice/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/finance/financeInvoice/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceInvoice financeInvoice = (FinanceInvoice)HttpUtils.pageData2Entity(pd, new FinanceInvoice());
        financeInvoiceService.save(financeInvoice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-12-03
    */
    @PostMapping("/finance/financeInvoice/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/finance/financeInvoice/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceInvoice financeInvoice = (FinanceInvoice)HttpUtils.pageData2Entity(pd, new FinanceInvoice());
        financeInvoiceService.update(financeInvoice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-12-03
    */
    @GetMapping("/finance/financeInvoice/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeInvoice/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        financeInvoiceService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-12-03
     */
    @PostMapping("/finance/financeInvoice/rebackFinanceInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackFinanceInvoice()  throws Exception {

        logger.info("################/finance/financeInvoice/rebackFinanceInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceInvoice financeInvoice = (FinanceInvoice)HttpUtils.pageData2Entity(pd, new FinanceInvoice());
        financeInvoice.setState("-1");
        financeInvoiceService.update(financeInvoice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/rebackFinanceInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-12-03
     */
    @PostMapping("/finance/financeInvoice/openFinanceInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel openFinanceInvoice()  throws Exception {

        logger.info("################/finance/financeInvoice/openFinanceInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceInvoice financeInvoice = (FinanceInvoice)HttpUtils.pageData2Entity(pd, new FinanceInvoice());
        financeInvoice.setState("1");
        financeInvoiceService.update(financeInvoice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/openFinanceInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-12-03
     */
    @PostMapping("/finance/financeInvoice/deleteFinanceInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteFinanceInvoice()  throws Exception {

        logger.info("################/finance/financeInvoice/deleteFinanceInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceInvoice financeInvoice = (FinanceInvoice)HttpUtils.pageData2Entity(pd, new FinanceInvoice());
        financeInvoiceService.deleteById(financeInvoice.getId());
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/deleteFinanceInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-12-03
    */
    @PostMapping("/finance/financeInvoice/listPageFinanceInvoices")
    public ResultModel listPageFinanceInvoices()  throws Exception {
        logger.info("################/finance/financeInvoice/listPageFinanceInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeInvoiceService.listPageFinanceInvoices(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/listPageFinanceInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-12-03
    */
    @PostMapping("/finance/financeInvoice/exportExcelFinanceInvoices")
    public void exportExcelFinanceInvoices() throws Exception {
        logger.info("################/finance/financeInvoice/exportExcelFinanceInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        financeInvoiceService.exportExcelFinanceInvoices(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/exportExcelFinanceInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-12-03
    */
    @PostMapping("/finance/financeInvoice/importExcelFinanceInvoices")
    public ResultModel importExcelFinanceInvoices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/finance/financeInvoice/importExcelFinanceInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = financeInvoiceService.importExcelFinanceInvoices(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/importExcelFinanceInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-12-03
     */
    @PostMapping("/finance/financeInvoice/getInvoiceAmount")
    public ResultModel getInvoiceAmount()  throws Exception {
        logger.info("################/finance/financeInvoice/getInvoiceAmount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeInvoiceService.getInvoiceAmount(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/getInvoiceAmount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-12-03
     */
    @PostMapping("/finance/financeInvoice/saveFinanceInvoice")
    public ResultModel saveFinanceInvoice()  throws Exception {
        logger.info("################/finance/financeInvoice/saveFinanceInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeInvoiceService.saveFinanceInvoice(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeInvoice/saveFinanceInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



