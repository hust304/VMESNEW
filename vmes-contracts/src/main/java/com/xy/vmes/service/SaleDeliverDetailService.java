package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.entity.SaleOrderDetailEntity;
import com.xy.vmes.exception.ApplicationException;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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

    SaleDeliverDetail findSaleDeliverDetail(PageData object) throws Exception;
    SaleDeliverDetail findSaleDeliverDetailById(String id) throws Exception;

    List<SaleDeliverDetail> findSaleDeliverDetailList(PageData object) throws Exception;
    List<SaleDeliverDetail> findSaleDeliverDetailListByParentId(String parentId) throws Exception;

    List<SaleDeliverDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleDeliverDetail> objectList);

    /**
     * model_code = 'saleOrderDetailQueryByDeliver'
     * 1. 本次发货数量(计价单位)
     * 2. 公式:P(计价单位) 转换 N(计量单位)
     * 3. count:订购数量(计价数量) -- 本次发货数量(计价单位)
     *    productCount:货品数量(计量数量) --本次发货数量(计量单位)
     *
     * @param mapList
     * @param objectList
     * @return
     */
    List<SaleOrderDetailEntity> mapList2OrderDetailList(List<Map<String, String>> mapList, List<SaleOrderDetailEntity> objectList);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    BigDecimal findTotalSumByDetailList(List<SaleDeliverDetail> objectList);
    void addDeliverDetail(SaleDeliver parentObj, List<SaleDeliverDetail> detailList, Map<String, String> orderDtl2OutDtlMap) throws Exception;
    void updateStateByDetail(String state, String parentIds) throws Exception;

    /**
     * 获取订单id的发货金额 Map<订单id, 发货金额>
     *
     * @param deliverId   发货单id
     * @param detailList  发货明细
     *
     * @return
     *     Map<订单id, 发货金额>
     */
    Map<String, BigDecimal> findOrderDeliverSumByDeliverId(String deliverId, List<SaleDeliverDetail> detailList) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////

    /**
     * 验证发货单明细是否全部完成出库
     *
     * @param deliverId 发货单id
     * @return
     *  Boolean.TRUE  全部出库完成
     *  Boolean.FALSE 一条或多条出库未完成
     *  is null 无出库明细
     */
    Boolean checkIsAllOutByDeliverId(String deliverId) throws ApplicationException;

    /**
     * 发货单取消
     * 清除订单明细与发货明细的关联关系(vmes_sale_order_detail.deliver_detail_id)
     *
     * @param deliverId 发货单id
     */
    void updateOrderDetailByCancelDeliver(String deliverId);

    /**
     * 验证出库单明细状态(状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * @param deliverId 发货单id
     * @return
     */
    String checkOutDetailStateByCancelDeliver(String deliverId) throws Exception;

    /**
     * 获取出库单id字符串(','逗号分隔的字符串)，根据发货单id(发货明细表,出库明细表)关联查询
     *
     * @param deliverId
     * @return
     */
    String findOutIdsByDeliverId(String deliverId);

    String findOrderDtlIdsByDeliverDtlList(List<SaleDeliverDetail> detailList);

    //////////////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageSaleDeliverDetail(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageSaleDeliverDetailByPrice(PageData pd, Pagination pg) throws Exception;
    ResultModel updateSaleDeliverDetailByPrice(PageData pd) throws Exception;

    void exportExcelSaleDeliverDetails(PageData pd, Pagination pg) throws Exception;
    ResultModel importExcelSaleDeliverDetails(MultipartFile file) throws Exception;

}



