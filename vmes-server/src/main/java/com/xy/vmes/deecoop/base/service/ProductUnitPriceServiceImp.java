package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.ProductUnitPriceMapper;
import com.xy.vmes.entity.ProductUnitPrice;
import com.xy.vmes.service.ProductUnitPriceService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
* 说明：vmes_product_unit_price:货品价格 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-04
*/
@Service
@Transactional(readOnly = false)
public class ProductUnitPriceServiceImp implements ProductUnitPriceService {


    @Autowired
    private ProductUnitPriceMapper productUnitPriceMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-04
    */
    @Override
    public void save(ProductUnitPrice productUnitPrice) throws Exception{
        productUnitPrice.setId(Conv.createUuid());
        productUnitPrice.setCdate(new Date());
        productUnitPrice.setUdate(new Date());
        productUnitPriceMapper.insert(productUnitPrice);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public ProductUnitPrice selectById(String id) throws Exception{
        return productUnitPriceMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public List<ProductUnitPrice> selectByColumnMap(Map columnMap) throws Exception{
        List<ProductUnitPrice> warehouseCheckDetailList =  productUnitPriceMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void update(ProductUnitPrice object) throws Exception{
        object.setUdate(new Date());
        productUnitPriceMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void updateAll(ProductUnitPrice object) throws Exception{
        object.setUdate(new Date());
        productUnitPriceMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void deleteById(String id) throws Exception{
        productUnitPriceMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        productUnitPriceMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        productUnitPriceMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-04
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        productUnitPriceMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<ProductUnitPrice> dataList(PageData pd) throws Exception {
        return productUnitPriceMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return productUnitPriceMapper.getDataListPage(pd, pg);
    }
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<ProductUnitPrice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProductUnitPrice>();
        }

        return this.dataList(pageData);
    }
}



