package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_loginfo:库存变更日志表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-06
*/
public interface WarehouseLoginfoService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    void save(WarehouseLoginfo warehouseLoginfo) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    List<WarehouseLoginfo> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-06
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

}



