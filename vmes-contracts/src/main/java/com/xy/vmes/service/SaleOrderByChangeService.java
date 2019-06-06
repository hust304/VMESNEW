package com.xy.vmes.service;

import com.xy.vmes.entity.SaleOrderDetailEntity;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderByChangeService {

    /**
     * 变更订单-变更订单明细(订购数量,锁定货品数量)
     * dtlJsonStr: 界面(model_code = 'saleOrderDetailByChange')
     *
     * 订单单明细表
     * id: rowData.id,
     * parentId: rowData.parentId,
     * productId: rowData.productId,
     * lockCount: rowData.lockCount,
     * state: rowData.state,

     * newOrderCount: rowData.newOrderCount,
     * newProductSum: rowData.newProductSum,
     * newNeedDeliverCount: rowData.newNeedDeliverCount,
     * p2nFormula: rowData.p2nFormula,
     * n2pFormula: rowData.n2pFormula
     * stockCount: rowData.stockCount
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    ResultModel updateSaleOrderByChange(PageData pageData) throws Exception;


    List<SaleOrderDetailEntity> orderChangeMapList2OrderDtlList(List<Map<String, String>> mapList, List<SaleOrderDetailEntity> objectList);

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 2:待生产 readyProduce
     * 修改订单明细(订购数量,金额,货品数量(计量单位))
     *
     * @param objectList
     */
    void orderChangeByReadyProduce(List<SaleOrderDetailEntity> objectList) throws Exception;

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 3:待出库 readyOut
     *
     * 修改订单明细(订购数量,金额,货品数量(计量单位),可发货数量(计价单位),锁定货品数量(计量单位))
     * 修改货品表(lockCount:lock_count:锁定库存数量)
     *
     * @param objectList
     */
    void orderChangeByReadyOut(List<SaleOrderDetailEntity> objectList, String companyId) throws Exception;

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 4:待发货 readyDeliver
     *
     * 修改订单明细(订购数量,金额,货品数量(计量单位),可发货数量(计价单位),锁定货品数量(计量单位))
     * 修改货品表(lockCount:lock_count:锁定库存数量)
     * 取消出库单
     * 取消发货单
     *
     * @param orderId
     * @param cuser
     * @param companyId
     * @param objectList
     */
    void orderChangeByReadyDeliver(String orderId,
                                   String cuser,
                                   String companyId,
                                   List<SaleOrderDetailEntity> objectList) throws Exception;
}
