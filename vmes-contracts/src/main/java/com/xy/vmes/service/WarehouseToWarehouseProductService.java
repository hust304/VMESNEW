package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：仓库表(vmes_warehouse)-关联仓库货品表(vmes_warehouse_product) 接口类
 * 创建人：陈刚
 * 创建时间：2019-08-09
 */
public interface WarehouseToWarehouseProductService {
    List<Map> findMapListWarehouseToWarehouseProduct(PageData pd);

    /**
     * 获取全部仓库信息-并且得到仓库的货品库存数量
     * @param pd
     * @return
     */
    List<Map> findWarehouseToWarehouseProductByProduct(PageData pd, Pagination pg);
}
