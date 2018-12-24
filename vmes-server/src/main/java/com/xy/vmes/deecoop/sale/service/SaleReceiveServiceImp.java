package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveMapper;
import com.xy.vmes.entity.SaleReceive;
import com.xy.vmes.service.SaleReceiveService;
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
* 说明：收款单 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-24
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveServiceImp implements SaleReceiveService {


    @Autowired
    private SaleReceiveMapper saleReceiveMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void save(SaleReceive saleReceive) throws Exception{
        saleReceive.setId(Conv.createUuid());
        saleReceive.setCdate(new Date());
        saleReceive.setUdate(new Date());
        saleReceiveMapper.insert(saleReceive);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void update(SaleReceive saleReceive) throws Exception{
        saleReceive.setUdate(new Date());
        saleReceiveMapper.updateById(saleReceive);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void updateAll(SaleReceive saleReceive) throws Exception{
        saleReceive.setUdate(new Date());
        saleReceiveMapper.updateAllColumnById(saleReceive);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    //@Cacheable(cacheNames = "saleReceive", key = "''+#id")
    public SaleReceive selectById(String id) throws Exception{
        return saleReceiveMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<SaleReceive> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<SaleReceive> dataList(PageData pd) throws Exception{
        return saleReceiveMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<SaleReceive> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceive> saleReceiveList =  saleReceiveMapper.selectByMap(columnMap);
        return saleReceiveList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-24
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveMapper.updateToDisableByIds(ids);
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
    public List<SaleReceive> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceive>();
        }

        return this.dataList(pageData);
    }
}



