package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单详情(订单明细) vmes_sale_order_detail:订单明细汇总 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-02-12
 */
@Mapper
@Repository
public interface SaleOrderDetailCollectMapper {
    List<Map> findListPageOrderDetailCollectByInfo(PageData pd);
    List<Map> findListPageOrderDetailCollectByInfo(PageData pd, Pagination pg);
}
