package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：收款记录 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-12-24
*/
public interface SaleReceiveRecordService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void save(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void update(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void updateAll(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    SaleReceiveRecord selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<SaleReceiveRecord> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<SaleReceiveRecord> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<SaleReceiveRecord> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
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
    List<SaleReceiveRecord> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

}



