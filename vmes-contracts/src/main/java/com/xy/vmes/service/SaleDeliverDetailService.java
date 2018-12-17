package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_deliver_detail:发货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-12-15
*/
public interface SaleDeliverDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void save(SaleDeliverDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void update(SaleDeliverDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void updateAll(SaleDeliverDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    SaleDeliverDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<SaleDeliverDetail> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<SaleDeliverDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
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
    List<SaleDeliverDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void addDeliverDetail(SaleDeliver parentObj, List<SaleDeliverDetail> detailList, Map<String, String> orderDtl2OutDtlMap) throws Exception;
    void updateStateByDetail(String state, String parentIds) throws Exception;

}



