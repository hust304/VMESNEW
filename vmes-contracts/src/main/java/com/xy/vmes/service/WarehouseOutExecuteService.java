package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库执行 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-11-01
*/
public interface WarehouseOutExecuteService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void save(WarehouseOutExecute warehouseOutExecute) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void update(WarehouseOutExecute warehouseOutExecute) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void updateAll(WarehouseOutExecute warehouseOutExecute) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    WarehouseOutExecute selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<WarehouseOutExecute> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<WarehouseOutExecute> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<WarehouseOutExecute> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;
    List<Map> getDataListPage(PageData pd) throws Exception;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    Long findMaxExecuteDateByMapList(List<Map> mapList);

    /**
     * @param outDetail
     * @param outMapList List<货位货品仓库Map<String, Object>>
     *     货位货品仓库Map<String, Object>
     *         warehouseProductId
     *         productId
     *         warehouseId
     *         outCount
     * @param executeList
     */
    List<WarehouseOutExecute> outMapList2ExecuteList(WarehouseOutDetail outDetail,
                                                     List<Map<String, Object>> outMapList,
                                                     List<WarehouseOutExecute> executeList);


    void addWarehouseOutExecuteBySimple(List<WarehouseOutExecute> executeList) throws Exception;
    List<Map> findExecuteListByParentId(String parentId) throws Exception;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel addWarehouseOutExecute(String detailId, String warehouseId, String warehouseProductId, String currentUserId,String currentCompanyId, BigDecimal count) throws Exception;
    ResultModel updateWarehouseOutState(String detailId) throws Exception;
    ResultModel executeWarehouseOutExecute(PageData pageData) throws Exception;
    ResultModel updateWarehouseOutExecute(PageData pageData) throws Exception;
    ResultModel deleteWarehouseOutExecute(PageData pageData) throws Exception;
    ResultModel listPageWarehouseOutExecutes(PageData pd, Pagination pg) throws Exception;


}



