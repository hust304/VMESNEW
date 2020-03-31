package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

/**
 * 说明：vmes_finance_bill:(采购)应付 接口类
 * 创建人：陈刚
 * 创建时间：2020-03-31
 */
public interface PurchaseByFinanceBillService {

    ResultModel listPagePurchaseByFinanceBill(PageData pd) throws Exception;
}
