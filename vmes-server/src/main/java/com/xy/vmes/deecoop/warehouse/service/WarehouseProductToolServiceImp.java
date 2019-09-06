package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.WarehouseProductService;
import com.xy.vmes.service.WarehouseProductToolService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：仓库货品工具实现类 (vmes_warehouse_product:仓库货位表)
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
@Transactional(readOnly = false)
public class WarehouseProductToolServiceImp implements WarehouseProductToolService {
    @Autowired
    private WarehouseProductService warehouseProductService;

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
     * @param warehouseNodeId  指定仓库id 如:(实体库,虚拟库,备件库,虚拟库) 允许为空(null:该企业仓库出库 not null:指定的仓库出库)
     * @param productCount     货品数量(需要出库数量) 不可为空
     * @return
     */
    public List<Map<String, Object>> findWarehouseProductOutMapList (String productId,
                                                                     String companyId,
                                                                     String warehouseNodeId,
                                                                     BigDecimal productCount) throws ApplicationException {
        if (productId == null || productId.trim().length() == 0) {
            throw new ApplicationException("货品id为空或空字符串");
        }
        if (productCount == null) {
            throw new ApplicationException("货品数量为空");
        } else if (productCount != null && 0L == productCount.longValue()) {
            throw new ApplicationException("货品数量不可为零");
        }
        List<Map<String, Object>> outMapList = new ArrayList<Map<String, Object>>();

        //1. (货品id,企业id)查询仓库货位表(vmes_warehouse_product) 按(cdate) 升序
        //按照先入先出原则得到出库的(货位,批次,货品)库存信息
        List<WarehouseProduct> objectList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("productId", productId);
            if (companyId != null && companyId.trim().length() > 0) {
                findMap.put("companyId", companyId.trim());
            }

            //warehouseNodeId  指定仓库id 如:(实体库,虚拟库,备件库,虚拟库)
            if (warehouseNodeId != null && warehouseNodeId.trim().length() > 0) {
                findMap.put("warehouseNodeId", warehouseNodeId);

            }
            findMap.put("queryStr", "stock_count > 0 ");
            findMap.put("orderStr", "cdate asc");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));

            objectList = warehouseProductService.findWarehouseProductList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectList == null || objectList.size() == 0) {return outMapList;}

        //addCount:累加器(库存数量)
        BigDecimal addCount = BigDecimal.valueOf(0D);
        //2. 遍历结果集 List<WarehouseProduct>
        for (WarehouseProduct object : objectList) {
            Map<String, Object> valueMap = new HashMap<String, Object>();

            String warehouseProductId = object.getId();
            valueMap.put("warehouseProductId", warehouseProductId);
            valueMap.put("productId", productId);

            String warehouseId = object.getWarehouseId();
            valueMap.put("warehouseId", warehouseId);

            //库存数量 stockCount
            BigDecimal stockCount = object.getStockCount();
            addCount = BigDecimal.valueOf(addCount.doubleValue() + stockCount.doubleValue());
            if (addCount.doubleValue() <= productCount.doubleValue()) {
                valueMap.put("outCount", stockCount);
                outMapList.add(valueMap);
                if (addCount.doubleValue() == productCount.doubleValue()) {
                    return outMapList;
                }
            } else if (addCount.doubleValue() > productCount.doubleValue()) {
                //出库数量 := 库存数量 + (需要出库数量 - 累加器(库存数量))
                BigDecimal outCount = BigDecimal.valueOf(stockCount.doubleValue() + (productCount.doubleValue() - addCount.doubleValue()));
                valueMap.put("outCount", outCount);
                outMapList.add(valueMap);
                return outMapList;
            }
        }

        return outMapList;
    }

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
    public List<Map<String, Object>> findWarehouseProductOutMapListByVirtual (String productId,
                                                                              String companyId,
                                                                              String deptId,
                                                                              String deptPlaceKey,
                                                                              BigDecimal productCount) throws ApplicationException {
        if (productId == null || productId.trim().length() == 0) {
            throw new ApplicationException("货品id为空或空字符串");
        }
        if (deptId == null || deptId.trim().length() == 0) {
            throw new ApplicationException("部门id为空或空字符串");
        }
        if (deptPlaceKey == null || deptPlaceKey.trim().length() == 0) {
            throw new ApplicationException("部门库位为空或空字符串");
        }

        if (productCount == null) {
            throw new ApplicationException("货品数量为空");
        } else if (productCount != null && 0L == productCount.longValue()) {
            throw new ApplicationException("货品数量不可为零");
        }
        List<Map<String, Object>> outMapList = new ArrayList<Map<String, Object>>();

        //1. (货品id,企业id)查询仓库货位表(vmes_warehouse_product) 按(cdate) 升序
        //按照先入先出原则得到出库的(货位,批次,货品)库存信息
        List<WarehouseProduct> objectList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("productId", productId);
            if (companyId != null && companyId.trim().length() > 0) {
                findMap.put("companyId", companyId.trim());
            }
            //仓库版本 (warehouseByVirtual:虚拟库)
            findMap.put("warehouseEdition", "warehouseByVirtual");
            findMap.put("deptId", deptId);
            findMap.put("deptPlaceKey", deptPlaceKey);
            findMap.put("queryStr", "stock_count > 0 ");
            findMap.put("orderStr", "cdate asc");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));

            objectList = warehouseProductService.findWarehouseProductList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectList == null || objectList.size() == 0) {return outMapList;}

        //addCount:累加器(库存数量)
        BigDecimal addCount = BigDecimal.valueOf(0D);
        //2. 遍历结果集 List<WarehouseProduct>
        for (WarehouseProduct object : objectList) {
            Map<String, Object> valueMap = new HashMap<String, Object>();

            String warehouseProductId = object.getId();
            valueMap.put("warehouseProductId", warehouseProductId);
            valueMap.put("productId", productId);

            String warehouseId = object.getWarehouseId();
            valueMap.put("warehouseId", warehouseId);

            //库存数量 stockCount
            BigDecimal stockCount = object.getStockCount();
            addCount = BigDecimal.valueOf(addCount.doubleValue() + stockCount.doubleValue());
            if (addCount.doubleValue() <= productCount.doubleValue()) {
                valueMap.put("outCount", stockCount);
                outMapList.add(valueMap);
                if (addCount.doubleValue() == productCount.doubleValue()) {
                    return outMapList;
                }
            } else if (addCount.doubleValue() > productCount.doubleValue()) {
                //出库数量 := 库存数量 + (需要出库数量 - 累加器(库存数量))
                BigDecimal outCount = BigDecimal.valueOf(stockCount.doubleValue() + (productCount.doubleValue() - addCount.doubleValue()));
                valueMap.put("outCount", outCount);
                outMapList.add(valueMap);
                return outMapList;
            }
        }

        return outMapList;
    }

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
    public List<Map<String, Object>> findWarehouseProductReduceMapListBySimple(List<WarehouseProduct> objectList, BigDecimal changeCount) {
        List<Map<String, Object>> outMapList = new ArrayList<Map<String, Object>>();
        if (objectList == null || objectList.size() == 0) {return outMapList;}
        if (changeCount == null) {return outMapList;}

        //List<WarehouseProduct> objectList，按(cdate)升序排列
        warehouseProductService.orderAcsByCdate(objectList);

        //addCount:累加器(库存数量)
        BigDecimal addCount = BigDecimal.valueOf(0D);
        //2. 遍历结果集 List<WarehouseProduct>
        for (WarehouseProduct object : objectList) {
            Map<String, Object> valueMap = new HashMap<String, Object>();

            String warehouseProductId = object.getId();
            valueMap.put("warehouseProductId", warehouseProductId);

            //库存数量 stockCount
            BigDecimal stockCount = object.getStockCount();
            addCount = BigDecimal.valueOf(addCount.doubleValue() + stockCount.doubleValue());
            if (addCount.doubleValue() <= changeCount.doubleValue()) {
                valueMap.put("outCount", stockCount);
                outMapList.add(valueMap);
                if (addCount.doubleValue() == changeCount.doubleValue()) {
                    return outMapList;
                }
            } else if (addCount.doubleValue() > changeCount.doubleValue()) {
                //出库数量 := 库存数量 + (需要出库数量 - 累加器(库存数量))
                BigDecimal outCount = BigDecimal.valueOf(stockCount.doubleValue() + (changeCount.doubleValue() - addCount.doubleValue()));
                valueMap.put("outCount", outCount);
                outMapList.add(valueMap);
                return outMapList;
            }
        }

        return outMapList;
    }

    public Map<String, WarehouseProduct> warehouseProductList2Map(List<WarehouseProduct> objectList) {
        Map<String, WarehouseProduct> objectMap = new HashMap<String, WarehouseProduct>();
        if (objectList == null || objectList.size() == 0) {return objectMap;}

        for (WarehouseProduct object : objectList) {
            objectMap.put(object.getId(), object);
        }

        return objectMap;
    }

}
