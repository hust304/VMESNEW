package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentMaintainPlan;

import java.util.Date;
import java.util.Map;

/**
 * 说明：vmes_equipment_maintain_plan:设备保养计划工具接口类
 * 创建人：陈刚
 * 创建时间：2019-07-25
 */
public interface EquipmentMaintainPlanToolsService {
    /**
     * 调整保养计划对象(周期计划)
     * 本方法按值引用(方法调用后参数对象发生改变)
     *
     * @param planObject
     */
    void adjustMaintainPlanByPeriod(EquipmentMaintainPlan planObject);

    /**
     * 获取计划周期的起止日期
     * 重复类型(everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
     *
     * @param nowDate 系统当前时间
     * @param plan    设备保养计划对象(周期计划)
     *
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
    Map<String, Map<String, Date>> findPlanPeriod(Date nowDate, EquipmentMaintainPlan plan);


}
