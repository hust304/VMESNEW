package com.xy.vmes.service;


import com.xy.vmes.entity.PurchasePaymentBuild;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_payment_build:供应商付款初期设定 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-03-11
*/
public interface PurchasePaymentBuildService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void save(PurchasePaymentBuild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void update(PurchasePaymentBuild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void updateAll(PurchasePaymentBuild object) throws Exception;

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
    PurchasePaymentBuild selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchasePaymentBuild> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchasePaymentBuild> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
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
    List<PurchasePaymentBuild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchasePaymentBuild(PageData pd,Pagination pg) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelPurchasePaymentBuilds(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelPurchasePaymentBuilds(MultipartFile file) throws Exception;
}



