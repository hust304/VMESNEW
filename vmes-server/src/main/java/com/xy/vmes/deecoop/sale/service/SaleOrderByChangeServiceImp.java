package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderByChangeServiceImp implements SaleOrderByChangeService {
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverOutDetailService saleDeliverOutDetailService;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private ProductService productService;

    /**
     * 变更订单-变更订单明细(订购数量,锁定货品数量)
     * dtlJsonStr: 界面(model_code = 'saleOrderDetailByChange')
     *
     * 订单单明细表
     * id: rowData.id,
     * parentId: rowData.parentId,
     * productId: rowData.productId,
     * productPrice: rowData.productPrice,
     * lockCount: rowData.lockCount,
     * state: rowData.state,

     * newOrderCount: rowData.newOrderCount,
     * newNeedDeliverCount: rowData.newNeedDeliverCount,
     * p2nFormula: rowData.p2nFormula,
     * n2pFormula: rowData.n2pFormula
     * stockCount: rowData.stockCount
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel updateSaleOrderByChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

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

        List<SaleOrderDetailEntity> orderDtlEntityList = this.orderChangeMapList2OrderDtlList(mapList, null);

        //2:待生产
        this.orderChangeByReadyProduce(orderDtlEntityList);
        //3:待出库
        this.orderChangeByReadyOut(orderDtlEntityList);
        //4:待发货
        this.orderChangeByReadyDeliver(orderId, cuser, companyId, orderDtlEntityList);

        List<SaleOrderDetail> orderDtlList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
        saleOrderDetailService.updateDetailStateByOrderId(orderId, orderDtlList);

        SaleOrder order = new SaleOrder();
        order.setId(orderId);
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByPrice(orderDtlList);
        order.setTotalSum(totalSum);
        saleOrderService.update(order);

        return model;
    }

    public List<SaleOrderDetailEntity> orderChangeMapList2OrderDtlList(List<Map<String, String>> mapList, List<SaleOrderDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetailEntity orderDtlEntity = (SaleOrderDetailEntity) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetailEntity());

            //newOrderCount 变更订购数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            String newOrderCount_Str = mapObject.get("newOrderCount");
            if (newOrderCount_Str != null && newOrderCount_Str.trim().length() > 0) {
                try {
                    orderCount = new BigDecimal(newOrderCount_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDtlEntity.setOrderCount(orderCount);
            orderDtlEntity.setPriceCount(orderCount);

            //productPrice 单价
            BigDecimal productPrice = BigDecimal.valueOf(0D);
            String productPrice_Str = mapObject.get("productPrice");
            if (productPrice_Str != null && productPrice_Str.trim().length() > 0) {
                try {
                    productPrice = new BigDecimal(productPrice_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //productSum 金额
            BigDecimal productSum = BigDecimal.valueOf(productPrice.doubleValue() * orderCount.doubleValue());
            //四舍五入到2位小数
            productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDtlEntity.setProductSum(productSum);

            //p2nFormula 单位转换公式:计价单位转换计量单位
            String p2nFormula = mapObject.get("p2nFormula");
            //productCount 货品数量(计量数量)
            BigDecimal productCount = EvaluateUtil.countFormulaP2N(orderCount, p2nFormula);
            orderDtlEntity.setProductCount(productCount);

            //oldLockCount 变更前-锁定货品数量(计量单位)
            orderDtlEntity.setOldLockCount(orderDtlEntity.getLockCount());

            //newNeedDeliverCount 变更锁定货品数量
            BigDecimal newNeedDeliverCount = null;
            String newNeedDeliverCount_Str = mapObject.get("newNeedDeliverCount");
            if (newNeedDeliverCount_Str != null && newNeedDeliverCount_Str.trim().length() > 0) {
                try {
                    newNeedDeliverCount = new BigDecimal(newNeedDeliverCount_Str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (newNeedDeliverCount != null) {
                //四舍五入到2位小数
                newNeedDeliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                orderDtlEntity.setNeedDeliverCount(newNeedDeliverCount);

                //newLockCount 变更后-锁定货品数量(计量单位)
                BigDecimal newLockCount = EvaluateUtil.countFormulaP2N(newNeedDeliverCount, p2nFormula);
                orderDtlEntity.setNewLockCount(newLockCount);
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
    public void orderChangeByReadyOut(List<SaleOrderDetailEntity> objectList) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}
        //3:待出库
        List<SaleOrderDetailEntity> readyOutList = this.findOrderDetailListByState(objectList, "3");
        if (readyOutList == null || readyOutList.size() == 0) {return;}

        for (SaleOrderDetailEntity orderDtlEntity : readyOutList) {
            SaleOrderDetail orderDtl = this.orderDtlEntity2OrderDtl(orderDtlEntity, null);

            //newNeedDeliverCount 变更锁定货品数量
            BigDecimal newNeedDeliverCount = orderDtlEntity.getNeedDeliverCount();
            if (newNeedDeliverCount != null) {
                //newLockCount 变更后-锁定货品数量(计量单位)
                BigDecimal newLockCount = orderDtlEntity.getNewLockCount();
                //oldLockCount 变更前-锁定货品数量(计量单位)
                BigDecimal oldLockCount = orderDtlEntity.getOldLockCount();
                BigDecimal changeLockCount = BigDecimal.valueOf(newLockCount.doubleValue() - oldLockCount.doubleValue());

                //stockCount 当前库存数量
                BigDecimal stockCount = orderDtlEntity.getStockCount();
                //productId 货品ID
                String productId = orderDtlEntity.getProductId();

                //修改锁定库存数量
                Product oldProduct = new Product();
                oldProduct.setId(productId);
                oldProduct.setLockCount(stockCount);
                productService.updateLockCount(
                        productId,
                        oldProduct,
                        changeLockCount,
                        null);
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
     * 取消出库单
     * 取消发货单
     *
     * @param orderId
     * @param cuser
     * @param companyId
     * @param objectList
     */
    public void orderChangeByReadyDeliver(String orderId, String cuser, String companyId, List<SaleOrderDetailEntity> objectList) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}
        //4:待发货
        List<SaleOrderDetailEntity> readyDeliverList = this.findOrderDetailListByState(objectList, "4");
        if (readyDeliverList == null || readyDeliverList.size() == 0) {return;}

        for (SaleOrderDetailEntity orderDtlEntity : readyDeliverList) {
            SaleOrderDetail orderDtl = this.orderDtlEntity2OrderDtl(orderDtlEntity, null);

            //newLockCount 变更后-锁定货品数量(计量单位)
            BigDecimal newLockCount = orderDtlEntity.getNewLockCount();
            //oldLockCount 变更前-锁定货品数量(计量单位)
            BigDecimal oldLockCount = orderDtlEntity.getOldLockCount();
            BigDecimal changeLockCount = BigDecimal.valueOf(newLockCount.doubleValue() - oldLockCount.doubleValue());

            //stockCount 当前库存数量
            BigDecimal stockCount = orderDtlEntity.getStockCount();
            //productId 货品ID
            String productId = orderDtlEntity.getProductId();

            //修改锁定库存数量
            Product oldProduct = new Product();
            oldProduct.setId(productId);
            oldProduct.setLockCount(stockCount);
            productService.updateLockCount(
                    productId,
                    oldProduct,
                    changeLockCount,
                    null);

            saleOrderDetailService.update(orderDtl);
        }

        //(订单id, 0:待发货) 查询发货明细表(vmes_sale_deliver_detail)
        //发货明细状态(0:待发货 1:已发货 -1:已取消)
        List<Map<String, Object>> mapList = saleDeliverOutDetailService.findDeliverDetailListByOrderId(orderId, "0");

        //获取出库单Map
        Map<String, Map<String, String>> warehouseOutMap = this.findWarehouseOutMap(mapList);
        if (warehouseOutMap == null || warehouseOutMap.size() == 0) {return;}
        for (Iterator firstIterator = warehouseOutMap.keySet().iterator(); firstIterator.hasNext();) {
            //出库单ID
            String outId = (String) firstIterator.next();
            String remark = "订单(订购数量)变更，取消该出库单";

            Map<String, String> outDtlMap = warehouseOutMap.get(outId);
            for (Iterator secondIterator = outDtlMap.keySet().iterator(); secondIterator.hasNext();) {
                //出库单明细ID
                String outDtlId = (String) secondIterator.next();

                PageData pageData = new PageData();
                pageData.put("id", outDtlId);
                pageData.put("cuser", cuser);
                pageData.put("currentCompanyId", companyId);
                pageData.put("rebackBillReason", "rebackBillReason");
                warehouseOutDetailService.rebackWarehouseOutDetail(pageData);

                WarehouseOutDetail outDetail = new WarehouseOutDetail();
                outDetail.setId(outDtlId);
                //出库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                outDetail.setState("-1");
                warehouseOutDetailService.update(outDetail);
            }

            WarehouseOut warehouseOut = new WarehouseOut();
            warehouseOut.setId(outId);
            warehouseOut.setRemark(remark);
            //出库状态(0:未完成 1:已完成 -1:已取消)
            warehouseOut.setState("-1");
            warehouseOutService.update(warehouseOut);
        }

        //获取发货单Map
        Map<String, Map<String, String>> deliverMap = this.findDeliverMap(mapList);
        if (deliverMap == null || deliverMap.size() == 0) {return;}
        for (Iterator firstIterator = deliverMap.keySet().iterator(); firstIterator.hasNext();) {
            //发货单ID
            String deliverId = (String) firstIterator.next();
            String remark = "订单(订购数量)变更，取消该发货单";

            Map<String, String> deliverDtlMap = deliverMap.get(deliverId);
            for (Iterator secondIterator = deliverDtlMap.keySet().iterator(); secondIterator.hasNext();) {
                //发货单明细ID
                String deliverDtlId = (String) secondIterator.next();

                SaleDeliverDetail deliverDetail = new SaleDeliverDetail();
                deliverDetail.setId(deliverDtlId);
                //发货明细状态(0:待发货 1:已发货 -1:已取消)
                deliverDetail.setState("-1");
                saleDeliverDetailService.update(deliverDetail);
            }

            SaleDeliver deliver = new SaleDeliver();
            deliver.setId(deliverId);
            //发货状态(0:待发货 1:已发货 -1:已取消)
            deliver.setState("-1");
            saleDeliverService.update(deliver);
        }
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
