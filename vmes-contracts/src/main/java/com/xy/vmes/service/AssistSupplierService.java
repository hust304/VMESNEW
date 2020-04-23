package com.xy.vmes.service;

import com.xy.vmes.entity.AssistSupplier;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_supplier:外协供应商 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-23
*/
public interface AssistSupplierService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void save(AssistSupplier object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void update(AssistSupplier object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void updateAll(AssistSupplier object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    AssistSupplier selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    List<AssistSupplier> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
     */
    List<AssistSupplier> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-23
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
    List<AssistSupplier> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistSupplier findAssistSupplier(PageData object) throws Exception;
    AssistSupplier findAssistSupplierById(String id) throws Exception;
    List<AssistSupplier> findAssistSupplierList(PageData object) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistSupplier(PageData pd) throws Exception;


}



