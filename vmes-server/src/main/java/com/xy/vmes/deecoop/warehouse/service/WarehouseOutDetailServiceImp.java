package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

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
    private ColumnService columnService;

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

    @Override
    public ResultModel dispatchWarehouseOutDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String executorIdsStr = pageData.getString("executorIdsStr");
        String jsonDataStr = pageData.getString("jsonDataStr");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);



        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> detailMap = mapList.get(j);
                if(detailMap!=null&&detailMap.get("children")!=null){
                    String detailId = (String)detailMap.get("id");
                    if(!StringUtils.isEmpty(detailId)){

                        //新增出库执行人记录
                        if(!StringUtils.isEmpty(executorIdsStr)){
                            String[] executorIds = executorIdsStr.split(",");
                            if(executorIds!=null&&executorIds.length>0){
                                for(int i=0;i<executorIds.length;i++){
                                    String executorId = executorIds[i];
                                    WarehouseOutExecutor executor = new WarehouseOutExecutor();
                                    executor.setExecutorId(executorId);
                                    executor.setDetailId(detailId);
                                    warehouseOutExecutorService.save(executor);
                                }
                            }
                        }

                        //新增推荐库位记录
                        List childrenList = (List) detailMap.get("children");
                        if(childrenList!=null&&childrenList.size()>0){
                            for(int k=0;k<childrenList.size();k++){
                                Map<String, Object> childrenMap = (Map<String, Object>)childrenList.get(k);
                                if(childrenMap != null){
                                    String warehouseProductId = (String)childrenMap.get("id");
                                    String suggestCount = (String)childrenMap.get("suggestCount");
                                    WarehouseOutRecommend recommend = new WarehouseOutRecommend();
                                    recommend.setDetailId(detailId);
                                    recommend.setWarehouseProductId(warehouseProductId);
                                    recommend.setCount(StringUtils.isEmpty(suggestCount)?BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(suggestCount)));
                                    warehouseOutRecommendService.save(recommend);
                                }
                            }
                        }

                        //更新出库单及出库明细状态
                        WarehouseOutDetail detail = this.selectById(detailId);
                        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                        detail.setState("1");
                        this.update(detail);
                        warehouseOutService.updateState(detail.getParentId());

                    }
                }

            }
        }
        return model;
    }

    @Override
    public ResultModel recoveryWarehouseOutDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = this.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不是取消状态，不能恢复！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        this.update(detail);
        //2.返写出库单状态
        warehouseOutService.updateState(detail.getParentId());

        return model;
    }

    @Override
    public ResultModel cancelWarehouseOutDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = this.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不可取消，该出库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        this.update(detail);
        //2.返写出库单状态
        warehouseOutService.updateState(detail.getParentId());
        return model;
    }

    @Override
    public ResultModel deleteWarehouseOutDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = this.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不可删除，该出库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 删除入库明细
        this.deleteById(detailId);
        //2.返写入库单状态
        warehouseOutService.updateState(detail.getParentId());
        return model;
    }

    @Override
    public ResultModel listPageWarehouseOutDetails(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
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
        List<Map> varList = warehouseOutExecuteService.getDataListPage(pd,pg);
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

    public Map getTitleList(List<Column> columnList){
        Map result = new HashMap();
        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);
        result.put("varModel",varModelMap);
        return result;
    }



    public List<Map> getDispatchChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("productId",rootMap.get("productId"));

        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
        }


        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseProductService.getDataListPageDispatch(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double stockCount = Double.parseDouble((String)varMap.get("stockCount"));
                if(count>0){
                    if(count>=stockCount){
                        varMap.put("suggestCount",df.format(stockCount));
                        count = count - stockCount;
                        childrenMapList.add(varMap);
                    }else if(count<stockCount){
                        varMap.put("suggestCount",df.format(count));
                        count = 0;
                        childrenMapList.add(varMap);
                    }
                }
            }
        }
        return childrenMapList;
    }


    @Override
    public ResultModel listPageWarehouseOutDetailsOutRecords(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailRecords");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取指定栏位字符串-重新调整List<Column>
        String firstFieldCode = pd.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String secondFieldCode = pd.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);


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

    public List<Map> getExecuteChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("detailId",rootMap.get("id"));

        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        double executeCount = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
            executeCount = ((BigDecimal) rootMap.get("executeCount")).doubleValue();

        }


        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseOutRecommendService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double suggestCount = Double.parseDouble((String)varMap.get("suggestCount"));
                double stockCount = Double.parseDouble((String)varMap.get("stockCount"));

                if(stockCount<=suggestCount&&stockCount<=(count-executeCount)){
                    varMap.put("suggestCount",df.format(stockCount));
                    childrenMapList.add(varMap);
                }else if(stockCount<=suggestCount&&stockCount>(count-executeCount)){
                    varMap.put("suggestCount",df.format(count-executeCount));
                    childrenMapList.add(varMap);
                }else if(stockCount>suggestCount&&stockCount<=(count-executeCount)){
                    varMap.put("suggestCount",df.format(suggestCount));
                    childrenMapList.add(varMap);
                }else if(stockCount>suggestCount&&stockCount>(count-executeCount)&&suggestCount>(count-executeCount)){
                    varMap.put("suggestCount",df.format(count-executeCount));
                    childrenMapList.add(varMap);
                }else if(stockCount>suggestCount&&stockCount>(count-executeCount)&&suggestCount<=(count-executeCount)){
                    varMap.put("suggestCount",df.format(suggestCount));
                    childrenMapList.add(varMap);
                }
            }
        }
        return childrenMapList;
    }

    @Override
    public ResultModel listPageWarehouseOutDetailsExecute(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutRecommend");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



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
                varMap.put("children",getExecuteChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseOutDetailsDispatch(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseProductDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



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
                varMap.put("children",getDispatchChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelWarehouseOutDetails(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("WarehouseOutDetail");
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
            fileName = "ExcelWarehouseOutDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseOutDetails(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

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



