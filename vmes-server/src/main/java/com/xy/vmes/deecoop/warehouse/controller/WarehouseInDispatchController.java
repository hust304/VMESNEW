package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 说明：入库派单
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInDispatchController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDispatchController.class);


    @Autowired
    private WarehouseInService warehouseInService;


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouse/warehouseInDispatch/listPageWarehouseInDetail")
    public ResultModel listPageWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDispatch/listPageWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInService.listPageWarehouseInDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDispatch/listPageWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 入库管理-入库派单
     * 获取全部货位，同时带出该货位存放的货品信息
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn")
    public ResultModel findWarehouseListByWarehouseIn() throws Exception {
        logger.info("################/warehouseInDispatch/findWarehouseListByWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInService.findWarehouseListByWarehouseIn(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDispatch/findWarehouseListByWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 入库派单
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDispatch/updateWarehouseInDispatch")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInDispatch() throws Exception {
        logger.info("################/warehouseInDispatch/updateWarehouseInDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInService.updateWarehouseInDispatch(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDispatch/updateWarehouseInDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
