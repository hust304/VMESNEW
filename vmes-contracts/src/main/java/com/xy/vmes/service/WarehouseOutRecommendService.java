package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOutRecommend;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库推荐 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-11-07
*/
public interface WarehouseOutRecommendService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void save(WarehouseOutRecommend warehouseOutRecommend) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void update(WarehouseOutRecommend warehouseOutRecommend) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void updateAll(WarehouseOutRecommend warehouseOutRecommend) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    WarehouseOutRecommend selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<WarehouseOutRecommend> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<WarehouseOutRecommend> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<WarehouseOutRecommend> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    void updateToDisableByIds(String[] ids)throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    List<Map<String, String>> findWarehouseOutMapList(String companyId, String productId, String code);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageWarehouseOutRecommends(PageData pd, Pagination pg) throws Exception;

    void exportExcelWarehouseOutRecommends(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseOutRecommends(MultipartFile file) throws Exception;
}



