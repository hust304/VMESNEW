package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface WarehouseInWarehouseProductService {
    /**
     * 获取全部货位，同时带出该货位存放的货品信息
     *
     * @param pd
     * @param pg
     * @return
     * @throws Exception
     */
    List<Map> findAllListWarehouse(PageData pd, Pagination pg) throws Exception;
}
