package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductByCollectMapper;
import com.xy.vmes.service.WarehouseProductByCollectService;
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

    public List<Map> findProductByVirtual(PageData pd) throws Exception {
        return warehouseProductByCollectMapper.findProductByVirtual(pd);
    }

    public List<Map> findProductByVirtual(PageData pd, Pagination pg) throws Exception {
        return warehouseProductByCollectMapper.findProductByVirtual(pd, pg);
    }
}
