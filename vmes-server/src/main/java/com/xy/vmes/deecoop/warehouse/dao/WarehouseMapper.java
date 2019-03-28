package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Warehouse;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse:仓库货位表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-10-10
*/
@Mapper
@Repository
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    List<Warehouse> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteWarehouseByPath(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
    /**
     * 获取全部仓库货位记录，同时带出该(货位,货品)库存数量
     *
     * @param pd
     * @param pg
     * @return
     */
    List<Map> findListWarehouseByWarehouseProduct(PageData pd, Pagination pg);
}


