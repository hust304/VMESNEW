package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.ProductProperty;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：vmes_product:产品表Controller
* @author 陈刚 自动生成
* @date 2018-09-21
*/
@RestController
@Slf4j
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductPropertyService productPropertyService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @GetMapping("/product/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################product/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Product product = productService.selectById(id);
        model.putResult(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/product/save")
    public ResultModel save()  throws Exception {

        logger.info("################product/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Product product = (Product)HttpUtils.pageData2Entity(pd, new Product());
        productService.save(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/product/update")
    public ResultModel update()  throws Exception {

        logger.info("################product/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Product product = (Product)HttpUtils.pageData2Entity(pd, new Product());
        productService.update(product);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @GetMapping("/product/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################product/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        productService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/product/deleteByIds")
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################product/deleteByIds 执行开始 ################# ");
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
            productService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/product/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################product/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Product> productList = productService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",productList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-21
    */
    @PostMapping("/product/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################product/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Product> productList = productService.dataList(pd);
        model.putResult(productList);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/product/listPageProducts")
    public ResultModel listPageProducts()  throws Exception {
        logger.info("################product/listPageProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("product");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
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

        PageData pd = HttpUtils.parsePageData();
        pd.put("orderStr", "prod.cdate desc");
        String genreId = pd.getString("genreId");
        if (genreId != null && genreId.trim().length() > 0
            && !Common.DICTIONARY_MAP.get("productGenre").equals(genreId)
        ) {
            pd.put("genre", genreId);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = productService.getDataListPage(pd, pg);
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
        logger.info("################product/listPageProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/product/listPageProductPropertys")
    public ResultModel listPageProductPropertys() throws Exception {
        logger.info("################product/listPageProductPropertys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("productProperty");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
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

        //无需分页
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = productService.getDataListPage(pd, pg);
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
        logger.info("################product/listPageProductPropertys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增产品物料
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/product/addProduct")
    public ResultModel addProduct() throws Exception {
        logger.info("################/product/addProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        //获取产品编码
        String companyId = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyId,"vmes_product","P");
        if(StringUtils.isEmpty(code)){
            model.putCode(1);
            model.putMsg("产品编码规则创建异常，请重新操作！");
            return model;
        }

        //2. 添加产品表(vmes_product)
        Product product = (Product)HttpUtils.pageData2Entity(pageData, new Product());
        product.setCuser(pageData.getString("cuser"));
        product.setCompanyId(companyId);
        product.setCode(code);

        //生成产品二维码
        String qrcode = fileService.createQRCode("product", YvanUtil.toJson(product));
        if (qrcode != null && qrcode.trim().length() > 0) {
            product.setQrcode(qrcode);
        }
        productService.save(product);

        //3. 添加产品属性表(vmes_product_property)
        String dataListJsonStr = pageData.getString("prodProperty");
        //测试代码-真实环境无此代码
        //dataListJsonStr = "[{\"name\":\"属性名称_1\",\"value\":\"属性值_1\",\"remark\":\"备注_1\"},{\"name\":\"属性名称_2\",\"value\":\"属性值_2\",\"remark\":\"备注_2\"}]";

        if (dataListJsonStr != null && dataListJsonStr.trim().length() > 0) {
            //JsonString 转换成List<Map<String, Object>>
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) YvanUtil.jsonToList(dataListJsonStr);
            if (dataList == null || dataList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("自定义产品属性Json字符串-转换成List错误！");
                return model;
            }

            List<ProductProperty> propertyList = productPropertyService.mapList2ProductPropertyList(dataList, null);
            productPropertyService.addProductProperty(pageData.getString("cuser"),
                    product.getId(),
                    propertyList);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################product/addProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改产品物料
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/product/updateProduct")
    public ResultModel updateProduct() throws Exception {
        logger.info("################/product/updateProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        Product productDB = (Product)HttpUtils.pageData2Entity(pageData, new Product());

        //2. 修改产品属性表(vmes_product_property)
        String dataListJsonStr = pageData.getString("prodProperty");
        if (dataListJsonStr != null && dataListJsonStr.trim().length() > 0) {
            //JsonString 转换成List<Map<String, Object>>
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) YvanUtil.jsonToList(dataListJsonStr);
            if (dataList == null || dataList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("自定义产品属性Json字符串-转换成List错误！");
                return model;
            }

            //按照产品id-删除产品属性表(vmes_product_property)
            productPropertyService.deleteProdPropertyByProdId(productDB.getId());

            //添加产品属性表(vmes_product_property)-按照json字符串数据(dataListJsonStr)
            List<ProductProperty> propertyList = productPropertyService.mapList2ProductPropertyList(dataList, null);
            productPropertyService.addProductProperty(pageData.getString("cuser"),
                    productDB.getId(),
                    propertyList);
        }

        //3.修改产品表(vmes_product)
        productDB.setUuser(pageData.getString("cuser"));
        productService.update(productDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################product/updateProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改产品物料(禁用)状态
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/product/updateDisableProduct")
    public ResultModel updateDisableProduct() throws Exception {
        logger.info("################/product/updateDisableProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        String isdisable = pageData.getString("isdisable");

        //1. 非空判断
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 修改产品物料(禁用)状态
        Product objectDB = (Product)HttpUtils.pageData2Entity(pageData, new Product());
        productService.update(objectDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################product/updateDisableProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除产品物料
     * 1. 支持批量删除
     * 2. 删除产品物料属性表(vmes_product_property)
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/product/deleteProduct")
    public ResultModel deleteProduct() throws Exception {
        logger.info("################/product/deleteProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        //2. 删除产品物料
        ids = StringUtil.stringTrimSpace(ids);
        productService.deleteByIds(ids.split(","));

        //3. 删除产品物料属性表(vmes_product_property)
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            productPropertyService.deleteProdPropertyByProdId(id);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################product/deleteProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/product/exportExcelProducts")
    public void exportExcelProducts() throws Exception {
        logger.info("################product/exportExcelProducts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("product");
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
        List<Map> dataList = productService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelProduct";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################product/exportExcelProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-21
    */
    @PostMapping("/product/importExcelProducts")
    public ResultModel importExcelProducts(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################product/importExcelProducts 执行开始 ################# ");
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
        logger.info("################product/importExcelProducts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



