package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.xy.vmes.service.WarehouseOutService;
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
 * 说明：vmes_warehouse_out: 报废-简版仓库出库单
 * @author 陈刚
 * @date 2019-10-10
 */
@RestController
@Slf4j
public class WarehouseOutScrapBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseOutScrapBySimpleController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增报废出库单-简版仓库出库单
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/addWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/addWarehouseOutScrapBySimple 执行开始 ################# ");
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
        warehouseOut.setCompanyId(companyID);
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_out", "O");
        warehouseOut.setCode(code);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");

        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOut.setState("2");

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            warehouseOut.setState("3");
        }
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/addWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交报废出库单-简版仓库出库单
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/submitWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/submitWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
            return model;
        }

        WarehouseOut warehouseOutEdit = new WarehouseOut();
        warehouseOutEdit.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOutEdit.setState("3");
        warehouseOutService.update(warehouseOutEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/submitWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (撤回提交)报废出库单-简版仓库出库单
     * @author 陈刚
     * @date 2018-12-11
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/rebackSubmitWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/rebackSubmitWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
            return model;
        }

        WarehouseOut warehouseOutEdit = new WarehouseOut();
        warehouseOutEdit.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOutEdit.setState("2");
        warehouseOutService.update(warehouseOutEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/rebackSubmitWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/deleteWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/deleteWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
            return model;
        }

        //2. 删除出库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseOutDetailService.deleteByColumnMap(columnMap);

        //3. 删除出库单
        warehouseOutService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/deleteWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/updateWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/updateWarehouseOutScrapBySimple 执行开始 ################# ");
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
            model.putMsg("报废单明细Json字符串-转换成List错误！");
            return model;
        }

        //1.更新出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseOutDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
                    //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                    detail.setParentId(warehouseOut.getId());
                    detail.setCuser(warehouseOut.getCuser());
                    warehouseOutDetailService.save(detail);
                }
                else {
                    if (detail.getRemark() == null || detail.getRemark().trim().length() == 0) {
                        detail.setRemark("");
                    }
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
        logger.info("################/warehouse/warehouseOutScrapBySimple/updateWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/cancelWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/cancelWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
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
        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOut.setState("-1");
        warehouseOutService.update(warehouseOut);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/cancelWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/recoveryWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/recoveryWarehouseOutScrapBySimple 执行开始 ################# ");
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
        WarehouseOut warehouseOutEdit = new WarehouseOut();
        warehouseOutEdit.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOutEdit.setState("2");
        warehouseOutService.update(warehouseOutEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/recoveryWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核通过报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/auditPassWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/auditPassWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.auditWarehouseOutExecuteBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/auditPassWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不通过报废出库单(简版仓库出库)
     * @author 陈刚
     * @date 2019-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutScrapBySimple/auditDisagreeWarehouseOutScrapBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeWarehouseOutScrapBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutScrapBySimple/auditDisagreeWarehouseOutScrapBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        WarehouseOut warehouseOutEdit = new WarehouseOut();
        warehouseOutEdit.setId(parentId);
        warehouseOutEdit.setRemark(remark);
        //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核)
        //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
        warehouseOutEdit.setState("2");
        warehouseOutService.update(warehouseOutEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutScrapBySimple/auditDisagreeWarehouseOutScrapBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
