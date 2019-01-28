package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleReceiveDetailService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
import java.util.*;



/**
* 说明：收款明细Controller
* @author 刘威 自动生成
* @date 2019-01-10
*/
@RestController
@Slf4j
public class SaleReceiveDetailController {

    private Logger logger = LoggerFactory.getLogger(SaleReceiveDetailController.class);

    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/sale/saleReceiveDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleReceiveDetail saleReceiveDetail = saleReceiveDetailService.selectById(id);
        model.putResult(saleReceiveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleReceiveDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveDetail saleReceiveDetail = (SaleReceiveDetail)HttpUtils.pageData2Entity(pd, new SaleReceiveDetail());
        saleReceiveDetailService.save(saleReceiveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleReceiveDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveDetail saleReceiveDetail = (SaleReceiveDetail)HttpUtils.pageData2Entity(pd, new SaleReceiveDetail());
        saleReceiveDetailService.update(saleReceiveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/sale/saleReceiveDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleReceiveDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleReceiveDetail/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
            saleReceiveDetailService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleReceiveDetail/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleReceiveDetail> saleReceiveDetailList = saleReceiveDetailService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleReceiveDetailList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleReceiveDetail/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleReceiveDetail> saleReceiveDetailList = saleReceiveDetailService.dataList(pd);
        model.putResult(saleReceiveDetailList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * @author 刘威 自动创建，可以修改
     * @date 2019-01-10
     */
    @PostMapping("/sale/saleReceiveDetail/listPageOrderReceiveDetail")
    public ResultModel listPageOrderReceiveDetail()  throws Exception {
        logger.info("################/sale/saleReceiveDetail/listPageOrderReceiveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleReceiveDetailService.listPageOrderReceiveDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/listPageOrderReceiveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/listPageSaleReceiveDetails")
    public ResultModel listPageSaleReceiveDetails()  throws Exception {
        logger.info("################/sale/saleReceiveDetail/listPageSaleReceiveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleReceiveDetailService.listPageSaleReceiveDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/listPageSaleReceiveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/exportExcelSaleReceiveDetails")
    public void exportExcelSaleReceiveDetails() throws Exception {
        logger.info("################/sale/saleReceiveDetail/exportExcelSaleReceiveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleReceiveDetailService.exportExcelSaleReceiveDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/exportExcelSaleReceiveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/sale/saleReceiveDetail/importExcelSaleReceiveDetails")
    public ResultModel importExcelSaleReceiveDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleReceiveDetail/importExcelSaleReceiveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleReceiveDetailService.importExcelSaleReceiveDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveDetail/importExcelSaleReceiveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



