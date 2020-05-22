package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

/**
 * Created by 46368 on 2020/4/8.
 */
public interface SaleAnalysisService {

    ResultModel syntheticalQuery(PageData pd)  throws Exception;

    ResultModel salesTrendQuery(PageData pd)  throws Exception;

    ResultModel salesVolumeByProductQuery(PageData pd)  throws Exception;

    ResultModel salesNumberByProductQuery(PageData pd) throws Exception;

    ResultModel productReturnRateQuery(PageData pd) throws Exception;

    ResultModel salesVolumeByCustomerQuery(PageData pd) throws Exception;

    ResultModel salesByEmployeeQuery(PageData pd) throws Exception;

    ResultModel salesTrendByEmployeeQuery(PageData pd) throws Exception;

    ResultModel accountsReceivableQuery(PageData pd) throws Exception;

    ResultModel salesTrendQueryByDMY(PageData pd) throws Exception;

    ResultModel salesTrendProductByDate(PageData pd) throws Exception;

    ResultModel salesTrendCustomerByDate(PageData pd) throws Exception;

    ResultModel salesTrendEmployeeByDate(PageData pd) throws Exception;

    ResultModel salesProductQueryByDMY(PageData pd) throws Exception;

    ResultModel salesProductVolumeByDMY(PageData pd) throws Exception;

    ResultModel salesProductNumberByDMY(PageData pd) throws Exception;

    ResultModel salesProductProportion(PageData pd) throws Exception;

    ResultModel salesProductCustomer(PageData pd) throws Exception;

    ResultModel salesProductEmployee(PageData pd) throws Exception;

    ResultModel salesCustomerQueryByDMY(PageData pd) throws Exception;

    ResultModel salesCustomerVolumeByDMY(PageData pd) throws Exception;

    ResultModel salesCustomerNumberByDMY(PageData pd) throws Exception;

    ResultModel salesCustomerProportion(PageData pd) throws Exception;

    ResultModel salesCustomerProduct(PageData pd) throws Exception;

    ResultModel salesEmployeeQueryByDMY(PageData pd) throws Exception;

    ResultModel salesEmployeeVolumeByDMY(PageData pd) throws Exception;

    ResultModel salesEmployeeNumberByDMY(PageData pd) throws Exception;

    ResultModel salesEmployeeProportion(PageData pd) throws Exception;

    ResultModel salesEmployeeProduct(PageData pd) throws Exception;

    ResultModel accountsReceivableQueryByCurrent(PageData pd) throws Exception;

    ResultModel accountsReceivable12MonthSingle(PageData pd) throws Exception;

    ResultModel accountsReceivable12MonthMuti(PageData pd) throws Exception;
}
