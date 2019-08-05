package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.equipment.dao.EquipmentMaintainMapper;
import com.xy.vmes.entity.EquipmentMaintain;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.EquipmentMaintainService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_equipment_maintain:设备保养单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-07-29
*/
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainServiceImp implements EquipmentMaintainService {

    @Autowired
    private EquipmentMaintainMapper equipmentMaintainMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-07-29
    */
    @Override
    public void save(EquipmentMaintain object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        equipmentMaintainMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public EquipmentMaintain selectById(String id) throws Exception{
        return equipmentMaintainMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public List<EquipmentMaintain> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentMaintain> warehouseCheckDetailList = equipmentMaintainMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void update(EquipmentMaintain object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void updateAll(EquipmentMaintain object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMaintainMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentMaintainMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMaintainMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentMaintainMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    public List<EquipmentMaintain> dataList(PageData pd) throws Exception{
        return equipmentMaintainMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentMaintainMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentMaintainMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    public EquipmentMaintain findMaintain(PageData object) throws Exception {
        List<EquipmentMaintain> objectList = this.findMaintainList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentMaintain findMaintainById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findMaintain(findMap);
    }
    public List<EquipmentMaintain> findMaintainList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    /**
     * 获取下一个保养计划(周期保养计划)
     *
     * @param maintain  保养单对象<EquipmentMaintain>
     * @return
     */
    public EquipmentMaintain findNextMaintainByPeriod(EquipmentMaintain maintain) {
        if (maintain == null) {return null;}

        //nextMaintainDate 下一保养时间(yyyy-MM-dd)
        Date nextMaintainDate = maintain.getNextMaintainDate();
        if (nextMaintainDate == null) {return null;}
        String nextMaintainDateStr = DateFormat.date2String(nextMaintainDate, DateFormat.DEFAULT_DATE_FORMAT);

        //sysBeginTime 保养开始时间(根据保养计划-系统计算)
        String sysBeginTimeStr = nextMaintainDateStr;


        EquipmentMaintain nextMaintain = null;
        try {
            PageData findMap = new PageData();
            findMap.put("sysBeginTime", sysBeginTimeStr);
            //保养单有效状态(1:有效 0:无效 is null 无效)
            findMap.put("isValidState", "0");
            //是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("orderStr", "cdate asc");

            nextMaintain = this.findMaintain(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nextMaintain;
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
    public List<EquipmentMaintain> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentMaintain>();
        }

        return this.dataList(pageData);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建设备保养单(设备保养定时任务调用)
     * @param plan  设备保养计划对象<EquipmentMaintainPlan>
     */
    public void addMaintainCustomByTimer(EquipmentMaintainPlan plan) throws Exception {
        EquipmentMaintain addMaintain = new EquipmentMaintain();
        //equipmentId 设备ID
        addMaintain.setEquipmentId(plan.getEquipmentId());
        //maintainContentId 保养内容ID
        addMaintain.setMaintainContentId(plan.getMaintainContentId());
        //isStop 是否停机 (1:停机保养 0:非停机保养)
        addMaintain.setIsStop(plan.getIsStop());

        addMaintain.setCuser(plan.getCuser());
        addMaintain.setCompanyId(plan.getCompanyId());
        //planId 保养计划ID
        addMaintain.setPlanId(plan.getId());

        //sysCode 保养单编号(系统生成)
        //设备维修单编号
        //EM+yyyyMMdd+00001 = 15位
        String code = coderuleService.createCoderCdateByDate(plan.getCompanyId(),
                "vmes_equipment_maintain:",
                "yyyyMMdd",
                "EM");
        addMaintain.setSysCode(code);

        //maintainDate 保养时间(yyyy-MM-dd)
        addMaintain.setMaintainDate(plan.getMaintainDate());
        //equipmentState 设备状态(1:待保养 2:保养中 3:已完成)
        addMaintain.setEquipmentState("1");

        //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
        addMaintain.setIsValidState("1");

        this.save(addMaintain);
    }

    /**
     * 创建设备保养单(设备保养定时任务调用)
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param dateMap   周期数据Map
     * @param plan      设备保养计划对象<EquipmentMaintainPlan>
     */
    public void addMaintainPeriodByTimer(Map<String, Date> dateMap, EquipmentMaintainPlan plan) throws Exception {
        if (dateMap == null) {return;}
        if (plan == null) {return;}

        //beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
        String beginDateTimeStr = null;
        Date beginDateTime = dateMap.get("beginDateTime");
        if (beginDateTime != null) {
            beginDateTimeStr = DateFormat.date2String(beginDateTime, DateFormat.DEFAULT_DATETIME_FORMAT);
        }

        //endDateTime: 周期结束日期时间(yyyy-MM-dd HH:mm:ss)
        String endDateTimeStr = null;
        Date endDateTime = dateMap.get("endDateTime");
        if (endDateTime != null) {
            endDateTimeStr = DateFormat.date2String(endDateTime, DateFormat.DEFAULT_DATETIME_FORMAT);
        }
        //nextMaintainDate: 下一保养日期(yyyy-MM-dd)
        Date nextMaintainDate = dateMap.get("nextMaintainDate");

        //(企业id,保养计划id,周期起始日期时间,周期结束日期时间) 查询(vmes_equipment_maintain:设备保养表)
        PageData findMap = new PageData();
        findMap.put("companyId", plan.getCompanyId());
        findMap.put("planId", plan.getId());
        findMap.put("sysBeginTime", beginDateTimeStr);
        findMap.put("sys_end_time", endDateTimeStr);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        EquipmentMaintain maintainObj = this.findMaintain(findMap);
        if (maintainObj != null) {return;}

        EquipmentMaintain addMaintain = new EquipmentMaintain();
        //equipmentId 设备ID
        addMaintain.setEquipmentId(plan.getEquipmentId());
        //maintainContentId 保养内容ID
        addMaintain.setMaintainContentId(plan.getMaintainContentId());
        //isStop 是否停机 (1:停机保养 0:非停机保养)
        addMaintain.setIsStop(plan.getIsStop());

        addMaintain.setCuser(plan.getCuser());
        addMaintain.setCompanyId(plan.getCompanyId());
        //planId 保养计划ID
        addMaintain.setPlanId(plan.getId());

        //sysCode 保养单编号(系统生成)
        //设备维修单编号
        //EM+yyyyMMdd+00001 = 15位
        String code = coderuleService.createCoderCdateByDate(plan.getCompanyId(),
                "vmes_equipment_maintain:",
                "yyyyMMdd",
                "EM");
        addMaintain.setSysCode(code);

        //equipmentState 设备状态(1:待保养 2:保养中 3:已完成)
        addMaintain.setEquipmentState("1");

        //sysBeginTime:保养开始时间(根据保养计划-系统计算)
        addMaintain.setSysBeginTime(beginDateTime);
        //sysEndTime:保养结束时间(根据保养计划-系统计算)
        addMaintain.setSysEndTime(endDateTime);

        //maintainDate:保养时间(yyyy-MM-dd)
        String maintainDateStr = DateFormat.date2String(beginDateTime, DateFormat.DEFAULT_DATE_FORMAT);
        Date maintainDate = DateFormat.dateString2Date(maintainDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        addMaintain.setMaintainDate(maintainDate);
        //nextMaintainDate:下一保养时间
        addMaintain.setNextMaintainDate(nextMaintainDate);

        //(企业id,保养计划id,保养单有效状态) 查询(vmes_equipment_maintain:设备保养表)
        //查询(vmes_equipment_maintain:设备保养表)-(企业id,保养计划id,有效)设备保养表单
        findMap = new PageData();
        findMap.put("companyId", plan.getCompanyId());
        findMap.put("planId", plan.getId());
        //保养单有效状态(1:有效 0:无效 is null 无效)
        findMap.put("isValidState", "1");
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        List<EquipmentMaintain> maintainList = this.findMaintainList(findMap);

        //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
        addMaintain.setIsValidState("0");
        if (maintainList == null || maintainList.size() == 0) {
            //isValidState 保养单有效状态(1:有效 0:无效 is null 无效)
            addMaintain.setIsValidState("1");
        }

        this.save(addMaintain);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageEquipmentMaintain(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintain");
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

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        //设备保养单状态
        String equipmentState = pd.getString("equipmentState");
        if (equipmentState == null || equipmentState.trim().length() == 0) {
            //保养单有效状态(1:有效 0:无效 is null 无效)
            pd.put("isValidState", "1");
        }

        //设置查询排序方式
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

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



