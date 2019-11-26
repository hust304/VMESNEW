package com.xy.vmes.deecoop.finance.controller;

import com.xy.vmes.service.FinanceBillService;
import com.xy.vmes.entity.FinanceBill;

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
* 说明：vmes_finance_bill:应收/应付单Controller
* @author 刘威 自动生成
* @date 2019-11-07
*/
@RestController
@Slf4j
public class FinanceBillController {

    private Logger logger = LoggerFactory.getLogger(FinanceBillController.class);

    @Autowired
    private FinanceBillService financeBillService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-07
    */
    @GetMapping("/finance/financeBill/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeBill/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        FinanceBill financeBill = financeBillService.selectById(id);
        model.putResult(financeBill);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-07
    */
    @PostMapping("/finance/financeBill/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/finance/financeBill/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceBill financeBill = (FinanceBill)HttpUtils.pageData2Entity(pd, new FinanceBill());
        financeBillService.save(financeBill);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-07
    */
    @PostMapping("/finance/financeBill/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/finance/financeBill/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        FinanceBill financeBill = (FinanceBill)HttpUtils.pageData2Entity(pd, new FinanceBill());
        financeBillService.update(financeBill);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-11-07
    */
    @GetMapping("/finance/financeBill/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/finance/financeBill/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        financeBillService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-07
    */
    @PostMapping("/finance/financeBill/listPageFinanceBills")
    public ResultModel listPageFinanceBills()  throws Exception {
        logger.info("################/finance/financeBill/listPageFinanceBills 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.listPageFinanceBills(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/listPageFinanceBills 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-07
    */
    @PostMapping("/finance/financeBill/exportExcelFinanceBills")
    public void exportExcelFinanceBills() throws Exception {
        logger.info("################/finance/financeBill/exportExcelFinanceBills 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        financeBillService.exportExcelFinanceBills(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/exportExcelFinanceBills 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-11-07
    */
    @PostMapping("/finance/financeBill/importExcelFinanceBills")
    public ResultModel importExcelFinanceBills(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/finance/financeBill/importExcelFinanceBills 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = financeBillService.importExcelFinanceBills(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/importExcelFinanceBills 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/batchAddFinanceBill")
    public ResultModel batchAddFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/batchAddFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.batchAddFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/batchAddFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/deleteFinanceBill")
    public ResultModel deleteFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/deleteFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.deleteFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/deleteFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/cancelFinanceBill")
    public ResultModel cancelFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/cancelFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.cancelFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/cancelFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/recoverFinanceBill")
    public ResultModel recoverFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/recoverFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.recoverFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/recoverFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/submitFinanceBill")
    public ResultModel submitFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/submitFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.submitFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/submitFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/rebackFinanceBill")
    public ResultModel rebackFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/rebackFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.rebackFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/rebackFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/eidtFinanceBill")
    public ResultModel eidtFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/eidtFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.eidtFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/eidtFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/comfirmFinanceBill")
    public ResultModel comfirmFinanceBill()  throws Exception {
        logger.info("################/finance/financeBill/comfirmFinanceBill 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.comfirmFinanceBill(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/comfirmFinanceBill 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/getFinanceReceiveView")
    public ResultModel getFinanceReceiveView()  throws Exception {
        logger.info("################/finance/financeBill/getFinanceReceiveView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.getFinanceReceiveView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/getFinanceReceiveView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/getFinanceBillDetail")
    public ResultModel getFinanceBillDetail()  throws Exception {
        logger.info("################/finance/financeBill/getFinanceBillDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.getFinanceBillDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/getFinanceBillDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/unCheckOutFinanceReceive")
    public ResultModel unCheckOutFinanceReceive()  throws Exception {
        logger.info("################/finance/financeBill/unCheckOutFinanceReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.unCheckOutFinanceReceive(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/unCheckOutFinanceReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-11-07
     */
    @PostMapping("/finance/financeBill/checkOutFinanceReceive")
    public ResultModel checkOutFinanceReceive()  throws Exception {
        logger.info("################/finance/financeBill/checkOutFinanceReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = financeBillService.checkOutFinanceReceive(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/finance/financeBill/checkOutFinanceReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




}



