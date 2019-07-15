package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.service.WarehouseInitialBySimpleService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：(简版)仓库初始化设定Controller
 * @author 陈刚 自动生成
 * @date 2018-11-20
 */
@RestController
@Slf4j
public class WarehouseInitialBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInitialBySimpleController.class);

    @Autowired
    private WarehouseInitialBySimpleService warehouseInitialBySimpleService;

    //仓库初始化(简版仓库)
    @PostMapping("/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple")
    public ResultModel findWarehouseInitialBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.findWarehouseInitialBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProductBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.deleteWarehouseProductBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProductBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.updateWarehouseProductBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
