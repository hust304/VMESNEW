package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.entity.PurchaseOrderDetail;
import com.xy.vmes.entity.PurchasePlanDetail;
import com.xy.vmes.entity.PurchaseRetreat;
import com.xy.vmes.entity.PurchaseRetreatDetail;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* 说明：vmes_purchase_retreat:退货单Controller
* @author 陈刚 自动生成
* @date 2019-05-09
*/
@RestController
@Slf4j
public class PurchaseRetreatController {

    private Logger logger = LoggerFactory.getLogger(PurchaseRetreatController.class);

    @Autowired
    private PurchasePlanService purchasePlanService;
    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

    @Autowired
    private PurchaseRetreatService purchaseRetreatService;
    @Autowired
    private PurchaseRetreatDetailService purchaseRetreatDetailService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;
    @Autowired
    private PurchaseOrderDetailToolService purchaseOrderDetailToolService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-05-09
    */
    @PostMapping("/purchase/purchaseRetreat/listPageRetreat")
    public ResultModel listPageRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/listPageRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseRetreatService.listPageRetreat(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/listPageRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增退货单
     * @author 陈刚
     * @date 2019-02-25
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseRetreat/addPurchaseRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addPurchaseRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/addPurchaseRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseRetreatService.addPurchaseRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/addPurchaseRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核通过(退货单)
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseRetreat/auditPassPurchaseRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassPurchaseRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/auditPassPurchaseRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //创建(复杂版,简版)仓库-出库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }
        //供应商(供应商id,供应商名称)
        String supplierName = pageData.getString("supplierName");
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        //业务相关参数////////////////////////////////////////////////////////////////////////////////////////////////////////
        String cuser = pageData.getString("cuser");
        String retreatId = pageData.getString("retreatId");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //退货总额:实际退货金额
        BigDecimal realityTotal_big = BigDecimal.valueOf(0D);
        String realityTotal = pageData.getString("realityTotal");
        if (realityTotal == null || realityTotal.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货总额为空或空字符串！");
            return model;
        }

        //实际退货金额 审核界面获得
        if (realityTotal != null && realityTotal.trim().length() > 0) {
            try {
                realityTotal_big = new BigDecimal(realityTotal);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无列表数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 创建出库单////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 货品入库Map<货品id, 货品Map<String, Object>>
        // 货品Map<String, Object>
        //     productId: 货品id
        //     outDtlId:   出库明细id
        //     outCount:   出库数量
        Map<String, Map<String, Object>> productByOutMap = purchaseRetreatService.findProductMapByOut(jsonMapList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseOutCreateService.createWarehouseOutByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //4cba5d3815644b26920777512a20474b 采购退货出库:purchaseOut
                    Common.DICTIONARY_MAP.get("purchaseOut"),
                    productByOutMap);

        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseOutCreateService.createWarehouseOutBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //4cba5d3815644b26920777512a20474b 采购退货出库:purchaseOut
                    Common.DICTIONARY_MAP.get("purchaseOut"),
                    productByOutMap);
        }

        //2. 修改退货单明细 (退货单明细(关联)出库单明细)/////////////////////////////////////////////////////////////////////////////////
        for (Map<String, String> jsonObject : jsonMapList) {
            PurchaseRetreatDetail detailEdit = new PurchaseRetreatDetail();

            //id: 退货单明细id,
            String retreatDtl_id = jsonObject.get("id");
            detailEdit.setId(retreatDtl_id);

//            //count: 退货数量
//            BigDecimal count = BigDecimal.valueOf(0D);
//            String count_str = jsonObject.get("count");
//            if (count_str != null && count_str.trim().length() > 0) {
//                try {
//                    count = new BigDecimal(count_str.trim());
//                    //四舍五入到2位小数
//                    count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            detailEdit.setCount(count);
//
//            //price: 货品单价
//            BigDecimal price = BigDecimal.valueOf(0D);
//            String price_str = jsonObject.get("price");
//            if (price_str != null && price_str.trim().length() > 0) {
//                try {
//                    price = new BigDecimal(price_str.trim());
//                    //四舍五入到2位小数
//                    price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //amount: 退货金额 := 退货数量 * 货品单价
//            BigDecimal amount = BigDecimal.valueOf(count.doubleValue() * price.doubleValue());
//            //四舍五入到2位小数
//            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            detailEdit.setAmount(amount);

            //(关联)出库单明细
            String productId = jsonObject.get("productId");
            if (productByOutMap != null && productByOutMap.get(productId) != null) {
                Map<String, Object> productOutMap = productByOutMap.get(productId);
                detailEdit.setOutDetailId((String)productOutMap.get("outDtlId"));
            }

            //退货单明细状态(1:待审核 2:待退货 3:已完成 -1:已取消)
            detailEdit.setState("3");
            purchaseRetreatDetailService.update(detailEdit);
        }

        //修改退货单
        PurchaseRetreat retreatEdit = new PurchaseRetreat();
        retreatEdit.setId(retreatId);
        //审核人ID
        retreatEdit.setAuditId(cuser);
        //状态(1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatEdit.setState("3");
//        //退货总额:实际退货金额
//        if (realityTotal_big.doubleValue() != 0) {
//            //四舍五入到2位小数
//            realityTotal_big = realityTotal_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            retreatEdit.setRealityTotal(realityTotal_big);
//        }
        purchaseRetreatService.update(retreatEdit);

        //3. 修改采购订单明细(订购数量,货品金额)////////////////////////////////////////////////////////////////////////////////////////////
        //获取退货单表对象-根据退货单id查询(vmes_purchase_retreat)
        PurchaseRetreat retreat = purchaseRetreatService.findPurchaseRetreatById(retreatId);
        //采购订单id
        String purchaseOrderId = retreat.getOrderId();

        //根据(退货单id)-获取退货单明细List
        List<PurchaseRetreatDetail> retreatDtlList = purchaseRetreatDetailService.findPurchaseRetreatDetailListByParentId(retreatId);
        //获取 <采购订单明细id, <采购订单明细退货信息Map(count:退货数量,amount:退货金额)>
        Map<String, Map<String, BigDecimal>> orderDtlRetreatMap = purchaseRetreatDetailService.findOrderDtlRetreatCountMap(retreatDtlList);
        //获取采购订单明细id字符串-(','逗号分隔字符串)
        String orderDtlIds = purchaseRetreatDetailService.findOrderDtlIdsByRetreatDtlList(retreatDtlList);
        if (orderDtlIds == null || orderDtlIds.trim().length() == 0) {
            return model;
        }

        PageData findMap = new PageData();
        orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
        findMap.put("ids", orderDtlIds);
        List<PurchaseOrderDetail> orderDtlList = purchaseOrderDetailService.findPurchaseOrderDetailList(findMap);
        if (orderDtlList == null || orderDtlList.size() == 0) {
            return model;
        }

        //根据退货类型
        //retreatRefund: f69839bbf2394846a65894f0da120df9 退货退款
        //retreatChange: c90c2081328c427e8d65014d98335601 退货换货
        if (Common.DICTIONARY_MAP.get("retreatRefund").equals(retreat.getType())) {
            //退货类型:= (f69839bbf2394846a65894f0da120df9)退货退款
            //修改采购订单明细-变更订单明细(订购数量,货品金额)
            Map<String, Object> valueMap = new HashMap<String, Object>();
            valueMap.put("retreatId", retreatId);
            valueMap.put("realityTotal", realityTotal_big);
            valueMap.put("orderDtlRetreatMap", orderDtlRetreatMap);
            valueMap.put("orderDtlList", orderDtlList);
            purchaseRetreatService.updatePurchaseOrder(valueMap);

            //创建(负值)的付款单
            purchaseRetreatService.createPurchasePaymentByMinus(realityTotal_big,
                    supplierId,
                    companyId,
                    retreat.getOrderId(),
                    cuser);
        }

        //4. 修改采购订单明细状态-根据(采购订单明细id,采购数量,到货数量)////////////////////////////////////////////////////////////////////////////////////////////
//获取(采购数量,签收数量,退货数量[已完成])
//Map<采购订单明细id, 采购明细Map<String, Object>>
//采购明细Map<String, Object>
//    detailId: 采购订单明细id
//    parentId: 采购订单id
//    detailCount: 采购数量
//    signCount: 签收数量
//    retreatCount: 退货数量(已完成)
//    arriveCount: 到货数量:= 签收数量 - 退货数量(已完成)
        Map<String, Map<String, Object>> detailMap = purchaseOrderDetailToolService.findPurchaseOrderDetailMap(purchaseOrderId);
        //修改采购订单明细
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> jsonObject : jsonMapList) {
                String orderDetailId = jsonObject.get("orderDetailId");
                Map<String, Object> detailValue = detailMap.get(orderDetailId);

                //detailCount: 采购数量
                BigDecimal detailCount = BigDecimal.valueOf(0D);
                if (detailValue.get("detailCount") != null) {
                    detailCount = (BigDecimal)detailValue.get("detailCount");
                }

                //arriveCount 到货数量:= 签收数量 - 退货数量(已完成)
                BigDecimal arriveCount = BigDecimal.valueOf(0D);
                if (detailValue.get("detailCount") != null) {
                    arriveCount = (BigDecimal)detailValue.get("arriveCount");
                }

                //状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
                PurchaseOrderDetail detailEdit = new PurchaseOrderDetail();
                detailEdit.setId(orderDetailId);
                if (arriveCount.doubleValue() >= detailCount.doubleValue()) {
                    detailEdit.setState("4");
                } else {
                    detailEdit.setState("3");
                }
                purchaseOrderDetailService.update(detailEdit);

                //采购计划明细id planDtlId
                String planDtlId = jsonObject.get("planDtlId");
                if (planDtlId != null && planDtlId.trim().length() > 0
                    && "4".equals(detailEdit.getState())
                ) {
                    PurchasePlanDetail planDtlEdit = new PurchasePlanDetail();
                    planDtlEdit.setId(planDtlId);
                    //采购计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                    planDtlEdit.setState("4");
                    purchasePlanDetailService.update(planDtlEdit);

                    //采购计划id planId
                    String planId = jsonObject.get("planId");
                    if (planId != null && planId.trim().length() > 0) {
                        purchasePlanService.updateState(planId);
                    }
                } else if (planDtlId != null && planDtlId.trim().length() > 0
                    && "3".equals(detailEdit.getState())
                ) {
                    PurchasePlanDetail planDtlEdit = new PurchasePlanDetail();
                    planDtlEdit.setId(planDtlId);
                    //采购计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                    planDtlEdit.setState("3");
                    purchasePlanDetailService.update(planDtlEdit);

                    //采购计划id planId
                    String planId = jsonObject.get("planId");
                    if (planId != null && planId.trim().length() > 0) {
                        purchasePlanService.updateState(planId);
                    }
                }
            }
        }

        //修改采购订单状态
        purchaseOrderService.updateState(purchaseOrderId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/auditPassPurchaseRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退回)退货审核-审核不通过
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseRetreat/auditDisagreePurchaseRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreePurchaseRetreat() throws Exception {
        logger.info("################/purchase/purchaseRetreat/auditDisagreePurchaseRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseRetreatService.auditDisagreePurchaseRetreat(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseRetreat/auditDisagreePurchaseRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}



