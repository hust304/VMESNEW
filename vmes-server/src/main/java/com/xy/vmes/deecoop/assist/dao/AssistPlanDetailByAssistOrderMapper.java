package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_plan_detail:外协计划明细 Mapper.java
 * 外协-订单管理-订单列表-(外协计划明细)勾选
 *
 * 创建人：陈刚
 * 创建时间：2020-04-19
 */
@Mapper
@Repository
public interface AssistPlanDetailByAssistOrderMapper {
    List<Map> listAssistPlanDetailByAssistOrder(PageData pd, Pagination pg);
    List<Map> listAssistPlanDetailByAssistOrder(PageData pd);
}
