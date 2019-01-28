package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleOrder;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.xy.vmes.service.SaleOrderService;
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

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;


/**
* 说明：vmes_sale_order_detail:订单明细Controller
* @author 陈刚 自动生成
* @date 2018-12-05
*/
@RestController
@Slf4j
public class SaleOrderDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderDetailController.class);


    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrderDetail/listPageSaleOrderDetail")
    public ResultModel listPageSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleOrderDetailService.listPageSaleOrderDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消订单明细
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/cancelSaleOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/cancelSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.cancelSaleOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/cancelSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除订单明细
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/deleteSaleOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/deleteSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.deleteSaleOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/deleteSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrderDetail/exportExcelSaleOrderDetails")
    public void exportExcelSaleOrderDetails() throws Exception {
        logger.info("################/sale/saleOrderDetail/exportExcelSaleOrderDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleOrderDetailService.exportExcelSaleOrderDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/exportExcelSaleOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrderDetail/importExcelSaleOrderDetails")
    public ResultModel importExcelSaleOrderDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleOrderDetail/importExcelSaleOrderDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleOrderDetailService.importExcelSaleOrderDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/importExcelSaleOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



