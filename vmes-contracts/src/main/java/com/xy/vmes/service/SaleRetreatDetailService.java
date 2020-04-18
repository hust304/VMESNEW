package com.xy.vmes.service;


import com.xy.vmes.entity.*;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_retreat_detail:退货明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-02-25
*/
public interface SaleRetreatDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void save(SaleRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void update(SaleRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void updateAll(SaleRetreatDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    SaleRetreatDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreatDetail> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreatDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
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
    List<SaleRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleRetreatDetail findSaleOrderReturnDetail(PageData object) throws Exception;
    SaleRetreatDetail findSaleOrderReturnDetailById(String id) throws Exception;

    List<SaleRetreatDetail> findSaleOrderReturnDetailList(PageData object) throws Exception;
    List<SaleRetreatDetail> findSaleOrderReturnDetailListByParentId(String parentId) throws Exception;

    List<SaleRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleRetreatDetail> objectList);
    BigDecimal findTotalSumByDetailList(List<SaleRetreatDetail> objectList);

    WarehouseInDetail retreatDetail2InDetail(SaleRetreatDetail retreatDetail, WarehouseInDetail inDetail);
    List<WarehouseInDetail> retreatDtlList2InDtlList(List<SaleRetreatDetail> retreatDtlList, List<WarehouseInDetail> inDtlList);

    List<SaleReceiveDetail> retreatMap2ReceiveDtlList(Map<String, BigDecimal> orderRetreatSumMap, List<SaleReceiveDetail> receiveDtlList);

    /**
     * 获取 <订单明细id,<订单明细退货信息Map>
     *     订单明细退货信息Map
     *         orderCount:退货数量
     *         orderSum:退货金额(订单明细-退货金额)
     * @param objectList
     * @return
     */
    Map<String, Map<String, BigDecimal>> findOrderDtlRetreatCountMap(List<SaleRetreatDetail> objectList);
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 验证入库单明细状态 (0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * @param retreatId 退货单id
     * @return
     */
    String checkInDetailStateByRetreatId(String retreatId) throws Exception;
    String findOrderDtlIdsByRetreatDtlList(List<SaleRetreatDetail> objectList);

    void addSaleRetreatDetail(SaleRetreat parentObj, List<SaleRetreatDetail> objectList) throws Exception;
    void updateStateByDetail(PageData pd) throws Exception;
    void updateStateByDetail(String state, String parentIds) throws Exception;
    void updateOrderByRetreat(Map<String, Map<String, BigDecimal>> orderDtlRetreatMap, List<SaleOrderDetail> orderDtlList) throws Exception;

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param detailList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByIn(List<SaleRetreatDetail> detailList);
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageSaleRetreatDetail(PageData pd) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelSaleRetreatDetail(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelSaleRetreatDetail(MultipartFile file) throws Exception;
}



