package com.xy.vmes.deecoop.warehouse.controller;

import com.yvan.common.util.Common;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_check 简版仓库盘点Controller
 * @author 陈刚
 * @date 2019-05-23
 */
@RestController
@Slf4j
public class WarehouseCheckBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckBySimpleController.class);

    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
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
            model.putMsg("盘点单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加盘点单
        WarehouseCheck warehouseCheck = new WarehouseCheck();
        String parentId = Conv.createUuid();
        warehouseCheck.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheck.setState("0");
        warehouseCheck.setCompanyId(companyId);
        //盘点单编号
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_check", "C");
        warehouseCheck.setCode(code);
        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        warehouseCheck.setIsSimple("Y");
        warehouseCheck.setCuser(cuser);
        warehouseCheck.setMakeId(cuser);
        warehouseCheckService.save(warehouseCheck);

        //2.添加盘点单明细
        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.mapList2DetailList(mapList);
        warehouseCheckDetailService.addWarehouseCheckDetailBySimple(parentId,cuser, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/deleteWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/deleteWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单id为空或空字符串！");
            return model;
        }

        //2. 删除盘点单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseCheckDetailService.deleteByColumnMap(columnMap);

        //3. 删除盘点单
        warehouseCheckService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/deleteWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/cancelWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/cancelWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        warehouseCheckDetailService.updateStateByDetail(parentId, "-1");

        //3. 修改抬头表状态
        WarehouseCheck warehouseCheckEdit = new WarehouseCheck();
        warehouseCheckEdit.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheckEdit.setState("-1");
        warehouseCheckService.update(warehouseCheckEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/cancelWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/recoveryWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/recoveryWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单id为空或空字符串！");
            return model;
        }


        //2. 修改明细状态
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        warehouseCheckDetailService.updateStateByDetail(parentId, "1");

        //3. 修改抬头表状态
        WarehouseCheck warehouseCheckEdit = new WarehouseCheck();
        warehouseCheckEdit.setId(parentId);
        //盘点单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheckEdit.setState("0");
        warehouseCheckService.update(warehouseCheckEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/recoveryWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 执行盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/executeWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/executeWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String cuser = pageData.getString("cuser");

        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.findWarehouseCheckDetailListByParentId(parentId);
        if (detailList == null || detailList.size() == 0) {
            return model;
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (int i = 0; i < detailList.size(); i++) {
                WarehouseCheckDetail detailEdit = new WarehouseCheckDetail();
                WarehouseCheckDetail object = detailList.get(i);

                String detailId = object.getId();
                detailEdit.setId(detailId);

                //盘点库存数量  stockCount
                BigDecimal afterCount = BigDecimal.valueOf(0D);
                if (object.getStockCount() != null) {
                    afterCount = object.getStockCount();
                }

                //台账数量 checkStockCount
                BigDecimal beforeCount = BigDecimal.valueOf(0D);
                if (object.getCheckStockCount() != null) {
                    beforeCount = object.getCheckStockCount();
                }

                //变更库存数量 := (count 盘点数量)after - (stockCount 台账数量)before
                double modifyCount = afterCount.doubleValue() - beforeCount.doubleValue();

                String warehouseId = object.getWarehouseId();
                String productId = object.getProductId();

                //盘点操作
                WarehouseProduct inObject = new WarehouseProduct();
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
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:盘点审核)
                loginfo.setOperation("checkAudit");

                //beforeCount 操作变更前数量(业务相关)-(beforeCount 台账数量)
                loginfo.setBeforeCount(beforeCount);
                //afterCount 操作变更后数量(业务相关)-(afterCount 盘点数量)
                loginfo.setAfterCount(afterCount);

                String msgStr = warehouseProductService.checkStockCountBySimple(inObject, BigDecimal.valueOf(modifyCount), loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "盘点操作失败:" + msgStr);
                } else {
                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount);
                    productService.updateStockCount(product, prodStockCount, cuser);

                    //明细状态:state:状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
                    detailEdit.setState("3");
                    detailEdit.setExecuteId(cuser);
                    warehouseCheckDetailService.update(detailEdit);
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

        //修改盘点单状态
        WarehouseCheck warehouseCheckEdit = new WarehouseCheck();
        warehouseCheckEdit.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheckEdit.setState("1");
        warehouseCheckService.update(warehouseCheckEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/executeWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
