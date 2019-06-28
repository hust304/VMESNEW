package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_equipment_sensor:设备传感器指标(设备联网) 接口类
 * 创建人：陈刚 自动生成
 * 创建时间：2019-06-19
 */
public interface EquipmentWarehouseLoginfoBySpareService {
    List<Map> findListWarehouseLoginfoBySpare(PageData pd, Pagination pg) throws Exception;
}
