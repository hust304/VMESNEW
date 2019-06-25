package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseInitial;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_initial: 仓库初始化设定Controller
 * @author 陈刚
 * @date 2019-06-25
 */
@RestController
@Slf4j
public class EquipmentWarehouseInitialBySpareController {
    private Logger logger = LoggerFactory.getLogger(EquipmentWarehouseInitialBySpareController.class);

    //@Autowired
    //private WarehouseInitialService warehouseInitialService;
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseOutService warehouseOutService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductExcelService warehouseProductExcelService;
    @Autowired
    private ProductService productService;

    /**
     * 初始化仓库(备件库)
     *
     * @author 陈刚
     * @date 2019-06-25
     * @throws Exception
     */
    @PostMapping("/equipment/warehouseInitialBySpare/initialWarehouseBySpare")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel initialWarehouseBySpare() throws Exception {
        logger.info("################/equipment/warehouseInitialBySpare/initialWarehouseBySpare 执行开始 ################# ");
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

        //是否删除备件库(true: 删除的是备件库 false: 删除的是非备件库)
        String isDelSpare = "true";

        //删除入库业务表:删除(备件库)的入库单
        warehouseInService.deleteTableByWarehouseIn(companyId, isDelSpare);
        //删除出库业务表:删除(备件库)的出库单
        warehouseOutService.deleteTableByWarehouseOut(companyId, isDelSpare);

        //删除仓库货品表(库存表)
        warehouseProductService.deleteTable(companyId, isDelSpare);

        //货品表(库存数量,锁定库存数量)初始化为零-货品属性是(备件)
        String isSpare = "true";
        productService.initialProductByStockCount(companyId, isSpare);

//        WarehouseInitial addObject = new WarehouseInitial();
//        addObject.setCuser(cuser);
//        addObject.setCompanyId(companyId);
//        warehouseInitialService.save(addObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/initialWarehouseBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导入
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-20
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

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/importExcelInitialWarehouseBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库货品(库存数量)
     * @author 陈刚
     * @date 2018-10-16
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

        WarehouseProduct warehouseProductEdit = new WarehouseProduct();
        warehouseProductEdit.setId(id);
        warehouseProductEdit.setUuser(cuser);
        warehouseProductEdit.setStockCount(afterCountBig);
        warehouseProductService.update(warehouseProductEdit);

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

        //货品变更数量:= 变更后数量 - 变更前数量
        BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
        //四舍五入到2位小数
        prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        productService.updateStockCount(product, prodStockCount, cuser);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseInitialBySpare/updateWarehouseProductBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
