package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：移库单明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveDetailServiceImp implements WarehouseMoveDetailService {


    @Autowired
    private WarehouseMoveDetailMapper warehouseMoveDetailMapper;

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    @Autowired
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMoveDetail warehouseMoveDetail) throws Exception{
        warehouseMoveDetail.setId(Conv.createUuid());
        warehouseMoveDetail.setCdate(new Date());
        warehouseMoveDetail.setUdate(new Date());
        warehouseMoveDetailMapper.insert(warehouseMoveDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMoveDetail warehouseMoveDetail) throws Exception{
        warehouseMoveDetail.setUdate(new Date());
        warehouseMoveDetailMapper.updateById(warehouseMoveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMoveDetail warehouseMoveDetail) throws Exception{
        warehouseMoveDetail.setUdate(new Date());
        warehouseMoveDetailMapper.updateAllColumnById(warehouseMoveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMoveDetail", key = "''+#id")
    public WarehouseMoveDetail selectById(String id) throws Exception{
        return warehouseMoveDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveDetail> dataList(PageData pd) throws Exception{
        return warehouseMoveDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMoveDetail> warehouseMoveDetailList =  warehouseMoveDetailMapper.selectByMap(columnMap);
        return warehouseMoveDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Override
    public List<WarehouseMoveDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseMoveDetail> objectList){
        if (objectList == null) {objectList = new ArrayList<WarehouseMoveDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}
        for (Map<String, String> mapObject : mapList) {
            WarehouseMoveDetail detail = (WarehouseMoveDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseMoveDetail());
            String id = Conv.createUuid();
            detail.setId(id);
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            objectList.add(detail);
        }
        return objectList;
    }

    @Override
    public void addWarehouseMoveDetail(WarehouseMove parentObj, List<WarehouseMoveDetail> objectList) throws Exception{
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseMoveDetail detail : objectList) {
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }

    @Override
    public void addWarehouseMoveDetail(WarehouseMove parentObj, WarehouseMoveDetail detail) throws Exception{
        if (parentObj == null) {return;}
        detail.setParentId(parentObj.getId());
        detail.setCuser(parentObj.getCuser());
        this.save(detail);
    }

    @Override
    public List<WarehouseMoveDetail> findWarehouseMoveDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}
        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        return this.findWarehouseMoveDetailList(findMap);
    }


    public List<WarehouseMoveDetail> findWarehouseMoveDetailList(PageData object) {
        if (object == null) {return null;}
        List<WarehouseMoveDetail> objectList = new ArrayList<WarehouseMoveDetail>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

    /**
     * 移库单明细状态，在移库单明细List<WarehouseMoveDetail>中是否全部相同
     *   true : 全部相同，在移库单明细List
     *   false: 一条或多条不同，在移库单明细List
     *
     * @param state       明细状态-移库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     * @param ignoreState 忽视状态(允许为空)
     * @param objectList  移库单明细List<WarehouseMoveDetail>
     * @return
     */
    @Override
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseMoveDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseMoveDetail object : objectList) {
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

    public WarehouseMoveDetail findWarehouseMoveDetailById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseMoveDetail(findMap);
    }

    @Override
    public ResultModel rebackWarehouseMoveDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String detailId = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        String rebackBill = pageData.getString("rebackBillReason");

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("executor_id",currentUserId);
        columnMap.put("isdisable","1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //取消出库执行人并记录退单原因
        List<WarehouseMoveExecutor> warehouseMoveExecutorList = warehouseMoveExecutorService.selectByColumnMap(columnMap);
        if(warehouseMoveExecutorList!=null&&warehouseMoveExecutorList.size()>0){
            for(int i=0;i<warehouseMoveExecutorList.size();i++){
                WarehouseMoveExecutor warehouseMoveExecutor = warehouseMoveExecutorList.get(i);
                if(StringUtils.isEmpty(warehouseMoveExecutor.getRemark())){
                    warehouseMoveExecutor.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseMoveExecutor.setRemark(warehouseMoveExecutor.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseMoveExecutor.setIsdisable("0");
                warehouseMoveExecutorService.update(warehouseMoveExecutor);
            }
        }
        //取消出库记录并记录退单原因
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            for(int i=0;i<warehouseMoveExecuteList.size();i++){
                WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                warehouseMoveExecute.setIsdisable("0");
                if(StringUtils.isEmpty(warehouseMoveExecute.getRemark())){
                    warehouseMoveExecute.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseMoveExecute.setRemark(warehouseMoveExecute.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseMoveExecuteService.update(warehouseMoveExecute);
                //取消出库执行
                try {
                    //出库操作
                    WarehouseProduct outObject = warehouseProductService.selectById(warehouseMoveExecute.getWarehouseProductId());
                    WarehouseProduct inObject = warehouseProductService.selectById(warehouseMoveExecute.getNewWarehouseProductId());


                    //库存变更日志
                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setDetailId(warehouseMoveExecute.getDetailId());
                    loginfo.setExecuteId(warehouseMoveExecute.getId());
                    loginfo.setCompanyId(currentCompanyId);
                    loginfo.setCuser(currentUserId);
                    //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                    loginfo.setOperation("reback");

                    //beforeCount 操作变更前数量(业务相关)
                    loginfo.setBeforeCount(warehouseMoveExecute.getCount());
                    //afterCount 操作变更后数量(业务相关)
                    loginfo.setAfterCount(BigDecimal.ZERO);

                    String msgStr = warehouseProductService.moveStockCount(outObject,inObject,warehouseMoveExecute.getCount().negate(), loginfo);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        model.putCode(Integer.valueOf(1));
                        model.putMsg(msgStr);
                        return model;
                    }
                } catch (TableVersionException tabExc) {
                    //库存变更 version 锁
                    if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                        model.putCode(Integer.valueOf(1));
                        model.putMsg(tabExc.getMessage());
                        return model;
                    }
                }
            }
        }

//        //删除推荐库位信息
//        columnMap = new HashMap();
//        columnMap.put("detail_id",detailId);
//        warehouseMoveRecommendService.deleteByColumnMap(columnMap);

        //更新出库单及出库明细状态
        WarehouseMoveDetail detail = this.selectById(detailId);

        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        List<WarehouseMoveExecutor> checkList = warehouseMoveExecutorService.selectByColumnMap(columnMap);

        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        detail.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
        this.update(detail);
        warehouseMoveService.updateState(detail.getParentId());

        return model;
    }

    public WarehouseMoveDetail findWarehouseMoveDetail(PageData object) {
        if (object == null) {return null;}

        List<WarehouseMoveDetail> objectList = this.findWarehouseMoveDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }



}



