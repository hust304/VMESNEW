package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：出库明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-10-23
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutDetailServiceImp implements WarehouseOutDetailService {


    @Autowired
    private WarehouseOutDetailMapper warehouseOutDetailMapper;

    @Autowired
    private WarehouseOutService warehouseOutService;

    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private WarehouseOutRecommendService warehouseOutRecommendService;

    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;

    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void save(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setId(Conv.createUuid());
        warehouseOutDetail.setCdate(new Date());
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.insert(warehouseOutDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void update(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.updateById(warehouseOutDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void updateAll(WarehouseOutDetail warehouseOutDetail) throws Exception{
        warehouseOutDetail.setUdate(new Date());
        warehouseOutDetailMapper.updateAllColumnById(warehouseOutDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutDetail", key = "''+#id")
    public WarehouseOutDetail selectById(String id) throws Exception{
        return warehouseOutDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> dataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<WarehouseOutDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutDetail> warehouseOutDetailList =  warehouseOutDetailMapper.selectByMap(columnMap);
        return warehouseOutDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseOutDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Override
    public List<WarehouseOutDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseOutDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseOutDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseOutDetail detail = (WarehouseOutDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseOutDetail());
            objectList.add(detail);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void addWarehouseOutDetail(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseOutDetail detail : objectList) {
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }

    @Override
    public void addWarehouseOutDetail(WarehouseOut parentObj, WarehouseOutDetail detail) throws Exception {
        if (parentObj == null) {return;}
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        detail.setParentId(parentObj.getId());
        detail.setCuser(parentObj.getCuser());
        this.save(detail);
    }

    @Override
    public List<WarehouseOutDetail> findWarehouseOutDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseOutDetailList(findMap);
    }






    public List<WarehouseOutDetail> findWarehouseOutDetailList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseOutDetail> objectList = new ArrayList<WarehouseOutDetail>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    /**
     * 出库单明细状态，在出库单明细List<WarehouseInDetail>中是否全部相同
     *   true : 全部相同，在出库单明细List
     *   false: 一条或多条不同，在出库单明细List
     *
     * @param state       明细状态-出库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     * @param ignoreState 忽视状态(允许为空)
     * @param objectList  出库单明细List<WarehouseInDetail>
     * @return
     */
    @Override
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseOutDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseOutDetail object : objectList) {
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

    @Override
    public void updateStateByDetail(PageData pd) throws Exception{
        warehouseOutDetailMapper.updateStateByDetail(pd);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        this.updateStateByDetail(pageData);
    }

    @Override
    public WarehouseOutDetail findWarehouseOutDetailById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseOutDetail(findMap);
    }

    public WarehouseOutDetail findWarehouseOutDetail(PageData object) {
        if (object == null) {return null;}

        List<WarehouseOutDetail> objectList = this.findWarehouseOutDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }


    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public ResultModel rebackWarehouseOutDetail(PageData pageData) throws Exception {

        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        String rebackBillReason = pageData.getString("rebackBillReason");

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("executor_id",currentUserId);
        columnMap.put("isdisable","1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //取消出库执行人并记录退单原因
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
        if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
            for(int i=0;i<warehouseOutExecutorList.size();i++){
                WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                if(StringUtils.isEmpty(warehouseOutExecutor.getRemark())){
                    warehouseOutExecutor.setRemark("退单原因:"+rebackBillReason+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseOutExecutor.setRemark(warehouseOutExecutor.getRemark()+"  退单原因:"+rebackBillReason+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseOutExecutor.setIsdisable("0");
                warehouseOutExecutorService.update(warehouseOutExecutor);
            }
        }
        //取消出库记录并记录退单原因
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.selectByColumnMap(columnMap);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            for(int i=0;i<warehouseOutExecuteList.size();i++){
                WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteList.get(i);
                warehouseOutExecute.setIsdisable("0");
                if(StringUtils.isEmpty(warehouseOutExecute.getRemark())){
                    warehouseOutExecute.setRemark("退单原因:"+rebackBillReason+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseOutExecute.setRemark(warehouseOutExecute.getRemark()+"  退单原因:"+rebackBillReason+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseOutExecuteService.update(warehouseOutExecute);
                //取消出库执行
                try {
                    //出库操作
                    WarehouseProduct outObject = warehouseProductService.selectById(warehouseOutExecute.getWarehouseProductId());


                    //库存变更日志
                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setCompanyId(currentCompanyId);
                    loginfo.setCuser(currentUserId);
                    //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                    loginfo.setOperation("reback");

                    //beforeCount 操作变更前数量(业务相关)
                    loginfo.setBeforeCount(warehouseOutExecute.getCount());
                    //afterCount 操作变更后数量(业务相关)
                    loginfo.setAfterCount(BigDecimal.ZERO);

                    loginfo.setExecuteId(warehouseOutExecute.getId());
                    loginfo.setDetailId(warehouseOutExecute.getDetailId());

                    String msgStr = warehouseProductService.outStockCount(outObject, warehouseOutExecute.getCount().negate(), loginfo);
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

        //删除推荐库位信息
        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        warehouseOutRecommendService.deleteByColumnMap(columnMap);

        //更新出库单及出库明细状态
        WarehouseOutDetail detail = this.selectById(detailId);

        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        List<WarehouseOutExecutor> checkList = warehouseOutExecutorService.selectByColumnMap(columnMap);

        if(checkList!=null&&checkList.size()>0){
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
        }else {
            detail.setState("0");
        }
        detail.setRemark("退单原因:"+rebackBillReason+" 操作时间："+ dateFormat.format(new Date()));
        this.update(detail);
        warehouseOutService.updateState(detail.getParentId());


        return model;
    }
}



