package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.MenuButtonMapper;
import com.xy.vmes.entity.MenuButton;
import com.xy.vmes.service.MenuButtonService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_menu_button:菜单按钮表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-08-01
*/
@Service
@Transactional(readOnly = false)
public class MenuButtonServiceImp implements MenuButtonService {


    @Autowired
    private MenuButtonMapper menuButtonMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void save(MenuButton menuButton) throws Exception{
        menuButton.setId(Conv.createUuid());
        menuButton.setCdate(new Date());
        menuButton.setUdate(new Date());
        menuButtonMapper.insert(menuButton);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void update(MenuButton menuButton) throws Exception{
        menuButton.setUdate(new Date());
        menuButtonMapper.updateById(menuButton);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    //@Cacheable(cacheNames = "menuButton", key = "''+#id")
    public MenuButton selectById(String id) throws Exception{
        return menuButtonMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        menuButtonMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<MenuButton> dataListPage(PageData pd,Pagination pg) throws Exception{
        return menuButtonMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<MenuButton> dataList(PageData pd) throws Exception{
        return menuButtonMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return menuButtonMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return menuButtonMapper.findDataList(pd);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        menuButtonMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<MenuButton> selectByColumnMap(Map columnMap) throws Exception{
    List<MenuButton> menuButtonList =  menuButtonMapper.selectByMap(columnMap);
        return menuButtonList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return menuButtonMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return menuButtonMapper.getDataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        menuButtonMapper.updateToDisableByIds(ids);
    }

    /**
     * 根据菜单ID-删除菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    public void deleteMenuButtonByMenuId(String menuId) throws Exception {
        menuButtonMapper.deleteMenuButtonByMenuId(menuId);
    }

    /**
     * 修改禁用属性(isdisable)
     * 根据菜单ID-修改菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    public void updateDisableByMenuId(String menuId) {
        menuButtonMapper.updateDisableByMenuId(menuId);
    }

    public List<MenuButton> findMenuButtonList(PageData object) {
        List<MenuButton> objectList = new ArrayList<MenuButton>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }
}



