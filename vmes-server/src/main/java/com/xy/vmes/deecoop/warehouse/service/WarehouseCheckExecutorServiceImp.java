package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckExecutorMapper;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecutor;
import com.xy.vmes.service.WarehouseCheckExecutorService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckExecutorServiceImp implements WarehouseCheckExecutorService {


    @Autowired
    private WarehouseCheckExecutorMapper warehouseCheckExecutorMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheckExecutor object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckExecutor selectById(String id) throws Exception{
        return warehouseCheckExecutorMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckExecutor> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckExecutor> warehouseCheckDetailList =  warehouseCheckExecutorMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckExecutor object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckExecutor object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckExecutorMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckExecutorMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckExecutorMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<WarehouseCheckExecutor> dataList(PageData pd) throws Exception {
        return warehouseCheckExecutorMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecutorMapper.getDataListPage(pd, pg);
    }

    /**
     * 获取盘点明细执行人列表(添加盘点执行)
     * @param pd
     * @return
     * @throws Exception
     */
    public List<Map> findListWarehouseCheckExecutorByAddExecute(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecutorMapper.findListWarehouseCheckExecutorByAddExecute(pd, pg);
    }

    public WarehouseCheckExecutor findWarehouseCheckExecutor(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckExecutor> objectList = this.findWarehouseCheckExecutorList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseCheckExecutor findWarehouseCheckExecutorById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecutor(findMap);
    }

    public List<WarehouseCheckExecutor> findWarehouseCheckExecutorList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }
    public List<WarehouseCheckExecutor> findWarehouseCheckExecutorListByDetailId(String detailId) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecutorList(findMap);
    }

    public void addWarehouseCheckExecutor(WarehouseCheckDetail detail, String userIds) throws Exception {
        if (detail == null) {return;}
        if (detail.getId() == null || detail.getId().trim().length() == 0) {return;}
        if (userIds == null || userIds.trim().length() == 0) {return;}

        userIds = StringUtil.stringTrimSpace(userIds);
        String[] strArry = userIds.split(",");

        for (String userId : strArry) {
            WarehouseCheckExecutor object = new WarehouseCheckExecutor();
            object.setParentId(detail.getParentId());
            object.setDetailId(detail.getId());
            object.setCuser(detail.getCuser());
            object.setExecutorId(userId);
            try {
                this.save(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



