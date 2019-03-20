package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.WarehouseProductService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseProductController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseProductController.class);

    @Autowired
    private WarehouseProductService warehouseProductService;

    @PostMapping("/mobile/mobileWarehouseProduct/listPageWarehouseByProduct")
    //@GetMapping("/mobileWarehouseProduct/listPageWarehouseByProduct")
    public ResultModel listPageWarehouseByProduct()  throws Exception {
        logger.info("################/mobile/mobileWarehouseProduct/listPageWarehouseByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varList = warehouseProductService.findListPageWarehouseByProduct(pd,pg);


        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseProduct/listPageWarehouseByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseProduct/findWarehouseProductByQrcode")
    public ResultModel findWarehouseProductByQrcode() throws Exception {
        logger.info("################/mobile/mobileWarehouseProduct/findWarehouseProductByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //仓库货位二维码:= 仓库货位id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货位二维码为空或空字符串！");
            return model;
        }

        Map<String, String> warehouseProductMap = new HashMap<String, String>();
        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(qrcode);
        if (warehouseProduct != null && warehouseProduct.getWarehouseId() != null && warehouseProduct.getWarehouseId().trim().length() > 0) {
            warehouseProductMap.put("warehouseId", warehouseProduct.getWarehouseId().trim());
        }
        if (warehouseProduct != null && warehouseProduct.getProductId() != null && warehouseProduct.getProductId().trim().length() > 0) {
            warehouseProductMap.put("productId", warehouseProduct.getProductId().trim());
        }
        if (warehouseProduct != null && warehouseProduct.getCode() != null && warehouseProduct.getCode().trim().length() > 0) {
            warehouseProductMap.put("code", warehouseProduct.getCode().trim());
        }

        String jsonStr = new String();
        if (warehouseProductMap.size() > 0) {
            jsonStr = YvanUtil.toJson(warehouseProductMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseProduct/findWarehouseProductByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
