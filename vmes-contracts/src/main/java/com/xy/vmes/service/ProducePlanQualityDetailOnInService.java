package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：生产计划明细检验报工关联入库明细 接口类
 * 创建人：陈刚
 * 创建时间：2020-03-11
 */
public interface ProducePlanQualityDetailOnInService {
    List<Map> findProducePlanQualityDetailOnInDetail(PageData pd, Pagination pg) throws Exception;
}
