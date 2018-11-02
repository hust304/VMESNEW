package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.RoleMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.RoleButtonService;
import com.xy.vmes.service.RoleMenuService;
import com.xy.vmes.service.RoleService;
import com.xy.vmes.service.UserRoleService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_role:角色 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-30
*/
@Service
@Transactional(readOnly = false)
public class RoleServiceImp implements RoleService {


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleButtonService roleButtonService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void save(Role role) throws Exception{
        role.setId(Conv.createUuid());
        role.setCdate(new Date());
        roleMapper.insert(role);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void update(Role role) throws Exception{
        role.setUdate(new Date());
        roleMapper.updateById(role);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-07-30
     */
    @Override
    public void updateAll(Role role) throws Exception{
        role.setUdate(new Date());
        roleMapper.updateAllColumnById(role);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    //@Cacheable(cacheNames = "role", key = "''+#id")
    public Role selectById(String id) throws Exception{
        return roleMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void deleteById(String id) throws Exception{
        roleMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<Role> dataListPage(PageData pd,Pagination pg) throws Exception{
        return roleMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<Role> dataList(PageData pd) throws Exception{
        return roleMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return roleMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return roleMapper.findDataList(pd);
    }

    public void deleteByIds(String[] ids) throws Exception {
        roleMapper.deleteByIds(ids);
    }
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-30
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception {
        return roleMapper.getColumnList();
    }
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-30
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return roleMapper.getDataListPage(pd, pg);
    }

    /**
     * 批量修改角色信息为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     */
    public void updateDisableByIds(String[] ids) throws Exception {
        roleMapper.updateDisableByIds(ids);
    }

    public List<Role> findRoleList(PageData object) {
        List<Role> objectList = new ArrayList<Role>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public Role findRoleById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Role> objectList = this.findRoleList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    /**
     * check角色ID是否允许删除
     * 当前角色ID(用户角色,角色菜单,角色按钮)-是否使用
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     * @param roleIds
     * @return
     */
    public String checkDeleteRoleByRoleIds(String roleIds) {
        if (roleIds == null || roleIds.trim().length() == 0) {return new String();}

        String msgTemp = "第 {0} 行: 角色在({1})中使用不可禁用！" + Common.SYS_ENDLINE_DEFAULT;
        StringBuffer msgBuf = new StringBuffer();

        String[] roleid_arry = roleIds.split(",");
        PageData findMap = new PageData();
        for (int i = 0; i < roleid_arry.length; i++) {
            String roleID = roleid_arry[i];

            findMap.put("isdisable", "1");
            findMap.put("roleId", roleID);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));

            //1. 当前角色ID(用户角色)
            List<UserRole> list_1 = userRoleService.findUserRoleList(findMap);
            if (list_1 != null && list_1.size() > 0) {
                String msg_1 = MessageFormat.format(msgTemp, (i+1), "用户角色");
                msgBuf.append(msg_1);
            }

            //2. 当前角色ID(角色菜单)
            List<RoleMenu> list_2 = roleMenuService.findRoleMenuList(findMap);
            if (list_2 != null && list_2.size() > 0) {
                String msg_2 = MessageFormat.format(msgTemp, (i+1), "角色菜单");
                msgBuf.append(msg_2);
            }

            //3. 当前角色ID(角色按钮)
            List<RoleButton> list_3 = roleButtonService.findRoleButtonList(findMap);
            if (list_3 != null && list_3.size() > 0) {
                String msg_3 = MessageFormat.format(msgTemp, (i+1), "角色按钮");
                msgBuf.append(msg_3);
            }
        }

        return  msgBuf.toString();
    }

    /**
     * 获取角色ID(','逗号分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-08-01
     *
     * @param objectList
     * @return
     */
    public String findRoleIdsByRoleList(List<Role> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Role object : objectList) {
            if (object.getId() != null && object.getId().trim().length() > 0)  {
                strBuf.append(object.getId().trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    /**
     * 角色名称是否相同
     *
     * @param companyId  (不可为空)
     * @param id         (允许为空)-(添加时is null, 修改时 is not null)
     * @param name       (不可为空)
     * @return
     *     true : 角色名称相同
     *     false: 角色名称不相同(默认值)
     */
    public boolean isExistByName(String companyId, String id, String name) {
        if (companyId == null || companyId.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("currentCompanyId", companyId);
        findMap.put("name", name);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Role> objectList = this.findRoleList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }
}



