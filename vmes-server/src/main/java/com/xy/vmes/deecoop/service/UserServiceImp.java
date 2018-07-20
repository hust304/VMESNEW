package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.UserMapper;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.UserService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 实现类
* 创建人：自动创建
* 创建时间：2018-07-20
*/
@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void save(User user) throws Exception{
        userMapper.save(user);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void delete(User user) throws Exception{
        userMapper.delete(user);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void update(User user) throws Exception{
        userMapper.update(user);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    @Cacheable(cacheNames = "user", key = "''+#id")
    public User selectById(String id) throws Exception{
        return userMapper.selectById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void deleteById(String id) throws Exception{
        userMapper.deleteById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public User findById(PageData pd) throws Exception{
        return userMapper.findById(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<User> dataListPage(PageData pd,Pagination pg) throws Exception{
        return userMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<User> dataList(PageData pd) throws Exception{
        return userMapper.dataList(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        userMapper.deleteByIds(ids);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return userMapper.findColumnList();
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return userMapper.findDataList(pd);
    }

}



