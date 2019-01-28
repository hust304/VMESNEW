package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;



/**
* 说明：vmes_warehouse_initial:仓库初始化设定Controller
* @author 陈刚 自动生成
* @date 2018-11-20
*/
@RestController
@Slf4j
public class WarehouseInitialController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInitialController.class);

    @Autowired
    private WarehouseInitialService warehouseInitialService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/listPageWarehouseInitial")
    public ResultModel listPageWarehouseInitial()  throws Exception {
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInitialService.listPageWarehouseInitial(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 初始化仓库
     *
     * @author 陈刚
     * @date 2018-11-20
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/initialWarehouse")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel initialWarehouse() throws Exception {
        logger.info("################/warehouseInitial/initialWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.initialWarehouse(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/initialWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库货品(库存数量)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/updateWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.updateWarehouseProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除仓库货品(删除库存记录)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/deleteWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.deleteWarehouseProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/exportExcelWarehouseInitial")
    public void exportExcelWarehouseInitial() throws Exception {
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseInitialService.exportExcelWarehouseInitial(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/importExcelWarehouseInitial")
    public ResultModel importExcelWarehouseInitial(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseInitialService.importExcelWarehouseInitial(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



