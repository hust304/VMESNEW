package com.xy.vmes.service;

import java.util.List;
import java.util.Map;

/**
 * 说明：发货出库 接口类
 * 创建人：陈刚 自动生成
 * 创建时间：2018-12-25
 */
public interface SaleDeliverOutDetailService {
    List<Map<String, Object>> findDeliverDetailListByOrderId(String orderId, String state);
    List<Map<String, Object>> findDeliverDetailListByDeliverId(String deliverId);

    /**
     * 发货出库查询(出库明细,发货明细,订单明细)关联查询
     *
     * @param outDtlId 出库明细id
     * @param state    出库明细状态
     * @return
     */
    Map<String, Object> findOutDetailByOrderDetail(String outDtlId, String state);

    /**
     * (发货出库)出库明细出库完成，
     * 根据(出库明细id,出库状态:(2已完成))关联查询(出库明细,发货明细,订单明细)
     * 1. (出库数量)修改货品库存锁定数量
     * 2. (出库数量)修改订单明细(库存锁定数量)
     *
     * @param outDtlId 出库明细id
     */
    void finishOutDetailUnlock(String outDtlId) throws Exception;
}
