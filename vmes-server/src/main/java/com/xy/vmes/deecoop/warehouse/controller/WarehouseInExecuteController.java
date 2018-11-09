package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/addWarehouseInExecute")
    @Transactional
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String executeJsonStr = pageData.getString("executeJsonStr");
        if (executeJsonStr == null || executeJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一条入库数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(executeJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细执行 Json字符串-转换成List错误！");
            return model;
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (Map<String, Object> warehouseInDetailMap : mapList) {
                Object executeObj = warehouseInDetailMap.get("children");
                if (executeObj == null) {continue;}

                List executeList = (List)executeObj;
                if (executeList == null || executeList.size() == 0) {continue;}

                //入库单明细 warehouseInDetailMap
                //界面上 model_code := 'warehouseInDetail' 中获得
                String parentId = (String)warehouseInDetailMap.get("parentId");
                String productId = (String)warehouseInDetailMap.get("productId");
                String detailId = (String)warehouseInDetailMap.get("id");
                //批次号
                String code = (String)warehouseInDetailMap.get("code");

                //入库执行明细 executeMap
                // 界面上 model_code := 'warehouseInExecutorByAddExecute' 中获得
                for (int i = 0; i < executeList.size(); i++) {
                    Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);
                    //入库货位id warehouseId
                    String warehouseId = (String)executeMap.get("warehouseId");
                    //入库数量 count
                    String count = (String)executeMap.get("count");

                    BigDecimal count_Big = BigDecimal.valueOf(0D);
                    if (count != null && count.trim().length() > 0) {
                        try {
                            count_Big = new BigDecimal(count);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    //入库操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //货位批次号
                    inObject.setCode(code);
                    //产品ID
                    inObject.setProductId(productId);
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseId);
                    String msgStr = warehouseProductService.inStockCount(inObject, count_Big, cuser, companyId);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                    } else {
                        WarehouseInExecute execute = new WarehouseInExecute();
                        execute.setDetailId(detailId);
                        execute.setWarehouseId(warehouseId);
                        execute.setExecutorId(cuser);
                        execute.setCount(count_Big);
                        execute.setCuser(cuser);
                        warehouseInExecuteService.save(execute);
                    }
                }

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
                warehouseInDetailService.updateStateWarehouseInDetail(detailList);
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
    @Transactional
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

        //根据入库单明细id-获取该入库单明细中-所有入库执行List
        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("executorId", cuser);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<WarehouseInExecute> executeList = warehouseInExecuteService.findWarehouseInExecuteList(findMap);
        if (executeList == null || executeList.size() == 0) {return model;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            //A. 入库执行明细-库存数量退回
            for (int i = 0; i < executeList.size(); i++) {
                WarehouseInExecute execute = executeList.get(i);

                //入库数量 count
                if (execute.getCount() == null) {continue;}

                //入库操作
                WarehouseProduct inObject = new WarehouseProduct();
                //货位批次号
                inObject.setCode(detail.getCode());
                //产品ID
                inObject.setProductId(detail.getProductId());
                //(实际)货位ID
                inObject.setWarehouseId(execute.getWarehouseId());

                //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                double count = -1 * execute.getCount().doubleValue();
                //(修改库存数量)退回已经入库数量
                String msgStr = warehouseProductService.inStockCount(inObject, BigDecimal.valueOf(count), cuser, companyId);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                }
            }

            if (msgBuf.toString().trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgBuf.toString());
                return model;
            } else {
                //B. 修改入库执行表
                for (int i = 0; i < executeList.size(); i++) {
                    WarehouseInExecute execute = executeList.get(i);
                    //isdisable: 是否启用(0:已禁用 1:启用)
                    execute.setIsdisable("0");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    if (execute.getRemark() == null) {
                        execute.setRemark("退单原因:"+remark+" 操作时间："+ dateFormat.format(new Date()));
                    } else {
                        execute.setRemark(execute.getRemark()+"  退单原因:"+remark+" 操作时间："+ dateFormat.format(new Date()));
                    }
                    warehouseInExecuteService.update(execute);
                }

                //C. 修改入库单明细状态
                //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                detail.setState("0");
                warehouseInDetailService.update(detail);

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
                WarehouseIn parent = new WarehouseIn();
                parent.setId(detail.getParentId());
                //入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消) --忽视明细状态(-1:已取消)
                warehouseInDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

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
    @PostMapping("/warehouseInExecute/updateWarehouseInExecute ")
    @Transactional
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
                BigDecimal afterCount_big = new BigDecimal(afterCount);
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
            BigDecimal count = BigDecimal.valueOf(after.doubleValue() - before.doubleValue());
            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, cuser, companyId);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

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
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

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
    @Transactional
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
            BigDecimal count = BigDecimal.valueOf(-1 * executeCountount.doubleValue());
            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, cuser, companyId);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

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
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

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

    /**
     * (退单)取消入库单执行-(退回整个入库单)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
//    @PostMapping("/warehouseInExecute/updateCancelWarehouseInExecute")
//    @Transactional
//    public ResultModel updateCancelWarehouseInExecute() throws Exception {
//        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//
//        PageData pageData = HttpUtils.parsePageData();
//        String parentId = pageData.getString("parentId");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库单id为空或空字符串！");
//            return model;
//        }
//
//        String remark = pageData.getString("remark");
//        if (remark == null || remark.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
//            return model;
//        }
//
//        //根据当前入库单id-获取当前入库单明细id-入库执行数量汇总
//        Map<String, BigDecimal> mapExecute = warehouseInExecuteService.findExecuteCountByParentId(parentId);
//        //判断当前入库单明细-货品是否部分入库
//        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//        if (detailList != null && detailList.size() > 0) {
//            for (WarehouseInDetail detail : detailList) {
//                String dtl_id = detail.getId();
//                if (mapExecute != null && mapExecute.get(dtl_id) != null && mapExecute.get(dtl_id).doubleValue() != 0D) {
//                    model.putCode(Integer.valueOf(1));
//                    model.putMsg("入库单明细货品已经部分入库，该入库单不可整单(退单)，请核对后再次操作！");
//                    return model;
//                }
//            }
//        }
//
//        //1. 修改入库单明细状态
//        PageData mapData = new PageData();
//        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//        mapData.put("state", "0");
//        mapData.put("parentId", parentId);
//        warehouseInDetailService.updateStateByDetail(mapData);
//
//        //2.修改入库单状态
//        WarehouseIn warehouseIn = new WarehouseIn();
//        //状态(0:未完成 1:已完成 -1:已取消)
//        warehouseIn.setState("0");
//        warehouseIn.setRemark(remark);
//        warehouseInService.update(warehouseIn);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
