package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Template;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_template:标准开发模板 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2018-08-23
*/
@Mapper
@Repository
public interface TemplateMapper extends BaseMapper<Template> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-08-23
	*/
    @Select("datalistPage")
    List<Template> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
	@Select("dataList")
	List<Template> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-08-23
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("getColumnList")
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("getDataList")
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("getDataListPage")
    List<Map> getDataListPage(PageData pd,Pagination pg);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Select("updateToDisableByIds")
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


