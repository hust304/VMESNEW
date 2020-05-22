package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleAnalysisService;
import com.xy.vmes.service.SaleDeliverService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 46368 on 2020/4/8.
 */
@RestController
@Slf4j
public class SaleAnalysisController {
    private Logger logger = LoggerFactory.getLogger(SaleDeliverController.class);

    @Autowired
    private SaleAnalysisService saleAnalysisService;
    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/syntheticalQuery")
    public ResultModel syntheticalQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/syntheticalQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.syntheticalQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/syntheticalQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendQuery")
    public ResultModel salesTrendQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesVolumeByProductQuery")
    public ResultModel salesVolumeByProductQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesVolumeByProductQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesVolumeByProductQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesVolumeByProductQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesNumberByProductQuery")
    public ResultModel salesNumberByProductQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesNumberByProductQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesNumberByProductQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesNumberByProductQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/productReturnRateQuery")
    public ResultModel productReturnRateQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/productReturnRateQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.productReturnRateQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/productReturnRateQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesVolumeByCustomerQuery")
    public ResultModel salesVolumeByCustomerQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesVolumeByCustomerQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesVolumeByCustomerQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesVolumeByCustomerQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesByEmployeeQuery")
    public ResultModel salesByEmployeeQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesByEmployeeQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesByEmployeeQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesByEmployeeQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendByEmployeeQuery")
    public ResultModel salesTrendByEmployeeQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendByEmployeeQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendByEmployeeQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendByEmployeeQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/accountsReceivableQuery")
    public ResultModel accountsReceivableQuery() throws Exception {
        logger.info("################/sale/saleAnalysis/accountsReceivableQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.accountsReceivableQuery(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/accountsReceivableQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendQueryByDMY")
    public ResultModel salesTrendQueryByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendQueryByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendQueryByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendQueryByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendProductByDate")
    public ResultModel salesTrendProductByDate() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendProductByDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendProductByDate(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendProductByDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendCustomerByDate")
    public ResultModel salesTrendCustomerByDate() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendCustomerByDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendCustomerByDate(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendCustomerByDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesTrendEmployeeByDate")
    public ResultModel salesTrendEmployeeByDate() throws Exception {
        logger.info("################/sale/saleAnalysis/salesTrendEmployeeByDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesTrendEmployeeByDate(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesTrendEmployeeByDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductQueryByDMY")
    public ResultModel salesProductQueryByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductQueryByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductQueryByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductQueryByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductVolumeByDMY")
    public ResultModel salesProductVolumeByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductVolumeByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductVolumeByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductVolumeByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductNumberByDMY")
    public ResultModel salesProductNumberByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductNumberByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductNumberByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductNumberByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductProportion")
    public ResultModel salesProductProportion() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductProportion 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductProportion(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductProportion 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductCustomer")
    public ResultModel salesProductCustomer() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductCustomer(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesProductEmployee")
    public ResultModel salesProductEmployee() throws Exception {
        logger.info("################/sale/saleAnalysis/salesProductEmployee 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesProductEmployee(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesProductEmployee 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesCustomerQueryByDMY")
    public ResultModel salesCustomerQueryByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesCustomerQueryByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesCustomerQueryByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesCustomerQueryByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesCustomerVolumeByDMY")
    public ResultModel salesCustomerVolumeByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesCustomerVolumeByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesCustomerVolumeByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesCustomerVolumeByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesCustomerNumberByDMY")
    public ResultModel salesCustomerNumberByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesCustomerNumberByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesCustomerNumberByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesCustomerNumberByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesCustomerProportion")
    public ResultModel salesCustomerProportion() throws Exception {
        logger.info("################/sale/saleAnalysis/salesCustomerProportion 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesCustomerProportion(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesCustomerProportion 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesCustomerProduct")
    public ResultModel salesCustomerProduct() throws Exception {
        logger.info("################/sale/saleAnalysis/salesCustomerProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesCustomerProduct(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesCustomerProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesEmployeeQueryByDMY")
    public ResultModel salesEmployeeQueryByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesEmployeeQueryByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesEmployeeQueryByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesEmployeeQueryByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesEmployeeVolumeByDMY")
    public ResultModel salesEmployeeVolumeByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesEmployeeVolumeByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesEmployeeVolumeByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesEmployeeVolumeByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesEmployeeNumberByDMY")
    public ResultModel salesEmployeeNumberByDMY() throws Exception {
        logger.info("################/sale/saleAnalysis/salesEmployeeNumberByDMY 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesEmployeeNumberByDMY(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesEmployeeNumberByDMY 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesEmployeeProportion")
    public ResultModel salesEmployeeProportion() throws Exception {
        logger.info("################/sale/saleAnalysis/salesEmployeeProportion 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesEmployeeProportion(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesEmployeeProportion 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/salesEmployeeProduct")
    public ResultModel salesEmployeeProduct() throws Exception {
        logger.info("################/sale/saleAnalysis/salesEmployeeProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.salesEmployeeProduct(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/salesEmployeeProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/accountsReceivableQueryByCurrent")
    public ResultModel accountsReceivableQueryByCurrent() throws Exception {
        logger.info("################/sale/saleAnalysis/accountsReceivableQueryByCurrent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.accountsReceivableQueryByCurrent(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/accountsReceivableQueryByCurrent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/accountsReceivable12MonthSingle")
    public ResultModel accountsReceivable12MonthSingle() throws Exception {
        logger.info("################/sale/saleAnalysis/accountsReceivable12MonthSingle 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.accountsReceivable12MonthSingle(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/accountsReceivable12MonthSingle 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-15
     */
    @PostMapping("/sale/saleAnalysis/accountsReceivable12MonthMuti")
    public ResultModel accountsReceivable12MonthMuti() throws Exception {
        logger.info("################/sale/saleAnalysis/accountsReceivable12MonthMuti 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleAnalysisService.accountsReceivable12MonthMuti(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleAnalysis/accountsReceivable12MonthMuti 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}
