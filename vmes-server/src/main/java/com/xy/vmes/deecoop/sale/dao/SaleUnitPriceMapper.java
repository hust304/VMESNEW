package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleUnitPrice;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：设置锁库时间 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2018-12-14
*/
@Mapper
@Repository
public interface SaleUnitPriceMapper extends BaseMapper<SaleUnitPrice> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-12-14
	*/
    List<SaleUnitPrice> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
	List<SaleUnitPrice> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-12-14
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    List<Map> getCustomerUnitPriceListPage(PageData pd,Pagination pg);

    List<Map> getCustomerUnitPriceHisListPage(PageData pd,Pagination pg);

}


