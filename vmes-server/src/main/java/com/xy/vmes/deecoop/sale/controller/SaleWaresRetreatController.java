package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleWaresRetreatService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_sale_wares_retreat:无订单退货单Controller
* @author 陈刚 自动生成
* @date 2019-12-05
*/
@RestController
@Slf4j
public class SaleWaresRetreatController {
    private Logger logger = LoggerFactory.getLogger(SaleWaresRetreatController.class);

    @Autowired
    private SaleWaresRetreatService saleWaresRetreatService;

    /**
     * (无订单)退货单
     * @return
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/listPageSaleWaresRetreat")
    public ResultModel listPageSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/listPageSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.listPageSaleWaresRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/listPageSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)添加退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/addSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/addSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.addSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/addSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)提交退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/submitSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/submitSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.submitSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/submitSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)(撤回提交)退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/rebackSubmitSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/rebackSubmitSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.rebackSubmitSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/rebackSubmitSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)修改退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/updateSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/updateSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.updateSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/updateSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)删除退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/deleteSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/deleteSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.deleteSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/deleteSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)取消退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/cancelSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/cancelSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.cancelSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/cancelSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (无订单)撤回取消退货单
     * @author 陈刚
     * @date 2019-12-05
     * @throws Exception
     */
    @PostMapping("/sale/saleWaresRetreat/rebackCancelSaleWaresRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelSaleWaresRetreat() throws Exception {
        logger.info("################/sale/saleWaresRetreat/rebackCancelSaleWaresRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleWaresRetreatService.rebackCancelSaleWaresRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleWaresRetreat/rebackCancelSaleWaresRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



