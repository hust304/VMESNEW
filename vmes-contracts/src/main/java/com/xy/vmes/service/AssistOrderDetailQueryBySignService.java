package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：外协订单明细查询汇总 接口类
 * 创建人：陈刚
 * 创建时间：2020-05-04
 */
public interface AssistOrderDetailQueryBySignService {
    List<Map> listAssistOrderDetaiQueryBySign(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistOrderDetaiQueryBySign(PageData pd) throws Exception;
}
