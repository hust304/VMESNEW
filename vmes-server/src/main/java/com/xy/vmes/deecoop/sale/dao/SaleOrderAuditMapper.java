package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SaleOrderAuditMapper {

    List<Map<String, Object>> findOrderDetaiListByAudit(PageData pd);
    List<Map> findPageListByLockStock(PageData pd);
}
