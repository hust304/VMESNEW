package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseReceiptService;
import com.xy.vmes.entity.PurchaseReceipt;

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
* 说明：vmes_purchase_receipt:应收/应付单Controller
* @author 刘威 自动生成
* @date 2020-04-21
*/
@RestController
@Slf4j
public class PurchaseReceiptController {

    private Logger logger = LoggerFactory.getLogger(PurchaseReceiptController.class);

    @Autowired
    private PurchaseReceiptService purchaseReceiptService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-21
    */
    @GetMapping("/purchase/purchaseReceipt/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseReceipt/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchaseReceipt purchaseReceipt = purchaseReceiptService.selectById(id);
        model.putResult(purchaseReceipt);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-21
    */
    @PostMapping("/purchase/purchaseReceipt/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchaseReceipt/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String companyId = pd.getString("currentCompanyId");
        PurchaseReceipt purchaseReceipt = (PurchaseReceipt)HttpUtils.pageData2Entity(pd, new PurchaseReceipt());
        purchaseReceipt.setCompanyId(companyId);
        purchaseReceiptService.save(purchaseReceipt);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-21
    */
    @PostMapping("/purchase/purchaseReceipt/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchaseReceipt/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseReceipt purchaseReceipt = (PurchaseReceipt)HttpUtils.pageData2Entity(pd, new PurchaseReceipt());
        purchaseReceiptService.update(purchaseReceipt);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-04-21
    */
    @GetMapping("/purchase/purchaseReceipt/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseReceipt/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchaseReceiptService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-21
    */
    @PostMapping("/purchase/purchaseReceipt/listPagePurchaseReceipts")
    public ResultModel listPagePurchaseReceipts()  throws Exception {
        logger.info("################/purchase/purchaseReceipt/listPagePurchaseReceipts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseReceiptService.listPagePurchaseReceipts(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/listPagePurchaseReceipts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-21
    */
    @PostMapping("/purchase/purchaseReceipt/exportExcelPurchaseReceipts")
    public void exportExcelPurchaseReceipts() throws Exception {
        logger.info("################/purchase/purchaseReceipt/exportExcelPurchaseReceipts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        purchaseReceiptService.exportExcelPurchaseReceipts(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/exportExcelPurchaseReceipts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2020-04-21
    */
    @PostMapping("/purchase/purchaseReceipt/importExcelPurchaseReceipts")
    public ResultModel importExcelPurchaseReceipts(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseReceipt/importExcelPurchaseReceipts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseReceiptService.importExcelPurchaseReceipts(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseReceipt/importExcelPurchaseReceipts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



