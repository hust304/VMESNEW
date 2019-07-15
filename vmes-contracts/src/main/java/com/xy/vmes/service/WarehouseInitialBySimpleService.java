package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：(简版)仓库初始化设定 接口类
 * 创建人：陈刚
 * 创建时间：2019-07-15
 */
public interface WarehouseInitialBySimpleService {
    //仓库初始化(简版仓库)
    List<Map> findWarehouseInitialBySimple(PageData pd, Pagination pg) throws Exception;

    ResultModel findWarehouseInitialBySimple(PageData pd) throws Exception;
    ResultModel deleteWarehouseProductBySimple(PageData pageData) throws Exception;
    ResultModel updateWarehouseProductBySimple(PageData pageData) throws Exception;
}
