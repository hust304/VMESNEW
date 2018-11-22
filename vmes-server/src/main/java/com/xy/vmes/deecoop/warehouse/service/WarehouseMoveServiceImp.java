package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveMapper;
import com.xy.vmes.entity.WarehouseMove;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.service.WarehouseMoveDetailService;
import com.xy.vmes.service.WarehouseMoveService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：移库单 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveServiceImp implements WarehouseMoveService {


    @Autowired
    private WarehouseMoveMapper warehouseMoveMapper;

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setId(Conv.createUuid());
        warehouseMove.setCdate(new Date());
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.insert(warehouseMove);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.updateById(warehouseMove);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.updateAllColumnById(warehouseMove);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMove", key = "''+#id")
    public WarehouseMove selectById(String id) throws Exception{
        return warehouseMoveMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> dataList(PageData pd) throws Exception{
        return warehouseMoveMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMove> warehouseMoveList =  warehouseMoveMapper.selectByMap(columnMap);
        return warehouseMoveList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByWarehouseMove(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

        warehouseMoveMapper.deleteTableByExecute(pageData);
        warehouseMoveMapper.deleteTableByExecutor(pageData);
        warehouseMoveMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    public List<WarehouseMove> findWarehouseMoveList(PageData object) {
        if (object == null) {return null;}
        List<WarehouseMove> objectList = new ArrayList<WarehouseMove>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

    public WarehouseMove findWarehouseMove(PageData object) {
        if (object == null) {return null;}
        List<WarehouseMove> objectList = this.findWarehouseMoveList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }
        return null;
    }

    public WarehouseMove findWarehouseMoveById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}
        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        return this.findWarehouseMove(findMap);
    }

    @Override
    public void updateState(String id) throws Exception {
        WarehouseMove warehouseMove = this.findWarehouseMoveById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(warehouseMove!=null){
            List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.findWarehouseMoveDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseMoveDetail warehouseMoveDetail = detailList.get(i);
                    if("-1".equals(warehouseMoveDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseMoveDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseMoveDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseMoveDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前出库单没有明细则自动删除当前出库单
                this.deleteById(id);
                return;
            }
            //该出库单明细状态全是已取消状态，则说明当前出库单状态为已取消
            if(yqx>0&&dpd==0&&zxz==0&&ywc==0){
                warehouseMove.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0){
                warehouseMove.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseMove.setState("0");//未完成
            }
            this.update(warehouseMove);
        }

    }
}



