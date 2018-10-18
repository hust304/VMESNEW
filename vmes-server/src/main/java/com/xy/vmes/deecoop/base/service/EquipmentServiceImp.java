package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.EquipmentMapper;
import com.xy.vmes.entity.Equipment;
import com.xy.vmes.service.EquipmentService;
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
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-09-20
*/
@Service
@Transactional(readOnly = false)
public class EquipmentServiceImp implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void save(Equipment equipment) throws Exception{
        equipment.setId(Conv.createUuid());
        equipment.setCdate(new Date());
        equipment.setUdate(new Date());
        equipmentMapper.insert(equipment);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void update(Equipment equipment) throws Exception{
        equipment.setUdate(new Date());
        equipmentMapper.updateById(equipment);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateAll(Equipment equipment) throws Exception{
        equipment.setUdate(new Date());
        equipmentMapper.updateAllColumnById(equipment);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    //@Cacheable(cacheNames = "equipment", key = "''+#id")
    public Equipment selectById(String id) throws Exception{
        return equipmentMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> dataListPage(PageData pd,Pagination pg) throws Exception{
        return equipmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> dataList(PageData pd) throws Exception{
        return equipmentMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return equipmentMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return equipmentMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> selectByColumnMap(Map columnMap) throws Exception{
    List<Equipment> equipmentList =  equipmentMapper.selectByMap(columnMap);
        return equipmentList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return equipmentMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return equipmentMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



