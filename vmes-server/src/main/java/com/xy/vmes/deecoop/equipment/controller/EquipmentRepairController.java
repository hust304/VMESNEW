package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.EquipmentRepair;
import com.xy.vmes.entity.EquipmentRepairTask;
import com.xy.vmes.service.CoderuleService;
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

import java.math.BigDecimal;
import java.util.Date;

/**
* 说明：vmes_equipment_repair:设备维修表Controller
* @author 陈刚 自动生成
* @date 2019-07-01
*/
@RestController
@Slf4j
public class EquipmentRepairController {
    private Logger logger = LoggerFactory.getLogger(EquipmentRepairController.class);

    @Autowired
    private EquipmentRepairService equipmentRepairService;
    @Autowired
    private EquipmentRepairTaskService repairTaskService;

    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-01
    */
    @PostMapping("/equipment/equipmentRepair/listPageEquipmentRepair")
    public ResultModel listPageEquipmentRepair() throws Exception {
        logger.info("################/equipment/equipmentRepair/listPageEquipmentRepair 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentRepairService.listPageEquipmentRepair(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepair/listPageEquipmentRepair 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备维修单
     * @author 陈刚
     * @date 2019-07-01
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentRepair/addEquipmentRepair")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addEquipmentRepair() throws Exception {
        logger.info("################/equipment/equipmentRepair/addEquipmentRepair 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String equipmentId = pageData.getString("equipmentId");
        if (equipmentId == null || equipmentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("companyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String cuser = pageData.getString("cuser");
        String faultDescribe = pageData.getString("faultDescribe");

        EquipmentRepair addRepair = new EquipmentRepair();
        addRepair.setEquipmentId(equipmentId);
        addRepair.setCompanyId(companyId);
        addRepair.setCuser(cuser);
        addRepair.setWarnDate(new Date());
        if (faultDescribe != null && faultDescribe.trim().length() > 0) {
            addRepair.setFaultDescribe(faultDescribe.trim());
        }

        //设备维修单编号
        //ER+yyyyMMdd+00001 = 15位
        String code = coderuleService.createCoderCdateByDate(companyId,
                "vmes_equipment_repair",
                "yyyyMMdd",
                "ER");
        addRepair.setSysCode(code);

        equipmentRepairService.save(addRepair);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepair/addEquipmentRepair 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 维修-设备维修单(领取)
     * @author 陈刚
     * @date 2019-07-01
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentRepair/equipmentRepairReceive")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel equipmentRepairReceive() throws Exception {
        logger.info("################/equipment/equipmentRepair/equipmentRepairReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String faultDescribe = pageData.getString("faultDescribe");
        String cuser = pageData.getString("cuser");

        String repairId = pageData.getString("repairId");
        if (repairId == null || repairId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备维修单id为空或空字符串！");
            return model;
        }

        String repairUser = pageData.getString("repairUser");
        if (repairUser == null || repairUser.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("维修人id为空或空字符串！");
            return model;
        }

        //teimType (M:分钟 H:小时 D:天)
        String teimType = pageData.getString("teimType");
        if (teimType == null || teimType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("时间分类为空，请选择(分钟,小时,天)");
            return model;
        }

        String timeLength = pageData.getString("timeLength");
        long timeLengthLong = 0L;
        if (timeLength == null || timeLength.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("预估维修时间为空或空字符串，预估维修时间为必填项不可为空！");
            return model;
        } else {
            try {
                timeLengthLong = new Long(timeLength).longValue();
            } catch (NumberFormatException e) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("预估维修时间(" + timeLength + ")输入错误，请输入大于零的正整数！");
                return model;
            }
        }

        //teimType (M:分钟 H:小时 D:天)
        //获取 预计维修时长(单位秒)
        if ("M".equals(teimType)) {
            timeLengthLong = timeLengthLong * 60;
        } else if ("H".equals(teimType)) {
            timeLengthLong = timeLengthLong * 60 * 60;
        } else if ("D".equals(teimType)) {
            timeLengthLong = timeLengthLong * 24 * 60 * 60;
        }

        //1. 设备维修单id 查询 vmes_equipment_repairTask:
        boolean isExistTask = repairTaskService.isExistRepairTaskByRepairId(repairId);
        if (isExistTask) {
            //设备维修单id 禁用全部设备维修任务表
            //是否启用(0:已禁用 1:启用)
            repairTaskService.updateIsdisableByRepairId("0", repairId);
        }

        //2. 创建-设备维修任务表 vmes_equipment_repairTask
        EquipmentRepairTask repairTask = new EquipmentRepairTask();
        repairTask.setRepairId(repairId);
        //repairUser 维修人id
        repairTask.setRepairUser(repairUser);
        //timeLength 预计维修时长(单位秒)
        repairTask.setTimeLength(BigDecimal.valueOf(timeLengthLong));
        repairTask.setFaultDescribe(faultDescribe);
        //task_result:执行结果(0:未解决 1:已解决)
        repairTask.setTaskResult("0");
        //task_state:任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
        repairTask.setTaskState("1");
        //task_type:任务类型(1:维修 2:退单)
        repairTask.setTaskType("1");
        //beginTime 任务开始时间(领取时间)
        repairTask.setBeginTime(new Date());
        repairTask.setCuser(cuser);
        repairTaskService.save(repairTask);

        //3. 修改-设备维修表 vmes_equipment_repair:
        EquipmentRepair repairEdit = new EquipmentRepair();
        repairEdit.setId(repairId);
        repairEdit.setRepairTaskId(repairTask.getId());
        //equipmentState:设备状态(1:故障 2:维修中 3:已完成)
        repairEdit.setEquipmentState("2");
        equipmentRepairService.update(repairEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepair/equipmentRepairReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



