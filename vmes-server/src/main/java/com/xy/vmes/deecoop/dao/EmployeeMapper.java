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
* 说明：vmes_employee:员工表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-07-23
*/
@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-23
	*/
    @Select("datalistPage")
    List<Employee> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
	@Select("dataList")
	List<Employee> dataList(PageData pd);

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
}


