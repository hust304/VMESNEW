package com.xy.vmes.service;


import com.xy.vmes.entity.FinanceInvoice;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_finance_invoice:销售开票 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-12-03
*/
public interface FinanceInvoiceService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void save(FinanceInvoice financeInvoice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void update(FinanceInvoice financeInvoice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void updateAll(FinanceInvoice financeInvoice) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    FinanceInvoice selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<FinanceInvoice> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<FinanceInvoice> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<FinanceInvoice> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-12-03
    */
    void updateByDefined(PageData pd)throws Exception;

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
    List<FinanceInvoice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageFinanceInvoices(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    void exportExcelFinanceInvoices(PageData pd) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelFinanceInvoices(MultipartFile file) throws Exception;
}



