package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@Slf4j
public class MobileWarehouseOutController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseOutController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MobileWarehouseOutService mobileWarehouseOutService;
    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    @PostMapping("/mobile/mobileWarehouseOut/findWarehouseOutByDetailId")
    //@GetMapping("/mobileWarehouseOut/findWarehouseOutByDetailId")
    public ResultModel findWarehouseOutByDetailId()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehouseOutByDetailId(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehouseOutByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    @PostMapping("/mobile/mobileWarehouseOut/findWarehousePathByQrcode")
    public ResultModel findWarehousePathByQrcode()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehousePathByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehousePathByQrcode(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehousePathByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobile/mobileWarehouseOut/listWarehousePathByProduct")
    public ResultModel listWarehousePathByProduct()  throws Exception {
        logger.info("################/mobileWarehouseOut/listWarehousePathByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.listWarehousePathByProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/listWarehousePathByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseOut/listWarehouseCodeByWarehouseId")
    public ResultModel listWarehouseCodeByWarehouseId()  throws Exception {
        logger.info("################/mobileWarehouseOut/listWarehouseCodeByWarehouseId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.listWarehouseCodeByWarehouseId(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/listWarehouseCodeByWarehouseId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/mobile/mobileWarehouseOut/findWarehouseCodeByQrcode")
    public ResultModel findWarehouseCodeByQrcode()  throws Exception {
        logger.info("################/mobileWarehouseOut/findWarehouseCodeByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.findWarehouseCodeByQrcode(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/findWarehouseCodeByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    @PostMapping("/mobile/mobileWarehouseOut/addWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOutExecute() throws Exception {
        logger.info("################/mobileWarehouseOut/addWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.addWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/addWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    @PostMapping("/mobile/mobileWarehouseOut/rebackWarehouseOutDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseOutDetail() throws Exception {
        logger.info("################/mobileWarehouseOut/rebackWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseOutService.rebackWarehouseOutDetail(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseOut/rebackWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 货品履历
     * 获取货品出库执行 warehouseOutExecute<String, Object>
     * warehouseOutExecute: {
     *     product: {code:批次号,productId:货品id, productCode:货品编号,productName:货品名称,productSpec:货品规格型号,productGenreName:货品属性,productUnitName:货品单位,
     *         typeName:出库类型,deptName:来源单位,count:出库数量,executeDate:完成时间
     *     }
     *     outExecute: [{warehousePathName:仓库路径, executeUserName:执行人姓名, executeCount:出库数量},]
     * }
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseOut/findWarehouseOutExecuteByDetailId")
    //@GetMapping("/mobile/mobileWarehouseOut/findWarehouseOutExecuteByDetailId")
    public ResultModel findWarehouseOutExecuteByDetailId() throws Exception {
        logger.info("################/mobile/mobileWarehouseOut/findWarehouseOutExecuteByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //出库明细id detailId
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("出库明细id为空或空字符串！");
            return model;
        }

        //出库执行Map 接口返回值
        PageData findMap = new PageData();
        Map<String, Object> warehouseOutExecuteMap = new HashMap<String, Object>();

        //根据(出库明细id) 获取出库明细表对象
        WarehouseOutDetail detail = warehouseOutDetailService.findWarehouseOutDetailById(detailId);
        String productId = detail.getProductId();
        String parentId = detail.getParentId();

        //根据(出库id) 获取出库单Map
        Map warehouseOutMap = new HashMap();
        List<Map> outList = null;
        try {
            findMap.put("parentId", parentId);
            outList = warehouseOutService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (outList != null && outList.size() > 0) {
            warehouseOutMap = outList.get(0);
        }

        //根据(出库明细id) 获取该(出库明细id)出库执行ListMap
        List<Map> outExecuteList = null;
        try {
            findMap = new PageData();
            findMap.put("detailId", detailId);
            outExecuteList = warehouseOutExecuteService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
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
            //出库类型 typeName
            String typeName = new String();
            if (warehouseOutMap.get("typeName") != null) {
                typeName = warehouseOutMap.get("typeName").toString().trim();
            }
            productMap.put("typeName", typeName);

            //来源单位 deptName
            String deptName = new String();
            if (warehouseOutMap.get("deptName") != null) {
                deptName = warehouseOutMap.get("deptName").toString().trim();
            }
            productMap.put("deptName", deptName);

            //出库数量 count
            String count = new String("0");
            if (detail.getCount() != null) {
                //四舍五入到2位小数
                BigDecimal count_big = detail.getCount();
                count_big = count_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                count = count_big.toString();
            }
            productMap.put("count", count);

            //出库完成日期 executeDate
            productMap.put("executeDate", "");
            //出库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if ("2".equals(detail.getState())) {
                Long executeDateLong = warehouseOutExecuteService.findMaxExecuteDateByMapList(outExecuteList);
                if (executeDateLong != null && executeDateLong.longValue() > 0) {
                    Date executeDate = new Date();
                    executeDate.setTime(executeDateLong.longValue());

                    String executeDateStr = new String();
                    try {
                        executeDateStr = DateFormat.date2String(executeDate, DateFormat.DEFAULT_DATETIME_FORMAT);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    productMap.put("executeDate", executeDateStr);
                }
            }
        }

        List<Map<String, Object>> executeList = new ArrayList<Map<String, Object>>();
        if (outExecuteList != null && outExecuteList.size() > 0) {
            for (Map<String, Object> mapObject : outExecuteList) {
                Map<String, Object> mapValue = new HashMap<String, Object>();

                //出库数量 executeCount actualCount
                String executeCount = "0";
                if (mapObject.get("actualCount") != null) {
                    BigDecimal count_big = (BigDecimal)mapObject.get("actualCount");
                    //四舍五入到2位小数
                    count_big = count_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    executeCount = count_big.toString();
                }
                mapValue.put("executeCount", executeCount);

                //仓库路径 warehousePathName name
                String warehousePathName = new String();
                if (mapObject.get("name") != null) {
                    warehousePathName = mapObject.get("name").toString().trim();
                }
                mapValue.put("warehousePathName", warehousePathName);

                //执行人姓名 executeUserName executorName
                String executeUserName = new String();
                if (mapObject.get("executorName") != null) {
                    executeUserName = mapObject.get("executorName").toString().trim();
                }
                mapValue.put("executeUserName", executeUserName);

                executeList.add(mapValue);
            }
        }

        warehouseOutExecuteMap.put("product", productMap);
        warehouseOutExecuteMap.put("outExecute", executeList);
        model.put("warehouseOutExecute", warehouseOutExecuteMap);

//        String jsonStr = new String();
//        if (warehouseOutExecuteMap.size() > 0) {
//            jsonStr = YvanUtil.toJson(warehouseOutExecuteMap);
//        }
//        System.out.println("warehouseOutExecuteJsonStr:" + jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseOut/findWarehouseOutExecuteByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
