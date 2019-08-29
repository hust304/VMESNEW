package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：销售退货明细关联入库明细 接口类
 * 创建人：陈刚
 * 创建时间：2019-08-29
 */
public interface SaleRetreatDetailOnInService {

    List<Map> findSaleRetreatDetailOnInDetail(PageData pd, Pagination pg) throws Exception;
    ResultModel listPageRetreatDetailByIn (PageData pd) throws Exception;
}
