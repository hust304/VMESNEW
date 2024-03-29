package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseProduct;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_product:仓库货位产品库存表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Mapper
@Repository
public interface WarehouseProductMapper extends BaseMapper<WarehouseProduct> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseProduct> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTable(PageData pageData);
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    List<Map<String, Object>> findWarehouseProductMapList(PageData pd);
    List<Map<String, Object>> findWarehouseProductMapList(PageData pd, Pagination pg);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    Integer updateStockCount(PageData pd);


    List<Map> getDataListPageDispatch(PageData pd, Pagination pg);
    List<Map> getDataListPageDispatch(PageData pd);

    List<Map> getDataListPageDispatchByWC(PageData pd);

    List<Map> getDataListPageDispatchBySimple(PageData pd, Pagination pg);
    List<Map> getDataListPageDispatchBySimple(PageData pd);

    List<Map> warehouseProductView(PageData pd);
    List<Map> warehouseProductView(PageData pd, Pagination pg);

    List<Map> simpleWarehouseProductView(PageData pd);

    List<Map> simpleWarehouseProductView(PageData pd, Pagination pg);

    List<Map> warehouseProductMove(PageData pd, Pagination pg);

    List<Map> warehouseDetailView(PageData pd, Pagination pg);

    List<Map> simpleWarehouseDetailView(PageData pd);
    List<Map> simpleWarehouseDetailView(PageData pd, Pagination pg);



    /**
     * 查询(仓库id或仓库货位id)下面所有仓库或货位，货位货品表(vmes_warehouse_product)
     * 查询参数(企业id, 仓库id或仓库货位id)
     *
     * @param pd
     * @return
     */
    List<Map<String, Object>> findWarehouseProductByWarehouse(PageData pd);

    //////////////////////////////////////////////////////////////////////////////////
    //手机端功能
    List<Map> findListPageWarehouseByProduct(PageData pd, Pagination pg);


    void updateSynStockCount(PageData pd);

    List<Map> wcWarehouseProductView(PageData pd, Pagination pg);
}


