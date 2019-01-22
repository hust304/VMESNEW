package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 手机端入库
 */
public interface MobileWarehouseInService {


    //手机端入库详情
    ResultModel findWarehouseIn(PageData pd) throws Exception;


    ResultModel addWarehouseInExecute(PageData pageData) throws Exception;

    ResultModel rebackWarehouseInExecute(PageData pageData) throws Exception;

    ResultModel listWarehouseNodeByPid(PageData pd) throws Exception;
}
