package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleUnitPrice;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：设置锁库时间 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-12-14
*/
public interface SaleUnitPriceService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void save(SaleUnitPrice saleUnitPrice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void update(SaleUnitPrice saleUnitPrice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void updateAll(SaleUnitPrice saleUnitPrice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    SaleUnitPrice selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<SaleUnitPrice> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<SaleUnitPrice> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<SaleUnitPrice> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     *
     * @param pageData    查询参数对象<HashMap>
     * @param isQueryAll  是否查询全部
     *   true: 无查询条件返回表全部结果集
     *   false: (false or is null)无查询条件-查询结果集返回空或
     *
     * @return
     * @throws Exception
     */
    List<SaleUnitPrice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleUnitPrice findSaleUnitPrice(PageData object) throws Exception;
    SaleUnitPrice findSaleUnitPriceById(String id) throws Exception;
    List<SaleUnitPrice> findSaleUnitPriceList(PageData object) throws Exception;

    ////////////////////////////////////////////////////////////////
    String checkColumn(SaleUnitPrice object);
    void modifySaleUnitPrice(SaleUnitPrice object) throws Exception;

    //List<Map> getCustomerUnitPriceListPage(PageData pd,Pagination pg) throws Exception;

    //List<Map> getCustomerUnitPriceHisListPage(PageData pd,Pagination pg) throws Exception;

    //ResultModel listPageCustomerUnitPricesHis(PageData pd, Pagination pg) throws Exception;

    //ResultModel listPageCustomerUnitPrices(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageSaleUnitPrices(PageData pd) throws Exception;

    ResultModel updateSaleUnitPriceByPrice(PageData pageData) throws Exception;

    ResultModel findSaleUnitPriceNew(PageData pageData) throws Exception;

    void exportExcelSaleUnitPrices(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelSaleUnitPrice(MultipartFile file) throws Exception;
}



