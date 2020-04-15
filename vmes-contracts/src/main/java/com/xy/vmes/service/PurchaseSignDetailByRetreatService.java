package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_sign_detail 采购签收明细关联采购退货 接口类
 * 创建人：陈刚
 * 创建时间：2020-04-15
 */
public interface PurchaseSignDetailByRetreatService {
    List<Map> findPurchaseSignDetailByRetreat(PageData pd, Pagination pg) throws Exception;
    String findSignCodeByRetreatId(String retreatId) throws Exception;

}
