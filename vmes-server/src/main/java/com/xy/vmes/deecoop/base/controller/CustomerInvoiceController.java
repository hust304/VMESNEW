package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.CustomerInvoice;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.CustomerInvoiceService;
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
* 说明：vmes_customer_invoice:客户开票信息Controller
* @author 陈刚 自动生成
* @date 2019-01-09
*/
@RestController
@Slf4j
public class CustomerInvoiceController {

    private Logger logger = LoggerFactory.getLogger(CustomerInvoiceController.class);

    @Autowired
    private CustomerInvoiceService customerInvoiceService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-09
    */
    @PostMapping("/base/customerInvoice/listPageCustomerInvoices")
    public ResultModel listPageCustomerInvoices()  throws Exception {
        logger.info("################customerInvoice/listPageCustomerInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = customerInvoiceService.listPageCustomerInvoices(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customerInvoice/listPageCustomerInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

/***************************************************/
    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-09
    */
    @PostMapping("/base/customerInvoice/exportExcelCustomerInvoices")
    public void exportExcelCustomerInvoices() throws Exception {
        logger.info("################customerInvoice/exportExcelCustomerInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        customerInvoiceService.exportExcelCustomerInvoices(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customerInvoice/exportExcelCustomerInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-09
    */
    @PostMapping("/base/customerInvoice/importExcelCustomerInvoices")
    public ResultModel importExcelCustomerInvoices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################customerInvoice/importExcelCustomerInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = customerInvoiceService.importExcelCustomerInvoices(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################customerInvoice/importExcelCustomerInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



