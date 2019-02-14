package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 手机端盘点
 */
public interface MobileWarehouseCheckService {


    //获得盘点任务详细信息
    ResultModel findWarehouseCheck(PageData pd) throws Exception;

    ResultModel addWarehouseCheckExecute(PageData pageData) throws Exception;

    ResultModel rebackWarehouseCheckByDetail(PageData pageData) throws Exception;

    ResultModel auditDisagreeWarehouseCheck(PageData pageData) throws Exception;

    ResultModel auditPassWarehouseCheck(PageData pageData) throws Exception;

    ResultModel listWarehouseCheckByAduited(PageData pd, Pagination pg) throws Exception;

    ResultModel listWarehouseCheckByAduiting(PageData pd, Pagination pg) throws Exception;

    ResultModel findWarehouseCheckById(PageData pd) throws Exception;
}
