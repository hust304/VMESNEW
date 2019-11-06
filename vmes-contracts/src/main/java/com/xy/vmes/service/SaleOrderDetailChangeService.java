package com.xy.vmes.service;


import com.xy.vmes.entity.SaleOrderDetailChange;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_saleOrdeDtl_change:订单明细变更记录表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-11-05
*/
public interface SaleOrderDetailChangeService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void save(SaleOrderDetailChange object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void update(SaleOrderDetailChange object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void updateAll(SaleOrderDetailChange object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    SaleOrderDetailChange selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    List<SaleOrderDetailChange> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    List<SaleOrderDetailChange> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
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
    List<SaleOrderDetailChange> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleOrderDetailChange findOrdeDtlChange(PageData object) throws Exception;
    SaleOrderDetailChange findOrdeDtlChangeById(String id) throws Exception;

    List<SaleOrderDetailChange> findOrdeDtlChangeList(PageData object) throws Exception;
    List<SaleOrderDetailChange> findOrdeDtlChangeListByParentId(String parentId) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageSaleOrderDetailChange(PageData pd) throws Exception;


}


