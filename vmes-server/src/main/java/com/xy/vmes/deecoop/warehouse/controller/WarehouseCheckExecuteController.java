package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecuteController.class);

    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
    @Autowired
    private WarehouseCheckExecuteService warehouseCheckExecuteService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;

    /**
     * 获取盘点执行列表-(盘点审核列表)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/findListByWarehouseCheckExecute")
    public ResultModel findListByWarehouseCheckExecute() throws Exception {
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecuteByAudit");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
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

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckExecuteService.findListWarehouseCheckExecuteByAudit(pd, pg);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/addWarehouseCheckExecute")
    @Transactional
    public ResultModel addWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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
            WarehouseCheckExecute execute = (WarehouseCheckExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            if (execute.getCount() == null) {execute.setCount(BigDecimal.valueOf(0D));}
            execute.setExecutorId(cuser);
            execute.setCuser(cuser);
            //state:状态(0:待审核 2:同意 3:不同意)
            execute.setState("0");
            warehouseCheckExecuteService.save(execute);

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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)退回盘点明细(退回单个盘点明细)
     * 1. 填写退回原因
     * 2. 盘点明细必须是(1:执行中)-允许退回
     * 3. 退回成功后盘点明细状态(0:待派单)
     * 4. 修改盘点明细执行人表(vmes_warehouse_check_executor.isdisable)状态
     *
     * rebackDetailJsonStr
     * {id:"",parentId:"",state:""}
     *
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/rebackWarehouseCheckByDetail")
    @Transactional
    public ResultModel rebackWarehouseCheckByDetail() throws Exception {
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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

        Map<String, String> parentMap = new HashMap<String, String>();
        for (WarehouseCheckDetail detail : detailList) {
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("0");
            warehouseCheckDetailService.update(detail);

            //isdisable: 是否启用(0:已禁用 1:启用)
            warehouseCheckExecutorService.updateIsdisableByExecutor("0",
                    remark,
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回盘点明细(撤回单个盘点明细)
     * 1. 盘点明细必须是(2:审核中)- and 无审批记录 - 允许撤回条件(盘点明细已经提交审核 and 无审批记录)
     * 2. 删除盘点明细执行表
     * 3. 退回成功后盘点明细状态(1:执行中)
     *
     * cancelAuditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/cancelAuditWarehouseCheckByExecute")
    @Transactional
    public ResultModel cancelAuditWarehouseCheckByExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/cancelAuditWarehouseCheckByExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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
            warehouseCheckExecuteService.deleteById(execute.getId());

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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/rebackWarehouseCheckByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    ///////////////////////////////////////////////////////////////////
    /**
     * 审核同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/auditPassWarehouseCheckExecute")
    @Transactional
    public ResultModel auditPassWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/auditPassWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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

                    //(修改库存数量)退回已经入库数量
                    warehouseProductService.inStockCount(inObject, BigDecimal.valueOf(modifyCount), cuser, companyId);

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
            warehouseCheckExecuteService.update(execute);

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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/auditPassWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute")
    @Transactional
    public ResultModel auditDisagreeWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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
            warehouseCheckExecuteService.update(execute);

            //修改盘点明细状态
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/auditDisagreeWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
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
            List<WarehouseCheckExecute> executeList = warehouseCheckExecuteService.findWarehouseCheckExecuteList(findMap);
            if (executeList != null && executeList.size() > 0) {
                String msgStr = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }


}



