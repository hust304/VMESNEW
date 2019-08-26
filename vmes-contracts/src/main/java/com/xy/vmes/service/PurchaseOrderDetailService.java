package com.xy.vmes.service;


import com.xy.vmes.entity.PurchaseOrderDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_order_detail:采购订单明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-03-05
*/
public interface PurchaseOrderDetailService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void save(PurchaseOrderDetail purchaseOrderDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void update(PurchaseOrderDetail purchaseOrderDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void updateAll(PurchaseOrderDetail purchaseOrderDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    PurchaseOrderDetail selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<PurchaseOrderDetail> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<PurchaseOrderDetail> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<PurchaseOrderDetail> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void updateByDefined(PageData pd)throws Exception;

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
    List<PurchaseOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchaseOrderDetails(PageData pd,Pagination pg) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelPurchaseOrderDetails(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelPurchaseOrderDetails(MultipartFile file) throws Exception;

    ResultModel deletePurchaseOrderDetail(PageData pageData) throws Exception;

    ResultModel recoveryPurchaseOrderDetail(PageData pageData) throws Exception;

    ResultModel cancelPurchaseOrderDetail(PageData pageData) throws Exception;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    PurchaseOrderDetail findPurchaseOrderDetail(PageData object) throws Exception;
    PurchaseOrderDetail findPurchaseOrderDetailById(String id) throws Exception;

    List<PurchaseOrderDetail> findPurchaseOrderDetailList(PageData object) throws Exception;
    List<PurchaseOrderDetail> findPurchaseOrderDetailListByParentId(String parentId) throws Exception;

    BigDecimal findTotalSumByDetailList(List<PurchaseOrderDetail> objectList);

    List<Map<String, Object>> findOrderDetaiByCollect(PageData pageData) throws Exception;
    /**
     * 按采购订单id-获取采购订单明细信息
     * <采购订单明细id, 采购订单明细信息Map>
     *     发货信息Map
     *         orderDtlCount:     采购订单明细采购数量
     *         orderDtlAmount:    采购订单明细采购金额
     *         orderDtlSignCount: 采购订单明细签收数量
     *         checkCount: 验证数量(签收数量-退货数量)
     *
     * 根据采购订单id-获取(采购订单明细id,采购数量,签收数量)
     *
     * @param orderIds  采购订单id
     * @return
     */
    Map<String, Map<String, Object>> findMapOrderDetaiCountByOrderId(String orderIds) throws Exception;

    /**
     * 采购订单明细状态，在采购订单明细List<PurchaseOrderDetail>中是否全部相同
     *   true : 全部相同，在入库单明细List
     *   false: 一条或多条不同，在入库单明细List
     *
     * @param state       明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
     * @param objectList  订单明细List<SaleOrderDetail>
     * @return
     */
    boolean isAllExistStateByDetailList(String state, List<PurchaseOrderDetail> objectList);

    /**
     * 获取Map结构体
     * 遍历JsonMapList-根据货品属性(productGenre)-返回Map结构体
     * 1.货品属性:productGenre:备件   添加到:warehouseList
     * 2.货品属性:productGenre:非备件 添加到:spareList
     *
     * Map<String, List<Map<String, String>>>
     *     warehouseList: 复杂版仓库,简版仓库
     *     spareList:     备件库
     *
     * @param jsonMapList 页面JsonMapList
     * @return
     */
    Map<String, List<Map<String, String>>> findMapByProductGenre(List<Map<String, String>> jsonMapList);

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByIn(List<Map<String, String>> jsonMapList);
    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> jsonMapList);


}



