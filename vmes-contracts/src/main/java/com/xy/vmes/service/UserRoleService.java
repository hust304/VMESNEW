package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.UserRole;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_user_role:用户角色表 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-07-26
*/
public interface UserRoleService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    void save(UserRole userRole) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    void update(UserRole userRole) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    UserRole selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    List<UserRole> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    List<UserRole> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    List<Map> findDataList(PageData pd) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    List<UserRole> findUserRoleList(PageData object);

    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    void deleteRoleByUserId(String userId) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void deleteUserRoleByRoleId(String roleId) throws Exception;
    /**
     * 添加用户角色
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void addUserRoleByUserIds(String roleId, String userIds);

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改用户角色
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void updateDisableByRoleId(String roleId);


    /**
     * 根据userID-获取全部用户角色List<UserRole>
     * 创建人：陈刚
     * 创建时间：2018-08-01
     *
     * @param userID
     * @return
     */
    List<UserRole> findUserRoleByUserID(String userID);

    /**
     * 获取角色ID(','逗号分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-08-01
     *
     * @param objectList
     * @return
     */
    String findRoleIdsByUserRoleList(List<UserRole> objectList);

    /**
     * 根据userID-获取角色ID(','逗号分隔的字符串)
     * @param userID
     * @return
     */
    String findRoleIdsByByUserID(String userID);

}



