package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailByCollectMapper;
import com.xy.vmes.service.SaleDeliverDetailByCollectService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：发货明细汇总 Service 实现类
 * 创建人：陈刚
 * 创建时间：2019-01-18
 */
@Service
@Transactional(readOnly = false)
public class SaleDeliverDetailByCollectServiceImp implements SaleDeliverDetailByCollectService {
    @Autowired
    private SaleDeliverDetailByCollectMapper saleDeliverDetailByCollectMapper;

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
     * 获取发货出库订单(订单明细id,订购数量,出库数量)
     *
     * @param pageData
     *     orderDetailId:订单明细id
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData) throws Exception {
        List<Map<String, Object>> mapList = saleDeliverDetailByCollectMapper.findDeliverDetailOnWarehouseOutDetailByOrder(pageData);
        if (mapList != null && mapList.size() > 0) { return mapList.get(0);}

        return null;
    }

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    public List<Map<String, Object>> findDeliverDetailByOrderDetaiCount(PageData pageData) throws Exception {
        return saleDeliverDetailByCollectMapper.findDeliverDetailByOrderDetaiCount(pageData);
    }

    /**
     * 根据发货单id-获取(订单明细id,订购数量,发货数量)
     *
     * @param deliverId       发货单id
     * @param deliveDtlState  发货单明细状态
     * @param retreatDtlState 退货单明细状态
     * @param orderDtlIds     订单明细id
     * @return
     */
    public Map<String, Map<String, BigDecimal>> findMapOrderDetaiCountByDeliverId(String deliverId, String deliveDtlState, String retreatDtlState, String orderDtlIds) throws Exception {
        Map<String, Map<String, BigDecimal>> mapObject = new HashMap<String, Map<String, BigDecimal>>();
        if (deliverId == null || deliverId.trim().length() == 0) {return mapObject;}

        PageData findMap = new PageData();
        findMap.put("deliverId", deliverId);
        findMap.put("deliveDtlState", deliveDtlState);
        findMap.put("retreatDtlState", retreatDtlState);
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            findMap.put("orderDtlIds", orderDtlIds);
        }
        List<Map<String, Object>> mapList = this.findDeliverDetailByOrderDetaiCount(findMap);
        if (mapList == null || mapList.size() == 0) {return mapObject;}

        for (Map<String, Object> mapObj : mapList) {

            //订单明细id orderDetailId
            String orderDtlId = (String)mapObj.get("orderDetailId");

            Map<String, BigDecimal> mapValue = new HashMap<String, BigDecimal>();

            //订单明细订购数量 orderCount
            BigDecimal orderCount = (BigDecimal)mapObj.get("orderCount");
            mapValue.put("orderCount", orderCount);

//            //订单明细 可发货数量 needDeliverCount
//            BigDecimal needDeliverCount = (BigDecimal)mapObj.get("needDeliverCount");
//            mapValue.put("needDeliverCount", needDeliverCount);
//
//            //订单明细发货数量 orderDtlDeliverCount
//            BigDecimal orderDtlDeliverCount = (BigDecimal)mapObj.get("orderDtlDeliverCount");
//            mapValue.put("orderDtlDeliverCount", orderDtlDeliverCount);
//
//            //订单明细发货金额
//            BigDecimal orderDtlDeliverSum = (BigDecimal)mapObj.get("orderDtlDeliverSum");
//            mapValue.put("orderDtlDeliverSum", orderDtlDeliverSum);

            //checkCount 验证数量(发货数量-退货数量)
            BigDecimal checkCount = (BigDecimal)mapObj.get("checkCount");
            mapValue.put("checkCount", checkCount);

            //checkSum 验证金额(发货金额-退货金额)
            BigDecimal checkSum = (BigDecimal)mapObj.get("checkSum");
            mapValue.put("checkSum", checkSum);

            mapObject.put(orderDtlId, mapValue);
        }

        return mapObject;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail)
     * 获取发货出库订单(订单明细id,订购数量,发货数量)
     *
     * 创建人：陈刚
     * 创建时间：2019-01-18
     */
    public List<Map<String, Object>> findDeliverDetailCollectByOrderDetaiCount(PageData pageData) throws Exception {
        return saleDeliverDetailByCollectMapper.findDeliverDetailByOrderDetai(pageData);
    }


    /**
     * 根据发货单id-获取(订单明细id,订购数量,发货数量)
     *
     * @param orderIds  订单单id
     * @return
     */
    public Map<String, Map<String, Object>> findMapOrderDetaiCountByOrderId(String orderIds) throws Exception {
        Map<String, Map<String, Object>> mapObject = new HashMap<String, Map<String, Object>>();
        if (orderIds == null || orderIds.trim().length() == 0) {return mapObject;}

        PageData findMap = new PageData();
        orderIds = StringUtil.stringTrimSpace(orderIds);
        orderIds = "'" + orderIds.replace(",", "','") + "'";
        findMap.put("orderIds", orderIds);

        List<Map<String, Object>> mapList = this.findDeliverDetailCollectByOrderDetaiCount(findMap);
        if (mapList == null || mapList.size() == 0) {return mapObject;}

        for (Map<String, Object> mapObj : mapList) {
            Map<String, Object> mapValue = new HashMap<String, Object>();

            //订单明细id orderDtlId
            String orderDtlId = (String)mapObj.get("orderDtlId");
            //订单id orderId
            String orderId = (String)mapObj.get("orderId");
            mapValue.put("orderId", orderId);

            //订单明细订购数量 orderDtlCount
            BigDecimal orderDtlCount = (BigDecimal)mapObj.get("orderDtlCount");
            mapValue.put("orderDtlCount", orderDtlCount);

            //货品金额 orderDtlSum
            BigDecimal orderDtlSum = (BigDecimal)mapObj.get("orderDtlSum");
            mapValue.put("orderDtlSum", orderDtlSum);

//            //订单明细发货数量 orderDtlDeliverCount
//            BigDecimal orderDtlDeliverCount = (BigDecimal)mapObj.get("orderDtlDeliverCount");
//            mapValue.put("orderDtlDeliverCount", orderDtlDeliverCount);
//
//            //订单明细发货金额 orderDtlDeliverSum
//            BigDecimal orderDtlDeliverSum = (BigDecimal)mapObj.get("orderDtlDeliverSum");
//            mapValue.put("orderDtlDeliverSum", orderDtlDeliverSum);

            //checkCount 验证数量(发货数量-退货数量)
            BigDecimal checkCount = (BigDecimal)mapObj.get("checkCount");
            mapValue.put("checkCount", checkCount);

            //checkSum 验证金额(发货金额-退货金额)
            BigDecimal checkSum = (BigDecimal)mapObj.get("checkSum");
            mapValue.put("checkSum", checkSum);

            mapObject.put(orderDtlId, mapValue);
        }

        return mapObject;
    }

}
