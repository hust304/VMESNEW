package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleRetreatDetailByEditService;
import com.xy.vmes.service.SaleRetreatDetailService;

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
* 说明：vmes_sale_order_return_detail:退货明细Controller
* @author 陈刚 自动生成
* @date 2019-02-25
*/
@RestController
@Slf4j
public class SaleRetreatDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleRetreatDetailController.class);

    @Autowired
    private SaleRetreatDetailService saleRetreatDetailService;
    @Autowired
    private SaleRetreatDetailByEditService saleRetreatDetailByEditService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreatDetail/listPageSaleRetreatDetail")
    public ResultModel listPageSaleRetreatDetail() throws Exception {
        logger.info("################/sale/saleRetreatDetail/listPageSaleRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleRetreatDetailService.listPageSaleRetreatDetail(pd, pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatDetail/listPageSaleRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleRetreatDetail/listPageRetreatDetailByEdit")
    public ResultModel listPageRetreatDetailByEdit() throws Exception {
        logger.info("################/sale/saleRetreatDetail/listPageRetreatDetailByEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleRetreatDetailByEditService.listPageRetreatDetailByEdit(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatDetail/listPageRetreatDetailByEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreatDetail/exportExcelSaleRetreatDetail")
    public void exportExcelSaleRetreatDetail() throws Exception {
        logger.info("################/sale/saleRetreatDetail/exportExcelSaleRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleRetreatDetailService.exportExcelSaleRetreatDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatDetail/exportExcelSaleRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreatDetail/importExcelSaleRetreatDetail")
    public ResultModel importExcelSaleRetreatDetail(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleRetreatDetail/importExcelSaleRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleRetreatDetailService.importExcelSaleRetreatDetail(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatDetail/importExcelSaleRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



