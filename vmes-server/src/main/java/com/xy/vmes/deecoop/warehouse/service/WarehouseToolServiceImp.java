package com.xy.vmes.deecoop.warehouse.service;

import com.yvan.common.util.Common;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.WarehouseService;
import com.xy.vmes.service.WarehouseToolService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;


/**
 * 说明：仓库货位工具实现类 (vmes_warehouse:仓库货位表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
public class WarehouseToolServiceImp implements WarehouseToolService {
    @Autowired
    private WarehouseService warehouseService;

//    /**
//     * 获取仓库属性(复杂版仓库,简版仓库)
//     * 1. 根据(用户角色id)查询角色菜单表(vmes_role_menu)
//     * 2. 返回值(warehouseByComplex:复杂版仓库 warehouseBySimple:简版仓库)
//     *
//     * @param roleIds  用户角色id
//     * @return
//     */
//    public String findWarehouseAttribute(String roleIds) {
//        if (roleIds == null || roleIds.trim().length() == 0) {
//            return null;
//        }
//
//        roleIds = StringUtil.stringTrimSpace(roleIds);
//        roleIds = "'" + roleIds.replace(",", "','") + "'";
//
//        List<Map<String, Object>> mapList = null;
//        try {
//            PageData findMap = new PageData();
//            findMap.put("roleIds", roleIds);
//            //是否禁用(0:已禁用 1:启用)
//            findMap.put("isdisable", "1");
//            findMap.put("mapSize", Integer.valueOf(findMap.size()));
//            mapList = roleMenuService.findRoleMenuMapList(findMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (mapList == null || mapList.size() == 0) {return null;}
//
//        List<Menu> menuList = roleMenuService.mapList2MenuList(mapList, null);
//        String menuIds = menuService.findMenuidByMenuList(menuList);
//        if (menuIds == null || menuIds.trim().length() == 0) {return null;}
//
//        //warehouseByComplex:复杂版仓库:15a6c4ca92fe42a0a82320287538b727(菜单id)
//        //warehouseBySimple:简版仓库:5abe8f434e114a87a73b85ed74bc78e7(菜单id)
//        menuIds = StringUtil.stringTrimSpace(menuIds);
//        if (menuIds.indexOf(Common.SYS_WAREHOUSE_NAMEKEY_MAP.get("warehouseByComplex")) != -1) {
//            return Common.SYS_WAREHOUSE_COMPLEX;
//        } else if (menuIds.indexOf(Common.SYS_WAREHOUSE_NAMEKEY_MAP.get("warehouseBySimple")) != -1) {
//            return Common.SYS_WAREHOUSE_SIMPLE;
//        }
//
//        return null;
//    }

    /**
     * 虚拟库位-(虚拟库-部门名称-部门货位名称)
     * @param companyId     企业id
     * @param deptId        部门id
     * @param deptName      部门名称
     * @param deptPlaceKey  部门货位Key(字典表:pid:db46547d1bcb4c14baa228db1e8aaffe)
     * @param deptPlaceName 部门货位名称
     * @return
     */
    public Warehouse findWarehouseByVirtual(String companyId,
                                            String deptId,
                                            String deptName,
                                            String deptPlaceKey,
                                            String deptPlaceName) throws ApplicationException {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (deptPlaceKey == null || deptPlaceKey.trim().length() == 0) {
            msgStr.append("部门库位名称id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        Warehouse warehouse = null;
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("deptId", deptId);
            findMap.put("deptPlaceKey", deptPlaceKey);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouse = warehouseService.findWarehouse(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (warehouse == null) {
            String msgTemp = "您所在的部门({0})虚拟库位({0}-{1})不存在或没有创建，请与管理员联系！" + Common.SYS_ENDLINE_DEFAULT;;
            throw new ApplicationException(MessageFormat.format(msgTemp, deptName,deptPlaceName));
        }

        return warehouse;
    }

}
