package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.PurchasePaymentDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_payment_detail:采购订单付款单明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-05-14
*/
@Mapper
@Repository
public interface PurchasePaymentDetailMapper extends BaseMapper<PurchasePaymentDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    List<PurchasePaymentDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


