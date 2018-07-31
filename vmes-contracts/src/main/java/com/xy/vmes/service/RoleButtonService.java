package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.RoleButton;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_role_button:角色按钮 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-30
*/
public interface RoleButtonService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void save(RoleButton roleButton) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void update(RoleButton roleButton) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    RoleButton selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<RoleButton> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<RoleButton> dataList(PageData pd) throws Exception;

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
    List<RoleButton> findRoleButtonList(PageData object);

    /**
     * 根据当前角色ID-删除角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void deleteRoleButtonByRoleId(String roleId) throws Exception;
    /**
     * 添加角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void addRoleButtonByMeunIds(String roleId, String buttonIds);

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void updateDisableByRoleId(String roleId);
}



