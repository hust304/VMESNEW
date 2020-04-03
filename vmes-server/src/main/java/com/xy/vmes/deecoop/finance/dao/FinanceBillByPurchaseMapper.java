package com.xy.vmes.deecoop.finance.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_finance_bill:采购财务单 Mapper.java
 *
 * 创建人：陈刚
 * 创建时间：2020-04-03
 */
@Mapper
@Repository
public interface FinanceBillByPurchaseMapper {
    List<Map> findFinanceBillByPurchaseView(PageData pd, Pagination pg);
    List<Map> findFinanceBillByPurchaseView(PageData pd);
}
