package com.xy.vmes.deecoop.sale.service;

import com.yvan.common.util.Common;
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
    private SaleDeliverDetailByCollectService saleDeliverDetailByCollectService;
    @Autowired
    private ProductService productService;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    public List<Map<String, Object>> findDeliverDetailListByOrderId(String orderId, String state) {
        PageData findMap = new PageData();
        findMap.put("orderId", orderId);
        //发货明细状态(0:待发货 1:已发货 -1:已取消)
        findMap.put("deliverDtlState", "0");

        List<Map<String, Object>> list = null;
        try{
            list = saleDeliverOutDetailMapper.findOutDetailByOrderDetail(findMap);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Map<String, Object>> findDeliverDetailListByDeliverId(String deliverId) {
        PageData findMap = new PageData();
        findMap.put("deliverId", deliverId);

        return saleDeliverOutDetailMapper.findOutDetailByOrderDetail(findMap);

    }

    /**
     * 发货出库查询(出库明细,发货明细,订单明细)关联查询
     *
     * @param outDtlId 出库明细id
     * @param state    出库明细状态
     * @return
     */
    public Map<String, Object> findOutDetailByOrderDetail(String outDtlId, String state) {
        if (outDtlId == null || outDtlId.trim().length() == 0) {return new HashMap<String, Object>();}
        //if (state == null || state.trim().length() == 0) {return new HashMap<String, Object>();}

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
     *
     * @param outDtlId 出库明细id
     */
    public void finishOutDetailUnlock(String outDtlId) throws Exception {
        //发货出库单-出库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        Map<String, Object> mapObject = findOutDetailByOrderDetail(outDtlId, null);

        if (mapObject != null && mapObject.size() > 0) {
            //货品id：修改该货品的库存锁定数量
            String productId = (String)mapObject.get("productId");
            BigDecimal outDetailCount = BigDecimal.valueOf(0D);
            if (productId != null && productId.trim().length() > 0) {
                if (mapObject.get("outDetailCount") != null) {
                    outDetailCount = (BigDecimal)mapObject.get("outDetailCount");
                    outDetailCount = BigDecimal.valueOf(outDetailCount.doubleValue() * -1);
                }
                productService.updateLockCount(productId, null, outDetailCount, null);
            }

            //锁定库存数量 lockCount 订单明细
            BigDecimal lockCount = null;
            if (mapObject.get("lockCount") != null) {
                lockCount = (BigDecimal)mapObject.get("lockCount");
            }

            //订单明细id：修改订单明细(库存锁定数量)
            String orderDtlId = (String)mapObject.get("orderDtlId");
            if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                SaleOrderDetail orderDetail = new SaleOrderDetail();
                orderDetail.setId(orderDtlId);

                if (lockCount != null) {
                    BigDecimal changeLockCount = BigDecimal.valueOf(lockCount.doubleValue() + outDetailCount.doubleValue());
                    if (changeLockCount.doubleValue() <= 0 ) {
                        //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定
                        orderDetail.setIsLockWarehouse("0");
                        orderDetail.setLockCount(BigDecimal.valueOf(0D));
                        orderDetail.setNeedDeliverCount(BigDecimal.valueOf(0D));
                    } else {
                        //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定
                        orderDetail.setIsLockWarehouse("1");
                        //四舍五入到2位小数
                        changeLockCount = changeLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        orderDetail.setLockCount(changeLockCount);
                        orderDetail.setNeedDeliverCount(changeLockCount);
                    }
                }

//                //获取发货出库订单(订单明细id,订购数量,出库数量)
//                PageData findMap = new PageData();
//                findMap.put("orderDetailId", orderDtlId);
//                Map<String, Object> mapObj = saleDeliverDetailByCollectService.findDeliverDetailOnWarehouseOutDetailByOrder(findMap);
//                //订单明细id 出库是否完成 (订单明细订购数量(计量单位))productCount (订单明细出库数量)deliverOutCount
//                if (mapObj != null
//                    && mapObj.get("productCount") != null
//                    && mapObj.get("deliverOutCount") != null
//                ) {
//                    BigDecimal productCount = (BigDecimal)mapObj.get("productCount");
//                    BigDecimal deliverOutCount = (BigDecimal)mapObj.get("deliverOutCount");
//                    if (deliverOutCount.doubleValue() >= productCount.doubleValue()) {
//                        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
//                        orderDetail.setState("4");
//                    }
//                }
                saleOrderDetailService.update(orderDetail);
            }
        }
    }
}
