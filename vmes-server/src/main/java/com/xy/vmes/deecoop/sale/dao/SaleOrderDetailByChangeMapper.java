package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总 Mapper.java
 * 销售-订单提交-订单变更-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2019-03-05
 */
@Mapper
@Repository
public interface SaleOrderDetailByChangeMapper {
    List<Map> listOrderDetaiByChange(PageData pd);
    List<Map> listOrderDetaiByChange(PageData pd, Pagination pg);
}
