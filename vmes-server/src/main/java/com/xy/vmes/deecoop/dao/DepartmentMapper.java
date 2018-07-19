package com.xy.vmes.deecoop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 Mapper.java
* 创建人：自动创建
* 创建时间：2018-07-18
*/
@Mapper
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Insert("save")
    void save(Department department);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Delete("delete")
    void delete(Department department);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-18
	*/
    @Update("update")
    void update(Department department);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-18
	*/
    @Select("findById")
	Department findById(PageData pd);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-18
	*/
    @Select("datalistPage")
    List<Department> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
	@Select("dataList")
	List<Department> dataList(PageData pd);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-18
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);

}


