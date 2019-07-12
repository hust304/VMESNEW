package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_equipment_repairTask_detail:设备维修任务明细详情 Mapper
 * @author 陈刚
 * @date 2019-07-12
 */
@Mapper
@Repository
public interface EquipmentRepairTaskDetailInfoMapper {

    List<Map> findRepairTaskDetailByInfo(PageData pd, Pagination pg);
    List<Map> findRepairTaskDetailByInfo(PageData pd);
}
