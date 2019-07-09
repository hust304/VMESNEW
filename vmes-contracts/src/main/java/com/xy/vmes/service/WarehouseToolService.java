package com.xy.vmes.service;

import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.exception.ApplicationException;

/**
 * 说明：仓库货位工具接口 (vmes_warehouse:仓库货位表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseToolService {
//    /**
//     * 获取仓库属性(复杂版仓库,简版仓库)
//     * 1. 根据(用户角色id)查询角色菜单表(vmes_role_menu)
//     * 2. 返回值(warehouseByComplex:复杂版仓库 warehouseBySimple:简版仓库)
//     * @param roleId  用户角色id
//     * @return
//     */
//    String findWarehouseAttribute(String roleId);

    /**
     * 虚拟库位-(虚拟库-部门名称-部门货位名称)
     * @param companyId     企业id
     * @param deptId        部门id
     * @param deptName      部门名称
     * @param deptPlaceKey  部门货位Key(字典表:pid:db46547d1bcb4c14baa228db1e8aaffe)
     * @param deptPlaceName 部门货位名称
     * @return
     */
    Warehouse findWarehouseByVirtual(String companyId,
                                     String deptId,
                                     String deptName,
                                     String deptPlaceKey,
                                     String deptPlaceName) throws ApplicationException;
}
