package com.xy.vmes.deecoop.base.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Product;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_product:产品表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-09-21
*/
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-09-21
	*/
    @Select("datalistPage")
    List<Product> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
	@Select("dataList")
	List<Product> dataList(PageData pd);

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-09-21
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Select("getColumnList")
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Select("getDataListPage")
    List<Map> getDataListPage(PageData pd,Pagination pg);


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Select("updateToDisableByIds")
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


