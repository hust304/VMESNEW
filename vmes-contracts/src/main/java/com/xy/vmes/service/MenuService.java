package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Menu;
import com.yvan.PageData;
import com.yvan.Tree;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_menu:系统功能菜单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-31
*/
public interface MenuService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void save(Menu menu) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void update(Menu menu) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    Menu selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Menu> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Menu> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Map> findDataList(PageData pd) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 批量修改菜单信息为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void updateDisableByIds(String[] ids) throws Exception;

    /**
     * 查询菜单表(vmes_menu)
     * @param object
     * @return
     */
    List<Menu> findMenuList(PageData object);
    /**
     * 查询菜单表(vmes_menu)
     * @param object
     * @return
     */
    Menu findMenu(PageData object);
    /**
     * 根据ID-查询菜单表(vmes_menu)
     * @param id
     * @return
     */
    Menu findMenuById(String id);

    /**
     * 根据pid-查询菜单表(vmes_menu)
     * @param pid
     * @return
     */
    List<Menu> findMenuListByPid(String pid);

    /**
     * 菜单名称同一层级是否相同
     *
     * @param pid   (不可为空)
     * @param id    (允许为空)-(添加时is null, 修改时 is not null)
     * @param name  (不可为空)
     * @return
     *     true : 菜单名称存在名称相同
     *     false: 菜单名称不存在名称相同(默认值)
     */
    boolean isExistByName(String pid, String id, String name);

    /**
     * 根据菜单对象<Menu>当前菜单节点下面所有节点生成树形结构
     * 1. <Menu>对象为空时-生成整棵树-(pid:=root)开始-菜单级别(0-5)
     * 2. <Menu>对象is not null
     * (允许为空)Menu.id    当前菜单id
     * (允许为空)Menu.code  当前菜单编码
     * (允许为空)Menu.name  当前菜单名称
     * (允许为空)Menu.id1   当前菜单(id_1)-公司id
     * (允许为空)Menu.layer 当前菜单级别
     * 3. (id,id1,code,name,layer) 不可同时为空
     * pid is not null pid对应的菜单+pid下面所有子菜单
     * pid is null (code,layer) is not null or (name,layer) is not null
     * <p>
     * <p>
     * <p>
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     * @param detp 允许为空-<Menu>对象(vmes_Menu:系统菜单表)
     * @return
     */
    Tree<Menu> findTree(Menu detp);

    /**
     * 获取菜单id字符串-(','分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    String findMenuidByMenuList(List<Menu> objectList);

    /**
     * 获取菜单最大级别-遍历菜单List<Menu>
     *
     * 创建人：陈刚
     * 创建时间：2018-07-24
     * @param objectList
     * @return
     */
    Integer findMaxLayerByMenuList(List<Menu> objectList);



}



