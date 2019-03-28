package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.xy.vmes.service.MobileProductService;
import com.xy.vmes.service.ProductService;
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

import java.math.BigDecimal;
import java.util.*;

@RestController
@Slf4j
public class MobileProductController {
    private Logger logger = LoggerFactory.getLogger(MobileProductController.class);

    @Autowired
    private MobileProductService mobileProductService;
    @Autowired
    private ProductService productService;

    @PostMapping("/mobile/mobileProduct/listPageProducts")
    public ResultModel listPageProducts() throws Exception {
        logger.info("################/mobile/mobileProduct/listPageProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<String> productNameList = (ArrayList<String>)pd.get("genreList");
        if(productNameList!=null&&productNameList.size()>0){
            String[] genreList = productNameList.toArray(new String[productNameList.size()]);
            pd.put("genreList",genreList);
        }else{
            pd.remove("genreList");
        }
        List<Map> varList = mobileProductService.findListPageProduct(pd,pg);


        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProduct/listPageProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileProduct/findProductByQrcode")
    public ResultModel findProductByQrcode() throws Exception {
        logger.info("################/mobile/mobileProduct/findProductByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //货品二维码:= 货品id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品二维码为空或空字符串！");
            return model;
        }

        Map<String, String> productMap = new HashMap<String, String>();
        PageData findMap = new PageData();
        findMap.put("productId", qrcode);
        List<Map> mapList = productService.getDataListPage(findMap);
        if (mapList != null && mapList.size() > 0) {
            Map objectMap = mapList.get(0);

            productMap.put("id", qrcode);
            String code = new String();
            if (objectMap.get("code") != null && objectMap.get("code").toString().trim().length() > 0) {
                code = objectMap.get("code").toString().trim();
                productMap.put("code", code);
            }

            String name = new String();
            if (objectMap.get("name") != null && objectMap.get("name").toString().trim().length() > 0) {
                name = objectMap.get("name").toString().trim();
                productMap.put("name", name);
            }

            String spec = new String();
            if (objectMap.get("spec") != null && objectMap.get("spec").toString().trim().length() > 0) {
                spec = objectMap.get("spec").toString().trim();
                productMap.put("spec", spec);
            }

            String genre = new String();
            if (objectMap.get("genre") != null && objectMap.get("genre").toString().trim().length() > 0) {
                genre = objectMap.get("genre").toString().trim();
                productMap.put("genre", genre);
            }

            String genreName = new String();
            if (objectMap.get("genreName") != null && objectMap.get("genreName").toString().trim().length() > 0) {
                genreName = objectMap.get("genreName").toString().trim();
                productMap.put("genreName", genreName);
            }

            String unit = new String();
            if (objectMap.get("unit") != null && objectMap.get("unit").toString().trim().length() > 0) {
                unit = objectMap.get("unit").toString().trim();
                productMap.put("unit", unit);
            }

            String unitName = new String();
            if (objectMap.get("unitName") != null && objectMap.get("unitName").toString().trim().length() > 0) {
                unitName = objectMap.get("unitName").toString().trim();
                productMap.put("unitName", unitName);
            }

            productMap.put("price", "");
            if (objectMap.get("price") != null) {
                productMap.put("price", ((BigDecimal)objectMap.get("price")).toString());
            }

            productMap.put("stockCount", "");
            if (objectMap.get("stockCount") != null) {
                productMap.put("stockCount", ((BigDecimal)objectMap.get("stockCount")).toString());
            }

            productMap.put("lockCount", "");
            if (objectMap.get("lockCount") != null) {
                productMap.put("lockCount", ((BigDecimal)objectMap.get("lockCount")).toString());
            }
        }

        String jsonStr = new String();
        if (productMap.size() > 0) {
            jsonStr = YvanUtil.toJson(productMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProduct/findProductByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
