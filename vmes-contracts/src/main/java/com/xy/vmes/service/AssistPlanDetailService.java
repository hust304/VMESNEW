package com.xy.vmes.service;


import com.xy.vmes.entity.AssistPlan;
import com.xy.vmes.entity.AssistPlanDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_plan_detail:外协订单明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2020-04-25
*/
public interface AssistPlanDetailService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void save(AssistPlanDetail assistPlanDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void update(AssistPlanDetail assistPlanDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateAll(AssistPlanDetail assistPlanDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    AssistPlanDetail selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlanDetail> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlanDetail> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlanDetail> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateByDefined(PageData pd)throws Exception;

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
    List<AssistPlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistPlanDetail findAssistPlanDetail(PageData object) throws Exception;
    AssistPlanDetail findAssistPlanDetailById(String id) throws Exception;

    List<AssistPlanDetail> findAssistPlanDetailList(PageData object) throws Exception;
    List<AssistPlanDetail> findAssistPlanDetailListByParentId(String parentId) throws Exception;

    /**
     * 获取外协计划状态
     * 计划状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     * 计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     *
     * @param dtlList      外协订单明细List<AssistPlanDetail>
     * @return
     */
    String findParentStateByDetail(List<AssistPlanDetail> dtlList);

    /**
     * 根据外协计划明细状态-反写计划状态
     * 计划状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     * 计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
     *
     * @param parent       计划对象
     * @param detailList   计划明细List<AssistPlanDetail>
     */
    void updateParentStateByDetailList(AssistPlan parent, List<AssistPlanDetail> detailList) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistPlanDetails(PageData pd) throws Exception;

}



