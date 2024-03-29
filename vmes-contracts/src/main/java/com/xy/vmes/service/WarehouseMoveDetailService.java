package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseMove;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.entity.WarehouseMoveDetailEntity;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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

    List<Map> getDataListPage(PageData pd) throws Exception;

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
    List<WarehouseMoveDetailEntity> mapList2DetailEntityList(List<Map<String, String>> mapList, List<WarehouseMoveDetailEntity> objectList);
    List<WarehouseMoveDetail> findWarehouseMoveDetailListByParentId(String parentId) throws Exception;
    WarehouseMoveDetail findWarehouseMoveDetailById(String detailId) throws Exception;
    boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseMoveDetail> detailList) throws Exception;
    List<Map<String, String>> findWarehouseMoveMapList(String companyId, String productId, String code);

    List<Map<String, Object>> findMoveDetailByProductMapList(String companyId, String productId, String code);
    Map<String, BigDecimal> findProductMapByMapList(List<Map<String, Object>> mapList);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void addWarehouseMoveDetail(WarehouseMove parentObj, List<WarehouseMoveDetail> objectList) throws Exception;
    void addWarehouseMoveDetail(WarehouseMove parentObj, WarehouseMoveDetail detail) throws Exception;
    void updateStateByDetail(PageData mapDetail) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel rebackWarehouseMoveDetail(PageData pageData) throws Exception;

    ResultModel deleteWarehouseMoveDetail(PageData pageData) throws Exception;

    ResultModel cancelWarehouseMoveDetail(PageData pageData) throws Exception;

    ResultModel recoveryWarehouseMoveDetail(PageData pageData) throws Exception;

    ResultModel listPageWarehouseMoveDetailsExecute(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageWarehouseMoveDetailsRecords(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageWarehouseMoveDetails(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageWarehouseMoveDetailsBySimple(PageData pd) throws Exception;

    void exportExcelWarehouseMoveDetails(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseMoveDetails(MultipartFile file) throws Exception;

}



