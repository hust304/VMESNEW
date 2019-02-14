package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderCollectService {
    List<Map> findListPageOrderCollectByInfo(PageData pd) throws Exception;
    List<Map> findListPageOrderCollectByInfo(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderCollectByInfo(PageData pd) throws Exception;
}
