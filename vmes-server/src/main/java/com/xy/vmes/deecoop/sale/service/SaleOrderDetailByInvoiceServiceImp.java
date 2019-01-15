package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByInvoiceMapper;
import com.xy.vmes.service.SaleOrderDetailByInvoiceService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByInvoiceServiceImp implements SaleOrderDetailByInvoiceService {
    @Autowired
    private SaleOrderDetailByInvoiceMapper saleOrderDetailByInvoiceMapper;

    public List<Map> findListPageOrderDetailByInvoice(PageData pd) throws Exception {
        return saleOrderDetailByInvoiceMapper.findListPageOrderDetailByInvoice(pd);
    }
    public List<Map> findListPageOrderDetailByInvoice(PageData pd, Pagination pg) throws Exception {
        return saleOrderDetailByInvoiceMapper.findListPageOrderDetailByInvoice(pd, pg);
    }
}
