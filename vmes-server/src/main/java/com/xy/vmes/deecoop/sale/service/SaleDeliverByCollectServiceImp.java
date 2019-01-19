package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.deecoop.sale.dao.SaleDeliverByCollectMapper;
import com.xy.vmes.service.SaleDeliverByCollectService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 说明：发货明细汇总 Service 实现类
 * 创建人：陈刚
 * 创建时间：2019-01-18
 */
@Service
@Transactional(readOnly = false)
public class SaleDeliverByCollectServiceImp implements SaleDeliverByCollectService {
    @Autowired
    private SaleDeliverByCollectMapper saleDeliverByCollectMapper;

    /**
     * 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
     * 获取发货出库订单(订单明细id,订购数量,出库数量)
     *
     * @param pageData
     *     orderDetailId:订单明细id
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> findDeliverDetailOnWarehouseOutDetailByOrder(PageData pageData) throws Exception {
        List<Map<String, Object>> mapList = saleDeliverByCollectMapper.findDeliverDetailOnWarehouseOutDetailByOrder(pageData);
        if (mapList != null && mapList.size() > 0) { return mapList.get(0);}

        return null;
    }

}
