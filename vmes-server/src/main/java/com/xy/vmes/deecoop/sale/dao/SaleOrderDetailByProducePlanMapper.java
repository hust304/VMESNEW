package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：销售订单明细查询 Mapper.java
 * 生产-生产计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-02-29
 */
@Mapper
@Repository
public interface SaleOrderDetailByProducePlanMapper {
    List<Map> listOrderDetaiByProducePlan(PageData pd, Pagination pg);
    List<Map> listOrderDetaiByProducePlan(PageData pd);
}
