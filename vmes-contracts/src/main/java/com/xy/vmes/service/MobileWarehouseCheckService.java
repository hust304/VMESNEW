package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 手机端盘点
 */
public interface MobileWarehouseCheckService {


    //获得盘点任务详细信息
    List<Map> findWarehouseCheck(PageData pd) throws Exception;


}
