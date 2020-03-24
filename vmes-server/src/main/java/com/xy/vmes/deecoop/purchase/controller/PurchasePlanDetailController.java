package com.xy.vmes.deecoop.purchase.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.service.PurchasePlanDetailService;
import com.xy.vmes.entity.PurchasePlanDetail;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.SaleOrderDetailService;
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
* 说明：vmes_purchase_plan_detail:采购计划Controller
* @author 刘威 自动生成
* @date 2019-02-28
*/
@RestController
@Slf4j
public class PurchasePlanDetailController {
    private Logger logger = LoggerFactory.getLogger(PurchasePlanDetailController.class);

    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;

    @Autowired
    private SaleOrderDetailService orderDetailService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlanDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PurchasePlanDetail purchasePlanDetail = purchasePlanDetailService.selectById(id);
        model.putResult(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail)HttpUtils.pageData2Entity(pd, new PurchasePlanDetail());
        purchasePlanDetailService.save(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail)HttpUtils.pageData2Entity(pd, new PurchasePlanDetail());
        purchasePlanDetailService.update(purchasePlanDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-02-28
    */
    @GetMapping("/purchase/purchasePlanDetail/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/purchase/purchasePlanDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        purchasePlanDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/listPagePurchasePlanDetails")
    public ResultModel listPagePurchasePlanDetails()  throws Exception {
        logger.info("################/purchase/purchasePlanDetail/listPagePurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = purchasePlanDetailService.listPagePurchasePlanDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/listPagePurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 按货品合并-生产计划明细
     * @return
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/mergeProductByPurchasePlanDetail")
    public ResultModel mergeProductByPurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/mergeProductByPurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 遍历 jsonMapList 保存Map<货品id, List<Map<String, String>>>
        Map<String, List<Map<String, String>>> mergeProductMap = new LinkedHashMap<>();
        for (Map<String, String> mapData : jsonMapList) {
            String productId = mapData.get("productId");

            if (mergeProductMap.get(productId) == null) {
                List<Map<String, String>> mapTempList = new ArrayList<>();
                mapTempList.add(mapData);
                mergeProductMap.put(productId, mapTempList);
            } else if (mergeProductMap.get(productId) != null) {
                List<Map<String, String>> mapTempList = mergeProductMap.get(productId);
                mapTempList.add(mapData);
            }
        }

        //2. 遍历 mergeProductMap
        List<Map<String, String>> mergeProductMapList = new ArrayList<>();
        for (Iterator iterator = mergeProductMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = iterator.next().toString().trim();
            List<Map<String, String>> mapTempList = mergeProductMap.get(mapKey);

            Map<String, String> productMap = mapTempList.get(0);

            //count 计划数量
            BigDecimal countSum = this.findCountSumByMapList(mapTempList);
            //四舍五入到2位小数
            countSum = countSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            productMap.put("count", countSum.toString());

            //jsonStr 按货品合并JsonString
            String jsonStr = this.findJsonStringByMapList(mapTempList);
            productMap.put("jsonStr", jsonStr);

            //获取(销售订单编号;订单最小约定交期)
            Map<String, String> valueMap = this.findOrderCodeByMapList(mapTempList);
            //mapKey:orderCodes:销售订单编号
            String orderCodes = valueMap.get("orderCodes");
            productMap.put("orderCode", orderCodes);

//            //mapKey:minExpectDate:订单最小约定交期
//            String minExpectDate = valueMap.get("minExpectDate");
//            productMap.put("expectDate", minExpectDate);

            mergeProductMapList.add(productMap);
        }
        model.put("mergeProductList", mergeProductMapList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/mergeProductByPurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails")
    public void exportExcelPurchasePlanDetails() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        purchasePlanDetailService.exportExcelPurchasePlanDetails(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/exportExcelPurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-02-28
    */
    @PostMapping("/purchase/purchasePlanDetail/importExcelPurchasePlanDetails")
    public ResultModel importExcelPurchasePlanDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/purchase/purchasePlanDetail/importExcelPurchasePlanDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = purchasePlanDetailService.importExcelPurchasePlanDetails(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/importExcelPurchasePlanDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/deletePurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deletePurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/deletePurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.deletePurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/deletePurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/recoveryPurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryPurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/recoveryPurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.recoveryPurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/recoveryPurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/purchase/purchasePlanDetail/cancelPurchasePlanDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelPurchasePlanDetail() throws Exception {
        logger.info("################/purchase/purchasePlanDetail/cancelPurchasePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = purchasePlanDetailService.cancelPurchasePlanDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/purchase/purchasePlanDetail/cancelPurchasePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private BigDecimal findCountSumByMapList(List<Map<String, String>> mapList) {
        BigDecimal countSum = BigDecimal.valueOf(0D);
        if (mapList == null || mapList.size() == 0) {
            return countSum;
        }

        for (Map<String, String> mapData : mapList) {
            //count 计划数量
            BigDecimal count = BigDecimal.valueOf(0D);

            String countStr = mapData.get("count");
            if (countStr != null && countStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(countStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            countSum = BigDecimal.valueOf(countSum.doubleValue() + count.doubleValue());
        }

        return countSum;
    }

    private String findJsonStringByMapList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //orderDetailMap<销售订单明细id, 销售订单明细id>
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (Map<String, String> mapData : mapList) {

            //jsonStr 按货品合并JsonString
            String jsonStr = mapData.get("jsonStr");
            if (jsonStr != null && jsonStr.trim().length() > 0) {
                List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
                if (jsonMapList != null && jsonMapList.size() > 0) {
                    for (Map<String, String> jsonMap : jsonMapList) {
                        String json_orderDtlId = jsonMap.get("orderDtlId");
                        if (json_orderDtlId != null && json_orderDtlId.trim().length() > 0) {
                            orderDetailMap.put(json_orderDtlId, json_orderDtlId);
                        }
                    }
                }
            }

            //orderDtlId 销售订单明细id
            String orderDtlId = new String();
            if (mapData.get("orderDtlId") != null) {
                orderDtlId = mapData.get("orderDtlId").trim();
            }
            if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                orderDetailMap.put(orderDtlId, orderDtlId);
            }
        }

        List<Map<String, String>> childMapList = new ArrayList<>();
        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    Map<String, String> childMap = new LinkedHashMap<>();
                    childMap.put("orderDtlId", mapKey_orderDtlId);
                    childMapList.add(childMap);
                }
            }
        }

        if (childMapList.size() > 0) {
            return YvanUtil.toJson(childMapList);
        }

        return new String();
    }

    /**
     * 获取(销售订单编号;订单最小约定交期)
     * 返回值:Map<String, String>
     *     mapKey:
     *         orderCodes:    销售订单编号
     *         minExpectDate: 订单最小约定交期(yyyy-MM-dd)
     *
     * @param mapList
     * @return
     * @throws Exception
     */
    private Map<String, String> findOrderCodeByMapList(List<Map<String, String>> mapList) throws Exception {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("orderCodes", new String());
        valueMap.put("minExpectDate", new String());
        if (mapList == null || mapList.size() == 0) {return valueMap;}

        //orderDetailMap<销售订单明细id, 销售订单明细id> //获取不重复的销售订单明细id
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (Map<String, String> mapData : mapList) {
            //jsonStr 按货品合并JsonString
            String jsonStr = mapData.get("jsonStr");
            if (jsonStr != null && jsonStr.trim().length() > 0) {
                List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
                if (jsonMapList != null && jsonMapList.size() > 0) {
                    for (Map<String, String> jsonMap : jsonMapList) {
                        String json_orderDtlId = jsonMap.get("orderDtlId");
                        if (json_orderDtlId != null && json_orderDtlId.trim().length() > 0) {
                            orderDetailMap.put(json_orderDtlId, json_orderDtlId);
                        }
                    }
                }
            }

            //orderDtlId 销售订单明细id
            String orderDtlId = new String();
            if (mapData.get("orderDtlId") != null) {
                orderDtlId = mapData.get("orderDtlId").trim();
            }
            if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                orderDetailMap.put(orderDtlId, orderDtlId);
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 并查询销售订单明细
        StringBuffer orderDtlIdBuf = new StringBuffer();
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    orderDtlIdBuf.append(mapKey_orderDtlId).append(",");
                }
            }
        }

        StringBuffer orderCodeBuf = new StringBuffer();
        //long minExpectDateLong = -1;
        if (orderDtlIdBuf != null && orderDtlIdBuf.toString().trim().length() > 0) {
            String orderDtlIds = StringUtil.stringTrimSpace(orderDtlIdBuf.toString().trim());
            orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("ids", orderDtlIds);
            List<Map> tableMapList = orderDetailService.getDataListPage(findMap, null);

            //获取(销售订单编号)','分隔的字符串
            if (tableMapList != null && tableMapList.size() > 0) {
                for (Map<String, Object> mapData : tableMapList) {
                    String sysCode = (String)mapData.get("sysCode");
                    if (sysCode != null && sysCode.trim().length() > 0) {
                        orderCodeBuf.append(sysCode).append(",");
                    }
                }
            }

//            //获取(订单最小约定交期)expectDate(yyyy-MM-dd)
//            if (tableMapList != null && tableMapList.size() > 0) {
//                for (int i = 0; i < tableMapList.size(); i++) {
//                    Map<String, Object> mapData = tableMapList.get(i);
//
//                    String expectDateStr = (String)mapData.get("expectDate");
//                    Date expectDate = DateFormat.dateString2Date(expectDateStr, DateFormat.DEFAULT_DATE_FORMAT);
//                    long expectL = expectDate.getTime();
//
//                    if (i == 0) {
//                        minExpectDateLong = expectL;
//                    } else if (i > 0) {
//                        if (expectL < minExpectDateLong) {minExpectDateLong = expectL;}
//                    }
//                }
//            }
        }

        String orderCodes = new String();
        if (orderCodeBuf != null && orderCodeBuf.toString().trim().length() > 0) {
            orderCodes = StringUtil.stringTrimSpace(orderCodeBuf.toString().trim());
        }
        valueMap.put("orderCodes", orderCodes);

//        String expectDateStr = new String();
//        if (minExpectDateLong != -1) {
//            Date expectDate = new Date(minExpectDateLong);
//            expectDateStr = DateFormat.date2String(expectDate, DateFormat.DEFAULT_DATE_FORMAT);
//        }
//        valueMap.put("minExpectDate", expectDateStr);

        return valueMap;
    }

}



