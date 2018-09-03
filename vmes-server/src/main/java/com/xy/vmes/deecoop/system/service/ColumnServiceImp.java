package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.deecoop.system.dao.ColumnMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_column:模块栏位表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-08-24
*/
@Service
@Transactional(readOnly = false)
public class ColumnServiceImp implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-24
    */
    @Override
    public void save(Column column) throws Exception{
        column.setId(Conv.createUuid());
        column.setCdate(new Date());
        columnMapper.insert(column);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-24
    */
    @Override
    public void update(Column column) throws Exception{
        columnMapper.updateAllColumnById(column);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-24
    */
    @Override
    public List<Column> dataList(PageData pd) throws Exception{
        return columnMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-24
     */
    @Override
    public List<Column> findColumnList(String modelCode) throws Exception {
        if (modelCode == null || modelCode.trim().length() == 0) {return new ArrayList<Column>();}

        PageData findMap = new PageData();
        findMap.put("modelCode", modelCode);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        return this.dataList(findMap);
    }

}



