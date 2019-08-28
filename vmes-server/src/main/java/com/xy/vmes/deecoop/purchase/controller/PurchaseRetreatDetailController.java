package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseRetreatDetailOnOutService;
import com.xy.vmes.service.PurchaseRetreatDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_purchase_retreat_detail:退货明细Controller
* @author 陈刚 自动生成
* @date 2019-05-09
*/
@RestController
@Slf4j
public class PurchaseRetreatDetailController {

    private Logger logger = LoggerFactory.getLogger(PurchaseRetreatDetailController.class);

    @Autowired
    private PurchaseRetreatDetailService purchaseRetreatDetailService;
    @Autowired
    private PurchaseRetreatDetailOnOutService retreatDetailOnOutService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-05-09
    */
    @PostMapping("/purchase/purchaseRetreatDetail/listPageRetreatDetail")
    public ResultModel listPageRetreatDetail() throws Exception {
        logger.info("################/purchase/purchaseRetreatDetail/listPageRetreatDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseRetreatDetailService.listPageRetreatDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreatDetail/listPageRetreatDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取采购退货单明细信息-根据出库单信息(出库单id)
     * @return
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseRetreatDetail/listPageRetreatDetailByOut")
    public ResultModel listPageRetreatDetailByOut() throws Exception {
        logger.info("################/purchase/purchaseRetreatDetail/listPageRetreatDetailByOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatDetailOnOutService.listPageRetreatDetailByOut(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreatDetail/listPageRetreatDetailByOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



