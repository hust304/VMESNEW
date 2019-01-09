package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleInvoice;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_invoice:发票 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-01-08
*/
public interface SaleInvoiceService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    void save(SaleInvoice saleInvoice) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void update(SaleInvoice object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void updateAll(SaleInvoice object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    SaleInvoice selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<SaleInvoice> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByInvoice(String state, String ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<SaleInvoice> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

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
    List<SaleInvoice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleInvoice findSaleInvoice(PageData object) throws Exception;
    SaleInvoice findSaleInvoiceById(String id) throws Exception;

    List<SaleInvoice> findSaleInvoiceList(PageData object) throws Exception;

}



