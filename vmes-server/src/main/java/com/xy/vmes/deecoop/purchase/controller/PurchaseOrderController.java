package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.entity.*;
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
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;


/**
* 说明：vmes_purchase_order:采购订单Controller
* @author 刘威 自动生成
* @date 2019-03-05
*/
@RestController
@Slf4j
public class PurchaseOrderController {

    private Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    private PurchaseSignService purchaseSignService;

    @Autowired
    private PurchasePlanService purchasePlanService;
    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;
    @Autowired
    private PurchaseOrderDetailToolService purchaseOrderDetailToolService;

    @Autowired
    private PurchasePaymentService purchasePaymentService;
    @Autowired
    private PurchasePaymentDetailService purchasePaymentDetailService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @GetMapping("/purchase/purchaseOrder/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseOrder/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchaseOrder purchaseOrder = purchaseOrderService.selectById(id);
        model.putResult(purchaseOrder);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrder/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchaseOrder/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseOrder purchaseOrder = (PurchaseOrder)HttpUtils.pageData2Entity(pd, new PurchaseOrder());
        purchaseOrderService.save(purchaseOrder);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrder/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchaseOrder/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchaseOrder purchaseOrder = (PurchaseOrder)HttpUtils.pageData2Entity(pd, new PurchaseOrder());
        purchaseOrderService.update(purchaseOrder);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-03-05
    */
    @GetMapping("/purchase/purchaseOrder/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchaseOrder/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchaseOrderService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrder/listPagePurchaseOrders")
    public ResultModel listPagePurchaseOrders()  throws Exception {
        logger.info("################/purchase/purchaseOrder/listPagePurchaseOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchaseOrderService.listPagePurchaseOrders(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/listPagePurchaseOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrder/exportExcelPurchaseOrders")
    public void exportExcelPurchaseOrders() throws Exception {
        logger.info("################/purchase/purchaseOrder/exportExcelPurchaseOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchaseOrderService.exportExcelPurchaseOrders(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/exportExcelPurchaseOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-03-05
    */
    @PostMapping("/purchase/purchaseOrder/importExcelPurchaseOrders")
    public ResultModel importExcelPurchaseOrders(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchaseOrder/importExcelPurchaseOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchaseOrderService.importExcelPurchaseOrders(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/importExcelPurchaseOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/deletePurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deletePurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/deletePurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.deletePurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/deletePurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/recoveryPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/recoveryPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.recoveryPurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/recoveryPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/cancelPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/cancelPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.cancelPurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/cancelPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/submitPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/submitPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.submitPurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/submitPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/auditPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/auditPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.auditPurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/auditPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 退回
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchaseOrder/rebackPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/rebackPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.rebackPurchaseOrder(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/rebackPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchaseOrder/addPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addPurchaseOrder()  throws Exception {

        logger.info("################/purchase/purchaseOrder/addPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.addPurchaseOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/addPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchaseOrder/addReceipt")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addReceipt()  throws Exception {

        logger.info("################/purchase/purchaseOrder/addReceipt 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.addReceipt(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/addReceipt 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchaseOrder/editPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel editPurchaseOrder()  throws Exception {

        logger.info("################/purchase/purchaseOrder/editPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = purchaseOrderService.editPurchaseOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/editPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * @author 刘威 自动创建，禁止修改
//     * @date 2019-02-28
//     */
//    @PostMapping("/purchase/purchaseOrder/signPurchaseOrder")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel signPurchaseOrder()  throws Exception {
//
//        logger.info("################/purchase/purchaseOrder/signPurchaseOrder 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        ResultModel model = purchaseOrderService.signPurchaseOrder(pd);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/purchase/purchaseOrder/signPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 采购订单签收
     * 1. 创建入库单-(根据用户角色菜单)-创建(复杂版,简版)入库单
     * 2. 创建采购签收单-(采购签收单,采购签收明细)
     * 3. 修改采购订单明细状态-根据(采购订单明细id,采购数量,到货数量)
     * 4. 采购订单签收完成时-创建正值的付款单
     *
     * @author 刘威 自动创建，禁止修改
     * @date 2019-02-28
     */
    @PostMapping("/purchase/purchaseOrder/signPurchaseOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel signPurchaseOrder() throws Exception {
        logger.info("################/purchase/purchaseOrder/signPurchaseOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //创建(复杂版,简版)仓库-入库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
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

        //仓库id
        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库id为空或空字符串！");
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
        String purchaseOrderId = pageData.getString("purchaseOrderId");
        if (purchaseOrderId == null || purchaseOrderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购订单id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 创建入库单////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, Map<String, Object>> productByInMap = purchaseOrderService.findProductMapByIn(jsonMapList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInByComplex(supplierId,
                    supplierName,
                    warehouseId,
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    productByInMap);

        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBySimple(supplierId,
                    supplierName,
                    warehouseId,
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    productByInMap);
        }

        //2. 创建采购签收单
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("productByInMap", productByInMap);
        valueMap.put("jsonMapList", jsonMapList);
        purchaseSignService.createPurchaseSign(cuser,
                companyId,
                purchaseOrderId,
                valueMap);

        //3. 修改采购订单明细状态-根据(采购订单明细id,采购数量,到货数量)

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
                }
            }
        }

        //修改采购订单状态
        purchaseOrderService.updateState(purchaseOrderId);

        //4. 采购订单签收完成时-创建正值的付款单
        PurchaseOrder purchaseOrder = purchaseOrderService.selectById(purchaseOrderId);
        //状态(0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消)
        if ("3".equals(purchaseOrder.getState())) {
            //付款单类型(1:订单付款 2:订单退款)
            PurchasePayment payment = purchasePaymentService.createPayment(purchaseOrder.getSupplierId(),
                    purchaseOrder.getCuser(),
                    purchaseOrder.getCompanyId(),
                    "1");
            //付款金额 paymentSum := amount 采购订单.采购金额(合计金额 - 折扣金额)
            payment.setPaymentSum(purchaseOrder.getAmount());
            purchasePaymentService.save(payment);

            //2. 创建收款单明细
            //获取 <订单id, 退货金额>
            PurchasePaymentDetail paymentDtl = new PurchasePaymentDetail();
            paymentDtl.setOrderId(purchaseOrder.getId());
            //状态(0:待付款 1:已付款 -1:已取消)
            paymentDtl.setState("1");
            //paymentSum 实付金额
            paymentDtl.setPaymentSum(purchaseOrder.getAmount());
            //discountAmount 折扣金额
            paymentDtl.setDiscountAmount(BigDecimal.valueOf(0D));

            List<PurchasePaymentDetail> paymentDtlList = new ArrayList<PurchasePaymentDetail>();
            paymentDtlList.add(paymentDtl);
            purchasePaymentDetailService.addPaymentDetail(payment, paymentDtlList);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/signPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



