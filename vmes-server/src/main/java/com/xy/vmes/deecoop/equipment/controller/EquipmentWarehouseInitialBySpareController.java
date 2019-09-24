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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
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
    private WarehouseProductToolService warehouseProductToolService;
    @Autowired
    private WarehouseProductExcelService warehouseProductExcelService;

    @Autowired
    private WarehouseInitialService warehouseInitialService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseInitialBySimpleService warehouseInitialBySimpleService;

    @Autowired
    private ColumnService columnService;


    //仓库初始化(备件库)
    @PostMapping("/equipment/warehouseInitialBySpare/findWarehouseInitialBySpare")
    public ResultModel findWarehouseInitialBySpare() throws Exception {
        logger.info("################/equipment/warehouseInitialBySpare/findWarehouseInitialBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.findWarehouseInitialBySimple(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/findWarehouseInitialBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

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

        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串！");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        //原(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
        BigDecimal oldStockCount = BigDecimal.valueOf(0D);
        String oldStockCountStr = pageData.getString("oldStockCount");
        if (oldStockCountStr != null) {
            try {
                oldStockCount = new BigDecimal(oldStockCountStr);
                //四舍五入到2位小数
                oldStockCount = oldStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //新(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
        BigDecimal newStockCount = BigDecimal.valueOf(0D);
        String newStockCountStr = pageData.getString("newStockCount");
        if (newStockCountStr != null) {
            try {
                newStockCount = new BigDecimal(newStockCountStr);
                //四舍五入到2位小数
                newStockCount = newStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //(货位id,货品id)查询 vmes_warehouse_product
        PageData findMap = new PageData();
        findMap.put("warehouseId", warehouseId);
        findMap.put("productId", productId);
        findMap.put("queryStr", "stock_count > 0 ");
        findMap.put("orderStr", "cdate asc");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<WarehouseProduct> objectList = warehouseProductService.findWarehouseProductList(findMap);
        if (objectList == null || objectList.size() == 0) {return model;}

        //变更库存数量 := 变更后库存数量 - 变更前库存数量
        BigDecimal changeStockCount = BigDecimal.valueOf(newStockCount.doubleValue() - oldStockCount.doubleValue());
        if (changeStockCount.doubleValue() < 0D) {
            //out 库存减数量
            BigDecimal changeCount = BigDecimal.valueOf(changeStockCount.doubleValue() * -1);
            //四舍五入到2位小数
            changeCount = changeCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, WarehouseProduct> WarehouseProductMap = warehouseProductToolService.warehouseProductList2Map(objectList);

            //List<Map<String, Object>>
            //Map<String, Object>
            //warehouseProductId
            //outCount
            List<Map<String, Object>> changeOutMap = warehouseProductToolService.findWarehouseProductReduceMapListBySimple(objectList, changeCount);
            for (Map<String, Object> outMap : changeOutMap) {
                String warehouseProductId = (String)outMap.get("warehouseProductId");
                BigDecimal outCount = (BigDecimal)outMap.get("outCount");
                if (outCount == null) {continue;}

                //修改库存数量
                WarehouseProduct warehouseProduct = WarehouseProductMap.get(warehouseProductId);
                BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
                if (warehouseProduct.getStockCount() != null) {
                    beforeCountBig = warehouseProduct.getStockCount();
                }

                //变更后库存数量 := 变更前库存数量 - outCount
                BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() - outCount.doubleValue());
                //四舍五入到2位小数
                afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                warehouseProduct.setUuser(cuser);
                warehouseProduct.setStockCount(afterCountBig);
                warehouseProductService.update(warehouseProduct);

                Product product = productService.findProductById(warehouseProduct.getProductId());
                BigDecimal prodCount = BigDecimal.valueOf(0D);
                if (product.getStockCount() != null) {
                    prodCount = product.getStockCount();
                }

                BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
                //四舍五入到2位小数
                prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                productService.updateStockCount(product, prodStockCount, cuser, "out");
            }

        } else if (changeStockCount.doubleValue() > 0D) {
            //in 库存加数量
            //List<WarehouseProduct> objectList，按(cdate)降序排列
            warehouseProductService.orderDescByCdate(objectList);

            WarehouseProduct warehouseProduct = objectList.get(0);
            BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
            if (warehouseProduct.getStockCount() != null) {
                beforeCountBig = warehouseProduct.getStockCount();
            }

            //变更后库存数量 := 变更前库存数量 + changeStockCount
            BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() + changeStockCount.doubleValue());
            //四舍五入到2位小数
            afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            warehouseProduct.setUuser(cuser);
            warehouseProduct.setStockCount(afterCountBig);
            warehouseProductService.update(warehouseProduct);

            Product product = productService.findProductById(warehouseProduct.getProductId());
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
            //四舍五入到2位小数
            prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            productService.updateStockCount(product, prodStockCount, cuser, "in");
        }

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
        productService.updateStockCount(product, prodStockCount, cuser, "out");

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

    /**
     * (备件库)Excel导入
     *
     * @author 陈刚
     * @date 2019-06-25
     */
    @PostMapping("/equipment/warehouseInitialBySpare/importExcelInitialWarehouseBySpare")
    public ResultModel importExcelInitialWarehouseBySpare(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/equipment/warehouseInitialBySpare/importExcelInitialWarehouseBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
                || fileName.matches("^.+\\.(?i)(xls)$"))
                ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        //获取备件库
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("name", "备件库");
        findMap.put("layer", Integer.valueOf(2));
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        Warehouse warehouseSpare = warehouseService.findWarehouse(findMap);
        if (warehouseSpare == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("您所在的企业不存在(备件库)，请与管理员联系！");
            return model;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        dataMapLst.remove(0);

        StringBuffer checkColumnMsgStr = new StringBuffer();
        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = warehouseProductExcelService.checkColumnImportExcelBySpare(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            checkColumnMsgStr.append(msgStr);
        }

        //2. (货品编码,货品名称,规格型号,货品属性,计量单位) 名称匹配
        Map<String, String> productMap = new HashMap<String, String>();
        msgStr = warehouseProductExcelService.checkColumnImportExcelByDataBaseBySpare(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW,
                productMap);
        if (msgStr != null && msgStr.trim().length() > 0) {
            checkColumnMsgStr.append(msgStr);
        }

        if (checkColumnMsgStr.toString().trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(checkColumnMsgStr.toString().trim());
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //3. 遍历Excel导入List-Map<String, WarehouseProduct>
        Map<String, String> warehouseMap = new HashMap<String, String>();
        Map<String, WarehouseProduct> warehouseProductMap = new HashMap<String, WarehouseProduct>();
        warehouseProductExcelService.findWarehouseProductMapByExcelDataList(dataMapLst,
                warehouseProductMap,
                warehouseMap,
                productMap);

        //4. 遍历Map<String, WarehouseProduct> 对业务表添加
        warehouseProductExcelService.addWarehouseProductBySpare(warehouseProductMap, companyId, userId);

        //(企业id)查询 vmes_warehouse_initial
        WarehouseInitial warehouseInitial = null;
        try {
            findMap = new PageData();
            findMap.put("companyId", companyId);
            //初始化仓库属性
            //warehouse:(简版,复杂版)仓库 spare:备件库
            findMap.put("warehouseAttribute", "spare");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouseInitial = warehouseInitialService.findWarehouseInitial(findMap);

            //是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
            //0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
            String isDisableButton = "101";

            if (warehouseInitial == null) {
                WarehouseInitial addObject = new WarehouseInitial();
                addObject.setCuser(userId);
                addObject.setCompanyId(companyId);
                addObject.setIsDisableButton(isDisableButton);
                //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
                addObject.setWarehouseAttribute("spare");
                warehouseInitialService.save(addObject);
            } else if (warehouseInitial != null) {
                warehouseInitial.setIsDisableButton(isDisableButton);
                warehouseInitialService.update(warehouseInitial);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/importExcelInitialWarehouseBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
