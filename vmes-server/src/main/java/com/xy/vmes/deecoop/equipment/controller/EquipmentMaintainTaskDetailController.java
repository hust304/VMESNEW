package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_maintainTask_detail:设备保养任务明细表Controller
* @author 陈刚 自动生成
* @date 2019-07-29
*/
@RestController
@Slf4j
public class EquipmentMaintainTaskDetailController {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainTaskDetailController.class);

    @Autowired
    private EquipmentMaintainTaskService maintainTaskService;
    @Autowired
    private EquipmentMaintainTaskDetailService maintainTaskDetailService;
    @Autowired
    private EquipmentMaintainTaskOutDetailService maintainTaskOutDetailService;

    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private DepartmentService departmentService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-29
    */
    @PostMapping("/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetail")
    public ResultModel listPageMaintainTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainTaskDetailService.listPageMaintainTaskDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/equipment/equipmentMaintainTaskDetail/findListTaskDetailByOutDetail")
    public ResultModel findListTaskDetailByOutDetail() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/findListTaskDetailByOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainTaskDetailService.findListTaskDetailByOutDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/findListTaskDetailByOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    //获取保养任务货品明细-是否出库执行完成
    // 根据(保养任务id)查询(vmes_equipment_maintainTask_detail)
    @PostMapping("/equipment/equipmentMaintainTaskDetail/findIsAllOutExecuteByMaintain")
    public ResultModel findIsAllOutExecuteByMaintain() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/findIsAllOutExecuteByMaintain 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String maintainTaskId = pd.getString("maintainTaskId");
        if (maintainTaskId == null || maintainTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养任务id为空或空字符串！");
            return model;
        }

        //获取保养任务货品明细-是否出库执行完成
        //true : 全部出库完成(默认值)
        //false: 一条或多条出库未完成
        model.put("isAllOut", "true");
        if (!maintainTaskOutDetailService.isAllOutExecuteMaintainTaskDetail(maintainTaskId)) {
            model.put("isAllOut", "false");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/findIsAllOutExecuteByMaintain 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备保养单-保养任务明细
     * @author 陈刚
     * @date 2019-07-29
     */
    @PostMapping("/equipment/equipmentMaintainTaskDetail/addMaintainTaskDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMaintainTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/addMaintainTaskDetail 执行开始 ################# ");
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
        String maintainTaskId = pageData.getString("maintainTaskId");
        if (maintainTaskId == null || maintainTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养任务id为空或空字符串！");
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
        Map<String, Map<String, Object>> productByOutMap = maintainTaskDetailService.findProductMapByOut(jsonMapList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseOutCreateService.createWarehouseOutByComplex(deptId,
                    deptName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:repairReceiveOut
                    Common.DICTIONARY_MAP.get("maintainReceiveOut"),
                    productByOutMap);

        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseOutCreateService.createWarehouseOutBySimple(deptId,
                    deptName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:repairReceiveOut
                    Common.DICTIONARY_MAP.get("maintainReceiveOut"),
                    productByOutMap);
        }

        //添加-vmes_equipment_maintainTask_detail:设备保养任务明细表
        List<EquipmentMaintainTaskDetail> taskDetailList = maintainTaskDetailService.jsonMapList2DetailList(jsonMapList, null);
        maintainTaskDetailService.addMaintainTaskDetail(cuser,
                taskDetailList,
                productByOutMap);

        //修改设备保养任务状态 (0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
        EquipmentMaintainTask maintainTaskEdit = new EquipmentMaintainTask();
        maintainTaskEdit.setId(maintainTaskId);
        maintainTaskEdit.setTaskState("2");
        maintainTaskService.update(maintainTaskEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/addMaintainTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
            //updateMaintainTaskDetail
}



