package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

/**
 * 手机端入库
 */
public interface MobileWarehouseService {


    ResultModel findEmployeeInfo(PageData pd) throws Exception;

}
