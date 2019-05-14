package com.xy.vmes.service;


import com.xy.vmes.entity.PurchasePayment;
import com.xy.vmes.entity.PurchasePaymentDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_payment_detail:采购订单付款单明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-05-14
*/
public interface PurchasePaymentDetailService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void save(PurchasePaymentDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void update(PurchasePaymentDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void updateAll(PurchasePaymentDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    PurchasePaymentDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    List<PurchasePaymentDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    List<PurchasePaymentDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
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
    List<PurchasePaymentDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchasePaymentDetail findPurchasePaymentDetail(PageData object) throws Exception;
    PurchasePaymentDetail findPurchasePaymentDetailById(String id) throws Exception;

    List<PurchasePaymentDetail> findPurchasePaymentDetailList(PageData object) throws Exception;
    List<PurchasePaymentDetail> findPurchasePaymentDetailListByParentId(String parentId) throws Exception;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void addPaymentDetail(PurchasePayment parentObj, List<PurchasePaymentDetail> objectList) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchasePaymentDetails(PageData pd,Pagination pg) throws Exception;

}



