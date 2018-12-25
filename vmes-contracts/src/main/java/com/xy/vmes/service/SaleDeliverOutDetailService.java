package com.xy.vmes.service;

import java.util.Map;

/**
 * 说明：发货出库 接口类
 * 创建人：陈刚 自动生成
 * 创建时间：2018-12-25
 */
public interface SaleDeliverOutDetailService {
    /**
     * 发货出库查询(出库明细,发货明细,订单明细)关联查询
     *
     * @param outDtlId 出库明细id
     * @param state    出库明细状态
     * @return
     */
    Map<String, Object> findOutDetailByOrderDetail(String outDtlId, String state);

    /**
     * (发货出库)出库明细出库完成，该出库明细货品解锁库存锁定数量，修改该订单明细(库存锁定数量)
     * 1. 根据出库明细id关联查询(出库明细,发货明细,订单明细)
     * 2. 货品id：修改该货品的库存锁定数量
     * 3. 订单明细id：修改订单明细(库存锁定数量)
     *
     * 出库明细id
     * @param outDtlId 出库明细id
     */
    void finishOutDetailUnlock(String outDtlId) throws Exception;
}
