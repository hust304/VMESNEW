package com.xy.vmes.service;


import com.xy.vmes.entity.PurchasePlan;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_plan:采购计划 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-02-28
*/
public interface PurchasePlanService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void save(PurchasePlan purchasePlan) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void update(PurchasePlan purchasePlan) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void updateAll(PurchasePlan purchasePlan) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    PurchasePlan selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<PurchasePlan> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<PurchasePlan> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<PurchasePlan> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-02-28
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
    List<PurchasePlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchasePlans(PageData pd,Pagination pg) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelPurchasePlans(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelPurchasePlans(MultipartFile file) throws Exception;


    ResultModel addPurchasePlan(PageData pd) throws Exception;

    ResultModel editPurchasePlan(PageData pd) throws Exception;

    ResultModel cancelPurchasePlan(PageData pageData) throws Exception;

    ResultModel recoveryPurchasePlan(PageData pageData) throws Exception;

    ResultModel deletePurchasePlan(PageData pageData) throws Exception;

    void updateState(String id) throws Exception;

    void updateState(String id,String remark) throws Exception;

    ResultModel submitPurchasePlan(PageData pageData) throws Exception;

    ResultModel auditPurchasePlan(PageData pageData) throws Exception;

    ResultModel rebackPurchasePlan(PageData pageData) throws Exception;

    ResultModel checkPurchasePlan(PageData pageData) throws Exception;
}



