package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.purchase.dao.PurchaseRetreatDetailOnInMapper;
import com.xy.vmes.service.PurchaseRetreatDetailOnInService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class PurchaseRetreatDetailOnInServiceImp implements PurchaseRetreatDetailOnInService {
    @Autowired
    private PurchaseRetreatDetailOnInMapper retreatDetailMapper;

    public List<Map> findPurchaseRetreatDetailOnInDetail(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return retreatDetailMapper.findPurchaseRetreatDetailOnInDetail(pd);
        } else if (pg != null) {
            return retreatDetailMapper.findPurchaseRetreatDetailOnInDetail(pd, pg);
        }

        return mapList;
    }
}
