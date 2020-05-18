package com.xy.vmes.service;

import com.xy.vmes.entity.AssistRetreat;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_retreat:外协退货单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-05-07
*/
public interface AssistRetreatService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void save(AssistRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void update(AssistRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void updateAll(AssistRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    AssistRetreat selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    List<AssistRetreat> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    List<AssistRetreat> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

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
    List<AssistRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistRetreat findAssistRetreat(PageData object) throws Exception;
    AssistRetreat findAssistRetreatById(String id) throws Exception;
    List<AssistRetreat> findAssistRetreatList(PageData object) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 生成外协退货单-外协质量检验(成品签收检验)
     * @param cuser      用户id
     * @param companyId  企业id
     * @param objectMap  质量检验jsonMap
     */
    String createRetreatByQuality(String cuser, String companyId, Map<String, String> objectMap) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistRetreat(PageData pd) throws Exception;

}



