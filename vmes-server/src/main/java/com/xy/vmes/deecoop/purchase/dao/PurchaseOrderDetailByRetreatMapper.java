package com.xy.vmes.deecoop.purchase.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PurchaseOrderDetailByRetreatMapper {
    List<Map> findOrderDetailByRetreat(PageData pd);
}
