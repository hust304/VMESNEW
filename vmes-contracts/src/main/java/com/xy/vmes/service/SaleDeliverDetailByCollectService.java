package com.xy.vmes.service;

import com.yvan.PageData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 说明：发货明细汇总 Service
 * 创建人：陈刚
 * 创建时间：2019-01-18
 */
public interface SaleDeliverDetailByCollectService {

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
     * 获取发货出库订单(订单明细id,订购数量,出库数量)
     *
     * @param pageData
     *     orderDetailId:订单明细id
     *
     * @return
     * @throws Exception
     */
    Map<String, Object> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData) throws Exception;

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    List<Map<String, Object>> findDeliverDetailByOrderDetaiCount(PageData pageData) throws Exception;

    /**
     * 根据发货单id-获取(订单明细id,订购数量,发货数量)
     *
     * @param deliverId       发货单id
     * @param deliveDtlState  发货单明细状态
     * @param orderDtlIds     订单明细id
     * @return
     */
    Map<String, Map<String, BigDecimal>> findMapOrderDetaiCountByDeliverId(String deliverId, String deliveDtlState, String orderDtlIds) throws Exception;
}
