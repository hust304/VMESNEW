package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseMove;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：移库单明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-11-16
*/
public interface WarehouseMoveDetailService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void save(WarehouseMoveDetail warehouseMoveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void update(WarehouseMoveDetail warehouseMoveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void updateAll(WarehouseMoveDetail warehouseMoveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    WarehouseMoveDetail selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<WarehouseMoveDetail> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<WarehouseMoveDetail> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<WarehouseMoveDetail> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    List<WarehouseMoveDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseMoveDetail> objectList);

    void addWarehouseMoveDetail(WarehouseMove parentObj, List<WarehouseMoveDetail> objectList) throws Exception;

    void addWarehouseMoveDetail(WarehouseMove parentObj, WarehouseMoveDetail detail) throws Exception;


    List<WarehouseMoveDetail> findWarehouseMoveDetailListByParentId(String parentId) throws Exception;

    boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseMoveDetail> detailList) throws Exception;

//    void updateStateByDetail(PageData mapDetail) throws Exception;

    WarehouseMoveDetail findWarehouseMoveDetailById(String detailId);


    ///////////////////////////////////////////////////////////////////////////////
    //手机端移库详情
    List<Map> findListPageWarehouseMoveDetail(PageData pd, Pagination pg) throws Exception;

}



