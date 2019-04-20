package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleOrder;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_order:订单表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-12-05
*/
public interface SaleOrderService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void save(SaleOrder object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void update(SaleOrder object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void updateAll(SaleOrder object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    SaleOrder selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    List<SaleOrder> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableByOrder(String companyId) throws Exception;

    void updateStateByOrder(String state, String ids) throws Exception;
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    List<SaleOrder> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
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
    List<SaleOrder> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleOrder findSaleOrder(PageData object) throws Exception;
    SaleOrder findSaleOrderById(String id) throws Exception;

    List<SaleOrder> findSaleOrderList(PageData object) throws Exception;

    List<SaleOrder> mapList2OrderList(List<Map<String, String>> mapList, List<SaleOrder> objectList);

    ResultModel listPageSaleOrder(PageData pd, Pagination pg) throws Exception;

    ResultModel addSaleOrder(PageData pageData) throws Exception;

    ResultModel updateSaleOrder(PageData pageData) throws Exception;

    ResultModel deleteSaleOrder(PageData pageData) throws Exception;

    ResultModel recoverySaleOrder(PageData pageData) throws Exception;

    ResultModel cancelSaleOrder(PageData pageData) throws Exception;

    ResultModel submitSaleOrder(PageData pageData) throws Exception;

    ResultModel rebackSaleOrder(PageData pageData) throws Exception;

    ResultModel updateSaleOrderByLockCount(PageData pageData) throws Exception;

    void exportExcelSaleOrders(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelSaleOrders(MultipartFile file) throws Exception;


    void updateOrderStateCompelete(String id) throws Exception;
}



