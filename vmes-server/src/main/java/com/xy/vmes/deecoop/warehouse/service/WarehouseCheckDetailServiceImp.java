package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckDetailMapper;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_detail:仓库库存盘点明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-13
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckDetailServiceImp implements WarehouseCheckDetailService {

    @Autowired
    private WarehouseCheckDetailMapper warehouseCheckDetailMapper;

    @Autowired
    private WarehouseCheckService warehouseCheckService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void save(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setId(Conv.createUuid());
        warehouseCheckDetail.setCdate(new Date());
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.insert(warehouseCheckDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckDetail selectById(String id) throws Exception{
        return warehouseCheckDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckDetail> warehouseCheckDetailList =  warehouseCheckDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.updateById(warehouseCheckDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.updateAllColumnById(warehouseCheckDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckDetailMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateStateByDetail(String parentId, String state) {
        if (parentId == null || parentId.trim().length() == 0) {return;}
        if (state == null || state.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("parentId", parentId);
        pageData.put("state", state);
        warehouseCheckDetailMapper.updateStateByDetail(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckDetail> dataList(PageData pd) throws Exception{
        return warehouseCheckDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseCheckDetailMapper.getDataListPage(pd, pg);
    }

    public WarehouseCheckDetail findWarehouseCheckDetail(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckDetail> objectList = this.findWarehouseCheckDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseCheckDetail findWarehouseCheckDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckDetail(findMap);
    }

    public List<WarehouseCheckDetail> findWarehouseCheckDetailList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }

    public List<WarehouseCheckDetail> findWarehouseCheckDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckDetailList(findMap);
    }

    public List<WarehouseCheckDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseCheckDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseCheckDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseCheckDetail detail = (WarehouseCheckDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckDetail());
            objectList.add(detail);
        }

        return objectList;
    }
    /////////////////////////////////////////////////////////////
    /**
     * 获取业务id字符串(逗号分隔的字符串)
     *
     * @param mapList 业务id
     * @return
     */
    public String findBusinessIdByMapList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, String> mapObject : mapList) {
            String businessId = mapObject.get("businessId");
            if (businessId != null && businessId.trim().length() > 0) {
                strBuf.append(businessId);
                strBuf.append(",");
            }
        }

        String idsTemp = strBuf.toString();
        //去掉最后一个','
        if (idsTemp.lastIndexOf(",") != -1) {
            idsTemp = idsTemp.substring(0, idsTemp.lastIndexOf(","));
        }

        return idsTemp;
    }

    public void addWarehouseCheckDetail(WarehouseCheck parentObj, List<WarehouseProduct> objectList) throws Exception {
        if (parentObj == null || (parentObj.getId() == null || parentObj.getId().trim().length() == 0)) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseProduct warehouseProduct : objectList) {
            WarehouseCheckDetail detail = new WarehouseCheckDetail();

            detail.setParentId(parentObj.getId());
            detail.setWarehouseProductId(warehouseProduct.getId());
            detail.setCode(warehouseProduct.getCode());
            detail.setProductId(warehouseProduct.getProductId());
            detail.setWarehouseId(warehouseProduct.getWarehouseId());

            detail.setStockCount(BigDecimal.valueOf(0D));
            if (warehouseProduct.getStockCount() != null) {
                detail.setStockCount(warehouseProduct.getStockCount());
            }

            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setCuser(parentObj.getCuser());

            this.save(detail);
        }

    }

    /**
     * 根据盘点明细状态-反写盘点单状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param parent       入库单对象
     * @param dtlList      入库单明细List<WarehouseCheckDetail>
     * @param ignoreState  忽视状态
     */
    public void updateParentStateByDetailList(WarehouseCheck parent, List<WarehouseCheckDetail> dtlList, String ignoreState) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findWarehouseCheckDetailListByParentId(parent.getId());
        }

        if (dtlList != null && dtlList.size() == 0) {
            warehouseCheckService.deleteById(parent.getId());
        } else {
            //获取入库单状态-根据入库单明细状态
            String parentState = this.findParentStateByDetailList(ignoreState, dtlList);
            parent.setState(parentState);
            warehouseCheckService.update(parent);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 一条或多条相同，在盘点单明细List
     *   false: 全部不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public boolean isExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseCheckDetail object : objectList) {
            String dtl_state = object.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if ("-1".equals(dtl_state)) {dtl_state = "c";}

            //忽视状态:判断与明细状态 相同则继续执行循环
            if (ignoreState != null && ignoreState.trim().length() > 0 && ignoreState.indexOf(dtl_state) != -1) {continue;}

            if (state.indexOf(dtl_state) != -1) {
                return true;
            }
        }

        return false;
    }

    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 全部相同，在盘点单明细List
     *   false: 一条或多条不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseCheckDetail object : objectList) {
            String dtl_state = object.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if ("-1".equals(dtl_state)) {dtl_state = "c";}

            //忽视状态:判断与明细状态 相同则继续执行循环
            if (ignoreState != null && ignoreState.trim().length() > 0 && ignoreState.indexOf(dtl_state) != -1) {continue;}

            if (state.indexOf(dtl_state) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取盘点单状态-根据盘点明细状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param ignoreState  忽视状态
     * @param dtlList      盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public String findParentStateByDetailList(String ignoreState, List<WarehouseCheckDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证入库单状态(1:已完成) --> 全部明细状态 (3:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "3";
        if (this.isAllExistStateByDetailList(checkDtlState, ignoreState, dtlList)) {
            return "1";
        }

        //2. 验证入库单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, null, dtlList)) {
            return "-1";
        }

        return parentState;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isAllAuditStateByDetailExecuteList(String state, List<Map<String, Object>> mapList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (mapList == null || mapList.size() == 0) {return false;}

        for (Map<String, Object> mapObject : mapList) {
            String executeState = (String)mapObject.get("executeState");
            if (executeState == null || executeState.trim().length() == 0) {return false;}

            if (!state.equals(executeState)) {
                return false;
            }
        }

        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //手机端
    public List<Map> findListPageWarehouseCheckDetail(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckDetailMapper.findListPageWarehouseCheckDetail(pd,pg);
    }

}



