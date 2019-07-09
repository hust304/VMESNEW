package com.xy.vmes.deecoop.mobile.controller;

import com.yvan.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.*;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@Slf4j
public class MobileWarehouseInController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private MobileWarehouseInService mobileWarehouseInService;
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;

    //获得入库任务详细信息
    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInByDetailId")
    public ResultModel findWarehouseInByDetailId()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.findWarehouseIn(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    /**
     * 手机端
     * 新增入库单明细执行
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.addWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行___手机端复用
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.rebackWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 通过Pid查找下级库位信息
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/listWarehouseNodeByPid")
    public ResultModel listWarehouseNodeByPid()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.listWarehouseNodeByPid(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode")
    public ResultModel findWarehouseInDetailByQrcode() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //货品货位二维码:= 入库明细id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品货位二维码(入库明细id)为空或空字符串！");
            return model;
        }

        Map<String, String> warehouseInDtlMap = new HashMap<String, String>();
        WarehouseInDetail inDetail = warehouseInDetailService.findWarehouseInDetailById(qrcode);
        if (inDetail != null) {
            if (inDetail.getWarehouseId() != null && inDetail.getWarehouseId().trim().length() > 0) {
                warehouseInDtlMap.put("warehouseId", inDetail.getWarehouseId().trim());
            }

            if (inDetail.getParentId() != null && inDetail.getParentId().trim().length() > 0) {
                warehouseInDtlMap.put("productId", inDetail.getParentId().trim());
            }

            if (inDetail.getCode() != null && inDetail.getCode().trim().length() > 0) {
                warehouseInDtlMap.put("code", inDetail.getCode().trim());
            }
        }

        String jsonStr = new String();
        if (warehouseInDtlMap.size() > 0) {
            jsonStr = YvanUtil.toJson(warehouseInDtlMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 货品履历
     * 获取货品入库执行 warehouseInExecute<String, Object>
     * warehouseInExecute: {
     *     product: {code:批次号,productId:货品id, productCode:货品编号,productName:货品名称,productSpec:货品规格型号,productGenreName:货品属性,productUnitName:货品单位,
     *         typeName:入库类型,deptName:来源单位,count:入库数量,executeDate:完成时间
     *     }
     *     inExecute: [{warehousePathName:仓库路径, executeUserName:执行人姓名, executeCount:入库数量},]
     * }
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInExecuteByDetailId")
    //@GetMapping("/mobile/mobileWarehouseIn/findWarehouseInExecuteByDetailId")
    public ResultModel findWarehouseInExecuteByDetailId() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInExecuteByDetailId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //入库明细id detailId
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("入库明细id为空或空字符串！");
            return model;
        }

        //入库执行Map 接口返回值
        PageData findMap = new PageData();
        Map<String, Object> warehouseInExecuteMap = new HashMap<String, Object>();

        //根据(入库明细id) 获取入库明细表对象
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        String productId = detail.getProductId();
        String parentId = detail.getParentId();

        //根据(入库id) 获取入库单Map
        Map warehouseInMap = new HashMap();
        List<Map> inList = null;
        try {
            findMap.put("parentId", parentId);
            inList = warehouseInService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (inList != null && inList.size() > 0) {
            warehouseInMap = inList.get(0);
        }

        //根据(入库明细id) 获取该(入库明细id)入库执行ListMap
        List<Map> inExecuteList = null;
        try {
            findMap.put("detailId", detailId);
            inExecuteList = warehouseInExecuteService.findListWarehouseInExecuteByEdit(findMap);
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

            //设置入库信息
            //入库类型 typeName
            String typeName = new String();
            if (warehouseInMap.get("typeName") != null) {
                typeName = warehouseInMap.get("typeName").toString().trim();
            }
            productMap.put("typeName", typeName);

            //来源单位 deptName
            String deptName = new String();
            if (warehouseInMap.get("deptName") != null) {
                deptName = warehouseInMap.get("deptName").toString().trim();
            }
            productMap.put("deptName", deptName);

            //入库数量 count
            String count = new String("0");
            if (detail.getCount() != null) {
                //四舍五入到2位小数
                BigDecimal count_big = detail.getCount();
                count_big = count_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                count = count_big.toString();
            }
            productMap.put("count", count);

            //入库完成日期 executeDate
            productMap.put("executeDate", "");
            //入库明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if ("2".equals(detail.getState())) {
                Long executeDateLong = warehouseInExecuteService.findMaxExecuteDateByMapList(inExecuteList);
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
        if (inExecuteList != null && inExecuteList.size() > 0) {
            for (Map<String, Object> mapObject : inExecuteList) {
                Map<String, Object> mapValue = new HashMap<String, Object>();

                //入库数量 executeCount count
                String executeCount = "0";
                if (mapObject.get("count") != null) {
                    BigDecimal count_big = (BigDecimal)mapObject.get("count");
                    //四舍五入到2位小数
                    count_big = count_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    executeCount = count_big.toString();
                }
                mapValue.put("executeCount", executeCount);

                //仓库路径 warehousePathName pathName
                String warehousePathName = new String();
                if (mapObject.get("pathName") != null) {
                    warehousePathName = mapObject.get("pathName").toString().trim();
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

        warehouseInExecuteMap.put("product", productMap);
        warehouseInExecuteMap.put("inExecute", executeList);
        model.put("warehouseInExecute", warehouseInExecuteMap);

//        String jsonStr = new String();
//        if (warehouseInExecuteMap.size() > 0) {
//            jsonStr = YvanUtil.toJson(warehouseInExecuteMap);
//        }
//        System.out.println("warehouseInExecuteJsonStr:" + jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInExecuteByDetailId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
