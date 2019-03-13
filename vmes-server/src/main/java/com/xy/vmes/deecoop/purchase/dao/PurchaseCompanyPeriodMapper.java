package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_company_period:采购企业付款期设定 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-03-12
*/
@Mapper
@Repository
public interface PurchaseCompanyPeriodMapper extends BaseMapper<PurchaseCompanyPeriod> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    void updateToDisableByIds(String[] ids);


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchaseCompanyPeriod> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
}


