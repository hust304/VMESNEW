package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_equipment_maintainTask:设备保养任务明细详情 Mapper
 * @author 陈刚
 * @date 2019-08-05
 */
@Mapper
@Repository
public interface EquipmentMaintainTaskDetailInfoMapper {
    List<Map> findMaintainTaskDetailByInfo(PageData pd, Pagination pg);
    List<Map> findMaintainTaskDetailByInfo(PageData pd);
}
