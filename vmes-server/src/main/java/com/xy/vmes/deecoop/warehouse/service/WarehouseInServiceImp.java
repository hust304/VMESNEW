package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInMapper;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseMove;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_warehouse_in:仓库入库单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInServiceImp implements WarehouseInService {

    @Autowired
    private WarehouseInMapper warehouseInMapper;

    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setCdate(new Date());
        warehouseIn.setUdate(new Date());
        warehouseInMapper.insert(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setUdate(new Date());
        warehouseInMapper.updateById(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setUdate(new Date());
        warehouseInMapper.updateAllColumnById(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseIn> dataList(PageData pd) throws Exception{
        return warehouseInMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseIn> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseIn> warehouseInList =  warehouseInMapper.selectByMap(columnMap);
        return warehouseInList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByWarehouseIn(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

        warehouseInMapper.deleteTableByExecute(pageData);
        warehouseInMapper.deleteTableByExecutor(pageData);
        warehouseInMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    public WarehouseIn findWarehouseIn(PageData object) {
        if (object == null) {return null;}

        List<WarehouseIn> objectList = this.findWarehouseInList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseIn findWarehouseInById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseIn(findMap);
    }

    public List<WarehouseIn> findWarehouseInList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseIn> objectList = new ArrayList<WarehouseIn>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public String checkColumn(WarehouseIn object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //type 入库类型
        if (object.getType() == null || object.getType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "入库类型");
            msgBuf.append(str_isnull);
        }

        //warehouseId 所属仓库
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "所属仓库");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    @Override
    public void updateState(String id) throws Exception {
        WarehouseIn warehouseIn = this.findWarehouseInById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(warehouseIn!=null){
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseInDetail warehouseInDetail = detailList.get(i);
                    if("-1".equals(warehouseInDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseInDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseInDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseInDetail.getState())){
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
                warehouseIn.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0){
                warehouseIn.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseIn.setState("0");//未完成
            }
            this.update(warehouseIn);
        }

    }
}



