package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutExecutorMapper;
import com.xy.vmes.entity.WarehouseOutExecutor;
import com.xy.vmes.service.WarehouseOutExecutorService;
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
* 说明：出库执行人 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-01
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutExecutorServiceImp implements WarehouseOutExecutorService {


    @Autowired
    private WarehouseOutExecutorMapper warehouseOutExecutorMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void save(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setId(Conv.createUuid());
        warehouseOutExecutor.setCdate(new Date());
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.insert(warehouseOutExecutor);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void update(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.updateById(warehouseOutExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateAll(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.updateAllColumnById(warehouseOutExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutExecutor", key = "''+#id")
    public WarehouseOutExecutor selectById(String id) throws Exception{
        return warehouseOutExecutorMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutExecutorMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutExecutorMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutExecutorMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> dataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutExecutorMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutExecutorMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutExecutor> warehouseOutExecutorList =  warehouseOutExecutorMapper.selectByMap(columnMap);
        return warehouseOutExecutorList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutExecutorMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutExecutorMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



