package com.xy.vmes.service;

import com.xy.vmes.entity.SaleWaresRetreatDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_wares_retreat_detail:无订单退货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-12-05
*/
public interface SaleWaresRetreatDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void save(SaleWaresRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void update(SaleWaresRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateAll(SaleWaresRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    SaleWaresRetreatDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<SaleWaresRetreatDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    List<SaleWaresRetreatDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
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
    List<SaleWaresRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleWaresRetreatDetail findWaresRetreatDetail(PageData object) throws Exception;
    SaleWaresRetreatDetail findWaresRetreatDetailById(String id) throws Exception;

    List<SaleWaresRetreatDetail> findWaresRetreatDetailList(PageData object) throws Exception;
    List<SaleWaresRetreatDetail> findWaresRetreatDetailListByParentId(String parentId) throws Exception;

    void updateStateByDetail(String state, String parentIds) throws Exception;
    BigDecimal findRetreatTotalSum(List<SaleWaresRetreatDetail> objectList);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageSaleWaresRetreatDetail(PageData pd) throws Exception;


}



