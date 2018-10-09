package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehousePositionMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehousePosition;
import com.xy.vmes.service.WarehousePositionService;
import com.yvan.Numbers;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_position:仓库货位表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-09
*/
@Service
@Transactional(readOnly = false)
public class WarehousePositionServiceImp implements WarehousePositionService {


    @Autowired
    private WarehousePositionMapper warehousePositionMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void save(WarehousePosition warehousePosition) throws Exception{
        warehousePosition.setId(Conv.createUuid());
        warehousePosition.setCdate(new Date());
        warehousePosition.setUdate(new Date());
        warehousePositionMapper.insert(warehousePosition);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void update(WarehousePosition warehousePosition) throws Exception{
        warehousePosition.setUdate(new Date());
        warehousePositionMapper.updateById(warehousePosition);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void updateAll(WarehousePosition warehousePosition) throws Exception{
        warehousePosition.setUdate(new Date());
        warehousePositionMapper.updateAllColumnById(warehousePosition);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehousePositionMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehousePositionMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public List<WarehousePosition> dataList(PageData pd) throws Exception{
        return warehousePositionMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehousePositionMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehousePositionMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehousePositionMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public WarehousePosition findWarehousePosition(PageData object) {
        if (object == null) {return null;}

        List<WarehousePosition> objectList = this.findWarehousePositionList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehousePosition findWarehousePositionById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehousePosition(findMap);
    }

    public List<WarehousePosition> findWarehousePositionList(PageData object) {
        if (object == null) {return null;}

        List<WarehousePosition> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public List<WarehousePosition> findWarehousePositionListByPid(String pid) {
        List<WarehousePosition> objectList = new ArrayList<WarehousePosition>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        objectList = this.findWarehousePositionList(findMap);
        return objectList;
    }

    public boolean isExistByName(String pid, String id, String name) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);

        name = "'" + StringUtil.stringTrimSpace(name).replace(",", "','") + "'";
        findMap.put("queryStr", "name in (" + name + ")");

        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehousePosition> objectList = this.findWarehousePositionList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public List<String> findNameListByNumber(int start, int end) {
        List<String> objList = new ArrayList<String>();
        if (start == -1) {return objList;}
        if (end == -1) {return objList;}
        if (end < start) {return objList;}

        for (int i = start; i <= end; i++) {
            objList.add(Integer.valueOf(i).toString());
        }

        return objList;
    }

    public List<String> findNameListByChar(String start, String end) {
        List<String> objList = new ArrayList<String>();

        long start_long = StringUtil.char2Number(start);
        if (start_long == -1) {return objList;}

        long end_long = StringUtil.char2Number(end);
        if (end_long == -1) {return objList;}

        for (long i = start_long; i <= end_long; i++) {
            objList.add(Numbers.toString(i, Numbers.MAX_RADIX));
        }

        return objList;
    }

    public List<String> findNameList(String start, String end, String suffix) {
        List<String> objList = new ArrayList<String>();
        if (start == null || start.trim().length() == 0) {return objList;}
        if (end == null || end.trim().length() == 0) {return objList;}

        //获取(开始,结束)范围
        int start_int = -1;
        try {
            start_int = Integer.parseInt(start);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int end_int = -1;
        try {
            end_int = Integer.parseInt(end);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //获取(开始,结束)范围List
        if (start_int != -1 && end_int != -1) {
            objList = this.findNameListByNumber(start_int, end_int);
        } else if (start_int == -1 && end_int == -1) {
            objList = this.findNameListByChar(start, end);
        }

        List<String> newList = new ArrayList<String>();
        if (suffix == null || suffix.trim().length() == 0) {return objList;}
        if (objList.size() > 0) {
            for (String str : objList) {
                newList.add(str + suffix);
            }
        }

        return newList;
    }
}



