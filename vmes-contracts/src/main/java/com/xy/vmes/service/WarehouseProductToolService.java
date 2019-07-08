package com.xy.vmes.service;

import com.xy.vmes.exception.ApplicationException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 说明：仓库货品工具接口 (vmes_warehouse_product:仓库货品表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseProductToolService {

    /**
     * 根据(货品数量:需要出库数量)-获取该货品在库存中的货位货品对应信息(vmes_warehouse_product)
     * 1. (货品id,企业id)查询仓库货位表(vmes_warehouse_product)
     * 2. 根据(货品数量:需要出库数量)-遍历查询结果集-按照先入先出原则得到出库的(货位,批次,货品)库存信息
     *
     * 返回结构体: List<Map<String, Object>>
     * Map<String, Object>
     *    warehouseProductId
     *    productId
     *    warehouseId
     *    outCount
     *
     * @param productId        货品id 不可为空
     * @param companyId        企业id 允许为空
     * @param warehouseEdition 仓库版本 (warehouseByComplex:复杂版仓库 warehouseBySimple:简版仓库)
     * @param productCount     货品数量(需要出库数量) 不可为空
     * @return
     */
    List<Map<String, Object>> findWarehouseProductOutMapList (String productId,
                                                              String companyId,
                                                              String warehouseEdition,
                                                              BigDecimal productCount) throws ApplicationException;
}
