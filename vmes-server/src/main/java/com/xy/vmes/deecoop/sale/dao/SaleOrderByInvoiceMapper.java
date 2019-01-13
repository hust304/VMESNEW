package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单查询汇总 Mapper.java
 * 销售-开票管理-申请开票-(勾选订单明细)-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2019-01-11
 */
@Mapper
@Repository
public interface SaleOrderByInvoiceMapper {

    List<Map> findListPageOrderByInvoice(PageData pd, Pagination pg);
}
