package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.WarehouseCheckDetailService;
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
* 说明：vmes_warehouse_check_detail:仓库库存盘点明细Controller
* @author 陈刚 自动生成
* @date 2018-11-13
*/
@RestController
@Slf4j
public class WarehouseCheckDetailController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckDetailController.class);

    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;


    /**
     * @author 陈刚
     * @date 2018-11-13
     */
    @PostMapping("/warehouse/warehouseCheckDetail/listPageWarehouseCheckDetails")
    public ResultModel listPageWarehouseCheckDetails() throws Exception {
        logger.info("################warehouseCheckDetail/listPageWarehouseCheckDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckDetailService.listPageWarehouseCheckDetails(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckDetail/listPageWarehouseCheckDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消盘点单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckDetail/cancelWarehouseCheckDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseCheckDetail() throws Exception {
        logger.info("################/warehouseCheckDetail/cancelWarehouseCheckDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckDetailService.cancelWarehouseCheckDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckDetail/cancelWarehouseCheckDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除盘点单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckDetail/deleteWarehouseCheckDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseCheckDetail() throws Exception {
        logger.info("################/warehouseCheckDetail/deleteWarehouseCheckDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseCheckDetailService.deleteWarehouseCheckDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckDetail/deleteWarehouseCheckDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



