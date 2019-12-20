package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_sale_deliver:发货表Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverController {
    private Logger logger = LoggerFactory.getLogger(SaleDeliverController.class);

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverOutDetailService saleDeliverOutDetailService;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseOutService outService;
    @Autowired
    private WarehouseOutDetailService outDetailService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;


    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliver/listPageSaleDeliver")
    public ResultModel listPageSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/listPageSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverService.listPageSaleDeliver(pd, pg);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/listPageSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/addSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/addSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.addSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/addSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货类型)-发货完成
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/updateSaleDeliverByDeliverType")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleDeliverByDeliverType() throws Exception {
        logger.info("################/sale/saleDeliver/updateSaleDeliverByDeliverType 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.updateSaleDeliverByDeliverType(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/updateSaleDeliverByDeliverType 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/cancelSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/cancelSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.cancelSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/cancelSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliver/deleteSaleDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleDeliver() throws Exception {
        logger.info("################/sale/saleDeliver/deleteSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.deleteSaleDeliver(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/deleteSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 验证发货单id(发货明细)List-是否全部出库完成
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/checkIsAllOutByDeliverId")
    public ResultModel checkIsAllOutByDeliverId() throws Exception {
        logger.info("################/sale/saleDeliver/checkIsAllOutByDeliverId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.checkIsAllOutByDeliverId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/checkIsAllOutByDeliverId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 验证发货单id(发货明细)List-(发货金额)是否为空
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliver/checkIsNullDeliverSumByDeliverId")
    public ResultModel checkIsNullDeliverSumByDeliverId() throws Exception {
        logger.info("################/sale/saleDeliver/checkIsNullDeliverSumByDeliverId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.checkIsNullDeliverSumByDeliverId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/checkIsNullDeliverSumByDeliverId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliver/checkIsAllNotNullDeliverSumByDeliverId")
    public ResultModel checkIsAllNotNullDeliverSumByDeliverId() throws Exception {
        logger.info("################/sale/saleDeliver/checkIsAllNotNullDeliverSumByDeliverId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverService.checkIsAllNotNullDeliverSumByDeliverId(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliver/checkIsAllNotNullDeliverSumByDeliverId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 发货单退库:
//     * 前置条件:发货单状态:= 0:待发货 And 出库单状态:= 1:已完成
//     *
//     * 1. 发货单明细生成入库单
//     * 2. 发货单明细对应的出库单状态变更为已退库
//     * 3. 发货单明细对应的订单明细状态变更为待出库
//     * 4. 取消发货单
//     *
//     * @return
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleDeliver/cancelDeliverWarehouse")
//    public ResultModel cancelDeliverWarehouse() throws Exception {
//        logger.info("################/sale/saleDeliver/cancelDeliverWarehouse 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        //创建(复杂版,简版)仓库-出库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
//        String cuser = pageData.getString("cuser");
//
//        String companyId = pageData.getString("currentCompanyId");
//        if (companyId == null || companyId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("企业id为空或空字符串！");
//            return model;
//        }
//
//        String roleId = pageData.getString("roleId");
//        if (roleId == null || roleId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("当前用户角色id为空或空字符串！");
//            return model;
//        }
//
//        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
//        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
//        if (warehouse == null || warehouse.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
//            return model;
//        }
//
//        String customerId = pageData.getString("customerId");
//        String customerName = pageData.getString("customerName");
//
//        String deliverId = pageData.getString("deliverId");
//        if (deliverId == null || deliverId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("发货单id为空或空字符串！");
//            return model;
//        }
//
//        //根据发货单id查询(发货单明细,出库单明细,订单明细)
//        //(发货单明细,出库单明细,订单明细)关联查询  SaleDeliverOutDetailMapper.findOutDetailByOrderDetail
//        //Sql查询语句见 SaleDeliverOutDetailMapper.xml
//        List<Map<String, Object>> mapList = saleDeliverOutDetailService.findDeliverDetailListByDeliverId(deliverId);
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //1. 发货单明细生成入库单
//
//        // 获取发货明细结构体<发货单明细id, 发货明细Map>
//        //   发货明细Map:
//        //     deliverDtlId: 发货单明细id
//        //     productId: 货品id
//        //     outDetailCount: 发货单明细id对应出库数量
//        Map<String, Map<String, Object>> deliverDtlMap = this.findDeliverDetailOutCount(mapList);
//
//        //生成入库单
//        //业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id(发货单明细id)
//        // 货品Map<String, Object>
//        //     productId: 货品id
//        //     inDtlId:   入库明细id
//        //     inCount:   入库数量
//        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();
//        if (deliverDtlMap != null && deliverDtlMap.size() > 0) {
//            for (Iterator iterator = deliverDtlMap.keySet().iterator(); iterator.hasNext();) {
//                //mapKey: 发货单明细id
//                String deliverDtlId = iterator.next().toString().trim();
//                Map<String, Object> deliverValueMap = deliverDtlMap.get(deliverDtlId);
//
//                String productId = (String)deliverValueMap.get("productId");
//                BigDecimal outDetailCount = (BigDecimal)deliverValueMap.get("outDetailCount");
//
//                Map<String, Object> productInMap = new HashMap<String, Object>();
//                productInMap.put("productId", productId);
//                productInMap.put("inCount", outDetailCount);
//                productInMap.put("inDtlId", null);
//                businessByInMap.put(deliverDtlId, productInMap);
//            }
//        }
//
//        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse) && businessByInMap != null && businessByInMap.size() > 0) {
//            //退库方式:1:生成退库单: (生成复杂版入库单)
//            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
//            warehouseInCreateService.createWarehouseInBusinessByComplex(customerId,
//                    customerName,
//                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
//                    Common.DICTIONARY_MAP.get("warehouseEntity"),
//                    cuser,
//                    companyId,
//                    //销售变更退货入库 d1c6dc9aa3b045dbabff2d5e1e253c22:saleChangeRetreatIn:
//                    Common.DICTIONARY_MAP.get("saleChangeRetreatIn"),
//                    businessByInMap);
//
//        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse) && businessByInMap != null && businessByInMap.size() > 0) {
//            //退库方式:1:生成退库单: (生成简版入库单)
//            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
//            warehouseInCreateService.createWarehouseInBusinessBySimple(customerId,
//                    customerName,
//                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
//                    Common.DICTIONARY_MAP.get("warehouseEntity"),
//                    cuser,
//                    companyId,
//                    //销售变更退货入库 d1c6dc9aa3b045dbabff2d5e1e253c22:saleChangeRetreatIn:
//                    Common.DICTIONARY_MAP.get("saleChangeRetreatIn"),
//                    businessByInMap);
//        }
//
//        //反写发货单明细
//        if (businessByInMap != null && businessByInMap.size() > 0) {
//            for (Iterator iterator = deliverDtlMap.keySet().iterator(); iterator.hasNext();) {
//                //mapKey: 发货单明细id
//                String deliverDtlId = iterator.next().toString().trim();
//                Map<String, Object> valueMap = deliverDtlMap.get(deliverDtlId);
//
//                //inDtlId:入库明细id
//                String inDtlId = (String)valueMap.get("inDtlId");
//
//                SaleDeliverDetail editDeliverDtl = new SaleDeliverDetail();
//                editDeliverDtl.setId(deliverDtlId);
//                editDeliverDtl.setInDetailId(inDtlId);
//                saleDeliverDetailService.update(editDeliverDtl);
//            }
//        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //2. 发货单明细对应的出库单状态变更为已退库
//        if (mapList != null && mapList.size() > 0) {
//            Map<String, Object> objectMap = mapList.get(0);
//            //出库单id
//            String outId = (String)objectMap.get("outId");
//            if (outId != null && outId.trim().length() > 0) {
//                WarehouseOut editOut = new WarehouseOut();
//                editOut.setId(outId);
//                //状态(0:未完成 1:已完成 -1:已取消 2:待提交 3:待审核 4:已退库)
//                //(2019-10-10)简版仓库报废审核功能-添加状态(2:待提交 3:待审核)
//                //(2019-10-18)销售订单变更-添加状态(4:已退库)
//                editOut.setState("4");
//                outService.update(editOut);
//            }
//        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //3. 发货单明细对应的订单明细状态变更为待出库
//        Map<String, String> orderDtlMap = new HashMap<>();
//        if (mapList != null && mapList.size() > 0) {
//            for (Map<String, Object> objectMap : mapList) {
//                String orderDtlId = (String)objectMap.get("orderDtlId");
//                if (orderDtlId != null && orderDtlId.trim().length() > 0) {
//                    orderDtlId = orderDtlId.trim();
//                    orderDtlMap.put(orderDtlId, orderDtlId);
//                }
//            }
//        }
//
//        if (orderDtlMap != null && orderDtlMap.size() > 0) {
//            for (Iterator iterator = orderDtlMap.keySet().iterator(); iterator.hasNext();) {
//                //mapKey: 订单明细id
//                String orderDtlId = iterator.next().toString().trim();
//
//                SaleOrderDetail editOrderDetail = new SaleOrderDetail();
//                editOrderDetail.setId(orderDtlId);
//                //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
//                editOrderDetail.setState("3");
//                saleOrderDetailService.update(editOrderDetail);
//            }
//        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //4. 取消发货单
//        SaleDeliver editDeliver = new SaleDeliver();
//        editDeliver.setId(deliverId);
//        //发货状态(0:待发货 1:已发货 -1:已取消)
//        editDeliver.setState("-1");
//        saleDeliverService.update(editDeliver);
//
//        //发货明细状态(0:待发货 1:已发货 -1:已取消)
//        saleDeliverDetailService.updateStateByDetail("-1", deliverId);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleDeliver/cancelDeliverWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取发货明细结构体<发货单明细id, 发货明细Map>
     *   发货明细Map:
     *     deliverDtlId: 发货单明细id
     *     productId: 货品id
     *     outDetailCount: 发货单明细id对应出库数量
     *
     * @param mapList
     * @return
     */
    private Map<String, Map<String, Object>> findDeliverDetailOutCount(List<Map<String, Object>> mapList) {
        Map<String, Map<String, Object>> deliverDtlMap = new LinkedHashMap<>();
        if (mapList == null || mapList.size() == 0) {return deliverDtlMap;}

        for (Map<String, Object> objectMap : mapList) {
            Map<String, Object> deliverValueMap = new HashMap<>();

            String deliverDtlId = (String)objectMap.get("deliverDtlId");
            deliverValueMap.put("deliverDtlId", deliverDtlId);

            String productId = (String)objectMap.get("productId");
            deliverValueMap.put("productId", productId);

            BigDecimal outDetailCount = BigDecimal.valueOf(0D);
            if (objectMap.get("outDetailCount") != null) {
                outDetailCount = (BigDecimal)objectMap.get("outDetailCount");

                //四舍五入到2位小数
                outDetailCount = outDetailCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            }
            deliverValueMap.put("outDetailCount", outDetailCount);

            deliverDtlMap.put(deliverDtlId, deliverValueMap);
        }

        return deliverDtlMap;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    /**
//    * Excel导出
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-15
//    */
//    @PostMapping("/sale/saleDeliver/exportExcelSaleDelivers")
//    public void exportExcelSaleDelivers() throws Exception {
//        logger.info("################/sale/saleDeliver/exportExcelSaleDelivers 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        saleDeliverService.exportExcelSaleDelivers(pd,pg);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleDeliver/exportExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }
//
//    /**
//    * Excel导入
//    *
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-15
//    */
//    @PostMapping("/sale/saleDeliver/importExcelSaleDelivers")
//    public ResultModel importExcelSaleDelivers(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
//        logger.info("################/sale/saleDeliver/importExcelSaleDelivers 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = saleDeliverService.importExcelSaleDelivers(file);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleDeliver/importExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

}



