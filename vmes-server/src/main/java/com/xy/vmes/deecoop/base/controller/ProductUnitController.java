package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.entity.ProductUnitPrice;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.ProductUnitPriceService;
import com.xy.vmes.service.ProductUnitService;
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
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;



/**
* 说明：产品计价单位Controller
* @author 刘威 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class ProductUnitController {
    private Logger logger = LoggerFactory.getLogger(ProductUnitController.class);

    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private ProductUnitPriceService productUnitPriceService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @GetMapping("/productUnit/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################productUnit/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        ProductUnit productUnit = productUnitService.selectById(id);
        model.putResult(productUnit);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################productUnit/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ProductUnit productUnit = (ProductUnit)HttpUtils.pageData2Entity(pd, new ProductUnit());
        productUnitService.save(productUnit);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################productUnit/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ProductUnit productUnit = (ProductUnit)HttpUtils.pageData2Entity(pd, new ProductUnit());
        productUnitService.update(productUnit);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @GetMapping("/productUnit/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################productUnit/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        productUnitService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################productUnit/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            productUnitService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################productUnit/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<ProductUnit> productUnitList = productUnitService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",productUnitList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################productUnit/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<ProductUnit> productUnitList = productUnitService.dataList(pd);
        model.putResult(productUnitList);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/listPageProductUnits")
    public ResultModel listPageProductUnits()  throws Exception {
        logger.info("################productUnit/listPageProductUnits 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("ProductUnit");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = productUnitService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/listPageProductUnits 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-15
     */
    @PostMapping("/productUnit/updateProductUnitPrice")
    @Transactional
    public ResultModel updateProductUnitPrice()  throws Exception {
        logger.info("################productUnit/updateProductUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        String id = pd.getString("id");
        String productId = pd.getString("productId");

        //punit 计价单位Id
        String punit = pd.getString("punit");
        if (punit == null || punit.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("计价单位为空或空字符串，请在(单位换算)中设定(计价单位)！");
            return model;
        }

        //货品单价 productPrice
        String productPrice = pd.getString("productPrice");
        if (productPrice == null || productPrice.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品单价为空，货品单价为必填项不可为空！");
            return model;
        }

        BigDecimal productPrice_big = BigDecimal.valueOf(0D);
        try {
            productPrice_big = new BigDecimal(productPrice);
            //四舍五入到2位小数
            productPrice_big = productPrice_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        PageData findMap = new PageData();
        findMap.put("productId", productId);
        findMap.put("unit", punit);
        findMap.put("productPrice", productPrice_big.toString());
        //isdisable:是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");

        ProductUnit productUnit = productUnitService.findProductUnit(findMap);
        if (productUnit == null) {
            //添加 vmes_product_unit_price:货品价格
            ProductUnitPrice productUnitPrice = new ProductUnitPrice();
            productUnitPrice.setProductId(productId);
            productUnitPrice.setPriceUnit(punit);
            productUnitPrice.setProductPrice(productPrice_big);
            productUnitPriceService.save(productUnitPrice);

            //修改 vmes_product_unit
            ProductUnit productUnit_update = new ProductUnit();
            productUnit_update.setId(id);
            productUnit_update.setProductPrice(productPrice_big);
            productUnitService.update(productUnit_update);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/updateProductUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/exportExcelProductUnits")
    public void exportExcelProductUnits() throws Exception {
        logger.info("################productUnit/exportExcelProductUnits 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("ProductUnit");
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
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = productUnitService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelProductUnit";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/exportExcelProductUnits 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-15
    */
    @PostMapping("/productUnit/importExcelProductUnits")
    public ResultModel importExcelProductUnits(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################productUnit/importExcelProductUnits 执行开始 ################# ");
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

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################productUnit/importExcelProductUnits 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



