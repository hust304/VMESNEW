package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.deecoop.equipment.dao.EquipmentMaintainContentMapper;
import com.xy.vmes.entity.EquipmentMaintainContent;
import com.xy.vmes.service.EquipmentMaintainContentService;

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
* 说明：vmes_equipment_maintain_content:设备保养内容 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-07-24
*/
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainContentServiceImp implements EquipmentMaintainContentService {
    @Autowired
    private EquipmentMaintainContentMapper equipmentMaintainContentMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void save(EquipmentMaintainContent equipmentRepair) throws Exception{
        equipmentRepair.setId(Conv.createUuid());
        equipmentRepair.setCdate(new Date());
        equipmentRepair.setUdate(new Date());
        equipmentMaintainContentMapper.insert(equipmentRepair);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public EquipmentMaintainContent selectById(String id) throws Exception{
        return equipmentMaintainContentMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public List<EquipmentMaintainContent> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentMaintainContent> warehouseCheckDetailList = equipmentMaintainContentMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void update(EquipmentMaintainContent object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainContentMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void updateAll(EquipmentMaintainContent object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainContentMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMaintainContentMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentMaintainContentMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMaintainContentMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentMaintainContentMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    public List<EquipmentMaintainContent> dataList(PageData pd) throws Exception{
        return equipmentMaintainContentMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-24
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentMaintainContentMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentMaintainContentMapper.getDataListPage(pd,pg);
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
    public List<EquipmentMaintainContent> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentMaintainContent>();
        }

        return this.dataList(pageData);
    }

    public EquipmentMaintainContent findMaintainContent(PageData object) throws Exception {
        List<EquipmentMaintainContent> objectList = this.findMaintainContentList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentMaintainContent findMaintainContentById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findMaintainContent(findMap);
    }
    public List<EquipmentMaintainContent> findMaintainContentList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageEquipmentMaintainContent(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintainContent");
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

        List<Map> varList = this.getDataListPage(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}



