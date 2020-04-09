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
}
