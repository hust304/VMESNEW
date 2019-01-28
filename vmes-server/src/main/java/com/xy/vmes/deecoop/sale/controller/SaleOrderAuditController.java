package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.Producer;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.SaleOrder;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.*;
import com.yvan.DateUtils;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@RestController
@Slf4j
public class SaleOrderAuditController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderController.class);

    @Autowired
    private SaleOrderAuditService saleOrderAuditService;


    @PostMapping("/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock")
    public ResultModel listPageSaleOrderDetailByLockStock() throws Exception {
        logger.info("################/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.listPageSaleOrderDetailByLockStock(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/listPageSaleOrderDetailByLockStock 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单审核
     * 1. 订单明细中:(货品id,货品计价单位,订单客户,价格)与订单明细货品价格比较
     * 2. 订单明细中:(货品订购数量(计量单位))与货品库存可用数量比较
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-11
     */
    @PostMapping("/sale/saleOrderAudit/checkSaleOrderByAudit")
    public ResultModel checkSaleOrderByAudit() throws Exception {
        logger.info("################/sale/saleOrderAudit/checkSaleOrderByAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.checkSaleOrderByAudit(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/checkSaleOrderByAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单明细(锁定库存数量)
     *
     * productIds: 锁定库存货品id字符串
     * dtlJsonStr: {id:'订单明细id', lockCount:'锁定货品数量'}
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderAudit/updateSaleOrderDetailByLockStock")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrderDetailByLockStock() throws Exception {
        logger.info("################/sale/saleOrderAudit/updateSaleOrderDetailByLockStock 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.updateSaleOrderDetailByLockStock(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/updateSaleOrderDetailByLockStock 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单(修改订单明细价格)
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderAudit/updateSaleOrderByAudit")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrderByAudit() throws Exception {
        logger.info("################/sale/saleOrderAudit/updateSaleOrderByAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.updateSaleOrderByAudit(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/updateSaleOrderByAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核通过订单
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderAudit/auditPassSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassSaleOrder() throws Exception {
        logger.info("################/sale/saleOrderAudit/auditPassSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.auditPassSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/auditPassSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderAudit/auditDisagreeSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeSaleOrder() throws Exception {
        logger.info("################/sale/saleOrderAudit/auditDisagreeSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderAuditService.auditDisagreeSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderAudit/auditDisagreeSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
