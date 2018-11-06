package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInWarehouseProductMapper;
import com.xy.vmes.service.WarehouseInWarehouseProductService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 入库管理-获取全部货位信息，同时带出货位存放的货品信息
 * (vmes_warehouse:仓库货位表-vmes_warehouse_product:仓库货位产品库存表) 关联查询
 *
 */
@Service
@Transactional(readOnly = false)
public class WarehouseInWarehouseProductServiceImp implements WarehouseInWarehouseProductService {

    @Autowired
    private WarehouseInWarehouseProductMapper warehouseInWarehouseProductMapper;

    /**
     * 获取全部货位，同时带出该货位存放的货品信息
     *
     * @param pd
     * @param pg
     * @return
     * @throws Exception
     */
    public List<Map> findAllListWarehouse(PageData pd, Pagination pg) throws Exception{
        return warehouseInWarehouseProductMapper.findAllListWarehouse(pd,pg);
    }
}
