package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：入库派单明细执行
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDispatchController.class);

    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;

    /**
     * (入库管理-任务列表)获取入库单执行列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/findListWarehouseInExecuteByEdit")
    public ResultModel findListWarehouseInExecuteByEdit() throws Exception {
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInExecuteService.findListWarehouseInExecuteByEdit(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.batchAddWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.rebackWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库执行(入库数量)
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/updateWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.updateWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库执行
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/deleteWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.deleteWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////



    /**
     * (退单)取消入库单执行-(退回整个入库单)
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/updateCancelWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCancelWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.updateCancelWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
