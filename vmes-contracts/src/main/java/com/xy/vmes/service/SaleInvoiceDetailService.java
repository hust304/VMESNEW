package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.entity.SaleInvoice;
import com.xy.vmes.entity.SaleInvoiceDetail;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_invoice_detail:发票明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-01-08
*/
public interface SaleInvoiceDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void save(SaleInvoiceDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void update(SaleInvoiceDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    void updateAll(SaleInvoiceDetail object) throws Exception;

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
    SaleInvoiceDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<SaleInvoiceDetail> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByDetail(String state, String parentIds) throws Exception;
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<SaleInvoiceDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<Map> getDataListPage(PageData pd) throws Exception;
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
    List<SaleInvoiceDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleInvoiceDetail findSaleInvoiceDetail(PageData object) throws Exception;
    SaleInvoiceDetail findSaleInvoiceDetailById(String id) throws Exception;

    List<SaleInvoiceDetail> findSaleInvoiceDetailList(PageData object) throws Exception;
    List<SaleInvoiceDetail> findSaleInvoiceDetailListByParentId(String parentId) throws Exception;

    void addInvoiceDetail(SaleInvoice parentObj, List<SaleInvoiceDetail> detailList) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageSaleInvoiceDetail(PageData pd, Pagination pg) throws Exception;

    void exportExcelSaleInvoiceDetails(PageData pd, Pagination pg) throws Exception;
    ResultModel importExcelSaleInvoiceDetails(MultipartFile file) throws Exception;


}



