package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.service.SaleUnitPriceService;
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
* 说明：设置锁库时间Controller
* @author 刘威 自动生成
* @date 2018-12-14
*/
@RestController
@Slf4j
public class SaleUnitPriceController {

    private Logger logger = LoggerFactory.getLogger(SaleUnitPriceController.class);

    @Autowired
    private SaleUnitPriceService saleUnitPriceService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @GetMapping("/sale/saleUnitPrice/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleUnitPrice/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleUnitPrice saleUnitPrice = saleUnitPriceService.selectById(id);
        model.putResult(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleUnitPrice/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice)HttpUtils.pageData2Entity(pd, new SaleUnitPrice());
        saleUnitPriceService.save(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleUnitPrice/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice)HttpUtils.pageData2Entity(pd, new SaleUnitPrice());
        saleUnitPriceService.update(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @GetMapping("/sale/saleUnitPrice/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleUnitPrice/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleUnitPriceService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleUnitPrice/deleteByIds 执行开始 ################# ");
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
            saleUnitPriceService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleUnitPrice/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleUnitPrice> saleUnitPriceList = saleUnitPriceService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleUnitPriceList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleUnitPrice/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleUnitPrice> saleUnitPriceList = saleUnitPriceService.dataList(pd);
        model.putResult(saleUnitPriceList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-12-14
     */
    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPricesHis")
    public ResultModel listPageCustomerUnitPricesHis()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleUnitPriceService.listPageCustomerUnitPricesHis(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-12-14
     */
    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPrices")
    public ResultModel listPageCustomerUnitPrices()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleUnitPriceService.listPageCustomerUnitPrices(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/listPageSaleUnitPrices")
    public ResultModel listPageSaleUnitPrices()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleUnitPriceService.listPageSaleUnitPrices(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改客户价格
     * {productId:货品id unit:单位id customerId:客户id productPrice: 货品单价}
     *
     * @author 陈刚
     * @date 2018-12-18
     * @throws Exception
     */
    @PostMapping("/sale/saleUnitPrice/updateSaleUnitPriceByPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleUnitPriceByPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleUnitPriceService.updateSaleUnitPriceByPrice(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取客户货品价格
     * {productId:货品id unit:单位id customerId:客户id }
     *
     * @date 2018-12-18
     */
    @PostMapping("/sale/saleUnitPrice/findSaleUnitPrice")
    public ResultModel findSaleUnitPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/findSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleUnitPriceService.findSaleUnitPriceNew(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/findSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/exportExcelSaleUnitPrices")
    public void exportExcelSaleUnitPrices() throws Exception {
        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        saleUnitPriceService.exportExcelSaleUnitPrices(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/importExcelSaleUnitPrices")
    public ResultModel importExcelSaleUnitPrices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = saleUnitPriceService.importExcelSaleUnitPrices(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



