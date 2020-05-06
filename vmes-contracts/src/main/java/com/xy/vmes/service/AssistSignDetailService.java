package com.xy.vmes.service;

import com.xy.vmes.entity.AssistSignDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_sign_detail:外协签收单明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-05-04
*/
public interface AssistSignDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void save(AssistSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void update(AssistSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void updateAll(AssistSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    AssistSignDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    List<AssistSignDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
     */
    List<AssistSignDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-05-04
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
    List<AssistSignDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistSignDetail findAssistSignDetail(PageData object) throws Exception;
    AssistSignDetail findAssistSignDetailById(String id) throws Exception;

    List<AssistSignDetail> findAssistSignDetailList(PageData object) throws Exception;
    List<AssistSignDetail> findAssistSignDetailListByParentId(String parentId) throws Exception;

    /**
     * 获取签收单状态-根据签收单明细状态
     * 签收单单状态(1:检验中 2:已完成 -1:已取消)
     * 签收单明细状态(1:检验中 2:已完成 -1:已取消)
     *
     * @param objectList      外协签收单明细List<AssistSignDetail>
     * @return
     */
    String findParentStateByDetailList(List<AssistSignDetail> objectList);

    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param objectList
     * @return
     */
    Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> objectList);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistSignDetail(PageData pd) throws Exception;

    //获取(质量-外协检验)外协签收明细检验
    //菜单路径:(质量-外协检验) 当前外协签收明细(执行)按钮弹出框查询调用方法
    ResultModel listPageAssistSignDetailByQualityExecute(PageData pd) throws Exception;

    //外协签收明细-检验执行
    ResultModel assistSignDetailByQualityExecute(PageData pageData) throws Exception;

    //外协签收明细-免检
    ResultModel updateAssistSignDetailByQuality(PageData pageData) throws Exception;
}



