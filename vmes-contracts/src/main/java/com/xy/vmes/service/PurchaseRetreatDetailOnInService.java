package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：采购退货明细关联入库明细 接口类
 * 创建人：陈刚
 * 创建时间：2019-08-28
 */
public interface PurchaseRetreatDetailOnInService {
    List<Map> findPurchaseRetreatDetailOnInDetail(PageData pd, Pagination pg) throws Exception;
}
