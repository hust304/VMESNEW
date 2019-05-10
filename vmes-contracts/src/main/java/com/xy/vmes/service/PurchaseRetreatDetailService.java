package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseRetreatDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_retreat_detail:退货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-05-09
*/
public interface PurchaseRetreatDetailService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void save(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void update(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void updateAll(PurchaseRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    PurchaseRetreatDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreatDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    List<PurchaseRetreatDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
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
    List<PurchaseRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseRetreatDetail findPurchaseRetreatDetail(PageData object) throws Exception;
    PurchaseRetreatDetail findPurchaseRetreatDetailById(String id) throws Exception;

    List<PurchaseRetreatDetail> findPurchaseRetreatDetailList(PageData object) throws Exception;
    List<PurchaseRetreatDetail> findPurchaseRetreatDetailListByParentId(String parentId) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageRetreatDetail(PageData pd,Pagination pg) throws Exception;


}



