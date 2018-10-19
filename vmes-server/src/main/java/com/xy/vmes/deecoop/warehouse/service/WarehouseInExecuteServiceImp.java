package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInExecuteMapper;
import com.xy.vmes.entity.WarehouseInExecute;
import com.xy.vmes.service.WarehouseInExecuteService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_execute:仓库入库执行明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInExecuteServiceImp implements WarehouseInExecuteService {


    @Autowired
    private WarehouseInExecuteMapper warehouseInExecuteMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setId(Conv.createUuid());
        warehouseInExecute.setCdate(new Date());
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.insert(warehouseInExecute);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateAllColumnById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> dataList(PageData pd) throws Exception{
        return warehouseInExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseInExecute> warehouseInExecuteList =  warehouseInExecuteMapper.selectByMap(columnMap);
        return warehouseInExecuteList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<Map<String, Object>> findSumcountByWarehouseInExecute(PageData object) {
        if (object == null) {return null;}
        return warehouseInExecuteMapper.findSumcountByWarehouseInExecute(object);
    }

    public Map<String, BigDecimal> findExecuteCountByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        Map<String, BigDecimal> mapObject = new HashMap<String, BigDecimal>();
        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        List<Map<String, Object>> mapList = this.findSumcountByWarehouseInExecute(findMap);
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> mapObj : mapList) {
                String detailId = (String)mapObj.get("detailId");
                BigDecimal count = (BigDecimal)mapObj.get("executeCount");
                if (detailId != null && count != null) {
                    mapObject.put(detailId, count);
                }
            }
        }

        return mapObject;
    }

    public WarehouseInExecute findWarehouseInExecute(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = this.findWarehouseInExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInExecute findWarehouseInExecuteById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecute(findMap);}

    public List<WarehouseInExecute> findWarehouseInExecuteList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = new ArrayList<WarehouseInExecute>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<WarehouseInExecute> findWarehouseInExecuteListByDetailId(String detailId) {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecuteList(findMap);
    }

    public List<WarehouseInExecute> mapList2ExecuteList(List<Map<String, String>> mapList, List<WarehouseInExecute> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInExecute>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInExecute execute = (WarehouseInExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseInExecute());
            objectList.add(execute);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////
//    public BigDecimal findSumCountByExecuteList(List<WarehouseInExecute> objectList) {
//        double sumCount = 0D;
//        if (objectList != null && objectList.size() > 0) {
//            for (WarehouseInExecute object : objectList) {
//                if (object.getCount() != null) {
//                    sumCount = sumCount + object.getCount().doubleValue();
//                }
//            }
//        }
//
//        //四舍五入 2位小数
//        return BigDecimal.valueOf(sumCount).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//    }

    public String checkColumnExecuteList(List<WarehouseInExecute> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}
        String column_isnull = "第 {0} 行: {1}为空或{2}为空，({1},{2})为必填不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            WarehouseInExecute object = objectList.get(i);
            if ((object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0)
                || object.getCount() == null
            ) {
                String str_isnull = MessageFormat.format(column_isnull,
                        Integer.valueOf(i+1).toString(),
                        "实际货位ID",
                        "入库数量");
                msgBuf.append(str_isnull);
            }
        }

        return msgBuf.toString();
    }
}



