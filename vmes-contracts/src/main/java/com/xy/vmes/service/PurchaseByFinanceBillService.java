package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_finance_bill:(采购)应付 接口类
 * 创建人：陈刚
 * 创建时间：2020-03-31
 */
public interface PurchaseByFinanceBillService {
    List<Map> findFinanceBillByPurchaseView(PageData pd, Pagination pg) throws Exception;
    List<Map> findFinanceBillDetailByPurchase(PageData pd, Pagination pg) throws Exception;

    ResultModel listPagePurchaseByFinanceBill(PageData pd) throws Exception;
    ResultModel listPageFinanceBillByPurchaseView(PageData pd) throws Exception;
    ResultModel listPageFinanceBillDetailByPurchase(PageData pd) throws Exception;

    /**
     * 根据查询期间(yyyyMM)获取采购应付查询功能查询条件
     * 返回值Map:
     *   period: 当前期间(yyyyMM)
     *   forePeriod: 当前期间(yyyyMM) -1 个月
     *
     * @param queryPeriod
     * @return
     */
    Map<String, String> findQueryPeriodMap(String queryPeriod) throws ParseException;

    void modifyCheckOutFinanceBillByPurchase(List<Map> queryList, String period);

    /**
     *
     * @param businessId  业务单据id
     * @param companyId   企业id
     * @param customerId  客户id
     * @param userId      用户id
     * @param type        付款单类型(vmes_finance_bill.type)
     * @param attribute   付款单属性(vmes_finance_bill.attribute)
     * @param amount
     * @throws Exception
     */
    void addFinanceBillByPurchase(String businessId,
                                  String companyId,
                                  String customerId,
                                  String userId,
                                  String type,
                                  String state,
                                  String attribute,
                                  BigDecimal amount,
                                  String remark) throws Exception;
}
