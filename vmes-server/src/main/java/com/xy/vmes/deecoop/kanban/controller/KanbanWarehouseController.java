package com.xy.vmes.deecoop.kanban.controller;

import com.xy.vmes.service.KanbanWarehouseService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
* 说明：vmes_kanban_visualization:销售开票Controller
* @author 刘威 自动生成
* @date 2020-01-06
*/
@RestController
@Slf4j
public class KanbanWarehouseController {

    private Logger logger = LoggerFactory.getLogger(KanbanWarehouseController.class);

    @Autowired
    private KanbanWarehouseService kanbanWarehouseService;


    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-01-06
    */
    @PostMapping("/kanban/warehouse/getWarehouseTotalKanban")
    public ResultModel getWarehouseTotalKanban()  throws Exception {
        logger.info("################/kanban/warehouse/getWarehouseTotalKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = kanbanWarehouseService.getWarehouseTotalKanban(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/warehouse/getWarehouseTotalKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2020-01-06
     */
    @PostMapping("/kanban/warehouse/listWarehouseDetailKanban")
    public ResultModel listWarehouseDetailKanban()  throws Exception {
        logger.info("################/kanban/warehouse/listWarehouseDetailKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = kanbanWarehouseService.listWarehouseDetailKanban(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/warehouse/listWarehouseDetailKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



