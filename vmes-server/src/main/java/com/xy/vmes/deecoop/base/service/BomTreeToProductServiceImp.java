package com.xy.vmes.deecoop.base.service;

import com.xy.vmes.deecoop.base.dao.BomTreeToProductMapper;
import com.xy.vmes.service.BomTreeToProductService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 说明：BomTree表关联货品表 实现类
 * 创建人：陈刚
 * 创建时间：2019-09-27
 */
@Service
@Transactional(readOnly = false)
public class BomTreeToProductServiceImp implements BomTreeToProductService {
    @Autowired
    private BomTreeToProductMapper bomTreeToProductMapper;

    public List<Map> findBomTreeProductList(PageData pd) throws Exception {
        return bomTreeToProductMapper.findBomTreeProductList(pd);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
