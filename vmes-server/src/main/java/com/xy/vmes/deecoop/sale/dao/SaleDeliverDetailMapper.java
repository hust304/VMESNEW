package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_deliver_detail:发货明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Mapper
@Repository
public interface SaleDeliverDetailMapper extends BaseMapper<SaleDeliverDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByDetail(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<SaleDeliverDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

    ///////////////////////////////////////////////////////////////////////////
    /**
     * 发货单明细与出库单明细
     *
     * @param pd
     * @return
     */
    List<Map<String, Object>> findDeliverDetailByOutDetail(PageData pd);

    /**
     * 发货单取消
     * 清除订单明细与发货明细的关联关系(vmes_sale_order_detail.deliver_detail_id)
     *
     * @param pd
     */
    void updateOrderDetailByCancelDeliver(PageData pd);
}


