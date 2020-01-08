package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchaseOrderDetailCollectMapper;
import com.xy.vmes.service.PurchaseOrderDetailToolService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：采购订单明细工具实现类 (vmes_purchase_order_detail:采购订单明细表)
 * 创建人：陈刚
 * 创建时间：2019-07-17
 */

@Service
public class PurchaseOrderDetailToolServiceImp implements PurchaseOrderDetailToolService {
    @Autowired
    private PurchaseOrderDetailCollectMapper purchaseOrderDetailCollectMapper;

    /**
     * 获取(采购明细id,采购数量,签收数量,退货数量[已完成])Map<String, Map<String, Object>>结构体
     * 根据(采购订单明细id)采购订单明细汇总查询
     *
     * Map<采购订单明细id, 采购明细Map<String, Object>>
     * 采购明细Map<String, Object>
     *     detailId: 采购订单明细id
     *     parentId: 采购订单id
     *     detailCount: 采购数量
     *     signCount: 签收数量
     *     retreatCount: 退货数量(已完成)
     *     arriveCount: 到货数量:= 签收数量 - 退货数量(已完成)
     *
     * @param purchaseOrderId  采购订单Id
     * @return
     */
    public Map<String, Map<String, Object>> findPurchaseOrderDetailMap(String purchaseOrderId) {
        Map<String, Map<String, Object>> detailMap = new HashMap<String, Map<String, Object>>();
        if (purchaseOrderId == null || purchaseOrderId.trim().length() == 0) {return detailMap;}

        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            PageData findMap = new PageData();
            findMap.put("parentId", purchaseOrderId);
            mapList = purchaseOrderDetailCollectMapper.findPurchaseOrderDetailCollect(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                //detailId: 采购订单明细id
                String detailId = (String)objectMap.get("detailId");
                detailMap.put(detailId, objectMap);
            }
        }

        return detailMap;
    }

//    /**
//     * 获取(采购明细id,采购数量,签收数量,退货数量[已完成])Map<String, Map<String, Object>>结构体
//     * 根据(采购订单明细id)采购订单明细汇总查询
//     *
//     * Map<采购订单明细id, 采购明细Map<String, Object>>
//     * 采购明细Map<String, Object>
//     *     detailId: 采购订单明细id
//     *     parentId: 采购订单id
//     *     detailCount: 采购数量
//     *     signCount: 签收数量
//     *     retreatCount: 退货数量(已完成)
//     *     arriveCount: 到货数量:= 签收数量 - 退货数量(已完成)
//     *
//     * @param detailIds  采购订单明细Id(','逗号分隔的字符串)
//     * @return
//     */
//    public Map<String, Map<String, Object>> findPurchaseOrderDetailMapByDetail(String detailIds) {
//        Map<String, Map<String, Object>> detailMap = new HashMap<String, Map<String, Object>>();
//        if (detailIds == null || detailIds.trim().length() == 0) {return detailMap;}
//
//        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//        try {
//            PageData findMap = new PageData();
//            detailIds = StringUtil.stringTrimSpace(detailIds);
//            detailIds = "'" + detailIds.replace(",", "','") + "'";
//            findMap.put("detailIds", detailIds);
//            mapList = purchaseOrderDetailCollectMapper.findPurchaseOrderDetailCollect(findMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (mapList != null && mapList.size() > 0) {
//            for (Map<String, Object> objectMap : mapList) {
//                //detailId: 采购订单明细id
//                String detailId = (String)objectMap.get("detailId");
//                detailMap.put(detailId, objectMap);
//            }
//        }
//
//        return detailMap;
//    }

}
