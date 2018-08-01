package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.EmployPostMapper;
import com.xy.vmes.entity.EmployPost;
import com.xy.vmes.service.EmployPostService;
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
* 说明：vmes_employ_post:员工岗位关系表 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-01
*/
@Service
@Transactional(readOnly = false)
public class EmployPostServiceImp implements EmployPostService {


    @Autowired
    private EmployPostMapper employPostMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void save(EmployPost employPost) throws Exception{
        employPost.setId(Conv.createUuid());
        employPost.setCdate(new Date());
        employPost.setUdate(new Date());
        employPostMapper.insert(employPost);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void update(EmployPost employPost) throws Exception{
        employPost.setUdate(new Date());
        employPostMapper.updateById(employPost);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    //@Cacheable(cacheNames = "employPost", key = "''+#id")
    public EmployPost selectById(String id) throws Exception{
        return employPostMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        employPostMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        employPostMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<EmployPost> dataListPage(PageData pd,Pagination pg) throws Exception{
        return employPostMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<EmployPost> dataList(PageData pd) throws Exception{
        return employPostMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return employPostMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return employPostMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        employPostMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<EmployPost> selectByColumnMap(Map columnMap) throws Exception{
    List<EmployPost> employPostList =  employPostMapper.selectByMap(columnMap);
        return employPostList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return employPostMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return employPostMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return employPostMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        employPostMapper.updateToDisableByIds(ids);
    }
}



