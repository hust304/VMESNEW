package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseLoginfoMapper;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.xy.vmes.service.WarehouseLoginfoService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_loginfo:库存变更日志表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-06
*/
@Service
@Transactional(readOnly = false)
public class WarehouseLoginfoServiceImp implements WarehouseLoginfoService {


    @Autowired
    private WarehouseLoginfoMapper warehouseLoginfoMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    @Override
    public void save(WarehouseLoginfo warehouseLoginfo) throws Exception{
        warehouseLoginfo.setId(Conv.createUuid());
        warehouseLoginfo.setCdate(new Date());
        warehouseLoginfoMapper.insert(warehouseLoginfo);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    @Override
    public List<WarehouseLoginfo> dataList(PageData pd) throws Exception{
        return warehouseLoginfoMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseLoginfoMapper.getDataListPage(pd,pg);
    }

}



