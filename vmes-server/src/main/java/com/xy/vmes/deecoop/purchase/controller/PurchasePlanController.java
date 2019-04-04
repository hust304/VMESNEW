package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchasePlanService;
import com.xy.vmes.entity.PurchasePlan;

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
* 说明：vmes_purchase_plan:采购计划Controller
* @author 刘威 自动生成
* @date 2019-02-28
*/
@RestController
@Slf4j
public class PurchasePlanController {

    private Logger logger = LoggerFactory.getLogger(PurchasePlanController.class);

    @Autowired
    private PurchasePlanService purchasePlanService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlan/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlan/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchasePlan purchasePlan = purchasePlanService.selectById(id);
        model.putResult(purchasePlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlan/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchasePlan/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlan purchasePlan = (PurchasePlan)HttpUtils.pageData2Entity(pd, new PurchasePlan());
        purchasePlanService.save(purchasePlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlan/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchasePlan/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlan purchasePlan = (PurchasePlan)HttpUtils.pageData2Entity(pd, new PurchasePlan());
        purchasePlanService.update(purchasePlan);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlan/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlan/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchasePlanService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlan/listPagePurchasePlans")
    public ResultModel listPagePurchasePlans()  throws Exception {
        logger.info("################/purchase/purchasePlan/listPagePurchasePlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePlanService.listPagePurchasePlans(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/listPagePurchasePlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchasePlan/addPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addPurchasePlan()  throws Exception {

        logger.info("################/purchase/purchasePlan/addPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.addPurchasePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/addPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchasePlan/editPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel editPurchasePlan()  throws Exception {

        logger.info("################/purchase/purchasePlan/editPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.editPurchasePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/editPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlan/exportExcelPurchasePlans")
    public void exportExcelPurchasePlans() throws Exception {
        logger.info("################/purchase/purchasePlan/exportExcelPurchasePlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchasePlanService.exportExcelPurchasePlans(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/exportExcelPurchasePlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlan/importExcelPurchasePlans")
    public ResultModel importExcelPurchasePlans(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchasePlan/importExcelPurchasePlans 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchasePlanService.importExcelPurchasePlans(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/importExcelPurchasePlans 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/deletePurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deletePurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/deletePurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.deletePurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/deletePurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/recoveryPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/recoveryPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.recoveryPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/recoveryPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/cancelPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/cancelPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.cancelPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/cancelPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/submitPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/submitPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.submitPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/submitPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/auditPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/auditPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.auditPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/auditPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 退回
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/rebackPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/rebackPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.rebackPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/rebackPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增采购计划校验
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlan/checkPurchasePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel checkPurchasePlan() throws Exception {
        logger.info("################/purchase/purchasePlan/checkPurchasePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanService.checkPurchasePlan(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlan/checkPurchasePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



