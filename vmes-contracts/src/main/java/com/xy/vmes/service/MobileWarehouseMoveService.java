package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 手机端移库
 */
public interface MobileWarehouseMoveService {

    //手机端移库详情
    ResultModel findWarehouseMove(PageData pd) throws Exception;

    ResultModel addWarehouseMoveExecute(PageData pageData) throws Exception;

    ResultModel rebackWarehouseMoveDetail(PageData pageData) throws Exception;
}
