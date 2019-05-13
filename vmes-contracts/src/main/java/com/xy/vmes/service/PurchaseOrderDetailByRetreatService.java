package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderDetailByRetreatService {
    List<Map> findOrderDetailByRetreat(PageData pd) throws Exception;
    ResultModel listPageOrderDetailByRetreat(PageData pageData) throws Exception;

}
