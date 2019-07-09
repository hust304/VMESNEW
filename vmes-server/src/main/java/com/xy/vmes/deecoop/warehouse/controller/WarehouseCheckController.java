package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
* 说明：vmes_warehouse_check:仓库库存盘点Controller
* @author 陈刚 自动生成
* @date 2018-11-13
*/
@RestController
@Slf4j
public class WarehouseCheckController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckController.class);

    @Autowired
    private WarehouseCheckService warehouseCheckService;

    /**
     * @author 陈刚
     * @date 2018-11-13
     */
    @PostMapping("/warehouse/warehouseCheck/listPagewarehouseChecks")
    public ResultModel listPagewarehouseChecks() throws Exception {
        logger.info("################warehouseCheck/listPagewarehouseChecks 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.listPagewarehouseChecks(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheck/listPagewarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheck/addWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/addWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.addWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/addWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheck/cancelWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/cancelWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.cancelWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/cancelWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)退回盘点单(退回整个盘点单)
     * 1. 填写退回原因
     * 2. 盘点明细必须是(<=1:执行中)-允许退回
     * 3. 退回成功后盘点明细状态(0:待派单)
     * 4. 修改盘点明细执行人表(vmes_warehouse_check_executor.isdisable)状态
     *
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheck/rebackWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/rebackWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.rebackWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/rebackWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 删除盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheck/deleteWarehouseCheck")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/deleteWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.deleteWarehouseCheck(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/deleteWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 验证当前登录用户是否含有(仓库盘点审核角色)
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-15
     */
    @PostMapping("/warehouse/warehouseCheck/checkUserRoleByWarehouseAudit")
    public ResultModel checkUserRoleByWarehouseAudit() throws Exception {
        logger.info("################/warehouseCheck/checkUserRoleByWarehouseAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckService.checkUserRoleByWarehouseAudit(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/checkUserRoleByWarehouseAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-13
     */
    @PostMapping("/warehouse/warehouseCheck/exportExcelwarehouseChecks")
    public void exportExcelwarehouseChecks() throws Exception {
        logger.info("################warehouseCheck/exportExcelwarehouseChecks 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseCheckService.exportExcelwarehouseChecks(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheck/exportExcelwarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * Excel导入
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-13
     */
    @PostMapping("/warehouse/warehouseCheck/importExcelwarehouseChecks")
    public ResultModel importExcelwarehouseChecks(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseCheck/importExcelwarehouseChecks 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseCheckService.importExcelwarehouseChecks(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheck/importExcelwarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



