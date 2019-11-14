package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.common.util.StringUtil;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
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
    private WarehouseProductToolService warehouseProductToolService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;
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
//        String parentId = Conv.createUuid();
//        warehouseMove.setId(parentId);
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
        for (Map<String, String> mapObject : mapList) {
            WarehouseMoveDetail detail = new WarehouseMoveDetail();
//            String id = Conv.createUuid();
//            detail.setId(id);
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            detail.setParentId(warehouseMove.getId());
            detail.setCuser(cuser);
            detail.setProductId(mapObject.get("productId"));
            detail.setWarehouseProductId(mapObject.get("warehouseProductId"));
            detail.setWarehouseId(mapObject.get("warehouseId"));
            BigDecimal count = BigDecimal.valueOf(Double.parseDouble(mapObject.get("moveCount")));
            detail.setCount(count);
            warehouseMoveDetailService.save(detail);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/addWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-11-16
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/listPageWarehouseMoveBySimple")
    public ResultModel listPageWarehouseMoveBySimple()  throws Exception {

        logger.info("################warehouseMoveBySimple/listPageWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveService.listPageWarehouseMoveBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveBySimple/listPageWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-11-16
     */
    @PostMapping("/warehouse/warehouseOutBySimple/listPageWarehouseMoveDetailsBySimple")
    public ResultModel listPageWarehouseMoveDetailsBySimple()  throws Exception {

        logger.info("################warehouseOutBySimple/listPageWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveDetailService.listPageWarehouseMoveDetailsBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutBySimple/listPageWarehouseMoveDetailsBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
        for (int i = 0; i < detailList.size(); i++) {
            WarehouseMoveDetail detail = detailList.get(i);
            String detailId = detail.getId();


            BigDecimal suggestCount = detail.getCount();
            String productId = detail.getProductId();
            String warehouseId = detail.getWarehouseId();
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,companyId,warehouseId,suggestCount);




            if(outMapList!=null&&outMapList.size()>0){
                for(int j=0;j<outMapList.size();j++){
                    Map<String, Object> outMap = outMapList.get(j);
                    String warehouseProductId = (String)outMap.get("warehouseProductId");
                    BigDecimal count = (BigDecimal)outMap.get("outCount");
                    if(count==null){
                        count = BigDecimal.valueOf(0D);
                    }
                    if(!StringUtils.isEmpty(warehouseProductId)){
                        if(count.compareTo(BigDecimal.ZERO)>0){
                            WarehouseProduct sourceMove = warehouseProductService.findWarehouseProductById(warehouseProductId);


                            PageData findMap = new PageData();
                            findMap.put("code", sourceMove.getCode());
                            findMap.put("productId", sourceMove.getProductId());
                            findMap.put("warehouseId", targetWarehouseId);
                            findMap.put("mapSize", Integer.valueOf(findMap.size()));
                            WarehouseProduct targetMove = warehouseProductService.findWarehouseProduct(findMap);

                            if(targetMove==null){
                                targetMove = new WarehouseProduct();
                                String id = Conv.createUuid();
                                targetMove.setId(id);
                                targetMove.setCompanyId(sourceMove.getCompanyId());
                                targetMove.setCode(sourceMove.getCode());
                                targetMove.setProductId(sourceMove.getProductId());
                                targetMove.setWarehouseId(targetWarehouseId);
                                targetMove.setCdate(new Date());
                                targetMove.setQrcode(sourceMove.getQrcode());
                                warehouseProductService.save(targetMove);
                            }

                            WarehouseMoveExecute execute = new WarehouseMoveExecute();
                            execute.setDetailId(detailId);
                            execute.setExecutorId(cuser);
                            execute.setWarehouseProductId(sourceMove.getId());
                            execute.setNewWarehouseProductId(targetMove.getId());
                            execute.setCount(count);
                            warehouseMoveExecuteService.save(execute);

                            WarehouseLoginfo loginfo = new WarehouseLoginfo();
                            loginfo.setParentId(parentId);
                            loginfo.setDetailId(detailId);
                            loginfo.setExecuteId(execute.getId());
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
                            }
                        }
                    }else{
                        model.putCode(Integer.valueOf(1));
                        model.putMsg("移库货品信息异常！");
                        return model;
                    }



                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("移库货品信息异常！");
                return model;
            }



            Map columnMap = new HashMap();
            columnMap.put("detail_id",detailId);
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
            if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
                for(int k=0; k<warehouseMoveExecuteList.size(); k++){
                    WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(k);
                    if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseMoveExecute.getCount());
                    }
                }
            }
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if(detail.getCount().compareTo(totalCount)>0){
                detail.setState("1");
            }else {
                detail.setState("2");
            }
            warehouseMoveDetailService.update(detail);
        }
        if (msgBuf.toString().trim().length() > 0) {
            throw new BizException(msgBuf.toString());
        }
        warehouseMoveService.updateState(parentId);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/executeWarehouseMoveBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * 执行移库单(简版仓库移库)
     * @author 陈刚
     * @date 2019-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseMoveBySimple/executeWarehouseMoveByWC")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseMoveByWC() throws Exception {
        logger.info("################/warehouse/warehouseMoveBySimple/executeWarehouseMoveByWC 执行开始 ################# ");
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
        for (int i = 0; i < detailList.size(); i++) {
            WarehouseMoveDetail detail = detailList.get(i);
            String detailId = detail.getId();
            String warehouseProductId = detail.getWarehouseProductId();

            BigDecimal suggestCount = detail.getCount();



            if(!StringUtils.isEmpty(warehouseProductId)){
                if(suggestCount.compareTo(BigDecimal.ZERO)>0){
                    WarehouseProduct sourceMove = warehouseProductService.findWarehouseProductById(warehouseProductId);


                    PageData findMap = new PageData();
                    findMap.put("code", sourceMove.getCode());
                    findMap.put("productId", sourceMove.getProductId());
                    findMap.put("warehouseId", targetWarehouseId);
                    findMap.put("mapSize", Integer.valueOf(findMap.size()));
                    WarehouseProduct targetMove = warehouseProductService.findWarehouseProduct(findMap);

                    if(targetMove==null){
                        targetMove = new WarehouseProduct();
                        String id = Conv.createUuid();
                        targetMove.setId(id);
                        targetMove.setCompanyId(sourceMove.getCompanyId());
                        targetMove.setCode(sourceMove.getCode());
                        targetMove.setProductId(sourceMove.getProductId());
                        targetMove.setWarehouseId(targetWarehouseId);
                        targetMove.setCdate(new Date());
                        targetMove.setQrcode(sourceMove.getQrcode());
                        warehouseProductService.save(targetMove);
                    }

                    WarehouseMoveExecute execute = new WarehouseMoveExecute();
                    execute.setDetailId(detailId);
                    execute.setExecutorId(cuser);
                    execute.setWarehouseProductId(sourceMove.getId());
                    execute.setNewWarehouseProductId(targetMove.getId());
                    execute.setCount(suggestCount);
                    warehouseMoveExecuteService.save(execute);

                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setParentId(parentId);
                    loginfo.setDetailId(detailId);
                    loginfo.setExecuteId(execute.getId());
                    loginfo.setCompanyId(companyId);
                    loginfo.setCuser(cuser);
                    //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:移库审核)
                    loginfo.setOperation("modify");

                    //beforeCount 操作变更前数量(业务相关)-(beforeCount 台账数量)
                    loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                    //afterCount 操作变更后数量(业务相关)-(afterCount 移库数量)
                    loginfo.setAfterCount(suggestCount);

                    String msgStr = warehouseProductService.moveStockCountBySimple(sourceMove, targetMove, suggestCount, loginfo);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        msgBuf.append("第 " + (i+1) + " 条: " + "移库操作失败:" + msgStr);
                    }
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("移库货品信息异常！");
                return model;
            }




            Map columnMap = new HashMap();
            columnMap.put("detail_id",detailId);
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
            if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
                for(int k=0; k<warehouseMoveExecuteList.size(); k++){
                    WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(k);
                    if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseMoveExecute.getCount());
                    }
                }
            }
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if(detail.getCount().compareTo(totalCount)>0){
                detail.setState("1");
            }else {
                detail.setState("2");
            }
            warehouseMoveDetailService.update(detail);
        }
        if (msgBuf.toString().trim().length() > 0) {
            throw new BizException(msgBuf.toString());
        }
        warehouseMoveService.updateState(parentId);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseMoveBySimple/executeWarehouseMoveByWC 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
