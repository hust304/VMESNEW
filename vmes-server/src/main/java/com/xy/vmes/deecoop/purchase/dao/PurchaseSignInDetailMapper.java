package com.xy.vmes.deecoop.purchase.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：采购签收明细关联入库明细 Mapper.java
 * 创建人：陈刚
 * 创建时间：2020-01-10
 */
@Mapper
@Repository
public interface PurchaseSignInDetailMapper {
    List<Map<String, Object>> findSignDetailByInDetail(PageData pd);
}
