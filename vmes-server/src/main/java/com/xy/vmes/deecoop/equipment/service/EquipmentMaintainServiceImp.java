package com.xy.vmes.deecoop.equipment.service;

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
     * 创建设备保养单
     * @param cuser      用户id
     * @param companyId  企业id
     * @param plan       设备保养计划对象<EquipmentMaintainPlan>
     */
    public void addMaintainByCustom(String cuser, String companyId, EquipmentMaintainPlan plan) throws Exception {
        EquipmentMaintain addMaintain = new EquipmentMaintain();
        addMaintain.setCuser(cuser);
        addMaintain.setCompanyId(companyId);
        //planId 保养计划ID
        addMaintain.setPlanId(plan.getId());

        //sysCode 保养单编号(系统生成)
        //设备维修单编号
        //EM+yyyyMMdd+00001 = 15位
        String code = coderuleService.createCoderCdateByDate(companyId,
                "vmes_equipment_maintain:",
                "yyyyMMdd",
                "EM");
        addMaintain.setSysCode(code);

        //maintainDate 保养时间(yyyy-MM-dd)
        addMaintain.setMaintainDate(plan.getMaintainDate());
        //equipmentState 设备状态(1:待保养 2:保养中 3:已完成)
        addMaintain.setEquipmentState("1");

        this.save(addMaintain);
    }
    public void addMaintainByPeriod() {}

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



