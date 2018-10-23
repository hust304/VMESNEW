package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutMapper;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.service.WarehouseOutService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-10-22
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutServiceImp implements WarehouseOutService {


    @Autowired
    private WarehouseOutMapper warehouseOutMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void save(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setId(Conv.createUuid());
        warehouseOut.setCdate(new Date());
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.insert(warehouseOut);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void update(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.updateById(warehouseOut);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void updateAll(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.updateAllColumnById(warehouseOut);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOut", key = "''+#id")
    public WarehouseOut selectById(String id) throws Exception{
        return warehouseOutMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> dataList(PageData pd) throws Exception{
        return warehouseOutMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOut> warehouseOutList =  warehouseOutMapper.selectByMap(columnMap);
        return warehouseOutList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    public String checkColumn(WarehouseOut object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //type 出库类型
        if (object.getType() == null || object.getType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "出库类型");
            msgBuf.append(str_isnull);
        }

        //warehouseId 所属仓库
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "所属仓库");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }
}



