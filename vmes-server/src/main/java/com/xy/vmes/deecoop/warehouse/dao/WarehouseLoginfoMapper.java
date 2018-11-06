package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_loginfo:库存变更日志表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-11-06
*/
@Mapper
@Repository
public interface WarehouseLoginfoMapper extends BaseMapper<WarehouseLoginfo> {


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    List<WarehouseLoginfo> dataList(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-31
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

}


