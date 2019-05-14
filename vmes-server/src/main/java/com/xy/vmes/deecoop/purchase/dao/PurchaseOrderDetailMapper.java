package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.PurchaseOrderDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_order_detail:采购订单明细 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2019-03-05
*/
@Mapper
@Repository
public interface PurchaseOrderDetailMapper extends BaseMapper<PurchaseOrderDetail> {


	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-03-05
	*/
    List<PurchaseOrderDetail> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
	List<PurchaseOrderDetail> dataList(PageData pd);

	/**
	* 创建人：刘威 自动创建，禁止修改
	* 创建时间：2019-03-05
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> findDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    List<Map> getDataListPage(PageData pd,Pagination pg);
    List<Map> getDataListPage(PageData pd);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void updateToDisableByIds(String[] ids);

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    void updateByDefined(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    List<Map<String, Object>> findOrderDetaiByCollect(PageData pd);
}


