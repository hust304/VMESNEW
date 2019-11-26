package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


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
    @Autowired
    private SaleOrderByChangeService saleOrderByChangeService;

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverDetailByCollectService saleDeliverDetailByCollectService;

    @Autowired
    private SaleReceiveService saleReceiveService;
    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;
    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private WarehouseOutDetailExecuteService outDetailExecuteService;
    @Autowired
    private WarehouseOutService outService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ColumnService columnService;

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
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrderDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrderDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
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

            if(mapObject.get("orderDetaiId")!=null){
                detail.setId(mapObject.get("orderDetaiId"));
            }

            //orderCount 订单订购数量 := 货品数量(计价数量)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            //orderCount:订购数量(计价数量)
            detail.setOrderCount(orderCount);
            //priceCount 货品数量(计价数量)
            detail.setPriceCount(orderCount);

            //计价转换计量单位 数量转换公式 p2nFormula
            String p2nFormula = mapObject.get("p2nFormula");
            //P(计价单位) --> N(计量单位)
            BigDecimal valueBig = EvaluateUtil.countFormulaP2N(orderCount, p2nFormula);

            String p2nIsScale = new String();
            if (mapObject.get("p2nIsScale") != null) {
                p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
            }

            //小数位数 (最小:0位 最大:4位)
            Integer p2nDecimalCount = Integer.valueOf(2);
            String p2nDecimalCountStr = mapObject.get("p2nDecimalCount");
            if (p2nDecimalCountStr != null) {
                try {
                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            valueBig = StringUtil.scaleDecimal(valueBig, p2nIsScale, p2nDecimalCount);

            //productCount:货品数量(计量数量)
            detail.setProductCount(valueBig);

            objectList.add(detail);
        }

        return objectList;
    }

//    public String findProductIdsByDetailList(List<SaleOrderDetail> objectList) {
//        if (objectList == null || objectList.size() == 0) {return new String();}
//
//        StringBuffer strBuf = new StringBuffer();
//        for (SaleOrderDetail object : objectList) {
//            String productId = object.getProductId();
//            if (productId != null && productId.trim().length() > 0)  {
//                strBuf.append(productId.trim());
//                strBuf.append(",");
//            }
//        }
//
//        String strTemp = strBuf.toString();
//        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
//            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
//            return strTemp;
//        }
//
//        return strTemp;
//    }

//    public String findDetailIdsByDetailList(List<SaleOrderDetail> objectList) {
//        if (objectList == null || objectList.size() == 0) {return new String();}
//
//        StringBuffer strBuf = new StringBuffer();
//        for (SaleOrderDetail object : objectList) {
//            String detailId = object.getProductId();
//            if (detailId != null && detailId.trim().length() > 0)  {
//                strBuf.append(detailId.trim());
//                strBuf.append(",");
//            }
//        }
//
//        String strTemp = strBuf.toString();
//        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
//            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
//            return strTemp;
//        }
//
//        return strTemp;
//    }

