package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_in: 简版仓库入库单Controller
 * @author 陈刚 自动生成
 * @date 2018-05-21
 */
@RestController
@Slf4j
public class WarehouseInBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInBySimpleController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;
    @Autowired
    private CoderuleService coderuleService;

    @PostMapping("/warehouse/warehouseInBySimple/listPageWarehouseInBySimple")
    public ResultModel listPageWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/listPageWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInService.listPageWarehouseIn(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/listPageWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单(简版仓库入库)
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInBySimple/addWarehouseInBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/addWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        WarehouseIn warehouseIn = (WarehouseIn) HttpUtils.pageData2Entity(pageData, new WarehouseIn());
        if (warehouseIn == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseIn 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseInService.checkColumn(warehouseIn);
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
            model.putMsg("入库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加入库单
        String parentId = Conv.createUuid();
        warehouseIn.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setCompanyId(companyID);
        //入库单编号
        //String code = coderuleService.createCoder(companyID, "vmes_warehouse_in", "I");
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyID, "vmes_warehouse_in", "I", Common.CODE_RULE_LENGTH_SHORTYEAR);
        warehouseIn.setCode(code);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseIn.setWarehouseAttribute("warehouse");

        //Service (deptId) 该参数名称已经使用 -- 更改为(warehouseDeptId)
        String warehouseDeptId = pageData.getString("warehouseDeptId");
        warehouseIn.setDeptId(warehouseDeptId);
        warehouseInService.save(warehouseIn);

        //2.添加入库单明细
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        //入库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        warehouseInDetailService.addWarehouseInDetailBySimple(warehouseIn, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/addWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单(简版仓库入库)
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInBySimple/deleteWarehouseInBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/deleteWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //2. 删除入库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseInDetailService.deleteByColumnMap(columnMap);

        //3. 删除入库单
        warehouseInService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/deleteWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单(简版仓库入库)
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInBySimple/updateWarehouseInBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/updateWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pageData, new WarehouseIn());
        if (warehouseIn == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 WarehouseIn 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseInService.checkColumn(warehouseIn);
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
            model.putMsg("入库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1.更新入库单明细
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseInDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
                    String id = Conv.createUuid();
                    detail.setId(id);
                    //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                    detail.setParentId(warehouseIn.getId());
                    detail.setCuser(warehouseIn.getCuser());
                    detail.setWarehouseId(warehouseIn.getWarehouseId());

                    //获取批次号
                    //PC+yyyy 最后2位+00001 = 13位
                    String code = coderuleService.createCoderCdateOnShortYearByDate(companyID,
                            "vmes_product_pc",
                            "PC");
                    detail.setCode(code);

                    //生成批次号二维码(批次号,产品ID,产品名称)
                    String QRCodeJson = warehouseInDetailService.warehouseInDtl2QRCode(detail);
                    String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
                    if (qrcode != null && qrcode.trim().length() > 0) {
                        detail.setQrcode(qrcode);
                    }

                    warehouseInDetailService.save(detail);
                }
                else {
                    if (detail.getRemark() == null || detail.getRemark().trim().length() == 0) {
                        detail.setRemark("");
                    }
                    detail.setWarehouseId(warehouseIn.getWarehouseId());
                    warehouseInDetailService.update(detail);
                }
            }
        }

        //2.更新入库单表头
        //Service (deptId) 该参数名称已经使用 -- 更改为(warehouseDeptId)
        String warehouseDeptId = pageData.getString("warehouseDeptId");
        warehouseIn.setDeptId(warehouseDeptId);
        warehouseInService.update(warehouseIn);

        //3.删除入库单明细
        String deleteIds = pageData.getString("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            deleteIds = StringUtil.stringTrimSpace(deleteIds);
            String[] delete_Ids = deleteIds.split(",");
            warehouseInDetailService.deleteByIds(delete_Ids);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/updateWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消入库单(简版仓库入库)
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInBySimple/cancelWarehouseInBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/cancelWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "-1");
        warehouseInDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseIn warehouseIn = new WarehouseIn();
        warehouseIn.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("-1");
        warehouseInService.update(warehouseIn);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/cancelWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复入库单(简版仓库入库)
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInBySimple/recoveryWarehouseInBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseInBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/recoveryWarehouseInBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //入库单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(parentId);
        //验证出库单是否允许取消
        if (!"-1".equals(warehouseIn.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单不是取消状态，不可恢复！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "1");
        warehouseInDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseInService.update(warehouseIn);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/recoveryWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 简版仓库-入库单明细查询
     * @author 陈刚
     * @date 2019-09-16
     */
    @PostMapping("/warehouse/warehouseInBySimple/listPageWarehouseInDetailExecuteBySimple")
    public ResultModel listPageWarehouseInDetailExecuteBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInBySimple/listPageWarehouseInDetailExecuteBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInDetailService.listPageWarehouseInDetailExecuteBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInBySimple/listPageWarehouseInDetailExecuteBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 执行入库单(简版仓库入库)
//     * @author 陈刚
//     * @date 2019-10-16
//     * @throws Exception
//     */
//    @PostMapping("/warehouse/warehouseInBySimple/executeWarehouseInBySimple")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel executeWarehouseInBySimple() throws Exception {
//        logger.info("################/warehouse/warehouseInBySimple/executeWarehouseInBySimple 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String parentId = pageData.getString("id");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库单id为空或空字符串！");
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
//        List<WarehouseInDetail> inDtlList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//        if (inDtlList == null || inDtlList.size() == 0) {
//            return model;
//        }
//
//        StringBuffer msgBuf = new StringBuffer();
//        try {
//            for (int i = 0; i < inDtlList.size(); i++) {
//                WarehouseInDetail object = inDtlList.get(i);
//
//                String detailId = object.getId();
//                BigDecimal count = object.getCount();
//                String warehouseId = object.getWarehouseId();
//                String productId = object.getProductId();
//                String code = object.getCode();
//
//                //入库操作
//                WarehouseProduct inObject = new WarehouseProduct();
//                //货位批次号
//                inObject.setCode(code);
//                //产品ID
//                inObject.setProductId(productId);
//                //(实际)货位ID
//                inObject.setWarehouseId(warehouseId);
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
//                String msgStr = warehouseProductService.inStockCount(inObject, count, loginfo);
//                if (msgStr != null && msgStr.trim().length() > 0) {
//                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
//                } else {
//                    Product product = productService.findProductById(productId);
//                    BigDecimal prodCount = BigDecimal.valueOf(0D);
//                    if (product.getStockCount() != null) {
//                        prodCount = product.getStockCount();
//                    }
//
//                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
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
//        //修改入库单明细状态
//        PageData mapDetail = new PageData();
//        mapDetail.put("parentId", parentId);
//        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//        mapDetail.put("state", "2");
//        warehouseInDetailService.updateStateByDetail(mapDetail);
//
//        //修改入库单状态
//        //state:状态(0:未完成 1:已完成 -1:已取消)
//        WarehouseIn warehouseInEdit = new WarehouseIn();
//        warehouseInEdit.setId(parentId);
//        warehouseInEdit.setState("1");
//        warehouseInService.update(warehouseInEdit);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouse/warehouseInBySimple/executeWarehouseInBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
