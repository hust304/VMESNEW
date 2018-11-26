package com.xy.vmes.service;

import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.xy.vmes.exception.TableVersionException;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseProduct;
import com.yvan.PageData;

import java.math.BigDecimal;
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

    WarehouseProduct selectById(String id) throws Exception;

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

    List<Map> getDataListPageDispatch(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStockCount(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    List<Map<String, Object>> findWarehouseProductMapList(PageData pd);

    WarehouseProduct findWarehouseProduct(PageData object);
    WarehouseProduct findWarehouseProductById(String id);

    List<WarehouseProduct> findWarehouseProductList(PageData object);
    String findWarehouseIdsByWarehouseProductList(List<WarehouseProduct> objectList);
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取推荐货位(默认货位)
     * 1. 查询库存表(vmes_warehouse_product:仓库货位产品库存表)
     *   A. 相同货品的库位，按数量由少到多
     *   B. 历史放过此货品的空库位
     * 2. 若是新货，就推荐相同货品分类附近的空库位
     * 3. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
     *
     * @param companyId  企业id
     * @param product    货品对象
     * @return
     */
    String findDefaultWarehousePosition(String companyId, Product product);

    String findWarehouseIdsByMapList(List<Map<String, Object>> mapList);

    /////////////////////////////////////////////////////////////////////////////////

    /**
     * 入库(变更库存数量)
     * @param object  入库库存信息
     * @param count   入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
     * @param loginfo
     */
    String inStockCount(WarehouseProduct object,
                        BigDecimal count,
                        WarehouseLoginfo loginfo) throws TableVersionException,Exception;
    /**
     * 出库(变更库存数量)
     * @param object  出库库存信息
     * @param count   出库数量(大于零或小于零)--小于零)反向操作(撤销出库)
     * @param loginfo
     */
    String outStockCount(WarehouseProduct object,
                         BigDecimal count,
                         WarehouseLoginfo loginfo) throws TableVersionException,Exception;

    /**
     * 盘点(变更库存数量)
     * @param object  盘点库存信息
     * @param count   盘点数量(大于零或小于零)--小于零)反向操作(撤销盘点)
     * @param loginfo
     */
    String checkStockCount(WarehouseProduct object,
                           BigDecimal count,
                           WarehouseLoginfo loginfo) throws TableVersionException,Exception;

    /**
     * 移库(变更库存数量)
     * @param source  变更源对象
     * @param target  变更目标对象
     * @param count   变更数量(大于零或小于零)
     * @param loginfo
     */
    String moveStockCount(WarehouseProduct source,
                          WarehouseProduct target,
                          BigDecimal count,
                          WarehouseLoginfo loginfo) throws TableVersionException,Exception;

    /**
     * 变更库存数量唯一接口
     * 库存数量变更，包括操作(入库, 出库, 移库)
     *
     * (源)source<WarehouseProduct>
     *   code:        is not null 货位批次号
     *   productId:   is not null 货品id
     *   warehouseId: is not null 库位id
     *
     * (目标)target<WarehouseProduct>
     *   code:        is not null 货位批次号
     *   productId:   is not null 货品id
     *   warehouseId: is not null 库位id
     *
     * (操作类型)type:(in:入库 out:出库 move:移库)
     * (变更数量)count: 大于零或小于零，(小于零)反向操作 退回或撤销业务等
     *
     * in:入库
     * (源)source (null) is null
     *(目标)target (不可为空)is not null
     * (货位批次号,货品id,库位id)查询库存表-得到库存数量
     * 库存数量 + 变更数量 := 变更后库存数量  变更数量(小于零) 撤销入库
     *
     * out:出库
     * (源)source (不可为空) is not null
     * (目标)target (null) is null
     * (货位批次号,货品id,库位id)查询库存表-得到库存数量
     * 库存数量 - 变更数量 := 变更后库存数量  变更数量(小于零) 撤销出库
     *
     * move:移库
     * (源)source (不可为空) is not null
     *   (货位批次号,货品id,库位id)查询库存表-得到(源)库存数量
     *   (源)库存数量 - 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     * (目标)target (不可为空)is not null
     *   (货位批次号,货品id,库位id)查询库存表-得到(目标)库存数量
     *   (目标)库存数量 + 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     *
     *
     * @param source  变更源对象
     * @param target  变更目标对象
     * @param type    (不可为空)类型(in:入库 out:出库 move:移库)
     * @param count   (不可为空)变更数量
     * @return
     */
    String modifyStockCount(WarehouseProduct source, WarehouseProduct target, String type, BigDecimal count, WarehouseLoginfo loginfo) throws Exception;


    List<Map> getWarehouseProductView(PageData pd,Pagination pg) throws Exception;

    List<Map> getWarehouseDetailView(PageData pd,Pagination pg) throws Exception;

    List<Map> getWarehouseProductMove(PageData pd,Pagination pg) throws Exception;

}



