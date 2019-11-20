package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInService;
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

import java.util.*;

/**
 * 说明：入库派单明细
 * @author 陈刚 自动生成
 * @date 2018-10-16
 */
@RestController
@Slf4j
public class WarehouseInDetailController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDetailController.class);

    @Autowired
    private WarehouseInDetailService warehouseInDetailService;


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouse/warehouseInDetail/listPageWarehouseInDetail")
    public ResultModel listPageWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/listPageWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInDetailService.listPageWarehouseInDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/listPageWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouse/warehouseInDetail/listPageDetailProduct")
    public ResultModel listPageDetailProduct() throws Exception {
        logger.info("################/warehouseInDetail/listPageDetailProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInDetailService.listPageDetailProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/listPageDetailProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDetail/updateWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/updateWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/updateWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDetail/cancelWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/cancelWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInDetailService.cancelWarehouseInDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/cancelWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDetail/recoveryWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/recoveryWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInDetailService.recoveryWarehouseInDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/recoveryWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInDetail/deleteWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInDetailService.deleteWarehouseInDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
