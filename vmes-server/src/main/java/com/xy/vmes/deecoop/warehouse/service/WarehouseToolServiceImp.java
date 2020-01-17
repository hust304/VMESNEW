package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.*;
import com.yvan.common.util.Common;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.exception.ApplicationException;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


/**
 * 说明：仓库货位工具实现类 (vmes_warehouse:仓库货位表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
public class WarehouseToolServiceImp implements WarehouseToolService {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private SaleRetreatDetailOnInService saleRetreatService;
    @Autowired
    private PurchaseSignDetailOnInService purchaseSignService;

    @Autowired
    private SaleDeliverDtlOnOutDtlService saleDeliverService;
    @Autowired
    private PurchaseRetreatDetailOnOutService purchaseRetreatService;

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

    /**
     * 是否存在业务数据-根据(入库单id,入库类型)
     * 返回值：
     *     Boolean.TRUE:  存在
     *     Boolean.FALSE: 不存在
     *
     * @param parentId  入库单id
     * @param type      入库类型(字典表id 字典表:pid:550e0457a3d34149ba3199d90b0ae198)
     * @return
     */
    public Boolean isExistBusinessByWarehouseIn(String parentId, String type) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return Boolean.FALSE;}
        if (type == null || type.trim().length() == 0) {return Boolean.FALSE;}

        //pid:550e0457a3d34149ba3199d90b0ae198:入库类型 12
        //2c4a104aedc046848455f5fa6e3da87c 生产入库 -(部门)
        //8e35209f19804e94940f076c8d71b955 生产退料 -(部门)
        //80ac00503a1d41e5926be50f93c32c54 组装入库
        //c396683796d54b8693b522a2c0ad2793 维修领料退回入库
        //d9c9eb85db0d4c8faa09ddc2b8173859 保养领料退回入库
        //4ac4616c7b254950af24e0c8eda0c6f7 备件入库
        //3ba2e016ac78464eb947c727ff41faf0 虚拟库入库
        //4d89ccb1e64f499cbdc6409f173f5407 盘盈

        //type:4:供应商
        //d78ceba5beef41f5be16f0ceee775399 采购入库 -(供应商)
        //064dda15d44d4f8fa6330c5c7e46300e 外协入库 -(供应商)

        //type:3:客户
        //81907167d5c8498692e6c4f3694c5cfa 销售退货入库 -(客户)
        //d1c6dc9aa3b045dbabff2d5e1e253c22 销售变更退货入库

        ////////////////////////////////////////////////////////////////////////////////////
        //销售部分
        //81907167d5c8498692e6c4f3694c5cfa 销售退货入库:saleRetreatIn
        if (Common.DICTIONARY_MAP.get("saleRetreatIn").equals(type.trim())) {
            PageData findMap = new PageData();
            findMap.put("inParentId", parentId);
            //SQL查询语句: SaleRetreatDetailOnInMapper.findSaleRetreatDetailOnInDetail
            List<Map> mapList = saleRetreatService.findSaleRetreatDetailOnInDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////
        //采购部分
        //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
        if (Common.DICTIONARY_MAP.get("purchaseIn").equals(type.trim())) {
            //1. (免检)入库单明细
            PageData findMap = new PageData();
            findMap.put("inParentId", parentId);
            //SQL查询语句: PurchaseSignDetailOnInMapper.findPurchaseSignDetailOnInDetail
            List<Map> mapList = purchaseSignService.findPurchaseSignDetailOnInDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }

            //2. (检验入库)入库单明细
            findMap = new PageData();
            findMap.put("qualityInParentId", parentId);
            //SQL查询语句: PurchaseSignDetailOnInMapper.findPurchaseSignDetailOnInDetail
            mapList = purchaseSignService.findPurchaseSignDetailOnInDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }

            //3. (检验让步接收入库)入库单明细
            findMap = new PageData();
            findMap.put("receiveInParentId", parentId);
            //SQL查询语句: PurchaseSignDetailOnInMapper.findPurchaseSignDetailOnInDetail
            mapList = purchaseSignService.findPurchaseSignDetailOnInDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }

        }

        return Boolean.FALSE;
    }

    /**
     * 是否存在业务数据-根据(出库单id,出库类型)
     * 返回值：
     *     Boolean.TRUE:  存在
     *     Boolean.FALSE: 不存在
     *
     * @param parentId  出库单id
     * @param type      出库类型(字典表id 字典表:pid:20c09785a7b54ec280d10c988be21929)
     * @return
     */
    public Boolean isExistBusinessByWarehouseOut(String parentId, String type) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return Boolean.FALSE;}
        if (type == null || type.trim().length() == 0) {return Boolean.FALSE;}

        //pid:20c09785a7b54ec280d10c988be21929:出库类型 11
        //609fa44c031847569a1d9e2516be4b41 组装出库 -(组装区)
        //cb0a55d81e754cd3b59715d225dab087 生产领料出库 -(虚拟库)
        //fa51ae2e17a9409d822fc4c9192d652c 维修领料出库
        //8bcbc84893cf46daabbd2522bee482ad 保养领料出库
        //12e84fefddc449a78cc3bf8075475823 备件出库
        //9c7be2410a0045c8963f9273fe6da067 虚拟库出库
        //55bdf3529c3c463489670a46c2651c1e 盘亏
        //f2b0aaceff914acd8636700a111ca8f0 办公用品出库
        //def4b13175dc44b08d7a0315b811700e 报废处理

        //type:4:供应商
        //4cba5d3815644b26920777512a20474b 采购退货出库 -(供应商)
        //type:3:客户
        //9459be975cd94ada8443cdf32f52c2be 销售发货出库 -(客户)

        ////////////////////////////////////////////////////////////////////////////////////
        //销售部分
        //9459be975cd94ada8443cdf32f52c2be 销售发货出库:saleOut
        if (Common.DICTIONARY_MAP.get("saleOut").equals(type.trim())) {
            PageData findMap = new PageData();
            findMap.put("outParentId", parentId);
            //SQL查询语句: SaleDeliverDtlOnOutDtlMapper.findSaleDeliverDetailOnOutDetail
            List<Map> mapList = saleDeliverService.findSaleDeliverDetailOnOutDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////
        //采购部分
        //4cba5d3815644b26920777512a20474b 采购退货出库:purchaseOut
        if (Common.DICTIONARY_MAP.get("purchaseOut").equals(type.trim())) {
            PageData findMap = new PageData();
            findMap.put("outParentId", parentId);
            //SQL查询语句: PurchaseRetreatDetailOnOutMapper.findPurchaseRetreatDetailOnOutDetail
            List<Map> mapList = purchaseRetreatService.findPurchaseRetreatDetailOnOutDetail(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

}
