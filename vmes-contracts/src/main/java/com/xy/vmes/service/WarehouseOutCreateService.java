package com.xy.vmes.service;

import java.util.Map;

/**
 * 说明：创建出库单 (vmes_warehouse_out:仓库出库单)
 * 1. 创建复杂版仓库(出库单)
 * 2. 创建简版仓库(出库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseOutCreateService {
    /**
     * 创建出库单(复杂版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    void createWarehouseOutByComplex(String deptId,
                                     String deptName,
                                     String warehouseId,
                                     String cuser,
                                     String companyId,
                                     String outType,
                                     Map<String, Map<String, Object>> productByOutMap) throws Exception;

    /**
     * 创建出库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    void createWarehouseOutBySimple(String deptId,
                                    String deptName,
                                    String warehouseId,
                                    String cuser,
                                    String companyId,
                                    String outType,
                                    Map<String, Map<String, Object>> productByOutMap) throws Exception;

    /**
     * 创建出库单(备件库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id(备件库id)
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    void createWarehouseOutByBySpare(String deptId,
                                     String deptName,
                                     String warehouseId,
                                     String cuser,
                                     String companyId,
                                     String outType,
                                     Map<String, Map<String, Object>> productByOutMap) throws Exception;

    /**
     * 创建出库单(虚拟库)-与简版出库单类似
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param deptPlaceKey    部门库位key
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    void createWarehouseOutByVirtual(String deptId,
                                     String deptName,
                                     String deptPlaceKey,
                                     String cuser,
                                     String companyId,
                                     String outType,
                                     Map<String, Map<String, Object>> productByOutMap) throws Exception;
}
