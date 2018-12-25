package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.entity.ProductUnitPrice;
import com.yvan.PageData;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_product:产品表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-09-21
*/
public interface ProductService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void save(Product product) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void update(Product product) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void updateAll(Product product) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    Product selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<Product> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<Product> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<Product> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void initialProductByStockCount(String companyId) throws Exception;

    Product findProduct(PageData object);
    Product findProductById(String id);

    List<Product> findProductList(PageData object);

    String findIdsByProductList(List<Product> objectList);
    String findIdsByPageMapList(List<Map> mapList);

    void updateStockCount(Product product, BigDecimal count, String uuser) throws Exception;

    /**
     * 修改锁定库存数量
     * @param productId   货品id
     * @param oldProduct  原货品对象
     * @param lockCount   修改的货品锁定数量
     * @param uuser       用户id
     * @throws Exception
     */
    void updateLockCount(String productId, Product oldProduct, BigDecimal lockCount, String uuser) throws Exception;

    ProductUnit product2ProductUnit(Product product, ProductUnit productUnit,String unit);
    ProductUnitPrice product2ProductUnitPrice(Product product, ProductUnitPrice productUnitPrice,String unit);
}



