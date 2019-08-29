package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：销售退货明细关联入库明细 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-08-29
 */
@Mapper
@Repository
public interface SaleRetreatDetailOnInMapper {
    List<Map> findSaleRetreatDetailOnInDetail(PageData pd, Pagination pg);
    List<Map> findSaleRetreatDetailOnInDetail(PageData pd);
}
