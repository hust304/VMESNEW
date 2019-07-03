package com.xy.vmes.service;

/**
 * 说明：创建出库单 (vmes_warehouse_out:仓库出库单)
 * 1. 创建复杂版仓库(出库单)
 * 2. 创建简版仓库(出库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseOutCreateService {
    void createWarehouseOutByComplex();
    void createWarehouseOutBySimple();
}
