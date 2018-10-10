package com.xy.vmes.deecoop.base.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Bom;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：操作日志 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2018-09-29
*/
@Mapper
@Repository
public interface BomMapper extends BaseMapper<Bom> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-09-29
	*/
    @Select("datalistPage")
    List<Bom> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
	@Select("dataList")
	List<Bom> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-09-29
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("getColumnList")
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("getDataList")
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("getDataListPage")
    List<Map> getDataListPage(PageData pd,Pagination pg);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Select("updateToDisableByIds")
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Select("updateToNotDefaultByPorId")
    void updateToNotDefaultByPorId(String prodId);
}


