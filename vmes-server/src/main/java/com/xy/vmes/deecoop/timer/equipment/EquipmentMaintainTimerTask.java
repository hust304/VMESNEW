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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 设备-设备保养-定时任务
 *
 */
@Component
@EnableScheduling
public class EquipmentMaintainTimerTask {
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
     * 每月1号凌晨1点执行：(0 0 1 1 * ?)
     *
     * 1. 获取系统全部企业
     * 2. 查询设备保养计划(vmes_equipment_maintain_plan)
     *
     */
    @Scheduled(cron = "0 0 1 1 * ?")
    public void createMaintainTimer() {
        Date nowDate = new Date();
        //当前系统日期(yyyy-MM-dd)
        String nowDateStr = DateFormat.date2String(nowDate, DateFormat.DEFAULT_DATE_FORMAT);

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
                    //创建-自定义(计划)
                    try {
                        maintainService.addMaintainByCustom(plan.getCuser(), companyId, plan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
                    //按周期(计划)
                }
            }

        }


    }
}
