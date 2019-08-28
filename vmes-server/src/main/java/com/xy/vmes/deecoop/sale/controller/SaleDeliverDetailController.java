package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.SaleDeliverDetailByRetreatService;
import com.xy.vmes.service.SaleDeliverDetailService;
import com.xy.vmes.service.SaleDeliverDtlOnOutDtlService;
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
* 说明：vmes_sale_deliver_detail:发货明细Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleDeliverDetailController.class);

    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverDetailByRetreatService saleDeliverDetailByRetreatService;
    @Autowired
    private SaleDeliverDtlOnOutDtlService saleDeliverDtlOnOutDtlService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliverDetail/listPageSaleDeliverDetail")
    public ResultModel listPageSaleDeliverDetail() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverDetailService.listPageSaleDeliverDetail(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice")
    public ResultModel listPageSaleDeliverDetailByPrice() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverDetailService.listPageSaleDeliverDetailByPrice(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliverDetail/listPageDeliverDetailByRetreat")
    public ResultModel listPageDeliverDetailByRetreat() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverDetailByRetreatService.listPageDeliverDetailByRetreat(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取销售发货单明细信息-根据出库单信息(出库单id)
     * @return
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliverDetail/listPageDeliverDetailByOut")
    public ResultModel listPageDeliverDetailByOut() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDtlOnOutDtlService.listPageDeliverDetailByOut(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货明细)
     * 后计价修改(结算单位,结算数量,结算单价,结算金额)
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleDeliverDetailByPrice() throws Exception {
        logger.info("################/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDetailService.updateSaleDeliverDetailByPrice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliverDetail/exportExcelSaleDeliverDetails")
    public void exportExcelSaleDeliverDetails() throws Exception {
        logger.info("################/sale/saleDeliverDetail/exportExcelSaleDeliverDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleDeliverDetailService.exportExcelSaleDeliverDetails(pd,pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/exportExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliverDetail/importExcelSaleDeliverDetails")
    public ResultModel importExcelSaleDeliverDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleDeliverDetail/importExcelSaleDeliverDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = saleDeliverDetailService.importExcelSaleDeliverDetails(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/importExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



