package com.xy.vmes.service;


import com.xy.vmes.entity.FinanceBase;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_finance_base:应收应付初始化 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-11-05
*/
public interface FinanceBaseService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void save(FinanceBase financeBase) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void update(FinanceBase financeBase) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void updateAll(FinanceBase financeBase) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    FinanceBase selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<FinanceBase> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<FinanceBase> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<FinanceBase> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
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
    List<FinanceBase> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageFinanceBases(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    void exportExcelFinanceBases(PageData pd) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelFinanceBases(MultipartFile file) throws Exception;

    ResultModel addFinanceBase(PageData pd) throws Exception;

    ResultModel eidtFinanceBase(PageData pd) throws Exception;

    ResultModel deleteFinanceBase(PageData pd) throws Exception;

    ResultModel initialFinanceSale(PageData pd) throws Exception;
    ResultModel initialFinancePurchase(PageData pd) throws Exception;

    ResultModel isDisableSaleInit(PageData pd) throws Exception;

    ResultModel setDisableSaleInit(PageData pd) throws Exception;

    ResultModel batchAddFinanceBase(PageData pd) throws Exception;
}



