package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseSignDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_sign_detail:采购签收明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-03-12
*/
public interface PurchaseSignDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void save(PurchaseSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void update(PurchaseSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateAll(PurchaseSignDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    PurchaseSignDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<PurchaseSignDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<PurchaseSignDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
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
    List<PurchaseSignDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseSignDetail findSignDetail(PageData object) throws Exception;
    PurchaseSignDetail findSignDetailById(String id) throws Exception;

    List<PurchaseSignDetail> findSignDetailList(PageData object) throws Exception;
    List<PurchaseSignDetail> findSignDetailListByParentId(String parentId) throws Exception;

    /**
     * 获取签收单状态-根据签收单明细状态
     * 签收单单状态(1:检验中 2:已完成 -1:已取消)
     * 签收单明细状态(1:检验中 2:已完成 -1:已取消)
     *
     * @param objectList      采购签收单明细List<PurchaseSignDetail>
     * @return
     */
    String findParentStateByDetailList(List<PurchaseSignDetail> objectList);

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
    Map<String, Map<String, Object>> findBusinessProducMapByIn(List<PurchaseSignDetail> objectList);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchaseSignDetail(PageData pd) throws Exception;




}



