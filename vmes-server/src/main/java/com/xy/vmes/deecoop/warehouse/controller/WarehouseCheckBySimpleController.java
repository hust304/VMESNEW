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
    private WarehouseProductToolService warehouseProductToolService;
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
        //warehouseCheck.setIsSimple("Y");
        warehouseCheck.setCuser(cuser);
        warehouseCheck.setMakeId(cuser);
        warehouseCheckService.saveNotId(warehouseCheck);

        //2.添加盘点单明细
        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.mapList2DetailList(mapList);
        warehouseCheckDetailService.addWarehouseCheckDetailBySimple(parentId, cuser, detailList);

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

        try {
            for (int i = 0; i < detailList.size(); i++) {
                WarehouseCheckDetail object = detailList.get(i);
                String checkDtl = object.getId();
                String warehouseId = object.getWarehouseId();
                String productId = object.getProductId();

                //(货位id,货品id)查询 vmes_warehouse_product
                PageData findMap = new PageData();
                findMap.put("warehouseId", warehouseId);
                findMap.put("productId", productId);
                findMap.put("queryStr", "stock_count > 0 ");
                findMap.put("orderStr", "cdate asc");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                List<WarehouseProduct> objectList = warehouseProductService.findWarehouseProductList(findMap);
                if (objectList == null || objectList.size() == 0) {continue;}

                //盘点库存数量数量 stockCount --> afterStockCount
                BigDecimal afterStockCount = object.getStockCount();

                //盘点台账数量 checkStockCount --> beforeStockCount
                BigDecimal beforeStockCount = object.getCheckStockCount();

                //变更库存数量 := 盘点后库存数量 - 盘点前库存数量
                BigDecimal changeStockCount = BigDecimal.valueOf(afterStockCount.doubleValue() - beforeStockCount.doubleValue());
                if (changeStockCount.doubleValue() < 0D) {
                    //out 库存减数量
                    BigDecimal changeCount = BigDecimal.valueOf(changeStockCount.doubleValue() * -1);
                    //四舍五入到2位小数
                    changeCount = changeCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                    Map<String, WarehouseProduct> WarehouseProductMap = warehouseProductToolService.warehouseProductList2Map(objectList);
                    //List<Map<String, Object>>
                    //Map<String, Object>
                    //warehouseProductId
                    //outCount
                    List<Map<String, Object>> changeOutMap = warehouseProductToolService.findWarehouseProductReduceMapListBySimple(objectList, changeCount);
                    for (Map<String, Object> outMap : changeOutMap) {
                        String warehouseProductId = (String)outMap.get("warehouseProductId");
                        BigDecimal outCount = (BigDecimal)outMap.get("outCount");
                        if (outCount == null) {continue;}
                        WarehouseProduct warehouseProduct = WarehouseProductMap.get(warehouseProductId);

                        BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
                        if (warehouseProduct.getStockCount() != null) {
                            beforeCountBig = warehouseProduct.getStockCount();
                        }
                        //四舍五入到2位小数
                        beforeCountBig = beforeCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                        //变更后库存数量 := 变更前库存数量 - outCount
                        BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() - outCount.doubleValue());
                        //四舍五入到2位小数
                        afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                        //盘点操作
                        WarehouseProduct inObject = new WarehouseProduct();
                        //产品ID
                        inObject.setProductId(warehouseProduct.getProductId());
                        //(实际)货位ID
                        inObject.setWarehouseId(warehouseProduct.getWarehouseId());
                        inObject.setCode(warehouseProduct.getCode());

                        //库存变更日志
                        WarehouseLoginfo loginfo = new WarehouseLoginfo();
                        loginfo.setParentId(parentId);
                        loginfo.setDetailId(checkDtl);
                        String executeId = Conv.createUuid();
                        loginfo.setExecuteId(executeId);
                        loginfo.setCompanyId(companyId);
                        loginfo.setCuser(cuser);
                        //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:盘点审核)
                        loginfo.setOperation("checkAudit");

                        //beforeCount 操作变更前数量(业务相关)-(beforeCount 台账数量)
                        loginfo.setBeforeCount(beforeCountBig);
                        //afterCount 操作变更后数量(业务相关)-(afterCount 盘点数量)
                        loginfo.setAfterCount(afterCountBig);

                        BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
                        warehouseProductService.checkStockCount(inObject, modifyCount, loginfo);

                        Product product = productService.findProductById(productId);
                        BigDecimal prodCount = BigDecimal.valueOf(0D);
                        if (product.getStockCount() != null) {
                            prodCount = product.getStockCount();
                        }

                        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
                        productService.updateStockCount(product, prodStockCount, cuser);
                    }
                } else if (changeStockCount.doubleValue() > 0D) {
                    //in 库存加数量
                    //List<WarehouseProduct> objectList，按(cdate)降序排列
                    warehouseProductService.orderDescByCdate(objectList);

                    WarehouseProduct warehouseProduct = objectList.get(0);
                    BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
                    if (warehouseProduct.getStockCount() != null) {
                        beforeCountBig = warehouseProduct.getStockCount();
                    }

                    //变更后库存数量 := 变更前库存数量 + changeStockCount
                    BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() + changeStockCount.doubleValue());
                    //四舍五入到2位小数
                    afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                    //盘点操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //产品ID
                    inObject.setProductId(warehouseProduct.getProductId());
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseProduct.getWarehouseId());
                    inObject.setCode(warehouseProduct.getCode());

                    //库存变更日志
                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setParentId(parentId);
                    loginfo.setDetailId(checkDtl);
                    String executeId = Conv.createUuid();
                    loginfo.setExecuteId(executeId);
                    loginfo.setCompanyId(companyId);
                    loginfo.setCuser(cuser);
                    //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:盘点审核)
                    loginfo.setOperation("checkAudit");

                    //beforeCount 操作变更前数量(业务相关)-(beforeCount 台账数量)
                    loginfo.setBeforeCount(beforeCountBig);
                    //afterCount 操作变更后数量(业务相关)-(afterCount 盘点数量)
                    loginfo.setAfterCount(afterCountBig);

                    BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
                    warehouseProductService.checkStockCount(inObject, modifyCount, loginfo);

                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
                    productService.updateStockCount(product, prodStockCount, cuser);
                }

                WarehouseCheckDetail detailEdit = new WarehouseCheckDetail();
                detailEdit.setId(checkDtl);
                //明细状态:state:状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
                detailEdit.setState("3");
                detailEdit.setExecuteId(cuser);
                warehouseCheckDetailService.update(detailEdit);
            }

            //修改盘点单状态
            WarehouseCheck warehouseCheckEdit = new WarehouseCheck();
            warehouseCheckEdit.setId(parentId);
            //state:状态(0:未完成 1:已完成 -1:已取消)
            warehouseCheckEdit.setState("1");
            warehouseCheckService.update(warehouseCheckEdit);

        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/executeWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
