package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutExecuteMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
* 说明：出库执行 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-01
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutExecuteServiceImp implements WarehouseOutExecuteService {
    @Autowired
    private WarehouseOutExecuteMapper warehouseOutExecuteMapper;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductToolService warehouseProductToolService;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;

    @Autowired
    SaleDeliverOutDetailService saleDeliverOutDetailService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProductService productService;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void save(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setId(Conv.createUuid());
        warehouseOutExecute.setCdate(new Date());
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.insert(warehouseOutExecute);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void update(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.updateById(warehouseOutExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateAll(WarehouseOutExecute warehouseOutExecute) throws Exception{
        warehouseOutExecute.setUdate(new Date());
        warehouseOutExecuteMapper.updateAllColumnById(warehouseOutExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutExecute", key = "''+#id")
    public WarehouseOutExecute selectById(String id) throws Exception{
        return warehouseOutExecuteMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutExecuteMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> dataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutExecuteMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutExecute> warehouseOutExecuteList =  warehouseOutExecuteMapper.selectByMap(columnMap);
        return warehouseOutExecuteList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutExecuteMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            return warehouseOutExecuteMapper.getDataListPage(pd);
        }
        return warehouseOutExecuteMapper.getDataListPage(pd,pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception{
        return warehouseOutExecuteMapper.getDataListPage(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutExecuteMapper.updateToDisableByIds(ids);
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public Long findMaxExecuteDateByMapList(List<Map> mapList) {
        if (mapList == null || mapList.size() == 0) {return Long.valueOf(0L);}

        long max = 0L;
        for (Map mapObject : mapList) {
            //出库执行日期 executeDateLong
            Long executeDateLong = Long.valueOf(0L);
            if (mapObject.get("executeDateLong") != null) {
                executeDateLong = (Long)mapObject.get("executeDateLong");
            }
            if (max < executeDateLong.longValue()) {
                max = executeDateLong.longValue();
            }
        }

        return Long.valueOf(max);
    }

    /**
     * @param outDetail
     * @param outMapList List<货位货品仓库Map<String, Object>>
     *     货位货品仓库Map<String, Object>
     *         warehouseProductId
     *         productId
     *         warehouseId
     *         outCount
     * @param executeList
     */
    public List<WarehouseOutExecute> outMapList2ExecuteList(WarehouseOutDetail outDetail,
                                                            List<Map<String, Object>> outMapList,
                                                            List<WarehouseOutExecute> executeList) {
        if (executeList == null) {executeList = new ArrayList<WarehouseOutExecute>();}
        if (outMapList == null || outMapList.size() == 0) {return executeList;}

        for (Map<String, Object> mapObject : outMapList) {
            WarehouseOutExecute outExecute = new WarehouseOutExecute();

            outExecute.setDetailId(outDetail.getId());
            outExecute.setExecutorId(outDetail.getCuser());
            outExecute.setCuser(outDetail.getCuser());

            //String warehouseId = (String)mapObject.get("warehouseId");
            //outExecute.setWarehouseId(warehouseId);

            String warehouseProductId = (String)mapObject.get("warehouseProductId");
            outExecute.setWarehouseProductId(warehouseProductId);

            BigDecimal count = BigDecimal.valueOf(0D);
            if (mapObject.get("outCount") != null) {
                count = (BigDecimal)mapObject.get("outCount");
                //四舍五入到2位小数
                count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            }
            outExecute.setCount(count);

            executeList.add(outExecute);
        }

        return executeList;
    }

    public void addWarehouseOutExecuteBySimple(List<WarehouseOutExecute> executeList) throws Exception {
        if (executeList == null || executeList.size() == 0) {return;}

        for (WarehouseOutExecute outExecute : executeList) {
            this.save(outExecute);
        }
    }

    public void executeWarehouseOutExecuteBySimple(WarehouseOut warehouseOut) throws Exception {
        List<Map> executeList = this.findExecuteListByParentId(warehouseOut.getId());
        if (executeList == null || executeList.size() == 0) {return;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (int i = 0; i < executeList.size(); i++) {
                Map object = executeList.get(i);

                String detailId = (String)object.get("detailId");
                BigDecimal count = (BigDecimal)object.get("actualCount");
                String warehouseId = (String)object.get("warehouseId");
                String productId = (String)object.get("productId");
                String code = (String)object.get("code");

                //(简版仓库)出库操作
                WarehouseProduct outObject = new WarehouseProduct();
                //产品ID
                outObject.setProductId(productId);
                //(实际)货位ID
                outObject.setWarehouseId(warehouseId);
                //货位批次号
                outObject.setCode(code);

                //库存变更日志
                String executeId = Conv.createUuid();

                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(warehouseOut.getId());
                loginfo.setDetailId(detailId);
                loginfo.setExecuteId(executeId);
                loginfo.setCompanyId(warehouseOut.getCompanyId());
                loginfo.setCuser(warehouseOut.getCuser());
                //operation 操作类型(add:添加 modify:修改 delete:删除:)
                loginfo.setOperation("add");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(count);

                String msgStr = warehouseProductService.outStockCount(outObject, count, loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "出库操作失败:" + msgStr);
                } else {
                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - count.doubleValue());
                    productService.updateStockCount(product, prodStockCount, warehouseOut.getCuser(), "out");
                }
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                throw new ApplicationException("系统繁忙请稍后再次操作");
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            throw new ApplicationException(msgBuf.toString());
        }

        //修改出库单明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", warehouseOut.getId());
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "2");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //修改出库单状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseOut warehouseoutEdit = new WarehouseOut();
        warehouseoutEdit.setId(warehouseOut.getId());
        warehouseoutEdit.setState("1");
        warehouseOutService.update(warehouseoutEdit);
    }

    public List<Map> findExecuteListByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return new ArrayList<Map>();}

        List<Map> mapList = new ArrayList<Map>();
        try {
            PageData findMap = new PageData();
            findMap.put("parentId", parentId);
            mapList = warehouseOutExecuteMapper.getDataList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapList;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel addWarehouseOutExecute(String detailId, String warehouseId, String warehouseProductId, String currentUserId,String currentCompanyId, BigDecimal count) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseOutExecute execute = new WarehouseOutExecute();
        execute.setDetailId(detailId);
        execute.setWarehouseId(warehouseId);
        execute.setExecutorId(currentUserId);
        execute.setWarehouseProductId(warehouseProductId);
        execute.setCount(count);
        this.save(execute);




        //添加出库单明细-出库执行
        try {
            //出库操作
            WarehouseProduct outObject = warehouseProductService.selectById(warehouseProductId);


            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setCompanyId(currentCompanyId);
            loginfo.setCuser(currentUserId);
            //operation 操作类型(add:添加 modify:修改 delete:删除:)
            loginfo.setOperation("add");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(BigDecimal.ZERO);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(execute.getCount());

            loginfo.setExecuteId(execute.getId());
            loginfo.setDetailId(execute.getDetailId());
//            if(outObject.getStockCount().compareTo(count)<0){
//                model.putCode(Integer.valueOf(1));
//                model.putMsg("库存数量不足，不能执行！");
//                return model;
//            }
            String msgStr = warehouseProductService.outStockCount(outObject, count, loginfo);

            Product product = productService.selectById(outObject.getProductId());
            productService.updateStockCount(product, product.getStockCount().subtract(count), currentUserId, "out");


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

        return model;
    }

    @Override
    public ResultModel updateWarehouseOutState(String detailId) throws Exception {
        ResultModel model = new ResultModel();

        //更新出库单及出库明细状态
        WarehouseOutDetail detail = warehouseOutDetailService.selectById(detailId);
        Task task = taskService.findTaskByBusinessId(detailId);

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        BigDecimal totalCount = BigDecimal.ZERO;
        List<WarehouseOutExecute> warehouseOutExecuteList = this.selectByColumnMap(columnMap);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            for(int i=0;i<warehouseOutExecuteList.size();i++){
                WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteList.get(i);
                if(warehouseOutExecute!=null&&warehouseOutExecute.getCount()!=null){
                    totalCount = totalCount.add(warehouseOutExecute.getCount());
                }
            }
        }
        Map countResult = new HashMap();
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if(detail.getCount().compareTo(totalCount)>0){
            //执行状态(0:待执行 1:已完成 -1:已取消)
            if(task!=null){
                task.setState("0");
            }
            detail.setState("1");
            countResult.put("unCompleteCount",(detail.getCount().subtract(totalCount).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
        }else {
            //执行状态(0:待执行 1:已完成 -1:已取消)
            if(task!=null){
                task.setState("1");
            }
            detail.setState("2");
            countResult.put("unCompleteCount",0.00);
        }
        model.putResult(countResult);
        warehouseOutDetailService.update(detail);
        if(task!=null){
            taskService.update(task);
        }
        warehouseOutService.updateState(detail.getParentId());

        if(saleDeliverOutDetailService!=null){
            saleDeliverOutDetailService.finishOutDetailUnlock(detail.getId());
        }

        return model;
    }



    @Override
    public ResultModel auditWarehouseOutExecuteBySimple(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        PageData pd = new PageData();
        pd.put("parentId",parentId);
        List<Map> mapList = warehouseOutDetailService.getDataListPage(pd);

        StringBuffer msgBuf = new StringBuffer();
        if(mapList!=null&&mapList.size()>0){
            for (Map outDetailMap : mapList) {
                String productId = (String) outDetailMap.get("productId");
                String productName = (String) outDetailMap.get("productName");
                BigDecimal count = (BigDecimal)outDetailMap.get("count");

                //验证当前(货品id)在库存中的数量
                PageData findMap = new PageData();
                findMap.put("companyId", currentCompanyId);
                findMap.put("productId", productId);
                //查询结果集需要(实体库)-结果集只含有(实体库)
                findMap.put("isNeedEntity", "true");
                //查询结果集不需要(备件库)
                findMap.put("isNotNeedSpare", "true");
                List<Map> warehouseProductMapList = warehouseToWarehouseProductService.findWarehouseToWarehouseProductByProduct(findMap, null);
                BigDecimal productStockCount = this.findProductStockCount(warehouseProductMapList);

                if (count.doubleValue() > productStockCount.doubleValue()) {
                    String msgTemp = "货品名称：{0} 该货品库存不足，请更改报废数量";
                    String msgStr = MessageFormat.format(msgTemp, productName);
                    msgBuf.append(msgStr);
                    continue;
                }

            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        if(mapList!=null&&mapList.size()>0){
            for (Map outDetailMap : mapList) {
                String detailId = (String) outDetailMap.get("id");
                String productId = (String) outDetailMap.get("productId");
                String warehouseId = (String)outDetailMap.get("warehouseId");
                BigDecimal count = (BigDecimal)outDetailMap.get("count");

                WarehouseOutExecutor outExecutor = new WarehouseOutExecutor();
                outExecutor.setDetailId(detailId);
                outExecutor.setExecutorId(currentUserId);
                outExecutor.setCuser(currentUserId);

                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
                if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
                    for(int i=0;i<warehouseOutExecutorList.size();i++){
                        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                        warehouseOutExecutor.setIsdisable("0");
                        warehouseOutExecutor.setRemark("执行人变更");
                        warehouseOutExecutorService.update(warehouseOutExecutor);
                    }
                }
                warehouseOutExecutorService.save(outExecutor);

                WarehouseOutDetail outDetail = new WarehouseOutDetail();
                outDetail.setId(detailId);
                outDetail.setCuser(currentUserId);

                List<WarehouseOutExecute> outExecuteList = new ArrayList<WarehouseOutExecute>();
                List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,currentCompanyId,warehouseId,count);
                if (outMapList != null && outMapList.size() > 0) {
                    outExecuteList = this.outMapList2ExecuteList(outDetail, outMapList, outExecuteList);
                }
                this.addWarehouseOutExecuteBySimple(outExecuteList);
                this.executeWarehouseOutExecuteBySimple(parentId,detailId,currentUserId,currentCompanyId,outExecuteList);
                this.updateWarehouseOutState(detailId);
            }
        }


        return model;
    }



    @Override
    public ResultModel executeWarehouseOutExecuteBySimple(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String jsonDataStr = pageData.getString("jsonDataStr");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);

        StringBuffer msgBuf = new StringBuffer();
        if(mapList!=null&&mapList.size()>0){
            //第一层: 数据遍历
            for (Map<String, Object> outDetailMap : mapList) {
                //String productId = (String) outDetailMap.get("productId");
                //String productCode = (String) outDetailMap.get("productCode");
                //String productName = (String) outDetailMap.get("productName");

                double count = Double.parseDouble((String)outDetailMap.get("count"));
                //BigDecimal countBig = BigDecimal.valueOf(count);
                //四舍五入到2位小数
                //countBig = countBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                double executeCount = Double.parseDouble((String)outDetailMap.get("executeCount"));
                double lackCount = count - executeCount;

//                //验证当前(货品id)在库存中的数量
//                PageData findMap = new PageData();
//                findMap.put("companyId", currentCompanyId);
//                findMap.put("productId", productId);
//                //查询结果集需要(实体库)-结果集只含有(实体库)
//                findMap.put("isNeedEntity", "true");
//                //查询结果集不需要(备件库)
//                findMap.put("isNotNeedSpare", "true");
//
//                List<Map> warehouseProductMapList = warehouseToWarehouseProductService.findWarehouseToWarehouseProductByProduct(findMap, null);
//                BigDecimal productStockCount = this.findProductStockCount(warehouseProductMapList);
//                if (count > productStockCount.doubleValue()) {
//                    String msgTemp = "货品名称：{0} 该货品库存不足，请更改出库数量";
//                    String msgStr = MessageFormat.format(msgTemp, productName);
//                    msgBuf.append(msgStr);
//                    continue;
//                }

                //第二层: 数据遍历
                if(outDetailMap.get("children") != null) {
                    List executeList = (List)outDetailMap.get("children");
                    if(executeList!=null&&executeList.size()>0){
                        for (int i = 0; i < executeList.size(); i++) {
                            Map<String, Object> executeMap = (Map<String, Object>) executeList.get(i);
                            double suggestCount = Double.parseDouble((String)executeMap.get("suggestCount"));
                            if(suggestCount>lackCount){
                                model.putCode(Integer.valueOf(1));
                                model.putMsg("出库执行数量不能大于当前可出库数量！");
                                return model;
                            }else{
                                lackCount = lackCount - suggestCount;
                            }

                        }
                    }
                }
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //遍历数据集-获取(建议取货数量) 大于零的(建议取货数量)
        List<Map<String, Object>> outExecuteMapList = new ArrayList();

        //第一层: 数据遍历
        for (Map<String, Object> firstMap : mapList) {

            //第二层: 数据遍历 -- 大于零的(建议取货数量)
            List<Map<String, Object>> outExecuteChildrenList = new ArrayList();
            if(firstMap.get("children") != null && ((List)firstMap.get("children")).size() > 0) {
                List<Map<String, Object>> secondList = (List)firstMap.get("children");
                for (Map<String, Object> secondMap : secondList) {
                    //建议取货数量 suggestCount
                    BigDecimal suggestCount = BigDecimal.valueOf(0D);
                    String suggestCountStr = (String)secondMap.get("suggestCount");
                    if (suggestCountStr != null && suggestCountStr.trim().length() > 0) {
                        try {
                            suggestCount = new BigDecimal(suggestCountStr);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    if (suggestCount.doubleValue() > 0) {
                        outExecuteChildrenList.add(secondMap);
                    }
                }
            }

            if (outExecuteChildrenList.size() > 0) {
                firstMap.put("children", outExecuteChildrenList);
                outExecuteMapList.add(firstMap);
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //出库执行
        if(outExecuteMapList != null && outExecuteMapList.size()>0){
            for (Map<String, Object> outDetailMap : outExecuteMapList) {
                List<WarehouseOutExecute> outExecuteList = new ArrayList<WarehouseOutExecute>();
                String detailId = (String) outDetailMap.get("id");
                String parentId = (String) outDetailMap.get("parentId");

                WarehouseOutDetail outDetail = new WarehouseOutDetail();
                outDetail.setId(detailId);
                outDetail.setCuser(currentUserId);
                WarehouseOutExecutor outExecutor = new WarehouseOutExecutor();
                outExecutor.setDetailId(detailId);
                outExecutor.setExecutorId(currentUserId);
                outExecutor.setCuser(currentUserId);

                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
                if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
                    for(int i=0;i<warehouseOutExecutorList.size();i++){
                        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                        warehouseOutExecutor.setIsdisable("0");
                        warehouseOutExecutor.setRemark("执行人变更");
                        warehouseOutExecutorService.update(warehouseOutExecutor);
                    }
                }

                warehouseOutExecutorService.save(outExecutor);
                if(outDetailMap.get("children")!=null){
                    List executeList = (List)outDetailMap.get("children");
                    if(executeList!=null&&executeList.size()>0){
                        for (int i = 0; i < executeList.size(); i++) {
                            Map<String, Object> executeMap = (Map<String, Object>) executeList.get(i);
                            BigDecimal suggestCount = BigDecimal.valueOf(Double.parseDouble((String)executeMap.get("suggestCount")));
                            String productId = (String)executeMap.get("productId");
                            String warehouseId = (String)executeMap.get("warehouseId");
                            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,currentCompanyId,warehouseId,suggestCount);
                            if (outMapList != null && outMapList.size() > 0) {
                                outExecuteList = this.outMapList2ExecuteList(outDetail, outMapList, outExecuteList);
                            }
                        }
                    }
                }
                this.addWarehouseOutExecuteBySimple(outExecuteList);
                this.executeWarehouseOutExecuteBySimple(parentId,detailId,currentUserId,currentCompanyId,outExecuteList);
                this.updateWarehouseOutState(detailId);
            }
        }


        return model;
    }

    @Override
    public ResultModel executeWarehouseOutExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String jsonDataStr = pageData.getString("jsonDataStr");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);

        //1. 出库执行验证 出库单明细数量 (出库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        StringBuffer msgBuf = new StringBuffer();
        for (Map<String, Object> outDetailMap : mapList) {
            String detailId = (String)outDetailMap.get("id");

            PageData findMap = new PageData();
            findMap.put("detailId", detailId);
            List<Map> outMapList = warehouseOutDetailService.getDataListPage(findMap, null);

            Map outDtlMap = null;
            if (outMapList != null && outMapList.size() > 0) {
                outDtlMap = outMapList.get(0);
            }

            //新增推荐库位记录
            Object executeObj = outDetailMap.get("children");
            if (executeObj == null) {continue;}
            List executeList = (List)executeObj;
            if (executeList == null || executeList.size() == 0) {continue;}

            for (int i = 0; i < executeList.size(); i++) {
                Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);

                //建议取货数量 suggestCount
                BigDecimal suggestCount_big = BigDecimal.valueOf(0D);
                String suggestCount = (String)executeMap.get("suggestCount");
                if (suggestCount != null && suggestCount.trim().length() > 0) {
                    try {
                        suggestCount_big = new BigDecimal(suggestCount);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                //出库执行验证 出库单明细数量 (出库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
                if (outDtlMap != null) {
                    //productCode 货品编码
                    String productCode = new String();
                    if (outDtlMap.get("productCode") != null) {
                        productCode = outDtlMap.get("productCode").toString().trim();
                    }

                    //productName 货品名称
                    String productName = new String();
                    if (outDtlMap.get("productName") != null) {
                        productName = outDtlMap.get("productName").toString().trim();
                    }

                    //executeCount 已完成数量
                    BigDecimal executeCount = BigDecimal.valueOf(0D);
                    if (outDtlMap.get("executeCount") != null) {
                        executeCount = (BigDecimal)outDtlMap.get("executeCount");
                    }

                    //订单明细:出库数量
                    BigDecimal dtl_count = BigDecimal.valueOf(0D);
                    if (outDtlMap.get("count") != null) {
                        dtl_count = (BigDecimal)outDtlMap.get("count");
                    }

                    String msgTemp = "货品编码({0})货品名称({1}) 出库执行冲突，出库数量({2}) 已执行({3}) 不可大于剩余数量！" + Common.SYS_ENDLINE_DEFAULT;
                    if (dtl_count.doubleValue() < (executeCount.doubleValue() + suggestCount_big.doubleValue())) {
                        String msgStr = MessageFormat.format(msgTemp,
                                productCode,
                                productName,
                                dtl_count.toString(),
                                executeCount.toString());

                        model.putCode(Integer.valueOf(1));
                        model.putMsg(msgStr);
                        return model;
                    }
                }
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //2. 出库执行
        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> detailMap = mapList.get(j);
                if(detailMap!=null&&detailMap.get("children")!=null){
                    String detailId = (String)detailMap.get("id");
                    if(!StringUtils.isEmpty(detailId)){
                        //新增推荐库位记录
                        List childrenList = (List) detailMap.get("children");
                        if(childrenList!=null&&childrenList.size()>0){
                            for(int k=0;k<childrenList.size();k++){
                                Map<String, Object> childrenMap = (Map<String, Object>)childrenList.get(k);
                                String warehouseProductId = (String)childrenMap.get("id");
                                String warehouseId = (String)childrenMap.get("warehouseId");
                                String suggestCount = (String)childrenMap.get("suggestCount");
                                BigDecimal count = StringUtils.isEmpty(suggestCount)?BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(suggestCount));
                                model = this.addWarehouseOutExecute(detailId,warehouseId,warehouseProductId,currentUserId,currentCompanyId,count);
                                if(model.get("code") != null && !"0".equals(model.get("code").toString().trim())){
                                    return model;
                                }
                            }
                        }
                        model = this.updateWarehouseOutState(detailId);

                    }
                }
            }
        }
        return model;
    }


    @Override
    public ResultModel updateWarehouseOutExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String beforeCount = pageData.getString("beforeCount");
        String afterCount = pageData.getString("afterCount");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");

        if((!StringUtils.isEmpty(beforeCount))&&(!StringUtils.isEmpty(afterCount))){

            BigDecimal before = BigDecimal.valueOf(Double.parseDouble(beforeCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal after = BigDecimal.valueOf(Double.parseDouble(afterCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            WarehouseOutExecute execute = this.selectById(id);
            execute.setCount(after);
            if(StringUtils.isEmpty(execute.getRemark())){
                execute.setRemark("操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }else {
                execute.setRemark(execute.getRemark()+"  操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }

            this.update(execute);


            try {
                //还原出库操作
                WarehouseProduct outObject = warehouseProductService.selectById(execute.getWarehouseProductId());


                //库存变更日志
                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setCompanyId(currentCompanyId);
                loginfo.setCuser(currentUserId);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                loginfo.setOperation("modify");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(before);
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(after);


                loginfo.setExecuteId(execute.getId());
                loginfo.setDetailId(execute.getDetailId());

                String msgStr = warehouseProductService.outStockCount(outObject, after.subtract(before), loginfo);

                Product product = productService.selectById(outObject.getProductId());
                productService.updateStockCount(product,
                        product.getStockCount().subtract(after.subtract(before)),
                        currentUserId,
                        "out");

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
            WarehouseOutDetail detail = warehouseOutDetailService.selectById(execute.getDetailId());
            Task task = taskService.findTaskByBusinessId(execute.getDetailId());

            Map columnMap = new HashMap();
            columnMap.put("detail_id",execute.getDetailId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseOutExecute> warehouseOutExecuteList = this.selectByColumnMap(columnMap);
            if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
                for(int i=0;i<warehouseOutExecuteList.size();i++){
                    WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteList.get(i);
                    if(warehouseOutExecute!=null&&warehouseOutExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseOutExecute.getCount());
                    }
                }
            }
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if(detail.getCount().compareTo(totalCount)>0){
                //执行状态(0:待执行 1:已完成 -1:已取消)
                task.setState("0");
                detail.setState("1");
            }else {
                //执行状态(0:待执行 1:已完成 -1:已取消)
                task.setState("1");
                detail.setState("2");
            }

            taskService.update(task);
            warehouseOutDetailService.update(detail);
            warehouseOutService.updateState(detail.getParentId());
            //saleDeliverOutDetailService.finishOutDetailUnlock(detail.getId());
        }

        return model;
    }

    @Override
    public ResultModel deleteWarehouseOutExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        WarehouseOutExecute execute = this.selectById(id);
        execute.setIsdisable("0");
        if(StringUtils.isEmpty(execute.getRemark())){
            execute.setRemark("操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }else {
            execute.setRemark(execute.getRemark()+"  操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }
        this.update(execute);


        try {
            //还原出库操作
            WarehouseProduct outObject = warehouseProductService.selectById(execute.getWarehouseProductId());


            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setCompanyId(currentCompanyId);
            loginfo.setCuser(currentUserId);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("delete");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(execute.getCount());
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(BigDecimal.ZERO);

            loginfo.setExecuteId(execute.getId());
            loginfo.setDetailId(execute.getDetailId());

            String msgStr = warehouseProductService.outStockCount(outObject, execute.getCount().negate(), loginfo);

            Product product = productService.selectById(outObject.getProductId());
            productService.updateStockCount(product,
                    product.getStockCount().add(execute.getCount()),
                    currentUserId,
                    "out");

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
        WarehouseOutDetail detail = warehouseOutDetailService.selectById(execute.getDetailId());
        Task task = taskService.findTaskByBusinessId(execute.getDetailId());

        Map columnMap = new HashMap();
        columnMap.put("detail_id",execute.getDetailId());
        columnMap.put("isdisable","1");
        BigDecimal totalCount = BigDecimal.ZERO;
        List<WarehouseOutExecute> warehouseOutExecuteList = this.selectByColumnMap(columnMap);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            for(int i=0;i<warehouseOutExecuteList.size();i++){
                WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteList.get(i);
                if(warehouseOutExecute!=null&&warehouseOutExecute.getCount()!=null){
                    totalCount = totalCount.add(warehouseOutExecute.getCount());
                }
            }
        }
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if(detail.getCount().compareTo(totalCount)>0){
            //执行状态(0:待执行 1:已完成 -1:已取消)
            task.setState("0");
            detail.setState("1");
        }else {
            //执行状态(0:待执行 1:已完成 -1:已取消)
            task.setState("1");
            detail.setState("2");
        }

        taskService.update(task);
        warehouseOutDetailService.update(detail);
        warehouseOutService.updateState(detail.getParentId());
        //saleDeliverOutDetailService.finishOutDetailUnlock(detail.getId());
        return model;
    }

    @Override
    public ResultModel listPageWarehouseOutExecutes(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutExecute");
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


        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }


        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void executeWarehouseOutExecuteBySimple(String parentId,
                                                    String detailId,
                                                    String cuser,
                                                    String companyId,
                                                    List<WarehouseOutExecute> outExecuteList) throws Exception {
        //PageData findMap = new PageData();
        //findMap.put("detailId", detailId);
        //List<Map> executeList = warehouseOutExecuteMapper.getDataList(findMap);

        if (outExecuteList != null && outExecuteList.size() > 0) {
            for (int i = 0; i < outExecuteList.size(); i++) {
                WarehouseOutExecute OutExecute = outExecuteList.get(i);

                String executeId = OutExecute.getId();
                BigDecimal count = OutExecute.getCount();

                //仓库货品Id
                String warehouseProductId = OutExecute.getWarehouseProductId();
                WarehouseProduct WarehouseProduct = warehouseProductService.selectById(warehouseProductId);

                String warehouseId = WarehouseProduct.getWarehouseId();
                String productId = WarehouseProduct.getProductId();
                String code = WarehouseProduct.getCode();

                //(简版仓库)出库操作
                WarehouseProduct outObject = new WarehouseProduct();
                //产品ID
                outObject.setProductId(productId);
                //(实际)货位ID
                outObject.setWarehouseId(warehouseId);
                //货位批次号
                outObject.setCode(code);

                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(parentId);
                loginfo.setDetailId(detailId);
                loginfo.setExecuteId(executeId);
                loginfo.setCompanyId(companyId);
                loginfo.setCuser(cuser);
                //operation 操作类型(add:添加 modify:修改 delete:删除:)
                loginfo.setOperation("add");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(count);

                String msgStr = warehouseProductService.outStockCount(outObject, count, loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    throw new Exception(msgStr);
                } else {
                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - count.doubleValue());
                    productService.updateStockCount(product, prodStockCount, cuser, "out");
                }
            }
        }
    }

    //com.xy.vmes.deecoop.warehouse.dao.WarehouseToWarehouseProductMapper.findWarehouseToWarehouseProductByProduct() -- 查询结果集
    private BigDecimal findProductStockCount(List<Map> warehouseProductMapList) {
        BigDecimal productStockCount = BigDecimal.valueOf(0D);
        if (warehouseProductMapList == null || warehouseProductMapList.size() == 0) {return productStockCount;}

        for (Map<String, Object> mapObject : warehouseProductMapList) {
            if (mapObject.get("stockCount") != null) {
                BigDecimal stockCount = (BigDecimal)mapObject.get("stockCount");
                productStockCount = BigDecimal.valueOf(productStockCount.doubleValue() + stockCount.doubleValue());
            }
        }

        //四舍五入到2位小数
        productStockCount = productStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        return productStockCount;
    }

}



