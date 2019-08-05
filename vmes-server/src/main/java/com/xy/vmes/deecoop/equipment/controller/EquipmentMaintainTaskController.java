package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.EquipmentMaintain;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.entity.EquipmentMaintainTask;
import com.xy.vmes.service.EquipmentMaintainPlanService;
import com.xy.vmes.service.EquipmentMaintainService;
import com.xy.vmes.service.EquipmentMaintainTaskService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
* 说明：vmes_equipment_maintainTask:设备保养任务Controller
* @author 陈刚 自动生成
* @date 2019-07-29
*/
@RestController
@Slf4j
public class EquipmentMaintainTaskController {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainTaskController.class);

    @Autowired
    private EquipmentMaintainPlanService maintainPlanService;
    @Autowired
    private EquipmentMaintainService maintainService;
    @Autowired
    private EquipmentMaintainTaskService maintainTaskService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-29
    */
    @PostMapping("/equipment/equipmentMaintainTask/listPageEquipmentMaintainTask")
    public ResultModel listPageEquipmentMaintainTask() throws Exception {
        logger.info("################/equipment/equipmentMaintainTask/listPageEquipmentMaintainTask 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainTaskService.listPageEquipmentMaintainTask(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTask/listPageEquipmentMaintainTask 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消-设备保养任务
     * @author 陈刚
     * @date 2019-07-29
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainTask/cancelMaintainTask")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelMaintainTask() throws Exception {
        logger.info("################/equipment/equipmentMaintainTask/cancelMaintainTask 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String maintainId = pageData.getString("maintainId");
        if (maintainId == null || maintainId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备保养单id为空或空字符串！");
            return model;
        }

        String cancelReason = pageData.getString("cancelReason");
        if (cancelReason == null || cancelReason.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("取消原因为空或空字符串！");
            return model;
        }

        String maintainTaskId = pageData.getString("maintainTaskId");
        if (maintainTaskId == null || maintainTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养任务id为空或空字符串！");
            return model;
        }

        //当前保养单对象
        EquipmentMaintain maintain = maintainService.findMaintainById(maintainId);
        //planId:保养计划ID
        String planId = maintain.getPlanId();
        EquipmentMaintainPlan maintainPlan = maintainPlanService.findMaintainPlanById(planId);

        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        String modeId = maintainPlan.getModeId();
        if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
            //获取下一个保养单对象
            EquipmentMaintain nextMaintain = maintainService.findNextMaintainByPeriod(maintain);
            if (nextMaintain != null) {
                //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
                nextMaintain.setIsValidState("1");
                maintainService.update(nextMaintain);
            }
        }


        EquipmentMaintain maintainEdit = new EquipmentMaintain();
        maintainEdit.setId(maintainId);
        //equipmentState: 设备状态(1:待保养 2:保养中 3:已完成)
        maintainEdit.setEquipmentState("3");
        //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
        maintainEdit.setIsValidState("0");

        //cancelReason 取消原因
        maintainEdit.setCancelReason(cancelReason);
        //cancelDate 取消时间
        maintainEdit.setCancelDate(new Date());
        //cancelUser 取消人
        maintainEdit.setCancelUser(cuser);
        maintainService.update(maintainEdit);

        if (maintainTaskId != null && maintainTaskId.trim().length() > 0) {
            EquipmentMaintainTask maintainTaskEdit = new EquipmentMaintainTask();
            maintainTaskEdit.setId(maintainTaskId);
            //cancelReason 取消原因
            maintainTaskEdit.setCancelReason(cancelReason);
            //cancelUser 取消人
            maintainTaskEdit.setCancelUser(cuser);
            //endTime 任务结束时间
            maintainTaskEdit.setEndTime(new Date());
            //taskResult 执行结果(0:未解决 1:已解决)
            maintainTaskEdit.setTaskResult("1");
            //taskState 任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
            maintainTaskEdit.setTaskState("4");
            maintainTaskService.update(maintainTaskEdit);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTask/cancelMaintainTask 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



