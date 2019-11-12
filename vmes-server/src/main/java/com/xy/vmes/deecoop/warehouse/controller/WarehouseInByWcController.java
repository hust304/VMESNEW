package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInService;
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

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_in: 文成仓库入库单Controller
 * @author 陈刚 自动生成
 * @date 2019-11-11
 */
@RestController
@Slf4j
public class WarehouseInByWcController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInByWcController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private CoderuleService coderuleService;

    @PostMapping("/warehouse/warehouseInByWc/listPageWarehouseInByWc")
    public ResultModel listPageWarehouseInByWc() throws Exception {
        logger.info("################/warehouse/warehouseInByWc/listPageWarehouseInByWc 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInService.listPageWarehouseIn(pd, pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInByWc/listPageWarehouseInByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单(文成企业定制)
     * @author 陈刚
     * @date 2019-11-12
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInByWc/addWarehouseInByWc")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInByWc() throws Exception {
        logger.info("################/warehouse/warehouseInByWc/addWarehouseInByWc 执行开始 ################# ");
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
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_in", "I");
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
        logger.info("################/warehouse/warehouseInByWc/addWarehouseInByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单(文成企业定制)
     * @author 陈刚
     * @date 2019-11-12
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInByWc/updateWarehouseInByWc")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInByWc() throws Exception {
        logger.info("################/warehouse/warehouseInByWc/updateWarehouseInByWc 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

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
        logger.info("################/warehouse/warehouseInByWc/updateWarehouseInByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
