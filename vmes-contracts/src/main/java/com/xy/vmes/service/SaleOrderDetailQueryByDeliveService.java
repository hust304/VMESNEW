package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总 接口类
 * 销售-发货管理-生成发货单-(勾选订单明细)-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2018-12-29
 */
public interface SaleOrderDetailQueryByDeliveService {
    List<Map> listOrderDetaiQueryByDeliver(PageData pd) throws Exception;
    List<Map> listOrderDetaiQueryByDeliver(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageOrderDetailQueryByDeliver(PageData pd) throws Exception;
}
