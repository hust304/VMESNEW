package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.MenuButton;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_menu_button:菜单按钮表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-08-03
*/
@Mapper
@Repository
public interface MenuButtonMapper extends BaseMapper<MenuButton> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-08-03
	*/
    @Select("datalistPage")
    List<MenuButton> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
	@Select("dataList")
	List<MenuButton> dataList(PageData pd);

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-08-03
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("getColumnList")
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("getDataList")
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("getDataListPage")
    List<Map> getDataListPage(PageData pd, Pagination pg);


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Select("updateToDisableByIds")
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    @Select("deleteMenuButtonByMenuId")
    void deleteMenuButtonByMenuId(String menuId);

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    @Select("updateDisableByMenuId")
    void updateDisableByMenuId(String menuId);
}


