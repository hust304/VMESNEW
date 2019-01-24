package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.Producer;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.SaleOrder;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.*;
import com.yvan.DateUtils;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@RestController
@Slf4j
public class SaleOrderAuditController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderController.class);

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private SaleOrderAuditService saleOrderAuditService;
    @Autowired
    private SaleOrderDetailCustomerPriceService saleOrderDetailCustomerPriceService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ColumnService columnService;

    @Autowired
    private SaleLockDateService saleLockDateService;
    //消息队列
    @Autowired
    private Producer producer;

    @PostMapping("/saleOrderAudit/listPageSaleOrderDetailByLockStock")
    public ResultModel listPageSaleOrderDetailByLockStock() throws Exception {
        logger.info("################saleOrderAudit/listPageSaleOrderDetailByLockStock 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByLockStock");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        String detailIds = pd.getString("detailIds");
        if (detailIds != null && detailIds.trim().length() > 0) {
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";
            pd.put("detailIds", detailIds);
        }

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleOrderAuditService.findPageListByLockStock(pd);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/listPageSaleOrderDetailByLockStock 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 订单审核
     * 1. 订单明细中:(货品id,货品计价单位,订单客户,价格)与订单明细货品价格比较
     * 2. 订单明细中:(货品订购数量(计量单位))与货品库存可用数量比较
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-12-11
     */
    @PostMapping("/saleOrderAudit/checkSaleOrderByAudit")
    public ResultModel checkSaleOrderByAudit() throws Exception {
        logger.info("################saleOrderAudit/checkSaleOrderByAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //订单客户id
        String customerId = pageData.getString("customerId");

        //1. 根据订单id获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
        Map<String, Map<String, Object>> productPriceMap = saleOrderDetailCustomerPriceService.findProductPriceByOrderDetai(customerId, orderId);
        if (detailList != null && detailList.size() > 0 && productPriceMap != null && productPriceMap.size() > 0) {
            for (SaleOrderDetail orderDetail : detailList) {
                String productId = orderDetail.getProductId();
                //计价单位id
                String priceUnit = orderDetail.getPriceUnit();
                //货品单价
                BigDecimal productPrice = orderDetail.getProductPrice();

                //当前货品客户价格
                String productKey = productId + "-" + priceUnit;
                Map<String, Object> priceMap = productPriceMap.get(productKey);
                if (priceMap != null && priceMap.get("productPrice") != null) {
                    BigDecimal productPriceByHistory = (BigDecimal)priceMap.get("productPrice");
                    if ((productPrice.doubleValue() - productPriceByHistory.doubleValue()) != 0) {
                        model.set("isShowProductPrice", "Y");
                        break;
                    }
                }
            }
        }

        //根据订单id:获取需要货品锁定库存数量MapList
        List<Map<String, Object>> needLockStockList = saleOrderAuditService.checkProdStockCountByOrderId(orderId);
        if (needLockStockList != null && needLockStockList.size() > 0) {
            model.set("isNeedLockStock", "Y");
            String detailIds = saleOrderAuditService.findDetailIdsByMapList(needLockStockList);
            model.set("needLockStockOrderDtlIds", detailIds);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/checkSaleOrderByAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单明细(锁定库存数量)
     *
     * productIds: 锁定库存货品id字符串
     * dtlJsonStr: {id:'订单明细id', lockCount:'锁定货品数量'}
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/saleOrderAudit/updateSaleOrderDetailByLockStock")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrderDetailByLockStock() throws Exception {
        logger.info("################saleOrderAudit/updateSaleOrderDetailByLockStock 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //获取锁定库存货品id字符串
        List<Product> productList = null;
        String productIds = pageData.getString("productIds");
        if (productIds != null && productIds.trim().length() > 0) {
            productIds = StringUtil.stringTrimSpace(productIds);
            productIds = "'" + productIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("ids", productIds);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            productList = productService.findProductList(findMap);
        }

        Map<String, Product> productMap = new HashMap<String, Product>();
        if (productList != null && productList.size() > 0) {
            for (Product product : productList) {
                productMap.put(product.getId(), product);
            }
        }

        //获取企业id对应的锁定库存时长(毫秒)
        String companyId = pageData.getString("currentCompanyId");
        Long lockTime = saleLockDateService.findLockDateMillisecondByCompanyId(companyId);

        //获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2DetailList(mapList, null);
        for (SaleOrderDetail detail : detailList) {
            //锁定开始时间
            detail.setLockDate(new Date());
            //是否锁定仓库(0:无锁定 1:锁定)
            detail.setIsLockWarehouse("1");
            saleOrderDetailService.update(detail);

            //修改货品表(锁定库存数量)
            String productId = detail.getProductId();
            Product product = productMap.get(productId);
            if (product != null) {
                //锁定库存数量 lockCount
                BigDecimal old_lockCount = BigDecimal.valueOf(0D);
                if (product.getLockCount() != null) {
                    old_lockCount = product.getLockCount();
                }

                BigDecimal new_lockCount = BigDecimal.valueOf(old_lockCount.doubleValue() + detail.getLockCount().doubleValue());
                //四舍五入到2位小数
                new_lockCount = new_lockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                product.setLockCount(new_lockCount);
                productService.update(product);
            }

            //将订单明细id作为消息体放入消息队列中，消息时长(毫秒)-根据企业id查询(vmes_sale_lock_date)
            if (lockTime != null && lockTime.longValue() > 0) {
                producer.sendMsg(detail.getId(), lockTime.longValue());
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/updateSaleOrderDetailByLockStock 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单(修改订单明细价格)
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/saleOrderAudit/updateSaleOrderByAudit")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrderByAudit() throws Exception {
        logger.info("################saleOrderAudit/updateSaleOrderByAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //A. 修改订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (SaleOrderDetail detail : detailList) {
                saleOrderDetailService.update(detail);
            }
        }

        //B. 修改订单主表
        List<SaleOrderDetail> orderDetailList = saleOrderDetailService.findSaleOrderDetailListByParentId(order.getId());
        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(orderDetailList);
        order.setTotalSum(totalSum);

        //discount_sum:折扣金额
        BigDecimal discountSum = BigDecimal.valueOf(0D);
        if (order.getDiscountSum() != null) {
            discountSum = order.getDiscountSum();
        }
        order.setDiscountSum(discountSum);

        //order_sum:订单金额(合计金额 - 折扣金额)
        //四舍五入到2位小数
        BigDecimal orderSum = BigDecimal.valueOf(totalSum.doubleValue() - order.getDiscountSum().doubleValue()).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        order.setOrderSum(orderSum);

        //2:后计价 无订单总金额 无订单金额
        if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {
            order.setTotalSum(BigDecimal.valueOf(0D));
            order.setOrderSum(BigDecimal.valueOf(0D));
        }
        saleOrderService.update(order);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/updateSaleOrderByAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核通过订单
     *
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/saleOrderAudit/auditPassSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassSaleOrder() throws Exception {
        logger.info("################saleOrderAudit/auditPassSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        //是否更新客户货品价格(Y:需要更新 (N or is null)无需更新)
        String isCustomerPrice = pageData.getString("isCustomerPrice");

        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order = new SaleOrder();
        order.setId(orderId);
        //审核人ID
        order.setAuditId(cuser);
        order.setState("2");
        saleOrderService.update(order);

        //2. 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        saleOrderDetailService.updateStateByDetail("3", orderId);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/auditPassSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不同意
     * auditExecuteJsonStr
     * {id:"",parentId:"",detailId:""}
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/saleOrderAudit/auditDisagreeSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeSaleOrder() throws Exception {
        logger.info("################/saleOrderAudit/auditDisagreeSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
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

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order = new SaleOrder();
        order.setId(orderId);
        String msgTemp = "审核退回:{0}{3}审核人:{1}{3}审核时间:{2}";
        String remarkStr = MessageFormat.format(msgTemp,
                remark,
                userName,
                DateUtils.toDateStr(new Date()),
                Common.SYS_ENDLINE_DEFAULT);
        order.setRemark(remarkStr);
        order.setState("0");
        //审核人ID
        order.setAuditId(cuser);
        saleOrderService.update(order);

        //2. 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        saleOrderDetailService.updateStateByDetail("0", orderId);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderAudit/auditDisagreeSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
