package com.xy.vmes.deecoop.produce.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_produce_plan_detail:生产计划明细(检验)报工 Mapper.java
 *
 * 创建人：陈刚
 * 创建时间：2020-03-04
 */
@Mapper
@Repository
public interface ProducePlanDetailByQualityMapper {
    List<Map> listProducePlanDetailByQuality(PageData pd);
    List<Map> listProducePlanDetailByQuality(PageData pd, Pagination pg);
}
