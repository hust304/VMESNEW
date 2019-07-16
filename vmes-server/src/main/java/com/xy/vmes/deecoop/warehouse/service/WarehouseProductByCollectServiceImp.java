package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductByCollectMapper;
import com.xy.vmes.service.WarehouseProductByCollectService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class WarehouseProductByCollectServiceImp implements WarehouseProductByCollectService {
    @Autowired
    private WarehouseProductByCollectMapper warehouseProductByCollectMapper;

    //获取仓库货品信息(虚拟库)-根据(货品id)汇总
    public List<Map> findProductByWarehouseVirtual(PageData pd) throws Exception {
        return warehouseProductByCollectMapper.findProductByWarehouseVirtual(pd);
    }
    public List<Map> findProductByWarehouseVirtual(PageData pd, Pagination pg) throws Exception {
        return warehouseProductByCollectMapper.findProductByWarehouseVirtual(pd, pg);
    }

    @Override
    public List<Map<String, Object>> findProductMapList(PageData pd) throws Exception {
        return warehouseProductByCollectMapper.findProductMapList(pd);
    }

    @Override
    public List<Map<String, Object>> findProductMapListByPage(PageData pd) throws Exception {
        Pagination pg = (Pagination) HttpUtils.parsePagination(pd);
        return warehouseProductByCollectMapper.findProductMapList(pd,pg);
    }
}
