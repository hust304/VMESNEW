package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.exception.TableVersionException;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：收款记录 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-12-25
*/
public interface SaleReceiveRecordService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void save(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void update(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void updateAll(SaleReceiveRecord saleReceiveRecord) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    SaleReceiveRecord selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<SaleReceiveRecord> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<SaleReceiveRecord> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<SaleReceiveRecord> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    void updateToDisableByIds(String[] ids)throws Exception;

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
    List<SaleReceiveRecord> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    /**
     * 修改客户余额
     * 1. 修改客户表(vmes_customer)
     * 2. 添加历史表(vmes_sale_receive_record)
     *
     * @param customerId  客户id
     * @param customer    客户对象
     * @param type        操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
     * @param editBalance 修改客户余额 (订单取消，订单删除 该参数为负数)
     * @param user        操作用户id
     * @param remark
     */
    void editCustomerBalanceByOrder(
            String customerId,
            Customer customer,
            String type,
            BigDecimal editBalance,
            String user,
            String remark) throws TableVersionException, ApplicationException;

    ResultModel listPageSaleReceiveRecords(PageData pd, Pagination pg) throws Exception;

    void exportExcelSaleReceiveRecords(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelSaleReceiveRecords(MultipartFile file) throws Exception;
}



