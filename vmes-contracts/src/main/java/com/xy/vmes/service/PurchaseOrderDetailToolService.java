package com.xy.vmes.service;

import java.util.Map;

/**
 * 说明：采购订单明细工具接口 (vmes_purchase_order_detail:采购订单明细表)
 * 创建人：陈刚
 * 创建时间：2019-07-17
 */
public interface PurchaseOrderDetailToolService {

    /**
     * 获取(采购明细id,采购数量,签收数量,退货数量[已完成])Map<String, Map<String, Object>>结构体
     * 根据(采购订单明细id)采购订单明细汇总查询
     *
     * Map<采购订单明细id, 采购明细Map<String, Object>>
     * 采购明细Map<String, Object>
     *     detailId: 采购订单明细id
     *     parentId: 采购订单id
     *     detailCount: 采购数量
     *     signCount: 签收数量
     *     retreatCount: 退货数量(已完成)
     *     arriveCount: 到货数量:= 签收数量 - 退货数量(已完成)
     *
     * @param purchaseOrderId  采购订单Id
     * @return
     */
    Map<String, Map<String, Object>> findPurchaseOrderDetailMap(String purchaseOrderId);

//    /**
//     * 获取(采购明细id,采购数量,签收数量,退货数量[已完成])Map<String, Map<String, Object>>结构体
//     * 根据(采购订单明细id)采购订单明细汇总查询
//     *
//     * Map<采购订单明细id, 采购明细Map<String, Object>>
//     * 采购明细Map<String, Object>
//     *     detailId: 采购订单明细id
//     *     parentId: 采购订单id
//     *     detailCount: 采购数量
//     *     signCount: 签收数量
//     *     retreatCount: 退货数量(已完成)
//     *     arriveCount: 到货数量:= 签收数量 - 退货数量(已完成)
//     *
//     * @param detailIds  采购订单明细Id(','逗号分隔的字符串)
//     * @return
//     */
//    Map<String, Map<String, Object>> findPurchaseOrderDetailMapByDetail(String detailIds);
}
