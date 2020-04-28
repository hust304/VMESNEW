package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.AssistPlanDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_plan_detail:外协订单明细 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2020-04-25
*/
@Mapper
@Repository
public interface AssistPlanDetailMapper extends BaseMapper<AssistPlanDetail> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2020-04-25
	*/
    List<AssistPlanDetail> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
	List<AssistPlanDetail> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2020-04-25
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateToDisableByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    void updateByDefined(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


