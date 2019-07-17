package com.xy.vmes.deecoop.purchase.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：采购订单明细汇总 Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-07-17
 */
@Mapper
@Repository
public interface PurchaseOrderDetailCollectMapper {

    /**
     * 获取(采购数量,签收数量,退货数量[已完成])
     * 按(采购订单明细id)采购订单明细汇总查询
     * 查询相关表
     *   vmes_purchase_order_detail,
     *   vmes_purchase_sign_detail,
     *   vmes_purchase_retreat_detail
     *
     * @param pageData
     * @return
     */
    List<Map<String, Object>> findPurchaseOrderDetailCollect(PageData pageData);
}
