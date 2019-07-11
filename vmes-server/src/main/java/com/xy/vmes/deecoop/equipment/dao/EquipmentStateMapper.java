package com.xy.vmes.deecoop.equipment.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 设备信息状态综合查询 Mapper
 * 创建人：陈刚
 * 创建时间：2019-07-11
 */
@Mapper
@Repository
public interface EquipmentStateMapper {
    List<Map> findEquipmentState(PageData pd);
}
