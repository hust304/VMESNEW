package com.xy.vmes.service;

import com.xy.vmes.entity.WarehouseProduct;
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
     * @param warehouseNodeId  指定仓库id 如:(实体库,虚拟库,备件库,虚拟库)
     * @param productCount     货品数量(需要出库数量) 不可为空
     * @return
     */
    List<Map<String, Object>> findWarehouseProductOutMapList (String productId,
                                                              String companyId,
                                                              String warehouseNodeId,
                                                              BigDecimal productCount) throws ApplicationException;


    /**
     * 根据(货品数量:需要出库数量)-获取该货品在库存中的货位货品对应信息(vmes_warehouse_product)-虚拟库
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
     * @param deptId           部门id
     * @param deptPlaceKey     部门库位名称
     * @param productCount     货品数量(需要出库数量) 不可为空
     * @return
     */
    List<Map<String, Object>> findWarehouseProductOutMapListByVirtual (String productId,
                                                                       String companyId,
                                                                       String deptId,
                                                                       String deptPlaceKey,
                                                                       BigDecimal productCount) throws ApplicationException;


    /**
     * (简版仓库)仓库货品减少时-按照先进先出原则-(vmes_warehouse_product)变更库存数量
     *
     * 返回结构体: List<Map<String, Object>>
     * Map<String, Object>
     *    warehouseProductId
     *    outCount
     *
     * @param objectList   List<WarehouseProduct>仓库货品结果集
     * @param changeCount  变更库存数量
     * @return
     */
    List<Map<String, Object>> findWarehouseProductReduceMapListBySimple(List<WarehouseProduct> objectList, BigDecimal changeCount);

    Map<String, WarehouseProduct> warehouseProductList2Map(List<WarehouseProduct> objectList);
}
