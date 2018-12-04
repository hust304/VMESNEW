package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.ProductUnitMapper;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.service.ProductUnitService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：产品计价单位 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class ProductUnitServiceImp implements ProductUnitService {


    @Autowired
    private ProductUnitMapper productUnitMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void save(ProductUnit productUnit) throws Exception{
        productUnit.setId(Conv.createUuid());
        productUnit.setCdate(new Date());
        productUnit.setUdate(new Date());
        productUnitMapper.insert(productUnit);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void update(ProductUnit productUnit) throws Exception{
        productUnit.setUdate(new Date());
        productUnitMapper.updateById(productUnit);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void updateAll(ProductUnit productUnit) throws Exception{
        productUnit.setUdate(new Date());
        productUnitMapper.updateAllColumnById(productUnit);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    //@Cacheable(cacheNames = "productUnit", key = "''+#id")
    public ProductUnit selectById(String id) throws Exception{
        return productUnitMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteById(String id) throws Exception{
        productUnitMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        productUnitMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> dataListPage(PageData pd,Pagination pg) throws Exception{
        return productUnitMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> dataList(PageData pd) throws Exception{
        return productUnitMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return productUnitMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return productUnitMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        productUnitMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> selectByColumnMap(Map columnMap) throws Exception{
    List<ProductUnit> productUnitList =  productUnitMapper.selectByMap(columnMap);
        return productUnitList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return productUnitMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return productUnitMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return productUnitMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        productUnitMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
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
    public List<ProductUnit> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProductUnit>();
        }

        return this.dataList(pageData);
    }

    public ProductUnit findProductUnit(PageData object) throws Exception {
        List<ProductUnit> objectList = this.findProductUnitList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public ProductUnit findProductUnitById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findProductUnit(findMap);
    }

    public List<ProductUnit> findProductUnitList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

}



