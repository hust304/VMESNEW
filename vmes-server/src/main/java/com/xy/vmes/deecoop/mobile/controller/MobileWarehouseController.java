package com.xy.vmes.deecoop.mobile.controller;


import com.xy.vmes.service.MobileWarehouseService;
import com.xy.vmes.service.WarehouseService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 说明：(手机端)vmes_warehouse:仓库货位表Controller
 */
@RestController
@Slf4j
public class MobileWarehouseController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseController.class);

    @Autowired
    private MobileWarehouseService mobileWarehouseService;

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/mobile/mobileWarehouse/findEmployeeInfo")
    public ResultModel findEmployeeInfo()  throws Exception {
        logger.info("################/mobile/mobileWarehouseService/findEmployeeInfo 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseService.findEmployeeInfo(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseService/findEmployeeInfo 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

    @PostMapping("/mobile/mobileWarehouse/findWarehouseByQrcode")
    public ResultModel findWarehouseByQrcode() throws Exception {
        logger.info("################/mobile/mobileWarehouse/findWarehouseByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //货位二维码:= 货位id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货位二维码为空或空字符串！");
            return model;
        }

        Map<String, String> warehouseMap = new HashMap<String, String>();
        PageData findMap = new PageData();
        findMap.put("warehouseId", qrcode);
        List<Map> mapList = warehouseService.getDataListPage(findMap);
        if (mapList != null && mapList.size() > 0) {
            Map objectMap = mapList.get(0);

            warehouseMap.put("id", qrcode);
            String code = new String();
            if (objectMap.get("code") != null && objectMap.get("code").toString().trim().length() > 0) {
                code = objectMap.get("code").toString().trim();
                warehouseMap.put("code", code);
            }

            String name = new String();
            if (objectMap.get("name") != null && objectMap.get("name").toString().trim().length() > 0) {
                name = objectMap.get("name").toString().trim();
                warehouseMap.put("name", name);
            }

            String pathId = new String();
            if (objectMap.get("pathId") != null && objectMap.get("pathId").toString().trim().length() > 0) {
                pathId = objectMap.get("pathId").toString().trim();
                warehouseMap.put("pathId", pathId);
            }

            String pathName = new String();
            if (objectMap.get("pathName") != null && objectMap.get("pathName").toString().trim().length() > 0) {
                pathName = objectMap.get("pathName").toString().trim();
                warehouseMap.put("pathName", pathName);
            }

        }

        String jsonStr = new String();
        if (warehouseMap.size() > 0) {
            jsonStr = YvanUtil.toJson(warehouseMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouse/findWarehouseByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
