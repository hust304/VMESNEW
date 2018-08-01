package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.RoleButtonMapper;
import com.xy.vmes.entity.RoleButton;
import com.xy.vmes.service.RoleButtonService;
import com.yvan.PageData;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_role_button:角色按钮 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-30
*/
@Service
@Transactional(readOnly = false)
public class RoleButtonServiceImp implements RoleButtonService {


    @Autowired
    private RoleButtonMapper roleButtonMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void save(RoleButton roleButton) throws Exception{
        roleButton.setId(Conv.createUuid());
        roleButton.setCdate(new Date());
        roleButton.setUdate(new Date());
        roleButtonMapper.insert(roleButton);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void update(RoleButton roleButton) throws Exception{
        roleButton.setUdate(new Date());
        roleButtonMapper.updateById(roleButton);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    //@Cacheable(cacheNames = "roleButton", key = "''+#id")
    public RoleButton selectById(String id) throws Exception{
        return roleButtonMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void deleteById(String id) throws Exception{
        roleButtonMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<RoleButton> dataListPage(PageData pd,Pagination pg) throws Exception{
        return roleButtonMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<RoleButton> dataList(PageData pd) throws Exception{
        return roleButtonMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return roleButtonMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return roleButtonMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<RoleButton> findRoleButtonList(PageData object) {
        List<RoleButton> objectList = new ArrayList<RoleButton>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }
    /**
     * 根据当前角色ID-删除角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void deleteRoleButtonByRoleId(String roleId) throws Exception {
        roleButtonMapper.deleteRoleButtonByRoleId(roleId);
    }
    /**
     * 添加角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void addRoleButtonByMeunIds(String roleId, String buttonIds) {
        if (roleId == null || roleId.trim().length() == 0) {return;}
        if (buttonIds == null || buttonIds.trim().length() == 0) {return;}

        buttonIds = StringUtil.stringTrimSpace(buttonIds);
        String[] strArry = buttonIds.split(",");
        for (int i = 0; i < strArry.length; i++) {
            String buttonID = strArry[i];
            RoleButton objectDB = new RoleButton();
            objectDB.setIsdisable("0");
            objectDB.setRoleId(roleId);
            objectDB.setButtonId(buttonID);
            try {
                this.save(objectDB);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }
    }

    /**
     * 修改禁用属性(isdisable)
     * 根据角色ID-修改角色按钮
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void updateDisableByRoleId(String roleId) {
        roleButtonMapper.updateDisableByRoleId(roleId);
    }

}



