package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseCompanyPeriodService;
import com.xy.vmes.entity.PurchaseCompanyPeriod;

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
* 说明：vmes_purchase_company_period:采购企业付款期设定Controller
* @author 陈刚 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchaseCompanyPeriodController {

    private Logger logger = LoggerFactory.getLogger(PurchaseCompanyPeriodController.class);

    @Autowired
    private PurchaseCompanyPeriodService purchaseCompanyPeriodService;

    /**
     * //获取当前企业首次(采购)付款期间
     *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseCompanyPeriod/listPagePurchaseCompanyPeriod")
    public ResultModel listPagePurchaseCompanyPeriod() throws Exception {
        logger.info("################/purchase/purchaseCompanyPeriod/listPagePurchaseCompanyPeriod 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseCompanyPeriodService.listPagePurchaseCompanyPeriod(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/listPagePurchaseCompanyPeriod 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取当前付款期间
     * @author 陈刚 自动创建，可以修改
     * @date 2019-03-12
     */
    @PostMapping("/purchase/purchaseCompanyPeriod/findPaymentPeriodByCompanyId")
    public ResultModel findPaymentPeriodByCompanyId() throws Exception {
        logger.info("################/purchase/purchaseCompanyPeriod/findPaymentPeriodByCompanyId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseCompanyPeriodService.findPaymentPeriodByCompanyId(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/findPaymentPeriodByCompanyId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加企业首次付款期间
     * @author 陈刚
     * @date 2019-03-11
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseCompanyPeriod/addCompanyPeriod")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addCompanyPeriod() throws Exception {
        logger.info("################/purchase/purchasePaymentRecord/addCompanyPeriod 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseCompanyPeriodService.addCompanyPeriod(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/addCompanyPeriod 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改企业首次付款期间
     * @author 陈刚
     * @date 2019-03-11
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseCompanyPeriod/updateCompanyPeriod")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCompanyPeriod() throws Exception {
        logger.info("################/purchase/purchasePaymentRecord/updateCompanyPeriod 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseCompanyPeriodService.updateCompanyPeriod(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/updateCompanyPeriod 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseCompanyPeriod/exportExcelPurchaseCompanyPeriods")
    public void exportExcelPurchaseCompanyPeriods() throws Exception {
        logger.info("################/purchase/purchaseCompanyPeriod/exportExcelPurchaseCompanyPeriods 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchaseCompanyPeriodService.exportExcelPurchaseCompanyPeriods(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/exportExcelPurchaseCompanyPeriods 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseCompanyPeriod/importExcelPurchaseCompanyPeriods")
    public ResultModel importExcelPurchaseCompanyPeriods(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseCompanyPeriod/importExcelPurchaseCompanyPeriods 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseCompanyPeriodService.importExcelPurchaseCompanyPeriods(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseCompanyPeriod/importExcelPurchaseCompanyPeriods 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



