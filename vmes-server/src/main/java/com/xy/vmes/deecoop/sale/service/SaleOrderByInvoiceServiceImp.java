package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderByInvoiceMapper;
import com.xy.vmes.service.SaleOrderByInvoiceService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderByInvoiceServiceImp implements SaleOrderByInvoiceService {
    @Autowired
    private SaleOrderByInvoiceMapper saleOrderByInvoiceMapper;

    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return saleOrderByInvoiceMapper.findListPageOrderByInvoice(pd, pg);
    }
}
