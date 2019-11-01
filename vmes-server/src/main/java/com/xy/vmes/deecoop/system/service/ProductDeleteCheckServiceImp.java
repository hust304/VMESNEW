package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDeleteCheckServiceImp implements ProductDeleteCheckService {

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

    public String checkDeleteProduct(String id) throws Exception {
        //1.查询仓库货品表
        PageData findMap = new PageData();
        findMap.put("productId", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List objectList = warehouseProductService.findWarehouseProductList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        //2.(入库出库)明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}

        findMap.put("productId", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        objectList = warehouseOutDetailService.findWarehouseOutDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        //(入库)明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}

        findMap.put("productId", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        objectList = warehouseInDetailService.findWarehouseInDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        //3. 销售模块
        //发货明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}

        findMap.put("productId", id);
        objectList = saleDeliverDetailService.findSaleDeliverDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }
        //订单明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}

        findMap.put("productId", id);
        objectList = saleOrderDetailService.findSaleOrderDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        //4. 采购模块
        //采购计划明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}
        findMap.put("productId", id);
        objectList = purchasePlanDetailService.findPurchasePlanDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        //采购订单明细
        objectList.clear();
        if (findMap != null) {findMap.clear();}
        findMap.put("productId", id);
        objectList = purchaseOrderDetailService.findPurchaseOrderDetailList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return "该货品在系统中正在使用";
        }

        return new String();
    }
}
