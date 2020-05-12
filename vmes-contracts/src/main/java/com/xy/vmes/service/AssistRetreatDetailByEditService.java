package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface AssistRetreatDetailByEditService {
    List<Map> findAssistRetreatDetailEditByProduct(PageData pd, Pagination pg) throws Exception;
    List<Map> findAssistRetreatDetailEdit(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageAssistRetreatDetailEditByProduct(PageData pd) throws Exception;
    ResultModel listPageAssistRetreatDetailEdit(PageData pd) throws Exception;
}
