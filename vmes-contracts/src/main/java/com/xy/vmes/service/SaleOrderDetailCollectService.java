package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailCollectService {
    List<Map> findListPageOrderDetailCollectByInfo(PageData pd) throws Exception;
    List<Map> findListPageOrderDetailCollectByInfo(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailCollectByInfo(PageData pd) throws Exception;
}
