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
    //Map<String, Object> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData) throws Exception;

//    /**
//     * 关联查询(vmes_sale_order_detail,vmes_sale_deliver_detail,vmes_sale_retreat_detail)
//     * 发货明细状态:1:已发货  发货明细状态(0:待发货 1:已发货 -1:已取消)
//     * 退货明细状态:3:已完成  退货明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
//     *
//     * 创建人：陈刚
//     * 创建时间：2019-01-18
//     */
//    List<Map<String, Object>> findDeliverDetailCollectByOrderDetail(PageData pageData) throws Exception;

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    List<Map<String, Object>> findDeliverDetailByOrderDetaiCount(PageData pageData) throws Exception;

    /**
     * 按发货单id-获取订单明细发货信息
     * <订单明细id, 发货信息Map>
     *     发货信息Map
     *     orderCount: 订单明细订购数量
     *     checkCount: (发货数量-退货数量)
     *     checkSum: (发货金额-退货金额)
     *
     * 根据发货单id-获取(订单明细id,订购数量,发货数量)
     *
     * @param deliverId       发货单id
     * @param deliveDtlState  发货单明细状态 (0:待发货 1:已发货 -1:已取消)
     * @param retreatDtlState 退货单明细状态 (0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
     * @param orderDtlIds     订单明细id
     * @return
     */
    Map<String, Map<String, BigDecimal>> findMapOrderDetaiCountByDeliverId(String deliverId, String deliveDtlState, String retreatDtlState, String orderDtlIds) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 按订单id-获取订单明细发货信息
     * <订单明细id, 发货信息Map>
     *     发货信息Map
     *         orderId
     *         orderDtlCount:订单明细订购数量
     *         orderDtlSum: 订单明细货品金额
     *         checkCount: 验证数量(发货数量-退货数量)
     *         checkSum: (发货金额-退货金额)
     *
     * 根据发货单id-获取(订单明细id,订购数量,发货数量)
     *
     * @param orderIds  订单id
     * @return
     */
    Map<String, Map<String, Object>> findMapOrderDetaiCountByOrderId(String orderIds) throws Exception;


}
