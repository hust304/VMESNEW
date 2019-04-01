package com.xy.vmes.common.util;

import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.ProductService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by 46368 on 2018/11/30.
 */

@Component
public class Consumer {
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;
    @Autowired
    private ProductService productService;

    /**
     * 消息队列接收消息-货品锁定库存解锁-信息队列信息:(订单明细id,锁定库存版本号)
     * 销售-订单管理-订单明细-订单明细货品锁定库存
     *
     * 1. 修改货品锁定库存数量
     * 2. 修改订单明细锁库字段
     *
     * @param activeMQ_msg  信息队列信息:(订单明细id,锁定库存版本号)
     *
     */
    @JmsListener(destination = "sale.orderDetail.ProductLockcount.queue")
    public void receiveProductLockcount (String activeMQ_msg) throws Exception {
        if (activeMQ_msg == null || activeMQ_msg.trim().length() == 0) {return;}
        String[] strArray = activeMQ_msg.split(",");

        String orderDtlId = "";
        if (strArray != null && strArray.length >= 1) {
            orderDtlId = strArray[0];
        }

        String versionLockCount = "";
        if (strArray != null && strArray.length >= 2) {
            versionLockCount = strArray[1];
        }

        PageData findMap = new PageData();
        findMap.put("orderDtlId", orderDtlId);
        findMap.put("versionLockCount", versionLockCount);

        SaleOrderDetail orderDetail = saleOrderDetailService.findSaleOrderDetail(findMap);
        //is_lock_warehouse 是否锁定仓库(0:未锁定 1:已锁定
        if (orderDetail != null && "1".equals(orderDetail.getIsLockWarehouse())) {
            //锁定货品数量
            BigDecimal lockCount = BigDecimal.valueOf(0D);
            if (orderDetail.getLockCount() != null) {
                lockCount = orderDetail.getLockCount();
            }

            //货品ID
            String productId = orderDetail.getProductId();
            if (productId != null && productId.trim().length() > 0) {
                lockCount = BigDecimal.valueOf(lockCount.doubleValue() * -1);
                productService.updateLockCount(productId, null, lockCount, null);
            }

            //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定
            orderDetail.setIsLockWarehouse("0");
            orderDetail.setLockCount(BigDecimal.valueOf(0D));
            saleOrderDetailService.update(orderDetail);
        }
    }

}
