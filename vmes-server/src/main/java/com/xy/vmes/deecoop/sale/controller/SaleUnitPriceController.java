package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleUnitPriceService;
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
* 说明：设置锁库时间Controller
* @author 刘威 自动生成
* @date 2018-12-14
*/
@RestController
@Slf4j
public class SaleUnitPriceController {

    private Logger logger = LoggerFactory.getLogger(SaleUnitPriceController.class);

    @Autowired
    private SaleUnitPriceService saleUnitPriceService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @GetMapping("/sale/saleUnitPrice/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleUnitPrice/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleUnitPrice saleUnitPrice = saleUnitPriceService.selectById(id);
        model.putResult(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleUnitPrice/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice)HttpUtils.pageData2Entity(pd, new SaleUnitPrice());
        saleUnitPriceService.save(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleUnitPrice/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice)HttpUtils.pageData2Entity(pd, new SaleUnitPrice());
        saleUnitPriceService.update(saleUnitPrice);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @GetMapping("/sale/saleUnitPrice/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleUnitPrice/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleUnitPriceService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleUnitPrice/deleteByIds 执行开始 ################# ");
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
            saleUnitPriceService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleUnitPrice/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleUnitPrice> saleUnitPriceList = saleUnitPriceService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleUnitPriceList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleUnitPrice/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleUnitPrice> saleUnitPriceList = saleUnitPriceService.dataList(pd);
        model.putResult(saleUnitPriceList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-12-14
     */
    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPricesHis")
    public ResultModel listPageCustomerUnitPricesHis()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("CustomerUnitPriceHis");
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleUnitPriceService.getCustomerUnitPriceHisListPage(pd,pg);
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
        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPricesHis 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-12-14
     */
    @PostMapping("/sale/saleUnitPrice/listPageCustomerUnitPrices")
    public ResultModel listPageCustomerUnitPrices()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("CustomerUnitPrice");
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleUnitPriceService.getCustomerUnitPriceListPage(pd,pg);
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
        logger.info("################/sale/saleUnitPrice/listPageCustomerUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/listPageSaleUnitPrices")
    public ResultModel listPageSaleUnitPrices()  throws Exception {

        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("SaleUnitPrice");
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleUnitPriceService.getDataListPage(pd,pg);
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
        logger.info("################/sale/saleUnitPrice/listPageSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改客户价格
     * {productId:货品id unit:单位id customerId:客户id productPrice: 货品单价}
     *
     * @author 陈刚
     * @date 2018-12-18
     * @throws Exception
     */
    @PostMapping("/sale/saleUnitPrice/updateSaleUnitPriceByPrice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleUnitPriceByPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice)HttpUtils.pageData2Entity(pageData, new SaleUnitPrice());
        String msgStr = saleUnitPriceService.checkColumn(saleUnitPrice);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode("1");
            model.putMsg(msgStr);
            return model;
        }

        PageData findMap = new PageData();
        findMap.put("productId", saleUnitPrice.getProductId());
        findMap.put("unit", saleUnitPrice.getUnit());
        findMap.put("customerId", saleUnitPrice.getCustomerId());

        SaleUnitPrice objectDB = saleUnitPriceService.findSaleUnitPrice(findMap);
        if (objectDB == null) {
            saleUnitPriceService.save(saleUnitPrice);
        } else {
            saleUnitPriceService.update(saleUnitPrice);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/updateSaleUnitPriceByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取客户货品价格
     * {productId:货品id unit:单位id customerId:客户id }
     *
     * @date 2018-12-18
     */
    @PostMapping("/sale/saleUnitPrice/findSaleUnitPrice")
    public ResultModel findSaleUnitPrice() throws Exception {
        logger.info("################/sale/saleUnitPrice/findSaleUnitPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String productId = pageData.getString("productId");
        String unit = pageData.getString("unit");
        String customerId = pageData.getString("customerId");

        if (productId == null || productId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品id为空或空字符串！");
            return model;
        }
        if (unit == null || unit.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("单位id为空或空字符串！");
            return model;
        }
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        //isdisable:是否启用(0:已禁用 1:启用)
        pageData.put("isdisable", "1");
        if (pageData.getString("isdisable") != null && pageData.getString("isdisable").trim().length() > 0) {
            pageData.put("isdisable", pageData.getString("isdisable").trim());
        }

        pageData.put("orderStr", "cdate desc");
        if (pageData.getString("orderStr") != null && pageData.getString("orderStr").trim().length() > 0) {
            pageData.put("orderStr", pageData.getString("orderStr").trim());
        }

        List<SaleUnitPrice> objectList = saleUnitPriceService.findSaleUnitPriceList(pageData);
        if (objectList != null && objectList.size() > 0 && objectList.get(0).getProductPrice() != null) {
            BigDecimal productPrice = objectList.get(0).getProductPrice();
            //四舍五入到2位小数
            productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            model.set("productPrice", productPrice.toString());
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/findSaleUnitPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/exportExcelSaleUnitPrices")
    public void exportExcelSaleUnitPrices() throws Exception {
        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("SaleUnitPrice");
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
        List<Map> dataList = saleUnitPriceService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleUnitPrice";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleUnitPrice/exportExcelSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-14
    */
    @PostMapping("/sale/saleUnitPrice/importExcelSaleUnitPrices")
    public ResultModel importExcelSaleUnitPrices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrices 执行开始 ################# ");
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
        logger.info("################/sale/saleUnitPrice/importExcelSaleUnitPrices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



