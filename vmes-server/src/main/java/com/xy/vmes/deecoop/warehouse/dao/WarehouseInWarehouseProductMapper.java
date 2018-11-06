package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 获取全部货位，同时带出该货位存放的货品信息
 */
@Mapper
@Repository
public interface WarehouseInWarehouseProductMapper {
    List<Map> findAllListWarehouse(PageData pd, Pagination pg);
}
