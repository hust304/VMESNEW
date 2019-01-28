package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.ProductService;
import com.xy.vmes.service.WarehouseProductService;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;



/**
* 说明：出库明细Controller
* @author 刘威 自动生成
* @date 2018-10-31
*/
@RestController
@Slf4j
public class WarehouseProductController {

    private Logger logger = LoggerFactory.getLogger(WarehouseProductController.class);

    @Autowired
    private WarehouseProductService warehouseProductService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseProduct/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseProduct warehouseProduct = (WarehouseProduct)HttpUtils.pageData2Entity(pd, new WarehouseProduct());
        warehouseProductService.save(warehouseProduct);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseProduct/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseProduct warehouseProduct = (WarehouseProduct)HttpUtils.pageData2Entity(pd, new WarehouseProduct());
        warehouseProductService.update(warehouseProduct);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @GetMapping("/warehouse/warehouseProduct/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseProduct/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseProductService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseProduct/deleteByIds 执行开始 ################# ");
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
            warehouseProductService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseProduct/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseProduct> warehouseProductList = warehouseProductService.dataList(pd);
        model.putResult(warehouseProductList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/







    /**
     * @author 刘威
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/updateWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProduct()  throws Exception {
        logger.info("################warehouseProduct/updateWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.updateWarehouseProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/updateWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductView")
    public ResultModel listPageWarehouseProductView()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductView(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductMove")
    public ResultModel listPageWarehouseProductMove()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductMove 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductMove(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductMove 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseDetailView")
    public ResultModel listPageWarehouseDetailView()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseDetailView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseDetailView(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseDetailView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductsDispatch")
    public ResultModel listPageWarehouseProductsDispatch()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductsDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductsDispatch(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductsDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductsDispatchOption")
    public ResultModel listPageWarehouseProductsDispatchOption()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOption 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductsDispatchOption(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOption 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/exportExcelWarehouseProducts")
    public void exportExcelWarehouseProducts() throws Exception {
        logger.info("################warehouseProduct/exportExcelWarehouseProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseProductService.exportExcelWarehouseProducts(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/exportExcelWarehouseProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/importExcelWarehouseProducts")
    public ResultModel importExcelWarehouseProducts(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseProduct/importExcelWarehouseProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseProductService.importExcelWarehouseProducts(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/importExcelWarehouseProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



