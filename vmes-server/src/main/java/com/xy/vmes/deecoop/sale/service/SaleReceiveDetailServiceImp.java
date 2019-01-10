package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveDetailMapper;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.xy.vmes.service.SaleReceiveDetailService;
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
* 说明：收款明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-01-10
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveDetailServiceImp implements SaleReceiveDetailService {


    @Autowired
    private SaleReceiveDetailMapper saleReceiveDetailMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void save(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setId(Conv.createUuid());
        saleReceiveDetail.setCdate(new Date());
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.insert(saleReceiveDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void update(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.updateById(saleReceiveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateAll(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.updateAllColumnById(saleReceiveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    //@Cacheable(cacheNames = "saleReceiveDetail", key = "''+#id")
    public SaleReceiveDetail selectById(String id) throws Exception{
        return saleReceiveDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> dataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceiveDetail> saleReceiveDetailList =  saleReceiveDetailMapper.selectByMap(columnMap);
        return saleReceiveDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-01-10
     */
    @Override
    public List<Map> getOrderReceiveDetailDataListPage(PageData pd, Pagination pg) throws Exception{
        return saleReceiveDetailMapper.getOrderReceiveDetailDataListPage(pd,pg);
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
    public List<SaleReceiveDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceiveDetail>();
        }

        return this.dataList(pageData);
    }
}



