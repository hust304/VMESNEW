package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentRepairTaskDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* 说明：vmes_equipment_repairTask_detail:设备维修任务明细表Controller
* @author 陈刚 自动生成
* @date 2019-07-01
*/
@RestController
@Slf4j
public class EquipmentRepairTaskDetailController {
    private Logger logger = LoggerFactory.getLogger(EquipmentRepairTaskDetailController.class);

    @Autowired
    private EquipmentRepairTaskDetailService equipmentRepairTaskDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-01
    */
    @PostMapping("/equipment/equipmentRepairTaskDetail/listPageEquipmentRepairTaskDetails")
    public ResultModel listPageEquipmentRepairTaskDetails() throws Exception {
        logger.info("################/equipment/equipmentRepairTaskDetail/listPageEquipmentRepairTaskDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = equipmentRepairTaskDetailService.listPageEquipmentRepairTaskDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTaskDetail/listPageEquipmentRepairTaskDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



