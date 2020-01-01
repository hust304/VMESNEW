package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseOrderDetailByRetreatService;
import com.xy.vmes.service.PurchaseOrderDetailQueryBySignService;
import com.xy.vmes.service.PurchaseOrderDetailService;
import com.xy.vmes.entity.PurchaseOrderDetail;

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
import org.springframework.web.multipart.MultipartFile;

/**
* 说明：vmes_purchase_order_detail:采购订单明细Controller
* @author 刘威 自动生成
* @date 2019-03-05
*/
@RestController
@Slf4j
public class PurchaseOrderDetailController {
    private Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailController.class);

    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;
    @Autowired
    private PurchaseOrderDetailQueryBySignService orderDetailQueryBySignService;

    @Autowired
    private PurchaseOrderDetailByRetreatService purchaseOrderDetailByRetreatService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @GetMapping("/purchase/purchaseOrderDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseOrderDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchaseOrderDetail purchaseOrderDetail = purchaseOrderDetailService.selectById(id);
        model.putResult(purchaseOrderDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrderDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchaseOrderDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseOrderDetail purchaseOrderDetail = (PurchaseOrderDetail)HttpUtils.pageData2Entity(pd, new PurchaseOrderDetail());
        purchaseOrderDetailService.save(purchaseOrderDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrderDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchaseOrderDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseOrderDetail purchaseOrderDetail = (PurchaseOrderDetail)HttpUtils.pageData2Entity(pd, new PurchaseOrderDetail());
        purchaseOrderDetailService.update(purchaseOrderDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @GetMapping("/purchase/purchaseOrderDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseOrderDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchaseOrderDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrderDetail/listPagePurchaseOrderDetails")
    public ResultModel listPagePurchaseOrderDetails()  throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/listPagePurchaseOrderDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseOrderDetailService.listPagePurchaseOrderDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/listPagePurchaseOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/purchase/purchaseOrderDetail/listPageOrderDetailByRetreat")
    public ResultModel listPageOrderDetailByRetreat()  throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/listPageOrderDetailByRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderDetailByRetreatService.listPageOrderDetailByRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/listPageOrderDetailByRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrderDetail/exportExcelPurchaseOrderDetails")
    public void exportExcelPurchaseOrderDetails() throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/exportExcelPurchaseOrderDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchaseOrderDetailService.exportExcelPurchaseOrderDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/exportExcelPurchaseOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrderDetail/importExcelPurchaseOrderDetails")
    public ResultModel importExcelPurchaseOrderDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseOrderDetail/importExcelPurchaseOrderDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseOrderDetailService.importExcelPurchaseOrderDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/importExcelPurchaseOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrderDetail/deletePurchaseOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deletePurchaseOrderDetail() throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/deletePurchaseOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderDetailService.deletePurchaseOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/deletePurchaseOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrderDetail/recoveryPurchaseOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryPurchaseOrderDetail() throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/recoveryPurchaseOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderDetailService.recoveryPurchaseOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/recoveryPurchaseOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrderDetail/cancelPurchaseOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelPurchaseOrderDetail() throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/cancelPurchaseOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderDetailService.cancelPurchaseOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/cancelPurchaseOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////
    @PostMapping("/purchase/purchaseOrderDetail/listPageOrderDetailQueryBySign")
    public ResultModel listPageOrderDetailQueryBySign() throws Exception {
        logger.info("################/purchase/purchaseOrderDetail/listPageOrderDetailQueryBySign 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderDetailQueryBySignService.listPageOrderDetailQueryBySign(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrderDetail/listPageOrderDetailQueryBySign 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



