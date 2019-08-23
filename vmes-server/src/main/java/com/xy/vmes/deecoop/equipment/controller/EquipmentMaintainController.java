package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.EquipmentMaintain;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.entity.EquipmentMaintainTask;
import com.xy.vmes.service.EquipmentMaintainPlanService;
import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
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
import java.util.Map;

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
    private EquipmentMaintainPlanService maintainPlanService;
    @Autowired
    private EquipmentMaintainPlanToolsService maintainPlanToolsService;

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

        String maintainDescribe = pageData.getString("maintainDescribe");
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
        maintainTask.setMaintainDescribe(maintainDescribe);
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

    /**
     * 逻辑删除-设备保养单
     * 修改-设备保养单(是否禁用状态)-(禁用)
     *
     * 表字段说明(vmes_equipment_maintain):
     * 1. isdisable: 是否启用(0:已禁用 1:启用)-该字段仅用于逻辑删除
     *    该字段维护场景: 保养计划删除, 保养计划修改 (设置:0:已禁用)
     *                  定时器中生成保养单 (设置:1:启用)
     *
     * 2. is_valid_state: 保养单有效状态(1:有效 0:无效 is null 无效)-保养单队列游标(整个保养周期有且只有一行是1-任务执行完成设置0)
     *    0:无效: 当前保养任务执行完成(报工并且已解决)设置为'0'--寻找下一个最近的保养单设置为'1'
     *           当前保养任务删除设置为'0'--寻找下一个最近的保养单设置为'1'
     *    1:有效: 定时器中保养计划无保养单时默认设置'1'--当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *    该字段维护场景:
     *      0:无效: 保养任务执行完成, 当前保养任务删除
     *      1:有效: 定时器中保养计划无保养单时默认设置'1'
     *              当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *              当前保养任务删除寻找下一个最近的保养单设置为'1'
     *
     * @author 陈刚
     * @date 2019-08-05
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintain/updateDisableMaintain")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableMaintain() throws Exception {
        logger.info("################/equipment/equipmentMaintain/updateDisableMaintain 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //保养单id
        String maintainId = pageData.getString("maintainId");
        if (maintainId == null || maintainId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养单id为空或空字符串！");
            return model;
        }

        //保养计划id
        String planId = pageData.getString("planId");
        if (maintainId == null || maintainId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养计划id为空或空字符串！");
            return model;
        }

        //1. 修改当前保养单(isdisable, is_valid_state)
        EquipmentMaintain maintainEdit = new EquipmentMaintain();
        maintainEdit.setId(maintainId);
        //isdisable 是否启用(0:已禁用 1:启用)
        maintainEdit.setIsdisable("0");
        //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
        maintainEdit.setIsValidState("0");
        maintainService.update(maintainEdit);

        //根据保养计划id-查询该保养计划保养单-获取下一个保养单(周期保养计划)
        EquipmentMaintain nextMaintain = maintainService.findNextMaintainByPeriod(planId);
        if (nextMaintain != null) {
            //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
            maintainEdit.setIsValidState("1");
            maintainService.update(nextMaintain);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintain/updateDisableMaintain 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-根据计划执行日期-维修保养单
     * @author 陈刚
     * @date 2019-07-01
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintain/addEquipmentMaintain")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addEquipmentMaintain() throws Exception {
        logger.info("################/equipment/equipmentMaintain/addEquipmentMaintain 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //保养计划id
        String maintainPlanId = pageData.getString("maintainPlanId");
        if (maintainPlanId == null || maintainPlanId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养计划id为空或空字符串！");
            return model;
        }

        //计划执行日期
        String maintainPlanDateStr = pageData.getString("maintainPlanDateStr");
        if (maintainPlanDateStr == null || maintainPlanDateStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("计划执行日期为空或空字符串！");
            return model;
        }
        Date nowDate = DateFormat.dateString2Date(maintainPlanDateStr, DateFormat.DEFAULT_DATE_FORMAT);


        EquipmentMaintainPlan planObject = maintainPlanService.findMaintainPlanById(maintainPlanId);
        if (planObject == null) {return model;}

        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        String modeId = planObject.getModeId();
        if (Common.DICTIONARY_MAP.get("maintainModeCustom").equals(modeId)) {
            //创建-自定义计划-保养单
            try {
                maintainService.addMaintainCustomByTimer(planObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
            //sysPeriodType 重复类型 (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
            String sysPeriodType = planObject.getSysPeriodType();
            if (sysPeriodType != null && sysPeriodType.trim().length() > 0) {

                /**
                 * 返回值参数说明
                 * Map<重复类型Key, 周期起止日期时间Map>
                 * 重复类型Key:
                 *   everDay:每天
                 *   dayOfWeek:每周星期几
                 *   weekOfMonth:每月第几个星期几
                 *   dayOfYear:每年某月某日
                 *   workDay:工作日[周1-周5]
                 *   customPeriod:自定义周期
                 *
                 *  周期起止日期时间Map:
                 *  Map<String, Date>>
                 *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
                 *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
                 *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
                 */
                Map<String, Map<String, Date>> valueMap = null;
                try {
                    valueMap = maintainPlanToolsService.findPlanPeriod(nowDate, planObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (valueMap != null && valueMap.get(sysPeriodType) != null) {
                    Map<String, Date> dateMap = valueMap.get(sysPeriodType);
                    //创建-周期计划-保养单
                    try {
                        maintainService.addMaintainPeriodByTimer(dateMap, planObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintain/addEquipmentMaintain 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



