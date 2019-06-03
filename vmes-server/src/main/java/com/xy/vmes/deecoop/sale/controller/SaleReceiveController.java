package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceive;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;



/**
* 说明：收款单Controller
* @author 刘威 自动生成
* @date 2019-01-10
*/
@RestController
@Slf4j
public class SaleReceiveController {

    private Logger logger = LoggerFactory.getLogger(SaleReceiveController.class);

    @Autowired
    private SaleReceiveService saleReceiveService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/sale/saleReceive/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceive/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        SaleReceive saleReceive = saleReceiveService.selectById(id);
        model.putResult(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleReceive/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceive saleReceive = (SaleReceive)HttpUtils.pageData2Entity(pd, new SaleReceive());
        saleReceiveService.save(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleReceive/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceive saleReceive = (SaleReceive)HttpUtils.pageData2Entity(pd, new SaleReceive());
        saleReceiveService.update(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/sale/saleReceive/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceive/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        saleReceiveService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleReceive/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            saleReceiveService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleReceive/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleReceive> saleReceiveList = saleReceiveService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleReceiveList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleReceive/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleReceive> saleReceiveList = saleReceiveService.dataList(pd);
        model.putResult(saleReceiveList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-12-24
     */
    @PostMapping("/sale/saleReceive/saveSaleReceiveAndDetail")
    @Transactional(rollbackFor=Exception.class)
    //注解为事务范围的方法中，事务的回滚仅仅对于unchecked的异常有效。对于checked异常无效。也就是说事务回滚仅仅发生在出现RuntimeException或Error的时候。如果希望一般的异常也能触发事务回滚，需要在注解了@Transactional的方法上，将@Transactional回滚参数设为：@Transactional(rollbackFor=Exception.class)
    public ResultModel saveSaleReceiveAndDetail()  throws Exception {

        logger.info("################/sale/saleReceive/saveSaleReceiveAndDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleReceiveService.saveSaleReceiveAndDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/saveSaleReceiveAndDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceive/listPageSaleReceives")
    public ResultModel listPageSaleReceives()  throws Exception {
        logger.info("################/sale/saleReceive/listPageSaleReceives 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleReceiveService.listPageSaleReceives(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/listPageSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleReceive/auditPassSaleReceive")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassSaleReceive() throws Exception {
        logger.info("################/sale/saleReceive/auditPassSaleReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleReceiveService.auditPassSaleReceive(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/auditPassSaleReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleReceive/auditDisagreeSaleReceive")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeSaleReceive() throws Exception {
        logger.info("################/sale/saleReceive/auditDisagreeSaleReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String parentId = pd.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("收款单id为空或空字符串！");
            return model;
        }

        String remark = pd.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("不通过原因为空或空字符串！");
            return model;
        }

        SaleReceive editReceive = new SaleReceive();
        editReceive.setId(parentId);
        editReceive.setRemark(remark);
        saleReceiveService.update(editReceive);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceive/auditDisagreeSaleReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//    * Excel导出
//    * @author 刘威 自动创建，可以修改
//    * @date 2019-01-10
//    */
//    @PostMapping("/sale/saleReceive/exportExcelSaleReceives")
//    public void exportExcelSaleReceives() throws Exception {
//        logger.info("################/sale/saleReceive/exportExcelSaleReceives 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        saleReceiveService.exportExcelSaleReceives(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleReceive/exportExcelSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }
//
//    /**
//    * Excel导入
//    *
//    * @author 刘威 自动创建，可以修改
//    * @date 2019-01-10
//    */
//    @PostMapping("/sale/saleReceive/importExcelSaleReceives")
//    public ResultModel importExcelSaleReceives(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
//        logger.info("################/sale/saleReceive/importExcelSaleReceives 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = saleReceiveService.importExcelSaleReceives(file);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleReceive/importExcelSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

}



