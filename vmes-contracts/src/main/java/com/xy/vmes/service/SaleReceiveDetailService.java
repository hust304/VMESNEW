package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleReceive;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：收款明细 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-01-10
*/
public interface SaleReceiveDetailService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void save(SaleReceiveDetail saleReceiveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void update(SaleReceiveDetail saleReceiveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void updateAll(SaleReceiveDetail saleReceiveDetail) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    SaleReceiveDetail selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<SaleReceiveDetail> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<SaleReceiveDetail> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<SaleReceiveDetail> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    List<Map<String, Object>> findReceiveDetailCollectByOrderId(PageData pageData) throws Exception;
    /**
     * 获取订单付款信息<订单id, 订单付款信息Map>
     *     订单付款信息Map
     *         receiveSum: 付款金额
     *
     * @param orderIds
     * @param state
     * @return
     * @throws Exception
     */
    Map<String, Map<String, BigDecimal>> findMapOrderReceiveByOrderId(String orderIds, String state) throws Exception;
    BigDecimal findReceiveSumByOrderId(String orderId) throws Exception;
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
    List<SaleReceiveDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    List<Map> getOrderReceiveDetailDataListPage(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderReceiveDetail(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageSaleReceiveDetails(PageData pd, Pagination pg) throws Exception;

    void exportExcelSaleReceiveDetails(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelSaleReceiveDetails(MultipartFile file) throws Exception;

    void addReceiveDetail(SaleReceive parentObj, List<SaleReceiveDetail> objectList) throws Exception;
}



