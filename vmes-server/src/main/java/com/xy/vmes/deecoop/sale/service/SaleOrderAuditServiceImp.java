package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.deecoop.sale.dao.SaleOrderAuditMapper;
import com.xy.vmes.service.SaleOrderAuditService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderAuditServiceImp implements SaleOrderAuditService {
    @Autowired
    private SaleOrderAuditMapper saleOrderAuditMapper;

    public List<Map> findPageListByLockStock(PageData pd) throws Exception {
        return saleOrderAuditMapper.findPageListByLockStock(pd);
    }

    public List<Map<String, Object>> findOrderDetaiListByAudit(PageData pd) {
        return saleOrderAuditMapper.findOrderDetaiListByAudit(pd);
    }

    /**
     * 当前订单id下的订单明细(货品id)货品可用库存数量与订购数量比较
     * @param orderId  订单id
     * @return
     */
    public List<Map<String, Object>> checkProdStockCountByOrderId(String orderId) {
        if (orderId == null || orderId.trim().length() == 0) {new ArrayList();}

        PageData pageData = new PageData();
        pageData.put("parentId", orderId);
        //isLockWarehouse:是否锁定仓库(0:未锁定 1:已锁定)
        pageData.put("isLockWarehouse", "0");

        List<Map<String, Object>> needLockStockList = new ArrayList();
        List<Map<String, Object>> mapList = this.findOrderDetaiListByAudit(pageData);
        for (Map<String, Object> mapObject : mapList) {
            //货品数量(计量数量) productCount
            BigDecimal productCount = (BigDecimal)mapObject.get("productCount");

            //货品库存可用数量 allowStockCount
            BigDecimal allowStockCount = (BigDecimal)mapObject.get("allowStockCount");

            if (allowStockCount != null && productCount != null
                && productCount.doubleValue() > 0
                && allowStockCount.doubleValue() > 0
            ) {
                needLockStockList.add(mapObject);
            }
        }

        return needLockStockList;
    }

    public String findDetailIdsByMapList(List<Map<String, Object>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, Object> mapObject : mapList) {
            String detailId = (String)mapObject.get("id");
            if (detailId != null && detailId.trim().length() > 0)  {
                strBuf.append(detailId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strTemp;
    }
}
