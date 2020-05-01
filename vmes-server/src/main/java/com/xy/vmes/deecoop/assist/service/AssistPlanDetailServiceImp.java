package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistPlanDetailMapper;
import com.xy.vmes.entity.AssistPlan;
import com.xy.vmes.entity.AssistPlanDetail;
import com.xy.vmes.service.AssistPlanDetailByAssistOrderService;
import com.xy.vmes.service.AssistPlanDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistPlanService;
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
* 说明：vmes_assist_plan_detail:外协订单明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2020-04-25
*/
@Service
@Transactional(readOnly = false)
public class AssistPlanDetailServiceImp implements AssistPlanDetailService {
    @Autowired
    private AssistPlanDetailMapper assistPlanDetailMapper;
    @Autowired
    private AssistPlanService assistPlanService;
    @Autowired
    private AssistPlanDetailByAssistOrderService assistPlanDetailByOrderService;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void save(AssistPlanDetail assistPlanDetail) throws Exception{
        assistPlanDetail.setId(Conv.createUuid());
        assistPlanDetail.setCdate(new Date());
        assistPlanDetail.setUdate(new Date());
        assistPlanDetailMapper.insert(assistPlanDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void update(AssistPlanDetail assistPlanDetail) throws Exception{
        assistPlanDetail.setUdate(new Date());
        assistPlanDetailMapper.updateById(assistPlanDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateAll(AssistPlanDetail assistPlanDetail) throws Exception{
        assistPlanDetail.setUdate(new Date());
        assistPlanDetailMapper.updateAllColumnById(assistPlanDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    //@Cacheable(cacheNames = "assistPlanDetail", key = "''+#id")
    public AssistPlanDetail selectById(String id) throws Exception{
        return assistPlanDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteById(String id) throws Exception{
        assistPlanDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistPlanDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return assistPlanDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetail> dataList(PageData pd) throws Exception{
        return assistPlanDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return assistPlanDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return assistPlanDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistPlanDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<AssistPlanDetail> assistPlanDetailList =  assistPlanDetailMapper.selectByMap(columnMap);
        return assistPlanDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return assistPlanDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return assistPlanDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistPlanDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistPlanDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistPlanDetailMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        assistPlanDetailMapper.updateByDefined(pd);
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
    public List<AssistPlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistPlanDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistPlanDetail findAssistPlanDetail(PageData object) throws Exception {
        List<AssistPlanDetail> objectList = this.findAssistPlanDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistPlanDetail findAssistPlanDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistPlanDetail(findMap);
    }

    public List<AssistPlanDetail> findAssistPlanDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistPlanDetail> findAssistPlanDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findAssistPlanDetailList(findMap);
    }

    /**
     * 获取外协计划状态
     * 计划状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     * 计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     *
     * @param dtlList      外协订单明细List<AssistPlanDetail>
     * @return
     */
    public String findParentStateByDetail(List<AssistPlanDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //计划状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
        int dtl_dtj = 0;  //0:待提交
        int dtl_dsh = 0;  //1:待审核
        int dtl_dzx = 0;  //2:待执行
        int dtl_zxz = 0;  //3:执行中
        int dtl_ywc = 0;  //4:已完成
        int dtl_yqx = 0;  //-1:已取消
        //由各自业务更改--(0:待提交 1:待审核 2:待执行 -1:已取消 )

        //明细变更状态(3:执行中 4:已完成 -1:已取消)
        for (AssistPlanDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dtj = dtl_dtj + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_dsh = dtl_dsh + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_dzx = dtl_dzx + 1;
            } else if ("3".equals(dtlObject.getState())) {
                dtl_zxz = dtl_zxz + 1;
            } else if ("4".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //订单明细状态:-1:已取消 全是已取消状态  订单状态:-1:已取消
        if (dtl_yqx > 0 && dtl_yqx == dtlList.size()) {
            return "-1";

            //订单明细状态:4:已完成 全是已完成(发货)状态  订单状态:4:已完成
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dtj == 0 && dtl_dsh == 0 && dtl_dzx == 0 && dtl_zxz == 0)
        ) {
            return "4";

            //计划明细状态:3:执行中 计划明细中存在(一个或多个)执行中状态 计划状态:3:执行中
        } else if (dtl_zxz > 0) {
            return "3";
        }

        return null;
    }

    /**
     * 根据外协计划明细状态-反写计划状态
     * 计划状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     * 计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     *
     * @param parent       计划对象
     * @param detailList   计划明细List<AssistPlanDetail>
     */
    public void updateParentStateByDetailList(AssistPlan parent, List<AssistPlanDetail> detailList) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (detailList == null) {
            detailList = this.findAssistPlanDetailListByParentId(parent.getId());
        }

        //获取订单状态-根据订单明细状态
        String parentState = this.findParentStateByDetail(detailList);
        if (parentState != null && parentState.trim().length() > 0) {
            parent.setState(parentState.trim());
            assistPlanService.update(parent);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistPlanDetails(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("AssistPlanDetail");
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

    public ResultModel listPageAssistPlanDetailByAssistOrder(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("AssistPlanDetailByAssistOrder");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        List<Map> varList = assistPlanDetailByOrderService.listAssistPlanDetailByAssistOrder(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}

