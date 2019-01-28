package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseInExecute;
import com.xy.vmes.entity.WarehouseInExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInExecuteService;
import com.xy.vmes.service.WarehouseInExecutorService;
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
 * 说明：入库派单明细执行
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInExecutorController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInExecutorController.class);


    @Autowired
    private WarehouseInExecutorService warehouseInExecutorService;

    /**
     * 入库单派单明细(vmes_warehouse_in_executor)
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouse/warehouseInExecutor/listPageWarehouseInExecutor")
    public ResultModel listPageWarehouseInExecutor() throws Exception {
        logger.info("################warehouseInExecutor/listPageWarehouseInExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInExecutorService.listPageWarehouseInExecutor(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecutor/listPageWarehouseInExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (入库管理-任务列表)获取入库单执行列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecutor/findListByWarehouseInExecutor")
    public ResultModel findListByWarehouseInExecutor() throws Exception {
        logger.info("################warehouseInExecutor/findListByWarehouseInExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInExecutorService.findListByWarehouseInExecutor(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecutor/findListByWarehouseInExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 修改入库明细执行人
     * @author 陈刚
     * @date 2018-11-01
     */
    @PostMapping("/warehouse/warehouseInExecutor/updateExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateExecutor() throws Exception {
        logger.info("################warehouseInExecutor/updateExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecutorService.updateExecutor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecutor/updateExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
