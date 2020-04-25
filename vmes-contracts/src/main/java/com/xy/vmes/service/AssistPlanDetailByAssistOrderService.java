package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_plan_detail:外协计划明细 接口类
 * 外协-订单管理-订单列表-(外协计划明细)勾选
 *
 * 创建人：陈刚
 * 创建时间：2020-04-19
 */
public interface AssistPlanDetailByAssistOrderService {
    List<Map> listAssistPlanDetailByAssistOrder(PageData pd, Pagination pg);
    ResultModel listPageAssistPlanDetailByAssistOrder(PageData pd) throws Exception;
}
