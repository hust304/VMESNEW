package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.service.ProducePlanDetailService;

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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_produce_plan_detail:生产计划明细Controller
* @author 陈刚 自动生成
* @date 2020-02-27
*/
@RestController
@Slf4j
public class ProducePlanDetailController {
    private Logger logger = LoggerFactory.getLogger(ProducePlanDetailController.class);

    @Autowired
    private ProducePlanDetailService producePlanDetailService;

    @Autowired
    private SaleOrderDetailService orderDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-02-27
    */
    @PostMapping("/produce/producePlanDetail/listPageProducePlanDetail")
    public ResultModel listPageProducePlanDetail() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageProducePlanDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 生产计划明细(检验)报工
     * @author 陈刚
     * @date 2020-02-27
     */
    @PostMapping("/produce/producePlanDetail/listPageProducePlanDetailByQuality")
    public ResultModel listPageProducePlanDetailByQuality() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetailByQuality 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageProducePlanDetailByQuality(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageProducePlanDetailByQuality 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2020-02-27
     */
    @PostMapping("/produce/producePlanDetail/listPageMaterialRequisition")
    public ResultModel listPageMaterialRequisition() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisition 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageMaterialRequisition(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisition 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2020-02-27
     */
    @PostMapping("/produce/producePlanDetail/listPageMaterialRequisitionGroup")
    public ResultModel listPageMaterialRequisitionGroup() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisitionGroup 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageMaterialRequisitionGroup(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisitionGroup 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2020-02-27
     */
    @PostMapping("/produce/producePlanDetail/listPageMaterialRequisitionGroupDetail")
    public ResultModel listPageMaterialRequisitionGroupDetail() throws Exception {
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisitionGroupDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanDetailService.listPageMaterialRequisitionGroupDetail(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/listPageMaterialRequisitionGroupDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 按货品合并-生产计划明细
     * @return
     * @throws Exception
     */
    @PostMapping("/produce/producePlanDetail/mergeProductByProducePlanDetail")
    public ResultModel mergeProductByProducePlanDetail() throws Exception {
        logger.info("################/produce/producePlanDetail/mergeProductByProducePlanDetail 执行开始 ################# ");
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

            //获取订单编号',' 逗号分隔的字符串
            String orderCodes = this.findOrderCodeByMapList(mapTempList);
            productMap.put("orderCode", orderCodes);

            mergeProductMapList.add(productMap);
        }

        model.put("mergeProductList", mergeProductMapList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlanDetail/mergeProductByProducePlanDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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


    private String findOrderCodeByMapList(List<Map<String, String>> mapList) throws Exception {
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

        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
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
        if (orderDtlIdBuf != null && orderDtlIdBuf.toString().trim().length() > 0) {
            String orderDtlIds = StringUtil.stringTrimSpace(orderDtlIdBuf.toString().trim());
            orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("ids", orderDtlIds);
            List<Map> tableMapList = orderDetailService.getDataListPage(findMap, null);
            if (tableMapList != null && tableMapList.size() > 0) {
                for (Map<String, Object> mapData : tableMapList) {
                    String sysCode = (String)mapData.get("sysCode");
                    if (sysCode != null && sysCode.trim().length() > 0) {
                        orderCodeBuf.append(sysCode).append(",");
                    }
                }
            }
        }

        String orderCodes = new String();
        if (orderCodeBuf != null && orderCodeBuf.toString().trim().length() > 0) {
            orderCodes = StringUtil.stringTrimSpace(orderCodeBuf.toString().trim());
        }

        return orderCodes;
    }

}



