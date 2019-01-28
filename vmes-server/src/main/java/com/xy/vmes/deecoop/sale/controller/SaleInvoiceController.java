package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.*;
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
* 说明：vmes_sale_invoice:发票Controller
* @author 陈刚 自动生成
* @date 2019-01-08
*/
@RestController
@Slf4j
public class SaleInvoiceController {
    private Logger logger = LoggerFactory.getLogger(SaleInvoiceController.class);

    @Autowired
    private SaleInvoiceService saleInvoiceService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/listPageSaleInvoice")
    public ResultModel listPageSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/listPageSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleInvoiceService.listPageSaleInvoice(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/listPageSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/addSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/addSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleInvoiceService.addSaleInvoice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/addSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/updateSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/updateSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleInvoiceService.updateSaleInvoice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/updateSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 完成开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/updateStateBySaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateStateBySaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/updateStateBySaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleInvoiceService.updateStateBySaleInvoice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/updateStateBySaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/deleteSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/deleteSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleInvoiceService.deleteSaleInvoice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/deleteSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/cancelSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/cancelSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleInvoiceService.cancelSaleInvoice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/cancelSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/exportExcelSaleInvoices")
    public void exportExcelSaleInvoices() throws Exception {
        logger.info("################/sale/saleInvoice/exportExcelSaleInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleInvoiceService.exportExcelSaleInvoices(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/exportExcelSaleInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/importExcelSaleInvoices")
    public ResultModel importExcelSaleInvoices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleInvoice/importExcelSaleInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = saleInvoiceService.importExcelSaleInvoices(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/importExcelSaleInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



