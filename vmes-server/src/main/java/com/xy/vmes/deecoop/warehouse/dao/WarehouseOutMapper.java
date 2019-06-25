package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseOut;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：出库 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2018-10-22
*/
@Mapper
@Repository
public interface WarehouseOutMapper extends BaseMapper<WarehouseOut> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-10-22
	*/
    List<WarehouseOut> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
	List<WarehouseOut> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2018-10-22
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    List<Map> getDataListPage(PageData pd,Pagination pg);
    List<Map> getDataListPage(PageData pd);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTable(PageData pageData);
    void deleteTableByDetail(PageData pageData);
    void deleteTableByExecute(PageData pageData);
    void deleteTableByExecutor(PageData pageData);
    void deleteTableByRecommend(PageData pageData);
    void updateStateByOut(PageData pageData);
}


