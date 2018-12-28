package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderByQueryMapper;
import com.xy.vmes.service.SaleOrderByQueryService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderByQueryServiceImp implements SaleOrderByQueryService {
    @Autowired
    private SaleOrderByQueryMapper orderByQueryMapper;

    public List<Map> findListPageOrderByQuery(PageData pd, Pagination pg) throws Exception{
        return orderByQueryMapper.findListPageOrderByQuery(pd, pg);
    }
}
