package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 手机端入库
 */
public interface MobileWarehouseInService {


    //手机端入库详情
    List<Map> findWarehouseIn(PageData pd) throws Exception;


}
