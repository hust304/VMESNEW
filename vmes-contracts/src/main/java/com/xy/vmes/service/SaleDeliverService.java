package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliver;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_deliver:发货表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-12-15
*/
public interface SaleDeliverService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void save(SaleDeliver object) throws Exception;
    void save(String id, SaleDeliver object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void update(SaleDeliver object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void updateAll(SaleDeliver object) throws Exception;

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
    SaleDeliver selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<SaleDeliver> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableByDeliver(String companyId) throws Exception;
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<SaleDeliver> dataList(PageData pd) throws Exception;

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
    List<SaleDeliver> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleDeliver findSaleDeliver(PageData object) throws Exception;
    SaleDeliver findSaleDeliverById(String id) throws Exception;

    List<SaleDeliver> findSaleDeliverList(PageData object) throws Exception;

    ////////////////////////////////////////////////////////////////

    /**
     * 验证客户是否相同，订单明细生成发货单
     *
     * @param mapList
     * @return
     */
    String checkCustomerByOrderDetailList(List<Map<String, String>> mapList);

    /**
     * 验证计价类型(1:先计价 2:后计价)是否相同，订单明细生成发货单
     *
     * @param mapList
     * @return
     */
    String checkPricetypeByOrderDetailList(List<Map<String, String>> mapList);

    ///////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageSaleDeliver(PageData pd) throws Exception;
    ResultModel addSaleDeliver(PageData pd) throws Exception;
    ResultModel updateSaleDeliverByDeliverType(PageData pd) throws Exception;
    ResultModel deleteSaleDeliver(PageData pd) throws Exception;
    ResultModel cancelSaleDeliver(PageData pd) throws Exception;
    ResultModel checkIsAllOutByDeliverId(PageData pd) throws Exception;

    ResultModel checkIsNullDeliverSumByDeliverId(PageData pd) throws Exception;
    ResultModel checkIsAllNotNullDeliverSumByDeliverId(PageData pd) throws Exception;

//    void exportExcelSaleDelivers(PageData pd, Pagination pg) throws Exception;
//    ResultModel importExcelSaleDelivers(MultipartFile file) throws Exception;


}



