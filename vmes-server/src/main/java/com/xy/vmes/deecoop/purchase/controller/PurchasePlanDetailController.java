package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePlanDetailService;
import com.xy.vmes.entity.PurchasePlanDetail;

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
* 说明：vmes_purchase_plan_detail:采购计划Controller
* @author 刘威 自动生成
* @date 2019-02-28
*/
@RestController
@Slf4j
public class PurchasePlanDetailController {

    private Logger logger = LoggerFactory.getLogger(PurchasePlanDetailController.class);

    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlanDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchasePlanDetail purchasePlanDetail = purchasePlanDetailService.selectById(id);
        model.putResult(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail)HttpUtils.pageData2Entity(pd, new PurchasePlanDetail());
        purchasePlanDetailService.save(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail)HttpUtils.pageData2Entity(pd, new PurchasePlanDetail());
        purchasePlanDetailService.update(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlanDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchasePlanDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/listPagePurchasePlanDetails")
    public ResultModel listPagePurchasePlanDetails()  throws Exception {
        logger.info("################/purchase/purchasePlanDetail/listPagePurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePlanDetailService.listPagePurchasePlanDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/listPagePurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails")
    public void exportExcelPurchasePlanDetails() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchasePlanDetailService.exportExcelPurchasePlanDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/importExcelPurchasePlanDetails")
    public ResultModel importExcelPurchasePlanDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchasePlanDetail/importExcelPurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchasePlanDetailService.importExcelPurchasePlanDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/importExcelPurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/deletePurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deletePurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/deletePurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.deletePurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/deletePurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/recoveryPurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryPurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/recoveryPurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.recoveryPurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/recoveryPurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/cancelPurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelPurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/cancelPurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.cancelPurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/cancelPurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



