package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 说明：创建入库单 (vmes_warehouse_in:仓库入库单)
 * 1. 创建复杂版仓库(入库单)
 * 2. 创建简版仓库(入库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
@Transactional(readOnly = false)
public class WarehouseInCreateServiceImp implements WarehouseInCreateService {
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;

    public void createWarehouseInByComplex() {}
    public void createWarehouseInBySimple() {}
}
