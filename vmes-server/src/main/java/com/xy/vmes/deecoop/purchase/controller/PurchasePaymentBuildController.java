package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePaymentBuildService;
import com.xy.vmes.entity.PurchasePaymentBuild;

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
* 说明：vmes_purchase_payment_build:供应商付款初期设定Controller
* @author 陈刚 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchasePaymentBuildController {
    private Logger logger = LoggerFactory.getLogger(PurchasePaymentBuildController.class);

    @Autowired
    private PurchasePaymentBuildService purchasePaymentBuildService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchasePaymentBuild/listPagePurchasePaymentBuild")
    public ResultModel listPagePurchasePaymentBuild() throws Exception {
        logger.info("################/purchase/purchasePaymentBuild/listPagePurchasePaymentBuild 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePaymentBuildService.listPagePurchasePaymentBuild(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentBuild/listPagePurchasePaymentBuild 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 设定(添加,修改) 供应商付款期间付款初期值
     * @author 陈刚
     * @date 2019-03-11
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePaymentBuild/editPaymentBuild")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel editPaymentBuild() throws Exception {
        logger.info("################/purchase/purchasePaymentBuild/editPaymentBuild 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePaymentBuildService.editPaymentBuild(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentBuild/editPaymentBuild 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 验证供应商(当前企业)是否设定付款期间期初值
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-11
     */
    @PostMapping("/purchase/purchasePaymentBuild/checkIsAllBuildSupplierPayment")
    public ResultModel checkIsAllBuildSupplierPayment() throws Exception {
        logger.info("################/purchase/purchasePaymentBuild/checkIsAllBuildSupplierPayment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("currentCompanyId");
        ResultModel model = purchasePaymentBuildService.checkIsAllBuildSupplierPayment(companyId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentBuild/checkIsAllBuildSupplierPayment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchasePaymentBuild/exportExcelPurchasePaymentBuilds")
    public void exportExcelPurchasePaymentBuilds() throws Exception {
        logger.info("################/purchase/purchasePaymentBuild/exportExcelPurchasePaymentBuilds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchasePaymentBuildService.exportExcelPurchasePaymentBuilds(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentBuild/exportExcelPurchasePaymentBuilds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchasePaymentBuild/importExcelPurchasePaymentBuilds")
    public ResultModel importExcelPurchasePaymentBuilds(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchasePaymentBuild/importExcelPurchasePaymentBuilds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchasePaymentBuildService.importExcelPurchasePaymentBuilds(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentBuild/importExcelPurchasePaymentBuilds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



