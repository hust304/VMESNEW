package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleOrder;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.*;
import com.yvan.*;
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
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_sale_order:订单表Controller
* @author 陈刚 自动生成
* @date 2018-12-05
*/
@RestController
@Slf4j
public class SaleOrderController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderController.class);

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderCollectService saleOrderCollectService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/listPageSaleOrder")
    public ResultModel listPageSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/listPageSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleOrderService.listPageSaleOrder(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/listPageSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单详情: vmes_sale_order 订单汇总
     * @date 2019-02-13
     */
    @PostMapping("/sale/saleOrder/listPageOrderCollectByInfo")
    public ResultModel listPageOrderCollectByInfo() throws Exception {
        logger.info("################/sale/saleOrder/listPageOrderCollectByInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderCollectService.listPageOrderCollectByInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/listPageOrderCollectByInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/addSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/addSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.addSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/addSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/updateSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/updateSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.updateSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/updateSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/deleteSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/deleteSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.deleteSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/deleteSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/cancelSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.cancelSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交订单
     * @author 陈刚
     * @date 2018-12-11
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/submitSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.submitSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/submitSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/exportExcelSaleOrders")
    public void exportExcelSaleOrders() throws Exception {
        logger.info("################/sale/saleOrder/exportExcelSaleOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleOrderService.exportExcelSaleOrders(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/exportExcelSaleOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/importExcelSaleOrders")
    public ResultModel importExcelSaleOrders(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleOrder/importExcelSaleOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleOrderService.importExcelSaleOrders(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/importExcelSaleOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



