package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseIn;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in:仓库入库单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-16
*/
public interface WarehouseInService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void save(WarehouseIn warehouseIn) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void update(WarehouseIn warehouseIn) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void updateAll(WarehouseIn warehouseIn) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    List<WarehouseIn> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    List<WarehouseIn> selectByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableByWarehouseIn();

    WarehouseIn findWarehouseIn(PageData object);
    WarehouseIn findWarehouseInById(String id);

    List<WarehouseIn> findWarehouseInList(PageData object);

    ///////////////////////////////////////////////////////////////////////////////////////////////
    String checkColumn(WarehouseIn object);
}



