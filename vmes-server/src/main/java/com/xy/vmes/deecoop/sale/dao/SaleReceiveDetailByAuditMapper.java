package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：收款明细 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-06-03
 */
@Mapper
@Repository
public interface SaleReceiveDetailByAuditMapper {
    List<Map> findReceiveDetailMapList(PageData pd, Pagination pg);
    List<Map> findReceiveDetailMapList(PageData pd);
}
