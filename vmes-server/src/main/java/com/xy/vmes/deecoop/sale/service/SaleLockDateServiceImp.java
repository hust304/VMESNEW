package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleLockDateMapper;
import com.xy.vmes.entity.SaleLockDate;
import com.xy.vmes.service.SaleLockDateService;
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
* 创建时间：2018-12-12
*/
@Service
@Transactional(readOnly = false)
public class SaleLockDateServiceImp implements SaleLockDateService {


    @Autowired
    private SaleLockDateMapper saleLockDateMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void save(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setId(Conv.createUuid());
        saleLockDate.setCdate(new Date());
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.insert(saleLockDate);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void update(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.updateById(saleLockDate);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void updateAll(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.updateAllColumnById(saleLockDate);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    //@Cacheable(cacheNames = "saleLockDate", key = "''+#id")
    public SaleLockDate selectById(String id) throws Exception{
        return saleLockDateMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleLockDateMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleLockDateMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleLockDateMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> dataList(PageData pd) throws Exception{
        return saleLockDateMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleLockDateMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleLockDateMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleLockDateMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleLockDate> saleLockDateList =  saleLockDateMapper.selectByMap(columnMap);
        return saleLockDateList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleLockDateMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleLockDateMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleLockDateMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleLockDateMapper.updateToDisableByIds(ids);
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
    public List<SaleLockDate> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleLockDate>();
        }

        return this.dataList(pageData);
    }
}



