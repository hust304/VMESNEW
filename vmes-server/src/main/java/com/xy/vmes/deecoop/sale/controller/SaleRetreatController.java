package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleRetreatService;

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
* 说明：vmes_sale_retreat:退货单 Controller
* @author 陈刚 自动生成
* @date 2019-02-25
*/
@RestController
@Slf4j
public class SaleRetreatController {

    private Logger logger = LoggerFactory.getLogger(SaleRetreatController.class);

    @Autowired
    private SaleRetreatService saleRetreatService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/listPageSaleRetreat")
    public ResultModel listPageSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/listPageSaleOrderReturn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleRetreatService.listPageSaleRetreat(pd, pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/listPageSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增退货单
     * @author 陈刚
     * @date 2019-02-25
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/addSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/addSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.addSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/addSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleRetreat/checkRetreatEdit")
    public ResultModel checkRetreatEdit() throws Exception {
        logger.info("################/sale/saleRetreat/checkRetreatEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.checkRetreatEdit(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/checkRetreatEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/updateSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/updateSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.updateSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/updateSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/deleteSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/deleteSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.deleteSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/deleteSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/cancelSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/cancelSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.cancelSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/cancelSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/submitSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/submitSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.submitSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/submitSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 退回(提交)退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/rebackBySubmitSaleRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackBySubmitSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/rebackBySubmitSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.rebackBySubmitSaleRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/rebackBySubmitSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退款)退货单
     * @author 陈刚
     * @date 2019-03-01
     * @throws Exception
     */
    @PostMapping("/sale/saleRetreat/updateRetreatByMoney")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateRetreatByMoney() throws Exception {
        logger.info("################/sale/saleRetreat/updateRetreatByMoney 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleRetreatService.updateRetreatByMoney(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/updateRetreatByMoney 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/exportExcelSaleRetreat")
    public void exportExcelSaleRetreat() throws Exception {
        logger.info("################/sale/saleRetreat/SaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleRetreatService.exportExcelSaleRetreat(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/SaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-02-25
    */
    @PostMapping("/sale/saleRetreat/importExcelSaleRetreat")
    public ResultModel importExcelSaleRetreat(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleRetreat/importExcelSaleRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleRetreatService.importExcelSaleRetreat(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleRetreat/importExcelSaleRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



