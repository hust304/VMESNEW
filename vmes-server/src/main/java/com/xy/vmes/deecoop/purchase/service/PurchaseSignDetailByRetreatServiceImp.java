package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.purchase.dao.PurchaseSignDetailByRetreatMapper;
import com.xy.vmes.service.PurchaseSignDetailByRetreatService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_sign_detail 采购签收明细关联采购退货 实现类
 * 创建人：陈刚
 * 创建时间：020-04-15
 */
@Service
@Transactional(readOnly = false)
public class PurchaseSignDetailByRetreatServiceImp implements PurchaseSignDetailByRetreatService {
    @Autowired
    private PurchaseSignDetailByRetreatMapper signDetailMapper;

    public List<Map> findPurchaseSignDetailByRetreat(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return signDetailMapper.findPurchaseSignDetailByRetreat(pd);
        } else if (pg != null) {
            return signDetailMapper.findPurchaseSignDetailByRetreat(pd, pg);
        }

        return mapList;
    }

    public String findSignCodeByRetreatId(String retreatId) throws Exception {
        String signCode = new String();

        PageData findMap = new PageData();
        findMap.put("retreatId", retreatId);
        List<Map> mapList = this.findPurchaseSignDetailByRetreat(findMap, null);
        if (mapList == null || mapList.size() == 0) {return signCode;}

        Map<String, Object> mapObj = mapList.get(0);
        if (mapObj != null && mapObj.get("signCode") != null) {
            signCode = mapObj.get("signCode").toString().trim();
        }

        return signCode;
    }
}
