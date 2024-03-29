package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleReceiveDetailByAuditService {
    List<Map> findReceiveDetailMapList(PageData pd, Pagination pg);
    List<Map> findReceiveDetailMapList(PageData pd) throws Exception;
    ResultModel findListSaleReceiveDetailByByAudit(PageData pd, Pagination pg) throws Exception;
}
