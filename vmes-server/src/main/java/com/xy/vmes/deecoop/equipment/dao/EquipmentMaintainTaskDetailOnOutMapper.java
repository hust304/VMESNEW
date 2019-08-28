package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：设备保养任务明细关联出库明细 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-08-28
 */
@Mapper
@Repository
public interface EquipmentMaintainTaskDetailOnOutMapper {
    List<Map> findMaintainTaskDetailOnOutDetail(PageData pd, Pagination pg);
    List<Map> findMaintainTaskDetailOnOutDetail(PageData pd);
}
