package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：设备维修任务明细关联出库明细 接口类
 * 创建人：陈刚
 * 创建时间：2019-08-28
 */
public interface EquipmentRepairTaskDetailOnInOutService {
    List<Map> findRepairTaskDetailOnInOutDetail(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageRepairTaskDetailByOut(PageData pd) throws Exception;
    ResultModel listPageRepairTaskDetailByIn(PageData pd) throws Exception;
}
