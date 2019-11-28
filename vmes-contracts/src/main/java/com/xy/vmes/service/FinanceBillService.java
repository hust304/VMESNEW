package com.xy.vmes.service;


import com.xy.vmes.entity.FinanceBill;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_finance_bill:应收/应付单 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-11-07
*/
public interface FinanceBillService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void save(FinanceBill financeBill) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void update(FinanceBill financeBill) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void updateAll(FinanceBill financeBill) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    FinanceBill selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<FinanceBill> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<FinanceBill> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<FinanceBill> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
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
    List<FinanceBill> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageFinanceBills(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    void exportExcelFinanceBills(PageData pd) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelFinanceBills(MultipartFile file) throws Exception;

    ResultModel batchAddFinanceBill(PageData pd) throws Exception;

    ResultModel deleteFinanceBill(PageData pd) throws Exception;

    ResultModel cancelFinanceBill(PageData pd) throws Exception;

    ResultModel recoverFinanceBill(PageData pd) throws Exception;

    ResultModel submitFinanceBill(PageData pd) throws Exception;

    ResultModel rebackFinanceBill(PageData pd) throws Exception;

    ResultModel eidtFinanceBill(PageData pd) throws Exception;

    ResultModel comfirmFinanceBill(PageData pd) throws Exception;

    ResultModel getFinanceReceiveView(PageData pd) throws Exception;

    ResultModel getFinanceBillDetail(PageData pd) throws Exception;

    ResultModel unCheckOutFinanceReceive(PageData pd) throws Exception;

    ResultModel checkOutFinanceReceive(PageData pd) throws Exception;

    void saveFinanceHistory(Map map) throws Exception;

    void saveFinancePeriod(String companyId) throws Exception;

    List<Map> getFinanceReceiveView(PageData pd,Pagination pg) throws Exception;


    void addFinanceBillBySys(String companyId,
                             String customerId,
                             String userId,
                             String type,
                             BigDecimal amount) throws Exception;
}



