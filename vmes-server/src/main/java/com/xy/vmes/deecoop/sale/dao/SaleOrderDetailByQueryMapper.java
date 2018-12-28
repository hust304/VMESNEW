package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总 Mapper.java
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-27
 */
@Mapper
@Repository
public interface SaleOrderDetailByQueryMapper {
    List<Map> findListPageOrderDetaiByQuery(PageData pd);
    List<Map> findListPageOrderDetaiByQuery(PageData pd, Pagination pg);
}
