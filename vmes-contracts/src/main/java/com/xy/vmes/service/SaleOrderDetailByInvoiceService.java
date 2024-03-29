package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailByInvoiceService {
    List<Map> findListPageOrderDetailByInvoice(PageData pd) throws Exception;
    List<Map> findListPageOrderDetailByInvoice(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailByInvoice(PageData pd, Pagination pg) throws Exception;
}
