package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentMaintainPlan;

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

}
