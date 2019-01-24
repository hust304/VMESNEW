package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseProduct;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;



/**
* 说明：vmes_warehouse_initial:仓库初始化设定Controller
* @author 陈刚 自动生成
* @date 2018-11-20
*/
@RestController
@Slf4j
public class WarehouseInitialController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInitialController.class);

    @Autowired
    private WarehouseInitialService warehouseInitialService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductExcelService warehouseProductExcelService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/listPageWarehouseInitial")
    public ResultModel listPageWarehouseInitial()  throws Exception {
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInitial");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
            for (Column column : columnList) {
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(), column.getTitleName());
                    varModelMap.put(column.getTitleKey(), "");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInitialService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),
                            map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 初始化仓库
     *
     * @author 陈刚
     * @date 2018-11-20
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/initialWarehouse")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel initialWarehouse() throws Exception {
        logger.info("################/warehouseInitial/initialWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        //初始化仓库业务表
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        warehouseInitialService.initialByWarehouse(cuser, companyId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/initialWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库货品(库存数量)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/updateWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行开始 ################# ");
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

        //库存数量(修改后)
        String afterCountStr = pageData.getString("stockCount");
        BigDecimal afterCountBig = BigDecimal.valueOf(0D);

        if (afterCountStr == null || afterCountStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("库存数量为空或空字符串，库存数量为必填项不可为空！");
            return model;
        } else {
            afterCountStr = afterCountStr.trim();
            try {
                //全数字
                BigDecimal bigDecimal = new BigDecimal(afterCountStr);
                //四舍五入到2位小数
                afterCountBig = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            } catch (NumberFormatException e) {
                String msg_column_error = "{0}:{1} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;
                //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                String str_error = MessageFormat.format(msg_column_error, "库存数量", afterCountStr);
                model.putCode(Integer.valueOf(1));
                model.putMsg(str_error);
                return model;
            }
        }

        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            beforeCountBig = warehouseProduct.getStockCount();
        }

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
        productService.updateStockCount(product, prodStockCount, cuser);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除仓库货品(删除库存记录)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/deleteWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行开始 ################# ");
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

        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        String productId = warehouseProduct.getProductId();
        BigDecimal stockCount = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            stockCount = warehouseProduct.getStockCount();
        }

        //删除库存表(vmes_warehouse_product:仓库货位产品库存表)
        warehouseProductService.deleteById(id);

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
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/exportExcelWarehouseInitial")
    public void exportExcelWarehouseInitial() throws Exception {
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("warehouseInitial");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "wp.id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = warehouseInitialService.getDataListPage(pd, pg);

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
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/importExcelWarehouseInitial")
    public ResultModel importExcelWarehouseInitial(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

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

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        dataMapLst.remove(0);

        StringBuffer checkColumnMsgStr = new StringBuffer();
        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = warehouseProductExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            checkColumnMsgStr.append(msgStr);
        }

        //2. (货位编码,货位名称) (货品编码,货品名称,规格型号,货品属性,计量单位) 名称匹配
        Map<String, String> warehouseMap = new HashMap<String, String>();
        Map<String, String> productMap = new HashMap<String, String>();
        msgStr = warehouseProductExcelService.checkColumnImportExcelByDataBase(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW,
                warehouseMap,
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
        Map<String, WarehouseProduct> warehouseProductMap = new HashMap<String, WarehouseProduct>();
        warehouseProductExcelService.findWarehouseProductMapByExcelDataList(dataMapLst,
                warehouseProductMap,
                warehouseMap,
                productMap);

        //4. 遍历Map<String, WarehouseProduct> 对业务表添加
        warehouseProductExcelService.addWarehouseProduct(warehouseProductMap, companyId, userId);

        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



