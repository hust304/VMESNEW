package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_sign_detail:外协签收明细 Mapper
 * 外协-外协件退货-生成退货(成品退货)
 * 创建人：陈刚
 * 创建时间：2020-05-12
 */
@Mapper
@Repository
public interface AssistSignDetailByRetreatMapper {
    List<Map> findAssistSignDetailByRetreat(PageData pd, Pagination pg);
    List<Map> findAssistSignDetailByRetreat(PageData pd);

}
