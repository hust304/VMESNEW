package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;

/**
 * 说明：vmes_finance_bill:(采购)应付 接口类
 * 创建人：陈刚
 * 创建时间：2020-03-31
 */
public interface PurchaseByFinanceBillService {

    ResultModel listPagePurchaseByFinanceBill(PageData pd) throws Exception;

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
