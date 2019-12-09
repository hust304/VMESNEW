package com.xy.vmes.service;

import com.xy.vmes.entity.SaleWaresRetreat;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_wares_retreat:无订单退货单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-12-05
*/
public interface SaleWaresRetreatService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void save(SaleWaresRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void update(SaleWaresRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateAll(SaleWaresRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    SaleWaresRetreat selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<SaleWaresRetreat> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<SaleWaresRetreat> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

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
    List<SaleWaresRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleWaresRetreat findWaresRetreat(PageData object) throws Exception;
    SaleWaresRetreat findWaresRetreatById(String id) throws Exception;
    List<SaleWaresRetreat> findWaresRetreatList(PageData object) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageSaleWaresRetreat(PageData pd) throws Exception;

    ResultModel addSaleWaresRetreat(PageData pageData) throws Exception;

    ResultModel submitSaleWaresRetreat(PageData pageData) throws Exception;
    ResultModel rebackSubmitSaleWaresRetreat(PageData pageData) throws Exception;

    ResultModel updateSaleWaresRetreat(PageData pageData) throws Exception;
    ResultModel deleteSaleWaresRetreat(PageData pageData) throws Exception;

    ResultModel cancelSaleWaresRetreat(PageData pageData) throws Exception;
    ResultModel rebackCancelSaleWaresRetreat(PageData pageData) throws Exception;

    ResultModel auditPassSaleWaresRetreat(PageData pageData) throws Exception;
    ResultModel auditDisagreeSaleWaresRetreat(PageData pageData) throws Exception;
}



