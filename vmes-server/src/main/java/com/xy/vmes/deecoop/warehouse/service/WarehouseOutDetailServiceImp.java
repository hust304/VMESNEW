package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutDetailMapper;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：出库明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-10-23
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutDetailServiceImp implements WarehouseOutDetailService {


    @Autowired
    private WarehouseOutDetailMapper warehouseOutDetailMapper;

    @Autowired
    private CoderuleService coderuleService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void save(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setId(Conv.createUuid());
        warehouseOutDetail.setCdate(new Date());
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.insert(warehouseOutDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void update(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.updateById(warehouseOutDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void updateAll(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.updateAllColumnById(warehouseOutDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutDetail", key = "''+#id")
    public WarehouseOutDetail selectById(String id) throws Exception{
        return warehouseOutDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> dataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutDetail> warehouseOutDetailList =  warehouseOutDetailMapper.selectByMap(columnMap);
        return warehouseOutDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    public List<WarehouseOutDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseOutDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseOutDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseOutDetail detail = (WarehouseOutDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseOutDetail());
            objectList.add(detail);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addWarehouseOutDetail(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseOutDetail detail : objectList) {
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }
}



