package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
* 说明：vmes_product:产品表Controller
* @author 陈刚 自动生成
* @date 2018-09-21
*/
@RestController
@Slf4j
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @GetMapping("/base/product/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################product/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        Product product = productService.selectById(id);
        model.putResult(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################product/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Product product = (Product)HttpUtils.pageData2Entity(pd, new Product());
        productService.save(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################product/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Product product = (Product)HttpUtils.pageData2Entity(pd, new Product());
        productService.update(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @GetMapping("/base/product/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################product/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        productService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################product/deleteByIds 执行开始 ################# ");
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
            productService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################product/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Product> productList = productService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",productList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################product/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Product> productList = productService.dataList(pd);
        model.putResult(productList);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/listPageProducts")
    public ResultModel listPageProducts() throws Exception {
        logger.info("################product/listPageProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = productService.listPageProducts(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/listPageProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/base/product/listPageProductPropertys")
    public ResultModel listPageProductPropertys() throws Exception {
        logger.info("################product/listPageProductPropertys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = productService.listPageProductPropertys(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/listPageProductPropertys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增产品物料
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/base/product/addProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addProduct() throws Exception {
        logger.info("################/product/addProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = productService.addProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/addProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改产品物料
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/base/product/updateProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateProduct() throws Exception {
        logger.info("################/product/updateProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = productService.updateProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/updateProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改产品物料(禁用)状态
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/base/product/updateDisableProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableProduct() throws Exception {
        logger.info("################/product/updateDisableProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = productService.updateDisableProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/updateDisableProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除产品物料
     * 1. 支持批量删除
     * 2. 删除产品物料属性表(vmes_product_property)
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/base/product/deleteProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteProduct() throws Exception {
        logger.info("################/product/deleteProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = productService.deleteProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/exportExcelProducts")
    public void exportExcelProducts() throws Exception {
        logger.info("################product/exportExcelProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        productService.exportExcelProducts(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/exportExcelProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/base/product/importExcelProducts")
    public ResultModel importExcelProducts(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################product/importExcelProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = productService.importExcelProducts(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/importExcelProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



