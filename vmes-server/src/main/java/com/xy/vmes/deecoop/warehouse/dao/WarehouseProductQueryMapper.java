package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_product:仓库货位产品库存表 Mapper.xml
 * 关联查询表(vmes_warehouse_product,vmes_warehouse,vmes_product)
 *
 * 创建人：陈刚
 * 创建时间：2019-11-14
 */
@Mapper
@Repository
public interface WarehouseProductQueryMapper {
    List<Map> findMapListWarehouseProductQuery(PageData pd);
    List<Map> findMapListWarehouseProductQuery(PageData pd, Pagination pg);

}
