package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.EquipmentRepairTask;
import com.xy.vmes.entity.EquipmentRepairTaskDetail;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_repairTask_detail:设备维修任务明细表Controller
* @author 陈刚 自动生成
* @date 2019-07-01
*/
@RestController
@Slf4j
public class EquipmentRepairTaskDetailController {
    private Logger logger = LoggerFactory.getLogger(EquipmentRepairTaskDetailController.class);

    @Autowired
    private EquipmentRepairTaskService repairTaskService;
    @Autowired
    private EquipmentRepairTaskDetailService repairTaskDetailService;
    @Autowired
    private EquipmentRepairTaskOutDetailService repairTaskOutDetailService;

    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-01
    */
    @PostMapping("/equipment/equipmentRepairTaskDetail/listPageRepairTaskDetail")
    public ResultModel listPageRepairTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentRepairTaskDetail/listPageRepairTaskDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = repairTaskDetailService.listPageRepairTaskDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTaskDetail/listPageRepairTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2019-07-01
     */
    @PostMapping("/equipment/equipmentRepairTaskDetail/findListTaskDetailByOutDetail")
    public ResultModel findListTaskDetailByOutDetail() throws Exception {
        logger.info("################/equipment/equipmentRepairTaskDetail/findListTaskDetailByOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentRepairTaskDetailByOutDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = repairTaskOutDetailService.findTaskDetailByOutDetail(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTaskDetail/findListTaskDetailByOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备维修单-维修任务明细
     * @author 陈刚
     * @date 2019-07-01
     */
    @PostMapping("/equipment/equipmentRepairTaskDetail/addRepairTaskDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addRepairTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentRepairTaskDetail/addRepairTaskDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //创建(复杂版,简版)仓库-出库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String cuser = pageData.getString("cuser");
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }
        //创建出库单
        String deptId = pageData.getString("deptId");
        if (deptId == null || deptId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("部门id为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //业务相关参数////////////////////////////////////////////////////////////////////////////////////////////////////////
        String repairTaskId = pageData.getString("repairTaskId");
        if (repairTaskId == null || repairTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("维修任务id为空或空字符串！");
            return model;
        }
        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一项货品！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        //部门id 获取部门名称
        String deptName = new String();
        Department department = departmentService.findDepartmentById(deptId);
        if (department != null && department.getName() != null) {
            deptName = department.getName().trim();
        }

        String msgStr = new String();
        Map<String, Map<String, Object>> productByOutMap = repairTaskDetailService.findProductMapByOut(jsonMapList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseOutCreateService.createWarehouseOutByComplex(deptId,
                    deptName,
                    cuser,
                    companyId,
                    //fa51ae2e17a9409d822fc4c9192d652c 维保领料出库:repairReceiveOut
                    Common.DICTIONARY_MAP.get("repairReceiveOut"),
                    productByOutMap);


        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseOutCreateService.createWarehouseOutBySimple(deptId,
                    deptName,
                    cuser,
                    companyId,
                    //fa51ae2e17a9409d822fc4c9192d652c 维保领料出库:repairReceiveOut
                    Common.DICTIONARY_MAP.get("repairReceiveOut"),
                    productByOutMap);
        }



        //添加-vmes_equipment_repairTask_detail:设备维修任务明细表
        List<EquipmentRepairTaskDetail> taskDetailList = repairTaskDetailService.jsonMapList2DetailList(jsonMapList, null);
        repairTaskDetailService.addRepairTaskDetail(cuser,
                taskDetailList,
                productByOutMap);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTaskDetail/addRepairTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备维修单-维修任务明细
     * @author 陈刚
     * @date 2019-07-01
     */
    @PostMapping("/equipment/equipmentRepairTaskDetail/updateRepairTaskDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateRepairTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentRepairTaskDetail/updateRepairTaskDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //创建(复杂版,简版)仓库-出库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String cuser = pageData.getString("cuser");
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }
        //创建出库单
        String deptId = pageData.getString("deptId");
        if (deptId == null || deptId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("部门id为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //部门id 获取部门名称
        String deptName = new String();
        Department department = departmentService.findDepartmentById(deptId);
        if (department != null && department.getName() != null) {
            deptName = department.getName().trim();
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        //业务相关参数////////////////////////////////////////////////////////////////////////////////////////////////////////
        String repairTaskId = pageData.getString("repairTaskId");
        if (repairTaskId == null || repairTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("维修任务id为空或空字符串！");
            return model;
        }
        //选择退库方式(1:生成退库单 2:退回虚拟库)
        String retreatType = pageData.getString("retreatType");
        if (retreatType == null || retreatType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退库方式为空！");
            return model;
        }

        String repairTaskJson = pageData.getString("repairTaskJson");
        Map<String, String> repairTaskMap = (Map<String, String>) YvanUtil.jsonToMap(repairTaskJson);
        if (repairTaskMap == null || repairTaskMap.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("维修任务Json字符串-转换成Map错误！");
            return model;
        }

        String taskResult = repairTaskMap.get("taskResult");
        if (taskResult == null || taskResult.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报工结果为空或空字符串！！");
            return model;
        }

        List<Map<String, String>> addJsonMapList = new ArrayList<Map<String, String>>();
        String detailAddJson = pageData.getString("detailAddJson");
        if (detailAddJson != null && detailAddJson.trim().length() > 0) {
            addJsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(detailAddJson);
            if (addJsonMapList == null || addJsonMapList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("明细添加Json字符串-转换成List错误！");
                return model;
            }
        }

        List<Map<String, String>> editJsonMapList = new ArrayList<Map<String, String>>();
        String detailEditJson = pageData.getString("detailEditJson");
        if (detailEditJson != null && detailEditJson.trim().length() > 0) {
            editJsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(detailEditJson);
            if (editJsonMapList == null || editJsonMapList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("明细修改Json字符串-转换成List错误！");
                return model;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////
        //维修任务明细追加货品(虚拟库中追加货品)-货品从虚拟库中(出库) addJsonMapList
        if (addJsonMapList.size() > 0) {
            String msgStr = new String();
            Map<String, Map<String, Object>> productByOutMap = repairTaskDetailService.findProductMapByOut(addJsonMapList);

            //虚拟库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseOutCreateService.createWarehouseOutByVirtual(deptId,
                    deptName,
                    Common.DICTIONARY_MAP.get("deptRepair"),
                    cuser,
                    companyId,
                    //fa51ae2e17a9409d822fc4c9192d652c 维保领料出库:repairReceiveOut
                    Common.DICTIONARY_MAP.get("repairReceiveOut"),
                    productByOutMap);
            if (msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //添加-vmes_equipment_repairTask_detail:设备维修任务明细表
            List<EquipmentRepairTaskDetail> taskDetailList = repairTaskDetailService.jsonMapList2DetailList(addJsonMapList, null);
            repairTaskDetailService.addRepairTaskDetail(cuser,
                    taskDetailList,
                    productByOutMap);
        }

        ///////////////////////////////////////////////////////////////////////////////
        //修改维修任务明细-生成入库单 editJsonMapList
        //遍历 editJsonMapList 将退回数量(不等于零)数据筛选出来
        List<Map<String, String>> newEditJsonMapList = repairTaskDetailService.findNewEditJsonMapList(editJsonMapList);
        if (newEditJsonMapList.size() > 0) {
            Map<String, Map<String, Object>> productByInMap = repairTaskDetailService.findProductMapByIn(newEditJsonMapList);

            //retreatType 退库方式(1:生成退库单 2:退回虚拟库)
            if ("1".equals(retreatType) && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                //退库方式:1:生成退库单: (生成复杂版入库单)
                //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                warehouseInCreateService.createWarehouseInByComplex(deptId,
                        deptName,
                        cuser,
                        companyId,
                        //维保领料退回入库:repairRetreatIn:c396683796d54b8693b522a2c0ad2793 Common.DICTIONARY_MAP
                        Common.DICTIONARY_MAP.get("repairRetreatIn"),
                        productByInMap);

            } else if ("1".equals(retreatType) && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
                //退库方式:1:生成退库单: (生成简版入库单)
                //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                warehouseInCreateService.createWarehouseInBySimple(deptId,
                        deptName,
                        cuser,
                        companyId,
                        //维保领料退回入库:repairRetreatIn:c396683796d54b8693b522a2c0ad2793 Common.DICTIONARY_MAP
                        Common.DICTIONARY_MAP.get("repairRetreatIn"),
                        productByInMap);

            } else if ("2".equals(retreatType)) {
                //退库方式:2:退回虚拟库-(生成虚拟库入库单)
                warehouseInCreateService.createWarehouseInByVirtual(deptId,
                        deptName,
                        //维保:deptRepair:a42f32ef9d39476e932e1e30b77fefbb Common.DICTIONARY_MAP
                        Common.DICTIONARY_MAP.get("deptRepair"),
                        "维保",
                        cuser,
                        companyId,
                        //维保领料退回入库:repairRetreatIn:c396683796d54b8693b522a2c0ad2793 Common.DICTIONARY_MAP
                        Common.DICTIONARY_MAP.get("repairRetreatIn"),
                        productByInMap);
            }

            //(维修任务id)-维修任务明细(领料货品明细)
            for (Map<String, String> objectMap : newEditJsonMapList) {
                EquipmentRepairTaskDetail detailEdit = new EquipmentRepairTaskDetail();

                String id = objectMap.get("id");
                detailEdit.setId(id);

                //实际使用数量 applyCount
                BigDecimal applyCount = BigDecimal.valueOf(0D);
                if (objectMap.get("applyCount") != null) {
                    try {
                        applyCount = new BigDecimal(objectMap.get("applyCount").trim());
                        //四舍五入到2位小数
                        applyCount = applyCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                detailEdit.setApplyCount(applyCount);

                //退回数量 retreatCount := 领取数量 - 实际使用数量
                BigDecimal retreatCount = BigDecimal.valueOf(0D);
                if (objectMap.get("retreatCount") != null) {
                    try {
                        retreatCount = new BigDecimal(objectMap.get("retreatCount").trim());
                        //四舍五入到2位小数
                        retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                detailEdit.setApplyCount(retreatCount);

                String productId = objectMap.get("productId");
                Map<String, Object> producValueMap = productByInMap.get(productId);




                repairTaskDetailService.update(detailEdit);
            }
        }




        ///////////////////////////////////////////////////////////////////////////////
        //修改维修任务单状态
        EquipmentRepairTask repairTaskEidt = new EquipmentRepairTask();
        repairTaskEidt.setId(repairTaskId);
        repairTaskEidt.setTaskResult(taskResult);
        repairTaskService.update(repairTaskEidt);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentRepairTaskDetail/updateRepairTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



