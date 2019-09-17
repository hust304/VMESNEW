package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseToWarehouseProductMapper;
import com.xy.vmes.service.WarehouseToWarehouseProductService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 说明：仓库表(vmes_warehouse)-关联仓库货品表(vmes_warehouse_product) 实现类
 * 创建人：陈刚
 * 创建时间：2019-08-09
 */
@Service
@Transactional(readOnly = false)
public class WarehouseToWarehouseProductServiceImp implements WarehouseToWarehouseProductService {
    @Autowired
    private WarehouseToWarehouseProductMapper warehouseMapper;

    public List<Map> findMapListWarehouseToWarehouseProduct(PageData pd) {
        return warehouseMapper.findMapListWarehouseToWarehouseProduct(pd);
    }

    /**
     * 获取全部仓库信息-并且得到仓库的货品库存数量
     * @param pd
     * @return
     */
    public List<Map> findWarehouseToWarehouseProductByProduct(PageData pd, Pagination pg) {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseMapper.findWarehouseToWarehouseProductByProduct(pd);
        } else if (pg != null) {
            return warehouseMapper.findWarehouseToWarehouseProductByProduct(pd, pg);
        }

        return mapList;
    }
}
