package com.xy.vmes.deecoop.equipment.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_out: (备件库)出库单Controller
 * @author 陈刚
 * @date 2018-06-24
 */
@RestController
@Slf4j
public class EquipmentWarehouseOutBySpareController {
    private Logger logger = LoggerFactory.getLogger(EquipmentWarehouseOutBySpareController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CoderuleService coderuleService;

    @PostMapping("/equipment/warehouseOutBySpare/listPageWarehouseOutBySpare")
    public ResultModel listPageWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/listPageWarehouseOutBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseOutService.listPageWarehouseOuts(pd,pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseOutBySpare/listPageWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseOutBySpare/addWarehouseOutBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/addWarehouseOutBySpare 执行开始 ################# ");
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
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_out", "O");
        warehouseOut.setCode(code);
        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        //warehouseOut.setIsSimple("Y");
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseOutBySpare/addWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseOutBySpare/deleteWarehouseOutBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/deleteWarehouseOutBySpare 执行开始 ################# ");
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
        logger.info("################/equipment/warehouseOutBySpare/deleteWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseOutBySpare/updateWarehouseOutBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/updateWarehouseOutBySpare 执行开始 ################# ");
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
                    String id = Conv.createUuid();
                    detail.setId(id);
                    //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                    detail.setParentId(warehouseOut.getId());
                    detail.setCuser(warehouseOut.getCuser());
                    detail.setWarehouseId(warehouseOut.getWarehouseId());
                    warehouseOutDetailService.save(detail);
                }
                else {
                    if (detail.getRemark() == null || detail.getRemark().trim().length() == 0) {
                        detail.setRemark("");
                    }
                    detail.setWarehouseId(warehouseOut.getWarehouseId());
                    warehouseOutDetailService.update(detail);
                }
            }
        }

        //2.更新出库单表头
        warehouseOutService.update(warehouseOut);

        //3.删除出库单明细
        String deleteIds = pageData.getString("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            deleteIds = StringUtil.stringTrimSpace(deleteIds);
            String[] delete_Ids = deleteIds.split(",");
            warehouseOutDetailService.deleteByIds(delete_Ids);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseOutBySpare/updateWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseOutBySpare/cancelWarehouseOutBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/cancelWarehouseOutBySpare 执行开始 ################# ");
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
        logger.info("################/equipment/warehouseOutBySpare/cancelWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseOutBySpare/recoveryWarehouseOutBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseOutBySpare() throws Exception {
        logger.info("################/equipment/warehouseOutBySpare/recoveryWarehouseOutBySpare 执行开始 ################# ");
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
        logger.info("################/equipment/warehouseOutBySpare/recoveryWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 执行出库单(备件库)
     * @author 陈刚
     * @date 2019-06-24
     * @throws Exception
     */
//    @PostMapping("/equipment/warehouseOutBySpare/executeWarehouseOutBySpare")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel executeWarehouseOutBySpare() throws Exception {
//        logger.info("################/equipment/warehouseOutBySpare/executeWarehouseOutBySpare 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String parentId = pageData.getString("id");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("出库单id为空或空字符串！");
//            return model;
//        }
//
//        String companyId = pageData.getString("currentCompanyId");
//        if (companyId == null || companyId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("企业id为空或空字符串！");
//            return model;
//        }
//
//        String cuser = pageData.getString("cuser");
//
//        List<WarehouseOutDetail> outDtlList = warehouseOutDetailService.findWarehouseOutDetailListByParentId(parentId);
//        if (outDtlList == null || outDtlList.size() == 0) {
//            return model;
//        }
//
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
//
//        //修改出库单明细状态
//        PageData mapDetail = new PageData();
//        mapDetail.put("parentId", parentId);
//        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//        mapDetail.put("state", "2");
//        warehouseOutDetailService.updateStateByDetail(mapDetail);
//
//        //修改出库单状态
//        //state:状态(0:未完成 1:已完成 -1:已取消)
//        WarehouseOut warehouseoutEdit = new WarehouseOut();
//        warehouseoutEdit.setId(parentId);
//        warehouseoutEdit.setState("1");
//        warehouseOutService.update(warehouseoutEdit);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/equipment/warehouseOutBySpare/executeWarehouseOutBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
