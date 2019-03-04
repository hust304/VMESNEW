package com.xy.vmes.service;

import com.xy.vmes.entity.SaleRetreat;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_retreat:退货单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-02-25
*/
public interface SaleRetreatService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void save(SaleRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void update(SaleRetreat object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void updateAll(SaleRetreat object) throws Exception;

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
    SaleRetreat selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreat> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableBySaleRetreat(String companyId) throws Exception;
    void updateStateByRetreat(String state, String ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreat> dataList(PageData pd) throws Exception;

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
    List<SaleRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleRetreat findSaleRetreat(PageData object) throws Exception;
    SaleRetreat findSaleRetreatById(String id) throws Exception;

    List<SaleRetreat> findSaleRetreatList(PageData object) throws Exception;

    List<SaleRetreat> mapList2RetreatList(List<Map<String, String>> mapList, List<SaleRetreat> objectList);

    /**
     *
     * 退货单明细表
     * deliverDetailId: rowData.id,
     * orderDetailId: rowData.orderDetaiId,
     * productId: rowData.productId,
     * orderSum: rowData.retreatOrderSum,
     * orderUnit: rowData.orderUnit,
     * orderCount: rowData.retreatOrderCount,
     * productUnit: rowData.productUnit,
     * remark: rowData.retreatRemark,
     *
     * sysOrderCode: rowData.orderId,
     * orderId: rowData.orderId,
     * receiveAmount: rowData.receiveAmount,
     * n2pFormula: rowData.n2pFormula,
     * p2nFormula: rowData.p2nFormula,
     *
     * @param mapList
     * @return
     */
    String checkColumnByEdit(List<Map<String, String>> mapList);
    String checkNullColumn(List<Map<String, String>> mapList);
    String checkColumnByReceiveAmount(List<Map<String, String>> mapList);

    /**
     *
     * 退货单明细表
     * id: rowData.id,
     * orderSum: rowData.retreatOrderSum,
     *
     * sysOrderCode: rowData.orderId,
     * orderId: rowData.orderId,
     * receiveAmount: rowData.receiveAmount,
     *
     * @param mapList
     * @return
     */
    String checkColumnByMoney(List<Map<String, String>> mapList);
    String checkNullColumnByMoney(List<Map<String, String>> mapList);

    String checkOrderReceiveAmount(List<Map<String, String>> mapList);

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageSaleRetreat(PageData pd,Pagination pg) throws Exception;
    ResultModel addSaleRetreat(PageData pageData) throws Exception;
    ResultModel checkRetreatEdit(PageData pageData);
    ResultModel updateSaleRetreat(PageData pageData) throws Exception;
    ResultModel deleteSaleRetreat(PageData pageData) throws Exception;
    ResultModel cancelSaleRetreat(PageData pageData) throws Exception;
    ResultModel submitSaleRetreat(PageData pageData) throws Exception;
    ResultModel rebackBySubmitSaleRetreat(PageData pageData) throws Exception;
    ResultModel updateRetreatByMoney(PageData pageData) throws Exception;

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    void exportExcelSaleRetreat(PageData pd,Pagination pg) throws Exception;

    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel importExcelSaleRetreat(MultipartFile file) throws Exception;


}



