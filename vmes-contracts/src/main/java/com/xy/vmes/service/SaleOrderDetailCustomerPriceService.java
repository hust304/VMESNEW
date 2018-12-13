package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailCustomerPriceService {
    List<Map<String, Object>> findOrderDetaiListByCustomer(PageData pd);

    List<Map<String, Object>> findCustomerProductPriceByOrderDetai(String customerId, String orderId);

    Map<String, Map<String, Object>> findProductPriceByOrderDetai(String customerId, String orderId);
}
