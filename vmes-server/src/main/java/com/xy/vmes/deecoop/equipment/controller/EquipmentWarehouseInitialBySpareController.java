package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.*;
import com.yvan.common.util.Common;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

/**
 * 说明：vmes_warehouse_initial: 仓库初始化设定Controller
 * @author 陈刚
 * @date 2019-06-25
 */
@RestController
@Slf4j
public class EquipmentWarehouseInitialBySpareController {
    private Logger logger = LoggerFactory.getLogger(EquipmentWarehouseInitialBySpareController.class);

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;


    /**
     * (备件库)修改仓库货品(库存数量)
     * @author 陈刚
     * @date 2019-06-25
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseInitialBySpare/updateWarehouseProductBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProductBySpare() throws Exception {
        logger.info("################/equipment/warehouseInitialBySpare/updateWarehouseProductBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库货品id(库存id)为空或空字符串！");
            return model;
        }

        //非空数据有效验证
        //库存数量 stockCount
        String stockCountStr = pageData.getString("stockCount");
        BigDecimal stockCountBig = BigDecimal.valueOf(0D);
        if (stockCountStr == null || stockCountStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("库存数量为空或空字符串，库存数量为必填项不可为空！");
            return model;
        } else {
            stockCountStr = stockCountStr.trim();
            try {
                //全数字
                BigDecimal bigDecimal = new BigDecimal(stockCountStr);
                //四舍五入到2位小数
                stockCountBig = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                String msg_column_error = "{0}:{1} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;
                String str_error = MessageFormat.format(msg_column_error, "库存数量", stockCountStr);
                model.putCode(Integer.valueOf(1));
                model.putMsg(str_error);
                return model;
            }
        }

        //安全库存数量 productSafetyCount
        String productSafetyCountStr = pageData.getString("productSafetyCount");
        BigDecimal productSafetyCountBig = BigDecimal.valueOf(0D);
        if (productSafetyCountStr != null && productSafetyCountStr.trim().length() > 0) {
            productSafetyCountStr = productSafetyCountStr.trim();
            try {
                //全数字
                BigDecimal bigDecimal = new BigDecimal(productSafetyCountStr);
                //四舍五入到2位小数
                productSafetyCountBig = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                String msg_column_error = "{0}:{1} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;
                String str_error = MessageFormat.format(msg_column_error, "安全库存数量", productSafetyCountStr);
                model.putCode(Integer.valueOf(1));
                model.putMsg(str_error);
                return model;
            }
        }

        //变更前(库存数量)
        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            beforeCountBig = warehouseProduct.getStockCount();
        }

        //当前货品库存数量
        Product product = productService.findProductById(warehouseProduct.getProductId());
        BigDecimal prodCount = BigDecimal.valueOf(0D);
        if (product.getStockCount() != null) {
            prodCount = product.getStockCount();
        }

        //变更后(库存数量)
        BigDecimal afterCountBig = stockCountBig;

        //货品变更数量:= 变更后数量 - 变更前数量
        BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
        if (modifyCount.doubleValue() != 0D) {
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setCuser(cuser);
            loginfo.setCompanyId(companyId);
            //操作变更前数量(业务相关)
            loginfo.setBeforeCount(beforeCountBig);
            //操作变更后数量(业务相关)
            loginfo.setAfterCount(afterCountBig);
            warehouseProductService.updateStockCount(warehouseProduct,
                    modifyCount,
                    loginfo);

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
            //四舍五入到2位小数
            prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            productService.updateStockCount(product, prodStockCount, cuser);
        }

        //修改安全库存
        Product productEdit = new Product();
        productEdit.setId(product.getId());
        //安全库存数量 safetyCount
        productEdit.setSafetyCount(productSafetyCountBig);
        productService.update(productEdit);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/updateWarehouseProductBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (备件库)删除仓库货品(删除库存记录)
     * @author 陈刚
     * @date 2019-06-25
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseInitialBySpare/deleteWarehouseProductBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProductBySpare() throws Exception {
        logger.info("################/equipment/warehouseInitialBySpare/deleteWarehouseProductBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库货品id(库存id)为空或空字符串！");
            return model;
        }

        //获取仓库货品库存数量
        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        BigDecimal stockCount = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            stockCount = warehouseProduct.getStockCount();
        }
        //删除库存表(vmes_warehouse_product:仓库货位产品库存表)
        warehouseProductService.deleteById(id);

        //获取货品表(库存数量)
        String productId = warehouseProduct.getProductId();
        Product product = productService.findProductById(productId);
        BigDecimal prodCount = BigDecimal.valueOf(0D);
        if (product.getStockCount() != null) {
            prodCount = product.getStockCount();
        }

        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - stockCount.doubleValue());
        //四舍五入到2位小数
        prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        productService.updateStockCount(product, prodStockCount, cuser);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/deleteWarehouseProductBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/equipment/warehouseInitialBySpare/exportExcelTemplateWarehouseInitialBySpare")
    public ResultModel exportExcelTemplateWarehouseInitialBySpare() throws Exception {
        logger.info("################/equipment/warehouseInitialBySpare/exportExcelTemplateWarehouseInitialBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Column> columnList = columnService.findColumnList("warehouseToWarehouseProduct");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        pd.put("companyId", companyId.trim());

        Warehouse warehouse = null;
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            //warehouseSpareName:备件库名称定义:备件库
            findMap.put("name", Common.DICTIONARY_MAP.get("warehouseSpareName"));
            //是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouse =  warehouseService.findWarehouse(findMap );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("您所在的企业不存在备件库，请与管理员联系！");
            return model;
        }

        List<Map> dataList = new ArrayList<Map>();
        try {
            pd.put("isNeedSpare", "true");
            dataList = warehouseToWarehouseProductService.findMapListWarehouseToWarehouseProduct(pd);
            if (dataList != null && dataList.size() > 0) {
                for (Map<String, Object> mapObject : dataList) {
                    mapObject.put("productCode", "");
                    mapObject.put("productName", "");
                    mapObject.put("productSpec", "");
                    mapObject.put("productGenreName", "");
                    mapObject.put("productUnitName", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/exportExcelTemplateWarehouseInitialBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
