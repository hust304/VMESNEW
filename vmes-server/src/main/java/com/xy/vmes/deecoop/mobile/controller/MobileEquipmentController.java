package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.service.EquipmentService;
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

@RestController
@Slf4j
public class MobileEquipmentController {
    private Logger logger = LoggerFactory.getLogger(MobileEquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/mobile/mobileEquipment/findEquipmentByQrcode")
    public ResultModel findEquipmentByQrcode() throws Exception {
        logger.info("################/mobile/mobileEquipment/findEquipmentByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //设备二维码:= 设备id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("设备二维码为空或空字符串！");
            return model;
        }

        Map<String, String> equipmentMap = new HashMap<String, String>();
        PageData findMap = new PageData();
        findMap.put("equipmentId", qrcode);
        List<Map> mapList = equipmentService.getDataListPage(findMap);
        if (mapList != null && mapList.size() > 0) {
            Map objectMap = mapList.get(0);

            String code = new String();
            if (objectMap.get("code") != null && objectMap.get("code").toString().trim().length() > 0) {
                code = objectMap.get("code").toString().trim();
                equipmentMap.put("code", code);
            }

            String name = new String();
            if (objectMap.get("name") != null && objectMap.get("name").toString().trim().length() > 0) {
                name = objectMap.get("name").toString().trim();
                equipmentMap.put("name", name);
            }

            String spec = new String();
            if (objectMap.get("spec") != null && objectMap.get("spec").toString().trim().length() > 0) {
                spec = objectMap.get("spec").toString().trim();
                equipmentMap.put("spec", spec);
            }

            String type = new String();
            if (objectMap.get("type") != null && objectMap.get("type").toString().trim().length() > 0) {
                type = objectMap.get("type").toString().trim();
                equipmentMap.put("type", type);
            }

            String typeName = new String();
            if (objectMap.get("typeName") != null && objectMap.get("typeName").toString().trim().length() > 0) {
                typeName = objectMap.get("typeName").toString().trim();
                equipmentMap.put("typeName", typeName);
            }
        }

        String jsonStr = new String();
        if (equipmentMap.size() > 0) {
            jsonStr = YvanUtil.toJson(equipmentMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileEquipment/findEquipmentByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
