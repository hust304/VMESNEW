package com.xy.vmes.service;


import com.xy.vmes.entity.AssistPlanDetail;
import com.xy.vmes.entity.AssistPlanDetailChild;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_plan_detail_child:外协订单明细原材料 接口类
* 创建人：刘威 自动生成
* 创建时间：2020-04-25
*/
public interface AssistPlanDetailChildService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void save(AssistPlanDetailChild assistPlanDetailChild) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void update(AssistPlanDetailChild assistPlanDetailChild) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateAll(AssistPlanDetailChild assistPlanDetailChild) throws Exception;

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
    AssistPlanDetailChild selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlanDetailChild> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<AssistPlanDetailChild> dataList(PageData pd) throws Exception;

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
    List<AssistPlanDetailChild> selectByColumnMap(Map columnMap) throws Exception;


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
    List<AssistPlanDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistPlanDetailChilds(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    void exportExcelAssistPlanDetailChilds(PageData pd) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelAssistPlanDetailChilds(MultipartFile file) throws Exception;

    void insertAssistPlanDetailChild(AssistPlanDetail assistPlanDetail) throws Exception;
}



