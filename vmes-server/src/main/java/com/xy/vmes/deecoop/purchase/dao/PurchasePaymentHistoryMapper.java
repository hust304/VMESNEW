package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.PurchasePaymentHistory;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_payment_history:供应商账期汇总 Mapper.java
 * 创建人：陈刚 自动创建
 * 创建时间：2019-03-11
 */
@Mapper
@Repository
public interface PurchasePaymentHistoryMapper extends BaseMapper<PurchasePaymentHistory> {

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
    void deleteTableByCompanyId(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<PurchasePaymentHistory> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    List<Map> findListPurchasePaymentHistoryByPaymentPeriod(PageData pd, Pagination pg);
}


