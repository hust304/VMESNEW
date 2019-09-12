package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.exception.ApplicationException;
import com.yvan.common.util.Common;
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

import java.util.*;

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
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private DepartmentService departmentService;

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

        //当前部门id
        String deptName = new String();
        String deptId = pageData.getString("deptId");
        if (deptId != null && deptId.trim().length() > 0) {
            Department dept = departmentService.findDepartmentById(deptId);
            if (dept != null && dept.getName() != null) {
                deptName = dept.getName().trim();
            }
        }

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

        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.mapList2DetailList(mapList);
        //获取(盘点数量-台账数量)-遍历盘点明细List<WarehouseCheckDetail>
        //
        // 返回值Map<String, List>
        //     negativeList: 负数结果集 List<WarehouseCheckDetail>
        //     positiveList: 正数结果集 List<WarehouseCheckDetail>
        Map<String, List> valueMap = warehouseCheckDetailService.findValueMapByDetailList(detailList);

        //negativeList: 负数结果集(盘点数量-台账数量) List<WarehouseCheckDetail>
        List<WarehouseCheckDetail> negativeList = new ArrayList<>();
        if (valueMap != null && valueMap.get("negativeList") != null) {
            negativeList = valueMap.get("negativeList");
        }

        //positiveList: 正数结果集(盘点数量-台账数量) List<WarehouseCheckDetail>
        List<WarehouseCheckDetail> positiveList = new ArrayList<>();
        if (valueMap != null && valueMap.get("positiveList") != null) {
            positiveList = valueMap.get("positiveList");
        }

        try {
            //positiveList: 正数结果集(盘点数量-台账数量) -- 入库单
            if (positiveList.size() > 0) {
                Map<String, Map<String, Object>> businessProdInMapByEditDetail = new HashMap<String, Map<String, Object>>();

                //生成入库单
                Map<String, Map<String, Object>> businessByInMap = warehouseCheckDetailService.findBusinessProducMapByIn(positiveList);
                //创建入库单(简版仓库)-执行时无需人工干预-系统自动执行
                warehouseInCreateService.createWarehouseInExecuteBusinessBySimple(deptId,
                        deptName,
                        //实体库:2d75e49bcb9911e884ad00163e105f05:warehouseEntity
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyId,
                        //盘点入库 4d89ccb1e64f499cbdc6409f173f5407:checkIn
                        Common.DICTIONARY_MAP.get("checkIn"),
                        businessByInMap);

                if (businessByInMap != null) {
                    for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                        String mapKey = (String) iterator.next();
                        Map<String, Object> mapValue = businessByInMap.get(mapKey);
                        businessProdInMapByEditDetail.put(mapKey, mapValue);
                    }
                }

                for (WarehouseCheckDetail detailObj : positiveList) {
                    WarehouseCheckDetail editDetail = new WarehouseCheckDetail();
                    String detailId = detailObj.getId();
                    editDetail.setId(detailObj.getId());

                    if (businessProdInMapByEditDetail != null && businessProdInMapByEditDetail.get(detailId) != null) {
                        Map<String, Object> producValueMap = businessProdInMapByEditDetail.get(detailId);

                        //inDtlId:   入库明细id
                        String inDtlId = new String();
                        if (producValueMap != null && producValueMap.get("inDtlId") != null) {
                            inDtlId = (String)producValueMap.get("inDtlId");
                        }
                        editDetail.setInDtlId(inDtlId);
                    }

                    warehouseCheckDetailService.update(editDetail);
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //negativeList: 负数结果集(盘点数量-台账数量) -- 出库单
            if (negativeList.size() > 0) {
                Map<String, Map<String, Object>> businessProdOutMapByEditDetail = new HashMap<String, Map<String, Object>>();

                Map<String, Map<String, Object>> businessByOutMap = warehouseCheckDetailService.findBusinessProducMapByOut(negativeList);
                //创建出库单(简版仓库)-执行时无需人工干预-系统自动执行
                warehouseOutCreateService.createWarehouseOutExecuteBusinessBySimple(deptId,
                        deptName,
                        //实体库:2d75e49bcb9911e884ad00163e105f05:warehouseEntity
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyId,
                        //盘点出库 55bdf3529c3c463489670a46c2651c1e:checkIn
                        Common.DICTIONARY_MAP.get("checkOut"),
                        businessByOutMap);

                if (businessByOutMap != null) {
                    for (Iterator iterator = businessByOutMap.keySet().iterator(); iterator.hasNext();) {
                        String mapKey = (String) iterator.next();
                        Map<String, Object> mapValue = businessByOutMap.get(mapKey);
                        businessProdOutMapByEditDetail.put(mapKey, mapValue);
                    }
                }

                for (WarehouseCheckDetail detailObj : negativeList) {
                    WarehouseCheckDetail editDetail = new WarehouseCheckDetail();
                    String detailId = detailObj.getId();
                    editDetail.setId(detailObj.getId());

                    if (businessProdOutMapByEditDetail != null && businessProdOutMapByEditDetail.get(detailId) != null) {
                        Map<String, Object> producValueMap = businessProdOutMapByEditDetail.get(detailId);

                        //outDtlId:   出库明细id
                        String outDtlId = new String();
                        if (producValueMap != null && producValueMap.get("outDtlId") != null) {
                            outDtlId = (String)producValueMap.get("outDtlId");
                        }
                        editDetail.setOutDtlId(outDtlId);
                    }

                    warehouseCheckDetailService.update(editDetail);
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //修改盘点单状态
            if (detailList != null && detailList.size() > 0) {
                for (WarehouseCheckDetail detailObj : detailList) {
                    WarehouseCheckDetail editDetail = new WarehouseCheckDetail();
                    editDetail.setId(detailObj.getId());
                    //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
                    editDetail.setState("3");
                    warehouseCheckDetailService.update(editDetail);
                }
            }

            //修改盘点单状态
            WarehouseCheck warehouseCheckEdit = new WarehouseCheck();
            warehouseCheckEdit.setId(parentId);
            //state:状态(0:未完成 1:已完成 -1:已取消)
            warehouseCheckEdit.setState("1");
            warehouseCheckService.update(warehouseCheckEdit);

        } catch (ApplicationException tabExc) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(tabExc.getMessage());
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/executeWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
