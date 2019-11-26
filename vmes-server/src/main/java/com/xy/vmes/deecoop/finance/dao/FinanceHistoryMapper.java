package com.xy.vmes.deecoop.finance.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.FinanceHistory;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_finance_history:历史账单 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2019-11-20
*/
@Mapper
@Repository
public interface FinanceHistoryMapper extends BaseMapper<FinanceHistory> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-11-20
	*/
    List<FinanceHistory> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
	List<FinanceHistory> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-11-20
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    void updateToDisableByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-20
    */
    void updateByDefined(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    void deleteFinanceHistory(PageData pd);
}


