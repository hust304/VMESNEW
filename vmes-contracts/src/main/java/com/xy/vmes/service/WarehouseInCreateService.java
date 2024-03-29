package com.xy.vmes.service;

import com.xy.vmes.exception.ApplicationException;

import java.util.Map;

/**
 * 说明：创建入库单 (vmes_warehouse_in:仓库入库单)
 * 1. 创建复杂版仓库(入库单)
 * 2. 创建简版仓库(入库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseInCreateService {
    /**
     * 创建入库单(复杂版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInByComplex(String deptId,
                                    String deptName,
                                    String warehouseId,
                                    String cuser,
                                    String companyId,
                                    String inType,
                                    Map<String, Map<String, Object>> productByInMap) throws ApplicationException;
    /**
     * 创建入库单(复杂版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param remark         (入库)备注
     * @param businessCode    业务单号
     * @param businessByInMap 业务货品入库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInBusinessByComplex(String deptId,
                                            String deptName,
                                            String warehouseId,
                                            String cuser,
                                            String companyId,
                                            String inType,
                                            String remark,
                                            String businessCode,
                                            Map<String, Map<String, Object>> businessByInMap) throws ApplicationException;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建入库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInBySimple(String deptId,
                                   String deptName,
                                   String warehouseId,
                                   String cuser,
                                   String companyId,
                                   String inType,
                                   Map<String, Map<String, Object>> productByInMap) throws ApplicationException;
    /**
     * 创建入库单(简版仓库)-执行时需要人工干预-系统非自动执行
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param remark         (入库)备注
     * @param businessCode    业务单号
     * @param businessByInMap 业务货品入库Map<货品id, 货品Map>
     *
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     warehouseId: 入库货位id(仓库id)
     *     productId:   货品id
     *     inDtlId:     入库明细id
     *     inCount:     入库数量
     */
    void createWarehouseInBusinessBySimple(String deptId,
                                           String deptName,
                                           String warehouseId,
                                           String cuser,
                                           String companyId,
                                           String inType,
                                           String remark,
                                           String businessCode,
                                           Map<String, Map<String, Object>> businessByInMap) throws ApplicationException;

    /**
     * 创建入库单(简版仓库)-执行时无需人工干预-系统自动执行
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param businessByInMap 业务货品入库Map<货品id, 货品Map>
     *
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     warehouseId: 入库货位id(仓库id)
     *     productId:   货品id
     *     inDtlId:     入库明细id
     *     inCount:     入库数量
     */
    void createWarehouseInExecuteBusinessBySimple(String deptId,
                                                  String deptName,
                                                  String warehouseId,
                                                  String cuser,
                                                  String companyId,
                                                  String inType,
                                                  Map<String, Map<String, Object>> businessByInMap) throws ApplicationException;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建入库单(备件库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInBySpare(String deptId,
                                  String deptName,
                                  String warehouseId,
                                  String cuser,
                                  String companyId,
                                  String inType,
                                  Map<String, Map<String, Object>> productByInMap) throws ApplicationException;
    /**
     * 创建入库单(备件库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param businessByInMap 业务货品入库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInBusinessBySpare(String deptId,
                                  String deptName,
                                  String warehouseId,
                                  String cuser,
                                  String companyId,
                                  String inType,
                                  Map<String, Map<String, Object>> businessByInMap) throws ApplicationException;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建入库单(虚拟库)-与简版入库单类似
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param deptPlaceKey    部门库位key
     * @param deptPlaceName   部门库位名称
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInByVirtual(String deptId,
                                    String deptName,
                                    String deptPlaceKey,
                                    String deptPlaceName,
                                    String cuser,
                                    String companyId,
                                    String inType,
                                    Map<String, Map<String, Object>> productByInMap) throws ApplicationException;
    /**
     * 创建入库单(虚拟库)-与简版入库单类似
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param deptPlaceKey    部门库位key
     * @param deptPlaceName   部门库位名称
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param businessByInMap 业务货品入库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    void createWarehouseInBusinessByVirtual(String deptId,
                                    String deptName,
                                    String deptPlaceKey,
                                    String deptPlaceName,
                                    String cuser,
                                    String companyId,
                                    String inType,
                                    Map<String, Map<String, Object>> businessByInMap) throws ApplicationException;
}
