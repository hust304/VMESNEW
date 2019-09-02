package com.xy.vmes.deecoop.warehouse.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：(出库单明细id)关联查询(出库明细表,出库执行表) Mapper.java
 * 创建人：陈刚
 * 创建时间：2019-09-02
 */
@Mapper
@Repository
public interface WarehouseOutDetailExecuteMapper {
    List<Map> findOutDetailExecute(PageData pd);
}