//    public String findOrderIdsByDetailList(List<SaleOrderDetail> objectList) {
//        if (objectList == null || objectList.size() == 0) {return new String();}
//
//        Map<String, String> orderIdMap = new HashMap<String, String>();
//        for (SaleOrderDetail object : objectList) {
//            String orderId = object.getParentId();
//            orderIdMap.put(orderId, orderId);
//        }
//
//        StringBuffer strBuf = new StringBuffer();
//        for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext();) {
//            String orderId = (String) iterator.next();
//            if (orderId != null && orderId.trim().length() > 0)  {
//                strBuf.append(orderId.trim());
//                strBuf.append(",");
//            }
//        }
//
//        String strTemp = strBuf.toString();
//        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
//            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
//            return strTemp;
//        }
//
//        return strTemp;
//    }

    public SaleDeliverDetail orderDetail2DeliverDetail(SaleOrderDetailEntity orderDetail, SaleDeliverDetail deliverDetail) {
        if (deliverDetail == null) {deliverDetail = new SaleDeliverDetail();}
        if (orderDetail == null) {return deliverDetail;}

        //orderId 订单ID
        deliverDetail.setOrderId(orderDetail.getParentId());
        //orderDetaiId 订单明细ID
        deliverDetail.setOrderDetaiId(orderDetail.getId());
        //productId货品ID
        deliverDetail.setProductId(orderDetail.getProductId());
        //orderUnit订单明细单位id
        deliverDetail.setOrderUnit(orderDetail.getOrderUnit());

        //orderCount 发货数量(订单单位) <-- orderDtlDeliverCount
        deliverDetail.setOrderCount(BigDecimal.valueOf(0D));
        if (orderDetail.getOrderDtlDeliverCount() != null) {
            deliverDetail.setOrderCount(orderDetail.getOrderDtlDeliverCount());
        }

        //priceUnit计价单位id
        deliverDetail.setPriceUnit(orderDetail.getPriceUnit());

        deliverDetail.setRemark(orderDetail.getDeliverDtlRemark());

        //productPrice 货品单价
        deliverDetail.setProductPrice(BigDecimal.valueOf(0D));
        if (orderDetail.getProductPrice() != null) {
            deliverDetail.setProductPrice(orderDetail.getProductPrice());
        }
        //priceCount 货品数量(计价数量) --> 本次发货数量(计价单位)
        deliverDetail.setPriceCount(BigDecimal.valueOf(0D));
        if (orderDetail.getPriceCount() != null) {
            deliverDetail.setPriceCount(orderDetail.getPriceCount());
        }

        //sum 发货金额 := 货品单价 * 发货数量
        //四舍五入到2位小数
        BigDecimal sum = BigDecimal.valueOf(deliverDetail.getProductPrice().doubleValue() * deliverDetail.getPriceCount().doubleValue());
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

//    public List<WarehouseOutDetail> orderDtlList2OutDtlList(List<SaleOrderDetailEntity> orderDtlList, List<WarehouseOutDetail> outDtlList) {
//        if (outDtlList == null) {outDtlList = new ArrayList<WarehouseOutDetail>();}
//        if (orderDtlList == null || orderDtlList.size() == 0) {return outDtlList;}
//
//        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
//            WarehouseOutDetail outDetail = this.orderDetail2OutDetail(orderDtl, null);
//            outDtlList.add(outDetail);
//        }
//
//        return outDtlList;
//    }

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
        //count 开票数量 <-- orderCount
        invoiceDetail.setCount(BigDecimal.valueOf(0D));
        if (orderDetail.getOrderCount() != null) {
            invoiceDetail.setCount(orderDetail.getOrderCount());
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
//    public void addSaleOrderDetail(SaleOrder parentObj, List<SaleOrderDetail> objectList) throws Exception {
//        if (parentObj == null) {return;}
//        if (objectList == null || objectList.size() == 0) {return;}
//
//        for (SaleOrderDetail detail : objectList) {
//            detail.setState("0");
//            detail.setParentId(parentObj.getId());
//            detail.setCuser(parentObj.getCuser());
//
//            //计价类型(1:先计价 2:后计价)
//            if (parentObj.getPriceType() != null && "2".equals(parentObj.getPriceType().trim())) {
//                //计价单位id
//                detail.setPriceUnit(null);
//                //货品数量(计价数量)
//                detail.setPriceCount(BigDecimal.valueOf(0D));
//                //货品单价
//                detail.setProductPrice(BigDecimal.valueOf(0D));
//                //货品金额(订购数量 * 货品单价)
//                detail.setProductSum(BigDecimal.valueOf(0D));
//            }
//
//            this.save(detail);
//        }
//    }

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
     * 修改订单明细状态
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     *
     * 1. 根据订单id-获取订单明细List-(vmes_sale_order_detail)
     * 2. 根据订单id-获取发货明细(当前订单id)-(vmes_sale_deliver_detail)
     * 3. 2:待生产: 可发货数量 is null or 可发货数量 == 0
     * 4. 3:待出库: 可发货数量 > 0 and 无未完成的发货明细
     * 5. 4:待发货: 可发货数量 > 0 and 存在
     *
     * @param orderId
     * @param orderDetailList
     * @throws Exception
     */
    public void updateDetailStateByOrderId(String orderId, List<SaleOrderDetail> orderDetailList) throws Exception {
        if (orderId == null || orderId.trim().length() == 0) {return;}
        if (orderDetailList == null) {
            //根据订单id-获取订单明细List
            orderDetailList = this.findSaleOrderDetailListByParentId(orderId);
        }
        if (orderDetailList == null || orderDetailList.size() == 0) {return;}

//        //根据订单id-获取发货明细(当前订单id)
//        PageData findMap = new PageData();
//        findMap.put("orderId", orderId);
//        //发货状态(0:待发货 1:已发货 -1:已取消)
//        findMap.put("queryStr", "state in ('0') ");
//        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailList(findMap);
//
//        //遍历发货明细List
//        Map<String, String> orderDetailIdByDeliver_map = new HashMap<String, String>();
//        if (deliverDtlList != null && deliverDtlList.size() > 0) {
//            for (SaleDeliverDetail detail : deliverDtlList) {
//                String orderDetaiId = detail.getOrderDetaiId();
//                if (orderDetaiId != null && orderDetaiId.trim().length() > 0) {
//                    orderDetailIdByDeliver_map.put(orderDetaiId, orderDetaiId);
//                }
//            }
//        }

        //遍历订单明细List
        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        for (SaleOrderDetail detail : orderDetailList) {
            if ("5".equals(detail.getState()) || "-1".equals(detail.getState())) {continue;}
            String orderDtl_id = detail.getId();

            SaleOrderDetail orderDtlDB = new SaleOrderDetail();
            orderDtlDB.setId(orderDtl_id);

//            //needDeliverCount 可发货数量(计价单位)
//            BigDecimal needDeliverCount = detail.getNeedDeliverCount();
//
//            if (needDeliverCount == null || needDeliverCount.doubleValue() == 0) {
//                //2:待生产
//                orderDtlDB.setState("2");
//            } else if (needDeliverCount != null && needDeliverCount.doubleValue() > 0
//                && orderDetailIdByDeliver_map.get(orderDtl_id) == null
//            ) {
//                //3:待出库
//                orderDtlDB.setState("3");
//            } else if (needDeliverCount != null && needDeliverCount.doubleValue() > 0
//                && orderDetailIdByDeliver_map.get(orderDtl_id) != null
//            ) {
//                //4:待发货
//                orderDtlDB.setState("4");
//            }
//
//            //是否锁定仓库(0:未锁定 1:已锁定)
//            if (detail.getNeedDeliverCount() == null || detail.getNeedDeliverCount().doubleValue() == 0) {
//                orderDtlDB.setIsLockWarehouse("0");
//            } else if (detail.getNeedDeliverCount() != null && detail.getNeedDeliverCount().doubleValue() > 0) {
//                orderDtlDB.setIsLockWarehouse("1");
//            }

            orderDtlDB.setState("3");
            this.update(orderDtlDB);
        }
    }

//    public void updateLockCount(PageData pd) throws Exception {
//        saleOrderDetailMapper.updateLockCount(pd);
//    }

    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
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
            String parentState = this.findParentStateByDetail(dtlList);
            parent.setState(parentState);

            //订单状态:3:已发货 设定发货日期
            if ("3".equals(parentState)) {
                parent.setDeliverDate(new Date());
            }

            saleOrderService.update(parent);
        }
    }

    public BigDecimal findTotalSumByDetailList(List<SaleOrderDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleOrderDetail detail : objectList) {
            //订购数量(计价数量)
            double count_double = 0D;
            if (detail.getOrderCount() != null) {
                count_double = detail.getOrderCount().doubleValue();
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

    public BigDecimal findTotalSumByPrice(List<SaleOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        double totalSum_double = 0D;
        for (SaleOrderDetail detail : objectList) {

            //productSum 货品金额(订购数量 * 货品单价)
            double productSum_double = 0D;
            if (detail.getProductSum() != null) {
                productSum_double = detail.getProductSum().doubleValue();
            }

            totalSum_double = totalSum_double + productSum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //退货单修改(订单明细,订单) 状态
//    public void updateOrderState(Map<String, Map<String, Object>> orderDtlMap,
//                          Map<String, Map<String, BigDecimal>> orderReceiveMap) throws Exception {
//        if (orderDtlMap == null || orderDtlMap.size() == 0) {return;}
//
//        Map<String, String> orderIdMap = new HashMap<String, String>();
//        for (Iterator iterator = orderDtlMap.keySet().iterator(); iterator.hasNext();) {
//            SaleOrderDetail orderDetail = new SaleOrderDetail();
//
//            String orderDtlId = (String) iterator.next();
//            orderDetail.setId(orderDtlId);
//
//            Map<String, Object> orderDtlValueMap = orderDtlMap.get(orderDtlId);
//
//            //orderId 订单id
//            String orderId = (String)orderDtlValueMap.get("orderId");
//            orderIdMap.put(orderId, orderId);
//
//            //订单明细订购数量 orderDtlCount
//            BigDecimal orderDtlCount = BigDecimal.valueOf(0D);
//            if (orderDtlValueMap.get("orderDtlCount") != null) {
//                orderDtlCount = (BigDecimal)orderDtlValueMap.get("orderDtlCount");
//            }
//
////            //订单明细发货数量 orderDtlDeliverCount
////            BigDecimal orderDtlDeliverCount = BigDecimal.valueOf(0D);
////            if (orderDtlValueMap.get("orderDtlDeliverCount") != null) {
////                orderDtlDeliverCount = (BigDecimal)orderDtlValueMap.get("orderDtlDeliverCount");
////            }
//
//            //checkCount 验证数量(发货数量-退货数量)
//            BigDecimal checkCount = BigDecimal.valueOf(0D);
//            if (orderDtlValueMap.get("checkCount") != null) {
//                checkCount = (BigDecimal)orderDtlValueMap.get("checkCount");
//            }
//
//            if (orderDtlCount.doubleValue() <= checkCount.doubleValue()) {
//                //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//                orderDetail.setState("5");
//            }
//
//            this.update(orderDetail);
//        }
//
//        //反写订单状态
//        if (orderIdMap.size() > 0) {
//            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext();) {
//                String orderId = (String)iterator.next();
//                List<SaleOrderDetail> detailList = this.findSaleOrderDetailListByParentId(orderId);
//
//                SaleOrder parent = new SaleOrder();
//                parent.setId(orderId);
//                this.updateParentStateByDetailList(parent, detailList);
//
//                SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
//                //orderSum 订单金额(合计金额 - 折扣金额)
//                BigDecimal orderSum = orderDB.getOrderSum();
//                //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//                if (this.isAllExistStateByDetailList("5", detailList)) {
//                    if (orderReceiveMap.get(orderId) != null) {
//                        Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);
//
//                        //订单id-订单已完成付款金额
//                        BigDecimal receiveSum = BigDecimal.valueOf(0D);
//                        if (receiveMap.get("receiveSum") != null) {
//                            receiveSum = receiveMap.get("receiveSum");
//                        }
//
//                        if (receiveSum.doubleValue() >= orderSum.doubleValue()) {
//                            SaleOrder editOrder = new SaleOrder();
//                            editOrder.setId(orderId);
//                            //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//                            editOrder.setState("4");
//                            saleOrderService.update(editOrder);
//                        }
//                    }
//                }
//            }
//        }
//    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
     *   true : 全部相同，在订单明细List
     *   false: 一条或多条不同，在订单明细List
     *
     * @param state       订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
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

//    /**
//     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
//     *   true : 一条或多条相同，在订单明细List
//     *   false: 全部不同，在订单明细List
//     *
//     * @param state       明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//     * @param objectList  盘点单明细List<SaleOrderDetail>
//     * @return
//     */
//    public boolean isExistStateByDetailList(String state, List<SaleOrderDetail> objectList) {
//        if (state == null || state.trim().length() == 0) {return false;}
//        if (objectList == null || objectList.size() == 0) {return false;}
//
//        for (SaleOrderDetail detail : objectList) {
//            String dtl_state = detail.getState();
//            if (dtl_state != null && state.trim().equals(dtl_state.trim())) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    /**
//     * 获取订单状态-根据订单明细状态
//     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//     *
//     * @param dtlList      订单明细List<SaleOrderDetail>
//     * @return
//     */
//    public String findParentStateByDetailList(List<SaleOrderDetail> dtlList) {
//        String parentState = new String("0");
//        if (dtlList == null || dtlList.size() == 0) {return parentState;}
//
////        //1. 验证订单状态(4:已完成) --> 全部明细状态 (6:已完成) -- 忽视状态(-1:已取消)
////        String checkDtlState = "6";
////        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
////            return "4";
////        }
//
//        //2. 验证订单状态(3:已发货) --> 全部明细状态 (5:已完成) -- 忽视状态(-1:已取消)
//        String checkDtlState = "5";
//        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
//            return "3";
//        }
//
//        //3. 验证订单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
//        checkDtlState = "-1";
//        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
//            return "-1";
//        }
//
//        return parentState;
//    }

//    /**
//     * 获取订单状态-根据订单明细状态
//     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//     *
//     * @param dtlList      订单明细List<SaleOrderDetail>
//     * @return
//     */
//    public SaleOrder findParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtlList) {
//        if (parent == null) {return null;}
//        if (dtlList == null || dtlList.size() == 0) {return null;}
//
////        //1. 验证订单状态(4:已完成) --> 全部明细状态 (6:已完成) -- 忽视状态(-1:已取消)
////        String checkDtlState = "6";
////        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
////            parent.setState("4");
////            return parent;
////        }
//
//        //2. 验证订单状态(3:已发货) --> 全部明细状态 (5:已完成) -- 忽视状态(-1:已取消)
//        String checkDtlState = "5";
//        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
//            parent.setState("3");
//            parent.setDeliverDate(new Date());
//            return parent;
//        }
//
//        //3. 验证订单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
//        checkDtlState = "-1";
//        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
//            parent.setState("-1");
//            return parent;
//        }
//
//        //4. 验证订单状态(2:待发货) -- 明细列表中状态(4:待发货) 一条或多条
//        checkDtlState = "4";
//        if (this.isExistStateByDetailList(checkDtlState, dtlList)) {
//            parent.setState("2");
//            return parent;
//        }
//
//        return parent;
//    }

    /**
     * 获取订单状态-根据订单明细状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:` 5:已完成(发货) -1:已取消)
     *
     * @param dtlList      订单明细List<SaleOrderDetail>
     * @return
     */
    public String findParentStateByDetail(List<SaleOrderDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成(发货) -1:已取消)
        int dtl_dtj = 0;  //0:待提交
        int dtl_dsh = 0;  //1:待审核
        int dtl_dsc = 0;  //2:待生产
        int dtl_dck = 0;  //3:待出库
        int dtl_dfh = 0;  //4:待发货
        int dtl_ywc = 0;  //5:已完成(发货)
        int dtl_yqx = 0;  //-1:已取消
        //由各自业务更改--(0:待提交 1:待审核 2:待生产 3:待出库 )

        //明细变更状态(4:待发货 5:已完成 -1:已取消)
        for (SaleOrderDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dtj = dtl_dtj + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_dsh = dtl_dsh + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_dsc = dtl_dsc + 1;
            } else if ("3".equals(dtlObject.getState())) {
                dtl_dck = dtl_dck + 1;
            } else if ("4".equals(dtlObject.getState())) {
                dtl_dfh = dtl_dfh + 1;
            } else if ("5".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //订单明细状态:-1:已取消 全是已取消状态  订单状态:-1:已取消
        if (dtl_yqx > 0 && dtl_yqx == dtlList.size()) {
            return "-1";

            //订单明细状态:5:已完成(发货) 全是已完成(发货)状态  订单状态:3:已发货
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dtj == 0 && dtl_dsh == 0 && dtl_dsc == 0 && dtl_dck == 0 && dtl_dfh == 0)
        ) {
            return "3";

            //订单明细状态:4:待发货 订单明细中存在(一个或多个)待发货状态 订单状态:2:待发货
            //订单明细状态:2:待生产 订单明细中存在(一个或多个)待生产状态 订单状态:2:待发货
        } else if (dtl_dfh > 0 || dtl_dsc > 0) {
            return "2";
        }

        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public ResultModel listPageSaleOrderDetail(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        Map result = new HashMap();
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);


        //添加订单明细界面使用该参数
        String type = pd.getString("type");
        if ("add".equals(type)) {
            pd.put("queryStr", "1=2");
        }

        //订单明细 ids
        String ids = pd.getString("ids");
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            pd.put("ids", ids);
        }

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        //遍历结果集
        //(计量单位)(库存数量,库存可用数量) 单位换算公式(n2pFormula) (计价单位)(库存数量,库存可用数量)
        for (Map mapObject : varMapList) {
            //n2pFormula (计量单位转换计价单位公式)
            String n2pFormula = (String)mapObject.get("n2pFormula");

            //stockCount (计量单位)库存数量
            BigDecimal stockCount = BigDecimal.valueOf(0D);
            String stockCount_str = (String)mapObject.get("stockCount");
            if (stockCount_str != null && stockCount_str.trim().length() > 0) {
                try {
                    stockCount = new BigDecimal(stockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //stockCountByPrice        (计价单位)库存数量
            BigDecimal valueBig = EvaluateUtil.countFormulaN2P(stockCount, n2pFormula);
            mapObject.put("stockCountByPrice", valueBig);

            //productStockCount (计量单位)库存可用数量
            BigDecimal productStockCount = BigDecimal.valueOf(0D);
            String productStockCount_str = (String)mapObject.get("productStockCount");
            if (productStockCount_str != null && productStockCount_str.trim().length() > 0) {
                try {
                    productStockCount = new BigDecimal(productStockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //productStockCountByPrice (计价单位)库存可用数量
            valueBig = EvaluateUtil.countFormulaN2P(productStockCount, n2pFormula);
            mapObject.put("productStockCountByPrice", valueBig);

            //lockCount:锁定货品数量(计量单位)
            BigDecimal lockCount = BigDecimal.valueOf(0D);
            String lockCount_str = (String)mapObject.get("lockCount");
            if (lockCount_str != null && lockCount_str.trim().length() > 0) {
                try {
                    lockCount = new BigDecimal(lockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            mapObject.put("lockCountN2P", "0.00");
            if (n2pFormula != null && lockCount != null) {
                valueBig = EvaluateUtil.countFormulaN2P(lockCount, n2pFormula);
                mapObject.put("lockCountN2P", valueBig);
            }
        }

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel cancelSaleOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        SaleOrderDetail detail = this.findSaleOrderDetailById(detailId);
        //明细状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (detail.getState() != null && "1,2,3,4,5".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前订单明细不可取消，该订单明细状态(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }

        SaleOrder order = saleOrderService.findSaleOrderById(detail.getParentId());
        //订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (order != null && order.getState() != null && "1,2,3,4,5".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该订单已经(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }

        //1. 修改明细状态
        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        detail.setState("-1");
        this.update(detail);

        //2.返写订单状态
        //获取订单状态-根据订单明细状态 -- 忽视状态(-1:已取消)
        if (order != null) {
            this.updateParentStateByDetailList(order, null);
        }

        return model;
    }

    @Override
    public ResultModel deleteSaleOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        SaleOrderDetail detail = this.findSaleOrderDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        //订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (checkState != null && "1,2,3,4,5".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该订单明细状态(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }


        //1. 删除入库明细
        this.deleteById(detailId);

        //2.返写订单状态
        //获取订单状态-根据订单明细状态 -- 忽视状态(-1:已取消)
        SaleOrder order = saleOrderService.findSaleOrderById(detail.getParentId());
        if (order != null) {
            this.updateParentStateByDetailList(order, null);
        }

        return model;
    }

    public ResultModel rebackSaleOrderDetailByLockCount(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String detail_id = pageData.getString("id");
        if (detail_id == null || detail_id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        //产品锁定库存数量
        String productLockCount_str = pageData.getString("productLockCount");
        BigDecimal productLockCount = BigDecimal.valueOf(0D);
        if (productLockCount_str != null && productLockCount_str.trim().length() > 0) {
            try {
                productLockCount = new BigDecimal(productLockCount_str);
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String lockCount_str = pageData.getString("lockCount");
        BigDecimal lockCount = BigDecimal.valueOf(0D);
        if (lockCount_str != null && lockCount_str.trim().length() > 0) {
            try {
                lockCount = new BigDecimal(lockCount_str);
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //1. 修改产品锁定库存数量
        Product product = new Product();
        product.setId(productId);

        BigDecimal lockCount_product = BigDecimal.valueOf(productLockCount.doubleValue() - lockCount.doubleValue());
        //四舍五入到2位小数
        lockCount_product = lockCount_product.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        product.setLockCount(lockCount_product);
        productService.update(product);

        //2. 修改订单明细产品锁定库存数量
        SaleOrderDetail orderDetail = new SaleOrderDetail();
        orderDetail.setId(detail_id);
        orderDetail.setNeedDeliverCount(BigDecimal.valueOf(0D));
        orderDetail.setLockCount(BigDecimal.valueOf(0D));
        //是否锁定仓库(0:未锁定 1:已锁定)
        orderDetail.setIsLockWarehouse("0");
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        //'2':待生产: 可发货数量 is null or 可发货数量 == 0
//        orderDetail.setState("2");
        this.update(orderDetail);

        return model;
    }

    public ResultModel changeSaleOrderByDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        String orderDtlId = pageData.getString("orderDtlId");
        if (orderDtlId == null || orderDtlId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细为空！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //单位换算(变更后订购数量)--货品数量:转换计量单位数量
        List<SaleOrderDetailEntity> orderDtlEntityList = saleOrderByChangeService.orderChangeMapList2OrderDtlList(mapList, null);
        if (orderDtlEntityList == null || orderDtlEntityList.size() == 0 || orderDtlEntityList.get(0) == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成订单明细实体类SaleOrderDetailEntity错误！");
            return model;
        }

        //修改订单明细(订单明细订购金额, 订单明细货品数量)
        //2:待生产
        saleOrderByChangeService.orderChangeByReadyProduce(orderDtlEntityList);
        //3:待出库
        saleOrderByChangeService.orderChangeByReadyOut(orderDtlEntityList, companyId);
        //4:待发货
        saleOrderByChangeService.orderChangeByReadyDeliver(orderDtlEntityList, companyId);

        //根据订单明细id 查询(vmes_warehouse_out_detail) 获取出库单明细id
        PageData findMap = new PageData();
        findMap.put("orderDtlId", orderDtlId);
        //发货状态(0:待发货 1:已发货 -1:已取消)
        findMap.put("state", "0");
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailList(findMap);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //取消发货单
        if (deliverDtlList != null && deliverDtlList.size() > 0) {
            //发货单明细id
            Map<String, String> deliverMap = new LinkedHashMap<String, String>();
            //发货单id
            Map<String, String> deliverDtlMap = new LinkedHashMap<String, String>();
            for (SaleDeliverDetail deliverDtl : deliverDtlList) {
                String detailId = deliverDtl.getId();
                deliverDtlMap.put(detailId, detailId);

                String parentId = deliverDtl.getParentId();
                deliverMap.put(parentId, parentId);

//                String inDetailId = deliverDtl.getInDetailId();
//                if (inDetailId != null && inDetailId.trim().length() > 0
//                    && detailId != null && detailId.trim().length() > 0
//                    && parentId != null && parentId.trim().length() > 0
//                ) {
//                    deliverDtlMap.put(detailId, detailId);
//                    deliverMap.put(parentId, parentId);
//                }
            }

            //取消发货单明细
            for (Iterator iterator = deliverDtlMap.keySet().iterator(); iterator.hasNext();) {
                String detailId = iterator.next().toString().trim();

                SaleDeliverDetail editDeliverDtl = new SaleDeliverDetail();
                editDeliverDtl.setId(detailId);
                //发货明细状态(0:待发货 1:已发货 -1:已取消)
                editDeliverDtl.setState("-1");
                saleDeliverDetailService.update(editDeliverDtl);
            }

            //取消发货单
            for (Iterator iterator = deliverMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = iterator.next().toString().trim();

                //获取发货单状态
                String parentState = null;
                List<SaleDeliverDetail> detailList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(parentId);
                if (detailList != null && detailList.size() > 0) {
                    parentState = saleDeliverDetailService.findParentStateByDetailList(detailList);
                }

                if (parentState != null) {
                    SaleDeliver editDeliver = new SaleDeliver();
                    editDeliver.setId(parentId);
                    //发货状态(0:待发货 1:已发货 -1:已取消)
                    editDeliver.setState(parentState);
                    saleDeliverService.update(editDeliver);
                }
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改订单
        SaleOrder saleOrder = saleOrderService.findSaleOrderById(orderId);

        String customerId = new String();
        if (saleOrder != null && saleOrder.getCustomerId() != null) {
            customerId = saleOrder.getCustomerId().trim();
        }

        //修改订单明细状态(订单明细货品数量 与 订单明细已发货数量 比较)
        //按订单id-获取<订单明细id, 发货信息Map> - (orderDtlCount:订单明细订购数量, checkCount: 验证数量(发货数量-退货数量))

        // <订单明细id, 发货信息Map>
        //     发货信息Map
        //         orderId
        //         orderDtlCount:订单明细订购数量
        //         orderDtlSum: 订单明细货品金额
        //         checkCount: 验证数量(发货数量-退货数量)
        //         checkSum: (发货金额-退货金额)
        Map<String, Map<String, Object>> orderDtlMap = saleDeliverDetailByCollectService.findMapOrderDetaiCountByOrderId(orderId);

        //修改订单明细状态
        SaleOrderDetail editOrderDtl = new SaleOrderDetail();
        editOrderDtl.setId(orderDtlId);

        Map<String, Object> valueMap = orderDtlMap.get(orderDtlId);
        //orderDtlCount:订单明细订购数量,
        BigDecimal orderDtlCount = (BigDecimal)valueMap.get("orderDtlCount");
        //checkCount: 验证数量(发货数量-退货数量)
        BigDecimal checkCount = (BigDecimal)valueMap.get("checkCount");

        if (checkCount.doubleValue() >= orderDtlCount.doubleValue()) {
            //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
            editOrderDtl.setState("5");
        }
        this.update(editOrderDtl);

        //修改订单状态
        List<SaleOrderDetail> orderDtlList = this.findSaleOrderDetailListByParentId(orderId);
        SaleOrder order_old = saleOrderService.findSaleOrderById(orderId);
        //修改前: orderSum_old(订单金额)
        BigDecimal orderSum_old = BigDecimal.valueOf(0D);
        if (order_old != null && order_old.getOrderSum() != null) {
            orderSum_old = order_old.getOrderSum();
        }

        SaleOrder orderEdit = new SaleOrder();
        orderEdit.setId(orderId);
        //discountSum 折扣金额
        orderEdit.setDiscountSum(BigDecimal.valueOf(0D));
        BigDecimal totalSum = this.findTotalSumByPrice(orderDtlList);
        //totalSum 合计金额
        orderEdit.setTotalSum(totalSum);
        //orderSum 订单金额
        orderEdit.setOrderSum(totalSum);
        //修改后: orderSum_new(订单金额)
        BigDecimal orderSum_new = totalSum;

        //订单变更金额 := (修改后)订单金额 - (修改前)订单金额
        BigDecimal orderSum_change = BigDecimal.valueOf(orderSum_new.doubleValue() - orderSum_old.doubleValue());
        //四舍五入到2位小数
        orderSum_change = orderSum_change.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        String remarkTemp = "订单编号:{0} 变更订单金额:{1}";
        String remark = MessageFormat.format(remarkTemp,
                order_old.getSysCode(),
                BigDecimal.valueOf(orderSum_change.doubleValue()).toString());
        orderEdit.setRemark(remark);
        saleOrderService.update(orderEdit);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        //生成负数的付款单
        //1. (负数)付款金额:=0                            变更后订单金额 >= 订单已付金额
        //2. (负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额

        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderId, "1");
        Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);
        //订单id-订单已完成付款金额
        BigDecimal receiveSum = BigDecimal.valueOf(0D);
        if (receiveMap != null && receiveMap.get("receiveSum") != null) {
            receiveSum = receiveMap.get("receiveSum");
        }

        //(负数)付款金额
        BigDecimal ReceiveSum = BigDecimal.valueOf(0D);
        //(负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额
        if (orderSum_new.doubleValue() < receiveSum.doubleValue()) {
            ReceiveSum = BigDecimal.valueOf(orderSum_new.doubleValue() - receiveSum.doubleValue());;
        }

        if (ReceiveSum.doubleValue() != 0) {
            //四舍五入到2位小数
            ReceiveSum = ReceiveSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            if (ReceiveSum.doubleValue() < 0) {
                //ReceiveSum < 0 退钱给客户
                saleReceiveRecordService.editCustomerBalanceByOrder(
                        customerId,
                        null,
                        //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
                        "4",
                        BigDecimal.valueOf(ReceiveSum.doubleValue() * -1),
                        cuser,
                        remark);
            }

            //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
            SaleReceive receive = saleReceiveService.createReceive(customerId,
                    cuser,
                    companyId,
                    "3");
            receive.setReceiveSum(BigDecimal.valueOf(ReceiveSum.doubleValue()));
            saleReceiveService.save(receive);

            //2. 创建收款单明细
            //获取 <订单id, 退货金额>
            SaleReceiveDetail receiveDtl = new SaleReceiveDetail();
            receiveDtl.setOrderId(orderId);
            //收款单状态(0:待收款 1:已收款 -1:已取消)
            receiveDtl.setState("1");
            //receiveAmount 实收金额
            receiveDtl.setReceiveAmount(BigDecimal.valueOf(ReceiveSum.doubleValue()));
            //discountAmount 折扣金额
            receiveDtl.setDiscountAmount(BigDecimal.valueOf(0D));

            List<SaleReceiveDetail> receiveDtlList = new ArrayList<SaleReceiveDetail>();
            receiveDtlList.add(receiveDtl);
            saleReceiveDetailService.addReceiveDetail(receive, receiveDtlList);
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改订单状态
        SaleOrder parent = new SaleOrder();
        parent.setId(orderId);
        this.updateParentStateByDetailList(parent, orderDtlList);

        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
        orderReceiveMap.clear();
        orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderId, "1");
        Map<String, BigDecimal> receiveMap_1 = orderReceiveMap.get(orderId);
        //订单id-订单已完成付款金额
        receiveSum = BigDecimal.valueOf(0D);
        if (receiveMap_1 != null && receiveMap_1.get("receiveSum") != null) {
            receiveSum = receiveMap_1.get("receiveSum");
        }

        SaleOrder editOrderByPayState = new SaleOrder();
        editOrderByPayState.setId(orderId);
        if (receiveSum.doubleValue() >= orderSum_new.doubleValue()) {
            //付款完成日期 payDate
            editOrderByPayState.setPayDate(new Date());
            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
            editOrderByPayState.setPayState("2");
            saleOrderService.update(editOrderByPayState);
        } else if (receiveSum.doubleValue() < orderSum_new.doubleValue()) {
            //付款完成日期 payDate
            editOrderByPayState.setPayDate(null);
            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
            editOrderByPayState.setPayState("1");
            saleOrderService.update(editOrderByPayState);
        }

        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        if (this.isAllExistStateByDetailList("5", orderDtlList)) {
            if (orderId != null) {
                SaleOrder editOrder = new SaleOrder();
                editOrder.setId(orderId);
                if (receiveSum.doubleValue() >= orderSum_new.doubleValue()) {
                    //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
                    editOrder.setState("4");
                    saleOrderService.update(editOrder);
                }
            }
        }

        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public void exportExcelSaleOrderDetails(PageData pd, Pagination pg) throws Exception {
//        List<Column> columnList = columnService.findColumnList("saleOrderDetail");
//        if (columnList == null || columnList.size() == 0) {
//            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
//        }
//
//        //根据查询条件获取业务数据List
//        String ids = (String)pd.getString("ids");
//        String queryStr = "";
//        if (ids != null && ids.trim().length() > 0) {
//            ids = StringUtil.stringTrimSpace(ids);
//            ids = "'" + ids.replace(",", "','") + "'";
//            queryStr = "id in (" + ids + ")";
//        }
//        pd.put("queryStr", queryStr);
//
//        pg.setSize(100000);
//        List<Map> dataList = this.getDataListPage(pd, pg);
//
//        //查询数据转换成Excel导出数据
//        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
//        HttpServletResponse response = HttpUtils.currentResponse();
//
//        //查询数据-Excel文件导出
//        String fileName = pd.getString("fileName");
//        if (fileName == null || fileName.trim().length() == 0) {
//            fileName = "ExcelSaleOrderDetail";
//        }
//
//        //导出文件名-中文转码
//        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
//        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
//    }

//    @Override
//    public ResultModel importExcelSaleOrderDetails(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//        //HttpServletRequest Request = HttpUtils.currentRequest();
//
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//        return model;
//    }

//    /////////////////////////////////////////////////////////////////////////////////////////////////////////
//    private StringBuffer findOutMessageByOutIdList(List<String> outIdList, String productInfo) {
//        StringBuffer msgBuf = new StringBuffer();
//        if (outIdList == null || outIdList.size() == 0) {return msgBuf;}
//
//        Map<String, String> outMap = new LinkedHashMap<String, String>();
//        for (String outId : outIdList) {
//            outMap.put(outId, outId);
//        }
//
//        //出库单号:出库单号 货品编码:货品编码
//        String msgTemp = "出库单号:{0} {1} " + Common.SYS_ENDLINE_DEFAULT;
//        for (Iterator iterator = outMap.keySet().iterator(); iterator.hasNext();) {
//            String outId = iterator.next().toString().trim();
//
//            try {
//                WarehouseOut outObject = outService.selectById(outId);
//                if (outObject != null) {
//                    String msgStr = MessageFormat.format(msgTemp,
//                            outObject.getCode(),
//                            productInfo);
//                    msgBuf.append(msgStr);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return msgBuf;
//    }
}



