package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.*;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_order_detail:订单明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-12-05
*/
public interface SaleOrderDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void save(SaleOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void update(SaleOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void updateAll(SaleOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    SaleOrderDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    List<SaleOrderDetail> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    List<SaleOrderDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

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
    List<SaleOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleOrderDetail findSaleOrderDetail(PageData object) throws Exception;
    SaleOrderDetail findSaleOrderDetailById(String id) throws Exception;

    List<SaleOrderDetail> findSaleOrderDetailList(PageData object) throws Exception;
    List<SaleOrderDetail> findSaleOrderDetailListByParentId(String parentId) throws Exception;

    List<SaleOrderDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList);
    List<SaleOrderDetail> mapList2OrderDetailListByEdit(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList);

    //String findProductIdsByDetailList(List<SaleOrderDetail> objectList);
    //String findDetailIdsByDetailList(List<SaleOrderDetail> objectList);
    //String findOrderIdsByDetailList(List<SaleOrderDetail> objectList);

    SaleDeliverDetail orderDetail2DeliverDetail(SaleOrderDetailEntity orderDetail, SaleDeliverDetail deliverDetail);
    List<SaleDeliverDetail> orderDtlList2DeliverDtllList(List<SaleOrderDetailEntity> orderDtlList, List<SaleDeliverDetail> deliverDtlList);

    WarehouseOutDetail orderDetail2OutDetail(SaleOrderDetailEntity orderDetail, WarehouseOutDetail outDetail);
    //List<WarehouseOutDetail> orderDtlList2OutDtlList(List<SaleOrderDetailEntity> orderDtlList, List<WarehouseOutDetail> outDtlList);

    SaleInvoiceDetail orderDetail2InvoiceDetail(SaleOrderDetail orderDetail, SaleInvoiceDetail invoiceDetail);
    List<SaleInvoiceDetail> orderDtlList2InvoiceDtlList(List<SaleOrderDetail> orderDtlList, List<SaleInvoiceDetail> invoiceDtlList);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    BigDecimal findTotalSumByDetailList(List<SaleOrderDetail> objectList);
    BigDecimal findTotalSumByPrice(List<SaleOrderDetail> objectList);

    //void addSaleOrderDetail(SaleOrder parentObj, List<SaleOrderDetail> objectList) throws Exception;
    void updateStateByDetail(PageData pd) throws Exception;
    void updateStateByDetail(String state, String parentIds) throws Exception;
    /**
     * 修改订单明细状态
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     *
     * 1. 根据订单id-获取订单明细List-(vmes_sale_order_detail)
     * 2. 根据订单id-获取发货明细(当前订单id)-(vmes_sale_deliver_detail)
     * 3. 2:待生产: 可发货数量 is null or 可发货数量 == 0
     * 4. 3:待出库: 可发货数量 > 0 and 无未完成的发货明细
     * 5. 4:待发货: 可发货数量 > 0 and 存在
     *
     * @param orderId
     * @param orderDetailList
     * @throws Exception
     */
    void updateDetailStateByOrderId(String orderId, List<SaleOrderDetail> orderDetailList) throws Exception;
    //void updateLockCount(PageData pd) throws Exception;

    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成(发货) -1:已取消)
     *
     * @param parent       订单对象
     * @param dtllList     订单明细List<SaleOrderDetail>
     */
    void updateParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtllList) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //退货单修改(订单明细,订单) 状态
//    void updateOrderState(Map<String, Map<String, Object>> orderDtlMap,
//                          Map<String, Map<String, BigDecimal>> orderReceiveMap) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
     *   true : 全部相同，在订单明细List
     *   false: 一条或多条不同，在订单明细List
     *
     * @param state       明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * @param objectList  订单明细List<SaleOrderDetail>
     * @return
     */
    boolean isAllExistStateByDetailList(String state, List<SaleOrderDetail> objectList);

//    /**
//     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
//     *   true : 一条或多条相同，在订单明细List
//     *   false: 全部不同，在订单明细List
//     *
//     * @param state       明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//     * @param objectList  盘点单明细List<SaleOrderDetail>
//     * @return
//     */
//    boolean isExistStateByDetailList(String state, List<SaleOrderDetail> objectList);

//    /**
//     * 获取订单状态-根据订单明细状态
//     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
//     *
//     * @param dtlList      订单明细List<SaleOrderDetail>
//     * @return
//     */
//    String findParentStateByDetailList(List<SaleOrderDetail> dtlList);
//    SaleOrder findParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtlList);


    /**
     * 获取订单状态-根据订单明细状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成(发货) -1:已取消)
     *
     * @param dtlList      订单明细List<SaleOrderDetail>
     * @return
     */
    String findParentStateByDetail(List<SaleOrderDetail> dtlList);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageSaleOrderDetail(PageData pd, Pagination pg) throws Exception;

    ResultModel cancelSaleOrderDetail(PageData pageData)  throws Exception;

    ResultModel deleteSaleOrderDetail(PageData pageData) throws Exception;

    ResultModel rebackSaleOrderDetailByLockCount(PageData pageData) throws Exception;

    //void exportExcelSaleOrderDetails(PageData pd, Pagination pg) throws Exception;

    //ResultModel importExcelSaleOrderDetails(MultipartFile file) throws Exception;

//    //订单变更-按变更订单明细变更
//    ResultModel changeSaleOrderByDetail(PageData pageData) throws Exception;
}



