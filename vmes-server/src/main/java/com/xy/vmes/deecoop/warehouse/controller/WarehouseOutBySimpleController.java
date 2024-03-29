package com.xy.vmes.deecoop.warehouse.controller;

import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
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
import java.util.*;

/**
 * 说明：vmes_warehouse_out: 简版仓库入库单Controller
 * @author 陈刚 自动生成
 * @date 2018-05-21
 */
@RestController
@Slf4j
public class WarehouseOutBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseOutBySimpleController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductToolService warehouseProductToolService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/addWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/addWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        WarehouseOut warehouseOut = (WarehouseOut)HttpUtils.pageData2Entity(pageData, new WarehouseOut());
        if (warehouseOut == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseOut 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseOutService.checkColumn(warehouseOut);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加出库单
        String id = Conv.createUuid();
        warehouseOut.setId(id);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        warehouseOut.setCompanyId(companyID);
        //出库单编号
        //String code = coderuleService.createCoder(companyID, "vmes_warehouse_out", "O");
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyID, "vmes_warehouse_out", "O", Common.CODE_RULE_LENGTH_SHORTYEAR);
        warehouseOut.setCode(code);

        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库 office:办公出库)
        String warehouseAttribute = "warehouse";
        if (pageData.getString("warehouseAttribute") != null && pageData.getString("warehouseAttribute").trim().length() > 0) {
            warehouseAttribute = pageData.getString("warehouseAttribute").trim();
        }
        warehouseOut.setWarehouseAttribute(warehouseAttribute);

        //Service (deptId) 该参数名称已经使用 -- 更改为(warehouseDeptId)
        String warehouseDeptId = pageData.getString("warehouseDeptId");
        warehouseOut.setDeptId(warehouseDeptId);
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, detailList);

//        //3.添加出库单派单表
//        warehouseOutExecutorService.addWarehouseOutExecutorBySimple(detailList);
//
//        //4.添加出库单执行表
//        List<WarehouseOutExecute> executeList = new ArrayList<WarehouseOutExecute>();
//        for (WarehouseOutDetail outDetail : detailList) {
//            String productId = outDetail.getProductId();
//            BigDecimal count = outDetail.getCount();
//            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
//                    companyID,
//                    //仓库id 允许为空(null:该企业仓库出库 not null:指定的仓库出库)
//                    null,
//                    count);
//            if (outMapList != null && outMapList.size() > 0) {
//                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
//            }
//        }
//        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/addWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        //2. 删除出库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseOutDetailService.deleteByColumnMap(columnMap);

        //3. 删除出库单
        warehouseOutService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        WarehouseOut warehouseOut = (WarehouseOut)HttpUtils.pageData2Entity(pageData, new WarehouseOut());
        if (warehouseOut == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseOut 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseOutService.checkColumn(warehouseOut);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }
        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1.更新出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseOutDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
//                    String id = Conv.createUuid();
//                    detail.setId(id);
                    //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                    detail.setParentId(warehouseOut.getId());
                    detail.setCuser(warehouseOut.getCuser());
