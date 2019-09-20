package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.service.SaleReceiveRecordService;
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
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：收款记录Controller
* @author 刘威 自动生成
* @date 2018-12-25
*/
@RestController
@Slf4j
public class SaleReceiveRecordController {

    private Logger logger = LoggerFactory.getLogger(SaleReceiveRecordController.class);

    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @GetMapping("/sale/saleReceiveRecord/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveRecord/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        SaleReceiveRecord saleReceiveRecord = saleReceiveRecordService.selectById(id);
        model.putResult(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveRecord saleReceiveRecord = (SaleReceiveRecord)HttpUtils.pageData2Entity(pd, new SaleReceiveRecord());
        saleReceiveRecordService.save(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveRecord saleReceiveRecord = (SaleReceiveRecord)HttpUtils.pageData2Entity(pd, new SaleReceiveRecord());
        saleReceiveRecordService.update(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @GetMapping("/sale/saleReceiveRecord/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveRecord/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        saleReceiveRecordService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/deleteByIds 执行开始 ################# ");
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
            saleReceiveRecordService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleReceiveRecord> saleReceiveRecordList = saleReceiveRecordService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleReceiveRecordList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleReceiveRecord> saleReceiveRecordList = saleReceiveRecordService.dataList(pd);
        model.putResult(saleReceiveRecordList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/listPageSaleReceiveRecords")
    public ResultModel listPageSaleReceiveRecords()  throws Exception {
        logger.info("################/sale/saleReceiveRecord/listPageSaleReceiveRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleReceiveRecordService.listPageSaleReceiveRecords(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/listPageSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/exportExcelSaleReceiveRecords")
    public void exportExcelSaleReceiveRecords() throws Exception {
        logger.info("################/sale/saleReceiveRecord/exportExcelSaleReceiveRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleReceiveRecordService.exportExcelSaleReceiveRecords(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/exportExcelSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/importExcelSaleReceiveRecords")
    public ResultModel importExcelSaleReceiveRecords(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleReceiveRecord/importExcelSaleReceiveRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleReceiveRecordService.importExcelSaleReceiveRecords(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/importExcelSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



