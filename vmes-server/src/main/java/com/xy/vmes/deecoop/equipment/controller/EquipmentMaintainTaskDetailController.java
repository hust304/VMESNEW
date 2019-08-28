package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
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

import java.math.BigDecimal;
import java.util.*;

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
    private EquipmentMaintainService maintainService;
    @Autowired
    private EquipmentMaintainTaskService maintainTaskService;
    @Autowired
    private EquipmentMaintainTaskDetailService maintainTaskDetailService;
    @Autowired
    private EquipmentMaintainTaskDetailInfoService maintainTaskDetailInfoService;
    @Autowired
    private EquipmentMaintainTaskOutDetailService maintainTaskOutDetailService;
    @Autowired
    private EquipmentMaintainTaskDetailOnOutService maintainTaskDetailOnOutService;

    @Autowired
    private WarehouseService warehouseService;
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

    //根据出库单id-获取保养任务明细
    @PostMapping("/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetailByOut")
    public ResultModel listPageMaintainTaskDetailByOut() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetailByOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainTaskDetailOnOutService.listPageMaintainTaskDetailByOut(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/listPageMaintainTaskDetailByOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

    @PostMapping("/equipment/equipmentMaintainTaskDetail/findListMaintainTaskDetailByInfo")
    public ResultModel findListMaintainTaskDetailByInfo() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/findListMaintainTaskDetailByInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainTaskDetailInfoService.findListMaintainTaskDetailByInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/findListMaintainTaskDetailByInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

        //遍历JsonMapList-根据货品属性(productGenre)-返回Map结构体
        //warehouseList: 复杂版仓库,简版仓库
        //spareList:     备件库
        Map<String, List<Map<String, String>>> valueMap = maintainTaskDetailService.findMapByProductGenre(jsonMapList);
        if (valueMap == null || valueMap.size() == 0) {return model;}

        List<Map<String, String>> warehouseList = new ArrayList<>();
        if (valueMap != null && valueMap.get("warehouseList") != null) {
            warehouseList = valueMap.get("warehouseList");
        }

        //备件库-表对象
        Warehouse warehouseSpare = null;
        List<Map<String, String>> spareList = new ArrayList<>();
        if (valueMap != null && valueMap.get("spareList") != null) {
            spareList = valueMap.get("spareList");
        }

        //系统备件库是否存在
        if (spareList != null && spareList.size() > 0) {
            try {
                //获取备件库
                PageData findMap = new PageData();
                findMap.put("companyId", companyId);
                findMap.put("name", "备件库");
                findMap.put("layer", Integer.valueOf(2));
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                warehouseSpare = warehouseService.findWarehouse(findMap);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (warehouseSpare == null) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("您所在的企业不存在(备件库)，请与管理员联系！");
                return model;
            }
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

        Map<String, Map<String, Object>> prodOutMapByAddDetail = new HashMap<String, Map<String, Object>>();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //(复杂版,简版)仓库
        if (warehouseList != null && warehouseList.size() > 0) {
            Map<String, Map<String, Object>> productByOutMap = maintainTaskDetailService.findProductMapByOut(warehouseList);

            if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                warehouseOutCreateService.createWarehouseOutByComplex(deptId,
                        deptName,
                        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyId,
                        //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:maintainReceiveOut
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
                        //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:maintainReceiveOut
                        Common.DICTIONARY_MAP.get("maintainReceiveOut"),
                        productByOutMap);
            }

            if (productByOutMap != null) {
                for (Iterator iterator = productByOutMap.keySet().iterator(); iterator.hasNext();) {
                    String mapKey = (String) iterator.next();
                    Map<String, Object> mapValue = productByOutMap.get(mapKey);
                    prodOutMapByAddDetail.put(mapKey, mapValue);
                }
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //(备件)仓库
        if (spareList != null && spareList.size() > 0) {
            Map<String, Map<String, Object>> productByOutMap = maintainTaskDetailService.findProductMapByOut(spareList);

            warehouseOutCreateService.createWarehouseOutByBySpare(deptId,
                    deptName,
                    //备件库
                    warehouseSpare.getId(),
                    cuser,
                    companyId,
                    //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:maintainReceiveOut
                    Common.DICTIONARY_MAP.get("maintainReceiveOut"),
                    productByOutMap);

            if (productByOutMap != null) {
                for (Iterator iterator = productByOutMap.keySet().iterator(); iterator.hasNext();) {
                    String mapKey = (String) iterator.next();
                    Map<String, Object> mapValue = productByOutMap.get(mapKey);
                    prodOutMapByAddDetail.put(mapKey, mapValue);
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        //添加-vmes_equipment_maintainTask_detail:设备保养任务明细表
        List<EquipmentMaintainTaskDetail> taskDetailList = maintainTaskDetailService.jsonMapList2DetailList(jsonMapList, null);
        maintainTaskDetailService.addMaintainTaskDetail(cuser,
                taskDetailList,
                prodOutMapByAddDetail);

        //修改设备保养任务状态 (0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
        EquipmentMaintainTask maintainTaskEdit = new EquipmentMaintainTask();
        maintainTaskEdit.setId(maintainTaskId);
        maintainTaskEdit.setTaskState("2");
        maintainTaskService.update(maintainTaskEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/addMaintainTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备保养单-保养任务明细
     *
     * 表字段说明(vmes_equipment_maintain):
     * 1. isdisable: 是否启用(0:已禁用 1:启用)-该字段仅用于逻辑删除
     *    该字段维护场景: 保养计划删除, 保养计划修改 (设置:0:已禁用)
     *                  保养单删除 (设置:0:已禁用)
     *                  保养单完成(报工并且已解决) (设置:0:已禁用)
     *                  定时器中生成保养单 (设置:1:启用)
     *
     * 2. is_valid_state: 保养单有效状态(1:有效 0:无效 is null 无效)-保养单队列游标(整个保养周期有且只有一行是1-任务执行完成设置0)
     *    0:无效: 当前保养任务执行完成(报工并且已解决)设置为'0'--寻找下一个最近的保养单设置为'1'
     *           当前保养任务删除设置为'0'--寻找下一个最近的保养单设置为'1'
     *    1:有效: 定时器中保养计划无保养单时默认设置'1'--当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *    该字段维护场景:
     *      0:无效: 保养任务执行完成, 当前保养任务删除
     *      1:有效: 定时器中保养计划无保养单时默认设置'1'
     *              当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *              当前保养任务删除寻找下一个最近的保养单设置为'1'
     *
     * @author 陈刚
     * @date 2019-07-01
     */
    @PostMapping("/equipment/equipmentMaintainTaskDetail/updateMaintainTaskDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateMaintainTaskDetail() throws Exception {
        logger.info("################/equipment/equipmentMaintainTaskDetail/updateMaintainTaskDetail 执行开始 ################# ");
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
        String maintainTaskId = pageData.getString("maintainTaskId");
        if (maintainTaskId == null || maintainTaskId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养任务id为空或空字符串！");
            return model;
        }
        //选择退库方式(1:生成退库单 2:退回虚拟库)
        String retreatType = pageData.getString("retreatType");
        if (retreatType == null || retreatType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退库方式为空！");
            return model;
        }

        String maintainTaskJson = pageData.getString("maintainTaskJson");
        Map<String, String> maintainTaskMap = (Map<String, String>) YvanUtil.jsonToMap(maintainTaskJson);
        if (maintainTaskMap == null || maintainTaskMap.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养任务Json字符串-转换成Map错误！");
            return model;
        }

        //报工结果:任务执行结果(0:未解决 1:已解决)
        String taskResult = maintainTaskMap.get("taskResult");
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

        try {
            //保养任务明细追加货品(虚拟库中追加货品)-货品从虚拟库中(出库) addJsonMapList
            if (addJsonMapList.size() > 0) {
                String msgStr = new String();
                Map<String, Map<String, Object>> productByOutMap = maintainTaskDetailService.findProductMapByOut(addJsonMapList);

                //虚拟库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                warehouseOutCreateService.createWarehouseOutByVirtual(deptId,
                        deptName,
                        //其他:deptOther:a42f32ef9d39476e932e1e30b77fefbb Common.DICTIONARY_MAP
                        Common.DICTIONARY_MAP.get("deptOther"),
                        cuser,
                        companyId,
                        //8bcbc84893cf46daabbd2522bee482ad 保养领料出库:maintainReceiveOut
                        Common.DICTIONARY_MAP.get("maintainReceiveOut"),
                        productByOutMap);
                if (msgStr.trim().length() > 0) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg(msgStr);
                    return model;
                }

                //添加-vmes_equipment_maintainTask_detail:设备保养任务明细表
                List<EquipmentMaintainTaskDetail> taskDetailList = maintainTaskDetailService.jsonMapList2DetailList(addJsonMapList, null);
                maintainTaskDetailService.addMaintainTaskDetail(cuser,
                        taskDetailList,
                        productByOutMap);
            }

            ///////////////////////////////////////////////////////////////////////////////
            //修改保养任务明细-生成入库单 editJsonMapList
            Map<String, List<Map<String, String>>> newEditJsonMap = maintainTaskDetailService.findNewEditJsonMap(editJsonMapList);

            //notEqualZeroList: 退回数量(不等于零)List
            List<Map<String, String>> notEqualZeroList = newEditJsonMap.get("notEqualZeroList");
            if (notEqualZeroList != null && notEqualZeroList.size() > 0) {
                Map<String, Map<String, Object>> businessProdOutMapByEditDetail = new HashMap<String, Map<String, Object>>();

                //遍历JsonMapList-根据货品属性(productGenre)-返回Map结构体
                //warehouseList: 复杂版仓库,简版仓库
                //spareList:     备件库
                Map<String, List<Map<String, String>>> valueMap = maintainTaskDetailService.findMapByProductGenre(notEqualZeroList);

                List<Map<String, String>> warehouseList = new ArrayList<>();
                if (valueMap != null && valueMap.get("warehouseList") != null) {
                    warehouseList = valueMap.get("warehouseList");
                }

                //备件库-表对象
                List<Map<String, String>> spareList = new ArrayList<>();
                if (valueMap != null && valueMap.get("spareList") != null) {
                    spareList = valueMap.get("spareList");
                }

                //复杂版仓库,简版仓库////////////////////////////////////////////////////////////////////////////////////////////////
                //retreatType 退库方式(1:生成退库单 2:退回虚拟库)
                if ("1".equals(retreatType)) {
                    if (warehouseList.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                        Map<String, Map<String, Object>> businessByInMap = maintainTaskDetailService.findBusinessProducMapByIn(warehouseList);

                        //退库方式:1:生成退库单: (生成复杂版入库单)
                        //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                        warehouseInCreateService.createWarehouseInBusinessByComplex(deptId,
                                deptName,
                                //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                                Common.DICTIONARY_MAP.get("warehouseEntity"),
                                cuser,
                                companyId,
                                //d9c9eb85db0d4c8faa09ddc2b8173859 保养领料退回入库:maintainRetreatIn
                                Common.DICTIONARY_MAP.get("maintainRetreatIn"),
                                businessByInMap);

                        if (businessByInMap != null) {
                            for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                                String mapKey = (String) iterator.next();
                                Map<String, Object> mapValue = businessByInMap.get(mapKey);
                                businessProdOutMapByEditDetail.put(mapKey, mapValue);
                            }
                        }
                    } else if (warehouseList.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
                        Map<String, Map<String, Object>> businessByInMap = maintainTaskDetailService.findBusinessProducMapByIn(warehouseList);

                        //退库方式:1:生成退库单: (生成简版入库单)
                        //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                        warehouseInCreateService.createWarehouseInBusinessBySimple(deptId,
                                deptName,
                                //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                                Common.DICTIONARY_MAP.get("warehouseEntity"),
                                cuser,
                                companyId,
                                //d9c9eb85db0d4c8faa09ddc2b8173859 保养领料退回入库:maintainRetreatIn
                                Common.DICTIONARY_MAP.get("maintainRetreatIn"),
                                businessByInMap);

                        if (businessByInMap != null) {
                            for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                                String mapKey = (String) iterator.next();
                                Map<String, Object> mapValue = businessByInMap.get(mapKey);
                                businessProdOutMapByEditDetail.put(mapKey, mapValue);
                            }
                        }
                    }

                    //备件库////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spareList.size() > 0) {
                        Warehouse warehouseSpare = null;
                        try {
                            //获取备件库
                            PageData findMap = new PageData();
                            findMap.put("companyId", companyId);
                            findMap.put("name", "备件库");
                            findMap.put("layer", Integer.valueOf(2));
                            //是否启用(0:已禁用 1:启用)
                            findMap.put("isdisable", "1");
                            findMap.put("mapSize", Integer.valueOf(findMap.size()));
                            warehouseSpare = warehouseService.findWarehouse(findMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (warehouseSpare == null) {
                            throw new ApplicationException("您所在的企业不存在(备件库)，请与管理员联系！");
                        }

                        Map<String, Map<String, Object>> businessByInMap = maintainTaskDetailService.findBusinessProducMapByIn(spareList);

                        //(备件库)入库单
                        warehouseInCreateService.createWarehouseInBusinessBySpare(deptId,
                                deptName,
                                //备件库
                                warehouseSpare.getId(),
                                cuser,
                                companyId,
                                //d9c9eb85db0d4c8faa09ddc2b8173859 保养领料退回入库:maintainRetreatIn
                                Common.DICTIONARY_MAP.get("maintainRetreatIn"),
                                businessByInMap);

                        if (businessByInMap != null) {
                            for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                                String mapKey = (String) iterator.next();
                                Map<String, Object> mapValue = businessByInMap.get(mapKey);
                                businessProdOutMapByEditDetail.put(mapKey, mapValue);
                            }
                        }
                    }
                //虚拟库////////////////////////////////////////////////////////////////////////////////////////////////
                } else if ("2".equals(retreatType)) {
                    Map<String, Map<String, Object>> businessByInMap = maintainTaskDetailService.findBusinessProducMapByIn(notEqualZeroList);

                    //退库方式:2:退回虚拟库-(生成虚拟库入库单)
                    warehouseInCreateService.createWarehouseInBusinessByVirtual(deptId,
                            deptName,
                            //其他:deptOther:a42f32ef9d39476e932e1e30b77fefbb Common.DICTIONARY_MAP
                            Common.DICTIONARY_MAP.get("deptOther"),
                            "其他",
                            cuser,
                            companyId,
                            //d9c9eb85db0d4c8faa09ddc2b8173859 保养领料退回入库:maintainRetreatIn
                            Common.DICTIONARY_MAP.get("maintainRetreatIn"),
                            businessByInMap);

                    if (businessByInMap != null) {
                        for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                            String mapKey = (String) iterator.next();
                            Map<String, Object> mapValue = businessByInMap.get(mapKey);
                            businessProdOutMapByEditDetail.put(mapKey, mapValue);
                        }
                    }
                }

                //(保养任务id)-保养任务明细(领料货品明细)
                for (Map<String, String> objectMap : notEqualZeroList) {
                    EquipmentMaintainTaskDetail detailEdit = new EquipmentMaintainTaskDetail();

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
                    detailEdit.setRetreatCount(retreatCount);

                    if (businessProdOutMapByEditDetail != null && businessProdOutMapByEditDetail.get(id) != null) {
                        Map<String, Object> producValueMap = businessProdOutMapByEditDetail.get(id);

                        //inDtlId:   入库明细id
                        String inDtlId = (String)producValueMap.get("inDtlId");
                        detailEdit.setInDtlId(inDtlId);
                        //inCount:   入库数量
                        BigDecimal inCount = (BigDecimal)producValueMap.get("inCount");
                        detailEdit.setInCount(inCount);
                    }

                    //retreatType 退库方式(1:生成退库单 2:退回虚拟库)
                    detailEdit.setRetreatType(retreatType);

                    maintainTaskDetailService.update(detailEdit);
                }
            }

            //equalZeroList:    退回数量(等于零)List
            List<Map<String, String>> equalZeroList = newEditJsonMap.get("equalZeroList");
            if (equalZeroList != null && equalZeroList.size() > 0) {
                for (Map<String, String> objectMap : equalZeroList) {
                    EquipmentMaintainTaskDetail detailEdit = new EquipmentMaintainTaskDetail();

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
                    detailEdit.setRetreatCount(retreatCount);

                    maintainTaskDetailService.update(detailEdit);
                }
            }
            ///////////////////////////////////////////////////////////////////////////////
            //修改保养任务单状态
            EquipmentMaintainTask maintainTaskEidt = new EquipmentMaintainTask();
            maintainTaskEidt.setId(maintainTaskId);
            //报工结果:任务执行结果(0:未解决 1:已解决)
            maintainTaskEidt.setTaskResult(taskResult);
            if (maintainTaskMap != null && maintainTaskMap.get("remark") != null) {
                maintainTaskEidt.setRemark(maintainTaskMap.get("remark"));
            }
            //taskState 任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
            maintainTaskEidt.setTaskState("3");
            //endTime 任务结束时间
            maintainTaskEidt.setEndTime(new Date());
            maintainTaskService.update(maintainTaskEidt);

            //修改设备保养单状态
            EquipmentMaintainTask maintainTask = maintainTaskService.findMaintainTaskById(maintainTaskId);

            //获取当前保养单-保养计划id
            String planId = null;
            String maintainId = null;
            if (maintainTask != null) {
                EquipmentMaintain maintain = maintainService.findMaintainById(maintainTask.getMaintainId());
                if (maintain != null) {maintainId = maintain.getId();}
                if (maintain != null && maintain.getPlanId() != null && maintain.getPlanId().trim().length() > 0) {
                    planId = maintain.getPlanId().trim();
                }
            }

            //taskResult:报工结果:任务执行结果(0:未解决 1:已解决)
            if ("1".equals(taskResult) && maintainId != null && maintainId.trim().length() > 0) {
                //报工结果:任务执行结果:1:已解决
                    EquipmentMaintain maintainEdit = new EquipmentMaintain();
                    maintainEdit.setId(maintainId);
                    //equipmentState 设备状态(1:待保养 2:保养中 3:已完成)
                    maintainEdit.setEquipmentState("3");
                    //完成维修时间 endTime
                    maintainEdit.setEndTime(new Date());

                    //isdisable 是否启用(0:已禁用 1:启用)
                    maintainEdit.setIsdisable("0");
                    //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
                    maintainEdit.setIsValidState("0");
                    maintainService.update(maintainEdit);

                    //查询下一个保养单-根据该保养单得到保养计划
                    if (planId != null && planId.trim().length() > 0) {
                        EquipmentMaintain nextMaintain = maintainService.findNextMaintainByPeriod(planId);
                        if (nextMaintain != null) {
                            //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
                            nextMaintain.setIsValidState("1");
                            maintainService.update(nextMaintain);
                        }
                    }
            } else if ("0".equals(taskResult) && maintainId != null && maintainId.trim().length() > 0) {
                //报工结果:任务执行结果:0:未解决
                EquipmentMaintain maintainEdit = new EquipmentMaintain();
                maintainEdit.setId(maintainId);
                //equipmentState 设备状态(1:待保养 2:保养中 3:已完成)
                maintainEdit.setEquipmentState("1");
                maintainService.update(maintainEdit);
            }

        } catch (ApplicationException appExc) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(appExc.getMessage());
        } catch (Exception exc) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(exc.getMessage());
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainTaskDetail/updateMaintainTaskDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}

