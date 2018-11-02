package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutExecuteMapper;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库执行 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-01
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutExecuteServiceImp implements WarehouseOutExecuteService {


    @Autowired
    private WarehouseOutExecuteMapper warehouseOutExecuteMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void save(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setId(Conv.createUuid());
        warehouseOutExecute.setCdate(new Date());
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.insert(warehouseOutExecute);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void update(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.updateById(warehouseOutExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateAll(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.updateAllColumnById(warehouseOutExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutExecute", key = "''+#id")
    public WarehouseOutExecute selectById(String id) throws Exception{
        return warehouseOutExecuteMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutExecuteMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> dataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutExecuteMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutExecute> warehouseOutExecuteList =  warehouseOutExecuteMapper.selectByMap(columnMap);
        return warehouseOutExecuteList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutExecuteMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



