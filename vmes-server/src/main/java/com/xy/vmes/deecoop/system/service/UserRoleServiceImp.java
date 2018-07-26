package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.UserRoleMapper;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.UserRoleService;
import com.yvan.Conv;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_user_role:用户角色表 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-07-26
*/
@Service
@Transactional(readOnly = false)
public class UserRoleServiceImp implements UserRoleService {


    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public void save(UserRole userRole) throws Exception{
        userRole.setId(Conv.createUuid());
        userRole.setCdate(new Date());
        userRole.setUdate(new Date());
        userRoleMapper.insert(userRole);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public void update(UserRole userRole) throws Exception{
        userRole.setUdate(new Date());
        userRoleMapper.updateById(userRole);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    //@Cacheable(cacheNames = "userRole", key = "''+#id")
    public UserRole selectById(String id) throws Exception{
        return userRoleMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public void deleteById(String id) throws Exception{
        userRoleMapper.deleteById(id);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public List<UserRole> dataListPage(PageData pd,Pagination pg) throws Exception{
        return userRoleMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public List<UserRole> dataList(PageData pd) throws Exception{
        return userRoleMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return userRoleMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return userRoleMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public void deleteRoleByUserId(String userId) throws Exception {
        userRoleMapper.deleteRoleByUserId(userId);
    }
}



