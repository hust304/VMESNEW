package com.xy.vmes.service;


import com.xy.vmes.entity.AssistPlan;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_plan:应收/应付单 接口类
* 创建人：刘威 自动生成
* 创建时间：2020-04-25
*/
public interface AssistPlanService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void save(AssistPlan assistPlan) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void update(AssistPlan assistPlan) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateAll(AssistPlan assistPlan) throws Exception;

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
    AssistPlan selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlan> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlan> dataList(PageData pd) throws Exception;

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
    List<AssistPlan> selectByColumnMap(Map columnMap) throws Exception;


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
    List<AssistPlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistPlans(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    void exportExcelAssistPlans(PageData pd) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelAssistPlans(MultipartFile file) throws Exception;

    ResultModel addAssistPlan(PageData pd) throws Exception;

    ResultModel auditPassAssistPlan(PageData pd) throws Exception;

    ResultModel auditDisagreeAssistPlan(PageData pd) throws Exception;

    ResultModel cancelAssistPlan(PageData pd) throws Exception;

    ResultModel deleteAssistPlan(PageData pd) throws Exception;

    ResultModel submitAssistPlan(PageData pd) throws Exception;

    ResultModel recoveryAssistPlan(PageData pd) throws Exception;

    ResultModel updateAssistPlan(PageData pd) throws Exception;
}



