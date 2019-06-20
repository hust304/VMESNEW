package com.xy.vmes.service;

import java.util.LinkedHashMap;

/**
 * 说明：设备传感器指标编码服务接口类
 * 创建人：陈刚
 * 创建时间：2019-06-19
 */
public interface EquipmentSensorTargetService {

    /**
     * 获取全部传感器指标编码
     * LinkedHashMap<指标编码, 指标编码>
     *
     * @param maxCount  系统允许生成指标编码-最大个数
     * @param maxDigit  指标编码最大位数
     * @param prefix    指标编码前缀
     * @return
     */
    LinkedHashMap<String, String> findAllTargetCodeMap(Integer maxCount, Integer maxDigit, String prefix);

    /**
     * 获取一个新的(未使用)的指标编码
     * @param allCodeMap    系统全部指标编码 (A0001..A0100 B0001..B0100)
     * @param applyCodeMap  设备使用中的指标编码
     * @return
     */
    String findNewTargetCode(LinkedHashMap<String, String> allCodeMap, LinkedHashMap<String, String> applyCodeMap);

}
