package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.ProductMapper;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.entity.ProductUnitPrice;
import com.xy.vmes.service.ProductService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_product:产品表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-09-21
*/
@Service
@Transactional(readOnly = false)
public class ProductServiceImp implements ProductService {


    @Autowired
    private ProductMapper productMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void save(Product product) throws Exception{
        product.setId(Conv.createUuid());
        product.setCdate(new Date());
        product.setUdate(new Date());
        productMapper.insert(product);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void update(Product product) throws Exception{
        product.setUdate(new Date());
        productMapper.updateById(product);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void updateAll(Product product) throws Exception{
        product.setUdate(new Date());
        productMapper.updateAllColumnById(product);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    //@Cacheable(cacheNames = "product", key = "''+#id")
    public Product selectById(String id) throws Exception{
        return productMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteById(String id) throws Exception{
        productMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        productMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> dataListPage(PageData pd,Pagination pg) throws Exception{
        return productMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> dataList(PageData pd) throws Exception{
        return productMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return productMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return productMapper.findDataList(pd);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        productMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> selectByColumnMap(Map columnMap) throws Exception{
    List<Product> productList =  productMapper.selectByMap(columnMap);
        return productList;
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return productMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return productMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        productMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void initialProductByStockCount(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        productMapper.updateProductInitialByStockCount(pageData);
    }

    public Product findProductById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findProduct(findMap);
    }

    public Product findProduct(PageData object) {
        if (object == null) {return null;}

        List<Product> objectList = this.findProductList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public List<Product> findProductList(PageData object) {
        if (object == null) {return null;}

        List<Product> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public String findIdsByProductList(List<Product> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Product object : objectList) {
            strBuf.append(object.getId().trim());
            strBuf.append(",");
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    public String findIdsByPageMapList(List<Map> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, Object> mapObject : mapList) {
            String productId = (String)mapObject.get("id");
            if (productId != null && productId.trim().length() > 0) {
                strBuf.append(productId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
        }
        return strTemp;
    }

    @Override
    public void updateStockCount(Product product, BigDecimal count,String uuser) throws Exception {
        PageData pd = new PageData();
        pd.put("id",product.getId());
        pd.put("version",product.getVersion());
        pd.put("uuser",uuser);
        pd.put("stockCount",count);
        productMapper.updateStockCount(pd);
    }

    public ProductUnit product2ProductUnit(Product product, ProductUnit productUnit,String unit) {
        if (productUnit == null) {productUnit = new ProductUnit();}
        if (product == null) {return productUnit;}

        //货品id productId
        productUnit.setProductId(product.getId());
        //计价单位 unit
        productUnit.setUnit(unit);
        //计量转换计价单位 单位换算公式 np_formula
        productUnit.setNpFormula("P=N");
        //计价转换计量单位 单位换算公式 pn_formula
        productUnit.setPnFormula("N=P");
        productUnit.setIsdefault("1");
        productUnit.setType("1");
        //创建人id
        productUnit.setCuser(product.getCuser());
        //货品单价 productPrice
        if (product.getPrice() != null) {
            productUnit.setProductPrice(product.getPrice());
        }

        return productUnit;
    }

    public ProductUnitPrice product2ProductUnitPrice(Product product, ProductUnitPrice productUnitPrice,String unit) {
        if (productUnitPrice == null) {productUnitPrice = new ProductUnitPrice();}
        if (product == null) {return productUnitPrice;}

        //货品ID productId
        productUnitPrice.setProductId(product.getId());
        //计价单位ID priceUnit
        productUnitPrice.setPriceUnit(unit);
        //货品单价 productPrice
        productUnitPrice.setProductPrice(product.getPrice());
        //创建用户id cuser
        productUnitPrice.setCuser(product.getCuser());

        return productUnitPrice;
    }
}



