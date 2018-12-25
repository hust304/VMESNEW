package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：发货出库 Mapper.java
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-25
 */
@Mapper
@Repository
public interface SaleDeliverOutDetailMapper {
    /**
     * 发货出库查询(出库明细,发货明细,订单明细)关联查询
     *
     * @param pd
     * @return
     */
    List<Map<String, Object>> findOutDetailByOrderDetail(PageData pd);
}
