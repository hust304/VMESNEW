package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：销售订单查询 接口类
 * 采购-采购计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-01-20
 */
public interface SaleOrderByPurchasePlanService {
    List<Map> listOrderByPurchasePlan(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageOrderByPurchasePlan(PageData pd) throws Exception;
}
