package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 手机端移库
 */
public interface MobileWarehouseMoveService {

    //手机端移库详情
    List<Map> findWarehouseMove(PageData pd) throws Exception;

}
