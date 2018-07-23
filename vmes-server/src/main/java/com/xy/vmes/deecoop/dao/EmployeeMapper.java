package com.xy.vmes.deecoop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Employee;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 Mapper.java
* 创建人：自动创建
* 创建时间：2018-07-20
*/
@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {



	/**
	* 创建人：自动创建
	* 创建时间：2018-07-20
	*/
    @Select("datalistPage")
    List<Employee> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
	@Select("dataList")
	List<Employee> dataList(PageData pd);


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);
}


