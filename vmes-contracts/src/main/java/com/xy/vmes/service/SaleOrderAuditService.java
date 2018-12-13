package com.xy.vmes.service;

import com.yvan.PageData;
import java.util.List;
import java.util.Map;

public interface SaleOrderAuditService {
    List<Map> findPageListByLockStock(PageData pd) throws Exception;

    List<Map<String, Object>> findOrderDetaiListByAudit(PageData pd);

    /**
     * 当前订单id下的订单明细(货品id)货品可用库存数量与订购数量比较
     * @param orderId  订单id
     * @return
     */
    List<Map<String, Object>> checkProdStockCountByOrderId(String orderId);

    String findDetailIdsByMapList(List<Map<String, Object>> mapList);
}
