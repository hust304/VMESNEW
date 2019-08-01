package com.xy.vmes.deecoop.timer.equipment;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.EquipmentMaintainPlanService;
import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
import com.xy.vmes.service.EquipmentMaintainService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 设备-设备保养-定时任务
 *
 */
@Component
@EnableScheduling
public class EquipmentMaintainTimerTask {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainTimerTask.class);

    //EquipmentMaintainTimerTask.createMaintainTimer(yyyy-MM-dd HH:mm:ss):开始执行
    private String begin_end_logger_msg_temp = "{0}.{1}({2}):{3}";

    @Autowired
    private EquipmentMaintainPlanService maintainPlanService;
    @Autowired
    private EquipmentMaintainPlanToolsService maintainPlanToolsService;
    @Autowired
    private EquipmentMaintainService maintainService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 创建设备保养单-定时任务
     * 每天凌晨1点执行        (0 0 1 * * ?)
     *
     * 1. 获取系统全部企业
     * 2. 查询设备保养计划(vmes_equipment_maintain_plan)
     *
     */
    //每天12点30分执行 (0 30 12 * * ?)
    //@Scheduled(cron = "0 30 12 * * ?") //测试代码-真实环境无此代码

    @Scheduled(cron = "0 0 1 * * ?")
    public void createMaintainTimer() {
        Date nowDate = new Date();

        //String dateStr = "2019-07-30";  //测试代码-真实环境无此代码
        //Date nowDate = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT); //测试代码-真实环境无此代码

        //当前系统日期(yyyy-MM-dd)
        String nowDateStr = DateFormat.date2String(nowDate, DateFormat.DEFAULT_DATE_FORMAT);
        nowDate = DateFormat.dateString2Date(nowDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //定时器开始执行日志
        String dateTimeStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT);
        String begin_logger_msg = MessageFormat.format(begin_end_logger_msg_temp,
                "EquipmentMaintainTimerTask",
                "createMaintainTimer",
                dateTimeStr,
                "开始执行");
        logger.info(begin_logger_msg);

        //1. 获取系统全部企业
        List<Department> companyList = null;
        try {
            PageData findMap = new PageData();
            //organizeType 组织类型(1:公司 2:部门)
            findMap.put("organizeType", "1");
            //isdisable 是否禁用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            companyList = departmentService.findDepartmentList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (companyList == null || companyList.size() == 0) {return;}

        //2. 遍历系统全部企业
        for (Department company : companyList) {
            String companyId = company.getId();

            //根据(企业id)-查询设备保养计划(vmes_equipment_maintain_plan)
            List<EquipmentMaintainPlan> planList = null;
            try {
                PageData findMap = new PageData();
                findMap.put("companyId", companyId);
                findMap.put("nowDate", nowDateStr);
                //isdisable 是否禁用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                planList = maintainPlanService.findMaintainPlanList(findMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (planList == null || planList.size() == 0) {continue;}

            //3. 遍历设备保养计划-创建保养单
            for (EquipmentMaintainPlan plan : planList) {
                //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
                //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
                //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
                String modeId = plan.getModeId();
                if (Common.DICTIONARY_MAP.get("maintainModeCustom").equals(modeId)) {
                    //创建-自定义计划-保养单
                    try {
                        maintainService.addMaintainCustomByTimer(plan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
                    //sysPeriodType 重复类型 (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
                    String sysPeriodType = plan.getSysPeriodType();
                    if (sysPeriodType == null || sysPeriodType.trim().length() == 0) {continue;}

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
                        valueMap = maintainPlanToolsService.findPlanPeriod(nowDate, plan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (valueMap == null || valueMap.get(sysPeriodType) == null) {continue;}
                    Map<String, Date> dateMap = valueMap.get(sysPeriodType);
                    //创建-周期计划-保养单
                    try {
                        maintainService.addMaintainPeriodByTimer(dateMap, plan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //定时器结束执行日志
        dateTimeStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT);
        String end_logger_msg = MessageFormat.format(begin_end_logger_msg_temp,
                "EquipmentMaintainTimerTask",
                "createMaintainTimer",
                dateTimeStr,
                "结束执行");
        logger.info(end_logger_msg);
    }


}
