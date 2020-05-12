package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_order_detail:外协订单明细子表 接口类
 * 外协-外协件退货-生成退货(成品退货)
 * 外协-外协件报废-生成报废(成品报废)
 *
 * 创建人：陈刚
 * 创建时间：2020-05-12
 */
public interface AssistOrderDetailByRetreatService {
    List<Map> findAssistOrderDetailByRetreat(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistOrderDetailByRetreat(PageData pd) throws Exception;
}
