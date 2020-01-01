package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：采购订单明细查询汇总 接口类
 * 采购-采购收货-生成收货单-收货-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2019-12-31
 */
public interface PurchaseOrderDetailQueryBySignService {
    List<Map> listOrderDetaiQueryBySign(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailQueryBySign(PageData pd) throws Exception;
}
