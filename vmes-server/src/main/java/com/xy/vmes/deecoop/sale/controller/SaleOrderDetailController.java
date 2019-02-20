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
    @Autowired
    private SaleOrderDetailCollectService saleOrderDetailCollectService;
    @Autowired
    private SaleOrderDetailByLockCountService saleOrderDetailByLockCountService;

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
     * 订单详情(订单明细) vmes_sale_order_detail 订单明细汇总
     * @author 陈刚
     * @date 2019-02-14
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetailCollectByInfo")
    public ResultModel listPageOrderDetailCollectByInfo() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailCollectByInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailCollectService.listPageOrderDetailCollectByInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailCollectByInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单明细(产品锁定库存) vmes_sale_order_detail
     * @author 陈刚
     * @date 2019-02-14
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetailByLockCount")
    public ResultModel listPageOrderDetailByLockCount() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByLockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailByLockCountService.listPageOrderDetailByLockCount(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByLockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
     * (解锁)订单明细产品锁定库存数量
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSaleOrderDetailByLockCount() throws Exception {
        logger.info("################/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.rebackSaleOrderDetailByLockCount(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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



