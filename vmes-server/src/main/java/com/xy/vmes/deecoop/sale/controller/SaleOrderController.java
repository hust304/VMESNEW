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
    @Autowired
    private SaleOrderByPurchasePlanService saleOrderByPurchasePlanService;

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
        ResultModel model = saleOrderService.listPageSaleOrder(pd);
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
     * 销售订单查询
     * 采购-采购计划管理-弹出界面查询
     * @date 2020-01-20
     */
    @PostMapping("/sale/saleOrder/listPageOrderByPurchasePlan")
    public ResultModel listPageOrderByPurchasePlan() throws Exception {
        logger.info("################/sale/saleOrder/listPageOrderByPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderByPurchasePlanService.listPageOrderByPurchasePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/listPageOrderByPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单详情: vmes_sale_order 订单汇总
     * @date 2019-02-13
     */
    @PostMapping("/sale/saleOrder/getSaleOrderCollectByOrderId")
    public ResultModel getSaleOrderCollectByOrderId() throws Exception {
        logger.info("################/sale/saleOrder/getSaleOrderCollectByOrderId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleOrderCollectService.getSaleOrderCollectByOrderId(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/getSaleOrderCollectByOrderId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
     * 修改订单-订单明细(产品锁定库存数量)
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/updateSaleOrderByLockCount")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrderByLockCount() throws Exception {
        logger.info("################/sale/saleOrder/updateSaleOrderByLockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.updateSaleOrderByLockCount(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/updateSaleOrderByLockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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


    @PostMapping("/sale/saleOrder/recoverySaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoverySaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/recoverySaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.recoverySaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/recoverySaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
        logger.info("################/sale/saleOrder/submitSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.submitSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/submitSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 退回订单
     * @author 陈刚
     * @date 2018-12-11
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/rebackSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/rebackSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.rebackSaleOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/rebackSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//2019-09-02 订单变更功能(按订单维度变更)方法注销：
//    /**
//     * 变更订单-变更订单明细(订购数量,锁定货品数量)
//     * @author 陈刚
//     * @date 2019-03-05
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleOrder/updateSaleOrderByChange")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel updateSaleOrderByChange() throws Exception {
//        logger.info("################/sale/saleOrder/updateSaleOrderByChange 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pageData = HttpUtils.parsePageData();
//        ResultModel model = saleOrderByChangeService.updateSaleOrderByChange(pageData);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleOrder/updateSaleOrderByChange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    @PostMapping("/sale/saleOrder/addCustomerBalance")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addCustomerBalance()  throws Exception {
        logger.info("################/sale/saleOrder/addCustomerBalance 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.addCustomerBalance(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/addCustomerBalance 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/sale/saleOrder/updateCustomerBalance")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCustomerBalance()  throws Exception {
        logger.info("################/sale/saleOrder/updateCustomerBalance 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderService.updateCustomerBalancee(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/updateCustomerBalance 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-05
     */
    @PostMapping("/sale/saleOrder/exportExcelSaleOrder")
    public void exportExcelSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/exportExcelSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        saleOrderService.exportExcelSaleOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/exportExcelSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

}



