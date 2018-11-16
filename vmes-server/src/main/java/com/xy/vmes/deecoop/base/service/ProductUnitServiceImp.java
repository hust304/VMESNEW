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

import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
}



