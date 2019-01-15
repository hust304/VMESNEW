package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.SaleOrderDetailService;
import com.xy.vmes.service.SaleOrderService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_sale_order_detail:订单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailServiceImp implements SaleOrderDetailService {
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-05
    */
    @Override
    public void save(SaleOrderDetail saleOrderDetail) throws Exception{
        saleOrderDetail.setId(Conv.createUuid());
        saleOrderDetail.setCdate(new Date());
        saleOrderDetail.setUdate(new Date());
        saleOrderDetailMapper.insert(saleOrderDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public SaleOrderDetail selectById(String id) throws Exception{
        return saleOrderDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleOrderDetail> warehouseCheckDetailList =  saleOrderDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void update(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateAll(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleOrderDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleOrderDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleOrderDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleOrderDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> dataList(PageData pd) throws Exception{
        return saleOrderDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleOrderDetailMapper.getDataListPage(pd,pg);
    }

    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<SaleOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderDetail findSaleOrderDetail(PageData object) throws Exception {
        List<SaleOrderDetail> objectList = this.findSaleOrderDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleOrderDetail findSaleOrderDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrderDetail(findMap);
    }

    public List<SaleOrderDetail> findSaleOrderDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleOrderDetail> findSaleOrderDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleOrderDetailList(findMap);
    }

    public List<SaleOrderDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetail detail = (SaleOrderDetail) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetail());
            objectList.add(detail);
        }

        return objectList;
    }
    public List<SaleOrderDetail> mapList2OrderDetailListByEdit(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetail detail = (SaleOrderDetail) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetail());

            //count 订购数量(计价数量)
            BigDecimal count = BigDecimal.valueOf(0D);
            if (detail.getCount() != null) {
                count = detail.getCount();
            }

            //计价转换计量单位 数量转换公式 p2nFormula
            String p2nFormula = mapObject.get("p2nFormula");
            BigDecimal valueBig = BigDecimal.valueOf(0D);
            //P(计价单位) --> N(计量单位)
            if (p2nFormula != null && p2nFormula.trim().length() > 0) {
                Map<String, Object> parmMap = new HashMap<String, Object>();
                parmMap.put("P", count);
                valueBig = EvaluateUtil.formulaReckon(parmMap, p2nFormula);
            }

            //count:订购数量(计价数量)
            detail.setCount(count);

            //productCount:货品数量(计量数量)
            detail.setProductCount(valueBig);

            objectList.add(detail);
        }

        return objectList;
    }

    public String findProductIdsByDetailList(List<SaleOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (SaleOrderDetail object : objectList) {
            String productId = object.getProductId();
            if (productId != null && productId.trim().length() > 0)  {
                strBuf.append(productId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strTemp;
    }

    public SaleDeliverDetail orderDetail2DeliverDetail(SaleOrderDetailEntity orderDetail, SaleDeliverDetail deliverDetail) {
        if (deliverDetail == null) {deliverDetail = new SaleDeliverDetail();}
        if (orderDetail == null) {return deliverDetail;}

        //orderId 订单ID
        deliverDetail.setOrderId(orderDetail.getParentId());
        //orderDetaiId 订单明细ID
        deliverDetail.setOrderDetaiId(orderDetail.getId());
        //productId货品ID
        deliverDetail.setProductId(orderDetail.getProductId());
        //(先计价) (orderUnit,priceUnit) 值相同
        //(后计价) (orderUnit,priceUnit) 值不相同
        //orderUnit订单明细单位id
        deliverDetail.setOrderUnit(orderDetail.getOrderUnit());
        //priceUnit计价单位id
        deliverDetail.setPriceUnit(orderDetail.getPriceUnit());

        deliverDetail.setRemark(orderDetail.getDeliverDtlRemark());

        //productPrice 货品单价
        deliverDetail.setProductPrice(BigDecimal.valueOf(0D));
        if (orderDetail.getProductPrice() != null) {
            deliverDetail.setProductPrice(orderDetail.getProductPrice());
        }
        //count 发货数量(订单明细 计价单位数量)
        deliverDetail.setCount(BigDecimal.valueOf(0D));
        if (orderDetail.getCount() != null) {
            deliverDetail.setCount(orderDetail.getCount());
        }

        //sum 发货金额 := 货品单价 * 发货数量
        //四舍五入到2位小数
        BigDecimal sum = BigDecimal.valueOf(deliverDetail.getProductPrice().doubleValue() * deliverDetail.getCount().doubleValue());
        sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        deliverDetail.setSum(sum);

        return deliverDetail;
    }

    public List<SaleDeliverDetail> orderDtlList2DeliverDtllList(List<SaleOrderDetailEntity> orderDtlList, List<SaleDeliverDetail> deliverDtlList) {
        if (deliverDtlList == null) {deliverDtlList = new ArrayList<SaleDeliverDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return deliverDtlList;}

        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            SaleDeliverDetail deliverDtl = this.orderDetail2DeliverDetail(orderDtl, null);
            deliverDtlList.add(deliverDtl);
        }

        return deliverDtlList;
    }

    public WarehouseOutDetail orderDetail2OutDetail(SaleOrderDetailEntity orderDetail, WarehouseOutDetail outDetail) {
        if (outDetail == null) {outDetail = new WarehouseOutDetail();}
        if (orderDetail == null) {return outDetail;}

        //productId 产品ID
        outDetail.setProductId(orderDetail.getProductId());
        //count 出库数量 (订单明细 计量单位数量)
        outDetail.setCount(orderDetail.getProductCount());
        //businessId 业务id(订单明细id)
        outDetail.setBusinessId(orderDetail.getId());

        return outDetail;
    }

    public List<WarehouseOutDetail> orderDtlList2OutDtlList(List<SaleOrderDetailEntity> orderDtlList, List<WarehouseOutDetail> outDtlList) {
        if (outDtlList == null) {outDtlList = new ArrayList<WarehouseOutDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return outDtlList;}

        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            WarehouseOutDetail outDetail = this.orderDetail2OutDetail(orderDtl, null);
            outDtlList.add(outDetail);
        }

        return outDtlList;
    }

    public SaleInvoiceDetail orderDetail2InvoiceDetail(SaleOrderDetail orderDetail, SaleInvoiceDetail invoiceDetail) {
        if (invoiceDetail == null) {invoiceDetail = new SaleInvoiceDetail();}
        if (orderDetail == null) {return invoiceDetail;}

        invoiceDetail.setOrderDetaiId(orderDetail.getId());
        invoiceDetail.setProductId(orderDetail.getProductId());
        invoiceDetail.setPriceUnit(orderDetail.getPriceUnit());

        //productPrice 货品单价
        invoiceDetail.setProductPrice(BigDecimal.valueOf(0D));
        if (orderDetail.getProductPrice() != null) {
            invoiceDetail.setProductPrice(orderDetail.getProductPrice());
        }
        //count 开票数量
        invoiceDetail.setCount(BigDecimal.valueOf(0D));
        if (orderDetail.getCount() != null) {
            invoiceDetail.setCount(orderDetail.getCount());
        }
        //sum 发票金额 := 货品单价 * 开票数量
        //四舍五入到2位小数
        BigDecimal sum = BigDecimal.valueOf(invoiceDetail.getProductPrice().doubleValue() * invoiceDetail.getCount().doubleValue());
        sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        invoiceDetail.setSum(sum);

        return invoiceDetail;
    }
    public List<SaleInvoiceDetail> orderDtlList2InvoiceDtlList(List<SaleOrderDetail> orderDtlList, List<SaleInvoiceDetail> invoiceDtlList) {
        if (invoiceDtlList == null) {invoiceDtlList = new ArrayList<SaleInvoiceDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return invoiceDtlList;}

        for (SaleOrderDetail orderDtl : orderDtlList) {
            SaleInvoiceDetail invoiceDetail = this.orderDetail2InvoiceDetail(orderDtl, null);
            invoiceDtlList.add(invoiceDetail);
        }

        return invoiceDtlList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addSaleOrderDetail(SaleOrder parentObj, List<SaleOrderDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (SaleOrderDetail detail : objectList) {
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            this.save(detail);
        }
    }

    public void updateStateByDetail(PageData pd) throws Exception {
        saleOrderDetailMapper.updateStateByDetail(pd);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleOrderDetailMapper.updateStateByDetail(pageData);
    }

    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     *
     * @param parent       订单对象
     * @param dtlList      订单明细List<SaleOrderDetail>
     */
    public void updateParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtlList) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findSaleOrderDetailListByParentId(parent.getId());
        }

        if (dtlList.size() == 0) {
            saleOrderService.deleteById(parent.getId());
        } else {
            //获取订单状态-根据订单明细状态
            String parentState = this.findParentStateByDetailList(dtlList);
            parent.setState(parentState);
            saleOrderService.update(parent);
        }
    }

    public BigDecimal findTotalSumByDetailList(List<SaleOrderDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleOrderDetail detail : objectList) {
            //订购数量(计价数量)
            double count_double = 0D;
            if (detail.getCount() != null) {
                count_double = detail.getCount().doubleValue();
            }

            //货品单价
            double productPrice_double = 0D;
            if (detail.getProductPrice() != null) {
                productPrice_double = detail.getProductPrice().doubleValue();
            }

            //货品金额(货品金额:=订购数量 * 货品单价)
            BigDecimal productSum = BigDecimal.valueOf(count_double * productPrice_double);
            //四舍五入到2位小数
            productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setProductSum(productSum);

            totalSum_double = totalSum_double + (count_double * productPrice_double);
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
     *   true : 全部相同，在订单明细List
     *   false: 一条或多条不同，在订单明细List
     *
     * @param state       明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     * @param objectList  订单明细List<SaleOrderDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, List<SaleOrderDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        for (SaleOrderDetail detail : objectList) {
            String dtl_state = detail.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if (!state.trim().equals(dtl_state.trim())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取订单状态-根据订单明细状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     *
     * @param dtlList      订单明细List<SaleOrderDetail>
     * @return
     */
    public String findParentStateByDetailList(List<SaleOrderDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证订单状态(3:已发货) --> 全部明细状态 (5:已发货) -- 忽视状态(-1:已取消)
        String checkDtlState = "5";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "3";
        }

        //2. 验证订单状态(4:已完成) --> 全部明细状态 (6:已完成) -- 忽视状态(-1:已取消)
        checkDtlState = "6";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "4";
        }

        //3. 验证订单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "-1";
        }

        return parentState;
    }
}



