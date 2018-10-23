package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOut;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-10-22
*/
public interface WarehouseOutService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void save(WarehouseOut warehouseOut) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void update(WarehouseOut warehouseOut) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void updateAll(WarehouseOut warehouseOut) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    WarehouseOut selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<WarehouseOut> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<WarehouseOut> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<WarehouseOut> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    String checkColumn(WarehouseOut object);

}



