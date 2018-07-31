package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Role;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_role:角色 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-30
*/
public interface RoleService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void save(Role role) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void update(Role role) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    Role selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<Role> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    List<Role> dataList(PageData pd) throws Exception;

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
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-07-30
     */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-07-30
     */
    List<Map<String, Object>> getDataList(PageData pd) throws Exception;

    /**
     * 批量修改角色信息为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     */
    void updateDisableByIds(String[] ids) throws Exception;

    List<Role> findRoleList(PageData object);
    Role findRoleById(String id);

    /**
     * check角色ID是否允许删除
     * 当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     * @param roleIds
     * @return
     */
    String checkDeleteRoleByRoleIds(String roleIds);

}



