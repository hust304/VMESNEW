package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleRetreatAuditService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SaleRetreatAuditController {
    private Logger logger = LoggerFactory.getLogger(SaleRetreatAuditController.class);

    @Autowired
    private SaleRetreatAuditService saleRetreatAuditService;

    /**
     * 审核通过(退货单)
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreatAudit/auditPassSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreatAudit/auditPassSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatAuditService.auditPassSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatAudit/auditPassSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不同意(退货单)
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreatAudit/auditDisagreeSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreatAudit/auditDisagreeSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatAuditService.auditDisagreeSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreatAudit/auditDisagreeSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    @PostMapping("/sale/saleRetreatAudit/checkRetreatEdit")
//    public ResultModel checkRetreatEdit() throws Exception {
//        logger.info("################/sale/saleRetreatAudit/checkRetreatEdit 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pageData = HttpUtils.parsePageData();
//        ResultModel model = saleRetreatAuditService.checkRetreatEdit(pageData);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleRetreatAudit/checkRetreatEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
