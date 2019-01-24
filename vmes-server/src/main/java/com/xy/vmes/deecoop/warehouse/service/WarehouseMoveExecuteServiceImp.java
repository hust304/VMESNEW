package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveExecuteMapper;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.entity.WarehouseMoveExecute;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：移库单执行 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveExecuteServiceImp implements WarehouseMoveExecuteService {


    @Autowired
    private WarehouseMoveExecuteMapper warehouseMoveExecuteMapper;

    @Autowired
    private WarehouseProductService warehouseProductService;


    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveService warehouseMoveService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setId(Conv.createUuid());
        warehouseMoveExecute.setCdate(new Date());
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.insert(warehouseMoveExecute);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.updateById(warehouseMoveExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.updateAllColumnById(warehouseMoveExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMoveExecute", key = "''+#id")
    public WarehouseMoveExecute selectById(String id) throws Exception{
        return warehouseMoveExecuteMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecuteMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> dataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveExecuteMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMoveExecute> warehouseMoveExecuteList =  warehouseMoveExecuteMapper.selectByMap(columnMap);
        return warehouseMoveExecuteList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveExecuteMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveExecuteMapper.updateToDisableByIds(ids);
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Override
    public ResultModel executeWarehouseMoveExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String jsonDataStr = pageData.getString("jsonDataStr");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);



        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> rootMap = mapList.get(j);
                if(rootMap!=null&&rootMap.get("children")!=null){
                    String newWarehouseId = (String)rootMap.get("warehouseId");
                    if(!StringUtils.isEmpty(newWarehouseId)){
                        //新增推荐库位记录
                        List childrenList = (List) rootMap.get("children");
                        if(childrenList!=null&&childrenList.size()>0){
                            for(int k=0;k<childrenList.size();k++){
                                Map<String, Object> childrenMap = (Map<String, Object>)childrenList.get(k);
                                String warehouseProductId = (String)childrenMap.get("warehouseProductId");
                                String suggestCount = (String)childrenMap.get("suggestCount");
                                String detailId = (String)childrenMap.get("id");
                                BigDecimal count = StringUtils.isEmpty(suggestCount)? BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(suggestCount));
                                model = this.addWarehouseMoveExecute(detailId,newWarehouseId,warehouseProductId,count,currentUserId,currentCompanyId);
                                if(model.get("code") != null && !"0".equals(model.get("code").toString().trim())){
                                    return model;
                                }
                            }
                        }

                    }
                }

            }
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseMoveExecute(String detailId, String newWarehouseId, String warehouseProductId, BigDecimal count, String currentUserId, String currentCompanyId) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseProduct outObject = warehouseProductService.selectById(warehouseProductId);

        PageData findMap = new PageData();
        findMap.put("code", outObject.getCode());
        findMap.put("productId", outObject.getProductId());
        findMap.put("warehouseId", newWarehouseId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        WarehouseProduct inObject = warehouseProductService.findWarehouseProduct(findMap);

        if(inObject==null){
            inObject = new WarehouseProduct();
            String id = Conv.createUuid();
            inObject.setId(id);
            inObject.setCompanyId(outObject.getCompanyId());
            inObject.setCode(outObject.getCode());
            inObject.setProductId(outObject.getProductId());
            inObject.setWarehouseId(newWarehouseId);
            inObject.setCdate(new Date());
            inObject.setQrcode(outObject.getQrcode());
            warehouseProductService.save(inObject);
        }


        WarehouseMoveExecute execute = new WarehouseMoveExecute();
        execute.setDetailId(detailId);
        execute.setExecutorId(currentUserId);
        execute.setWarehouseProductId(outObject.getId());
        execute.setNewWarehouseProductId(inObject.getId());
        execute.setCount(count);
        this.save(execute);


        //移库执行
        try {
            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId("");
            loginfo.setDetailId(execute.getDetailId());
            loginfo.setExecuteId(execute.getId());
            loginfo.setCompanyId(currentCompanyId);
            loginfo.setCuser(currentUserId);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("add");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(BigDecimal.ZERO);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(execute.getCount());


            String msgStr = warehouseProductService.moveStockCount(outObject,inObject, count, loginfo);
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

        //更新出库单及出库明细状态
        WarehouseMoveDetail detail = warehouseMoveDetailService.selectById(detailId);

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        BigDecimal totalCount = BigDecimal.ZERO;
        List<WarehouseMoveExecute> warehouseMoveExecuteList = this.selectByColumnMap(columnMap);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            for(int i=0;i<warehouseMoveExecuteList.size();i++){
                WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                    totalCount = totalCount.add(warehouseMoveExecute.getCount());
                }
            }
        }
        Map countResult = new HashMap();
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if(detail.getCount().compareTo(totalCount)>0){
            detail.setState("1");
            countResult.put("unCompleteCount",(detail.getCount().subtract(totalCount).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
        }else {
            detail.setState("2");
            countResult.put("unCompleteCount",0.00);
        }
        model.putResult(countResult);
        warehouseMoveDetailService.update(detail);
        warehouseMoveService.updateState(detail.getParentId());

        return model;
    }

}



