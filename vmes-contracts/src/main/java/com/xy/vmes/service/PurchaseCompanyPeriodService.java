package com.xy.vmes.service;


import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_company_period:采购企业付款期设定 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-03-12
*/
public interface PurchaseCompanyPeriodService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void save(PurchaseCompanyPeriod object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void update(PurchaseCompanyPeriod object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void updateAll(PurchaseCompanyPeriod object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    PurchaseCompanyPeriod selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchaseCompanyPeriod> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchaseCompanyPeriod> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
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
    List<PurchaseCompanyPeriod> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseCompanyPeriod findPurchaseCompanyPeriod(PageData object) throws Exception;
    List<PurchaseCompanyPeriod> findPurchaseCompanyPeriodList(PageData object) throws Exception;
    PurchaseCompanyPeriod findPurchaseCompanyPeriodByCompanyId(String companyId) throws Exception;

    void updatePaymentPeriodByCompanyId(String companyId, String paymentPeriod) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchaseCompanyPeriod(PageData pd) throws Exception;
    ResultModel listPagePurchaseCompanyPeriod(PageData pd,Pagination pg) throws Exception;
    ResultModel findPaymentPeriodByCompanyId(PageData pageData) throws Exception;
    ResultModel addCompanyPeriod(PageData pageData) throws Exception;
    ResultModel updateCompanyPeriod(PageData pageData) throws Exception;


    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelPurchaseCompanyPeriods(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelPurchaseCompanyPeriods(MultipartFile file) throws Exception;
}



