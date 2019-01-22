package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.mobile.dao.MobileProductMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseCheckMapper;
import com.xy.vmes.service.MobileProductService;
import com.xy.vmes.service.MobileWarehouseCheckService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 手机端盘点
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseCheckServiceImp implements MobileWarehouseCheckService {

    @Autowired
    private MobileWarehouseCheckMapper mobileWarehouseCheckMapper;

    ////获得盘点任务详细信息
    public List<Map> findWarehouseCheck(PageData pd) throws Exception {
        return mobileWarehouseCheckMapper.findWarehouseCheck(pd);
    }
}
