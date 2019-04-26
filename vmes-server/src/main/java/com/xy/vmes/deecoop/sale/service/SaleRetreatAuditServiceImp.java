package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.DateUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleRetreatAuditServiceImp implements SaleRetreatAuditService {
    @Autowired
    private SaleRetreatService saleRetreatService;
    @Autowired
    private SaleRetreatDetailService saleRetreatDetailService;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private SaleReceiveService saleReceiveService;
    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;
    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    /**
     * 退货单审核(创建入库单,退货单明细)
     * 1. 创建入库单(入库单, 入库单明细)
     * 2. 修改退货单明细(退货单明细(关联)入库单明细)
     * 3. 修改订单明细(订购数量,订单金额)
     * 4. 修改订单(订单金额,合计金额,折扣金额)
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel auditPassSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String companyId = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }
        String customerId = pageData.getString("customerId");
        String customerName = pageData.getString("customerName");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无列表数据！");
            return model;
        }

        List<Map<String, String>> retreatDtlMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (retreatDtlMapList == null || retreatDtlMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //根据(退货单id)-获取退货单明细List
        List<SaleRetreatDetail> retreatDtlList = saleRetreatDetailService.findSaleOrderReturnDetailListByParentId(parentId);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //1. 创建入库单
        WarehouseIn warehouseIn = warehouseInService.createWarehouseIn(customerId,
                customerName,
                cuser,
                companyId,
                Common.DICTIONARY_MAP.get("saleRetreatIn"));

        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        warehouseIn.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
        warehouseInService.save(warehouseIn);

        //2. 创建入库单明细
        List<WarehouseInDetail> inDtlList = saleRetreatDetailService.retreatDtlList2InDtlList(retreatDtlList, null);
        warehouseInDetailService.addWarehouseInDetail(warehouseIn, inDtlList);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //<退货单明细id, 入库明细id>Map
        Map<String, String> retreatDtl2InDtlMap = new HashMap<String, String>();
        for (WarehouseInDetail inDtl : inDtlList) {
            retreatDtl2InDtlMap.put(inDtl.getBusinessId(), inDtl.getId());
        }

        //3. 修改退货单明细(退货单明细(关联)入库单明细)
        for (Map<String, String> mapObject : retreatDtlMapList) {
            SaleRetreatDetail detailEdit = new SaleRetreatDetail();
            //id: 退货单明细id,
            String retreatDtl_id = mapObject.get("id");
            detailEdit.setId(retreatDtl_id);

            //orderSum: 订单退货金额
            BigDecimal orderSum = BigDecimal.valueOf(0D);
            String orderSum_str = mapObject.get("orderSum");
            if (orderSum_str != null && orderSum_str.trim().length() > 0) {
                try {
                    orderSum = new BigDecimal(orderSum_str.trim());
                    //四舍五入到2位小数
                    orderSum = orderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            detailEdit.setOrderSum(orderSum);

            if (retreatDtl2InDtlMap != null
                    && retreatDtl2InDtlMap.get(retreatDtl_id) != null
                    && retreatDtl2InDtlMap.get(retreatDtl_id).trim().length() > 0
                    ) {
                detailEdit.setInDetailId(retreatDtl2InDtlMap.get(retreatDtl_id).trim());
            }

            //退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
            detailEdit.setState("3");
            saleRetreatDetailService.update(detailEdit);
        }

        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        //审核人ID
        retreatEdit.setAuditId(cuser);
        //状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("3");
        saleRetreatService.update(retreatEdit);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 修改订单明细和订单
        //获取 <订单明细id, <订单明细退货信息Map(orderCount:退货数量,orderSum:退货金额)>
        Map<String, Map<String, BigDecimal>> orderDtlRetreatMap = saleRetreatDetailService.findOrderDtlRetreatCountMap(retreatDtlList);
        if (orderDtlRetreatMap == null || orderDtlRetreatMap.size() == 0) {
            return model;
        }

        //获取订单明细id字符串-(','逗号分隔字符串)
        String orderDtlIds = saleRetreatDetailService.findOrderDtlIdsByRetreatDtlList(retreatDtlList);
        if (orderDtlIds == null || orderDtlIds.trim().length() == 0) {
            return model;
        }

        PageData findMap = new PageData();
        orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
        findMap.put("ids", orderDtlIds);
        List<SaleOrderDetail> orderDtlList = saleOrderDetailService.findSaleOrderDetailList(findMap);
        if (orderDtlList == null || orderDtlList.size() == 0) {
            return model;
        }

        //修改订单明细-变更订单明细(订购数量,货品金额)
        saleRetreatDetailService.updateOrderByRetreat(orderDtlRetreatMap, orderDtlList);

        //获取当前退货单中-订单信息(订单id,订单编号,订单已付金额,订单金额) 遍历List
        Map<String, Map<String, Object>> orderMap = this.findOrderMap(retreatDtlMapList);
        //获取当前退货单中-<订单id, 退货单明细列表>
        Map<String, List<SaleRetreatDetail>> orderRetreatDtlMap = this.findOrderRetreatDtlMap(retreatDtlMapList);
        //获取当前退货单中-订单退货金额 <订单id, 退货单明细列表>
        Map<String, List<SaleRetreatDetail>> orderRetreatSumMap = this.findOrderRetreatSumMap(retreatDtlMapList);

        for (Iterator iterator = orderMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            Map<String, Object> orderObjMap = orderMap.get(mapKey);

            //sysOrderCode:订单编号
            String sysOrderCode = (String)orderObjMap.get("sysOrderCode");

            SaleOrder orderEdit = new SaleOrder();
            //orderId:订单id
            String orderId = (String)orderObjMap.get("orderId");
            orderEdit.setId(orderId);

            List<SaleOrderDetail> orderDetailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
            BigDecimal orderTotalSum =  saleOrderDetailService.findTotalSumByPrice(orderDetailList);

            orderEdit.setOrderSum(orderTotalSum);
            orderEdit.setTotalSum(orderTotalSum);
            orderEdit.setDiscountSum(BigDecimal.valueOf(0D));

            List<SaleRetreatDetail> retreatDtlListByOrder = orderRetreatDtlMap.get(orderId);
            BigDecimal orderRetreatSumByorderDtl = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlListByOrder);

            String remarkTemp = "订单编号:{0} 退款金额:{1}";
            String remark = MessageFormat.format(remarkTemp,
                    sysOrderCode,
                    orderRetreatSumByorderDtl.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP)
            );
            orderEdit.setRemark(remark);
            //修改订单信息(备注，订单金额)
            saleOrderService.update(orderEdit);

            //修改订单状态
            SaleOrder parent = new SaleOrder();
            parent.setId(orderId);
            saleOrderDetailService.updateParentStateByDetailList(parent, orderDetailList);

            //orderTotalSum 订单金额
            //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
            Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderId, "1");
            //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
            if (saleOrderDetailService.isAllExistStateByDetailList("5", orderDetailList)) {
                if (orderId != null) {
                    Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);

                    //订单id-订单已完成付款金额
                    BigDecimal receiveSum = BigDecimal.valueOf(0D);
                    if (receiveMap.get("receiveSum") != null) {
                        receiveSum = receiveMap.get("receiveSum");
                    }
                    SaleOrder editOrder = new SaleOrder();
                    editOrder.setId(orderId);
                    if (receiveSum.doubleValue() >= orderTotalSum.doubleValue()) {
                        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
                        editOrder.setState("4");
                        saleOrderService.update(editOrder);
                    }
                }
            }

            //订单id-订单退货金额(页面输入框)
            List<SaleRetreatDetail> retreatDtlListByOrderRetreatSum = orderRetreatSumMap.get(orderId);
            BigDecimal orderRetreatSum = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlListByOrderRetreatSum);
            if (orderRetreatSum != null) {
                saleReceiveRecordService.editCustomerBalanceByOrder(
                        customerId,
                        null,
                        //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
                        "3",
                        BigDecimal.valueOf(orderRetreatSum.doubleValue() * -1),
                        cuser,
                        remark);

                //创建收款单-负数的收款单
                //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
                SaleReceive receive = saleReceiveService.createReceive(customerId,
                        cuser,
                        companyId,
                        "3");
                receive.setReceiveSum(BigDecimal.valueOf(orderRetreatSum.doubleValue() * -1));
                saleReceiveService.save(receive);

                //2. 创建收款单明细
                //获取 <订单id, 退货金额>
                SaleReceiveDetail receiveDtl = new SaleReceiveDetail();
                receiveDtl.setOrderId(orderId);
                //收款单状态(0:待收款 1:已收款 -1:已取消)
                receiveDtl.setState("1");
                //receiveAmount 实收金额
                receiveDtl.setReceiveAmount(BigDecimal.valueOf(orderRetreatSum.doubleValue() * -1));
                //discountAmount 折扣金额
                receiveDtl.setDiscountAmount(BigDecimal.valueOf(0D));

                List<SaleReceiveDetail> receiveDtlList = new ArrayList<SaleReceiveDetail>();
                receiveDtlList.add(receiveDtl);
                saleReceiveDetailService.addReceiveDetail(receive, receiveDtlList);
            }
        }

        return model;
    }

    public ResultModel auditDisagreeSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        //当前登录用户姓名
        String userName = "";
        if (pageData.getString("userName") != null && pageData.getString("userName").trim().length() > 0) {
            userName = pageData.getString("userName").trim();
        }

        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        String msgTemp = "审核退回:{0}{3}审核人:{1}{3}审核时间:{2}";
        String remarkStr = MessageFormat.format(msgTemp,
                remark,
                userName,
                DateUtils.toDateStr(new Date()),
                Common.SYS_ENDLINE_DEFAULT);
        retreatEdit.setRemark(remarkStr);
        //退货单状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("0");
        //审核人ID
        retreatEdit.setAuditId(cuser);
        saleRetreatService.update(retreatEdit);

        //退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        saleRetreatDetailService.updateStateByDetail("0", parentId);

        return model;
    }

    public ResultModel checkRetreatEdit(PageData pageData) {
        ResultModel model = new ResultModel();
        model.set("msgStr", "");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 获取当前退货单中-订单信息(订单id,订单编号,订单已付金额,订单金额) 遍历List
        Map<String, Map<String, Object>> orderMap = this.findOrderMap(mapList);

        //2. 获取当前退货单中-<订单id, 退货单明细列表>
        Map<String, List<SaleRetreatDetail>> orderRetreatDtlMap = this.findOrderRetreatDtlMap(mapList);

        //3. 获取当前退货单中-订单退货金额 <订单id, 退货单明细列表>
        Map<String, List<SaleRetreatDetail>> orderRetreatSumMap = this.findOrderRetreatSumMap(mapList);

        String msgTemp_error_1 = "订单编号：{0} 实收金额：{1} 汇总退货金额：{2} 汇总退货金额不可大于实收金额";
        String msgTemp_error_2 = "订单编号：{0} 实收金额：{1} 退货审核完成后：订单金额{2} 订单已付金额：{3} 订单已付金额大于订单金额，";

        for (Iterator iterator = orderMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            Map<String, Object> orderObjMap = orderMap.get(mapKey);

            //orderId:订单id
            String orderId = (String)orderObjMap.get("orderId");

            //sysOrderCode:订单编号
            String sysOrderCode = (String)orderObjMap.get("sysOrderCode");

            //receiveAmount:实收金额 订单已付金额
            BigDecimal receiveAmount = (BigDecimal)orderObjMap.get("receiveAmount");

            //orderTotalSum:订单金额
            BigDecimal orderTotalSum = (BigDecimal)orderObjMap.get("orderTotalSum");

            //订单id-订单明细id对应的退货金额
            List<SaleRetreatDetail> retreatDtlListByOrder = orderRetreatDtlMap.get(orderId);
            BigDecimal orderRetreatSumByorderDtl = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlListByOrder);

            //订单id-订单退货金额(页面输入框)
            List<SaleRetreatDetail> retreatDtlListByOrderRetreatSum = orderRetreatSumMap.get(orderId);
            BigDecimal orderRetreatSum = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlListByOrderRetreatSum);

            //A. 汇总退货金额不可大于实收金额
            if (receiveAmount.doubleValue() < orderRetreatSum.doubleValue()) {
                //String msgTemp_error_1 = "订单编号:{0} 实收金额:{1} 汇总退货金额:{2} 汇总退货金额不可大于实收金额"
                String msgStr = MessageFormat.format(msgTemp_error_1,
                        sysOrderCode,
                        receiveAmount.toString(),
                        orderRetreatSum.toString());
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //B. (实收金额-订单退货金额) 不可大于 (订单金额)
            if ((receiveAmount.doubleValue() - orderRetreatSum.doubleValue())
                > (orderTotalSum.doubleValue() - orderRetreatSumByorderDtl.doubleValue())
            ) {
                //String msgTemp_error_2 = "订单编号:{0},实收金额:{1} 退货审核完成后:订单金额{2} 订单已付金额:{3} 订单已付金额大于订单金额";
                String msgStr = MessageFormat.format(msgTemp_error_2,
                        sysOrderCode,
                        receiveAmount.toString(),
                        BigDecimal.valueOf(orderTotalSum.doubleValue() - orderRetreatSumByorderDtl.doubleValue()).toString(),
                        BigDecimal.valueOf(receiveAmount.doubleValue() - orderRetreatSum.doubleValue()).toString());
                model.putCode(Integer.valueOf(0));
                model.set("msgStr", msgStr);
                //model.putMsg(msgStr);
                return model;
            }
        }

        return model;
    }

    ////////////////////////////////////////////////////////////////////
    /**
     *
     * 订单相关信息
     * orderId: rowData.orderId,
     * sysOrderCode: rowData.sysOrderCode,
     * receiveAmount: rowData.receiveAmount,
     * orderTotalSum: rowData.orderTotalSum,
     *
     * 退货单明细表
     * id: rowData.id,
     * parentId: rowData.parentId,
     * productId: rowData.productId,
     * productCount: rowData.productCount,
     * orderDetailId: rowData.orderDetailId,
     * retreatDtlSum: rowData.retreatDtlSum,
     * orderSum: rowData.orderSum
     *
     * @param mapList
     * @return
     */
    private String checkColumnByEdit(List<Map<String, String>> mapList) {
        return null;
    }

    /**
     * 获取订单信息Map
     *
     * <订单id, 订单信息Map>
     *     订单信息Map<String, Object>
     *         orderId:订单id
     *         sysOrderCode:订单编号
     *         receiveAmount:订单已付金额
     *         orderTotalSum:订单金额
     *
     * @param mapList
     * @return
     */
    private Map<String, Map<String, Object>> findOrderMap(List<Map<String, String>> mapList) {
        Map<String, Map<String, Object>> orderMap = new HashMap<String, Map<String, Object>>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            Map<String, Object> order = new HashMap<String, Object>();

            //orderId:订单id
            String orderId = mapObject.get("orderId");
            order.put("orderId", orderId);

            //sysOrderCode:订单编号
            String sysOrderCode = mapObject.get("sysOrderCode");
            order.put("sysOrderCode", sysOrderCode);

            //receiveAmount:订单已付金额
            BigDecimal receiveAmount = BigDecimal.valueOf(0D);
            String receiveAmount_str = mapObject.get("receiveAmount");
            if (receiveAmount_str != null && receiveAmount_str.trim().length() > 0) {
                try {
                    receiveAmount = new BigDecimal(receiveAmount_str.trim());
                    //四舍五入到2位小数
                    receiveAmount = receiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            order.put("receiveAmount", receiveAmount);

            //orderTotalSum:订单金额
            BigDecimal orderTotalSum = BigDecimal.valueOf(0D);
            String orderTotalSum_str = mapObject.get("orderTotalSum");
            if (orderTotalSum_str != null && orderTotalSum_str.trim().length() > 0) {
                try {
                    orderTotalSum = new BigDecimal(orderTotalSum_str.trim());
                    //四舍五入到2位小数
                    orderTotalSum = orderTotalSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            order.put("orderTotalSum", orderTotalSum);

            orderMap.put(orderId, order);
        }

        return orderMap;
    }

    private Map<String, List<SaleRetreatDetail>> findOrderRetreatDtlMap(List<Map<String, String>> mapList) {
        Map<String, List<SaleRetreatDetail>> orderMap = new HashMap<String, List<SaleRetreatDetail>>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            //orderId:订单id
            String orderId = mapObject.get("orderId");

            SaleRetreatDetail object = new SaleRetreatDetail();
            //id: 退货单明细id,
            String id = mapObject.get("id");
            object.setId(id);

            //parentId:退货单Id,
            String parentId = mapObject.get("parentId");
            object.setParentId(parentId);

            //orderDetailId: 订单明细Id,
            String orderDetailId = mapObject.get("orderDetailId");
            object.setOrderDetailId(orderDetailId);

            //productId: rowData.productId,
            String productId = mapObject.get("productId");
            object.setParentId(productId);

            //productCount: rowData.productCount,
            BigDecimal productCount = BigDecimal.valueOf(0D);
            String productCount_str = mapObject.get("productCount");
            if (productCount_str != null && productCount_str.trim().length() > 0) {
                try {
                    productCount = new BigDecimal(productCount_str.trim());
                    //四舍五入到2位小数
                    productCount = productCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            object.setProductCount(productCount);

            //retreatDtlSum: 订单明细Id-退货金额,
            BigDecimal retreatDtlSum = BigDecimal.valueOf(0D);
            String retreatDtlSum_str = mapObject.get("retreatDtlSum");
            if (retreatDtlSum_str != null && retreatDtlSum_str.trim().length() > 0) {
                try {
                    retreatDtlSum = new BigDecimal(retreatDtlSum_str.trim());
                    //四舍五入到2位小数
                    retreatDtlSum = retreatDtlSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            object.setOrderSum(retreatDtlSum);

            //orderSum: rowData.orderSum

            if (orderMap.get(orderId) == null) {
                List<SaleRetreatDetail> objectList = new ArrayList<SaleRetreatDetail>();
                objectList.add(object);
                orderMap.put(orderId, objectList);
            } else if (orderMap.get(orderId) != null) {
                List<SaleRetreatDetail> objectList = orderMap.get(orderId);
                objectList.add(object);
                orderMap.put(orderId, objectList);
            }
        }

        return orderMap;
    }

    private Map<String, List<SaleRetreatDetail>> findOrderRetreatSumMap(List<Map<String, String>> mapList) {
        Map<String, List<SaleRetreatDetail>> orderMap = new HashMap<String, List<SaleRetreatDetail>>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            //orderId:订单id
            String orderId = mapObject.get("orderId");

            SaleRetreatDetail object = new SaleRetreatDetail();
            //id: 退货单明细id,
            String id = mapObject.get("id");
            object.setId(id);

            //parentId:退货单Id,
            String parentId = mapObject.get("parentId");
            object.setParentId(parentId);

            //orderDetailId: 订单明细Id,
            String orderDetailId = mapObject.get("orderDetailId");
            object.setOrderDetailId(orderDetailId);

            //retreatDtlSum: 订单明细Id-退货金额,
            //orderSum: 订单退货金额
            BigDecimal orderSum = BigDecimal.valueOf(0D);
            String orderSum_str = mapObject.get("orderSum");
            if (orderSum_str != null && orderSum_str.trim().length() > 0) {
                try {
                    orderSum = new BigDecimal(orderSum_str.trim());
                    //四舍五入到2位小数
                    orderSum = orderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            object.setOrderSum(orderSum);

            if (orderMap.get(orderId) == null) {
                List<SaleRetreatDetail> objectList = new ArrayList<SaleRetreatDetail>();
                objectList.add(object);
                orderMap.put(orderId, objectList);
            } else if (orderMap.get(orderId) != null) {
                List<SaleRetreatDetail> objectList = orderMap.get(orderId);
                objectList.add(object);
                orderMap.put(orderId, objectList);
            }
        }

        return orderMap;
    }
}
