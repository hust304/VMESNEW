package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_loginfo: (备件库)货品库存数量变更日志 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-06-27
 */
@Mapper
@Repository
public interface EquipmentWarehouseLoginfoBySpareMapper {
    List<Map> findListWarehouseLoginfoBySpare(PageData pd);
    List<Map> findListWarehouseLoginfoBySpare(PageData pd, Pagination pg);
}
