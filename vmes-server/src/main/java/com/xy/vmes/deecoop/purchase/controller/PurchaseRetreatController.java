package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseRetreatService;

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


/**
* 说明：vmes_purchase_retreat:退货单Controller
* @author 陈刚 自动生成
* @date 2019-05-09
*/
@RestController
@Slf4j
public class PurchaseRetreatController {

    private Logger logger = LoggerFactory.getLogger(PurchaseRetreatController.class);

    @Autowired
    private PurchaseRetreatService purchaseRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-05-09
    */
    @PostMapping("/purchase/purchaseRetreat/listPageRetreat")
    public ResultModel listPageRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/listPageRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseRetreatService.listPageRetreat(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/listPageRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增退货单
     * @author 陈刚
     * @date 2019-02-25
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseRetreat/addPurchaseRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addPurchaseRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/addPurchaseRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseRetreatService.addPurchaseRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/addPurchaseRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



