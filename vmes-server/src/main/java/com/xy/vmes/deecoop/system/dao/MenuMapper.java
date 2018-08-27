package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Menu;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_menu:系统功能菜单 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-07-31
*/
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-31
	*/
    @Select("datalistPage")
    List<Menu> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
	@Select("dataList")
	List<Menu> dataList(PageData pd);

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-31
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
	/**
	 * 批量修改菜单信息为禁用状态
	 *
	 * 创建人：陈刚
	 * 创建时间：2018-07-31
	 */
	@Select("updateDisableByIds")
	void updateDisableByIds(String[] ids);

	/**
	 * 创建人：陈刚
	 * 创建时间：2018-07-30
	 */
	@Select("getColumnList")
	List<LinkedHashMap> getColumnList();
	/**
	 * 创建人：陈刚
	 * 创建时间：2018-07-30
	 */
	@Select("getDataListPage")
	List<Map> getDataListPage(PageData pd, Pagination pg);
}


