package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseProduct;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_product:仓库货位产品库存表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-16
*/
public interface WarehouseProductService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void save(WarehouseProduct object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void update(WarehouseProduct object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateAll(WarehouseProduct object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseProduct> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseProduct> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStockCount(PageData pd) throws Exception;

    WarehouseProduct findWarehouseProduct(PageData object);
    WarehouseProduct findWarehouseProductById(String id);

    List<WarehouseProduct> findWarehouseProductList(PageData object);

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取推荐货位(默认货位)
     * 1. 查询库存表(vmes_warehouse_product:仓库货位产品库存表)
     *   A. 相同货品的库位，按数量由少到多
     *   B. 历史放过此货品的空库位
     * 2. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
     *
     * @param companyId  企业id
     * @param productId  货品id
     * @return
     */
    String findDefaultWarehousePosition(String companyId, String productId);
}



