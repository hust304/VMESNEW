package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInExecuteMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_execute:仓库入库执行明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInExecuteServiceImp implements WarehouseInExecuteService {


    @Autowired
    private WarehouseInExecuteMapper warehouseInExecuteMapper;
    @Autowired
    private WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private TaskService taskService;


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setCdate(new Date());
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.insert(warehouseInExecute);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateAllColumnById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> dataList(PageData pd) throws Exception{
        return warehouseInExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseInExecute> warehouseInExecuteList =  warehouseInExecuteMapper.selectByMap(columnMap);
        return warehouseInExecuteList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateIsdisableByExecute(String detailId, String isdisable) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return;}
        if (isdisable == null || isdisable.trim().length() == 0) {return;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("isdisable", isdisable);
        warehouseInExecuteMapper.updateIsdisableByExecute(findMap);
    }

    /**
     * 获取入库执行明细列表(修改入库执行)
     * @param pd
     * @return
     */
    public List<Map> findListWarehouseInExecuteByEdit(PageData pd) throws Exception {
        return warehouseInExecuteMapper.findListWarehouseInExecuteByEdit(pd);
    }

    public List<Map<String, Object>> findSumcountByWarehouseInExecute(PageData object) {
        if (object == null) {return null;}
        return warehouseInExecuteMapper.findSumcountByWarehouseInExecute(object);
    }

    public Map<String, BigDecimal> findExecuteCountByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        Map<String, BigDecimal> mapObject = new HashMap<String, BigDecimal>();
        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        List<Map<String, Object>> mapList = this.findSumcountByWarehouseInExecute(findMap);
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> mapObj : mapList) {
                String detailId = (String)mapObj.get("detailId");
                BigDecimal count = (BigDecimal)mapObj.get("executeCount");
                if (detailId != null && count != null) {
                    mapObject.put(detailId, count);
                }
            }
        }

        return mapObject;
    }

    public WarehouseInExecute findWarehouseInExecute(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = this.findWarehouseInExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInExecute findWarehouseInExecuteById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecute(findMap);}

    public List<WarehouseInExecute> findWarehouseInExecuteList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = new ArrayList<WarehouseInExecute>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<WarehouseInExecute> findWarehouseInExecuteListByDetailId(String detailId) {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecuteList(findMap);
    }

    public List<WarehouseInExecute> mapList2ExecuteList(List<Map<String, String>> mapList, List<WarehouseInExecute> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInExecute>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInExecute execute = (WarehouseInExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseInExecute());
            objectList.add(execute);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////
//    public BigDecimal findSumCountByExecuteList(List<WarehouseInExecute> objectList) {
//        double sumCount = 0D;
//        if (objectList != null && objectList.size() > 0) {
//            for (WarehouseInExecute object : objectList) {
//                if (object.getCount() != null) {
//                    sumCount = sumCount + object.getCount().doubleValue();
//                }
//            }
//        }
//
//        //四舍五入 2位小数
//        return BigDecimal.valueOf(sumCount).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//    }

    public String checkColumnExecuteList(List<WarehouseInExecute> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}
        String column_isnull = "第 {0} 行: {1}为空或{2}为空，({1},{2})为必填不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            WarehouseInExecute object = objectList.get(i);
            if ((object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0)
                || object.getCount() == null
            ) {
                String str_isnull = MessageFormat.format(column_isnull,
                        Integer.valueOf(i+1).toString(),
                        "实际货位ID",
                        "入库数量");
                msgBuf.append(str_isnull);
            }
        }

        return msgBuf.toString();
    }

    @Override
    public ResultModel batchAddWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String executeJsonStr = pageData.getString("executeJsonStr");
        if (executeJsonStr == null || executeJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一条入库数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(executeJsonStr);
        if(mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细执行 Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库执行验证 入库单明细数量 (入库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        StringBuffer msgBuf = new StringBuffer();
        for (Map<String, Object> warehouseInDetailMap : mapList) {
            String parentId = (String)warehouseInDetailMap.get("parentId");
            String productCode = (String)warehouseInDetailMap.get("productCode");
            String productName = (String)warehouseInDetailMap.get("productName");

            String detailId = (String)warehouseInDetailMap.get("id");
            BigDecimal count_big = BigDecimal.valueOf(0D);
            String count = (String)warehouseInDetailMap.get("count");
            if (count != null && count.trim().length() > 0) {
                try {
                    count_big = new BigDecimal(count);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, BigDecimal> inDtlCountMap = this.findExecuteCountByParentId(parentId);
            BigDecimal executeCount = BigDecimal.valueOf(0D);
            if (inDtlCountMap.get(detailId) != null) {
                executeCount = inDtlCountMap.get(detailId);
            }
            Object executeObj = warehouseInDetailMap.get("children");
            if (executeObj == null) {continue;}

            List executeList = (List)executeObj;
            if (executeList == null || executeList.size() == 0) {continue;}

            for (int i = 0; i < executeList.size(); i++) {
                Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);
                //入库数量 count
                BigDecimal now_count_big = BigDecimal.valueOf(0D);
                String now_count = (String)executeMap.get("count");
                if (now_count != null && now_count.trim().length() > 0) {
                    try {
                        now_count_big = new BigDecimal(now_count);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                String msgTemp = "货品编码({0})货品名称({1}) 入库执行冲突，入库数量({2}) 已执行({3}) 当前需要执行({4})" + Common.SYS_ENDLINE_DEFAULT;
                if (count_big.doubleValue() < (executeCount.doubleValue() + now_count_big.doubleValue())) {
                    String msgStr = MessageFormat.format(msgTemp,
                            productCode,
                            productName,
                            count.toString(),
                            executeCount.toString(),
                            now_count);
                    msgBuf.append(msgStr);
                }
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //2. 入库执行
        msgBuf = new StringBuffer();
        try {
            for (Map<String, Object> warehouseInDetailMap : mapList) {
                Object executeObj = warehouseInDetailMap.get("children");
                if (executeObj == null) {continue;}

                List executeList = (List)executeObj;
                if (executeList == null || executeList.size() == 0) {continue;}

                //入库单明细 warehouseInDetailMap
                //界面上 model_code := 'warehouseInDetail' 中获得
                String parentId = (String)warehouseInDetailMap.get("parentId");
                String productId = (String)warehouseInDetailMap.get("productId");
                String detailId = (String)warehouseInDetailMap.get("id");
                //批次号
                String code = (String)warehouseInDetailMap.get("code");

                //入库执行明细 executeMap
                // 界面上 model_code := 'warehouseInExecutorByAddExecute' 中获得
                for (int i = 0; i < executeList.size(); i++) {
                    Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);
                    //入库货位id warehouseId
                    String warehouseId = (String)executeMap.get("warehouseId");
                    //入库数量 count
                    String count = (String)executeMap.get("count");

                    BigDecimal count_Big = BigDecimal.valueOf(0D);
                    if (count != null && count.trim().length() > 0) {
                        try {
                            count_Big = new BigDecimal(count);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    //入库操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //货位批次号
                    inObject.setCode(code);
                    //产品ID
                    inObject.setProductId(productId);
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseId);

                    //库存变更日志
                    String executeId = Conv.createUuid();

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
                    loginfo.setAfterCount(count_Big);

                    String msgStr = warehouseProductService.inStockCount(inObject, count_Big, loginfo);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                    } else {
                        WarehouseInExecute execute = new WarehouseInExecute();
                        execute.setId(executeId);
                        execute.setDetailId(detailId);
                        execute.setWarehouseId(warehouseId);
                        execute.setExecutorId(cuser);
                        execute.setCount(count_Big);
                        execute.setCuser(cuser);
                        this.save(execute);

                        Product product = productService.findProductById(productId);
                        BigDecimal prodCount = BigDecimal.valueOf(0D);
                        if (product.getStockCount() != null) {
                            prodCount = product.getStockCount();
                        }

                        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count_Big.doubleValue());
                        productService.updateStockCount(product, prodStockCount, cuser);
                    }
                }

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
//                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//                warehouseInDetailService.updateStateWarehouseInDetail(detailList);


                WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
                Task task = taskService.findTaskByBusinessId(detailId);

                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                columnMap.put("isdisable","1");
                BigDecimal totalCount = BigDecimal.ZERO;
                List<WarehouseInExecute> warehouseInExecuteList = this.selectByColumnMap(columnMap);
                if(warehouseInExecuteList!=null&&warehouseInExecuteList.size()>0){
                    for(int i=0;i<warehouseInExecuteList.size();i++){
                        WarehouseInExecute warehouseInExecute = warehouseInExecuteList.get(i);
                        if(warehouseInExecute!=null&&warehouseInExecute.getCount()!=null){
                            totalCount = totalCount.add(warehouseInExecute.getCount());
                        }
                    }
                }
                Map countResult = new HashMap();
                //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                if(detail.getCount().compareTo(totalCount)>0){
                    //执行状态(0:待执行 1:已完成 -1:已取消)
                    task.setState("0");
                    detail.setState("1");
                    countResult.put("unCompleteCount",(detail.getCount().subtract(totalCount).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
                }else {
                    //执行状态(0:待执行 1:已完成 -1:已取消)
                    task.setState("1");
                    detail.setState("2");
                    countResult.put("unCompleteCount",0.00);
                }
                model.putResult(countResult);
                warehouseInDetailService.update(detail);
                taskService.update(task);
                warehouseInService.updateState(detail.getParentId());
            }

        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串");
            return model;
        }
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串");
            return model;
        }
        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串");
            return model;
        }
        String code = pageData.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串");
            return model;
        }

        //入库数量 count
        String count = pageData.getString("count");
        BigDecimal countBig = BigDecimal.valueOf(0D);
        if (count == null || count.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库数量为空或空字符串！");
            return model;
        } else {
            try {
                BigDecimal doubleBig = new BigDecimal(count);
                if (doubleBig.doubleValue() < 0) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                    return model;
                }
                countBig = doubleBig;
            } catch (NumberFormatException numberExc) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                return model;
            }
        }

        //当前入库单明细 信息
        PageData findMap = new PageData();
        findMap.put("detailId", detailId);

        Map inDtlMap = null;
        List<Map> inDtlList = warehouseInDetailService.getDataListPage(findMap, null);
        if (inDtlList != null && inDtlList.size() > 0) {
            inDtlMap = inDtlList.get(0);
        }

        //入库执行验证 入库单明细数量 (入库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        if (inDtlMap != null) {
            //productCode 货品编码
            String productCode = new String();
            if (inDtlMap.get("productCode") != null) {
                productCode = inDtlMap.get("productCode").toString().trim();
            }

            //productName 货品名称
            String productName = new String();
            if (inDtlMap.get("productName") != null) {
                productName = inDtlMap.get("productName").toString().trim();
            }

            //count 入库数量
            BigDecimal dtl_count = BigDecimal.valueOf(0D);
            if (inDtlMap.get("count") != null) {
                dtl_count = (BigDecimal)inDtlMap.get("count");
            }
            //executeCount 已完成数量
            BigDecimal executeCount = BigDecimal.valueOf(0D);
            if (inDtlMap.get("executeCount") != null) {
                executeCount = (BigDecimal)inDtlMap.get("executeCount");
            }

            String msgTemp = "货品编码({0})货品名称({1}) 入库执行冲突，入库数量({2}) 已执行({3}) 当前需要执行({4})" + Common.SYS_ENDLINE_DEFAULT;
            if (dtl_count.doubleValue() < (executeCount.doubleValue() + countBig.doubleValue())) {
                String msgStr = MessageFormat.format(msgTemp,
                        productCode,
                        productName,
                        dtl_count.toString(),
                        executeCount.toString(),
                        countBig.toString());

                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            //入库操作
            WarehouseProduct inObject = new WarehouseProduct();
            //货位批次号
            inObject.setCode(code);
            //产品ID
            inObject.setProductId(productId);
            //(实际)货位ID
            inObject.setWarehouseId(warehouseId);

            //库存变更日志
            String executeId = Conv.createUuid();

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
            loginfo.setAfterCount(countBig);

            String msgStr = warehouseProductService.inStockCount(inObject, countBig, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                msgBuf.append( "入库操作失败:" + msgStr);
            } else {
                WarehouseInExecute execute = new WarehouseInExecute();
                execute.setId(executeId);
                execute.setDetailId(detailId);
                execute.setWarehouseId(warehouseId);
                execute.setExecutorId(cuser);
                execute.setCount(countBig);
                execute.setCuser(cuser);
                this.save(execute);

                Product product = productService.findProductById(productId);
                BigDecimal prodCount = BigDecimal.valueOf(0D);
                if (product.getStockCount() != null) {
                    prodCount = product.getStockCount();
                }

                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + countBig.doubleValue());
                productService.updateStockCount(product, prodStockCount, cuser);

                //2. 修改修改当前入库单明细状态--同时反写入库单状态

                WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                columnMap.put("isdisable","1");
                BigDecimal totalCount = BigDecimal.ZERO;
                List<WarehouseInExecute> warehouseInExecuteList = this.selectByColumnMap(columnMap);
                if(warehouseInExecuteList!=null&&warehouseInExecuteList.size()>0){
                    for(int i=0;i<warehouseInExecuteList.size();i++){
                        WarehouseInExecute warehouseInExecute = warehouseInExecuteList.get(i);
                        if(warehouseInExecute!=null&&warehouseInExecute.getCount()!=null){
                            totalCount = totalCount.add(warehouseInExecute.getCount());
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
                warehouseInDetailService.update(detail);
                warehouseInService.updateState(detail.getParentId());




//                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//                warehouseInDetailService.updateStateWarehouseInDetail(detailList);

            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }
        return model;
    }

    @Override
    public ResultModel rebackWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("rebackRemark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        Task task = taskService.findTaskByBusinessId(detailId);

        //根据入库单明细id-获取该入库单明细中-所有入库执行List
        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("executorId", cuser);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseInExecute> executeList = this.findWarehouseInExecuteList(findMap);
        List<WarehouseInExecutor> executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);

        if (executorList == null || executorList.size() == 0) {return model;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            //A. 入库执行明细-库存数量退回
            for (int i = 0; i < executeList.size(); i++) {
                WarehouseInExecute execute = executeList.get(i);

                //入库数量 count
                if (execute.getCount() == null) {continue;}

                //入库操作
                WarehouseProduct inObject = new WarehouseProduct();
                //货位批次号
                inObject.setCode(detail.getCode());
                //产品ID
                inObject.setProductId(detail.getProductId());
                //(实际)货位ID
                inObject.setWarehouseId(execute.getWarehouseId());

                //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                double count = -1 * execute.getCount().doubleValue();

                //库存变更日志
                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(detail.getParentId());
                loginfo.setDetailId(detail.getId());
                loginfo.setExecuteId(execute.getId());

                loginfo.setCompanyId(companyId);
                loginfo.setCuser(cuser);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                loginfo.setOperation("reback");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(execute.getCount());
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(BigDecimal.valueOf(execute.getCount().doubleValue() + count));

                //(修改库存数量)退回已经入库数量
                String msgStr = warehouseProductService.inStockCount(inObject, BigDecimal.valueOf(count), loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                }
            }

            if (msgBuf.toString().trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgBuf.toString());
                return model;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strTemp = " 退单原因:{0} 操作时间：{1} ";
                String remarkStr = MessageFormat.format(strTemp, remark, dateFormat.format(new Date()));

                //B. 修改入库执行表 vmes_warehouse_in_execute
                for (WarehouseInExecute execute : executeList) {
                    //isdisable: 是否启用(0:已禁用 1:启用)
                    execute.setIsdisable("0");

                    if (execute.getRemark() == null) {
                        execute.setRemark(remarkStr);
                    } else {
                        execute.setRemark(execute.getRemark() + remarkStr);
                    }
                    this.update(execute);

                    //产品ID
                    String productId = detail.getProductId();
                    //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                    double count = -1 * execute.getCount().doubleValue();

                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count);
                    productService.updateStockCount(product, prodStockCount, cuser);
                }

                //C. 入库明细执行人 vmes_warehouse_in_executor
                if (executorList != null && executorList.size() > 0) {
                    for (WarehouseInExecutor executor : executorList) {
                        //isdisable: 是否启用(0:已禁用 1:启用)
                        executor.setIsdisable("0");

                        if (executor.getRemark() == null) {
                            executor.setRemark(remarkStr);
                        } else {
                            executor.setRemark(executor.getRemark() + remarkStr);
                        }

                        warehouseInExecutorService.update(executor);
                    }
                }

                //D. 修改入库单明细状态
                findMap = new PageData();
                findMap.put("detailId", detailId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);
                if (executorList != null && executorList.size() > 0) {
                    //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                }else {
                    detail.setState("0");
                }
                if (detail.getRemark() == null) {
                    detail.setRemark(remarkStr);
                } else {
                    detail.setRemark(detail.getRemark() + remarkStr);
                }
                warehouseInDetailService.update(detail);

                //执行状态(0:待执行 1:已完成 -1:已取消)
                task.setState("-1");
                task.setRemark(remarkStr);
                taskService.update(task);

                //E. 修改修改当前入库单明细状态--同时反写入库单状态
                WarehouseIn parent = new WarehouseIn();
                parent.setId(detail.getParentId());
                //入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消) --忽视明细状态(-1:已取消)
                warehouseInDetailService.updateParentStateByDetailList(parent, null, null);
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

    ///////////////////////////////////////////////////////////////////////////////

    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap, String companyId) throws Exception {
        String productId = (String)firstRowMap.get("productId");
        String detailId = (String)firstRowMap.get("id");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("productId", productId);
        findMap.put("companyId", companyId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = this.findListWarehouseInExecuteByEdit(findMap);
        if(varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)secondTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("pid",firstRowMap.get("id").toString());
                secondMapList.add(varMap);

            }
        }

        return secondMapList;
    }

    @Override
    public ResultModel findListWarehouseInExecuteByEdit(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String firstFieldCode = pd.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }

        Map<String, Object> firstTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        result.put("hideTitles",firstTitleMap.get("hideTitles"));
        result.put("titles",firstTitleMap.get("titles"));

        //B. 第二级: 获取入库单明细执行人Title列表
        columnList = columnService.findColumnList("warehouseInExecuteByEdit");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String secondFieldCode = pd.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }

        Map<String, Object> secondTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //C. 查询第一层数据
        String companyId = pd.getString("currentCompanyId");

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)firstTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("hideTitles", secondTitleMap.get("hideTitles"));
                varMap.put("titles", secondTitleMap.get("titles"));
                varMap.put("pid", null);
                //查询第二层数据
                varMap.put("children", this.findSecondList(map, secondTitleMap ,companyId));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel updateWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String id = pageData.getString("id");
        String beforeCount = pageData.getString("beforeCount");
        String afterCount = pageData.getString("afterCount");

        if (beforeCount == null || beforeCount.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("调整前入库数量为空或空字符串");
            return model;
        }

        if (afterCount == null || afterCount.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("调整后入库数量为空或空字符串");
            return model;
        } else {
            try {
                new BigDecimal(afterCount);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                model.putCode(Integer.valueOf(1));
                model.putMsg("数据输入错误:调整后入库数量("+afterCount+") 请输入大于0的整数或(1,2)位小数！");
                return model;
            }
        }

        WarehouseInExecute execute = this.findWarehouseInExecuteById(id);
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(execute.getDetailId());
        Task task = taskService.findTaskByBusinessId(execute.getDetailId());

        try {
            //A. 修改库存数量
            BigDecimal before = BigDecimal.valueOf(Double.parseDouble(beforeCount));
            BigDecimal after = BigDecimal.valueOf(Double.parseDouble(afterCount));

            WarehouseProduct warehouseProduct = new WarehouseProduct();
            warehouseProduct.setProductId(detail.getProductId());
            warehouseProduct.setCode(detail.getCode());
            warehouseProduct.setWarehouseId(execute.getWarehouseId());

            BigDecimal count = BigDecimal.valueOf(after.doubleValue() - before.doubleValue());

            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId(detail.getParentId());
            loginfo.setDetailId(detail.getId());
            loginfo.setExecuteId(execute.getId());

            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("modify");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(before);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(after);

            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //产品ID
            String productId = detail.getProductId();
            Product product = productService.findProductById(productId);

            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
            productService.updateStockCount(product, prodStockCount, cuser);

            //B. 修改入库执行明细
            execute.setCount(after);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (execute.getRemark() == null) {
                execute.setRemark("操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            } else {
                execute.setRemark(execute.getRemark()+"  操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }
            this.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
//            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

//            WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

            Map columnMap = new HashMap();
            columnMap.put("detail_id",detail.getId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseInExecute> warehouseInExecuteList = this.selectByColumnMap(columnMap);
            if(warehouseInExecuteList!=null&&warehouseInExecuteList.size()>0){
                for(int i=0;i<warehouseInExecuteList.size();i++){
                    WarehouseInExecute warehouseInExecute = warehouseInExecuteList.get(i);
                    if(warehouseInExecute!=null&&warehouseInExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseInExecute.getCount());
                    }
                }
            }
            Map countResult = new HashMap();
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if(detail.getCount().compareTo(totalCount)>0){
                //执行状态(0:待执行 1:已完成 -1:已取消)
                task.setState("0");
                detail.setState("1");
                countResult.put("unCompleteCount",(detail.getCount().subtract(totalCount).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
            }else {
                //执行状态(0:待执行 1:已完成 -1:已取消)
                task.setState("1");
                detail.setState("2");
                countResult.put("unCompleteCount",0.00);
            }
            model.putResult(countResult);
            taskService.update(task);
            warehouseInDetailService.update(detail);
            warehouseInService.updateState(detail.getParentId());



        } catch (TableVersionException tabExc) {
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }
        return model;
    }


    @Override
    public ResultModel deleteWarehouseInExecute(PageData pageData) throws Exception {

        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        String id = pageData.getString("id");

        WarehouseInExecute execute = this.findWarehouseInExecuteById(id);
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(execute.getDetailId());

        try {
            //A. 修改库存数量
            BigDecimal executeCountount = execute.getCount();

            WarehouseProduct warehouseProduct = new WarehouseProduct();
            warehouseProduct.setProductId(detail.getProductId());
            warehouseProduct.setCode(detail.getCode());
            warehouseProduct.setWarehouseId(execute.getWarehouseId());

            BigDecimal count = BigDecimal.valueOf(-1 * executeCountount.doubleValue());

            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId(detail.getParentId());
            loginfo.setDetailId(detail.getId());
            loginfo.setExecuteId(execute.getId());

            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("delete");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(executeCountount);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(BigDecimal.valueOf(executeCountount.doubleValue() + count.doubleValue()));

            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //产品ID
            String productId = detail.getProductId();
            Product product = productService.findProductById(productId);

            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
            productService.updateStockCount(product, prodStockCount, cuser);

            //B. 修改入库执行明细
            //是否启用(0:已禁用 1:启用)
            execute.setIsdisable("0");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (execute.getRemark() == null) {
                execute.setRemark("操作记录：删除  操作时间："+ dateFormat.format(new Date()));
            } else {
                execute.setRemark(execute.getRemark()+"  操作记录：删除  操作时间："+ dateFormat.format(new Date()));
            }
            this.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
//            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//            warehouseInDetailService.updateStateWarehouseInDetail(detailList);


//            WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

            Map columnMap = new HashMap();
            columnMap.put("detail_id",detail.getId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseInExecute> warehouseInExecuteList = this.selectByColumnMap(columnMap);
            if(warehouseInExecuteList!=null&&warehouseInExecuteList.size()>0){
                for(int i=0;i<warehouseInExecuteList.size();i++){
                    WarehouseInExecute warehouseInExecute = warehouseInExecuteList.get(i);
                    if(warehouseInExecute!=null&&warehouseInExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseInExecute.getCount());
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
            warehouseInDetailService.update(detail);
            warehouseInService.updateState(detail.getParentId());


        } catch (TableVersionException tabExc) {
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }
        return model;
    }


    @Override
    public ResultModel updateCancelWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        //根据当前入库单id-获取当前入库单明细id-入库执行数量汇总
        Map<String, BigDecimal> mapExecute = this.findExecuteCountByParentId(parentId);
        //判断当前入库单明细-货品是否部分入库
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseInDetail detail : detailList) {
                String dtl_id = detail.getId();
                if (mapExecute != null && mapExecute.get(dtl_id) != null && mapExecute.get(dtl_id).doubleValue() != 0D) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("入库单明细货品已经部分入库，该入库单不可整单(退单)，请核对后再次操作！");
                    return model;
                }
            }
        }

        //1. 修改入库单明细状态
        PageData mapData = new PageData();
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapData.put("state", "0");
        mapData.put("parentId", parentId);
        warehouseInDetailService.updateStateByDetail(mapData);

        //2.修改入库单状态
        WarehouseIn warehouseIn = new WarehouseIn();
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setRemark(remark);
        warehouseInService.update(warehouseIn);
        return model;
    }
}



