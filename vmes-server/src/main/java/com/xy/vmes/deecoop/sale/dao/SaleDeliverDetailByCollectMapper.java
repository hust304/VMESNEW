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

//    /**
//     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
//     * 获取发货出库订单(订单明细id,订购数量,出库数量)
//     *
//     * 创建人：陈刚
//     * 创建时间：2019-01-18
//     */
//    List<Map<String, Object>> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData);

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    List<Map<String, Object>> findDeliverDetailByOrderDetaiCount(PageData pageData);

    /**
     * 关联查询(vmes_sale_order_detail,vmes_sale_deliver_detail,vmes_sale_retreat_detail)
     * 发货明细状态:1:已发货  发货明细状态(0:待发货 1:已发货 -1:已取消)
     * 退货明细状态:3:已完成  退货明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
     *
     * @param pageData
     * @return
     */
    List<Map<String, Object>> findDeliverDetailByOrderDetail(PageData pageData);
}
