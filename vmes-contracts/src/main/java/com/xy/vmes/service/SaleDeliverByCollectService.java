package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.Map;

/**
 * 说明：发货明细汇总 Service
 * 创建人：陈刚
 * 创建时间：2019-01-18
 */
public interface SaleDeliverByCollectService {

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
}
