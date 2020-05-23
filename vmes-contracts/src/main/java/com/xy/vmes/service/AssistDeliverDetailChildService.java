package com.xy.vmes.service;

import com.xy.vmes.entity.AssistDeliverDetailChild;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_deliver_detail_child:外协发货明细子表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-27
*/
public interface AssistDeliverDetailChildService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void save(AssistDeliverDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void update(AssistDeliverDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void updateAll(AssistDeliverDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    AssistDeliverDetailChild selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    List<AssistDeliverDetailChild> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    List<AssistDeliverDetailChild> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
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
    List<AssistDeliverDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistDeliverDetailChild findDeliverDetailChild(PageData object) throws Exception;
    AssistDeliverDetailChild findDeliverDetailChildById(String id) throws Exception;
    List<AssistDeliverDetailChild> findDeliverDetailChildList(PageData object) throws Exception;

    /**
     * 返回货品出库Map
     * 业务货品出库Map<业务单id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param orderDtlList
     * @return
     */
    Map<String, Map<String, Object>> findProductBusinessMapByOut(List<AssistDeliverDetailChild> orderDtlList);

    List<Map<String, Object>> checkAssistDeliverDetailChildByOutDetail(PageData pd);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistDeliverDetailChild(PageData pd) throws Exception;


}



