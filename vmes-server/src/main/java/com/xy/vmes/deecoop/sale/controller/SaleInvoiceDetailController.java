package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleInvoiceDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleInvoiceDetailService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：vmes_sale_invoice_detail:发票明细Controller
* @author 陈刚 自动生成
* @date 2019-01-08
*/
@RestController
@Slf4j
public class SaleInvoiceDetailController {

    private Logger logger = LoggerFactory.getLogger(SaleInvoiceDetailController.class);

    @Autowired
    private SaleInvoiceDetailService saleInvoiceDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoiceDetail/listPageSaleInvoiceDetail")
    public ResultModel listPageSaleInvoiceDetail()  throws Exception {
        logger.info("################/sale/saleInvoiceDetail/listPageSaleInvoiceDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleInvoiceDetailService.listPageSaleInvoiceDetail(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoiceDetail/listPageSaleInvoiceDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoiceDetail/exportExcelSaleInvoiceDetails")
    public void exportExcelSaleInvoiceDetails() throws Exception {
        logger.info("################/sale/saleInvoiceDetail/exportExcelSaleInvoiceDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleInvoiceDetailService.exportExcelSaleInvoiceDetails(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoiceDetail/exportExcelSaleInvoiceDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoiceDetail/importExcelSaleInvoiceDetails")
    public ResultModel importExcelSaleInvoiceDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleInvoiceDetail/importExcelSaleInvoiceDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = saleInvoiceDetailService.importExcelSaleInvoiceDetails(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoiceDetail/importExcelSaleInvoiceDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



