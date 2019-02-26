package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleDeliverDetailByRetreatService {

    List<Map> findDeliverDetailByRetreat(PageData pageData) throws Exception;

    ResultModel listPageDeliverDetailByRetreat(PageData pageData) throws Exception;
}
