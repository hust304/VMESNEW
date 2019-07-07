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
     * @param productId     货品id 不可为空
     * @param companyId     企业id 允许为空
     * @param productCount  货品数量(需要出库数量) 不可为空
     * @return
     */
    public List<Map<String, Object>> findWarehouseProductOutMapList (String productId, String companyId, BigDecimal productCount) throws ApplicationException {
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

}
