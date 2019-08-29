package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseSignDetailOnInService;
import com.xy.vmes.service.PurchaseSignDetailService;
import com.xy.vmes.entity.PurchaseSignDetail;

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
* 说明：vmes_purchase_sign_detail:采购签收明细Controller
* @author 刘威 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchaseSignDetailController {

    private Logger logger = LoggerFactory.getLogger(PurchaseSignDetailController.class);

    @Autowired
    private PurchaseSignDetailService purchaseSignDetailService;
    @Autowired
    private PurchaseSignDetailOnInService signDetailOnInService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @GetMapping("/purchase/purchaseSignDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseSignDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchaseSignDetail purchaseSignDetail = purchaseSignDetailService.selectById(id);
        model.putResult(purchaseSignDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchaseSignDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseSignDetail purchaseSignDetail = (PurchaseSignDetail)HttpUtils.pageData2Entity(pd, new PurchaseSignDetail());
        purchaseSignDetailService.save(purchaseSignDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchaseSignDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseSignDetail purchaseSignDetail = (PurchaseSignDetail)HttpUtils.pageData2Entity(pd, new PurchaseSignDetail());
        purchaseSignDetailService.update(purchaseSignDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @GetMapping("/purchase/purchaseSignDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseSignDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchaseSignDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/listPagePurchaseSignDetails")
    public ResultModel listPagePurchaseSignDetails()  throws Exception {
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseSignDetailService.listPagePurchaseSignDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取采购签收单明细-根据入库单id
    @PostMapping("/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn")
    public ResultModel listPagePurchaseSignDetailByIn() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = signDetailOnInService.listPagePurchaseSignDetailByIn(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/listPagePurchaseSignDetailByIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/exportExcelPurchaseSignDetails")
    public void exportExcelPurchaseSignDetails() throws Exception {
        logger.info("################/purchase/purchaseSignDetail/exportExcelPurchaseSignDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchaseSignDetailService.exportExcelPurchaseSignDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/exportExcelPurchaseSignDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSignDetail/importExcelPurchaseSignDetails")
    public ResultModel importExcelPurchaseSignDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseSignDetail/importExcelPurchaseSignDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseSignDetailService.importExcelPurchaseSignDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSignDetail/importExcelPurchaseSignDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



