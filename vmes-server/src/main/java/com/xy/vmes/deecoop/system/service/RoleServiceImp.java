package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.RoleMapper;
import com.xy.vmes.entity.Role;
import com.xy.vmes.service.RoleService;
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

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Override
    public void save(Role role) throws Exception{
        role.setId(Conv.createUuid());
        role.setIsdisable("0");
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


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
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
     * check角色列表List<Role>是否允许删除
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     * @param objectList
     * @return
     */
    public String checkDeleteRoleByList(List<Role> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String msgTemp = "第&nbsp;{0}&nbsp;行:&nbsp;状态为(启用)不可删除！<br/>";
        for (int i = 0; i < objectList.size(); i++) {
            Role object = objectList.get(i);
            //isdisable:是否禁用(1:已禁用 0:启用)
            if (object.getIsdisable() != null && "0".equals(object.getIsdisable().trim())) {
                String str_isnull = MessageFormat.format(msgTemp, Integer.valueOf(i+1).toString());
                msgBuf.append(str_isnull);
            }
        }

        return  msgBuf.toString();
    }
}



