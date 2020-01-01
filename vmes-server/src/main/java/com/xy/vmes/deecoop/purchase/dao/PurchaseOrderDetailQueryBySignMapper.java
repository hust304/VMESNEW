package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：采购订单明细查询汇总 Mapper.java
 * 采购-采购收货-生成收货单-收货-弹出界面查询
 *
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-29
 */
@Mapper
@Repository
public interface PurchaseOrderDetailQueryBySignMapper {
    List<Map> listOrderDetaiQueryBySign(PageData pd);
    List<Map> listOrderDetaiQueryBySign(PageData pd, Pagination pg);
}
