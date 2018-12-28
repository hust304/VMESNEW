package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByQueryMapper;
import com.xy.vmes.service.SaleOrderDetailByQueryService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 说明：订单明细查询汇总实现类
 * 创建人：陈刚
 * 创建时间：2018-12-27
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByQueryServiceImp implements SaleOrderDetailByQueryService {
    @Autowired
    private SaleOrderDetailByQueryMapper orderDetailByQueryMapper;

    public List<Map> findListPageOrderDetaiByQuery(PageData pd) throws Exception{
        return orderDetailByQueryMapper.findListPageOrderDetaiByQuery(pd);
    }
    public List<Map> findListPageOrderDetaiByQuery(PageData pd, Pagination pg) throws Exception{
        return orderDetailByQueryMapper.findListPageOrderDetaiByQuery(pd, pg);
    }
}
