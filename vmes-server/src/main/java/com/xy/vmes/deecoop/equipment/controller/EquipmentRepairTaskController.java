package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.EquipmentRepair;
import com.xy.vmes.entity.EquipmentRepairTask;
import com.xy.vmes.service.EquipmentRepairService;
import com.xy.vmes.service.EquipmentRepairTaskService;

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
* 说明：vmes_equipment_repairTask:设备维修任务表Controller
* @author 陈刚 自动生成
* @date 2019-07-01
*/
@RestController
@Slf4j
public class EquipmentRepairTaskController {
    private Logger logger = LoggerFactory.getLogger(EquipmentRepairTaskController.class);

    @Autowired
    private EquipmentRepairService repairService;
    @Autowired
    private EquipmentRepairTaskService repairTaskService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-01
    */
    @PostMapping("/equipment/equipmentRepairTask/listPageEquipmentRepairTask")
    public ResultModel listPageEquipmentRepairTask() throws Exception {
        logger.info("################/equipment/equipmentRepairTask/listPageEquipmentRepairTask 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();

        ResultModel model = repairTaskService.listPageEquipmentRepairTask(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTask/listPageEquipmentRepairTask 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消-设备维修任务
     * @author 陈刚
     * @date 2019-07-01
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentRepairTask/cancelRepairTask")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelRepairTask() throws Exception {
        logger.info("################/equipment/equipmentRepairTask/cancelRepairTask 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String repairId = pageData.getString("repairId");
        if (repairId == null || repairId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备维修单id为空或空字符串！");
            return model;
        }

        String cancelReason = pageData.getString("cancelReason");
        if (cancelReason == null || cancelReason.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("取消原因为空或空字符串！");
            return model;
        }

        String repairTaskId = pageData.getString("repairTaskId");
        if (repairTaskId == null || repairTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("维修任务id为空或空字符串！");
            return model;
        }

        EquipmentRepair repairEdit = new EquipmentRepair();
        repairEdit.setId(repairId);
        //equipmentState:设备状态(1:故障 2:维修中 3:已完成)
        repairEdit.setEquipmentState("3");
        //isdisable 是否启用(0:已禁用 1:启用)
        repairEdit.setIsdisable("0");

        //cancelReason 取消原因
        repairEdit.setCancelReason(cancelReason);
        //cancelDate 取消时间
        repairEdit.setCancelDate(new Date());
        //cancelUser 取消人
        repairEdit.setCancelUser(cuser);
        repairService.update(repairEdit);

        if (repairTaskId != null && repairTaskId.trim().length() > 0) {
            EquipmentRepairTask repairTaskEdit = new EquipmentRepairTask();
            repairTaskEdit.setId(repairTaskId);
            //cancelReason 取消原因
            repairTaskEdit.setCancelReason(cancelReason);
            //cancelUser 取消人
            repairTaskEdit.setCancelUser(cuser);
            //endTime 任务结束时间
            repairTaskEdit.setEndTime(new Date());
            //taskResult 执行结果(0:未解决 1:已解决)
            repairTaskEdit.setTaskResult("1");
            //taskState 任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
            repairTaskEdit.setTaskState("4");
            repairTaskService.update(repairTaskEdit);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTask/cancelRepairTask 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



