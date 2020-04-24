package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface AssistProductBySupplierService {

    List<Map> listAssistProductBySupplier(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageAssistProductBySupplier(PageData pd) throws Exception;

}
