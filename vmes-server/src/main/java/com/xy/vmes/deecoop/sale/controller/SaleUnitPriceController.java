package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.service.SaleUnitPriceService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleUnitPrice> saleUnitPriceList = saleUnitPriceService.dataList(pd);
        model.putResult(saleUnitPriceList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

//    /**
//     * @author 刘威 自动创建，可以修改
//     * @date 2018-12-14
//     */
//    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPricesHis")
//    public ResultModel listPageCustomerUnitPricesHis()  throws Exception {
//
//        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        ResultModel model = saleUnitPriceService.listPageCustomerUnitPricesHis(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }


//    /**
//     * @author 刘威 自动创建，可以修改
//     * @date 2018-12-14
//     */
//    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPrices")
//    public ResultModel listPageCustomerUnitPrices()  throws Exception {
//
//        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        ResultModel model = saleUnitPriceService.listPageCustomerUnitPrices(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/listPageSaleUnitPrices")
    public ResultModel listPageSaleUnitPrices()  throws Exception {
        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleUnitPriceService.listPageSaleUnitPrices(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

//    /**
//     * 修改客户价格
//     * {productId:货品id unit:单位id customerId:客户id productPrice: 货品单价}
//     *
//     * @author 陈刚
//     * @date 2018-12-18
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleUnitPrice/updateSaleUnitPriceByPrice")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel updateSaleUnitPriceByPrice() throws Exception {
//        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pageData = HttpUtils.parsePageData();
//        ResultModel model = saleUnitPriceService.updateSaleUnitPriceByPrice(pageData);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    //修改客户货品单价
    @PostMapping("/sale/saleUnitPrice/updateSaleUnitPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleUnitPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户货品单价id为空或空字符串");
            return model;
        }

        String productPriceStr = pageData.getString("productPrice");
        if (productPriceStr == null || productPriceStr.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户单价为必填项不可为空！");
            return model;
        }

        String remark = new String();
        if (pageData.getString("remark") != null) {
            remark = pageData.getString("remark").trim();
        }

        BigDecimal productPrice = BigDecimal.valueOf(0D);
        try {
            productPrice = new BigDecimal(productPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //四舍五入到2位小数
        productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        SaleUnitPrice editObject = new SaleUnitPrice();
        editObject.setId(id);
        editObject.setProductPrice(productPrice);
        editObject.setRemark(remark);
        saleUnitPriceService.update(editObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //添加客户货品单价
    @PostMapping("/sale/saleUnitPrice/addSaleUnitPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleUnitPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/addSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户id为空或空字符串");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                SaleUnitPrice addObject = new SaleUnitPrice();

                addObject.setCuser(cuser);
                addObject.setUuser(cuser);
                addObject.setCustomerId(customerId);

                String productId = mapObject.get("productId");
                addObject.setProductId(productId);

                String unit = mapObject.get("unit");
                addObject.setUnit(unit);

                String remark = mapObject.get("remark");
                addObject.setRemark(remark);

                BigDecimal productPrice = BigDecimal.valueOf(0D);
                String productPriceStr = mapObject.get("productPrice");
                if (productPriceStr != null && productPriceStr.trim().length() > 0) {
                    try {
                        productPrice = new BigDecimal(productPriceStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addObject.setProductPrice(productPrice);

                //(客户id,货品id,单位id)查询(vmes_sale_unit_price) 是否存在
                PageData findMap = new PageData();
                findMap.put("productId", productId);
                findMap.put("unit", unit);
                findMap.put("customerId", customerId);
                SaleUnitPrice objectDB = saleUnitPriceService.findSaleUnitPrice(findMap);

                if (objectDB == null) {
                    saleUnitPriceService.save(addObject);
                } else {
                    SaleUnitPrice editObject = new SaleUnitPrice();
                    editObject.setId(objectDB.getId());
                    editObject.setUuser(cuser);
                    editObject.setProductPrice(productPrice);
                    editObject.setRemark(remark);
                    saleUnitPriceService.update(editObject);
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/addSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //删除客户货品单价-(根据id)支持多行删除
    @PostMapping("/sale/saleUnitPrice/deleteSaleUnitPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleUnitPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/deleteSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        ids = StringUtil.stringTrimSpace(ids);
        String[] idArry = ids.split(",");

        if (idArry != null && idArry.length > 0) {
            saleUnitPriceService.deleteByIds(idArry);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/deleteSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//    * Excel导出
//    * @author 刘威 自动创建，可以修改
//    * @date 2018-12-14
//    */
//    @PostMapping("/sale/saleUnitPrice/exportExcelSaleUnitPrices")
//    public void exportExcelSaleUnitPrices() throws Exception {
//        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        saleUnitPriceService.exportExcelSaleUnitPrices(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

    /**
    * 客户货品价格 Excel导入
    *
    * @author 陈刚
    * @date 2019-10-25
    */
    @PostMapping("/sale/saleUnitPrice/importExcelSaleUnitPrice")
    public ResultModel importExcelSaleUnitPrice(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        HttpServletRequest httpRequest = HttpUtils.currentRequest();

        String companyId = httpRequest.getParameter("companyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        model = saleUnitPriceService.importExcelSaleUnitPrice(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}

