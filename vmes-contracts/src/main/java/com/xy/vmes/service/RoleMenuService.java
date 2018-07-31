package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.RoleMenu;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_role_menu:角色菜单表:角色按钮 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-30
*/
public interface RoleMenuService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void save(RoleMenu roleMenu) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void update(RoleMenu roleMenu) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    RoleMenu selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<RoleMenu> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<RoleMenu> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<Map> findDataList(PageData pd) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    List<RoleMenu> findRoleMenuList(PageData object);
    /**
     * 根据当前角色ID-删除角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void deleteRoleMenuByRoleId(String roleId) throws Exception;
    /**
     * 添加角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void addRoleMenuByMeunIds(String roleId, String meunIds);

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void updateDisableByRoleId(String roleId);
}



