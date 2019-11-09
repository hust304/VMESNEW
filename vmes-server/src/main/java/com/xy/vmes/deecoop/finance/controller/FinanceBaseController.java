package com.xy.vmes.deecoop.finance.controller;

import com.xy.vmes.service.FinanceBaseService;
import com.xy.vmes.entity.FinanceBase;

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
* 说明：vmes_finance_base:应收应付初始化Controller
* @author 刘威 自动生成
* @date 2019-11-05
*/
@RestController
@Slf4j
public class FinanceBaseController {

    private Logger logger = LoggerFactory.getLogger(FinanceBaseController.class);

    @Autowired
    private FinanceBaseService financeBaseService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @GetMapping("/finance/financeBase/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeBase/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        FinanceBase financeBase = financeBaseService.selectById(id);
        model.putResult(financeBase);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financeBase/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/finance/financeBase/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceBase financeBase = (FinanceBase)HttpUtils.pageData2Entity(pd, new FinanceBase());
        financeBaseService.save(financeBase);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financeBase/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/finance/financeBase/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceBase financeBase = (FinanceBase)HttpUtils.pageData2Entity(pd, new FinanceBase());
        financeBaseService.update(financeBase);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-05
    */
    @GetMapping("/finance/financeBase/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeBase/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        financeBaseService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financeBase/listPageFinanceBases")
    public ResultModel listPageFinanceBases()  throws Exception {
        logger.info("################/finance/financeBase/listPageFinanceBases 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.listPageFinanceBases(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/listPageFinanceBases 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-05
     */
    @PostMapping("/finance/financeBase/initialFinanceSale")
    public ResultModel initialFinanceSale()  throws Exception {
        logger.info("################/finance/financeBase/initialFinanceSale 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.initialFinanceSale(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/initialFinanceSale 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-05
     */
    @PostMapping("/finance/financeBase/isDisableSaleInit")
    public ResultModel isDisableSaleInit()  throws Exception {
        logger.info("################/finance/financeBase/isDisableSaleInit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.isDisableSaleInit(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/isDisableSaleInit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-05
     */
    @PostMapping("/finance/financeBase/setDisableSaleInit")
    public ResultModel setDisableSaleInit()  throws Exception {
        logger.info("################/finance/financeBase/setDisableSaleInit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.setDisableSaleInit(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/setDisableSaleInit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-05
     */
    @PostMapping("/finance/financeBase/addFinanceBase")
    public ResultModel addFinanceBase()  throws Exception {
        logger.info("################/finance/financeBase/addFinanceBase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.addFinanceBase(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/addFinanceBase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-05
     */
    @PostMapping("/finance/financeBase/batchAddFinanceBase")
    public ResultModel batchAddFinanceBase()  throws Exception {
        logger.info("################/finance/financeBase/batchAddFinanceBase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.batchAddFinanceBase(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/batchAddFinanceBase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/finance/financeBase/eidtFinanceBase")
    public ResultModel eidtFinanceBase()  throws Exception {
        logger.info("################/finance/financeBase/eidtFinanceBase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.eidtFinanceBase(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/eidtFinanceBase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/finance/financeBase/deleteFinanceBase")
    public ResultModel deleteFinanceBase()  throws Exception {
        logger.info("################/finance/financeBase/deleteFinanceBase 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBaseService.deleteFinanceBase(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/deleteFinanceBase 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financeBase/exportExcelFinanceBases")
    public void exportExcelFinanceBases() throws Exception {
        logger.info("################/finance/financeBase/exportExcelFinanceBases 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        financeBaseService.exportExcelFinanceBases(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/exportExcelFinanceBases 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/finance/financeBase/importExcelFinanceBases")
    public ResultModel importExcelFinanceBases(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/finance/financeBase/importExcelFinanceBases 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = financeBaseService.importExcelFinanceBases(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBase/importExcelFinanceBases 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



