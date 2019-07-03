package com.xy.vmes.service;

/**
 * 说明：创建入库单 (vmes_warehouse_in:仓库入库单)
 * 1. 创建复杂版仓库(入库单)
 * 2. 创建简版仓库(入库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseInCreateService {
    void createWarehouseInByComplex();
    void createWarehouseInBySimple();
}
