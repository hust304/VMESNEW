package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：发货明细汇总 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-01-18
 */
@Mapper
@Repository
public interface SaleDeliverDetailByCollectMapper {

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
     * 获取发货出库订单(订单明细id,订购数量,出库数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    List<Map<String, Object>> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData);

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    List<Map<String, Object>> findDeliverDetailByOrderDetaiCount(PageData pageData);
}
