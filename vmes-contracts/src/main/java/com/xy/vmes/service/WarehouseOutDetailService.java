package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-10-23
*/
public interface WarehouseOutDetailService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void save(WarehouseOutDetail warehouseOutDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void update(WarehouseOutDetail warehouseOutDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void updateAll(WarehouseOutDetail warehouseOutDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    WarehouseOutDetail selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<WarehouseOutDetail> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<WarehouseOutDetail> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<WarehouseOutDetail> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<Map> getDataList(PageData pd) throws Exception;

    List<Map> getDataListPage(PageData pd) throws Exception;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-23
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    List<WarehouseOutDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseOutDetail> objectList);

    void addWarehouseOutDetail(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception;

    void addWarehouseOutDetail(String parentId,String cuser, List<WarehouseOutDetail> objectList) throws Exception;

    void addWarehouseOutDetailBySimple(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception;
    void addWarehouseOutDetailExecuteBySimple(WarehouseOut parentObj, List<WarehouseOutDetail> objectList) throws Exception;

    void addWarehouseOutDetail(WarehouseOut parentObj, WarehouseOutDetail detail) throws Exception;

    List<WarehouseOutDetail> findWarehouseOutDetailList(PageData object);
    List<WarehouseOutDetail> findWarehouseOutDetailListByParentId(String parentId) throws Exception;

    boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseOutDetail> detailList) throws Exception;

    void updateStateByDetail(PageData mapDetail) throws Exception;
    void updateStateByDetail(String state, String parentIds) throws Exception;

    WarehouseOutDetail findWarehouseOutDetailById(String detailId);


    List<Map<String, Object>> findMapListWarehouseOutDetail(PageData pd) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////

    ResultModel rebackWarehouseOutDetail(PageData pageData) throws Exception;

    ResultModel dispatchWarehouseOutDetail(PageData pageData) throws Exception;

    ResultModel recoveryWarehouseOutDetail(PageData pageData) throws Exception;

    ResultModel cancelWarehouseOutDetail(PageData pageData) throws Exception;

    ResultModel deleteWarehouseOutDetail(PageData pageData) throws Exception;

    ResultModel listPageWarehouseOutDetails(PageData pd) throws Exception;

    ResultModel listPageWarehouseOutDetailsOutRecords(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageWarehouseOutDetailsExecute(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageWarehouseOutDetailsExecuteBySimple(PageData pd) throws Exception;

    ResultModel listPageWarehouseOutDetailsDispatch(PageData pd, Pagination pg) throws Exception;

    void exportExcelWarehouseOutDetails(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseOutDetails(MultipartFile file) throws Exception;

    ResultModel listPageForAddFromBOM(PageData pd) throws Exception;
}



