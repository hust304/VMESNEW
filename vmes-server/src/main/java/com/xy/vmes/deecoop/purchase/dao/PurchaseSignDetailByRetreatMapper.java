package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_sign_detail 采购签收明细关联采购退货 Mapper.java
 * 创建人：陈刚
 * 创建时间：2020-04-15
 */
@Mapper
@Repository
public interface PurchaseSignDetailByRetreatMapper {
    List<Map> findPurchaseSignDetailByRetreat(PageData pd, Pagination pg);
    List<Map> findPurchaseSignDetailByRetreat(PageData pd);
}
