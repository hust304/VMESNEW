package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.WarehouseCheckExecutorService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecutorController.class);

    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;

    /**
     * 盘点执行人列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecutor/listPageWarehouseCheckExecutor")
    public ResultModel listPageWarehouseCheckExecutor() throws Exception {
        logger.info("################/warehouse/warehouseCheckExecutor/listPageWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseCheckExecutorService.listPageWarehouseCheckExecutor(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckExecutor/listPageWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取盘点执行列表-(添加盘点执行对话框)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecutor/findListByWarehouseCheckExecutor")
    public ResultModel findListByWarehouseCheckExecutor() throws Exception {
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseCheckExecutorService.findListByWarehouseCheckExecutor(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加盘点明细执行人 (盘点派单)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckExecutor/addWarehouseCheckExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheckExecutor() throws Exception {
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecutorService.addWarehouseCheckExecutor(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改盘点明细执行人
     * @author 陈刚
     * @date 2018-11-01
     */
    @PostMapping("/warehouse/warehouseCheckExecutor/updateExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateExecutor() throws Exception {
        logger.info("################/warehouse/warehouseCheckExecutor/updateExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckExecutorService.updateExecutor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckExecutor/updateExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



