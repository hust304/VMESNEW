package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailQueryByDeliverMapper;
import com.xy.vmes.service.SaleOrderDetailQueryByDeliveService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总实现类
 * 销售-发货管理-生成发货单-(勾选订单明细)-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2018-12-27
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailQueryByDeliveServiceImp implements SaleOrderDetailQueryByDeliveService {
    @Autowired
    private SaleOrderDetailQueryByDeliverMapper orderDetailQueryByDeliverMapper;

    public List<Map> listOrderDetaiQueryByDeliver(PageData pd) throws Exception{
        return orderDetailQueryByDeliverMapper.listOrderDetaiQueryByDeliver(pd);
    }
    public List<Map> listOrderDetaiQueryByDeliver(PageData pd, Pagination pg) throws Exception{
        return orderDetailQueryByDeliverMapper.listOrderDetaiQueryByDeliver(pd, pg);
    }
}
