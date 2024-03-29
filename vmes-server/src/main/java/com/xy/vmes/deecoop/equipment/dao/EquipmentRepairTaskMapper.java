package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.EquipmentRepairTask;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_repairTask:设备维修任务表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-07-01
*/
@Mapper
@Repository
public interface EquipmentRepairTaskMapper extends BaseMapper<EquipmentRepairTask> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void updateIsdisableByRepairId(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<EquipmentRepairTask> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
}


