package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePaymentRecordService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
* 说明：vmes_purchase_receive:供应商付款表Controller
* @author 陈刚 自动生成
* @date 2019-03-11
*/
@RestController
@Slf4j
public class PurchasePaymentRecordController {
    private Logger logger = LoggerFactory.getLogger(PurchasePaymentRecordController.class);

    @Autowired
    private PurchasePaymentRecordService purchasePaymentRecordService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-11
    */
    @PostMapping("/purchase/purchasePaymentRecord/listPagePurchasePaymentRecord")
    public ResultModel listPagePurchasePaymentRecord() throws Exception {
        logger.info("################/purchase/purchasePaymentRecord/listPagePurchasePaymentRecord 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePaymentRecordService.listPagePurchasePaymentRecord(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentRecord/listPagePurchasePaymentRecord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-11
    */
    @PostMapping("/purchase/purchasePaymentRecord/exportExcelPurchasePaymentRecords")
    public void exportExcelPurchasePaymentRecords() throws Exception {
        logger.info("################/purchase/purchasePaymentRecord/exportExcelPurchasePaymentRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchasePaymentRecordService.exportExcelPurchasePaymentRecords(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentRecord/exportExcelPurchasePaymentRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-03-11
    */
    @PostMapping("/purchase/purchasePaymentRecord/importExcelPurchasePaymentRecords")
    public ResultModel importExcelPurchaseReceives(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchasePaymentRecord/importExcelPurchasePaymentRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchasePaymentRecordService.importExcelPurchasePaymentRecords(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePaymentRecord/importExcelPurchasePaymentRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



