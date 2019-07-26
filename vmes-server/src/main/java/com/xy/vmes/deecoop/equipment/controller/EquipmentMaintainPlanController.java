package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentMaintainPlanService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_equipment_maintain_plan:设备保养计划Controller
* @author 陈刚 自动生成
* @date 2019-07-25
*/
@RestController
@Slf4j
public class EquipmentMaintainPlanController {

    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainPlanController.class);

    @Autowired
    private EquipmentMaintainPlanService equipmentMaintainPlanService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-25
    */
    @PostMapping("/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan")
    public ResultModel listPageEquipmentMaintainPlans() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentMaintainPlanService.listPageEquipmentMaintainPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



