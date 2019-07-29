package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.EquipmentMaintainPlanService;

import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private EquipmentMaintainPlanService maintainPlanService;
    @Autowired
    private EquipmentMaintainPlanToolsService maintainPlanToolsService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-25
    */
    @PostMapping("/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan")
    public ResultModel listPageEquipmentMaintainPlans() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainPlanService.listPageEquipmentMaintainPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备保养计划
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/addMaintainPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMaintainPlan() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //计划开始日期 beginPlan
        String beginPlanStr = pageData.getString("beginPlan");
        Date beginPlan = null;
        if (beginPlanStr != null && beginPlanStr.trim().length() > 0) {
            beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        //计划结束日期 endPlan
        String endPlanStr = pageData.getString("endPlan");
        Date endPlan = null;
        if (endPlanStr != null && endPlanStr.trim().length() > 0) {
            endPlan = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //计划对象 <EquipmentMaintainPlan>
        EquipmentMaintainPlan planObject = (EquipmentMaintainPlan) HttpUtils.pageData2Entity(pageData, new EquipmentMaintainPlan());
        planObject.setBeginPlan(beginPlan);
        planObject.setEndPlan(endPlan);
        planObject.setCompanyId(companyId);

        String eqptJsonStr = pageData.getString("eqptJsonStr");
        if (eqptJsonStr == null || eqptJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一项设备！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(eqptJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //调整保养计划对象(周期计划)
        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        //设备保养方式: 7ef6384e92a343ccb839112a5d59b2fe (vmes_dictionary.id) 设备保养计划(模块)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(planObject.getModeId())) {
            maintainPlanToolsService.adjustMaintainPlanByPeriod(planObject);
        }

        //添加设备保养计划
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("planObject", planObject);
        valueMap.put("eqptJsonMapList", jsonMapList);
        maintainPlanService.addMaintainPlan(valueMap);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



