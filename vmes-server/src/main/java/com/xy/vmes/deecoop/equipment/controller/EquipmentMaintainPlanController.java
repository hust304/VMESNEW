package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.EquipmentMaintain;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.EquipmentMaintainPlanService;

import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
import com.xy.vmes.service.EquipmentMaintainService;
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

import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_equipment_maintain_plan:设备保养计划Controller
* @author 陈刚 自动生成
* @date 2019-07-25
*/
@RestController
@Slf4j
public class EquipmentMaintainPlanController {
    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainPlanController.class);

    @Autowired
    private EquipmentMaintainPlanService maintainPlanService;
    @Autowired
    private EquipmentMaintainPlanToolsService maintainPlanToolsService;
    @Autowired
    private EquipmentMaintainService maintainService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-25
    */
    @PostMapping("/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan")
    public ResultModel listPageEquipmentMaintainPlans() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = maintainPlanService.listPageEquipmentMaintainPlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/listPageEquipmentMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取设备保养计划-系统计划
    @PostMapping("/equipment/equipmentMaintainPlan/findSysPeriodTypeOption")
    public ResultModel findSysPeriodTypeOption() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/findSysPeriodTypeOption 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        //计划开始日期 beginPlan (yyyy-MM-dd)
        String beginPlanStr = pd.getString("beginPlan");
        if (beginPlanStr == null || beginPlanStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("计划开始日期为空或空字符串！");
            return model;
        }
        Date beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);

        Calendar calendar = Calendar.getInstance();
        List<Map<String, String>> optionList = new ArrayList<>();

        //{label:'每天', value:'everDay'}
        Map<String, String> optionMap_1 = new HashMap<>();
        optionMap_1.put("label", "每天");
        optionMap_1.put("value", "everDay");
        optionList.add(optionMap_1);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //{label:'每周星期几', value:'dayOfWeek'},
        calendar.setTime(beginPlan);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeekStr = Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(dayOfWeek));
        Map<String, String> optionMap_2 = new HashMap<>();
        optionMap_2.put("label", "每周"+dayOfWeekStr);
        optionMap_2.put("value", "dayOfWeek");
        optionList.add(optionMap_2);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //{label:'每月第几个星期几', value:'weekOfMonth'},
        calendar = Calendar.getInstance();
        calendar.setTime(beginPlan);

        //当前月第几周
        int weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //当前日期星期几
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String tempStr = "每月{0}个{1}";
        String sysPeriodTypeName = MessageFormat.format(tempStr,
                Common.SYS_WEEK_WEEKINMONTH.get(Integer.valueOf(weekInMonth)),
                Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(dayOfWeek)));
        Map<String, String> optionMap_3 = new HashMap<>();
        optionMap_3.put("label", sysPeriodTypeName);
        optionMap_3.put("value", "weekOfMonth");
        optionList.add(optionMap_3);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //{label:'每年某月某日', value:'dayOfYear'},
        String dayOfYearStr = DateFormat.date2String(beginPlan, "MM月dd日");
        Map<String, String> optionMap_4 = new HashMap<>();
        optionMap_4.put("label", "每年" + dayOfYearStr);
        optionMap_4.put("value", "dayOfYear");
        optionList.add(optionMap_4);

        //{label:'工作日[周1-周5]', value:'workDay'},
        Map<String, String> optionMap_5 = new HashMap<>();
        optionMap_5.put("label", "工作日[周1-周5]");
        optionMap_5.put("value", "workDay");
        optionList.add(optionMap_5);

        //{label:'自定义周期', value:'customPeriod'},
        Map<String, String> optionMap_6 = new HashMap<>();
        optionMap_6.put("label", "自定义周期");
        optionMap_6.put("value", "customPeriod");
        optionList.add(optionMap_6);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        model.put("options", optionList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/findSysPeriodTypeOption 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //(保养计划id,设备id,保养内容id) 是否存在计划
    @PostMapping("/equipment/equipmentMaintainPlan/findIsExistByEquipmentConten")
    public ResultModel findIsExistByEquipmentConten() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/findIsExistByEquipmentConten 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String id = pd.getString("id");
        String equipmentId = pd.getString("equipmentId");
        String code = pd.getString("code");
        String name = pd.getString("name");
        String maintainContentId = pd.getString("maintainContentId");
        String maintainContent = pd.getString("maintainContent");

        if (maintainPlanService.isExistByEquipmentConten(id, equipmentId, maintainContentId)) {
            String msgTemp = "设备编码:{0} 设备名称:{1} 保养内容:{2} 该设备保养计划系统已经存在！";
            String msgStr = MessageFormat.format(msgTemp,
                    code,
                    name,
                    maintainContent);
            model.put("existEquipmentConten", msgStr);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/findIsExistByEquipmentConten 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备保养计划(自定义计划)
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/addMaintainPlanByCustom")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMaintainPlanByCustom() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlanByCustom 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String eqptJsonStr = pageData.getString("eqptJsonStr");
        if (eqptJsonStr == null || eqptJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一项设备！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(eqptJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //计划对象 <EquipmentMaintainPlan>
        EquipmentMaintainPlan planObject = (EquipmentMaintainPlan) HttpUtils.pageData2Entity(pageData, new EquipmentMaintainPlan());
        planObject.setCompanyId(companyId);

        //添加设备保养计划
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("planObject", planObject);
        valueMap.put("eqptJsonMapList", jsonMapList);
        maintainPlanService.addMaintainPlan(valueMap);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlanByCustom 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备保养计划(周期计划)
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/addMaintainPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMaintainPlan() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //计划开始日期 beginPlan
        String beginPlanStr = pageData.getString("beginPlan");
        Date beginPlan = null;
        if (beginPlanStr != null && beginPlanStr.trim().length() > 0) {
            beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        //计划结束日期 endPlan
        String endPlanStr = pageData.getString("endPlan");
        Date endPlan = null;
        if (endPlanStr != null && endPlanStr.trim().length() > 0) {
            endPlan = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //计划对象 <EquipmentMaintainPlan>
        EquipmentMaintainPlan planObject = (EquipmentMaintainPlan) HttpUtils.pageData2Entity(pageData, new EquipmentMaintainPlan());
        planObject.setBeginPlan(beginPlan);
        planObject.setEndPlan(endPlan);
        planObject.setCompanyId(companyId);

        String eqptJsonStr = pageData.getString("eqptJsonStr");
        if (eqptJsonStr == null || eqptJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一项设备！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(eqptJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //调整保养计划对象(周期计划)
        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        //设备保养方式: 7ef6384e92a343ccb839112a5d59b2fe (vmes_dictionary.id) 设备保养计划(模块)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(planObject.getModeId())) {
            maintainPlanToolsService.adjustMaintainPlanByPeriod(planObject);
        }

        //添加设备保养计划
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("planObject", planObject);
        valueMap.put("eqptJsonMapList", jsonMapList);
        maintainPlanService.addMaintainPlan(valueMap);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/addMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 修改-设备保养计划(自定义计划)
     * @author 陈刚
     * @date 2019-08-06
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/updateMaintainPlanByCustom")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateMaintainPlanByCustom() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/updateMaintainPlanByCustom 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养计划id为空或空字符串！");
            return model;
        }

        String maintainDateStr = pageData.getString("maintainDateStr");
        if (maintainDateStr == null || maintainDateStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("计划保养时间为空或空字符串！");
            return model;
        }

        EquipmentMaintainPlan editPlan = new EquipmentMaintainPlan();
        editPlan.setId(id);

        Date maintainDate = DateFormat.dateString2Date(maintainDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        editPlan.setMaintainDate(maintainDate);

        maintainPlanService.update(editPlan);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/updateMaintainPlanByCustom 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备保养计划(周期计划)
     * @author 陈刚
     * @date 2019-08-06
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/updateMaintainPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateMaintainPlan() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/updateMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //计划开始日期 beginPlan
        String beginPlanStr = pageData.getString("beginPlan");
        Date beginPlan = null;
        if (beginPlanStr != null && beginPlanStr.trim().length() > 0) {
            beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        //计划结束日期 endPlan
        String endPlanStr = pageData.getString("endPlan");
        Date endPlan = null;
        if (endPlanStr != null && endPlanStr.trim().length() > 0) {
            endPlan = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //计划对象 <EquipmentMaintainPlan>
        EquipmentMaintainPlan planObject = (EquipmentMaintainPlan) HttpUtils.pageData2Entity(pageData, new EquipmentMaintainPlan());
        planObject.setBeginPlan(beginPlan);
        planObject.setEndPlan(endPlan);
        planObject.setCompanyId(companyId);

        //调整保养计划对象(周期计划)
        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        //设备保养方式: 7ef6384e92a343ccb839112a5d59b2fe (vmes_dictionary.id) 设备保养计划(模块)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(planObject.getModeId())) {
            maintainPlanToolsService.adjustMaintainPlanByPeriod(planObject);
        }

        //获取当前计划有效的保养单
        String planId = planObject.getId();
        EquipmentMaintain maintain = null;
        try {
            PageData findMap = new PageData();
            findMap.put("planId", planId);
            //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
            findMap.put("isValidState", "1");
            maintain = maintainService.findMaintain(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //当前计划保养单id
        String planMaintainId = null;
        if (maintain != null) {
            planMaintainId = maintain.getId();
        }

        //获取当前计划全部保养单
        List<EquipmentMaintain> maintainList = new ArrayList<EquipmentMaintain>();
        try {
            PageData findMap = new PageData();
            findMap.put("planId", planId);
            maintainList = maintainService.findMaintainList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (maintainList != null && maintainList.size() > 0) {
            for (EquipmentMaintain object : maintainList) {
                String maintainId = object.getId();
                if (planMaintainId != null
                    && maintainId.equals(planMaintainId)
                ) {
                    continue;
                }

                EquipmentMaintain editMaintain = new EquipmentMaintain();
                editMaintain.setId(maintainId);
                //isdisable 是否启用(0:已禁用 1:启用)
                editMaintain.setIsdisable("0");
                maintainService.update(editMaintain);
            }
        }

        maintainPlanService.update(planObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/updateMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 逻辑删除-设备保养计划
     * 修改-设备保养计划(是否禁用状态)-(禁用)
     *
     * @author 陈刚
     * @date 2019-08-05
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainPlan/updateDisableMaintainPlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableMaintainPlan() throws Exception {
        logger.info("################/equipment/equipmentMaintainPlan/updateDisableMaintainPlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String planId = pageData.getString("planId");
        if (planId == null || planId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养计划id为空或空字符串！");
            return model;
        }

        EquipmentMaintainPlan maintainPlanEdit = new EquipmentMaintainPlan();
        maintainPlanEdit.setId(planId);
        //isdisable 是否启用(0:已禁用 1:启用)
        maintainPlanEdit.setIsdisable("0");
        maintainPlanService.update(maintainPlanEdit);

        //isdisable 是否启用(0:已禁用 1:启用)
        maintainService.updateIsdisableByPlan(planId, "0");

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainPlan/updateDisableMaintainPlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



