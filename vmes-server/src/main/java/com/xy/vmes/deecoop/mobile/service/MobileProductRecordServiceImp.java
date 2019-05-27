package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductMapper;
import com.xy.vmes.service.MobileProductRecordService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 库存查询     （接口复用，不发送参数获得公司所有的库存信息；发送参数则进行筛选）
 */
@Service
@Transactional(readOnly = false)
public class MobileProductRecordServiceImp implements MobileProductRecordService {

    @Autowired
    private WarehouseProductMapper warehouseProductMapper;

    public List<Map<String, Object>> findListProductRecord(PageData pd, Pagination pg) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
            list = warehouseProductMapper.findWarehouseProductMapList(pd, pg);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public List<Map<String, Object>> findListProductRecordByCode(PageData pd, Pagination pg) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
            list = warehouseProductMapper.findWarehouseProductMapList(pd, pg);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


}
