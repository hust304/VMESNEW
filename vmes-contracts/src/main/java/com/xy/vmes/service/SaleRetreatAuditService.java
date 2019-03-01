package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

public interface SaleRetreatAuditService {

    /**
     * 退货单审核(创建入库单,退货单明细)
     * 1. 创建入库单(入库单, 入库单明细)
     * 2. 修改退货单明细(退货单明细(关联)入库单明细)
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    ResultModel auditPassSaleRetreat(PageData pageData) throws Exception;

    ResultModel auditDisagreeSaleRetreat(PageData pageData) throws Exception;
}
