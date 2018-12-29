package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总 Mapper.java
 * 销售-发货管理-生成发货单-(勾选订单明细)-弹出界面查询
 *
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-29
 */
@Mapper
@Repository
public interface SaleOrderDetailQueryByDeliverMapper {
    List<Map> listOrderDetaiQueryByDeliver(PageData pd);
    List<Map> listOrderDetaiQueryByDeliver(PageData pd, Pagination pg);
}
