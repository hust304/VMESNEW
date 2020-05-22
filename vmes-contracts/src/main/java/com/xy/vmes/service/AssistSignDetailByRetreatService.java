package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_sign_detail:外协签收明细 接口类
 * 外协-外协件退货-生成退货(成品退货)
 *
 * 创建人：陈刚
 * 创建时间：2020-05-12
 */
public interface AssistSignDetailByRetreatService {
    List<Map> findAssistSignDetailByRetreat(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistSignDetailByRetreat(PageData pd) throws Exception;
}
