package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总 接口类
 * 创建人：陈刚
 * 创建时间：2018-12-27
 */
public interface SaleOrderDetailByQueryService {
    List<Map> findListPageOrderDetaiByQuery(PageData pd) throws Exception;
    List<Map> findListPageOrderDetaiByQuery(PageData pd, Pagination pg) throws Exception;
}
