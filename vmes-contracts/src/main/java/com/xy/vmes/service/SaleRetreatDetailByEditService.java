package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleRetreatDetailByEditService {
    List<Map> findRetreatDetailByEdit(PageData pageData) throws Exception;
    ResultModel listPageRetreatDetailByEdit(PageData pageData) throws Exception;
}
