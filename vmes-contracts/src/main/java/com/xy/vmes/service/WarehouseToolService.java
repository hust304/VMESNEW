package com.xy.vmes.service;

/**
 * 说明：仓库货位工具接口 (vmes_warehouse:仓库货位表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
public interface WarehouseToolService {
    /**
     * 获取仓库属性(复杂版仓库,简版仓库)
     * 1. 根据(用户角色id)查询角色菜单表(vmes_role_menu)
     * 2. 返回值(warehouseByComplex:复杂版仓库 warehouseBySimple:简版仓库)
     * @param roleId  用户角色id
     * @return
     */
    String findWarehouseAttribute(String roleId);
}
