package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface EquipmentRepairTaskOutDetailService {
    List<Map> findTaskDetailByOutDetail(PageData pd, Pagination pg) throws Exception;
}
