package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_sale_deliver_detail:发货明细Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleDeliverDetailController.class);

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverDetailByRetreatService saleDeliverDetailByRetreatService;
    @Autowired
    private SaleDeliverDtlOnOutDtlService saleDeliverDtlOnOutDtlService;

    @Autowired
    private WarehouseOutService outService;
    @Autowired
    private WarehouseOutDetailService outDetailService;
    @Autowired
    private WarehouseOutDetailExecuteService outDetailExecuteService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private ProductService productService;
    @Autowired
    private RoleMenuService roleMenuService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/sale/saleDeliverDetail/listPageSaleDeliverDetail")
    public ResultModel listPageSaleDeliverDetail() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDetailService.listPageSaleDeliverDetail(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice")
    public ResultModel listPageSaleDeliverDetailByPrice() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDetailService.listPageSaleDeliverDetailByPrice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageSaleDeliverDetailByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/sale/saleDeliverDetail/listPageDeliverDetailByRetreat")
    public ResultModel listPageDeliverDetailByRetreat() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleDeliverDetailByRetreatService.listPageDeliverDetailByRetreat(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取销售发货单明细信息-根据出库单信息(出库单id)
     * @return
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliverDetail/listPageDeliverDetailByOut")
    public ResultModel listPageDeliverDetailByOut() throws Exception {
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDtlOnOutDtlService.listPageDeliverDetailByOut(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/listPageDeliverDetailByOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货明细)
     * 后计价修改(结算单位,结算数量,结算单价,结算金额)
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleDeliverDetailByPrice() throws Exception {
        logger.info("################/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleDeliverDetailService.updateSaleDeliverDetailByPrice(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleDeliverDetail/updateSaleDeliverDetailByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 验证当前发货单明细是否允许(退库)操作
//     * 获取当前发货单明细-不可做(退库)-对界面提示信息
//     *
//     * 不可做(退库)满足以下条件:
//     * 1. 出库单明细(出库已经执行 and 出库没有执行完成)
//     * 2. 出库单明细(出库执行完成 and 已执行退库操作)
//     *
//     * @return
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleDeliverDetail/checkDeliverDetailByOutExecute")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel checkDeliverDetailByOutExecute() throws Exception {
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String deliverDtlId = pageData.getString("deliverDtlId");
//        if (deliverDtlId == null || deliverDtlId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("发货单明细id为空或空字符串！");
//            return model;
//        }
//
//        String productInfo = new String();
//        String productId = pageData.getString("productId");
//        Product product = productService.findProductById(productId);
//        if (productId != null && product != null) {
//            //货品信息(货品编码:{0} 货品名称:{1})
//            String prodInfoTemp = "货品编码:{0} 货品名称:{1}";
//
//            String productCode = new String();
//            if (product.getCode() != null) {
//                productCode = product.getCode();
//            }
//
//            String productName = new String();
//            if (product.getName() != null) {
//                productName = product.getName();
//            }
//            productInfo = MessageFormat.format(prodInfoTemp,
//                    productCode,
//                    productName);
//        }
//
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //根据订单明细id 查询(vmes_warehouse_out_detail) 获取出库单明细id
//        PageData findMap = new PageData();
//        findMap.put("id", deliverDtlId);
//        //发货状态(0:待发货 1:已发货 -1:已取消)
//        findMap.put("state", "0");
//        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailList(findMap);
//        if (deliverDtlList == null || deliverDtlList.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("当前发货单明细状态(已发货,已取消)不可退库操作！");
//            return model;
//        }
//
//        String msgNotCancelDeliver = new String();
//        if (deliverDtlList != null && deliverDtlList.size() > 0) {
//            String outDtlIds = saleDeliverDetailService.findOutDetailIdsByDeliverDtlList(deliverDtlList);
//            if (outDtlIds != null && outDtlIds.trim().length() > 0) {
//                //出库明细id数组
//                String[] outDtlIdArry = outDtlIds.split(",");
//
//                // <出库单明细id, 出库单明细执行Map>
//                //     出库单明细执行Map
//                //     outParentId:       出库单id
//                //     outDtlId:          出库单明细id
//                //     outDtlCount:       出库单明细出库数量
//                //     outDtlExecuteCount 出库单明细出库执行数量
//                Map<String, Map<String, Object>> outDtlMap = outDetailExecuteService.findOutDetailExecuteMapByOutDtlIds(outDtlIds);
//
//                //获取当前订单明细不可做(订单变更)-出库单明细id
//
//                // 出库单明细id-该出库单明细-出库未执行(出库执行数量:=0)
//                List<String> outIdListByNotExecute = new ArrayList<String>();
//
//                // 出库单明细id-该出库单明细(出库数量,出库执行数量)比较-出库开始执行并且未执行完成-(出库执行数量 > 0 and 出库执行数量 < 出库数量)
//                List<String> outIdListByNotCancel = new ArrayList<String>();
//
//                //获取出库单明细-出库执行完成-(出库数量 <= 出库执行数量)
//                List<String> outDtlIdListByOutEnd = new ArrayList<String>();
//
//                for (String outDtlId : outDtlIdArry) {
//                    Map<String, Object> outDtlExecuteMap = outDtlMap.get(outDtlId);
//                    if (outDtlExecuteMap != null) {
//                        //出库单明细出库数量
//                        BigDecimal outDtlCount = (BigDecimal)outDtlExecuteMap.get("outDtlCount");
//                        //出库单明细出库执行数量
//                        BigDecimal outDtlExecuteCount = (BigDecimal)outDtlExecuteMap.get("outDtlExecuteCount");
//                        if (outDtlCount != null && outDtlExecuteCount != null
//                            && outDtlCount.doubleValue() > 0
//                            && outDtlExecuteCount.doubleValue() == 0
//                        ) {
//                            outIdListByNotExecute.add(outDtlId);
//                            //出库数量 > 0 and 出库执行数量 > 0 and 出库执行数量 < 出库数量
//                        } else if (outDtlCount != null && outDtlExecuteCount != null
//                                && outDtlCount.doubleValue() > 0
//                                && outDtlExecuteCount.doubleValue() > 0
//                                && outDtlExecuteCount.doubleValue() < outDtlCount.doubleValue()
//                                ) {
//                            //出库单id
//                            String outParentId = (String)outDtlExecuteMap.get("outParentId");
//                            if (outParentId != null && outParentId.trim().length() > 0) {
//                                outIdListByNotCancel.add(outParentId);
//                            }
//                        } else if (outDtlCount != null && outDtlExecuteCount != null
//                                && outDtlCount.doubleValue() > 0
//                                && outDtlExecuteCount.doubleValue() > 0
//                                && outDtlExecuteCount.doubleValue() >= outDtlCount.doubleValue()
//                                ) {
//                            //出库单明细id
//                            outDtlIdListByOutEnd.add(outDtlId);
//                        }
//                    }
//                }
//
//                if (outIdListByNotExecute.size() > 0) {
//                    msgNotCancelDeliver = "该发货单明细未执行出库操作，无需执行(退库)操作！" + Common.SYS_ENDLINE_DEFAULT;
//                }
//
//                //当前发货单明细-不可做(退库)-对界面提示信息:
//                if (outIdListByNotCancel.size() > 0) {
//                    StringBuffer outNotChange = this.findOutMessageByOutIdList(outIdListByNotCancel, productInfo);
//                    if (outNotChange != null && outNotChange.toString().trim().length() > 0) {
//                        msgNotCancelDeliver = "该发货单明细已经开始执行出库，不可直接退库。" + Common.SYS_ENDLINE_DEFAULT
//                                                + "请按以下出库单信息执行完成后，执行(退库)操作！" + Common.SYS_ENDLINE_DEFAULT
//                                                + " 出库信息：" + outNotChange.toString();
//                    }
//                }
//
//                if (outDtlIdListByOutEnd.size() > 0) {
//                    StringBuffer outNotChange = this.findDeliverMessageByOutDtlIdList(deliverDtlList, outDtlIdListByOutEnd);
//                    if (outNotChange != null && outNotChange.toString().trim().length() > 0) {
//                        msgNotCancelDeliver = "该发货单明细已执行(退库)操作！" + Common.SYS_ENDLINE_DEFAULT;
//                    }
//                }
//            }
//        }
//
//        model.put("notCancelDeliver", msgNotCancelDeliver);
//        return model;
//    }

//    /**
//     * 退库
//     * 1. 获取出库单明细-(发货订单明细-对应的出库单明细id
//     * 2. 生成入库单-(出库单明细)
//     *
//     * @author 陈刚
//     * @date 2019-03-05
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleDeliverDetail/cancelDeliverDetail")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel cancelDeliverDetail() throws Exception {
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
//        String deliverDtlId = pageData.getString("deliverDtlId");
//        if (deliverDtlId == null || deliverDtlId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("发货单明细id为空或空字符串！");
//            return model;
//        }
//        String outDetailId = pageData.getString("outDetailId");
//        if (outDetailId == null || outDetailId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("出库单明细id为空或空字符串！");
//            return model;
//        }
//
//        WarehouseOutDetail outDetail = outDetailService.findWarehouseOutDetailById(outDetailId);
//
//        //生成入库单
//        //货品入库Map<货品id, 货品Map<String, Object>>
//        // 货品Map<String, Object>
//        //     productId: 货品id
//        //     inDtlId:   入库明细id
//        //     inCount:   入库数量
//        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
//        Map<String, Object> productInMap = new HashMap<String, Object>();
//        productInMap.put("productId", outDetail.getProductId());
//        productInMap.put("inCount", outDetail.getCount());
//        productInMap.put("inDtlId", null);
//        productByInMap.put(outDetail.getProductId(), productInMap);
//
//        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
//            //退库方式:1:生成退库单: (生成复杂版入库单)
//            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
//            warehouseInCreateService.createWarehouseInByComplex(customerId,
//                    customerName,
//                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
//                    Common.DICTIONARY_MAP.get("warehouseEntity"),
//                    cuser,
//                    companyId,
//                    //销售变更退货入库 d1c6dc9aa3b045dbabff2d5e1e253c22:saleChangeRetreatIn:
//                    Common.DICTIONARY_MAP.get("saleChangeRetreatIn"),
//                    productByInMap);
//
//        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
//            //退库方式:1:生成退库单: (生成简版入库单)
//            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
//            warehouseInCreateService.createWarehouseInBySimple(customerId,
//                    customerName,
//                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
//                    Common.DICTIONARY_MAP.get("warehouseEntity"),
//                    cuser,
//                    companyId,
//                    //销售变更退货入库 d1c6dc9aa3b045dbabff2d5e1e253c22:saleChangeRetreatIn:
//                    Common.DICTIONARY_MAP.get("saleChangeRetreatIn"),
//                    productByInMap);
//        }
//
//        //修改发货单明细
//        SaleDeliverDetail editDeliverDtl = new SaleDeliverDetail();
//        editDeliverDtl.setId(deliverDtlId);
//
//        String productId = outDetail.getProductId();
//        if (productByInMap != null && productByInMap.get(productId) != null) {
//            Map<String, Object> producValueMap = productByInMap.get(productId);
//
//            //inDtlId:   入库明细id
//            String inDtlId = (String)producValueMap.get("inDtlId");
//            editDeliverDtl.setInDetailId(inDtlId);
//        }
//
//        //发货状态(0:待发货 1:已发货 -1:已取消)
//        //editDeliverDtl.setState("-1");
//        saleDeliverDetailService.update(editDeliverDtl);
//
////        //修改发货单状态
////        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
////        String deliverState = saleDeliverDetailService.findParentStateByDetailList(deliverDtlList);
////        if (deliverState != null) {
////            SaleDeliver editDeliver = new SaleDeliver();
////            editDeliver.setId(deliverId);
////            editDeliver.setState(deliverState);
////            saleDeliverService.update(editDeliver);
////        }
//
//        return model;
//    }


//    /**
//    * Excel导出
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-15
//    */
//    @PostMapping("/sale/saleDeliverDetail/exportExcelSaleDeliverDetails")
//    public void exportExcelSaleDeliverDetails() throws Exception {
//        logger.info("################/sale/saleDeliverDetail/exportExcelSaleDeliverDetails 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        saleDeliverDetailService.exportExcelSaleDeliverDetails(pd,pg);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleDeliverDetail/exportExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

//    /**
//    * Excel导入
//    *
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-15
//    */
//    @PostMapping("/sale/saleDeliverDetail/importExcelSaleDeliverDetails")
//    public ResultModel importExcelSaleDeliverDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
//        logger.info("################/sale/saleDeliverDetail/importExcelSaleDeliverDetails 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = saleDeliverDetailService.importExcelSaleDeliverDetails(file);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleDeliverDetail/importExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
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

//    //获取出库单明细(出库执行完成 and 未执行退库操作)-对应的发货单
//    //(出库单明细)查询发货单明细表(入库单明细id)--判断(入库单明细id)是否为空
//    private StringBuffer findDeliverMessageByOutDtlIdList(List<SaleDeliverDetail> deliverDtlList,
//                                                          List<String> outDtlIdList) {
//        StringBuffer msgBuf = new StringBuffer();
//        if (deliverDtlList == null || deliverDtlList.size() == 0) {return msgBuf;}
//        if (outDtlIdList == null || outDtlIdList.size() == 0) {return msgBuf;}
//
//        Map<String, String> deliverMap = new LinkedHashMap<String, String>();
//        for (String outDtlId : outDtlIdList) {
//            for (SaleDeliverDetail deliverDetail : deliverDtlList) {
//                //outDetailId 出单明细id
//                String outDetailId = deliverDetail.getOutDetailId();
//                //parentId 发货单id
//                String deliverId = deliverDetail.getParentId();
//
//                //inDetailId 入库单明细id
//                String inDetailId = deliverDetail.getInDetailId();
//                if (outDtlId.equals(outDetailId) && (inDetailId != null && inDetailId.trim().length() > 0)) {
//                    deliverMap.put(deliverId, deliverId);
//                }
//            }
//        }
//
//        for (Iterator iterator = deliverMap.keySet().iterator(); iterator.hasNext();) {
//            String deliverId = iterator.next().toString().trim();
//            msgBuf.append(deliverId).append(",");
//        }
//
//        return msgBuf;
//    }

}

