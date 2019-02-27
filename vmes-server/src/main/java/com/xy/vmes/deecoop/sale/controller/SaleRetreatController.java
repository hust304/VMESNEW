package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleRetreatService;

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
* 说明：vmes_sale_retreat:退货单 Controller
* @author 陈刚 自动生成
* @date 2019-02-25
*/
@RestController
@Slf4j
public class SaleRetreatController {

    private Logger logger = LoggerFactory.getLogger(SaleRetreatController.class);

    @Autowired
    private SaleRetreatService saleRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/listPageSaleRetreat")
    public ResultModel listPageSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/listPageSaleOrderReturn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleRetreatService.listPageSaleRetreat(pd, pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/listPageSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增退货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/addSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/addSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.addSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/addSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleRetreat/checkRetreatEdit")
    public ResultModel checkRetreatEdit() throws Exception {
        logger.info("################/sale/saleRetreat/checkRetreatEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.checkRetreatEdit(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/checkRetreatEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/exportExcelSaleRetreat")
    public void exportExcelSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/SaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleRetreatService.exportExcelSaleRetreat(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/SaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/importExcelSaleRetreat")
    public ResultModel importExcelSaleRetreat(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleRetreat/importExcelSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleRetreatService.importExcelSaleRetreat(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/importExcelSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



