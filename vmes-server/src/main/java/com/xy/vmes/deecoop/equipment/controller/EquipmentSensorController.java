package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.service.EquipmentSensorService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.EquipmentSensorTargetService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;


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
    @Autowired
    private EquipmentSensorTargetService equipmentSensorTargetService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-06-19
    */
    @PostMapping("/equipment/equipmentSensor/listPageEquipmentSensor")
    public ResultModel listPageEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = equipmentSensorService.listPageEquipmentSensor(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

    /**
     * 新增-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/addEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        EquipmentSensor eqptSensor = (EquipmentSensor) HttpUtils.pageData2Entity(pageData, new EquipmentSensor());

        //非空判断
        String msgStr = equipmentSensorService.checkColumnByEdit(eqptSensor);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //该设备下-指标名称是否相同
        if (equipmentSensorService.isExistByName(null, eqptSensor.getEquipmentId(), eqptSensor.getTargetName())) {
            String msgTemp = "该指标名称: {0} 在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, eqptSensor.getTargetName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //获取全部传感器指标编码
        //指标编码前缀 := 指标类型(A:传感器指标 B:分析指标)
        LinkedHashMap<String, String> allCodeMap = equipmentSensorTargetService.findAllTargetCodeMap(
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXCOUNT,
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXDIGIT,
                eqptSensor.getTargetType());

        PageData findMap = new PageData();
        findMap.put("equipmentId", eqptSensor.getEquipmentId());
        findMap.put("targetType", eqptSensor.getTargetType());
        findMap = equipmentSensorService.setupSqlOrder("target_code asc", findMap);
        List<EquipmentSensor> eqptList = equipmentSensorService.findEquipmentSensorList(findMap);
        LinkedHashMap<String, String> applyCodeMap = equipmentSensorService.findTargetCodeMap(eqptList);

        //获取一个新的(未使用)的指标编码
        String targetCode = equipmentSensorTargetService.findNewTargetCode(allCodeMap, applyCodeMap);
        if (targetCode == null || targetCode.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id" + eqptSensor.getEquipmentId() + " 获取(未使用)的指标编码失败，请与管理员联系！");
            return model;
        }
        eqptSensor.setTargetCode(targetCode);

        //获取企业id
        String companyID = pageData.getString("currentCompanyId");
        eqptSensor.setCompanyId(companyID);

        equipmentSensorService.save(eqptSensor);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



