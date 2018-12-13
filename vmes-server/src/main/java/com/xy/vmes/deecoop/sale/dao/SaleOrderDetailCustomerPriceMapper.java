package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SaleOrderDetailCustomerPriceMapper {
    List<Map<String, Object>> findOrderDetaiListByCustomer(PageData pd);

}
