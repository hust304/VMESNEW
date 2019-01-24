package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：入库派单明细执行
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDispatchController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;

    /**
     * (入库管理-任务列表)获取入库单执行列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/findListWarehouseInExecuteByEdit")
    public ResultModel findListWarehouseInExecuteByEdit() throws Exception {
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
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
        Pagination pg = HttpUtils.parsePagination(pd);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.batchAddWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.rebackWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库执行(入库数量)
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/updateWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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

        WarehouseInExecute execute = warehouseInExecuteService.findWarehouseInExecuteById(id);
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(execute.getDetailId());

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
            warehouseInExecuteService.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
//            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

//            WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

            Map columnMap = new HashMap();
            columnMap.put("detail_id",detail.getId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseInExecute> warehouseInExecuteList = warehouseInExecuteService.selectByColumnMap(columnMap);
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库执行
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/deleteWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        String id = pageData.getString("id");

        WarehouseInExecute execute = warehouseInExecuteService.findWarehouseInExecuteById(id);
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
            warehouseInExecuteService.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
//            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//            warehouseInDetailService.updateStateWarehouseInDetail(detailList);


//            WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

            Map columnMap = new HashMap();
            columnMap.put("detail_id",detail.getId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseInExecute> warehouseInExecuteList = warehouseInExecuteService.selectByColumnMap(columnMap);
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap, String companyId) throws Exception {
        String productId = (String)firstRowMap.get("productId");
        String detailId = (String)firstRowMap.get("id");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("productId", productId);
        findMap.put("companyId", companyId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = warehouseInExecuteService.findListWarehouseInExecuteByEdit(findMap);
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


    /**
     * (退单)取消入库单执行-(退回整个入库单)
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/updateCancelWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCancelWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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
        Map<String, BigDecimal> mapExecute = warehouseInExecuteService.findExecuteCountByParentId(parentId);
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * 手机端
//     * 新增入库单明细执行
//     * @author fang
//     * @date 2018-10-18
//     * @throws Exception
//     */
//    @PostMapping("/warehouseInExecute/moblileAddWarehouseInExecute")
//    @Transactional
//    public ResultModel moblileAddWarehouseInExecute() throws Exception {
//        logger.info("################/warehouseInExecute/moblileAddWarehouseInExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//
//        PageData pageData = HttpUtils.parsePageData();
//        String cuser = pageData.getString("cuser");
//        String companyId = pageData.getString("currentCompanyId");
//
//        String parentId = pageData.getString("parentId");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库单id为空或空字符串");
//            return model;
//        }
//        String detailId = pageData.getString("detailId");
//        if (detailId == null || detailId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库单明细id为空或空字符串");
//            return model;
//        }
//
//        String productId = pageData.getString("productId");
//        if (productId == null || productId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("货品id为空或空字符串");
//            return model;
//        }
//        String warehouseId = pageData.getString("warehouseId");
//        if (warehouseId == null || warehouseId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("货位id为空或空字符串");
//            return model;
//        }
//        String code = pageData.getString("code");
//        if (code == null || code.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("批次号为空或空字符串");
//            return model;
//        }
//
//        //入库数量 count
//        String count = pageData.getString("count");
//        BigDecimal countBig = BigDecimal.valueOf(0D);
//        if (count == null || count.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库数量为空或空字符串！");
//            return model;
//        } else {
//            try {
//                BigDecimal doubleBig = new BigDecimal(count);
//                if (doubleBig.doubleValue() < 0) {
//                    model.putCode(Integer.valueOf(1));
//                    model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
//                    return model;
//                }
//                countBig = doubleBig;
//            } catch (NumberFormatException numberExc) {
//                model.putCode(Integer.valueOf(1));
//                model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
//                return model;
//            }
//        }
//
//
//        StringBuffer msgBuf = new StringBuffer();
//        try {
//            //入库操作
//            WarehouseProduct inObject = new WarehouseProduct();
//            //货位批次号
//            inObject.setCode(code);
//            //产品ID
//            inObject.setProductId(productId);
//            //(实际)货位ID
//            inObject.setWarehouseId(warehouseId);
//
//            //库存变更日志
//            String executeId = Conv.createUuid();
//
//            WarehouseLoginfo loginfo = new WarehouseLoginfo();
//            loginfo.setParentId(parentId);
//            loginfo.setDetailId(detailId);
//            loginfo.setExecuteId(executeId);
//            loginfo.setCompanyId(companyId);
//            loginfo.setCuser(cuser);
//            //operation 操作类型(add:添加 modify:修改 delete:删除:)
//            loginfo.setOperation("add");
//
//            //beforeCount 操作变更前数量(业务相关)
//            loginfo.setBeforeCount(BigDecimal.valueOf(0D));
//            //afterCount 操作变更后数量(业务相关)
//            loginfo.setAfterCount(countBig);
//
//            String msgStr = warehouseProductService.inStockCount(inObject, countBig, loginfo);
//            if (msgStr != null && msgStr.trim().length() > 0) {
//                msgBuf.append( "入库操作失败:" + msgStr);
//            } else {
//                WarehouseInExecute execute = new WarehouseInExecute();
//                execute.setId(executeId);
//                execute.setDetailId(detailId);
//                execute.setWarehouseId(warehouseId);
//                execute.setExecutorId(cuser);
//                execute.setCount(countBig);
//                execute.setCuser(cuser);
//                warehouseInExecuteService.save(execute);
//
//                Product product = productService.findProductById(productId);
//                BigDecimal prodCount = BigDecimal.valueOf(0D);
//                if (product.getStockCount() != null) {
//                    prodCount = product.getStockCount();
//                }
//
//                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + countBig.doubleValue());
//                productService.updateStockCount(product, prodStockCount, cuser);
//
//                //2. 修改修改当前入库单明细状态--同时反写入库单状态
//                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//                warehouseInDetailService.updateStateWarehouseInDetail(detailList);
//            }
//        } catch (TableVersionException tabExc) {
//            //库存变更 version 锁
//            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
//                model.putCode(Integer.valueOf(1));
//                model.putMsg(tabExc.getMessage());
//                return model;
//            }
//        }
//
//        if (msgBuf.toString().trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgBuf.toString());
//            return model;
//        }
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouseInExecute/moblileAddWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
