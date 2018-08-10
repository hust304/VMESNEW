package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.system.dao.UserRoleMapper;
import com.xy.vmes.entity.Role;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.RoleService;
import com.xy.vmes.service.UserRoleService;
import com.yvan.Conv;
import com.yvan.PageData;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private RoleService roleService;

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
     * 用户角色-关联角色表
     * @param pd
     * @return
     */
    public List<Map<String, Object>> findUserRoleMapList(PageData pd) {
        return userRoleMapper.findUserRoleMapList(pd);
    }



    public List<UserRole> findUserRoleList(PageData object) {
        List<UserRole> objectList = new ArrayList<UserRole>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }
    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public void deleteRoleByUserId(String userId) throws Exception {
        userRoleMapper.deleteRoleByUserId(userId);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void deleteUserRoleByRoleId(String roleId) throws Exception {
        userRoleMapper.deleteUserRoleByRoleId(roleId);
    }

    /**
     * 添加用户角色
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void addUserRoleByUserIds(String roleId, String userIds) {
        if (roleId == null || roleId.trim().length() == 0) {return;}
        if (userIds == null || userIds.trim().length() == 0) {return;}

        userIds = StringUtil.stringTrimSpace(userIds);
        String[] strArry = userIds.split(",");
        for (int i = 0; i < strArry.length; i++) {
            String userID = strArry[i];
            UserRole objectDB = new UserRole();
            objectDB.setIsdisable("0");
            objectDB.setRoleId(roleId);
            objectDB.setUserId(userID);
            try {
                this.save(objectDB);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }
    }

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改用户角色
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void updateDisableByRoleId(String roleId) {
        userRoleMapper.updateDisableByRoleId(roleId);
    }

    /**
     * 根据userID-获取角色ID(','逗号分隔的字符串)
     * @param userID
     * @return
     */
    public String findRoleIdsByByUserID(String userID) {
        if (userID == null || userID.trim().length() == 0) {return new String();}

        PageData findMap = new PageData();
        findMap.put("userId", userID);
        findMap.put("isdisable", "1");
        findMap.put("roleIsdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Map<String, Object>> mapList = this.findUserRoleMapList(findMap);
        List<Role> roleList = this.userRoleMap2RoleList(mapList, new ArrayList<Role>());

        return roleService.findRoleIdsByRoleList(roleList);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public Role userRoleMap2Role(Map<String, Object> mapObject, Role object) {
        if (object == null) {object = new Role();}
        if (mapObject == null) {return object;}

        //b.id as roleId,
        if (mapObject.get("roleId") != null) {
            object.setId(mapObject.get("roleId").toString().trim());
        }
        //b.company_id as roleCompanyId,
        if (mapObject.get("roleCompanyId") != null) {
            object.setCompanyId(mapObject.get("roleCompanyId").toString().trim());
        }
        //b.name as roleName,
        if (mapObject.get("roleName") != null) {
            object.setName(mapObject.get("roleName").toString().trim());
        }
        //b.name_en as roleNameEn,
        if (mapObject.get("roleNameEn") != null) {
            object.setNameEn(mapObject.get("roleNameEn").toString().trim());
        }
        //b.isdisable as roleIsdisable,
        if (mapObject.get("roleIsdisable") != null) {
            object.setIsdisable(mapObject.get("roleIsdisable").toString().trim());
        }

        //b.cdate as roleCdate,
        if (mapObject.get("roleCdate") != null) {
            String dateStr = mapObject.get("roleCdate").toString().trim();
            Date date = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            if (date != null) {
                object.setCdate(date);
            }
        }
        //b.cuser as roleCuser,
        if (mapObject.get("roleCuser") != null) {
            object.setCuser(mapObject.get("roleCuser").toString().trim());
        }
        //b.udate as roleUdate,
        if (mapObject.get("roleUdate") != null) {
            String dateStr = mapObject.get("roleUdate").toString().trim();
            Date date = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            if (date != null) {
                object.setUdate(date);
            }
        }
        //b.uuser as roleUuser
        if (mapObject.get("roleUuser") != null) {
            object.setUuser(mapObject.get("roleUuser").toString().trim());
        }

        return object;
    }

    public List<Role> userRoleMap2RoleList(List<Map<String, Object>> mapList, List<Role> objectList) {
        if (objectList == null) {
            objectList = new ArrayList<Role>();
        }
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, Object> mapObj : mapList) {
            Role object = new Role();
            object = this.userRoleMap2Role(mapObj, object);
            objectList.add(object);
        }

        return objectList;
    }

}



