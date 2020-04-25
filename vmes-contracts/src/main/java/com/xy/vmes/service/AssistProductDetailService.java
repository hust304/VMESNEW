package com.xy.vmes.service;

import com.xy.vmes.entity.AssistProductDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_product_detail:外协件原材料 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-19
*/
public interface AssistProductDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void save(AssistProductDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void update(AssistProductDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void updateAll(AssistProductDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    AssistProductDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    List<AssistProductDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    List<AssistProductDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
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
    List<AssistProductDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistProductDetail findAssistProductDetail(PageData object) throws Exception;
    AssistProductDetail findAssistProductDetailById(String id) throws Exception;

    List<AssistProductDetail> findAssistProductDetailList(PageData object) throws Exception;
    List<AssistProductDetail> findAssistProductDetailListByParentId(String parentId) throws Exception;

    /**
     * 表(vmes_assist_product_detail:外协件原材料)对象 转换为目标类对象
     *
     * @param assistProductDtl 表(vmes_assist_product_detail:外协件原材料)对象
     * @param targetClazz      目标类
     * @return
     */
    Object assistProductDetail2Target(AssistProductDetail assistProductDtl, Class<?> targetClazz) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistProductDetail(PageData pd) throws Exception;


}



