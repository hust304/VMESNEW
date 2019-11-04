package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOut;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

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
    List<Map> getDataListPage(PageData pd) throws Exception;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    //void deleteTableByWarehouseOut(String companyId) throws Exception;
    /**
     *
     * @param companyId  企业id
     * @param warehouseGenre 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
     * @throws Exception
     */
    void deleteTableByWarehouseOut(String companyId, String warehouseGenre) throws Exception;

    String checkColumn(WarehouseOut object);

    WarehouseOut findWarehouseOutById(String id)throws Exception;
    WarehouseOut findWarehouseOut(PageData object);
    List<WarehouseOut> findWarehouseOutList(PageData object);

    void updateState(String id) throws Exception;
    void updateStateByOut(String state, String ids) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////
    WarehouseOut createWarehouseOut(String customerId, String customerName, String cuser, String companyId, String outType);

    ResultModel updateWarehouseOut(PageData pageData) throws Exception;

    ResultModel addWarehouseOut(PageData pageData) throws Exception;

    ResultModel recoveryWarehouseOut(PageData pageData) throws Exception;

    ResultModel cancelWarehouseOut(PageData pageData) throws Exception;

    ResultModel deleteWarehouseOut(PageData pageData) throws Exception;

    ResultModel listPageWarehouseOuts(PageData pd) throws Exception;

    void exportExcelWarehouseOuts(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseOuts(MultipartFile file) throws Exception;
}



