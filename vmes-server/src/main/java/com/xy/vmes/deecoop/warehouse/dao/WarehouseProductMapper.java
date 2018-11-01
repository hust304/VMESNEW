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
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    List<Map<String, Object>> findWarehouseProductMapList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    void updateStockCount(PageData pd);


    List<Map> getDataListPageDispatch(PageData pd, Pagination pg);

}


