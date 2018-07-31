package com.xy.vmes.service;

import com.xy.vmes.entity.Menu;
import com.yvan.platform.RestException;

import java.util.List;

/**
 * 当前菜单节点和该菜单节点下所有子菜单-的树形结构
 * 1. 查询(vmes_menu:系统菜单表)-查询次数(当前菜单节点-最低层叶子菜单节点)层数
 * 2. 每次递归查询pid-(通过','逗号分隔的字符串)-得到下一层菜单节点List集合-存入对应的层的List结构体中
 * 3. 递归结束条件()
 *
 * 菜单树结构生成
 * 创建人：陈刚
 * 创建时间：2018-07-31
 */
public interface MenuTreeService {
    List<Menu> getList_1();
    List<Menu> getList_2();
    List<Menu> getList_3();
    List<Menu> getList_4();
    List<Menu> getList_5();

    /**
     * 初始化方法
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    void initialization();

    /**
     * 根据菜单对象<Menu>当前菜单节点下面所有节点生成树形结构
     * 查询次数: 从当前节点到最低层叶子节点-总共菜单层级数
     *
     * 1. 该方法为递归调用
     * 2. 递归执行次数: count := 0 获取当前节点--
     * 3. 根据(pids)获取下一层<Department>List
     * 4. 递归结束条件(递归执行次数 > 6 or 查询无子节点)
     * 5. 递归调用结束后生成(list_0,list_1,...,list_5)结构体
     *
     * @param pids  (','分隔的字符串)
     * @return
     * @throws RestException
     *
     * 创建人：陈刚
     * 创建时间：2018-07-31
     *
     */
    void findMenuTree(String pids);

    /**
     * 根据已知的菜单List<Menu>-生成树形结构
     * @param menuList
     * @param layer
     */
    void findMenuTreeByList(List<Menu> menuList, Integer layer);
}
