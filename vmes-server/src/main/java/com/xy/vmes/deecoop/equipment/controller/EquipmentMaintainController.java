package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.EquipmentMaintain;
import com.xy.vmes.entity.EquipmentMaintainTask;
import com.xy.vmes.service.EquipmentMaintainService;

import com.xy.vmes.service.EquipmentMaintainTaskService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
* 说明：vmes_equipment_maintain:设备保养单Controller
* @author 陈刚 自动生成
* @date 2019-07-29
*/
@RestController
@Slf4j
public class EquipmentMaintainController {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainController.class);

    @Autowired
    private EquipmentMaintainService maintainService;
    @Autowired
    private EquipmentMaintainTaskService maintainTaskService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-29
    */
    @PostMapping("/equipment/equipmentMaintain/listPageEquipmentMaintain")
    public ResultModel listPageEquipmentMaintain() throws Exception {
        logger.info("################/equipment/equipmentMaintain/listPageEquipmentMaintain 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainService.listPageEquipmentMaintain(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintain/listPageEquipmentMaintain 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 保养-设备保养单(领取)
     * @author 陈刚
     * @date 2019-07-29
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintain/maintainReceive")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel maintainReceive() throws Exception {
        logger.info("################/equipment/equipmentMaintain/maintainReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String describe = pageData.getString("describe");
        String cuser = pageData.getString("cuser");

        String maintainId = pageData.getString("maintainId");
        if (maintainId == null || maintainId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备保养单id为空或空字符串！");
            return model;
        }

        String maintainUser = pageData.getString("maintainUser");
        if (maintainUser == null || maintainUser.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养人id为空或空字符串！");
            return model;
        }

        //创建-设备保养任务表 vmes_equipment_maintainTask
        EquipmentMaintainTask maintainTask = new EquipmentMaintainTask();
        maintainTask.setMaintainId(maintainId);
        //maintainUser 保养人id
        maintainTask.setMaintainUser(maintainUser);
        maintainTask.setDescribe(describe);
        //task_state:任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
        maintainTask.setTaskState("1");
        //task_type:任务类型(1:保养 2:退单)
        maintainTask.setTaskType("1");
        //beginTime 任务开始时间(领取时间)
        maintainTask.setBeginTime(new Date());
        maintainTask.setCuser(cuser);
        maintainTaskService.save(maintainTask);

        //修改-设备保养表 vmes_equipment_maintain:
        EquipmentMaintain maintainEdit = new EquipmentMaintain();
        maintainEdit.setId(maintainId);
        maintainEdit.setMaintainTaskId(maintainTask.getId());
        maintainEdit.setBeginTime(maintainTask.getBeginTime());
        //equipmentState:设备状态(1:待保养 2:保养中 3:已完成)
        maintainEdit.setEquipmentState("2");
        maintainService.update(maintainEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintain/maintainReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



