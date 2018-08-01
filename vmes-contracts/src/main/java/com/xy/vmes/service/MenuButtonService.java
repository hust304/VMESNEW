package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.MenuButton;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_menu_button:菜单按钮表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-08-01
*/
public interface MenuButtonService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void save(MenuButton menuButton) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void update(MenuButton menuButton) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    MenuButton selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<MenuButton> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<MenuButton> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<MenuButton> selectByColumnMap(Map columnMap) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    List<MenuButton> findMenuButtonList(PageData object);
    /**
     * 根据菜单ID-删除菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    void deleteMenuButtonByMenuId(String menuId) throws Exception;

    /**
     * 修改禁用属性(isdisable)
     * 根据菜单ID-修改菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    void updateDisableByMenuId(String menuId);

}



