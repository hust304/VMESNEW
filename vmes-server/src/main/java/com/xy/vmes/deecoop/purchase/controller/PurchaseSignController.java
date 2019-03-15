package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseSignService;
import com.xy.vmes.entity.PurchaseSign;

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
* 说明：vmes_purchase_sign:采购签收Controller
* @author 刘威 自动生成
* @date 2019-03-12
*/
@RestController
@Slf4j
public class PurchaseSignController {

    private Logger logger = LoggerFactory.getLogger(PurchaseSignController.class);

    @Autowired
    private PurchaseSignService purchaseSignService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @GetMapping("/purchase/purchaseSign/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseSign/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchaseSign purchaseSign = purchaseSignService.selectById(id);
        model.putResult(purchaseSign);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchaseSign/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseSign purchaseSign = (PurchaseSign)HttpUtils.pageData2Entity(pd, new PurchaseSign());
        purchaseSignService.save(purchaseSign);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchaseSign/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseSign purchaseSign = (PurchaseSign)HttpUtils.pageData2Entity(pd, new PurchaseSign());
        purchaseSignService.update(purchaseSign);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-12
    */
    @GetMapping("/purchase/purchaseSign/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseSign/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchaseSignService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/listPagePurchaseSigns")
    public ResultModel listPagePurchaseSigns()  throws Exception {
        logger.info("################/purchase/purchaseSign/listPagePurchaseSigns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseSignService.listPagePurchaseSigns(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/listPagePurchaseSigns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/exportExcelPurchaseSigns")
    public void exportExcelPurchaseSigns() throws Exception {
        logger.info("################/purchase/purchaseSign/exportExcelPurchaseSigns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchaseSignService.exportExcelPurchaseSigns(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/exportExcelPurchaseSigns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-12
    */
    @PostMapping("/purchase/purchaseSign/importExcelPurchaseSigns")
    public ResultModel importExcelPurchaseSigns(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseSign/importExcelPurchaseSigns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseSignService.importExcelPurchaseSigns(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseSign/importExcelPurchaseSigns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



