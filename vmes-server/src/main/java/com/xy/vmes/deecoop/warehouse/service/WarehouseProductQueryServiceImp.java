package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductQueryMapper;
import com.xy.vmes.service.WarehouseProductQueryService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_product:仓库货位产品库存表 实现类
 * 关联查询表(vmes_warehouse_product,vmes_warehouse,vmes_product)
 *
 * 创建人：陈刚
 * 创建时间：2019-11-14
 */
@Service
@Transactional(readOnly = false)
public class WarehouseProductQueryServiceImp implements WarehouseProductQueryService {
    @Autowired
    private WarehouseProductQueryMapper queryMapper;

    public List<Map> findWarehouseProductQuery(PageData pd, Pagination pg) {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return queryMapper.findMapListWarehouseProductQuery(pd);
        } else if (pg != null) {
            return queryMapper.findMapListWarehouseProductQuery(pd, pg);
        }

        return mapList;
    }
}
