package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductMapper;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.WarehouseProductService;
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
}



