package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentMaintainTaskDetailService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_equipment_maintainTask_detail:设备保养任务明细表Controller
* @author 陈刚 自动生成
* @date 2019-07-29
*/
@RestController
@Slf4j
public class EquipmentMaintainTaskDetailController {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainTaskDetailController.class);

    @Autowired
    private EquipmentMaintainTaskDetailService equipmentMaintainTaskDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-29
    */
    @PostMapping("/equipment/equipmentMaintainTaskDetail/listPageEquipmentMaintainTaskDetail")
    public ResultModel listPageEquipmentMaintainTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageEquipmentMaintainTaskDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentMaintainTaskDetailService.listPageEquipmentMaintainTaskDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageEquipmentMaintainTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



