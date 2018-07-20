package com.xy.vmes.deecoop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Insert("save")
    void save(User user);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Delete("delete")
    void delete(User user);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-20
	*/
    @Update("update")
    void update(User user);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-20
	*/
    @Select("findById")
	User findById(PageData pd);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-20
	*/
    @Select("datalistPage")
    List<User> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
	@Select("dataList")
	List<User> dataList(PageData pd);

	/**
	* 创建人：自动创建
	* 创建时间：2018-07-20
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

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


