package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.deecoop.sale.dao.SaleDeliverOutDetailMapper;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：发货出库 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-25
 */
@Service
@Transactional(readOnly = false)
public class SaleDeliverOutDetailServiceImp implements SaleDeliverOutDetailService {

    @Autowired
    private SaleDeliverOutDetailMapper saleDeliverOutDetailMapper;
    @Autowired
    private SaleDeliverDetailByCollectService saleDeliverByCollectService;
    @Autowired
    private ProductService productService;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    /**
     * 发货出库查询(出库明细,发货明细,订单明细)关联查询
     *
     * @param outDtlId 出库明细id
     * @param state    出库明细状态
     * @return
     */
    public Map<String, Object> findOutDetailByOrderDetail(String outDtlId, String state) {
        if (outDtlId == null || outDtlId.trim().length() == 0) {return new HashMap<String, Object>();}
        if (state == null || state.trim().length() == 0) {return new HashMap<String, Object>();}

        PageData findMap = new PageData();
        findMap.put("outDtlId", outDtlId);
        findMap.put("outDetailState", state);
        List<Map<String, Object>> list = saleDeliverOutDetailMapper.findOutDetailByOrderDetail(findMap);

        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return new HashMap<String, Object>();
    }

    /**
     * (发货出库)出库明细出库完成，
     * 根据(出库明细id,出库状态:(2已完成))关联查询(出库明细,发货明细,订单明细)
     * 1. (出库数量)修改货品库存锁定数量
     * 2. (出库数量)修改订单明细(库存锁定数量)
     * 3. (出库数量)修改订单明细状态:(订单订购数量,订单明细出库数量)
     *
     * @param outDtlId 出库明细id
     */
    public void finishOutDetailUnlock(String outDtlId) throws Exception {
        //发货出库单-出库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        Map<String, Object> mapObject = findOutDetailByOrderDetail(outDtlId, "2");

        if (mapObject != null && mapObject.size() > 0) {
            //货品id：修改该货品的库存锁定数量
            String productId = (String)mapObject.get("productId");
            if (productId != null && productId.trim().length() > 0) {
                BigDecimal outDetailCount = BigDecimal.valueOf(0D);
                if (mapObject.get("outDetailCount") != null) {
                    outDetailCount = (BigDecimal)mapObject.get("outDetailCount");
                    outDetailCount = BigDecimal.valueOf(outDetailCount.doubleValue() * -1);
                }
                productService.updateLockCount(productId, null, outDetailCount, null);
            }

            //订单明细id：修改订单明细(库存锁定数量)
            String orderDtlId = (String)mapObject.get("orderDtlId");
            if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                //获取发货出库订单(订单明细id,订购数量,出库数量)
                PageData findMap = new PageData();
                findMap.put("orderDetailId", orderDtlId);
                Map<String, Object> mapObj = saleDeliverByCollectService.findDeliverDetailOnWarehouseOutDetailByOrder(findMap);

                SaleOrderDetail orderDetail = new SaleOrderDetail();
                orderDetail.setId(orderDtlId);
                //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定
                orderDetail.setIsLockWarehouse("0");
                orderDetail.setLockCount(BigDecimal.valueOf(0D));

                //订单明细id 出库是否完成 (订单明细订购数量(计量单位))productCount (订单明细出库数量)deliverOutCount
                if (mapObj != null
                    && mapObj.get("productCount") != null
                    && mapObj.get("deliverOutCount") != null
                ) {
                    BigDecimal productCount = (BigDecimal)mapObj.get("productCount");
                    BigDecimal deliverOutCount = (BigDecimal)mapObj.get("deliverOutCount");
                    if (deliverOutCount.doubleValue() >= productCount.doubleValue()) {
                        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
                        orderDetail.setState("4");
                    }
                }
                saleOrderDetailService.update(orderDetail);
            }
        }
    }
}
