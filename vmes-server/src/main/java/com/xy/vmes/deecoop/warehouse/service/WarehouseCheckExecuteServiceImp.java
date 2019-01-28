package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckExecuteMapper;
import com.xy.vmes.entity.*;
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
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckExecuteServiceImp implements WarehouseCheckExecuteService {


    @Autowired
    private WarehouseCheckExecuteMapper warehouseCheckExecuteMapper;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheckExecute object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckExecute selectById(String id) throws Exception{
        return warehouseCheckExecuteMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckExecute> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckExecute> warehouseCheckDetailList =  warehouseCheckExecuteMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckExecuteMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckExecuteMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckExecuteMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<WarehouseCheckExecute> dataList(PageData pd) throws Exception {
        return warehouseCheckExecuteMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.getDataListPage(pd, pg);
    }
    public List<Map> findListWarehouseCheckExecuteByAudit(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.findListWarehouseCheckExecuteByAudit(pd, pg);
    }

    public WarehouseCheckExecute findWarehouseCheckExecute(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckExecute> objectList = this.findWarehouseCheckExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseCheckExecute findWarehouseCheckExecuteById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecute(findMap);
    }

    public List<WarehouseCheckExecute> findWarehouseCheckExecuteList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }
    public List<WarehouseCheckExecute> findWarehouseCheckExecuteListByDetailId(String detailId) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecuteList(findMap);
    }

    @Override
    public ResultModel addWarehouseCheckExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String addExecuteJsonStr = pageData.getString("addExecuteJsonStr");
        if (addExecuteJsonStr == null || addExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(addExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细执行 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            if (execute.getCount() == null) {execute.setCount(BigDecimal.valueOf(0D));}
            execute.setExecutorId(cuser);
            execute.setCuser(cuser);
            //state:状态(0:待审核 2:同意 3:不同意)
            execute.setState("0");
            this.save(execute);

            //修改盘点明细状态
            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(execute.getDetailId());
            detail.setState("2");
            warehouseCheckDetailService.update(detail);
            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
        return model;
    }

    @Override
    public ResultModel rebackWarehouseCheckByDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String rebackDetailJsonStr = pageData.getString("rebackDetailJsonStr");

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        if (rebackDetailJsonStr == null || rebackDetailJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(rebackDetailJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细退单 Json字符串-转换成List错误！");
            return model;
        }

        List<WarehouseCheckDetail> detailList = new ArrayList<WarehouseCheckDetail>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckDetail detail = (WarehouseCheckDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckDetail());
            detailList.add(detail);
        }

        String msgStr = this.checkStateByDetailList(detailList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        this.rebackWarehouseCheck(detailList,remark,cuser);

        return model;
    }
    @Override
    public void rebackWarehouseCheck(List<WarehouseCheckDetail> detailList,String rebackBillReason,String cuser) throws Exception {

        Map<String, String> parentMap = new HashMap<String, String>();
        for (WarehouseCheckDetail detail : detailList) {
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setRemark(rebackBillReason);
            warehouseCheckDetailService.update(detail);

            //isdisable: 是否启用(0:已禁用 1:启用)
            warehouseCheckExecutorService.updateIsdisableByExecutor("0",
                    rebackBillReason,
                    null,
                    detail.getId(),
                    cuser);

            parentMap.put(detail.getParentId(), detail.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
    }


    private String checkStateByDetailList(List<WarehouseCheckDetail> detailList) {
        StringBuffer msgBuf = new StringBuffer();
        if (detailList == null || detailList.size() == 0) {return msgBuf.toString();}

        String msgTemp = "第 {0} 行: 盘点明细状态({1})，盘点明细状态必须是(执行中)允许退回！" + Common.SYS_ENDLINE_DEFAULT;
        for (int i = 0; i < detailList.size(); i++) {
            WarehouseCheckDetail detail = detailList.get(i);
            //明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            if ("2,3".indexOf(detail.getState()) != -1) {
                String msgStr = MessageFormat.format(msgTemp,
                        (i+1),
                        Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detail.getState()));
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }

    @Override
    public ResultModel findListByWarehouseCheckExecute(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecuteByAudit");
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

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
            for (Column column : columnList) {
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        pd.put("orderStr", "checkExecute.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findListWarehouseCheckExecuteByAudit(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    //1. 盘点明细必须是(2:审核中)
    private String checkDetailStateByExecuteMapList(List<Map<String, Object>> mapList) {
        StringBuffer msgBuf = new StringBuffer();
        if (mapList == null || mapList.size() == 0) {return msgBuf.toString();}

        String msgTemp = "第 {0} 行: 盘点明细状态({1})，{2}无需(撤回)操作！" + Common.SYS_ENDLINE_DEFAULT;
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, Object> mapObject = mapList.get(i);
            //{id:"",parentId:"",detailId:"",state:"":detailState:""}
            //明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)

            String detailState = (String)mapObject.get("detailState");
            if ("0,1".indexOf(detailState) != -1) {
                String msgStr = MessageFormat.format(msgTemp,
                        (i+1),
                        Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detailState),
                        "没有进行盘点操作");
                msgBuf.append(msgStr);
            } else if ("3,-1".indexOf(detailState) != -1) {
                String msgStr = MessageFormat.format(msgTemp,
                        (i+1),
                        Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detailState),
                        "");
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }

    /**
     * 验证盘点明细id(vmes_warehouse_check_execute)审核记录
     * @param mapList
     * @return
     */
    private String checkAuditHistoryByByExecuteMapList(List<Map<String, Object>> mapList) throws Exception {
        StringBuffer msgBuf = new StringBuffer();
        if (mapList == null || mapList.size() == 0) {return msgBuf.toString();}

        String msgTemp = "第 {0} 行: 盘点明细状态(审核中)，审核状态(不同意)不可撤回操作！" + Common.SYS_ENDLINE_DEFAULT;
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, Object> mapObject = mapList.get(i);

            //{id:"",parentId:"",detailId:"",state:"":detailState:""}
            String detailId = (String)mapObject.get("detailId");

            PageData findMap = new PageData();
            findMap.put("detailId", detailId);
            //state:状态(0:待审核 2:同意 3:不同意)
            findMap.put("state", "3");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<WarehouseCheckExecute> executeList = this.findWarehouseCheckExecuteList(findMap);
            if (executeList != null && executeList.size() > 0) {
                String msgStr = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }

    @Override
    public ResultModel cancelAuditWarehouseCheckByExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String cancelAuditExecuteJsonStr = pageData.getString("cancelAuditExecuteJsonStr");

        if (cancelAuditExecuteJsonStr == null || cancelAuditExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(cancelAuditExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细撤回 Json字符串-转换成List错误！");
            return model;
        }

        //盘点明细必须是(2:审核中)
        String msgStr = this.checkDetailStateByExecuteMapList(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }
        //验证盘点明细id(vmes_warehouse_check_execute)审核记录
        msgStr = this.checkAuditHistoryByByExecuteMapList(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        //{id:"",parentId:"",detailId:"",state:"":detailState:""}
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            this.deleteById(execute.getId());

            WarehouseCheckDetail detail = new WarehouseCheckDetail();
            detail.setId(execute.getDetailId());
            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("1");
            warehouseCheckDetailService.update(detail);

            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
        return model;
    }

    @Override
    public ResultModel auditPassWarehouseCheckExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        String auditExecuteJsonStr = pageData.getString("auditExecuteJsonStr");

        if (auditExecuteJsonStr == null || auditExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(auditExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细审核 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            String executeId = (String)mapObject.get("id");
            String parentId = (String)mapObject.get("parentId");
            String detailId = (String)mapObject.get("detailId");

            //stockCount 台账数量
            String stockCountStr = (String)mapObject.get("stockCount");
            BigDecimal stockCount_big = BigDecimal.valueOf(0D);
            if (stockCountStr != null && stockCountStr.trim().length() > 0) {
                try {
                    stockCount_big = new BigDecimal(stockCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //count 盘点数量
            String countStr = (String)mapObject.get("count");
            BigDecimal count_big = BigDecimal.valueOf(0D);
            if (countStr != null && countStr.trim().length() > 0) {
                try {
                    count_big = new BigDecimal(countStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            String code = (String)mapObject.get("code");
            String productId = (String)mapObject.get("productId");
            String warehouseId = (String)mapObject.get("warehouseId");

            //(count 盘点数量)after - (stockCount 台账数量)before
            double modifyCount = count_big.doubleValue() - stockCount_big.doubleValue();
            if (modifyCount != 0) {
                if (code != null && code.trim().length() > 0
                        && productId != null && productId.trim().length() > 0
                        && warehouseId != null && warehouseId.trim().length() > 0
                        ) {
                    //A. 变更库存数量
                    //入库操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //货位批次号
                    inObject.setCode(code);
                    //产品ID
                    inObject.setProductId(productId);
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseId);

                    //库存变更日志
                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setParentId(parentId);
                    loginfo.setDetailId(detailId);
                    loginfo.setExecuteId(executeId);
                    loginfo.setCompanyId(companyId);
                    loginfo.setCuser(cuser);
                    //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:盘点审核)
                    loginfo.setOperation("checkAudit");

                    //beforeCount 操作变更前数量(业务相关)-(stockCount 台账数量)
                    loginfo.setBeforeCount(stockCount_big);
                    //afterCount 操作变更后数量(业务相关)-(count 盘点数量)
                    loginfo.setAfterCount(count_big);

                    //(修改库存数量)
                    warehouseProductService.checkStockCount(inObject, BigDecimal.valueOf(modifyCount), loginfo);

                    //B. 修改产品数量
                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount);
                    productService.updateStockCount(product, prodStockCount, cuser);
                }
            }

            WarehouseCheckExecute execute = (WarehouseCheckExecute) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            //状态(0:待审核 2:同意 3:不同意)
            execute.setState("2");
            execute.setAuditId(cuser);
            this.update(execute);

            //修改盘点明细状态
            WarehouseCheckDetail detail = new WarehouseCheckDetail();
            detail.setId(execute.getDetailId());
            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("3");
            warehouseCheckDetailService.update(detail);

            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
        return model;
    }


    @Override
    public ResultModel auditDisagreeWarehouseCheckExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("审核意见为空或空字符串，审核意见为必填不可为空！");
            return model;
        }

        String auditExecuteJsonStr = pageData.getString("auditExecuteJsonStr");
        if (auditExecuteJsonStr == null || auditExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(auditExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细审核 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            //状态(0:待审核 2:同意 3:不同意)
            execute.setState("3");
            execute.setAuditId(cuser);
            execute.setRemark(remark);
            //是否启用(0:已禁用 1:启用)
            execute.setIsdisable("0");
            this.update(execute);

            //修改盘点明细状态
            WarehouseCheckDetail detail = new WarehouseCheckDetail();
            detail.setId(execute.getDetailId());
            detail.setRemark(remark);
            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("1");
            warehouseCheckDetailService.update(detail);

            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
        return model;
    }
}



