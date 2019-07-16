package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface WarehouseProductByCollectService {
    //获取仓库货品信息(虚拟库)-根据(货品id)汇总
    List<Map> findProductByWarehouseVirtual(PageData pd) throws Exception;
    List<Map> findProductByWarehouseVirtual(PageData pd, Pagination pg) throws Exception;

    List<Map<String, Object>> findProductMapList(PageData pd) throws Exception;
    List<Map<String, Object>> findProductMapListByPage(PageData pd) throws Exception;
}
