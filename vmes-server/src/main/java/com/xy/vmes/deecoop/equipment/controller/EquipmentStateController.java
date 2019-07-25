package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.service.EquipmentStateService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    //获取设备当日产量、最后开机时间、最后采集时间
    @PostMapping("/equipment/equipmentStatus/getOutputAndDate")
    public ResultModel getOutputAndDate() throws Exception {
        logger.info("################/equipment/equipmentStatus/getOutputAndDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentStateService.getOutputAndDate(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentStatus/getOutputAndDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取设备24小时开机时间、工作时间、故障报警
    @PostMapping("/equipment/equipmentStatus/get24HoursData")
    public ResultModel get24HoursData() throws Exception {
        logger.info("################/equipment/equipmentStatus/get24HoursData 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentStateService.get24HoursData(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentStatus/get24HoursData 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取设备指标24小时详细数据
    @PostMapping("/equipment/equipmentStatus/get24HoursDataDetail")
    public ResultModel get24HoursDataDetail() throws Exception {
        logger.info("################/equipment/equipmentStatus/get24HoursDataDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentStateService.get24HoursDataDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentStatus/get24HoursDataDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
