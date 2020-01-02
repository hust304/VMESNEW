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
* 说明：vmes_sale_order_detail:订单明细Controller
* @author 陈刚 自动生成
* @date 2018-12-05
*/
@RestController
@Slf4j
public class SaleOrderDetailController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderDetailController.class);

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;
    @Autowired
    private SaleOrderDetailCollectService saleOrderDetailCollectService;
    @Autowired
    private SaleOrderDetailByLockCountService saleOrderDetailByLockCountService;
    @Autowired
    private SaleOrderDetailByChangeService saleOrderDetailByChangeService;

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;

    @Autowired
    private WarehouseOutService outService;
    @Autowired
    private WarehouseOutDetailExecuteService outDetailExecuteService;

    @Autowired
    private ProductService productService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrderDetail/listPageSaleOrderDetail")
    public ResultModel listPageSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = saleOrderDetailService.listPageSaleOrderDetail(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单详情(订单明细) vmes_sale_order_detail 订单明细汇总
     * @author 陈刚
     * @date 2019-02-14
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetailCollectByInfo")
    public ResultModel listPageOrderDetailCollectByInfo() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailCollectByInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailCollectService.listPageOrderDetailCollectByInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailCollectByInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单明细(产品锁定库存) vmes_sale_order_detail
     * @author 陈刚
     * @date 2019-02-14
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetailByLockCount")
    public ResultModel listPageOrderDetailByLockCount() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByLockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailByLockCountService.listPageOrderDetailByLockCount(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetailByLockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单明细(订单变更)
     * @author 陈刚
     * @date 2019-03-05
     */
    @PostMapping("/sale/saleOrderDetail/listPageOrderDetaiByChange")
    public ResultModel listPageOrderDetaiByChange() throws Exception {
        logger.info("################/sale/saleOrderDetail/listPageOrderDetaiByChange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailByChangeService.listPageOrderDetaiByChange(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/listPageOrderDetaiByChange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消订单明细
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/cancelSaleOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/cancelSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.cancelSaleOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/cancelSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除订单明细
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/deleteSaleOrderDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleOrderDetail() throws Exception {
        logger.info("################/sale/saleOrderDetail/deleteSaleOrderDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.deleteSaleOrderDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/deleteSaleOrderDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (解锁)订单明细产品锁定库存数量
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSaleOrderDetailByLockCount() throws Exception {
        logger.info("################/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrderDetailService.rebackSaleOrderDetailByLockCount(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderDetail/rebackSaleOrderDetailByLockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


//    /**
//    * Excel导出
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-05
//    */
//    @PostMapping("/sale/saleOrderDetail/exportExcelSaleOrderDetails")
//    public void exportExcelSaleOrderDetails() throws Exception {
//        logger.info("################/sale/saleOrderDetail/exportExcelSaleOrderDetails 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        saleOrderDetailService.exportExcelSaleOrderDetails(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleOrderDetail/exportExcelSaleOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

//    /**
//    * Excel导入
//    *
//    * @author 陈刚 自动创建，可以修改
//    * @date 2018-12-05
//    */
//    @PostMapping("/sale/saleOrderDetail/importExcelSaleOrderDetails")
//    public ResultModel importExcelSaleOrderDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
//        logger.info("################/sale/saleOrderDetail/importExcelSaleOrderDetails 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = saleOrderDetailService.importExcelSaleOrderDetails(file);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleOrderDetail/importExcelSaleOrderDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 订单变更-按变更订单明细变更
     * 获取当前订单明细-不可做(订单变更)-对界面提示信息
     * 验证(订单明细id)-对应的出库单明细(出库数量, 出库执行数量)-比较(出库数量, 出库执行数量)
     *
     * 不可做(订单变更)满足以下条件:
     * 1. 出库单明细(出库已经执行 and 出库没有执行完成)
     * 2. 出库单明细(出库执行完成 and 未执行退库操作) 退库: 发货管理-发货单列表-发货单明细-操作-退库
     *
     * @author 陈刚
     * @date 2019-03-05
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderDetail/checkOrderDetailOnOutExecuteByNotChangeOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel checkOrderDetailOnOutExecuteByNotChangeOrder() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String orderDtlId = pageData.getString("orderDtlId");
        if (orderDtlId == null || orderDtlId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        String productInfo = new String();
        String productId = pageData.getString("productId");
        Product product = productService.findProductById(productId);
        if (productId != null && product != null) {
            //货品信息(货品编码:{0} 货品名称:{1})
            String prodInfoTemp = "货品编码:{0} 货品名称:{1}";

            String productCode = new String();
            if (product.getCode() != null) {
                productCode = product.getCode();
            }

            String productName = new String();
            if (product.getName() != null) {
                productName = product.getName();
            }
            productInfo = MessageFormat.format(prodInfoTemp,
                    productCode,
                    productName);
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        //根据订单明细id 查询(vmes_warehouse_out_detail) 获取出库单明细id
        PageData findMap = new PageData();
        findMap.put("orderDtlId", orderDtlId);
        //发货状态(0:待发货 1:已发货 -1:已取消)
        findMap.put("state", "0");
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailList(findMap);

        String msgNotChangeOrder = new String();
        if (deliverDtlList != null && deliverDtlList.size() > 0) {
            String outDtlIds = saleDeliverDetailService.findOutDetailIdsByDeliverDtlList(deliverDtlList);
            if (outDtlIds != null && outDtlIds.trim().length() > 0) {
                //出库明细id数组
                String[] outDtlIdArry = outDtlIds.split(",");

                // <出库单明细id, 出库单明细执行Map>
                //     出库单明细执行Map
                //     outParentId:       出库单id
                //     outDtlId:          出库单明细id
                //     outDtlCount:       出库单明细出库数量
                //     outDtlExecuteCount 出库单明细出库执行数量
                Map<String, Map<String, Object>> outDtlMap = outDetailExecuteService.findOutDetailExecuteMapByOutDtlIds(outDtlIds);

                //获取当前订单明细不可做(订单变更)-出库单明细id
                // 出库单明细id-该出库单明细(出库数量,出库执行数量)比较-
                List<String> outIdListByNotChange = new ArrayList<String>();

                //获取出库单明细-出库执行完成
                List<String> outDtlIdListByOutEnd = new ArrayList<String>();

                for (String outDtlId : outDtlIdArry) {
                    Map<String, Object> outDtlExecuteMap = outDtlMap.get(outDtlId);
                    if (outDtlExecuteMap != null) {
                        //出库单明细出库数量
                        BigDecimal outDtlCount = (BigDecimal)outDtlExecuteMap.get("outDtlCount");
                        //出库单明细出库执行数量
                        BigDecimal outDtlExecuteCount = (BigDecimal)outDtlExecuteMap.get("outDtlExecuteCount");
                        //出库数量 > 0 and 出库执行数量 > 0 and 出库执行数量 < 出库数量
                        if (outDtlCount != null && outDtlExecuteCount != null
                                && outDtlCount.doubleValue() > 0
                                && outDtlExecuteCount.doubleValue() > 0
                                && outDtlExecuteCount.doubleValue() < outDtlCount.doubleValue()
                                ) {
                            //出库单id
                            String outParentId = (String)outDtlExecuteMap.get("outParentId");
                            if (outParentId != null && outParentId.trim().length() > 0) {
                                outIdListByNotChange.add(outParentId);
                            }
                        } else if (outDtlCount != null && outDtlExecuteCount != null
                            && outDtlCount.doubleValue() > 0
                            && outDtlExecuteCount.doubleValue() > 0
                            && outDtlExecuteCount.doubleValue() >= outDtlCount.doubleValue()
                        ) {
                            //出库单明细id
                            outDtlIdListByOutEnd.add(outDtlId);
                        }
                    }
                }

                //当前订单明细-不可做(订单变更)-对界面提示信息:
                if (outIdListByNotChange.size() > 0) {
                    StringBuffer outNotChange = this.findOutMessageByOutIdList(outIdListByNotChange, productInfo);
                    if (outNotChange != null && outNotChange.toString().trim().length() > 0) {
                        msgNotChangeOrder = "该订单明细已经开始执行出库，不可直接变更。" + Common.SYS_ENDLINE_DEFAULT
                                            + "请将以下出库单信息执行完成后允许(订单变更)操作！" + Common.SYS_ENDLINE_DEFAULT
                                            + " 出库信息：" + outNotChange.toString();
                    }
                }

                if (outDtlIdListByOutEnd.size() > 0) {
                    StringBuffer outNotChange = this.findDeliverMessageByOutDtlIdList(deliverDtlList,
                            outDtlIdListByOutEnd,
                            productInfo);
                    if (outNotChange != null && outNotChange.toString().trim().length() > 0) {
                        msgNotChangeOrder = "该订单明细发货单已经出库完成，不可直接变更。" + Common.SYS_ENDLINE_DEFAULT
                                            + "请按以下发货单信息执行(退库)操作！" + Common.SYS_ENDLINE_DEFAULT
                                            + " 发货信息：" + outNotChange.toString()
                                            + " (发货管理-发货单列表-发货单明细-操作-退库)";
                    }
                }
            }
        }

        model.put("notChangeOrder", msgNotChangeOrder);
        return model;
    }

//    /**
//     * 订单变更-按变更订单明细变更
//     * 该订单明细id: 是否允许(订单变更)已经验证
//     * 验证方法: (/sale/saleOrderDetail/checkOrderDetailOnOutExecuteByNotChangeOrder)
//     *
//     * @author 陈刚
//     * @date 2019-03-05
//     * @throws Exception
//     */
//    @PostMapping("/sale/saleOrderDetail/changeSaleOrderByDetail")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel changeSaleOrderByDetail() throws Exception {
//        logger.info("################/sale/saleOrderDetail/changeSaleOrderByDetail 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        PageData pageData = HttpUtils.parsePageData();
//        ResultModel model = saleOrderDetailService.changeSaleOrderByDetail(pageData);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/sale/saleOrderDetail/changeSaleOrderByDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private StringBuffer findOutMessageByOutIdList(List<String> outIdList, String productInfo) {
        StringBuffer msgBuf = new StringBuffer();
        if (outIdList == null || outIdList.size() == 0) {return msgBuf;}

        Map<String, String> outMap = new LinkedHashMap<String, String>();
        for (String outId : outIdList) {
            outMap.put(outId, outId);
        }

        //出库单号:出库单号 货品编码:货品编码
        String msgTemp = "出库单号:{0} {1} " + Common.SYS_ENDLINE_DEFAULT;
        for (Iterator iterator = outMap.keySet().iterator(); iterator.hasNext();) {
            String outId = iterator.next().toString().trim();

            try {
                WarehouseOut outObject = outService.selectById(outId);
                if (outObject != null) {
                    String msgStr = MessageFormat.format(msgTemp,
                            outObject.getCode(),
                            productInfo);
                    msgBuf.append(msgStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msgBuf;
    }

    //获取出库单明细(出库执行完成 and 未执行退库操作)-对应的发货单
    //(出库单明细)查询发货单明细表(入库单明细id)--判断(入库单明细id)是否为空
    private StringBuffer findDeliverMessageByOutDtlIdList(List<SaleDeliverDetail> deliverDtlList,
                                                       List<String> outDtlIdList,
                                                       String productInfo) {
        StringBuffer msgBuf = new StringBuffer();
        if (deliverDtlList == null || deliverDtlList.size() == 0) {return msgBuf;}
        if (outDtlIdList == null || outDtlIdList.size() == 0) {return msgBuf;}

        Map<String, String> deliverMap = new LinkedHashMap<String, String>();
        for (String outDtlId : outDtlIdList) {
            for (SaleDeliverDetail deliverDetail : deliverDtlList) {
                //inDetailId 入库单明细id
                String inDetailId = deliverDetail.getInDetailId();
                if (inDetailId != null && inDetailId.trim().length() > 0) {continue;}

                //outDetailId 出单明细id
                String outDetailId = deliverDetail.getOutDetailId();
                //parentId 发货单id
                String deliverId = deliverDetail.getParentId();

                if (outDtlId.equals(outDetailId)) {
                    deliverMap.put(deliverId, deliverId);
                }
            }
        }

        //发货单号:发货单号 货品编码:货品编码
        String msgTemp = "发货单号:{0} {1} " + Common.SYS_ENDLINE_DEFAULT;
        for (Iterator iterator = deliverMap.keySet().iterator(); iterator.hasNext();) {
            String deliverId = iterator.next().toString().trim();

            try {
                SaleDeliver deliver = saleDeliverService.findSaleDeliverById(deliverId);
                if (deliver != null) {
                    String msgStr = MessageFormat.format(msgTemp,
                            deliver.getDeliverCode(),
                            productInfo);
                    msgBuf.append(msgStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msgBuf;
    }

}



