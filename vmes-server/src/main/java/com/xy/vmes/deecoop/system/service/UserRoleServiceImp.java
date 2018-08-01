package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.UserRoleMapper;
import com.xy.vmes.entity.UserRole;
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
     * 根据userID-获取全部用户角色List<UserRole>
     * 创建人：陈刚
     * 创建时间：2018-08-01
     *
     * @param userID
     * @return
     */
    public List<UserRole> findUserRoleByUserID(String userID) {
        List<UserRole> objectList = new ArrayList<UserRole>();
        if (userID == null || userID.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("userId", userID);
        //是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
        findMap.put("isdisable", "0");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findUserRoleList(findMap);
    }

    /**
     * 获取角色ID(','逗号分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-08-01
     *
     * @param objectList
     * @return
     */
    public String findRoleIdsByUserRoleList(List<UserRole> objectList) {
        StringBuffer strBuf = new StringBuffer();
        if (objectList == null || objectList.size() == 0) {return strBuf.toString();}

        for (UserRole object : objectList) {
            if (object.getRoleId() != null && object.getRoleId().trim().length() > 0)  {
                strBuf.append(object.getRoleId().trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.indexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    /**
     * 根据userID-获取角色ID(','逗号分隔的字符串)
     * @param userID
     * @return
     */
    public String findRoleIdsByByUserID(String userID) {
        if (userID == null || userID.trim().length() == 0) {return new String();}
        List<UserRole> objectList = this.findUserRoleByUserID(userID);
        return findRoleIdsByUserRoleList(objectList);
    }

}



