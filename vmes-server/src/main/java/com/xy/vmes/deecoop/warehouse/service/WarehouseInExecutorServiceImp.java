package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInExecutorMapper;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseInExecutor;
import com.xy.vmes.service.WarehouseInExecutorService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_executor:入库明细执行人 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-31
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInExecutorServiceImp implements WarehouseInExecutorService {


    @Autowired
    private WarehouseInExecutorMapper warehouseInExecutorMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void save(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setId(Conv.createUuid());
        warehouseInExecute.setCdate(new Date());
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.insert(warehouseInExecute);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void update(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.updateById(warehouseInExecute);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void updateAll(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.updateAllColumnById(warehouseInExecute);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInExecutorMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInExecutorMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<WarehouseInExecutor> dataList(PageData pd) throws Exception{
        return warehouseInExecutorMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInExecutorMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<WarehouseInExecutor> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseInExecutor> warehouseInExecuteList =  warehouseInExecutorMapper.selectByMap(columnMap);
        return warehouseInExecuteList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInExecutorMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public WarehouseInExecutor findWarehouseInExecutor(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecutor> objectList = this.findWarehouseInExecutorList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInExecutor findWarehouseInExecutorById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecutor(findMap);
    }

    public List<WarehouseInExecutor> findWarehouseInExecutorList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecutor> objectList = new ArrayList<WarehouseInExecutor>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }
    public List<WarehouseInExecutor> findWarehouseInExecutorListByDetailId(String detailId) {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecutorList(findMap);
    }

    public void addWarehouseInExecutor(WarehouseInDetail detail, String userIds) {
        if (detail == null) {return;}
        if (detail.getId() == null || detail.getId().trim().length() == 0) {return;}
        if (userIds == null || userIds.trim().length() == 0) {return;}

        userIds = StringUtil.stringTrimSpace(userIds);
        String[] strArry = userIds.split(",");

        for (String userId : strArry) {
            WarehouseInExecutor object = new WarehouseInExecutor();
            object.setCuser(detail.getCuser());
            object.setDetailId(detail.getId());
            object.setExecutorId(userId);
            try {
                this.save(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



