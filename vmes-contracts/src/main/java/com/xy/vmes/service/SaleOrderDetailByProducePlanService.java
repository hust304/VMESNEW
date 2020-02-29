package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：销售订单明细查询 接口类
 * 生产-生产计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-02-29
 */
public interface SaleOrderDetailByProducePlanService {
    List<Map> listOrderDetaiByProducePlan(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageOrderDetaiByProducePlan(PageData pd) throws Exception;



}
