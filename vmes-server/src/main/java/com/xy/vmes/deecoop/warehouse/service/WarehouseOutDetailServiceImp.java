package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.yvan.common.util.Common;
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
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailMapper warehouseOutDetailMapper;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseOutRecommendService warehouseOutRecommendService;
    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;
    @Autowired
    private BomTreeService bomTreeService;
    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private SystemToolService systemToolService;

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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
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


    @Override
    public List<Map> getDataListPage(PageData pd) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}
        return warehouseOutDetailMapper.getDataListPage(pd);
    }
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseOutDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return warehouseOutDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
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

            try {
                //获取当前货品id的计量单位
                PageData findMap = new PageData();
                findMap.put("productId", detail.getProductId());
                //单位类型 (1:计量单位 0:计价单位)
                findMap.put("type", "1");
                //是否禁用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                ProductUnit productUnit = productUnitService.findProductUnit(findMap);
                if (productUnit != null && productUnit.getUnit() != null) {
                    detail.setProductUnit(productUnit.getUnit().trim());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //计价单位转换计量单位
            //p2nFormula 计价转换计量单位 数量转换公式 pn_formula
            String p2nFormula = "";
            if (mapObject.get("p2nFormula") != null && mapObject.get("p2nFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("p2nFormula").toString().trim();
            }

            //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
            String p2nIsScale = new String();
            if (mapObject.get("p2nIsScale") != null) {
                p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
            }

            //小数位数 (最小:0位 最大:4位)
            Integer p2nDecimalCount = Integer.valueOf(2);
            String p2nDecimalCountStr = mapObject.get("p2nDecimalCount");
            if (p2nDecimalCountStr != null) {
                try {
                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //(货品)单据单位-出库数量
            BigDecimal priceCount = BigDecimal.valueOf(0D);
            String priceCountStr = mapObject.get("priceCount");
            if (priceCountStr != null) {
                try {
                    priceCount = new BigDecimal(priceCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            detail.setPriceCount(priceCount);

            //货品(计量单位)数量
            BigDecimal productCount = EvaluateUtil.countFormulaP2N(priceCount, p2nFormula);
            productCount = StringUtil.scaleDecimal(productCount, p2nIsScale, p2nDecimalCount);
            detail.setProductCount(productCount);
            detail.setCount(productCount);

            //单据货品单价
            String priceStr = mapObject.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    BigDecimal price = new BigDecimal(priceStr);
                    //四舍五入到2位小数
                    //price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    detail.setPrice(price);

                    //货品金额： 单据单位(出库数量) * 单据货品单价
                    BigDecimal sumPrice = BigDecimal.valueOf(priceCount.doubleValue() * price.doubleValue());

                    //获取(计量单位：货品单价)
                    BigDecimal productPrice = BigDecimal.valueOf(0D);
                    if (productCount != null && productCount.doubleValue() != 0D) {
                        productPrice = BigDecimal.valueOf(sumPrice.doubleValue() / productCount.doubleValue());
                    }
                    //四舍五入到2位小数
                    productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    detail.setProductPrice(productPrice);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

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
    public void addWarehouseOutDetail(String parentId, String cuser, List<WarehouseOutDetail> objectList) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseOutDetail detail : objectList) {
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentId);
            detail.setCuser(cuser);
            this.save(detail);
        }
    }

    public void addWarehouseOutDetailBySimple(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseOutDetail detail : objectList) {
            //detail.setWarehouseId(parentObj.getWarehouseId());
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }
    public void addWarehouseOutDetailExecuteBySimple(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseOutDetail detail : objectList) {
            //detail.setWarehouseId(parentObj.getWarehouseId());
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("2");
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

    public List<Map<String, Object>> findMapListWarehouseOutDetail(PageData pd) throws Exception {
        return warehouseOutDetailMapper.findWarehouseOutDetailList(pd);
    }

    ///////////////////////////////////////////////////////////////////////////////

    @Override
    public ResultModel rebackWarehouseOutDetail(PageData pageData) throws Exception {

        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String cuser = pageData.getString("cuser");
        String currentCompanyId = pageData.getString("currentCompanyId");
        String rebackBillReason = pageData.getString("rebackBillReason");

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        if(!StringUtils.isEmpty(currentUserId)){
            columnMap.put("executor_id",currentUserId);
        }
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
                    loginfo.setCuser(cuser);
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
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String executorIdsStr = pageData.getString("executorIdsStr");
        String jsonDataStr = pageData.getString("jsonDataStr");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);

        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> detailMap = mapList.get(j);
                if(detailMap!=null&&detailMap.get("children")!=null){
                    String detailId = (String)detailMap.get("id");
                    String warehouseOutCode = (String)detailMap.get("warehouseOutCode");
                    String productName = (String)detailMap.get("productName");

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

                                    Task task = taskService.createTaskByWarehouseOut(detailId, executorId, cuser);
                                    task.setTaskName(warehouseOutCode + "_" + productName);
                                    task.setCompanyId(companyId);
                                    taskService.save(task);
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
    public ResultModel listPageForAddFromBOM(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        String dtlJsonStr = pd.getString("dtlJsonStr");

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0 || "{}".equals(dtlJsonStr)) {
            PageData pageData = new PageData();
            pageData.put("parentId","null");
            pageData.put("fieldCode",pd.getString("fieldCode"));
            pageData.put("isNeedPage","false");
            return this.listPageWarehouseOutDetails(pageData);
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        List<Map> treeMapList = new ArrayList();
        if(mapList!=null&&mapList.size()>0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> detailMap = mapList.get(i);

                if(detailMap.get("bomId")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("BOM ID 不能为空！");
                    return model;
                }
                if(detailMap.get("id")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("产品 ID 不能为空！");
                    return model;
                }
//                detailMap.put("bomId",detailMap.get("bomId"));
//                detailMap.put("id",detailMap.get("id"));
                TreeEntity treeEntity = (TreeEntity) HttpUtils.pageData2Entity(detailMap, new TreeEntity());
                BigDecimal planCount = treeEntity.getPlanCount()==null?BigDecimal.ZERO:treeEntity.getPlanCount();

                PageData pageData = new PageData();
                pageData.put("bomId",treeEntity.getBomId());

                if(pd.get("isreplaceable")!=null && "1".equals(pd.get("isreplaceable"))){
                    pageData.put("isreplaceable",null);
                }else{
                    pageData.put("isreplaceable",'0');
                }

                List<TreeEntity> treeList = bomTreeService.getBomTreeProductList(pageData);

                Map map = new HashMap();
                map.put("productId",treeEntity.getId());
                map.put("planCount",planCount);
                map.put("treeList",treeList);
                treeMapList.add(map);
            }
        }
        if(treeMapList!=null&&treeMapList.size()>0){
            String prodIds = null;

            List<TreeEntity> varList = TreeUtil.getMaterielNum(treeMapList);
            if(varList!=null&&varList.size()>0){
                Map planCountMap = new HashMap();
                for(int i=0;i<varList.size();i++){
                    TreeEntity treeEntity = varList.get(i);
                    String prodId = treeEntity.getId();
                    planCountMap.put(prodId,treeEntity.getPlanCount().setScale(0,BigDecimal.ROUND_DOWN));
                    if(prodIds == null){
                        prodIds =  "'" + prodId+"'";
                    }else{
                        prodIds = prodIds +",'"+prodId+"'";
                    }
                }
                PageData pageData = new PageData();
                pageData.put("prodIds",prodIds);
                List<Map> addFromBOMList =  warehouseOutDetailMapper.getDataListPageForAddFromBOM(pageData);

                if(addFromBOMList!=null&&addFromBOMList.size()>0){
                    for(int i=0;i<addFromBOMList.size();i++){
                        Map addFromBOMMap = addFromBOMList.get(i);
                        String prodId = (String)addFromBOMMap.get("id");
                        addFromBOMMap.put("priceCount",planCountMap.get(prodId));
                    }
                }

                List<Column> columnList = columnService.findColumnList("WarehouseOutDetail");
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
                List<Map> varMapList = ColumnUtil.getVarMapList(addFromBOMList,titleMap);

                result.put("hideTitles",titleMap.get("hideTitles"));
                result.put("titles",titleMap.get("titles"));
                result.put("varList",varMapList);
                model.putResult(result);
                return model;

            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("无查询记录！");
                return model;
            }

        }else {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无查询记录！");
            return model;
        }
    }

    @Override
    public ResultModel listPageWarehouseOutDetails(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg =  HttpUtils.parsePagination(pd);

        //出库单明细表 (出库模块与报废模块)
        //modelCode:WarehouseOutDetail 出库模块
        //modelCode:WarehouseScrapDetail 报废模块
        String modelCode = "WarehouseOutDetail";
        String typeName = pd.getString("typeName");
        if (typeName != null && "报废处理".equals(typeName)) {
            modelCode = "WarehouseScrapDetail";
        }else if (typeName != null && "领料明细".equals(typeName)) {
            modelCode = "MaterialRequisitionDetail";
        }

        List<Column> columnList = columnService.findColumnList(modelCode);
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        List<Map> varList = this.getDataListPage(pd, pg);


        if (varList != null && varList.size() > 0) {
            String prodColumnKey = pd.getString("prodColumnKey");
            for (Map<String, Object> mapObject : varList) {

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);

                //priceCount 计价单位数量
                BigDecimal priceCount = BigDecimal.valueOf(0D);
                if (mapObject.get("priceCount") != null) {
                    priceCount = (BigDecimal)mapObject.get("priceCount");
                }

                //n2pIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String n2pIsScale = new String();
                if (mapObject.get("n2pIsScale") != null) {
                    n2pIsScale = mapObject.get("n2pIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer n2pDecimalCount = Integer.valueOf(2);
                if (mapObject.get("n2pDecimalCount") != null) {
                    n2pDecimalCount = (Integer)mapObject.get("n2pDecimalCount");
                }
                priceCount = StringUtil.scaleDecimal(priceCount, n2pIsScale, n2pDecimalCount);
                mapObject.put("priceCount", priceCount.toString());

                //n2pFormula (计量单位转换计价单位公式)
                String n2pFormula = (String)mapObject.get("n2pFormula");
                //stockCount (计量单位)库存数量
                BigDecimal stockCount = BigDecimal.valueOf(0D);
                if (mapObject.get("stockCount") != null) {
                    stockCount = (BigDecimal)mapObject.get("stockCount");
                }

                //stockCountByPrice        (计价单位)库存数量
                BigDecimal stockCountByPrice = EvaluateUtil.countFormulaN2P(stockCount, n2pFormula);
                stockCountByPrice = StringUtil.scaleDecimal(stockCountByPrice, n2pIsScale, n2pDecimalCount);
                mapObject.put("stockCountByPrice", stockCountByPrice.toString());

                //count 出库数量(计量单位)
                BigDecimal count = BigDecimal.valueOf(0D);
                if (mapObject.get("count") != null) {
                    count = (BigDecimal)mapObject.get("count");
                }
                //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String p2nIsScale = new String();
                if (mapObject.get("p2nIsScale") != null) {
                    p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer p2nDecimalCount = Integer.valueOf(2);
                if (mapObject.get("p2nDecimalCount") != null) {
                    p2nDecimalCount = (Integer)mapObject.get("p2nDecimalCount");
                }
                count = StringUtil.scaleDecimal(count, p2nIsScale, p2nDecimalCount);
                mapObject.put("count", count.toString());

                //executeCount 已完成数量(计量单位)
                BigDecimal executeCount = BigDecimal.valueOf(0D);
                if (mapObject.get("executeCount") != null) {
                    executeCount = (BigDecimal)mapObject.get("executeCount");
                }
                executeCount = StringUtil.scaleDecimal(executeCount, p2nIsScale, p2nDecimalCount);
                mapObject.put("executeCount", executeCount.toString());
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
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



    private List<Map> getDispatchChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("productId",rootMap.get("productId"));

        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
        }

        //查询仓库下所有子节点
        pd.put("isNeedWarehouse", "true");
        String parentWarehouseId = new String();
        if (rootMap.get("parentWarehouseId") != null && rootMap.get("parentWarehouseId").toString().trim().length() > 0) {
            parentWarehouseId = rootMap.get("parentWarehouseId").toString().trim();
            parentWarehouseId = "'%" + parentWarehouseId +"%'";
        }
        pd.put("parentWarehouseId", parentWarehouseId);
        pd.put("orderStr", "product.code asc");

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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
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
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutRecommend");
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
                varMap.put("children",getExecuteChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }



    public List<Map> getExecuteChildrenListByWC(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        pd.put("productId",rootMap.get("productId"));
        pd.put("isNotNeedSpare","true");
        pd.put("isNeedEntity","true");
        pd.put("isStockCountGreaterThanZero","true");


        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        double executeCount = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
            executeCount = ((BigDecimal) rootMap.get("executeCount")).doubleValue();

        }

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseProductService.getDataListPageDispatchByWC(pd);
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

                if(stockCount<=(count-executeCount)){
                    varMap.put("suggestCount",df.format(stockCount));
                    childrenMapList.add(varMap);
                    executeCount = executeCount + stockCount;
                }else if(stockCount>(count-executeCount)){
                    varMap.put("suggestCount",df.format(count-executeCount));
                    childrenMapList.add(varMap);
                    break;
                }
            }
        }
        return childrenMapList;
    }

    @Override
    public ResultModel listPageWarehouseOutDetailsExecuteByWC(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);

        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutRecommendByWC");
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
                varMap.put("children",getExecuteChildrenListByWC(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }




    public List<Map> getExecuteChildrenListBySimple(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        pd.put("productId",rootMap.get("productId"));
        pd.put("isNotNeedSpare","true");
        pd.put("isNeedEntity","true");
        pd.put("isStockCountGreaterThanZero","true");


        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        double executeCount = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
            executeCount = ((BigDecimal) rootMap.get("executeCount")).doubleValue();

        }

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseProductService.getDataListPageDispatchBySimple(pd);
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

                if(stockCount<=(count-executeCount)){
                    varMap.put("suggestCount",df.format(stockCount));
                    childrenMapList.add(varMap);
                    executeCount = executeCount + stockCount;
                }else if(stockCount>(count-executeCount)){
                    varMap.put("suggestCount",df.format(count-executeCount));
                    childrenMapList.add(varMap);
                    break;
                }
            }
        }
        return childrenMapList;
    }




    @Override
    public ResultModel listPageWarehouseOutDetailsExecuteBySimple(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);

        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutRecommendBySimple");
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
                varMap.put("children",getExecuteChildrenListBySimple(map,childrenTitleMap));
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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseProductDispatch");
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
                varMap.put("children",this.getDispatchChildrenList(map,childrenTitleMap));
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
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
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



