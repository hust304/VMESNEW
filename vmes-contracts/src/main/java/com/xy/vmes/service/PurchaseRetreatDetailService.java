package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseOrderDetail;
import com.xy.vmes.entity.PurchaseRetreat;
import com.xy.vmes.entity.PurchaseRetreatDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_retreat_detail:退货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-05-09
*/
public interface PurchaseRetreatDetailService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void save(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void update(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void updateAll(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    PurchaseRetreatDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreatDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreatDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
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
    List<PurchaseRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseRetreatDetail findPurchaseRetreatDetail(PageData object) throws Exception;
    PurchaseRetreatDetail findPurchaseRetreatDetailById(String id) throws Exception;

    List<PurchaseRetreatDetail> findPurchaseRetreatDetailList(PageData object) throws Exception;
    List<PurchaseRetreatDetail> findPurchaseRetreatDetailListByParentId(String parentId) throws Exception;

    List<PurchaseRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<PurchaseRetreatDetail> objectList);
    BigDecimal findTotalSumByDetailList(List<PurchaseRetreatDetail> objectList);

    WarehouseOutDetail retreatDetail2OutDetail(PurchaseRetreatDetail retreatDetail, WarehouseOutDetail outDetail);
    List<WarehouseOutDetail> retreatDtlList2OutDtlList(List<PurchaseRetreatDetail> retreatDtlList, Map<String, String> productMap, List<WarehouseOutDetail> outDtlList);

    String findOrderDtlIdsByRetreatDtlList(List<PurchaseRetreatDetail> objectList);
    /**
     * 获取 <采购订单明细id,<订单明细退货信息Map>
     *     订单明细退货信息Map
     *         count:退货数量
     *         amount:退货金额(订单明细-退货金额)
     * @param objectList
     * @return
     */
    Map<String, Map<String, BigDecimal>> findOrderDtlRetreatCountMap(List<PurchaseRetreatDetail> objectList);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;
    void addPurchaseRetreatDetail(PurchaseRetreat parentObj, List<PurchaseRetreatDetail> objectList) throws Exception;
    void updateOrderDetailByRetreat(Map<String, Map<String, BigDecimal>> orderDtlRetreatMap, List<PurchaseOrderDetail> orderDtlList) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageRetreatDetail(PageData pd,Pagination pg) throws Exception;


}



