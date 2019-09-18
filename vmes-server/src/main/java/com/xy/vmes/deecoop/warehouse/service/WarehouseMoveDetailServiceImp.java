package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;
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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
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

    @Override
    public List<Map> getDataListPage(PageData pd) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}
        return warehouseMoveDetailMapper.getDataListPage(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        //return warehouseMoveDetailMapper.getDataListPage(pd,pg);
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseMoveDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return warehouseMoveDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }


    public List<Map> getDataListPageBySimple(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseMoveDetailMapper.getDataListPageBySimple(pd);
        } else if (pg != null) {
            return warehouseMoveDetailMapper.getDataListPageBySimple(pd,pg);
        }

        return mapList;
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

    public List<WarehouseMoveDetailEntity> mapList2DetailEntityList(List<Map<String, String>> mapList, List<WarehouseMoveDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseMoveDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}
        for (Map<String, String> mapObject : mapList) {
            WarehouseMoveDetailEntity detail = (WarehouseMoveDetailEntity) HttpUtils.pageData2Entity(mapObject, new WarehouseMoveDetailEntity());
            String id = Conv.createUuid();
            detail.setId(id);
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            objectList.add(detail);
        }
        return objectList;
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

    public WarehouseMoveDetail findWarehouseMoveDetailById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseMoveDetail(findMap);
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

    public List<Map<String, String>> findWarehouseMoveMapList(String companyId, String productId, String code) {
        List<Map<String, String>> moveList = new ArrayList<Map<String, String>>();

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("productId", productId);
        findMap.put("code", code);

        List<Map<String, Object>> mapList = null;
        try {
            mapList = warehouseMoveDetailMapper.findWarehouseMoveMapList(findMap);
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {return moveList;}

        for (Map<String, Object> mapObject : mapList) {
            Map<String, String> mapObj = new HashMap<String, String>();

            //移库单id parentId
            String parentId = new String();
            if (mapObject.get("parentId") != null) {
                parentId = mapObject.get("parentId").toString().trim();
            }
            mapObj.put("parentId", parentId);


            //移库单编号 parentCode
            String parentCode = new String();
            if (mapObject.get("parentCode") != null) {
                parentCode = mapObject.get("parentCode").toString().trim();
            }
            mapObj.put("parentCode", parentCode);

            //货品id productId
            mapObj.put("productId", productId);
            //批次号 code
            mapObj.put("code", code);
            mapObj.put("type", "move");

            moveList.add(mapObj);
        }

        return moveList;
    }

    public List<Map<String, Object>> findMoveDetailByProductMapList(String companyId, String productId, String code) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("productId", productId);
        findMap.put("code", code);

        try {
            mapList = warehouseMoveDetailMapper.findMoveDetailByProductMapList(findMap);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return mapList;
    }

    public Map<String, BigDecimal> findProductMapByMapList(List<Map<String, Object>> mapList) {
        Map<String, BigDecimal> productMap = new HashMap<String, BigDecimal>();
        if (mapList == null || mapList.size() == 0) {return productMap;}

        for (Map<String, Object> mapObject : mapList) {
            String productId = (String)mapObject.get("productId");
            String code = (String)mapObject.get("code");

            BigDecimal moveCount = BigDecimal.valueOf(0D);
            if (mapObject.get("moveCount") != null) {
                moveCount = (BigDecimal)mapObject.get("moveCount");
                //四舍五入到2位小数
                moveCount = moveCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                String mapKey = productId + "," + code;
                productMap.put(mapKey, moveCount);
            }
        }

        return productMap;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

    public void updateStateByDetail(PageData pd) throws Exception{
        warehouseMoveDetailMapper.updateStateByDetail(pd);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        //取消移库执行人并记录退单原因
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
        //取消移库记录并记录退单原因
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
                //取消移库执行
                try {
                    //移库操作
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
                    if(inObject.getStockCount().compareTo(warehouseMoveExecute.getCount())<0){
                        model.putCode(Integer.valueOf(1));
                        model.putMsg("库存数量不足，不能退回！");
                        return model;
                    }

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

        //更新移库单及移库明细状态
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

    @Override
    public ResultModel deleteWarehouseMoveDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = this.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细不可删除，该移库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 删除移库明细
        this.deleteById(detailId);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());
        return model;
    }

    @Override
    public ResultModel cancelWarehouseMoveDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = this.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细是已完成状态，不可取消！");
            return model;
        }

        PageData pd = new PageData();
        pd.put("queryStr","detail_id ='"+detail.getId()+"' and isdisable = '1' ");
        pd.put("mapSize", Integer.valueOf(pd.size()));
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataList(pd);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            model.putCode("1");
            model.putMsg("该移库单执行人已开始执行，不能直接更换执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }


        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        this.update(detail);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());
        return model;
    }



    public List<Map> getExecuteChildrenList(Map rootMap,Map childrenTitleMap,PageData pd)  throws Exception {

        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("parentId",rootMap.get("id"));

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                childrenMapList.add(varMap);
            }
        }
        return childrenMapList;
    }

    @Override
    public ResultModel recoveryWarehouseMoveDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = this.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细不是取消状态，不能执行恢复操作！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("1");
        this.update(detail);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());
        return model;
    }

    @Override
    public ResultModel listPageWarehouseMoveDetailsExecute(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMove");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseMoveDetailExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = ColumnUtil.getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseMoveService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)rootTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("hideTitles",childrenTitleMap.get("hideTitles"));
                varMap.put("titles",childrenTitleMap.get("titles"));
                varMap.put("pid",null);
                varMap.put("children",getExecuteChildrenList(map,childrenTitleMap,pd));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }


    public List<Map> getOutRecordsChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("detailId",rootMap.get("id"));

        DecimalFormat df = new DecimalFormat("0.00");

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseMoveExecuteService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double actualCount = Double.parseDouble((String)varMap.get("actualCount"));

                varMap.put("actualCount",df.format(actualCount));
                childrenMapList.add(varMap);
            }
        }
        return childrenMapList;
    }

    @Override
    public ResultModel listPageWarehouseMoveDetailsRecords(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetailRecords");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseMoveExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = ColumnUtil.getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)rootTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("hideTitles",childrenTitleMap.get("hideTitles"));
                varMap.put("titles",childrenTitleMap.get("titles"));
                varMap.put("pid",null);
                varMap.put("children",getOutRecordsChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel listPageWarehouseMoveDetailsBySimple(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPageBySimple(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseMoveDetails(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelWarehouseMoveDetails(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetail");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseMoveDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseMoveDetails(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
                || fileName.matches("^.+\\.(?i)(xls)$"))
                ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        return model;
    }
}



