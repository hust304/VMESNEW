package com.xy.vmes.deecoop.assist.dao;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_retreat_detail:外协退货明细(原材料) Mapper
 * 外协-退料管理-退料列表(编辑)功能
 * 创建人：陈刚
 * 创建时间：2020-05-09
 */
@Mapper
@Repository
public interface AssistRetreatDetailEditByProductMapper {
    List<Map> findAssistRetreatDetailEditByProduct(PageData pd, Pagination pg);
    List<Map> findAssistRetreatDetailEditByProduct(PageData pd);
}
