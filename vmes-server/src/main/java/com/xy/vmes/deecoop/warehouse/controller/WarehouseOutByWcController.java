package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.xy.vmes.service.WarehouseOutService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_out: 文成仓库出库单Controller
 * @author 陈刚
 * @date 2019-11-11
 */
@RestController
@Slf4j
public class WarehouseOutByWcController {
    private Logger logger = LoggerFactory.getLogger(WarehouseOutByWcController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增出库单(文成企业定制)
     * @author 陈刚
     * @date 2019-11-12
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutByWc/addWarehouseOutByWc")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutByWc() throws Exception {
        logger.info("################/warehouse/warehouseOutByWc/addWarehouseOutByWc 执行开始 ################# ");
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
            model.putMsg("参数错误：Map 转 仓库对象WarehouseIn 异常！");
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
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        warehouseOut.setCompanyId(companyID);
        //出库单编号
        //String code = coderuleService.createCoder(companyID, "vmes_warehouse_out", "O");
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyID, "vmes_warehouse_out", "O", Common.CODE_RULE_LENGTH_SHORTYEAR);
        warehouseOut.setCode(code);

        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库 office:办公出库)
        warehouseOut.setWarehouseAttribute("warehouse");

        //Service (deptId) 该参数名称已经使用 -- 更改为(warehouseDeptId)
        String warehouseDeptId = pageData.getString("warehouseDeptId");
        warehouseOut.setDeptId(warehouseDeptId);
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutByWc/addWarehouseOutByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改出库单(文成企业定制)
     * @author 陈刚
     * @date 2019-11-12
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutByWc/updateWarehouseOutByWc")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutByWc() throws Exception {
        logger.info("################/warehouse/warehouseOutByWc/updateWarehouseOutByWc 执行开始 ################# ");
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
        logger.info("################/warehouse/warehouseOutByWc/updateWarehouseOutByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
