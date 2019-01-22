package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface SaleOrderByInvoiceService {
    List<Map> findListPageOrderByInvoice(PageData pd, Pagination pg) throws Exception;
}