package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckMapper;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.service.WarehouseCheckService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check:仓库库存盘点 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-13
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckServiceImp implements WarehouseCheckService {

    @Autowired
    private WarehouseCheckMapper warehouseCheckMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setId(Conv.createUuid());
        warehouseCheck.setCdate(new Date());
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.insert(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheck selectById(String id) throws Exception{
        return warehouseCheckMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheck> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheck> warehouseCheckList =  warehouseCheckMapper.selectByMap(columnMap);
        return warehouseCheckList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.updateById(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.updateAllColumnById(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckMapper.deleteByMap(columnMap);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteWarehouseInTable() {
        warehouseCheckMapper.deleteTableByParent();
        warehouseCheckMapper.deleteTableByDetail();
        warehouseCheckMapper.deleteTableByExecutor();
        warehouseCheckMapper.deleteTableByExecute();
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheck> dataList(PageData pd) throws Exception{
        return warehouseCheckMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseCheckMapper.getDataListPage(pd, pg);
    }

    public WarehouseCheck findWarehouseCheck(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheck> objectList = this.findWarehouseCheckList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseCheck findWarehouseCheckById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheck(findMap);
    }

    public List<WarehouseCheck> findWarehouseCheckList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }

}