//                    detail.setWarehouseId(warehouseOut.getWarehouseId());
                    warehouseOutDetailService.save(detail);
                }
                else {
                    if (detail.getRemark() == null || detail.getRemark().trim().length() == 0) {
                        detail.setRemark("");
                    }
//                    detail.setWarehouseId(warehouseOut.getWarehouseId());
                    warehouseOutDetailService.update(detail);
                }
            }
        }

        //2.更新出库单表头
        //Service (deptId) 该参数名称已经使用 -- 更改为(warehouseDeptId)
        String warehouseDeptId = pageData.getString("warehouseDeptId");
        warehouseOut.setDeptId(warehouseDeptId);
        warehouseOutService.update(warehouseOut);

        //3.删除出库单明细
        String deleteIds = pageData.getString("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            deleteIds = StringUtil.stringTrimSpace(deleteIds);
            String[] delete_Ids = deleteIds.split(",");
            warehouseOutDetailService.deleteByIds(delete_Ids);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/cancelWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/cancelWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "-1");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseOut warehouseOut = new WarehouseOut();
        warehouseOut.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("-1");
        warehouseOutService.update(warehouseOut);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/cancelWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/recoveryWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/recoveryWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        //出库单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseOut warehouseOut = warehouseOutService.findWarehouseOutById(parentId);
        //验证出库单是否允许取消
        if (!"-1".equals(warehouseOut.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库单不是取消状态，不可恢复！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "1");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        warehouseOutService.update(warehouseOut);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/recoveryWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/executeWarehouseOutExecuteBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseOutExecuteBySimple() throws Exception {
        logger.info("################/warehouseOutBySimple/executeWarehouseOutExecuteBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.executeWarehouseOutExecuteBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutBySimple/executeWarehouseOutExecuteBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/executeWarehouseOutExecuteByWC")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseOutExecuteByWC() throws Exception {
        logger.info("################/warehouseOutBySimple/executeWarehouseOutExecuteByWC 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.executeWarehouseOutExecuteByWC(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutBySimple/executeWarehouseOutExecuteByWC 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 报废审核
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/auditWarehouseOutExecuteBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditWarehouseOutExecuteBySimple() throws Exception {
        logger.info("################/warehouseOutBySimple/auditWarehouseOutExecuteBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.auditWarehouseOutExecuteBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutBySimple/auditWarehouseOutExecuteBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 执行出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/executeWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/executeWarehouseOutBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String cuser = pageData.getString("cuser");

//        List<WarehouseOutDetail> outDtlList = warehouseOutDetailService.findWarehouseOutDetailListByParentId(parentId);
//        if (outDtlList == null || outDtlList.size() == 0) {
//            return model;
//        }

//        StringBuffer msgBuf = new StringBuffer();
//        try {
//            for (int i = 0; i < outDtlList.size(); i++) {
//                WarehouseOutDetail object = outDtlList.get(i);
//
//                String detailId = object.getId();
//                BigDecimal count = object.getCount();
//                String warehouseId = object.getWarehouseId();
//                String productId = object.getProductId();
//
//                //(简版仓库)出库操作
//                WarehouseProduct outObject = new WarehouseProduct();
//                //产品ID
//                outObject.setProductId(productId);
//                //(实际)货位ID
//                outObject.setWarehouseId(warehouseId);
//
//                //库存变更日志
//                String executeId = Conv.createUuid();
//
//                WarehouseLoginfo loginfo = new WarehouseLoginfo();
//                loginfo.setParentId(parentId);
//                loginfo.setDetailId(detailId);
//                loginfo.setExecuteId(executeId);
//                loginfo.setCompanyId(companyId);
//                loginfo.setCuser(cuser);
//                //operation 操作类型(add:添加 modify:修改 delete:删除:)
//                loginfo.setOperation("add");
//
//                //beforeCount 操作变更前数量(业务相关)
//                loginfo.setBeforeCount(BigDecimal.valueOf(0D));
//                //afterCount 操作变更后数量(业务相关)
//                loginfo.setAfterCount(count);
//
//                String msgStr = warehouseProductService.outStockCountBySimple(outObject, count, loginfo);
//                if (msgStr != null && msgStr.trim().length() > 0) {
//                    msgBuf.append("第 " + (i+1) + " 条: " + "出库操作失败:" + msgStr);
//                } else {
//                    Product product = productService.findProductById(productId);
//                    BigDecimal prodCount = BigDecimal.valueOf(0D);
//                    if (product.getStockCount() != null) {
//                        prodCount = product.getStockCount();
//                    }
//
//                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - count.doubleValue());
//                    productService.updateStockCount(product, prodStockCount, cuser);
//                }
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

        List<Map> executeList = warehouseOutExecuteService.findExecuteListByParentId(parentId);
        if (executeList == null || executeList.size() == 0) {
            return model;
        }

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
                    msgBuf.append("第 " + (i+1) + " 条: " + "出库操作失败:" + msgStr);
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


        //修改出库单明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "2");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //修改出库单状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseOut warehouseoutEdit = new WarehouseOut();
        warehouseoutEdit.setId(parentId);
        warehouseoutEdit.setState("1");
        warehouseOutService.update(warehouseoutEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/executeWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
