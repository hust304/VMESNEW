package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：退货明细汇总 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-03-07
 */
@Mapper
@Repository
public interface SaleRetreatDetailByCollectMapper {
    List<Map<String, Object>> findRetreatDetailCollectByOrderDtlId(PageData pageData);
    List<Map<String, Object>> findRetreatDetailCollectByOrderId(PageData pageData);
}
