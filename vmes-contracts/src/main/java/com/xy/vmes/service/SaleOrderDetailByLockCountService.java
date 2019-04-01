package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

public interface SaleOrderDetailByLockCountService {
    List<Map> findListOrderDetailByLockCount(PageData pd) throws Exception;
    List<Map> findListOrderDetailByLockCount(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailByLockCount(PageData pd) throws Exception;

    /**
     * 更新锁定库存版本号
     * 1. 根据(企业id)获取订单明细表(vmes_sale_order_detail)
     * 2. 字段 version_lock_count 加一
     *
     * @param companyId  企业id
     */
    void updateVersionLockCount(String companyId) throws Exception;
}
