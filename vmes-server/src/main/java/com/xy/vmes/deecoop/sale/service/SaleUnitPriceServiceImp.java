package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleUnitPriceMapper;
import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.service.SaleUnitPriceService;
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
import java.util.ArrayList;

/**
* 说明：设置锁库时间 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-14
*/
@Service
@Transactional(readOnly = false)
public class SaleUnitPriceServiceImp implements SaleUnitPriceService {


    @Autowired
    private SaleUnitPriceMapper saleUnitPriceMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void save(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setId(Conv.createUuid());
        saleUnitPrice.setCdate(new Date());
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.insert(saleUnitPrice);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void update(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.updateById(saleUnitPrice);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void updateAll(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.updateAllColumnById(saleUnitPrice);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    //@Cacheable(cacheNames = "saleUnitPrice", key = "''+#id")
    public SaleUnitPrice selectById(String id) throws Exception{
        return saleUnitPriceMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleUnitPriceMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleUnitPriceMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleUnitPriceMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> dataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleUnitPriceMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleUnitPriceMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleUnitPrice> saleUnitPriceList =  saleUnitPriceMapper.selectByMap(columnMap);
        return saleUnitPriceList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleUnitPriceMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleUnitPriceMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleUnitPriceMapper.updateToDisableByIds(ids);
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
    public List<SaleUnitPrice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleUnitPrice>();
        }

        return this.dataList(pageData);
    }
}



