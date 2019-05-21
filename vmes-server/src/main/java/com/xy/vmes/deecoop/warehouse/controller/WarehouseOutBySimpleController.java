package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
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
 * 说明：vmes_warehouse_out: 简版仓库入库单Controller
 * @author 陈刚 自动生成
 * @date 2018-05-21
 */
@RestController
@Slf4j
public class WarehouseOutBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseOutBySimpleController.class);

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
    @Autowired
    private FileService fileService;

    /**
     * 新增出库单(简版仓库入库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/addWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/addWarehouseOutBySimple 执行开始 ################# ");
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
        warehouseOut.setIsSimple("Y");
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutBySimple/addWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple 执行开始 ################# ");
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
        logger.info("################/warehouse/warehouseOutBySimple/deleteWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改出库单(简版仓库出库)
     * @author 陈刚
     * @date 2018-05-21
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple 执行开始 ################# ");
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
        logger.info("################/warehouse/warehouseOutBySimple/updateWarehouseOutBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
