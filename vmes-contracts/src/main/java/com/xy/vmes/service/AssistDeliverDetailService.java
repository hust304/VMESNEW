package com.xy.vmes.service;

import com.xy.vmes.entity.AssistDeliverDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_deliver_detail:外协发货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-27
*/
public interface AssistDeliverDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void save(AssistDeliverDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void update(AssistDeliverDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    void updateAll(AssistDeliverDetail object) throws Exception;

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
    AssistDeliverDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    List<AssistDeliverDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-27
     */
    List<AssistDeliverDetail> dataList(PageData pd) throws Exception;

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
    List<AssistDeliverDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistDeliverDetail findDeliverDetail(PageData object) throws Exception;
    AssistDeliverDetail findDeliverDetailById(String id) throws Exception;

    List<AssistDeliverDetail> findDeliverDetailList(PageData object) throws Exception;
    List<AssistDeliverDetail> findDeliverDetailListByParentId(String parentId) throws Exception;

    String findOrderDtlIdsByDeliverDtlList(List<AssistDeliverDetail> detailList);

    /**
     * 获取外协订单(原材料)Map结构体
     * Map<外协订单明细id, List<Map<String, Object>>>
     * Sql查询语句: AssistOrderDetailChildByAssistDeliverMapper.checkAssistOrderDetailChildByDeliver
     *
     * @param orderDtlIds
     * @return
     */
    Map<String, List<Map<String, Object>>> findOrderDetailChildMap(String orderDtlIds);

    boolean isAllDeliverByOrderDetail(String orderDtlId, Map<String, List<Map<String, Object>>> valueMap);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistDeliverDetail(PageData pd) throws Exception;


}



