package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailByQualityMapper;
import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailMapper;
import com.xy.vmes.entity.ProducePlanDetail;
import com.xy.vmes.service.ProducePlanDetailService;

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

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_produce_plan_detail:生产计划明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-02-27
*/
@Service
@Transactional(readOnly = false)
public class ProducePlanDetailServiceImp implements ProducePlanDetailService {
    @Autowired
    private ProducePlanDetailMapper producePlanDetailMapper;
    @Autowired
    private ProducePlanDetailByQualityMapper producePlanDetailByQualityMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void save(ProducePlanDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        producePlanDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public ProducePlanDetail selectById(String id) throws Exception{
        return producePlanDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<ProducePlanDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlanDetail> warehouseCheckDetailList = producePlanDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void update(ProducePlanDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateAll(ProducePlanDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    public List<ProducePlanDetail> dataList(PageData pd) throws Exception{
        return producePlanDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return producePlanDetailMapper.getDataListPage(pd,pg);
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
    public List<ProducePlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProducePlanDetail>();
        }

        return this.dataList(pageData);
    }

    public ProducePlanDetail findProducePlanDetail(PageData object) throws Exception {
        List<ProducePlanDetail> objectList = this.findProducePlanDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public ProducePlanDetail findProducePlanDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findProducePlanDetail(findMap);
    }

    public List<ProducePlanDetail> findProducePlanDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<ProducePlanDetail> findProducePlanDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("orderStr", "order_id asc");

        return this.findProducePlanDetailList(findMap);
    }

    /**
     * 获取生产计划状态-根据生产计划明细状态
     * 生产计划状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     * 生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     *
     * @param dtlList      生产计划明细List<SaleOrderDetail>
     * @return
     */
    public String findParentStateByDetail(List<ProducePlanDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        int dtl_dsc = 0;  //0:待生产
        int dtl_scz = 0;  //1:生产中
        int dtl_ywc = 0;  //2:已完成
        int dtl_yqx = 0;  //-1:已取消

        for (ProducePlanDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dsc = dtl_dsc + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_scz = dtl_scz + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        if (dtl_yqx > 0 && dtl_yqx == dtlList.size()) {
            return "-1";

            //明细状态:2:已完成 全是已完成状态  主表状态:2:已完成
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dsc == 0 && dtl_scz == 0)
        ) {
            return "2";

            //明细状态:1:生产中 明细中存在(一个或多个)生产中状态 主表状态:1:生产中
        } else if (dtl_scz > 0) {
            return "1";
        }

        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        producePlanDetailMapper.updateStateByDetail(pageData);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageProducePlanDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlanDetail");
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
        Pagination pg = HttpUtils.parsePagination(pd);
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

    //生产计划明细(检验)报工
    public ResultModel listPageProducePlanDetailByQuality(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlanDetailByQuality");
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
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.listProducePlanDetailByQuality(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageMaterialRequisition(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("MaterialRequisition");
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
        Pagination pg = HttpUtils.parsePagination(pd);
        result.put("pageData", pg);

        List<Map> varList = producePlanDetailMapper.getMaterialRequisition(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageMaterialRequisitionGroup(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("MaterialRequisitionGroup");
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
        Pagination pg = HttpUtils.parsePagination(pd);
        result.put("pageData", pg);

        List<Map> varList = producePlanDetailMapper.getMaterialRequisitionGroup(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<Map> listProducePlanDetailByQuality(PageData pd,Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanDetailByQualityMapper.listProducePlanDetailByQuality(pd);
        } else if (pg != null) {
            return producePlanDetailByQualityMapper.listProducePlanDetailByQuality(pd, pg);
        }

        return mapList;
    }

}



