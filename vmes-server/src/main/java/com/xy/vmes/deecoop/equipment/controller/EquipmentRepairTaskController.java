package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentRepairTaskService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_equipment_repairTask:设备维修任务表Controller
* @author 陈刚 自动生成
* @date 2019-07-01
*/
@RestController
@Slf4j
public class EquipmentRepairTaskController {
    private Logger logger = LoggerFactory.getLogger(EquipmentRepairTaskController.class);

    //@Autowired
    //private EquipmentRepairService equipmentRepairService;
    @Autowired
    private EquipmentRepairTaskService equipmentRepairTaskService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-01
    */
    @PostMapping("/equipment/equipmentRepairTask/listPageEquipmentRepairTask")
    public ResultModel listPageEquipmentRepairTask() throws Exception {
        logger.info("################/equipment/equipmentRepairTask/listPageEquipmentRepairTask 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();

        ResultModel model = equipmentRepairTaskService.listPageEquipmentRepairTask(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTask/listPageEquipmentRepairTask 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



