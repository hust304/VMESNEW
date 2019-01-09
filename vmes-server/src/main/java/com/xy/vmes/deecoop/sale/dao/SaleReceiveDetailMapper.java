package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：收款明细 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2019-01-08
*/
@Mapper
@Repository
public interface SaleReceiveDetailMapper extends BaseMapper<SaleReceiveDetail> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-01-08
	*/
    List<SaleReceiveDetail> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
	List<SaleReceiveDetail> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-01-08
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    List<Map> getDataListPage(PageData pd,Pagination pg);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


