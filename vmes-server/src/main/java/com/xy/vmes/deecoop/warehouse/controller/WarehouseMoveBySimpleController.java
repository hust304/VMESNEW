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
public class WarehouseMoveBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckBySimpleController.class);

    @Autowired
    private WarehouseMoveService warehouseMoveService;
    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/addWarehouseMoveBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseMoveBySimple() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/addWarehouseMoveBySimple 执行开始 ################# ");
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

        //目标库位 targetWarehouseId
        String targetWarehouseId = pageData.getString("targetWarehouseId");
        if (targetWarehouseId == null || targetWarehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("目标仓库id为空或空字符串！");
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
            model.putMsg("移库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加移库单
        WarehouseMove warehouseMove = new WarehouseMove();
        String parentId = Conv.createUuid();
        warehouseMove.setId(parentId);
        warehouseMove.setWarehouseId(targetWarehouseId);
        //type 移库类型：移库
        warehouseMove.setType("b73d12669b4646e68c1a633da5b5d22d");
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseMove.setState("0");
        warehouseMove.setCompanyId(companyId);
        //移库单编号
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_move", "M");
        warehouseMove.setCode(code);
        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        //warehouseMove.setIsSimple("Y");
        warehouseMove.setCuser(cuser);
        warehouseMove.setMakeId(cuser);
        warehouseMoveService.save(warehouseMove);

        //2.添加移库单明细
        List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.mapList2DetailList(mapList, null);
        warehouseMoveDetailService.addWarehouseMoveDetail(warehouseMove, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/addWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/deleteWarehouseMoveBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseMoveBySimple() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/deleteWarehouseMoveBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }

        //2. 删除移库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseMoveDetailService.deleteByColumnMap(columnMap);

        //3. 删除移库单
        warehouseMoveService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/deleteWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/cancelWarehouseMoveBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseMoveBySimple() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/cancelWarehouseMoveBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "-1");
        warehouseMoveDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseMove warehouseMoveEdit = new WarehouseMove();
        warehouseMoveEdit.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseMoveEdit.setState("-1");
        warehouseMoveService.update(warehouseMoveEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/cancelWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/recoveryWarehouseMoveBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseMoveBySimple() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/recoveryWarehouseMoveBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }


        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "1");
        warehouseMoveDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseMove warehouseMoveEdit = new WarehouseMove();
        warehouseMoveEdit.setId(parentId);
        //移库单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseMoveEdit.setState("0");
        warehouseMoveService.update(warehouseMoveEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/recoveryWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 执行移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/executeWarehouseMoveBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseMoveBySimple() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/executeWarehouseMoveBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String cuser = pageData.getString("cuser");

        //移库单id 获取移库单表对象
        WarehouseMove parent = warehouseMoveService.selectById(parentId);
        //获取移库目标货位id
        String targetWarehouseId = parent.getWarehouseId();

        List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.findWarehouseMoveDetailListByParentId(parentId);
        if (detailList == null || detailList.size() == 0) {
            return model;
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (int i = 0; i < detailList.size(); i++) {
                WarehouseMoveDetail detailEdit = new WarehouseMoveDetail();
                WarehouseMoveDetail detail = detailList.get(i);

                String detailId = detail.getId();
                detailEdit.setId(detailId);

                //warehouseProductId 当前库位产品ID
                String warehouseProductId = detail.getWarehouseProductId();
                WarehouseProduct sourceWarehouseProduct = warehouseProductService.findWarehouseProductById(warehouseProductId);

                //移库数量 count
                BigDecimal count = BigDecimal.valueOf(0D);
                if (detail.getCount() != null) {
                    count = detail.getCount();
                }

                //移库操作(源)
                WarehouseProduct sourceMove = new WarehouseProduct();
                sourceMove.setWarehouseId(sourceWarehouseProduct.getWarehouseId());
                sourceMove.setProductId(sourceWarehouseProduct.getProductId());

                //移库操作(目标)
                WarehouseProduct targetMove = new WarehouseProduct();
                targetMove.setWarehouseId(targetWarehouseId);
                targetMove.setProductId(sourceWarehouseProduct.getProductId());

                //库存变更日志
                String executeId = Conv.createUuid();

                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(parentId);
                loginfo.setDetailId(detailId);
                loginfo.setExecuteId(executeId);
                loginfo.setCompanyId(companyId);
                loginfo.setCuser(cuser);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:移库审核)
                loginfo.setOperation("modify");

                //beforeCount 操作变更前数量(业务相关)-(beforeCount 台账数量)
                loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                //afterCount 操作变更后数量(业务相关)-(afterCount 移库数量)
                loginfo.setAfterCount(count);

                String msgStr = warehouseProductService.moveStockCountBySimple(sourceMove, targetMove, count, loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "移库操作失败:" + msgStr);
                } else {
                    //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1:已取消)
                    detailEdit.setState("2");
                    warehouseMoveDetailService.update(detailEdit);
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

        //修改移库单状态
        WarehouseMove warehouseMoveEdit = new WarehouseMove();
        warehouseMoveEdit.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseMoveEdit.setState("1");
        warehouseMoveService.update(warehouseMoveEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/executeWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
