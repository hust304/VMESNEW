package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
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
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecuteController.class);


    @Autowired
    private WarehouseCheckExecuteService warehouseCheckExecuteService;


    /**
     * 获取盘点执行列表-(盘点审核列表)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/findListByWarehouseCheckExecute")
    public ResultModel findListByWarehouseCheckExecute() throws Exception {
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseCheckExecuteService.findListByWarehouseCheckExecute(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/addWarehouseCheckExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecuteService.addWarehouseCheckExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)退回盘点明细(退回单个盘点明细)
     * 1. 填写退回原因
     * 2. 盘点明细必须是(1:执行中)-允许退回
     * 3. 退回成功后盘点明细状态(0:待派单)
     * 4. 修改盘点明细执行人表(vmes_warehouse_check_executor.isdisable)状态
     *
     * rebackDetailJsonStr
     * {id:"",parentId:"",state:""}
     *
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/rebackWarehouseCheckByDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseCheckByDetail() throws Exception {
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecuteService.rebackWarehouseCheckByDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回盘点明细(撤回单个盘点明细)
     * 1. 盘点明细必须是(2:审核中)- and 无审批记录 - 允许撤回条件(盘点明细已经提交审核 and 无审批记录)
     * 2. 删除盘点明细执行表
     * 3. 退回成功后盘点明细状态(1:执行中)
     *
     * cancelAuditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/cancelAuditWarehouseCheckByExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAuditWarehouseCheckByExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/cancelAuditWarehouseCheckByExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecuteService.cancelAuditWarehouseCheckByExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    ///////////////////////////////////////////////////////////////////
    /**
     * 审核同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/auditPassWarehouseCheckExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/auditPassWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecuteService.auditPassWarehouseCheckExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/auditPassWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecuteService.auditDisagreeWarehouseCheckExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////






}



