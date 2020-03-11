package com.xy.vmes.deecoop.produce.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：生产计划明细检验报工关联入库明细 Mapper.java
 * 创建人：陈刚
 * 创建时间：2020-03-11
 */
@Mapper
@Repository
public interface ProducePlanQualityDetailOnInMapper {
    List<Map> findProducePlanQualityDetailOnInDetail(PageData pd, Pagination pg);
    List<Map> findProducePlanQualityDetailOnInDetail(PageData pd);
}
