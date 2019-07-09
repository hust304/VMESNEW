package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailCustomerPriceMapper;
import com.xy.vmes.service.SaleOrderDetailCustomerPriceService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderDetailCustomerPriceServiceImp implements SaleOrderDetailCustomerPriceService {
    @Autowired
    private SaleOrderDetailCustomerPriceMapper orderDetailCustomerPriceMapper;

    public List<Map<String, Object>> findOrderDetaiListByCustomer(PageData pd) {
        return orderDetailCustomerPriceMapper.findOrderDetaiListByCustomer(pd);
    }

    public List<Map<String, Object>> findCustomerProductPriceByOrderDetai(String customerId, String orderId) {
        PageData pageData = new PageData();
        if (customerId != null && customerId.trim().length() > 0) {
            pageData.put("customerId", customerId);
        }
        if (orderId != null && orderId.trim().length() > 0) {
            pageData.put("orderId", orderId);
        }
        pageData.put("queryStr", "(detail.product_id is not null and detail.price_unit is not null and detail.product_price is not null)");

        return this.findOrderDetaiListByCustomer(pageData);
    }

    public Map<String, Map<String, Object>> findProductPriceByOrderDetai(String customerId, String orderId) {
        List<Map<String, Object>> mapList = this.findCustomerProductPriceByOrderDetai(customerId, orderId);
        if (mapList == null || mapList.size() == 0) {return new LinkedHashMap<String, Map<String, Object>>();}

        //遍历查询结果集，获取货品最新价格
        Map<String, Map<String, Object>> productPriceMap = new LinkedHashMap<String, Map<String, Object>>();
        for (Map<String, Object> mapObj : mapList) {
            String productId = (String)mapObj.get("productKey");
            productPriceMap.put(productId, mapObj);
        }

        return productPriceMap;
    }
}
