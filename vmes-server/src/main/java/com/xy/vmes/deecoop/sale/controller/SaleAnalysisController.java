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




}
