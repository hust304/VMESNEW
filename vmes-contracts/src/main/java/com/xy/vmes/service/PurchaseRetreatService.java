package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseRetreat;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_retreat:退货单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-05-09
*/
public interface PurchaseRetreatService {
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-05-09
    */
    void save(PurchaseRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void update(PurchaseRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void updateAll(PurchaseRetreat object) throws Exception;

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
    PurchaseRetreat selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreat> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreat> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByRetreat(String state, String ids) throws Exception;

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
    List<PurchaseRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseRetreat findPurchaseRetreat(PageData object) throws Exception;
    PurchaseRetreat findPurchaseRetreatById(String id) throws Exception;
    List<PurchaseRetreat> findPurchaseRetreatList(PageData object) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    /**
//     * 修改订单明细和订单
//     * 修改采购订单明细-变更订单明细(订购数量,货品金额)
//     *
//     * @param valueMap 入口参数
//     * 参数说明:
//     * Map<String, Object>
//     *   retreatId:          退货单id
//     *   realityTotal:       退货金额
//     *   orderDtlRetreatMap: 采购订单明细退货信息
//     *   orderDtlList:       采购订单明细
//     */
//    void updatePurchaseOrder(Map<String, Object> valueMap) throws Exception;

//    /**
//     * 创建(负值)的付款单
//     *
//     * @param realityTotal 金额
//     * @param supplierId   供应商id
//     * @param companyId    企业id
//     * @param orderId      采购订单id
//     * @param cuser        用户id
//     */
//    void createPurchasePaymentByMinus(BigDecimal realityTotal,
//                                      String supplierId,
//                                      String companyId,
//                                      String orderId,
//                                      String cuser) throws Exception;

//    /**
//     * 创建(正值)的付款单
//     *
//     * @param realityTotal 金额
//     * @param supplierId   供应商id
//     * @param companyId    企业id
//     * @param orderId      采购订单id
//     * @param cuser        用户id
//     */
//    void createPurchasePaymentByPlus(BigDecimal realityTotal,
//                                     String supplierId,
//                                     String companyId,
//                                     String orderId,
//                                     String cuser) throws Exception;

    /**
     * 生成采购退货单-采购质量检验(退货)
     * @param cuser      用户id
     * @param companyId  企业id
     * @param objectMap  质量检验jsonMap
     */
    String createRetreatByQuality(String cuser, String companyId, Map<String, String> objectMap) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageRetreat(PageData pd,Pagination pg) throws Exception;
    ResultModel addPurchaseRetreat(PageData pageData) throws Exception;
    //ResultModel auditPassPurchaseRetreat(PageData pageData) throws Exception;
    ResultModel auditDisagreePurchaseRetreat(PageData pageData) throws Exception;

    //////////////////////////////////////////////////////////////////////////////////
    /**
     * 返回货品出库Map
     * 货品出库Map<业务id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:   出库明细id
     *     outCount:   出库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByOut(List<Map<String, String>> jsonMapList);

    /**
     * 返回货品入库Map
     * 货品出库Map<业务id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByIn(List<Map<String, String>> jsonMapList);


}



