package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_order_detail_child:外协订单明细子表 接口类
 * 外协-发货管理-生成发货单 (订单明细中-生成发货单)
 * 创建人：陈刚
 * 创建时间：2020-04-19
 */
public interface AssistOrderDetailChildByAssistDeliverService {

    List<Map> findAssistOrderDetailChildByDeliver(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistOrderDetailChildByDeliver(PageData pd) throws Exception;

    List<Map<String, Object>> checkAssistOrderDetailChildByDeliver(PageData pd);
}

