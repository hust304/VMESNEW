package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseCheckMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseInMapper;
import com.xy.vmes.service.MobileWarehouseCheckService;
import com.xy.vmes.service.MobileWarehouseInService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 手机端入库
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseInServiceImp implements MobileWarehouseInService {

    @Autowired
    private MobileWarehouseInMapper mobileWarehouseInMapper;

    ///////////////////////////////////////////////////////////////////////////////
    public List<Map> findWarehouseIn(PageData pd) throws Exception {
        return mobileWarehouseInMapper.findWarehouseIn(pd);
    }

}
