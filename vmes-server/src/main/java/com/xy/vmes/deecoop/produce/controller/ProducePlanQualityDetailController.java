package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.common.util.DateFormat;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：vmes_produce_plan_quality_detail:生产计划明细检验报工表 Controller
 * @author 陈刚 自动生成
 * @date 2020-02-26
 */
@RestController
@Slf4j
public class ProducePlanQualityDetailController {
    private Logger logger = LoggerFactory.getLogger(ProducePlanQualityDetailController.class);

    @Autowired
    private ProducePlanService planService;
    @Autowired
    private ProducePlanDetailService planDetailService;
    @Autowired
    private ProducePlanDetailToolService planDetailToolService;
    @Autowired
    private ProducePlanQualityDetailService planQualityDetailService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2020-02-27
     */
    @PostMapping("/produce/producePlanQualityDetail/listPageProducePlanQualityDetail")
    public ResultModel listPageProducePlanQualityDetail() throws Exception {
        logger.info("################/produce/producePlanQualityDetail/listPageProducePlanQualityDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = planQualityDetailService.listPageProducePlanQualityDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanQualityDetail/listPageProducePlanQualityDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (添加)生产计划明细(检验)报工
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlanQualityDetail/addProducePlanDetailByQuality")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addProducePlanDetailByQuality() throws Exception {
        logger.info("################/produce/producePlanQualityDetail/addProducePlanDetailByQuality 执行开始 ################# ");
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

        String deptId = pageData.getString("deptId");
        if (deptId == null || deptId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("部门id为空或空字符串！");
            return model;
        }

        //部门id 获取部门名称
        String deptName = new String();
        Department department = departmentService.findDepartmentById(deptId);
        if (department != null && department.getName() != null) {
            deptName = department.getName().trim();
        }

        String planId = pageData.getString("planId");
        if (planId == null || planId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生产计划id为空或空字符串！");
            return model;
        }

        String jsonStr = pageData.getString("jsonStr");
        if (jsonStr == null || jsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一行数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
        if(jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //创建(复杂版,简版)仓库-入库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        ProducePlan planDB = planService.findProducePlanById(planId);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加(vmes_produce_plan_quality_detail:生产计划明细检验报工表)
        List<ProducePlanQualityDetail> qualityDtlList = this.mapList2PlanQualityDetailList(jsonMapList, null);
        for (ProducePlanQualityDetail dtlObject : qualityDtlList) {
            dtlObject.setCuser(cuser);
            planQualityDetailService.save(dtlObject);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //2. 生成入库单
        Map<String, Map<String, Object>> productByInMap = planQualityDetailService.findProductMapByIn(qualityDtlList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //退库方式:1:生成退库单: (生成复杂版入库单)
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInBusinessByComplex(deptId,
                    deptName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //生产入库 2c4a104aedc046848455f5fa6e3da87c:produceIn:
                    Common.DICTIONARY_MAP.get("produceIn"),
                    null,
                    planDB.getSysCode(),
                    productByInMap);

        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //退库方式:1:生成退库单: (生成简版入库单)
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBusinessBySimple(deptId,
                    deptName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //生产入库 2c4a104aedc046848455f5fa6e3da87c:produceIn:
                    Common.DICTIONARY_MAP.get("produceIn"),
                    null,
                    planDB.getSysCode(),
                    productByInMap);
        }

        if (productByInMap != null) {
            for (Iterator iterator = productByInMap.keySet().iterator(); iterator.hasNext();) {
                //生产计划明细检验报工id (vmes_produce_plan_quality_detail:生产计划明细检验报工表)
                String mapKey_businessId = (String)iterator.next();

                if (mapKey_businessId != null) {
                    ProducePlanQualityDetail editDetail = new ProducePlanQualityDetail();
                    editDetail.setId(mapKey_businessId);

                    Map<String, Object> mapValue = productByInMap.get(mapKey_businessId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");

                    editDetail.setInDetailId(inDtlId);
                    planQualityDetailService.update(editDetail);
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 修改(生产计划明细, 生产计划)状态

        //获取系统时间 (yyyy-MM-dd)
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //获取(生产明细id,计划数量,合格数量,不合格数量)Map<String, Map<String, Object>>结构体
        Map<String, Map<String, Object>> detailMap = planDetailToolService.findProducePlanDetailMap(planId);
        for (ProducePlanQualityDetail dtlObject : qualityDtlList) {
            ProducePlanDetail editPlanDetail = new ProducePlanDetail();

            //生产计划明细id
            String planDtlId = dtlObject.getPlanDtlId();
            editPlanDetail.setId(planDtlId);

            Map<String, Object> detailValueMap = detailMap.get(planDtlId);
            if (detailValueMap != null) {
                //dtlCount: 计划数量
                BigDecimal dtlCount = (BigDecimal)detailValueMap.get("dtlCount");
                //fineCount: 合格数量
                BigDecimal fineCount = (BigDecimal)detailValueMap.get("fineCount");

                //状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
                if (dtlCount != null && fineCount != null
                    && (fineCount.doubleValue() - dtlCount.doubleValue()) >= 0
                ) {
                    editPlanDetail.setState("2");
                    //planDate 计划完成日期(yyyy-MM-dd)
                    editPlanDetail.setPlanDate(sysDate);
                } else if (dtlCount != null && fineCount != null
                    && fineCount.doubleValue() > 0
                    && (dtlCount.doubleValue() - fineCount.doubleValue()) > 0
                ) {
                    editPlanDetail.setState("1");
                }
            }
            planDetailService.update(editPlanDetail);

        }

        ProducePlan editPlan = new ProducePlan();
        editPlan.setId(planId);

        List<ProducePlanDetail> planDtlList = planDetailService.findProducePlanDetailListByParentId(planId);
        //状态 (1:未完成 2:已完成 -1:已取消)
        String planState = planDetailService.findParentStateByDetail(planDtlList);
        editPlan.setState(planState);
        //planDate 计划完成日期(yyyy-MM-dd)
        if ("2".equals(planState)) {
            editPlan.setPlanDate(sysDate);
        }

        planService.update(editPlan);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanQualityDetail/addProducePlanDetailByQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<ProducePlanQualityDetail> mapList2PlanQualityDetailList(List<Map<String, String>> mapList, List<ProducePlanQualityDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            ProducePlanQualityDetail detail = (ProducePlanQualityDetail) HttpUtils.pageData2Entity(mapObject, new ProducePlanQualityDetail());

            BigDecimal badCount = BigDecimal.valueOf(0D);
            String badCountStr = mapObject.get("badCount");
            if (badCountStr != null && badCountStr.trim().length() > 0) {
                try {
                    badCount = new BigDecimal(badCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            badCount = badCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setBadCount(badCount);

            objectList.add(detail);
        }

        return objectList;
    }

}
