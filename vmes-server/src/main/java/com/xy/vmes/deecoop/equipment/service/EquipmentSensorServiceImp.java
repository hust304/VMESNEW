package com.xy.vmes.deecoop.equipment.service;

import com.yvan.HttpUtils;
import com.yvan.common.util.Common;
import com.xy.vmes.deecoop.equipment.dao.EquipmentSensorMapper;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.service.EquipmentSensorService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_equipment_sensor:设备传感器指标(设备联网) 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-06-19
*/
@Service
@Transactional(readOnly = false)
public class EquipmentSensorServiceImp implements EquipmentSensorService {
    @Autowired
    private EquipmentSensorMapper equipmentSensorMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void save(EquipmentSensor object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        equipmentSensorMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public EquipmentSensor selectById(String id) throws Exception{
        return equipmentSensorMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public List<EquipmentSensor> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentSensor> warehouseCheckDetailList = equipmentSensorMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void update(EquipmentSensor object) throws Exception{
        object.setUdate(new Date());
        equipmentSensorMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void updateAll(EquipmentSensor object) throws Exception{
        object.setUdate(new Date());
        equipmentSensorMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentSensorMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentSensorMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentSensorMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentSensorMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    public List<EquipmentSensor> dataList(PageData pd) throws Exception{
        return equipmentSensorMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentSensorMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentSensorMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<Map> findAllEquipmentBySensorMapList(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentSensorMapper.findAllEquipmentBySensor(pd);
        } else if (pg != null) {
            return equipmentSensorMapper.findAllEquipmentBySensor(pd,pg);
        }

        return mapList;
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
    public List<EquipmentSensor> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentSensor>();
        }

        return this.dataList(pageData);
    }

    public EquipmentSensor findEquipmentSensor(PageData object) throws Exception {
        List<EquipmentSensor> objectList = this.findEquipmentSensorList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentSensor findEquipmentSensorById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findEquipmentSensor(findMap);
    }
    public List<EquipmentSensor> findEquipmentSensorList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public PageData setupSqlOrder(String orderStr, PageData pageData) {
        if (pageData == null) {pageData = new PageData();}
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr.trim());
        }
        return pageData;
    }

    public LinkedHashMap<String, String> findTargetCodeMap(List<EquipmentSensor> list) {
        LinkedHashMap<String, String> codeMap = new LinkedHashMap<String, String>();
        if (list == null || list.size() == 0) {return codeMap;}

        for (EquipmentSensor object : list) {
            String targetCode = object.getTargetCode();
            if (targetCode != null && targetCode.trim().length() > 0) {
                codeMap.put(targetCode.trim(), targetCode.trim());
            }
        }

        return codeMap;
    }

    public String findTargetCode(Map<String, String> mapObject) {
        StringBuffer strBuf = new StringBuffer();
        if (mapObject == null || mapObject.size() == 0) {return strBuf.toString();}

        for (Iterator iterator = mapObject.keySet().iterator(); iterator.hasNext();) {
            String targetCode = (String) iterator.next();
            if (targetCode != null && targetCode.trim().length() > 0) {
                strBuf.append(targetCode.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteTableByEquipment(PageData pd) {
        equipmentSensorMapper.deleteTableByEquipment(pd);
    }
    public String checkColumnByEdit(EquipmentSensor object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //设备ID equipmentId
        if (object.getEquipmentId() == null || object.getEquipmentId().trim().length() == 0) {
            msgBuf.append("设备id为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }

        //指标类型 targetType
        if (object.getTargetType() == null || object.getTargetType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "指标类型");
            msgBuf.append(str_isnull);

        }

        //指标名称 targetName
        if (object.getTargetName() == null || object.getTargetName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "指标名称");
            msgBuf.append(str_isnull);
        }

        //指标类型 targetType (A:传感器指标 B:分析指标)
        if ("A".equals(object.getTargetType().trim())) {
            //指标公式 targetFormula
            object.setTargetFormula(null);
            //指标公式(转换栏位名称公式-SQL查询语句直接使用) targetFormulaColumn
            object.setTargetFormulaColumn(null);
        } else if ("B".equals(object.getTargetType().trim())
                && object.getTargetFormula() == null || object.getTargetFormula().trim().length() == 0
        ) {
            String str_isnull = MessageFormat.format(column_isnull, "指标公式");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    public boolean isExistByName(String id, String equipmentId, String targetName) {
        if (targetName == null || targetName.trim().length() == 0) {return false;}

        List<EquipmentSensor> objectList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("isSelfExist", "true");
            findMap.put("targetName", targetName);
            findMap.put("equipmentId", equipmentId);
            findMap.put("id", id);

            objectList = this.findEquipmentSensorList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageEquipmentSensor(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentSensor");
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
        String orderStr = pd.getString("orderStr");
        if (orderStr == null || orderStr.trim().length() == 0) {
            pd.put("orderStr", "cdate asc");
        } else if (orderStr != null && orderStr.trim().length() > 0) {
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

        List<Map> varList = this.getDataListPage(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel findAllEquipmentBySensor(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentBindSensor");
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
        pd.put("orderStr", "equipment.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        String companyId = new String();
        if (pd.getString("currentCompanyId") != null) {
            companyId = pd.getString("currentCompanyId").trim();
        }
        pd.put("companyId", companyId);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.findAllEquipmentBySensorMapList(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    //获取设备全部传感器指标-公式编辑器调用
    public ResultModel findListEquipmentSensorByEquipment(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String equipmentId = pd.getString("equipmentId");
        if (equipmentId == null || equipmentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id为空或空字符串！");
            return model;
        }

        List<EquipmentSensor> sensorList = new ArrayList<EquipmentSensor>();
        try {
            PageData findMap = new PageData();
            findMap.put("equipmentId", equipmentId);
            //是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("orderStr", "target_code asc");
            sensorList = findEquipmentSensorList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> sensorMapList = new ArrayList<Map<String, Object>>();
        for (EquipmentSensor object : sensorList) {
            Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
            valueMap.put("id", object.getId());
            valueMap.put("targetCode", object.getTargetCode());
            valueMap.put("targetName", object.getTargetName());
            valueMap.put("targetFormula", object.getTargetFormula());
            sensorMapList.add(valueMap);
        }

        model.put("EquipmentSensor", sensorMapList);
        return model;
    }

}



