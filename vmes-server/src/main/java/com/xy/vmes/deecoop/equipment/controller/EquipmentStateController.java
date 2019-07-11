package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentStateService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EquipmentStateController {
    private Logger logger = LoggerFactory.getLogger(EquipmentStateController.class);

    @Autowired
    private EquipmentStateService equipmentStateService;

    //获取设备信息状态综合查询
    @PostMapping("/equipment/equipmentStatus/findEquipmentState")
    public ResultModel findEquipmentState() throws Exception {
        logger.info("################/equipment/equipmentStatus/findEquipmentState 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentStateService.findEquipmentState(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentStatus/findEquipmentState 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
