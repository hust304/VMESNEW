package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.service.PurchaseOrderService;
import com.xy.vmes.entity.PurchaseOrder;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.RoleMenuService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


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
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private RoleMenuService roleMenuService;

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

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收单明细Json字符串-转换成List错误！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchaseOrder/signPurchaseOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



