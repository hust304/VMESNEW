package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailByChangeService {
    List<Map> listOrderDetaiByChange(PageData pd) throws Exception;
    ResultModel listPageOrderDetaiByChange(PageData pageData) throws Exception;
}
