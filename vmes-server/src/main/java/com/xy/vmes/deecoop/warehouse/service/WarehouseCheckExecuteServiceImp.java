package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckExecuteMapper;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.xy.vmes.service.WarehouseCheckExecuteService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckExecuteServiceImp implements WarehouseCheckExecuteService {


    @Autowired
    private WarehouseCheckExecuteMapper warehouseCheckExecuteMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheckExecute object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckExecute selectById(String id) throws Exception{
        return warehouseCheckExecuteMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckExecute> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckExecute> warehouseCheckDetailList =  warehouseCheckExecuteMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckExecuteMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckExecuteMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckExecuteMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<WarehouseCheckExecute> dataList(PageData pd) throws Exception {
        return warehouseCheckExecuteMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.getDataListPage(pd, pg);
    }
    public List<Map> findListWarehouseCheckExecuteByAudit(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.findListWarehouseCheckExecuteByAudit(pd, pg);
    }

    public WarehouseCheckExecute findWarehouseCheckExecute(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckExecute> objectList = this.findWarehouseCheckExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseCheckExecute findWarehouseCheckExecuteById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecute(findMap);
    }

    public List<WarehouseCheckExecute> findWarehouseCheckExecuteList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }
    public List<WarehouseCheckExecute> findWarehouseCheckExecuteListByDetailId(String detailId) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecuteList(findMap);
    }
}



