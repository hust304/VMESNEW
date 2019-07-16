package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface EquipmentRepairTaskOutDetailService {
    List<Map> findTaskDetailByOutDetail(PageData pd, Pagination pg) throws Exception;

    /**
     * 获取维修任务货品明细-是否出库执行完成
     * (vmes_equipment_repairTask_detail, vmes_warehouse_out_detail)
     *
     * @param repairTaskId  维修任务id
     *
     * @return
     *   true : 全部出库完成(默认值)
     *   false: 一条或多条出库未完成
     */
    boolean isAllOutExecuteRepairTaskDetail(String repairTaskId);
}
