package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.equipment.dao.EquipmentMaintainPlanMapper;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.EquipmentMaintainPlanService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_equipment_maintain_plan:设备保养计划 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-07-25
*/
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainPlanServiceImp implements EquipmentMaintainPlanService {

    @Autowired
    private EquipmentMaintainPlanMapper equipmentMaintainPlanMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void save(EquipmentMaintainPlan object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        equipmentMaintainPlanMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public EquipmentMaintainPlan selectById(String id) throws Exception{
        return equipmentMaintainPlanMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public List<EquipmentMaintainPlan> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentMaintainPlan> warehouseCheckDetailList = equipmentMaintainPlanMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void update(EquipmentMaintainPlan object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainPlanMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void updateAll(EquipmentMaintainPlan object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainPlanMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMaintainPlanMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentMaintainPlanMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMaintainPlanMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentMaintainPlanMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    public List<EquipmentMaintainPlan> dataList(PageData pd) throws Exception{
        return equipmentMaintainPlanMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentMaintainPlanMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentMaintainPlanMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<EquipmentMaintainPlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentMaintainPlan>();
        }

        return this.dataList(pageData);
    }

    public EquipmentMaintainPlan findMaintainPlan(PageData object) throws Exception {
        List<EquipmentMaintainPlan> objectList = this.findMaintainPlanList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentMaintainPlan findMaintainPlanById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findMaintainPlan(findMap);
    }
    public List<EquipmentMaintainPlan> findMaintainPlanList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 添加设备保养计划
     * @param valueMap
     *
     * 参数说明:
     * valueMap Map<String, Object>
     * eqptJsonMapList: 设备jsonMapList List<Map<String, String>>
     * planObject: 周期计划设定 EquipmentMaintainPlan
     */
    public void addMaintainPlan(Map<String, Object> valueMap) {
        if (valueMap == null) {return;}
        //周期计划设定
        EquipmentMaintainPlan planObject = (EquipmentMaintainPlan)valueMap.get("planObject");
        if (planObject == null) {return;}
        List<Map<String, String>> jsonMapList = (List<Map<String, String>>)valueMap.get("eqptJsonMapList");
        if (jsonMapList == null || jsonMapList.size() == 0) {return;}

        //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
        String modeId = planObject.getModeId();

        //设备保养方式: 7ef6384e92a343ccb839112a5d59b2fe (vmes_dictionary.id) 设备保养计划(模块)
        //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
        //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期
        if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
            this.addMaintainPlanByPeriod(planObject, jsonMapList);
        } else if (Common.DICTIONARY_MAP.get("maintainModeCustom").equals(modeId)) {
            this.addMaintainPlanByCustom(planObject, jsonMapList);
        }


    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageEquipmentMaintainPlan(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintainPlan");
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
        String isNeedPage = pd.getString("isNeedPage");

        //添加保养计划界面使用该参数
        String type = pd.getString("type");
        if ("add".equals(type)) {
            pd.clear();
            pd.put("queryStr", "1=2");
        } else {
            String companyId = pd.getString("currentCompanyId");
            pd.put("companyId", companyId);
        }

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        for (Map<String, Object> mapObject : varList) {
            String cycleName = new String();

            //modeId 保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
            String modeId = (String)mapObject.get("modeId");
            //maintainModeCustom ee66976e1b3d453bae8839e6e9458b2f 自定义
            //maintainModePeriod 9a05a30aa81e4637b498703b14cde8b1 按周期

            if (Common.DICTIONARY_MAP.get("maintainModePeriod").equals(modeId)) {
                //sysPeriodType 重复类型 (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
                String sysPeriodType = (String)mapObject.get("sysPeriodType");
                if ("customPeriod".equals(sysPeriodType)) {
                    String periodName = (String)mapObject.get("periodName");
                    if (periodName != null && periodName.trim().length() > 0) {cycleName = periodName;}
                } else if ("everDay,dayOfWeek,weekOfMonth,dayOfYear,workDay".indexOf(sysPeriodType) != -1) {
                    String sysPeriodTypeName = (String)mapObject.get("sysPeriodTypeName");
                    if (sysPeriodTypeName != null && sysPeriodTypeName.trim().length() > 0) {cycleName = sysPeriodTypeName;}
                }
            }

            mapObject.put("cycleName", cycleName);
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 添加设备保养计划(按周期)
     *
     * @param planObject
     * @param jsonMapList
     */
    private void addMaintainPlanByPeriod(EquipmentMaintainPlan planObject, List<Map<String, String>> jsonMapList) {
        if (planObject == null) {return;}
        if (jsonMapList == null || jsonMapList.size() == 0) {return;}

        for (Map<String, String> mapObject : jsonMapList) {
            EquipmentMaintainPlan addMaintainPlan = planObject.clone();

            String equipmentId = mapObject.get("equipmentId");
            addMaintainPlan.setEquipmentId(equipmentId);
            String maintainContentId = mapObject.get("maintainContentId");
            addMaintainPlan.setMaintainContentId(maintainContentId);

            String companyId = planObject.getCompanyId();
            //sysCode 保养计划单编号(系统生成)
            //MP+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(companyId,
                    "vmes_equipment_maintain_plan",
                    "yyyyMMdd",
                    "MP");
            addMaintainPlan.setSysCode(code);

            try {
                this.save(addMaintainPlan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加设备保养计划(自定义)
     *
     * @param planObject
     * @param jsonMapList
     */
    private void addMaintainPlanByCustom(EquipmentMaintainPlan planObject, List<Map<String, String>> jsonMapList) {
        if (planObject == null) {return;}
        if (jsonMapList == null || jsonMapList.size() == 0) {return;}

        for (Map<String, String> mapObject : jsonMapList) {
            EquipmentMaintainPlan addMaintainPlan = planObject.clone();

            String equipmentId = mapObject.get("equipmentId");
            addMaintainPlan.setEquipmentId(equipmentId);
            String maintainContentId = mapObject.get("maintainContentId");
            addMaintainPlan.setMaintainContentId(maintainContentId);

            //maintainDate 计划保养时间
            String maintainDateStr = mapObject.get("maintainDate");
            Date maintainDate = DateFormat.dateString2Date(maintainDateStr, DateFormat.DEFAULT_DATE_FORMAT);
            addMaintainPlan.setMaintainDate(maintainDate);
            //addMaintainPlan.setBeginPlan(maintainDate);
            //addMaintainPlan.setEndPlan(maintainDate);

            String companyId = planObject.getCompanyId();
            //sysCode 保养计划单编号(系统生成)
            //MP+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(companyId,
                    "vmes_equipment_maintain_plan",
                    "yyyyMMdd",
                    "MP");
            addMaintainPlan.setSysCode(code);

            try {
                this.save(addMaintainPlan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}



