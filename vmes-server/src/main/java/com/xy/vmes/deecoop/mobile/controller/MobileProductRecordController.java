package com.xy.vmes.deecoop.mobile.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.*;
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
public class MobileProductRecordController {
    private Logger logger = LoggerFactory.getLogger(MobileProductRecordController.class);

    @Autowired
    private MobileProductRecordService mobileProductRecordService;

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseOutRecommendService warehouseOutRecommendService;
    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @PostMapping("/mobile/mobileProductRecord/findListProductRecord")
    public ResultModel findListProductRecord() throws Exception {
        logger.info("################/mobile/mobileProductRecord/listPageProductRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData findMap = new PageData();
        PageData pd = HttpUtils.parsePageData();
        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        findMap.put("companyId", companyId);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map<String, Object>> varList = mobileProductRecordService.findListProductRecord(findMap, pg);

        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/findListProductRecord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileProductRecord/findListProductRecordByCode")
    public ResultModel findListProductRecordByCode() throws Exception {
        logger.info("################/mobile/mobileProductRecord/findListProductRecordByCode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData findMap = new PageData();
        PageData pd = HttpUtils.parsePageData();

        String code = pd.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串！");
            return model;
        }
        findMap.put("code", code);

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        findMap.put("companyId", companyId);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map<String, Object>> varList = mobileProductRecordService.findListProductRecordByCode(findMap, pg);

        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/findListProductRecordByCode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取货品履历 prodRecordMap<String, Object>
     * prodRecordMap: {
     *     product: {code:批次号,productId:货品id, productCode:货品编号,productName:货品名称,productSpec:货品规格型号,productGenreName:货品属性,productUnitName:货品单位,stockCount:库存数量}
     *     warehouse: [{warehouseProductId:货位货品id, warehouseId:货位id, warehouseStockCount:库存数量, warehousePathName:仓库路径名称},]
     *     in:  [{detailId:入库单明细id,parentCode:入库单编号,detailCount:入库数量, type:in},]
     *     out: [{detailId:出库单明细id,parentCode:出库单编号,detailCount:出库数量, type:out},]
     *     move: [{detailId:移库单明细id,parentCode:移库单编号,detailCount:移库数量, type:move},]
     * }
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/mobile/mobileProductRecord/findProductRecordByProduct")
    public ResultModel findProductRecordByProduct() throws Exception {
        logger.info("################/mobile/mobileProductRecord/findProductRecordByProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String productId = pd.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        String code = pd.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串！");
            return model;
        }

        //货品履历Map 接口返回值
        Map<String, Object> prodRecordMap = new HashMap<String, Object>();

        //1. 根据(货品id)查询 vmes_product 获取货品表对象
        Map<String, String> productMap = new HashMap<String, String>();

        PageData findMap = new PageData();
        findMap.put("productId", productId);
        List<Map> mapList = null;
        try {
            mapList = productService.getDataListPage(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mapList != null && mapList.size() > 0) {
            productMap = productService.queryMap2ProductMap(mapList.get(0), productMap);
            productMap.put("code", code);
        }
        prodRecordMap.put("product", productMap);

        //2. 根据(企业id, 货品id, 批次号) 查询 vmes_warehouse_product
        List<Map<String, String>> warehouseList = warehouseProductService.findWarehouseProductMapList(companyId, productId, code);
        prodRecordMap.put("warehouse", warehouseList);

        //3. 根据(企业id, 货品id, 批次号) 查询  vmes_warehouse_in_detail
        List<Map<String, String>> inList = warehouseInDetailService.findWarehouseInMapList(companyId, productId, code);
        prodRecordMap.put("in", inList);

        //4. 根据(企业id, 货品id, 批次号) 查询  vmes_warehouse_out_recommend
        List<Map<String, String>> outList = warehouseOutRecommendService.findWarehouseOutMapList(companyId, productId, code);
        prodRecordMap.put("out", outList);

        //5. 根据(企业id, 货品id, 批次号) 查询  vmes_warehouse_move_detail
        List<Map<String, String>> moveList = warehouseMoveDetailService.findWarehouseMoveMapList(companyId, productId, code);
        prodRecordMap.put("move", moveList);

        String productRecordJsonStr = new String();
        if (productMap.size() > 0) {
            productRecordJsonStr = YvanUtil.toJson(prodRecordMap);
        }
        System.out.println("productRecordJsonStr:" + productRecordJsonStr);

        model.put("productRecord", prodRecordMap);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileProductRecord/findProductRecordByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
