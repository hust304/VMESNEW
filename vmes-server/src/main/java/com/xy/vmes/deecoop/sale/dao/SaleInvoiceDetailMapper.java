package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleInvoiceDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_invoice_detail:发票明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-01-08
*/
@Mapper
@Repository
public interface SaleInvoiceDetailMapper extends BaseMapper<SaleInvoiceDetail> {

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2019-01-08
	*/
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<SaleInvoiceDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    List<Map> getDataListPage(PageData pd,Pagination pg);
    List<Map> getDataListPage(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2019-01-08
     */
    void updateStateByDetail(PageData pd);

}


