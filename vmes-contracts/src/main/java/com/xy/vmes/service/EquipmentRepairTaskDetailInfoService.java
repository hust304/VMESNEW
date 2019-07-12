package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_equipment_repairTask_detail:设备维修任务明细详情 接口类
 * 创建人：陈刚
 * 创建时间：2019-07-12
 */
public interface EquipmentRepairTaskDetailInfoService {
    List<Map> findRepairTaskDetailByInfo(PageData pd, Pagination pg) throws Exception;

    ResultModel findListRepairTaskDetailByInfo(PageData pd) throws Exception;
}
