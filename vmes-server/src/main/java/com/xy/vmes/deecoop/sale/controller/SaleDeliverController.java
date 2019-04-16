package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
* 说明：vmes_sale_deliver:发货表Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverController {
    private Logger logger = LoggerFactory.getLogger(SaleDeliverController.class);

    @Autowired
    private SaleDeliverService saleDeliverService;


    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliver/listPageSaleDeliver")
    public ResultModel listPageSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/listPageSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverService.listPageSaleDeliver(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/listPageSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/addSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/addSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.addSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/addSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货类型)-发货完成
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/updateSaleDeliverByDeliverType")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleDeliverByDeliverType() throws Exception {
        logger.info("################/sale/saleDeliver/updateSaleDeliverByDeliverType 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.updateSaleDeliverByDeliverType(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/updateSaleDeliverByDeliverType 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/cancelSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/cancelSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.cancelSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/cancelSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliver/deleteSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/deleteSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.deleteSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/deleteSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 验证发货单id(发货明细)List-是否全部出库完成
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/checkIsAllOutByDeliverId")
    public ResultModel checkIsAllOutByDeliverId() throws Exception {
        logger.info("################/sale/saleDeliver/checkIsAllOutByDeliverId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.checkIsAllOutByDeliverId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/checkIsAllOutByDeliverId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 验证发货单id(发货明细)List-(发货金额)是否为空
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/checkIsNullDeliverSumByDeliverId")
    public ResultModel checkIsNullDeliverSumByDeliverId() throws Exception {
        logger.info("################/sale/saleDeliver/checkIsNullDeliverSumByDeliverId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.checkIsNullDeliverSumByDeliverId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/checkIsNullDeliverSumByDeliverId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliver/exportExcelSaleDelivers")
    public void exportExcelSaleDelivers() throws Exception {
        logger.info("################/sale/saleDeliver/exportExcelSaleDelivers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleDeliverService.exportExcelSaleDelivers(pd,pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/exportExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliver/importExcelSaleDelivers")
    public ResultModel importExcelSaleDelivers(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleDeliver/importExcelSaleDelivers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = saleDeliverService.importExcelSaleDelivers(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/importExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



