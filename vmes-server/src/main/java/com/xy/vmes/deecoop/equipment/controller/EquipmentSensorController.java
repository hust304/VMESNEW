package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentSensorService;

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
* 说明：vmes_equipment_sensor:设备传感器指标(设备联网)Controller
* @author 陈刚 自动生成
* @date 2019-06-19
*/
@RestController
@Slf4j
public class EquipmentSensorController {
    private Logger logger = LoggerFactory.getLogger(EquipmentSensorController.class);

    @Autowired
    private EquipmentSensorService equipmentSensorService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-06-19
    */
    @PostMapping("/equipment/equipmentSensor/listPageEquipmentSensors")
    public ResultModel listPageEquipmentSensors() throws Exception {
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = equipmentSensorService.listPageEquipmentSensors(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/equipment/equipmentSensor/findAllEquipmentBySensor")
    public ResultModel findAllEquipmentBySensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/findAllEquipmentBySensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = equipmentSensorService.findAllEquipmentBySensor(pd, pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/findAllEquipmentBySensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



