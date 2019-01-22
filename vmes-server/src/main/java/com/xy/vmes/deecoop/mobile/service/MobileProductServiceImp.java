package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.mobile.dao.MobileProductMapper;
import com.xy.vmes.service.MobileProductService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 库存查询     （接口复用，不发送参数获得公司所有的库存信息；发送参数则进行筛选）
 */
@Service
@Transactional(readOnly = false)
public class MobileProductServiceImp implements MobileProductService {

    @Autowired
    private MobileProductMapper mobileProductMapper;

    //手机端功能
    public List<Map> findListPageProduct(PageData pd, Pagination pg) throws Exception {
        return mobileProductMapper.findListPageProduct(pd,pg);
    }
}
