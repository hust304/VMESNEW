package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailByLockCountService {
    List<Map> findListOrderDetailByLockCount(PageData pd) throws Exception;
    List<Map> findListOrderDetailByLockCount(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailByLockCount(PageData pd) throws Exception;
}
