package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_product:仓库货位产品库存表 接口类
 * 关联查询表(vmes_warehouse_product,vmes_warehouse,vmes_product)
 *
 * 创建人：陈刚
 * 创建时间：2019-11-14
 */
public interface WarehouseProductQueryService {

    List<Map> findWarehouseProductQuery(PageData pd, Pagination pg);

}
