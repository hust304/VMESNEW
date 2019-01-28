package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderByInvoiceService {
    List<Map> findListPageOrderByInvoice(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderByInvoice(PageData pd, Pagination pg) throws Exception;
}
