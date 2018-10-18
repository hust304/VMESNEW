package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductMapper;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.WarehouseProductService;
import com.xy.vmes.service.WarehouseService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_product:仓库货位产品库存表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseProductServiceImp implements WarehouseProductService {

    @Autowired
    private WarehouseProductMapper warehouseProductMapper;
    @Autowired
    private WarehouseService warehouseService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setId(Conv.createUuid());
        warehouseProduct.setCdate(new Date());
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.insert(warehouseProduct);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.updateById(warehouseProduct);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.updateAllColumnById(warehouseProduct);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseProductMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseProductMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseProduct> dataList(PageData pd) throws Exception{
        return warehouseProductMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseProductMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseProduct> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseProduct> warehouseProductList =  warehouseProductMapper.selectByMap(columnMap);
        return warehouseProductList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseProductMapper.getDataListPage(pd, pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseProductMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-26
     */
    public void updateStockCount(PageData pd) throws Exception {
        warehouseProductMapper.updateStockCount(pd);
    }

    public WarehouseProduct findWarehouseProduct(PageData object) {
        if (object == null) {return null;}

        List<WarehouseProduct> objectList = this.findWarehouseProductList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseProduct findWarehouseProductById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseProduct(findMap);
    }

    public List<WarehouseProduct> findWarehouseProductList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseProduct> objectList = new ArrayList<WarehouseProduct>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取推荐货位(默认货位)
     * 1. 查询库存表(vmes_warehouse_product:仓库货位产品库存表)
     *   A. 相同货品的库位，按数量由少到多
     *   B. 历史放过此货品的空库位
     * 2. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
     *
     * @param companyId  企业id
     * @param productId  货品id
     * @return
     */
    public String findDefaultWarehousePosition(String companyId, String productId) {
        //1. 查询库存表(vmes_warehouse_product:仓库货位产品库存表)
        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        if (productId != null && productId.trim().length() > 0) {
            findMap.put("productId", productId);
        }
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            findMap.put("orderStr", "stock_count,cdate asc");
        }

        List<WarehouseProduct> objectList = findWarehouseProductList(findMap);
        if (objectList != null && objectList.size() > 0
            && objectList.get(0).getWarehouseId() != null
            && objectList.get(0).getWarehouseId().trim().length() > 0
        ) {
            return objectList.get(0).getWarehouseId().trim();
        }

        //2. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
        findMap = new PageData();
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        //实体库 warehouseEntity 2d75e49bcb9911e884ad00163e105f05
        findMap.put("nodeId", Common.DICTIONARY_MAP.get("warehouseEntity"));
        findMap.put("queryStr", "layer >= 3");
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("orderStr", "cdate asc");

        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);
        if (warehouseList != null && warehouseList.size() > 0 && warehouseList.get(0).getId() != null) {
            return objectList.get(0).getWarehouseId().trim();
        }

        return null;
    }
}



