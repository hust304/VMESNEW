package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.RoleMenuMapper;
import com.xy.vmes.entity.RoleMenu;
import com.xy.vmes.service.RoleMenuService;
import com.yvan.PageData;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_role_menu:角色菜单表:角色按钮 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-30
*/
@Service
@Transactional(readOnly = false)
public class RoleMenuServiceImp implements RoleMenuService {


    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void save(RoleMenu roleMenu) throws Exception{
        roleMenu.setId(Conv.createUuid());
        roleMenu.setCdate(new Date());
        roleMenu.setUdate(new Date());
        roleMenuMapper.insert(roleMenu);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void update(RoleMenu roleMenu) throws Exception{
        roleMenu.setUdate(new Date());
        roleMenuMapper.updateById(roleMenu);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    //@Cacheable(cacheNames = "roleMenu", key = "''+#id")
    public RoleMenu selectById(String id) throws Exception{
        return roleMenuMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void deleteById(String id) throws Exception{
        roleMenuMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<RoleMenu> dataListPage(PageData pd,Pagination pg) throws Exception{
        return roleMenuMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<RoleMenu> dataList(PageData pd) throws Exception{
        return roleMenuMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return roleMenuMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return roleMenuMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<RoleMenu> findRoleMenuList(PageData object) {
        List<RoleMenu> objectList = new ArrayList<RoleMenu>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    /**
     * 根据当前角色ID-删除角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void deleteRoleMenuByRoleId(String roleId) throws Exception {
        roleMenuMapper.deleteRoleMenuByRoleId(roleId);
    }
    /**
     * 添加角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void addRoleMenuByMeunIds(String roleId, String meunIds) {
        if (roleId == null || roleId.trim().length() == 0) {return;}
        if (meunIds == null || meunIds.trim().length() == 0) {return;}

        meunIds = StringUtil.stringTrimSpace(meunIds);
        String[] strArry = meunIds.split(",");
        for (int i = 0; i < strArry.length; i++) {
            String meunID = strArry[i];
            RoleMenu objectDB = new RoleMenu();
            objectDB.setIsdisable("0");
            objectDB.setRoleId(roleId);
            objectDB.setMenuId(meunID);
            try {
                this.save(objectDB);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }
    }

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改角色菜单
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void updateDisableByRoleId(String roleId) {
        roleMenuMapper.updateDisableByRoleId(roleId);
    }

    /**
     * 角色菜单-关联菜单表-<Map>
     * @param pd
     * @return
     */
    public List<Map<String, Object>> findRoleMenuMapList(PageData pd) {
        return roleMenuMapper.findRoleMenuMapList(pd);
    }
}



