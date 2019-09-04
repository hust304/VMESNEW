package com.xy.vmes.deecoop.sale.service;

import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.rabbitmq.sender.ProductStockcountLockSender;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderByChangeServiceImp implements SaleOrderByChangeService {
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private ProductService productService;
    @Autowired
    private SaleLockDateService saleLockDateService;
    //消息队列
    @Autowired
    private ProductStockcountLockSender firstSender;

//    /**
//     * 变更订单-变更订单明细(订购数量,锁定货品数量)
//     * dtlJsonStr: 界面(model_code = 'saleOrderDetailByChange')
//     *
//     * 订单单明细表
//     * id: rowData.id,
//     * parentId: rowData.parentId,
//     * productId: rowData.productId,
//     * lockCount: rowData.lockCount,
//     * state: rowData.state,
//
//     * newOrderCount: rowData.newOrderCount,
//     * newProductSum: rowData.newProductSum,
//     * newNeedDeliverCount: rowData.newNeedDeliverCount,
//     * p2nFormula: rowData.p2nFormula,
//     * n2pFormula: rowData.n2pFormula
//     * stockCount: rowData.stockCount
//     *
//     * @param pageData
//     * @return
//     * @throws Exception
//     */
//    public ResultModel updateSaleOrderByChange(PageData pageData) throws Exception {
//        ResultModel model = new ResultModel();
//        String cuser = pageData.getString("cuser");
//        String companyId = pageData.getString("currentCompanyId");
//        String customerId = pageData.getString("customerId");
//
//        String orderId = pageData.getString("orderId");
//        if (orderId == null || orderId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("订单id为空或空字符串！");
//            return model;
//        }
//
//        String dtlJsonStr = pageData.getString("dtlJsonStr");
//        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("订单明细为空！");
//            return model;
//        }
//
//        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
//        if (mapList == null || mapList.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("订单明细Json字符串-转换成List错误！");
//            return model;
//        }
//
//        List<SaleOrderDetailEntity> orderDtlEntityList = this.orderChangeMapList2OrderDtlList(mapList, null);
//
//        //修改订单明细(订单明细订购金额, 订单明细货品数量)
//        //2:待生产
//        this.orderChangeByReadyProduce(orderDtlEntityList);
//        //3:待出库
//        this.orderChangeByReadyOut(orderDtlEntityList, companyId);
//        //4:待发货
//        this.orderChangeByReadyDeliver(orderDtlEntityList,companyId);
//
//        //修改订单明细状态(订单明细货品数量 与 订单明细已发货数量 比较)
//        //按订单id-获取<订单明细id, 发货信息Map> - (orderDtlCount:订单明细订购数量, checkCount: 验证数量(发货数量-退货数量))
//        Map<String, Map<String, Object>> orderDtlMap = saleDeliverDetailByCollectService.findMapOrderDetaiCountByOrderId(orderId);
//        for (SaleOrderDetailEntity orderDtlEntity : orderDtlEntityList) {
//            SaleOrderDetail orderDetailEdit = new SaleOrderDetail();
//
//            String orderDtl_id = orderDtlEntity.getId();
//            orderDetailEdit.setId(orderDtl_id);
//
//            Map<String, Object> valueMap = orderDtlMap.get(orderDtl_id);
//            //orderDtlCount:订单明细订购数量,
//            BigDecimal orderDtlCount = (BigDecimal)valueMap.get("orderDtlCount");
//            //checkCount: 验证数量(发货数量-退货数量)
//            BigDecimal checkCount = (BigDecimal)valueMap.get("checkCount");
//
//            if (checkCount.doubleValue() >= orderDtlCount.doubleValue()) {
//                //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//                orderDetailEdit.setState("5");
//            }
//            saleOrderDetailService.update(orderDetailEdit);
//        }
//
//        SaleOrder order_old = saleOrderService.findSaleOrderById(orderId);
//        //修改前: orderSum_old(订单金额)
//        BigDecimal orderSum_old = BigDecimal.valueOf(0D);
//        if (order_old != null && order_old.getOrderSum() != null) {
//            orderSum_old = order_old.getOrderSum();
//        }
//
//        //修改订单金额
//        List<SaleOrderDetail> orderDtlList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
//        SaleOrder orderEdit = new SaleOrder();
//        orderEdit.setId(orderId);
//        //discountSum 折扣金额
//        orderEdit.setDiscountSum(BigDecimal.valueOf(0D));
//        BigDecimal totalSum = saleOrderDetailService.findTotalSumByPrice(orderDtlList);
//        //totalSum 合计金额
//        orderEdit.setTotalSum(totalSum);
//        //orderSum 订单金额
//        orderEdit.setOrderSum(totalSum);
//        //修改后: orderSum_new(订单金额)
//        BigDecimal orderSum_new = totalSum;
//
//        //订单变更金额 := (修改后)订单金额 - (修改前)订单金额
//        BigDecimal orderSum_change = BigDecimal.valueOf(orderSum_new.doubleValue() - orderSum_old.doubleValue());
//        //四舍五入到2位小数
//        orderSum_change = orderSum_change.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//
//        String remarkTemp = "订单编号:{0} 变更订单金额:{1}";
//        String remark = MessageFormat.format(remarkTemp,
//                order_old.getSysCode(),
//                BigDecimal.valueOf(orderSum_change.doubleValue()).toString());
//        orderEdit.setRemark(remark);
//        saleOrderService.update(orderEdit);
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //生成负数的付款单
//        //1. (负数)付款金额:=0                            变更后订单金额 >= 订单已付金额
//        //2. (负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额
//
//        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
//        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderId, "1");
//        Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);
//        //订单id-订单已完成付款金额
//        BigDecimal receiveSum = BigDecimal.valueOf(0D);
//        if (receiveMap != null && receiveMap.get("receiveSum") != null) {
//            receiveSum = receiveMap.get("receiveSum");
//        }
//
//        //(负数)付款金额
//        BigDecimal ReceiveSum = BigDecimal.valueOf(0D);
//        //(负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额
//        if (orderSum_new.doubleValue() < receiveSum.doubleValue()) {
//            ReceiveSum = BigDecimal.valueOf(orderSum_new.doubleValue() - receiveSum.doubleValue());;
//        }
//
//        if (ReceiveSum.doubleValue() != 0) {
//            //四舍五入到2位小数
//            ReceiveSum = ReceiveSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            if (ReceiveSum.doubleValue() < 0) {
//                //ReceiveSum < 0 退钱给客户
//                saleReceiveRecordService.editCustomerBalanceByOrder(
//                        customerId,
//                        null,
//                        //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
//                        "4",
//                        BigDecimal.valueOf(ReceiveSum.doubleValue() * -1),
//                        cuser,
//                        remark);
//            }
//
//            //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
//            SaleReceive receive = saleReceiveService.createReceive(customerId,
//                    cuser,
//                    companyId,
//                    "3");
//            receive.setReceiveSum(BigDecimal.valueOf(ReceiveSum.doubleValue()));
//            saleReceiveService.save(receive);
//
//            //2. 创建收款单明细
//            //获取 <订单id, 退货金额>
//            SaleReceiveDetail receiveDtl = new SaleReceiveDetail();
//            receiveDtl.setOrderId(orderId);
//            //收款单状态(0:待收款 1:已收款 -1:已取消)
//            receiveDtl.setState("1");
//            //receiveAmount 实收金额
//            receiveDtl.setReceiveAmount(BigDecimal.valueOf(ReceiveSum.doubleValue()));
//            //discountAmount 折扣金额
//            receiveDtl.setDiscountAmount(BigDecimal.valueOf(0D));
//
//            List<SaleReceiveDetail> receiveDtlList = new ArrayList<SaleReceiveDetail>();
//            receiveDtlList.add(receiveDtl);
//            saleReceiveDetailService.addReceiveDetail(receive, receiveDtlList);
//        }
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //修改订单状态
//        SaleOrder parent = new SaleOrder();
//        parent.setId(orderId);
//        saleOrderDetailService.updateParentStateByDetailList(parent, orderDtlList);
//
//        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
//        orderReceiveMap.clear();
//        orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderId, "1");
//        Map<String, BigDecimal> receiveMap_1 = orderReceiveMap.get(orderId);
//        //订单id-订单已完成付款金额
//        receiveSum = BigDecimal.valueOf(0D);
//        if (receiveMap_1 != null && receiveMap_1.get("receiveSum") != null) {
//            receiveSum = receiveMap_1.get("receiveSum");
//        }
//
//        SaleOrder editOrderByPayState = new SaleOrder();
//        editOrderByPayState.setId(orderId);
//        if (receiveSum.doubleValue() >= orderSum_new.doubleValue()) {
//            //付款完成日期 payDate
//            editOrderByPayState.setPayDate(new Date());
//            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
//            editOrderByPayState.setPayState("2");
//            saleOrderService.update(editOrderByPayState);
//        } else if (receiveSum.doubleValue() < orderSum_new.doubleValue()) {
//            //付款完成日期 payDate
//            editOrderByPayState.setPayDate(null);
//            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
//            editOrderByPayState.setPayState("1");
//            saleOrderService.update(editOrderByPayState);
//        }
//
//        //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//        if (saleOrderDetailService.isAllExistStateByDetailList("5", orderDtlList)) {
//            if (orderId != null) {
//                SaleOrder editOrder = new SaleOrder();
//                editOrder.setId(orderId);
//                if (receiveSum.doubleValue() >= orderSum_new.doubleValue()) {
//                    //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//                    editOrder.setState("4");
//                    saleOrderService.update(editOrder);
//                }
//            }
//        }
//
//        return model;
//    }

    public List<SaleOrderDetailEntity> orderChangeMapList2OrderDtlList(List<Map<String, String>> mapList, List<SaleOrderDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetailEntity orderDtlEntity = (SaleOrderDetailEntity) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetailEntity());

            //oldOrderCount 变更前-订购数量
            BigDecimal oldOrderCount = BigDecimal.valueOf(0D);
            String oldOrderCount_Str = mapObject.get("oldOrderCount");
            if (oldOrderCount_Str != null && oldOrderCount_Str.trim().length() > 0) {
                try {
                    oldOrderCount = new BigDecimal(oldOrderCount_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            oldOrderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDtlEntity.setOldOrderCount(oldOrderCount);

            //newOrderCount 变更订购数量
            BigDecimal newOrderCount = BigDecimal.valueOf(0D);
            String newOrderCount_Str = mapObject.get("newOrderCount");
            if (newOrderCount_Str != null && newOrderCount_Str.trim().length() > 0) {
                try {
                    newOrderCount = new BigDecimal(newOrderCount_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            newOrderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDtlEntity.setOrderCount(newOrderCount);
            orderDtlEntity.setPriceCount(newOrderCount);
            orderDtlEntity.setNewOrderCount(newOrderCount);
            //needDeliverCount 可发货数量(计价单位)
            orderDtlEntity.setNeedDeliverCount(newOrderCount);

            //newProductSum 修改货品金额
            BigDecimal newProductSum = BigDecimal.valueOf(0D);
            String newProductSum_Str = mapObject.get("newProductSum");
            if (newProductSum_Str != null && newProductSum_Str.trim().length() > 0) {
                try {
                    newProductSum = new BigDecimal(newProductSum_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            newProductSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDtlEntity.setProductSum(newProductSum);

            //p2nFormula 单位转换公式:计价单位转换计量单位
            String p2nFormula = mapObject.get("p2nFormula");

            //productCount 货品数量(计量数量)
            BigDecimal productCount = BigDecimal.valueOf(0D);
            BigDecimal countFormula = EvaluateUtil.countFormulaP2N(newOrderCount, p2nFormula);
            if (countFormula != null) {productCount = countFormula;}
            orderDtlEntity.setProductCount(productCount);

            //变更后-订购数量(newOrderCount) 计量单位
            BigDecimal newOrderCountByProdUnit = productCount;

            //oldLockCount 变更前-锁定货品数量(计量单位)
            BigDecimal oldLockCount = BigDecimal.valueOf(0D);
            if (orderDtlEntity.getLockCount() != null) {
                oldLockCount = orderDtlEntity.getLockCount();
            }
            orderDtlEntity.setOldLockCount(oldLockCount);

            //变更后订购数量(计量单位) < 锁定货品数量(计量单位)
            if (oldLockCount.doubleValue() != 0D && newOrderCountByProdUnit.doubleValue() < oldLockCount.doubleValue()) {
                //newLockCount 变更后-锁定货品数量(计量单位)
                BigDecimal newLockCount = newOrderCountByProdUnit;
                if (newLockCount != null && newLockCount.doubleValue() != 0D) {
                    //四舍五入到2位小数
                    newLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    orderDtlEntity.setNewLockCount(newLockCount);
                }
            }

            objectList.add(orderDtlEntity);
        }

        return objectList;
    }

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 2:待生产 readyProduce
     * 修改订单明细(订购数量,金额,货品数量(计量单位))
     *
     * @param objectList
     */
    public void orderChangeByReadyProduce(List<SaleOrderDetailEntity> objectList) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}
        //2:待生产
        List<SaleOrderDetailEntity> readyProduceList = this.findOrderDetailListByState(objectList, "2");
        if (readyProduceList == null || readyProduceList.size() == 0) {return;}

        for (SaleOrderDetailEntity orderDtlEntity : readyProduceList) {
            SaleOrderDetail orderDtl = new SaleOrderDetail();
            orderDtl.setId(orderDtlEntity.getId());

            //orderCount 订购数量
            orderDtl.setOrderCount(orderDtlEntity.getOrderCount());
            orderDtl.setPriceCount(orderDtlEntity.getOrderCount());
            //productSum 金额
            orderDtl.setProductSum(orderDtlEntity.getProductSum());

            //productCount 货品数量(计量数量)
            orderDtl.setProductCount(orderDtlEntity.getProductCount());

            saleOrderDetailService.update(orderDtl);
        }
    }

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 3:待出库 readyOut
     *
     * 修改订单明细(订购数量,金额,货品数量(计量单位),可发货数量(计价单位),锁定货品数量(计量单位))
     * 修改货品表(lockCount:lock_count:锁定库存数量)
     *
     * @param objectList
     */
    public void orderChangeByReadyOut(List<SaleOrderDetailEntity> objectList, String companyId) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}
        //3:待出库
        List<SaleOrderDetailEntity> readyOutList = this.findOrderDetailListByState(objectList, "3");
        if (readyOutList == null || readyOutList.size() == 0) {return;}

        //获取企业id对应的锁定库存时长(毫秒)
        Long lockTime = saleLockDateService.findLockDateMillisecondByCompanyId(companyId);

        for (SaleOrderDetailEntity orderDtlEntity : readyOutList) {
            SaleOrderDetail orderDtl = this.orderDtlEntity2OrderDtl(orderDtlEntity, null);

            //newLockCount 变更后-锁定货品数量(计量单位)
            BigDecimal newLockCount = orderDtlEntity.getNewLockCount();
            if (newLockCount != null) {
                //oldLockCount 变更前-锁定货品数量(计量单位)
                BigDecimal oldLockCount = orderDtlEntity.getOldLockCount();
                BigDecimal changeLockCount = BigDecimal.valueOf(newLockCount.doubleValue() - oldLockCount.doubleValue());

                //productId 货品ID
                String productId = orderDtlEntity.getProductId();

                //修改锁定库存数量
                Product oldProduct = new Product();
                oldProduct.setId(productId);
                oldProduct.setLockCount(oldLockCount);
                productService.updateLockCount(
                        productId,
                        oldProduct,
                        changeLockCount,
                        null);

                //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定)
                orderDtl.setIsLockWarehouse("1");
                //lockCount 锁定货品数量(计量单位)
                orderDtl.setLockCount(newLockCount);

                //versionLockCount
                Integer versionLockCount = orderDtlEntity.getVersionLockCount();

                if (versionLockCount != null) {
                    versionLockCount = Integer.valueOf(versionLockCount.intValue() + 1);
                    orderDtl.setVersionLockCount(versionLockCount);

                    //信息队列信息:(订单明细id,锁定库存版本号,,)
                    String orderDtl_activeMQ_temp = "{0},{1}";
                    String orderDtl_activeMQ_msg = MessageFormat.format(orderDtl_activeMQ_temp,
                            orderDtl.getId(),
                            orderDtl.getVersionLockCount());

                    //发送消息队列信息
                    if (lockTime != null && lockTime.longValue() > 0) {
                        firstSender.sendMsg(orderDtl_activeMQ_msg, lockTime.intValue());
                    }
                }
            }

            saleOrderDetailService.update(orderDtl);
        }
    }

    /**
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
     * 4:待发货 readyDeliver
     *
     * 修改订单明细(订购数量,金额,货品数量(计量单位),可发货数量(计价单位),锁定货品数量(计量单位))
     * 修改货品表(lockCount:lock_count:锁定库存数量)
     *
     * @param objectList
     * @param companyId
     */
    public void orderChangeByReadyDeliver(List<SaleOrderDetailEntity> objectList, String companyId) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}
        //4:待发货
        List<SaleOrderDetailEntity> readyDeliverList = this.findOrderDetailListByState(objectList, "4");
        if (readyDeliverList == null || readyDeliverList.size() == 0) {return;}

        //获取企业id对应的锁定库存时长(毫秒)
        Long lockTime = saleLockDateService.findLockDateMillisecondByCompanyId(companyId);

        for (SaleOrderDetailEntity orderDtlEntity : readyDeliverList) {
            SaleOrderDetail orderDtl = this.orderDtlEntity2OrderDtl(orderDtlEntity, null);

            //newLockCount 变更后-锁定货品数量(计量单位)
            BigDecimal newLockCount = orderDtlEntity.getNewLockCount();
            if (newLockCount != null) {
                //oldLockCount 变更前-锁定货品数量(计量单位)
                BigDecimal oldLockCount = orderDtlEntity.getOldLockCount();
                BigDecimal changeLockCount = BigDecimal.valueOf(newLockCount.doubleValue() - oldLockCount.doubleValue());

                //productId 货品ID
                String productId = orderDtlEntity.getProductId();

                //修改锁定库存数量
                Product oldProduct = new Product();
                oldProduct.setId(productId);
                oldProduct.setLockCount(oldLockCount);
                productService.updateLockCount(
                        productId,
                        oldProduct,
                        changeLockCount,
                        null);

                //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定)
                orderDtl.setIsLockWarehouse("1");
                //lockCount 锁定货品数量(计量单位)
                orderDtl.setLockCount(newLockCount);

                //versionLockCount
                Integer versionLockCount = orderDtlEntity.getVersionLockCount();

                if (versionLockCount != null) {
                    versionLockCount = Integer.valueOf(versionLockCount.intValue() + 1);
                    orderDtl.setVersionLockCount(versionLockCount);

                    //信息队列信息:(订单明细id,锁定库存版本号,,)
                    String orderDtl_activeMQ_temp = "{0},{1}";
                    String orderDtl_activeMQ_msg = MessageFormat.format(orderDtl_activeMQ_temp,
                            orderDtl.getId(),
                            orderDtl.getVersionLockCount());

                    //发送消息队列信息
                    if (lockTime != null && lockTime.longValue() > 0) {
                        firstSender.sendMsg(orderDtl_activeMQ_msg, lockTime.intValue());
                    }
                }
            }

            saleOrderDetailService.update(orderDtl);
        }

//        //(订单id, 0:待发货) 查询发货明细表(vmes_sale_deliver_detail)
//        //发货明细状态(0:待发货 1:已发货 -1:已取消)
//        List<Map<String, Object>> mapList = saleDeliverOutDetailService.findDeliverDetailListByOrderId(orderId, "0");
//
//        //获取出库单Map
//        Map<String, Map<String, String>> warehouseOutMap = this.findWarehouseOutMap(mapList);
//        if (warehouseOutMap == null || warehouseOutMap.size() == 0) {return;}
//        for (Iterator firstIterator = warehouseOutMap.keySet().iterator(); firstIterator.hasNext();) {
//            //出库单ID
//            String outId = (String) firstIterator.next();
//            String remark = "订单(订购数量)变更，取消该出库单";
//
//            Map<String, String> outDtlMap = warehouseOutMap.get(outId);
//            for (Iterator secondIterator = outDtlMap.keySet().iterator(); secondIterator.hasNext();) {
//                //出库单明细ID
//                String outDtlId = (String) secondIterator.next();
//
//                PageData pageData = new PageData();
//                pageData.put("id", outDtlId);
//                pageData.put("cuser", cuser);
//                pageData.put("currentCompanyId", companyId);
//                pageData.put("rebackBillReason", remark);
//                warehouseOutDetailService.rebackWarehouseOutDetail(pageData);
//
//                WarehouseOutDetail outDetail = new WarehouseOutDetail();
//                outDetail.setId(outDtlId);
//                //出库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//                outDetail.setState("-1");
//                warehouseOutDetailService.update(outDetail);
//            }
//
//            WarehouseOut warehouseOut = new WarehouseOut();
//            warehouseOut.setId(outId);
//            warehouseOut.setRemark(remark);
//            //出库状态(0:未完成 1:已完成 -1:已取消)
//            warehouseOut.setState("-1");
//            warehouseOutService.update(warehouseOut);
//        }

//        //获取发货单Map
//        Map<String, Map<String, String>> deliverMap = this.findDeliverMap(mapList);
//        if (deliverMap == null || deliverMap.size() == 0) {return;}
//        for (Iterator firstIterator = deliverMap.keySet().iterator(); firstIterator.hasNext();) {
//            //发货单ID
//            String deliverId = (String) firstIterator.next();
//            String remark = "订单(订购数量)变更，取消该发货单";
//
//            Map<String, String> deliverDtlMap = deliverMap.get(deliverId);
//            for (Iterator secondIterator = deliverDtlMap.keySet().iterator(); secondIterator.hasNext();) {
//                //发货单明细ID
//                String deliverDtlId = (String) secondIterator.next();
//
//                SaleDeliverDetail deliverDetail = new SaleDeliverDetail();
//                deliverDetail.setId(deliverDtlId);
//                //发货明细状态(0:待发货 1:已发货 -1:已取消)
//                deliverDetail.setState("-1");
//                deliverDetail.setRemark(remark);
//                saleDeliverDetailService.update(deliverDetail);
//            }
//
//            SaleDeliver deliver = new SaleDeliver();
//            deliver.setId(deliverId);
//            //发货状态(0:待发货 1:已发货 -1:已取消)
//            deliver.setState("-1");
//            deliver.setRemark(remark);
//            saleDeliverService.update(deliver);
//        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private List<SaleOrderDetailEntity> findOrderDetailListByState(List<SaleOrderDetailEntity> objectList, String state) {
        List<SaleOrderDetailEntity> outList = new ArrayList<SaleOrderDetailEntity>();
        if (objectList == null || objectList.size() == 0) {return outList;}
        if (state == null || state.trim().length() == 0) {return outList;}

        for (SaleOrderDetailEntity entity : objectList) {
            if (state.equals(entity.getState())) {
                outList.add(entity);
            }
        }

        return outList;
    }

    private SaleOrderDetail orderDtlEntity2OrderDtl(SaleOrderDetailEntity orderDtlEntity, SaleOrderDetail orderDtl) {
        if (orderDtl == null) {orderDtl = new SaleOrderDetail();}
        if (orderDtlEntity == null) {return orderDtl;}

        orderDtl.setId(orderDtlEntity.getId());

        //修改订单属性
        //orderCount 订购数量
        orderDtl.setOrderCount(orderDtlEntity.getOrderCount());
        orderDtl.setPriceCount(orderDtlEntity.getOrderCount());
        //productSum 金额
        orderDtl.setProductSum(orderDtlEntity.getProductSum());
        //productCount 货品数量(计量单位)
        orderDtl.setProductCount(orderDtlEntity.getProductCount());

        //needDeliverCount 可发货数量(计价单位)
        if (orderDtlEntity.getNeedDeliverCount() != null) {
            orderDtl.setNeedDeliverCount(orderDtlEntity.getNeedDeliverCount());

            //lockCount 锁定货品数量(计量单位) := newLockCount 变更后-锁定货品数量(计量单位)
            orderDtl.setLockCount(orderDtlEntity.getNewLockCount());

            //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定)
            if (orderDtl.getNeedDeliverCount() != null && orderDtl.getNeedDeliverCount().doubleValue() > 0) {
                orderDtl.setIsLockWarehouse("1");
            }
        }

        return orderDtl;
    }

    /**
     * 生成出库单 Map<出库单id,Map<出库单明细id,出库单明细id>
     *
     * @param mapList 订单明细查询结果集
     * @return
     */
    private Map<String, Map<String, String>> findWarehouseOutMap(List<Map<String, Object>> mapList) {
        Map<String, Map<String, String>> warehouseOutMap = new HashMap<String, Map<String, String>>();
        if (mapList == null || mapList.size() == 0) {return warehouseOutMap;}

        for (Map<String, Object> mapObject : mapList) {
            String outId = (String)mapObject.get("outId");
            String outDtlId = (String)mapObject.get("outDtlId");

            if (warehouseOutMap.get(outId) == null) {
                Map<String, String> outDtlMap = new HashMap<String, String>();
                outDtlMap.put(outDtlId, outDtlId);
                warehouseOutMap.put(outId, outDtlMap);
            } else if (warehouseOutMap.get(outId) != null) {
                Map<String, String> outDtlMap = warehouseOutMap.get(outId);
                outDtlMap.put(outDtlId, outDtlId);
                warehouseOutMap.put(outId, outDtlMap);
            }
        }

        return warehouseOutMap;
    }

    /**
     * 生成发货单 Map<发货单id, Map<发货单明细id,发货单明细id>>
     *
     * @param mapList 订单明细查询结果集
     * @return
     */
    private Map<String, Map<String, String>> findDeliverMap(List<Map<String, Object>> mapList) {
        Map<String, Map<String, String>> deliverMap = new HashMap<String, Map<String, String>>();
        if (mapList == null || mapList.size() == 0) {return deliverMap;}

        for (Map<String, Object> mapObject : mapList) {
            String deliverId = (String)mapObject.get("deliverId");
            String deliverDtlId = (String)mapObject.get("deliverDtlId");

            if (deliverMap.get(deliverId) == null) {
                Map<String, String> deliverDtlMap = new HashMap<String, String>();
                deliverDtlMap.put(deliverDtlId, deliverDtlId);
                deliverMap.put(deliverId, deliverDtlMap);
            } else if (deliverMap.get(deliverId) != null) {
                Map<String, String> deliverDtlMap = deliverMap.get(deliverId);
                deliverDtlMap.put(deliverDtlId, deliverDtlId);
                deliverMap.put(deliverId, deliverDtlMap);
            }
        }

        return deliverMap;
    }
}
