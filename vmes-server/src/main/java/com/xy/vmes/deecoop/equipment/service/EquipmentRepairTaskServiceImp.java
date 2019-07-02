package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.deecoop.equipment.dao.EquipmentRepairTaskMapper;
import com.xy.vmes.entity.EquipmentRepairTask;
import com.xy.vmes.service.EquipmentRepairTaskService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_equipment_repairTask:设备维修任务表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-07-01
*/
@Service
@Transactional(readOnly = false)
public class EquipmentRepairTaskServiceImp implements EquipmentRepairTaskService {


    @Autowired
    private EquipmentRepairTaskMapper equipmentRepairTaskMapper;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-07-01
    */
    @Override
    public void save(EquipmentRepairTask equipmentRepairTask) throws Exception{
        equipmentRepairTask.setId(Conv.createUuid());
        equipmentRepairTask.setCdate(new Date());
        equipmentRepairTask.setUdate(new Date());
        equipmentRepairTaskMapper.insert(equipmentRepairTask);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public EquipmentRepairTask selectById(String id) throws Exception{
        return equipmentRepairTaskMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public List<EquipmentRepairTask> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentRepairTask> warehouseCheckDetailList = equipmentRepairTaskMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void update(EquipmentRepairTask object) throws Exception{
        object.setUdate(new Date());
        equipmentRepairTaskMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void updateAll(EquipmentRepairTask object) throws Exception{
        object.setUdate(new Date());
        equipmentRepairTaskMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentRepairTaskMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentRepairTaskMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    public List<EquipmentRepairTask> dataList(PageData pd) throws Exception{
        return equipmentRepairTaskMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentRepairTaskMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentRepairTaskMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2019-07-01
     */
    public void updateIsdisableByRepairId(String isdisable, String repairId)throws Exception {
        if (isdisable == null || isdisable.trim().length() == 0) {return;}
        if (repairId == null || repairId.trim().length() == 0) {return;}
        if ("0,1".indexOf(isdisable.trim()) == -1) {return;}

        PageData valueMap = new PageData();
        valueMap.put("isdisable", isdisable);
        valueMap.put("repairId", repairId);
        equipmentRepairTaskMapper.updateIsdisableByRepairId(valueMap);
    }

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
    public List<EquipmentRepairTask> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentRepairTask>();
        }

        return this.dataList(pageData);
    }

    public EquipmentRepairTask findRepairTask(PageData object) throws Exception {
        List<EquipmentRepairTask> objectList = this.findRepairTaskList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentRepairTask findRepairTaskById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findRepairTask(findMap);
    }
    public List<EquipmentRepairTask> findRepairTaskList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public boolean isExistRepairTaskByRepairId(String repairId) {
        if (repairId == null || repairId.trim().length() == 0) {return false;}

        List<EquipmentRepairTask> repairTaskList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("repairId", repairId);
            repairTaskList = this.findRepairTaskList(findMap);

            if (repairTaskList != null && repairTaskList.size() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageEquipmentRepairTasks(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("equipmentRepairTask");
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

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }







}



