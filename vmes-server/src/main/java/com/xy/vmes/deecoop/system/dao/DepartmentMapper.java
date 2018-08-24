package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.TreeEntity;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_department:系统部门表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-07-23
*/
@Mapper
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-23
	*/
    @Select("datalistPage")
    List<Department> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
	@Select("dataList")
	List<Department> dataList(PageData pd);

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-23
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
	/**
	 * 创建人：陈刚
	 * 创建时间：2018-08-08
	 */
	@Select("getColumnList")
	List<LinkedHashMap<String, String>> getColumnList();

	/**
	 * 创建人：陈刚
	 * 创建时间：2018-08-08
	 */
	@Select("getDataListPage")
	List<Map<String, Object>> getDataListPage(PageData pd, Pagination pg);

    /**
	 * 批量修改组织架构信息为禁用状态
	 *
	 * 创建人：陈刚
	 * 创建时间：2018-07-27
	 */
	@Select("updateDisableByIds")
	void updateDisableByIds(String[] ids);



	/**
	 * 创建人：刘威
	 * 创建时间：2018-08-01
	 */
	@Select("getTreeList")
	List<TreeEntity> getTreeList(PageData pd);

}


