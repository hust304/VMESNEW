package com.xy.vmes.service;

/**
 * 说明：设备传感器指标公式转换服务接口
 * 创建人：陈刚
 * 创建时间：2019-06-19
 */
public interface EquipmentSensorFormulaService {
    /**
     * 公式转换:
     * 公式字符串转换成-栏位名称公式(SQL查询语句直接使用)
     *
     * @param equipmentId    设备id
     * @param targetType     指标类型(A:传感器指标 B:分析指标)
     * @param targetFormula  指标公式
     * @return
     */
    String formula2TargetFormulaColumn(String equipmentId, String targetType, String targetFormula);
}
