package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_retreat_detail:外协退货明细(外协件成品) Mapper
 * 外协-外协件退货-退货列表(编辑)功能
 * 创建人：陈刚
 * 创建时间：2020-05-09
 */
@Mapper
@Repository
public interface AssistRetreatDetailEditMapper {
    List<Map> findAssistRetreatDetailEdit(PageData pd, Pagination pg);
    List<Map> findAssistRetreatDetailEdit(PageData pd);
}
