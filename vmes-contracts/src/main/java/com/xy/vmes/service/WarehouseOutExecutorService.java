package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.entity.WarehouseOutExecutor;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库执行人 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-11-01
*/
public interface WarehouseOutExecutorService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void save(WarehouseOutExecutor warehouseOutExecutor) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void update(WarehouseOutExecutor warehouseOutExecutor) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void updateAll(WarehouseOutExecutor warehouseOutExecutor) throws Exception;

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
    WarehouseOutExecutor selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<WarehouseOutExecutor> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    List<WarehouseOutExecutor> dataList(PageData pd) throws Exception;

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
    List<WarehouseOutExecutor> selectByColumnMap(Map columnMap) throws Exception;


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

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    void updateToDisableByIds(String[] ids)throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    ResultModel updateExecutor(PageData pd) throws Exception;
    ResultModel listPageWarehouseOutExecutors(PageData pd, Pagination pg) throws Exception;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void addWarehouseOutExecutorBySimple(List<WarehouseOutDetail> objectList) throws Exception;

}



