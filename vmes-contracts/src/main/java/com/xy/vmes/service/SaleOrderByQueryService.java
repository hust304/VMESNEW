package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单查询汇总 接口类
 * 创建人：陈刚
 * 创建时间：2018-12-28
 */
public interface SaleOrderByQueryService {
    List<Map> findListPageOrderByQuery(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageSaleOrderQuery(PageData pd, Pagination pg) throws Exception;
}
