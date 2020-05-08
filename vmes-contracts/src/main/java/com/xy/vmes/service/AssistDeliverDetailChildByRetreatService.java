package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_deliver_detail_child:外协发货明细明细子表 接口类
 * 外协-退货管理-生成退货单(退料)
 * 创建人：陈刚
 * 创建时间：2020-05-08
 */
public interface AssistDeliverDetailChildByRetreatService {
    List<Map> findAssistDeliverDetailChildByRetreat(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistDeliverDetailChildByRetreat(PageData pd) throws Exception;
}
