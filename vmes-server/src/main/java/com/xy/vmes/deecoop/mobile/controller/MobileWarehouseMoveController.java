package com.xy.vmes.deecoop.mobile.controller;

import com.yvan.common.util.Common;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@Slf4j
public class MobileWarehouseMoveController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseMoveController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MobileWarehouseMoveService mobileWarehouseMoveService;
    @Autowired
    private WarehouseMoveService warehouseMoveService;
    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;
    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    // 获得移库任务详细信息
    @PostMapping("/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId")
    //@GetMapping("/mobileWarehouseMove/findWarehouseMoveByDetailId")
    public ResultModel findWarehouseMoveByDetailId()  throws Exception {

        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.findWarehouseMove(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }



    @PostMapping("/mobile/mobileWarehouseMove/addWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseMoveExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseMove/addWarehouseMoveExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.addWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/addWarehouseMoveExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseMoveDetail() throws Exception {
        logger.info("################/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseMoveService.rebackWarehouseMoveDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/rebackWarehouseMoveDetail执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 货品履历
     * 获取货品移库执行 warehouseMoveExecute<String, Object>
     * warehouseMoveExecute: {
     *     product: {code:批次号,productId:货品id, productCode:货品编号,productName:货品名称,productSpec:货品规格型号,productGenreName:货品属性,productUnitName:货品单位,
     *         typeName:移库类型,count:移库数量,executeDate:完成时间
     *     }
     *     moveExecute: [{sourceWarehousePathName:(源)仓库路径, executeUserName:执行人姓名, executeCount:移库数量},
     *                  {targetWarehousePathName:(目标)仓库路径}]
     * }
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseMove/findWarehouseMoveExecuteByProduct")
    //@GetMapping("/mobile/mobileWarehouseMove/findWarehouseMoveExecuteByProduct")
    public ResultModel findWarehouseMoveExecuteByProduct() throws Exception {
        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveExecuteByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        String code = pageData.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串！");
            return model;
        }

        //移库执行Map 接口返回值
        Map<String, Object> warehouseMoveExecuteMap = new HashMap<String, Object>();
        PageData findMap = new PageData();

        //根据(移库单id,货品id,批次号)-查询vmes_warehouse_move_detail-按(货品id,批次号)汇总-获取移库数量
        List<Map<String, Object>> detailProductMapList = null;
        try {
            findMap.put("companyId", companyId);
            findMap.put("parentId", parentId);
            findMap.put("productId", productId);
            findMap.put("code", code);
            detailProductMapList = warehouseMoveDetailService.findMoveDetailByProductMapList(companyId, productId, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, BigDecimal> moveProductMap = warehouseMoveDetailService.findProductMapByMapList(detailProductMapList);

        //根据(移库单id,货品id,批次号)-查询vmes_warehouse_move_execute-按(货品id,批次号)汇总-获取移库完成时间
        //移库明细状态(0:待派单 1:执行中 2:已完成)
        String executeDateStr = warehouseMoveExecuteService.findMoveExecuteDateByProduct(companyId,
                parentId,
                productId,
                code,
                "2");

        //根据(移库id) 获取移库单Map
        Map warehouseMoveMap = new HashMap();
        List<Map> moveList = null;
        try {
            findMap = new PageData();
            findMap.put("parentId", parentId);
            moveList = warehouseMoveService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (moveList != null && moveList.size() > 0) {
            warehouseMoveMap = moveList.get(0);
        }

        //根据(货品id)查询 vmes_product 获取货品表对象
        Map<String, String> productMap = new HashMap<String, String>();
        List<Map> mapList = null;
        try {
            findMap = new PageData();
            findMap.put("productId", productId);
            mapList = productService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mapList != null && mapList.size() > 0) {
            productMap = productService.queryMap2ProductMap(mapList.get(0));

            //设置出库信息
            //移库类型 typeName
            String typeName = new String();
            if (warehouseMoveMap.get("typeName") != null) {
                typeName = warehouseMoveMap.get("typeName").toString().trim();
            }
            productMap.put("typeName", typeName);

            //移库数量 count
            productMap.put("count", "0");
            String moveProdMapKey = productId + "," + code;
            if (moveProductMap != null && moveProductMap.get(moveProdMapKey) != null) {
                productMap.put("count", moveProductMap.get(moveProdMapKey).toString());
            }

            //移库完成日期 executeDate
            productMap.put("executeDate", executeDateStr);
        }

        //根据(移库单id,货品id,批次号) 获取移库执行ListMap
        List<Map<String, Object>> executeList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> moveExecuteList = warehouseMoveExecuteService.findMoveExecuteMapList(companyId, parentId, productId, code);
        if (moveExecuteList != null && moveExecuteList.size() > 0) {
            for (Map<String, Object> mapObject : moveExecuteList) {
                Map<String, Object> mapValue = new HashMap<String, Object>();

                //移库数量 executeCount count
                String executeCount = "0";
                if (mapObject.get("count") != null) {
                    BigDecimal count_big = (BigDecimal)mapObject.get("count");
                    //四舍五入到2位小数
                    count_big = count_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    executeCount = count_big.toString();
                }
                mapValue.put("executeCount", executeCount);

                //(源)仓库路径 sourceWarehousePathName pathName
                String sourceWarehousePathName = new String();
                if (mapObject.get("pathName") != null) {
                    sourceWarehousePathName = mapObject.get("pathName").toString().trim();
                }
                mapValue.put("sourceWarehousePathName", sourceWarehousePathName);

                //执行人姓名 executeUserName executorName
                String executeUserName = new String();
                if (mapObject.get("executorName") != null) {
                    executeUserName = mapObject.get("executorName").toString().trim();
                }
                mapValue.put("executeUserName", executeUserName);

                executeList.add(mapValue);
            }
        }

        //移库目标货位
        String targetWarehousePathName = new String();
        if (warehouseMoveMap != null && warehouseMoveMap.get("warehouseName") != null) {
            targetWarehousePathName = warehouseMoveMap.get("warehouseName").toString().trim();
        }

        Map<String, Object> mapValue = new HashMap<String, Object>();
        mapValue.put("targetWarehousePathName", targetWarehousePathName);
        executeList.add(mapValue);

        warehouseMoveExecuteMap.put("product", productMap);
        warehouseMoveExecuteMap.put("moveExecute", executeList);
        model.put("warehouseMoveExecute", warehouseMoveExecuteMap);

//        String jsonStr = new String();
//        if (warehouseMoveExecuteMap.size() > 0) {
//            jsonStr = YvanUtil.toJson(warehouseMoveExecuteMap);
//        }
//        System.out.println("warehouseMoveExecuteJsonStr:" + jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseMove/findWarehouseMoveExecuteByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
