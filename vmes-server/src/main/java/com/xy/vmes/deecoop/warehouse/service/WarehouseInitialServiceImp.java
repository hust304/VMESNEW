package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInitialMapper;
import com.xy.vmes.entity.WarehouseInitial;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_initial:仓库初始化设定 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-20
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInitialServiceImp implements WarehouseInitialService {
    @Autowired
    private WarehouseInitialMapper warehouseInitialMapper;

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-20
    */
    @Override
    public void save(WarehouseInitial warehouseInitial) throws Exception{
        warehouseInitial.setId(Conv.createUuid());
        warehouseInitial.setCdate(new Date());
        warehouseInitial.setUdate(new Date());
        warehouseInitialMapper.insert(warehouseInitial);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public WarehouseInitial selectById(String id) throws Exception{
        return warehouseInitialMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public List<WarehouseInitial> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseInitial> warehouseCheckList =  warehouseInitialMapper.selectByMap(columnMap);
        return warehouseCheckList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void update(WarehouseInitial object) throws Exception{
        object.setUdate(new Date());
        warehouseInitialMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void updateAll(WarehouseInitial object) throws Exception{
        object.setUdate(new Date());
        warehouseInitialMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInitialMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInitialMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInitialMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInitialMapper.deleteByMap(columnMap);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateIsdisable(String isdisable, String companyId) {
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("isdisable", isdisable);
        warehouseInitialMapper.updateIsdisable(findMap);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    @Override
    public List<WarehouseInitial> dataList(PageData pd) throws Exception{
        return warehouseInitialMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseInitialMapper.getDataListPage(pd, pg);
    }

    public void initialByWarehouse(String cuser, String companyId) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return;}

        this.deleteTableByBusiness(companyId);

        //是否启用(0:已禁用 1:启用)
        this.updateIsdisable("0", companyId);

        WarehouseInitial addObject = new WarehouseInitial();
        addObject.setCuser(cuser);
        addObject.setCompanyId(companyId);
        this.save(addObject);
    }

    public void deleteTableByBusiness(String companyId) throws Exception {
        //删除入库业务表
        warehouseInService.deleteTableByWarehouseIn(companyId);
        //删除出库业务表
        warehouseOutService.deleteTableByWarehouseOut(companyId);
        //删除仓库盘点业务表
        warehouseCheckService.deleteTableByWarehouseCheck(companyId);
        //删除移库业务表
        warehouseMoveService.deleteTableByWarehouseMove(companyId);

        //删除仓库货品表(库存表)
        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        warehouseProductService.deleteByColumnMap(columnMap);

        //货品表(库存数量)初始化
        productService.initialProductByStockCount(companyId);
    }
}



