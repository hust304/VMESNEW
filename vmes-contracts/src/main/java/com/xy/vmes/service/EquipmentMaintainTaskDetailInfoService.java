package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_equipment_maintainTask_detail:设备保养任务明细详情 接口类
 * 创建人：陈刚
 * 创建时间：2019-08-05
 */
public interface EquipmentMaintainTaskDetailInfoService {
    List<Map> findMaintainTaskDetailByInfo(PageData pd, Pagination pg) throws Exception;
    ResultModel findListMaintainTaskDetailByInfo(PageData pd) throws Exception;
}
