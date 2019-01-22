package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseInMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseMoveMapper;
import com.xy.vmes.service.MobileWarehouseInService;
import com.xy.vmes.service.MobileWarehouseMoveService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 手机端移库
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseMoveServiceImp implements MobileWarehouseMoveService {

    @Autowired
    private MobileWarehouseMoveMapper mobileWarehouseMoveMapper;

    public List<Map> findWarehouseMove(PageData pd) throws Exception {
        return mobileWarehouseMoveMapper.findWarehouseMove(pd);
    }

}
