package com.xy.vmes.service;

import com.xy.vmes.entity.AssistRetreatDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_retreat_detail:外协退货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-05-07
*/
public interface AssistRetreatDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void save(AssistRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void update(AssistRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    void updateAll(AssistRetreatDetail object) throws Exception;

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
    AssistRetreatDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    List<AssistRetreatDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-07
     */
    List<AssistRetreatDetail> dataList(PageData pd) throws Exception;

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
    List<AssistRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistRetreatDetail findAssistRetreatDetail(PageData object) throws Exception;
    AssistRetreatDetail findAssistRetreatDetailById(String id) throws Exception;

    List<AssistRetreatDetail> findAssistRetreatDetailList(PageData object) throws Exception;
    List<AssistRetreatDetail> findAssistRetreatDetailListByParentId(String parentId) throws Exception;

    BigDecimal findTotalAmount(List<AssistRetreatDetail> objectList);

    /**
     * 获取外协退货单状态-根据退货单明细状态
     * 外协退货单状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
     * 外协退货单明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
     *
     * @param detailList      外协退货单明细List<AssistSignDetail>
     * @return
     */
    String findParentStateByDetailList(List<AssistRetreatDetail> detailList);

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
    Map<String, Map<String, Object>> findProductBusinessMapByOut(List<AssistRetreatDetail> orderDtlList);

    List<Map<String, Object>> checkAssistRetreatDetailByInDetail(PageData pd);
    List<Map<String, Object>> checkAssistRetreatDetailByOutDetail(PageData pd);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //供应商原材料退回-免检
    ResultModel updateAssistRetreatDetailByProductQuality(PageData pageData) throws Exception;

    //供应商原材料退回-检验执行
    ResultModel updateAssistRetreatDetailByProductQualityExecute(PageData pageData) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistRetreatDetail(PageData pd) throws Exception;
    ResultModel listPageAssistRetreatDetailByQualityExecute(PageData pd) throws Exception;
}



