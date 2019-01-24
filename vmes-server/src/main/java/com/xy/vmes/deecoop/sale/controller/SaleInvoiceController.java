package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;


/**
* 说明：vmes_sale_invoice:发票Controller
* @author 陈刚 自动生成
* @date 2019-01-08
*/
@RestController
@Slf4j
public class SaleInvoiceController {
    private Logger logger = LoggerFactory.getLogger(SaleInvoiceController.class);

    @Autowired
    private SaleInvoiceService saleInvoiceService;
    @Autowired
    private SaleInvoiceDetailService saleInvoiceDetailService;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/listPageSaleInvoice")
    public ResultModel listPageSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/listPageSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("saleInvoice");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String firstFieldCode = pd.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }

        Map<String, Object> firstTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        result.put("hideTitles",firstTitleMap.get("hideTitles"));
        result.put("titles",firstTitleMap.get("titles"));

        //B. 第二级: 获取订单明细汇总查询
        columnList = columnService.findColumnList("saleInvoiceDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String secondFieldCode = pd.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }
        Map<String, Object> secondTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //C. 查询第一层数据
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleInvoiceService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)firstTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("hideTitles", secondTitleMap.get("hideTitles"));
                varMap.put("titles", secondTitleMap.get("titles"));
                varMap.put("pid", null);
                //查询第二层数据
                varMap.put("children", this.findSecondList(map, secondTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/listPageSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/addSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/addSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());
        String companyId = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("明细Json字符串-转换成List错误！");
            return model;
        }

        //获取订单明细
        List<SaleOrderDetail> orderDtlList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);
        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(orderDtlList);

        //1. 创建开票单
        SaleInvoice invoice = new SaleInvoice();

        //开票单编号
        //String code = coderuleService.createCoder(companyId, "vmes_sale_invoice", "FP");
        //invoice.setSysCode(code);
        invoice.setReceiptType(order.getReceiptType());
        invoice.setCompanyId(companyId);
        invoice.setCustomerId(order.getCustomerId());
        invoice.setOrderId(order.getId());
        invoice.setTotalSum(totalSum);
        //state:状态(0:待开票 1:已开票 -1:已取消)
        invoice.setState("0");
        invoice.setCuser(cuser);
        saleInvoiceService.save(invoice);

        //2. 创建开票单明细
        List<SaleInvoiceDetail> invoiceDtlList = saleOrderDetailService.orderDtlList2InvoiceDtlList(orderDtlList, null);
        saleInvoiceDetailService.addInvoiceDetail(invoice, invoiceDtlList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/addSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/updateSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/updateSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleInvoice invoiceByPage = (SaleInvoice)HttpUtils.pageData2Entity(pageData, new SaleInvoice());
        //state:状态(0:待开票 1:已开票 -1:已取消)
        if ("1".equals(invoiceByPage.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("该开票单状态(已开票)，不可修改！");
            return model;
        }

        //total_sum:合计金额
        BigDecimal totalSum = BigDecimal.valueOf(0D);
        List<SaleInvoiceDetail> invoiceDtlList = new ArrayList<SaleInvoiceDetail>();

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr != null && dtlJsonStr.trim().length() > 0) {
            List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
            if (mapList == null || mapList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("明细Json字符串-转换成List错误！");
                return model;
            }

            //获取订单明细
            List<SaleOrderDetail> orderDtlList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);
            //total_sum:合计金额
            totalSum = saleOrderDetailService.findTotalSumByDetailList(orderDtlList);
            invoiceDtlList = saleOrderDetailService.orderDtlList2InvoiceDtlList(orderDtlList, null);
        }

        //1. 修改开票单
        SaleInvoice invoiceDB = saleInvoiceService.findSaleInvoiceById(invoiceByPage.getId());
        invoiceDB.setReceiptType(invoiceByPage.getReceiptType());
        invoiceDB.setTotalSum(totalSum);
        saleInvoiceService.update(invoiceDB);

        //2. 删除开票单明细
        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("parent_id", invoiceDB.getId());
        saleInvoiceDetailService.deleteByColumnMap(columnMap);

        //3. 创建开票单明细
        if (invoiceDtlList.size() > 0) {
            saleInvoiceDetailService.addInvoiceDetail(invoiceDB, invoiceDtlList);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/updateSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 完成开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/updateStateBySaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateStateBySaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/updateStateBySaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        ids = StringUtil.stringTrimSpace(ids);
        //ids = "'" + ids.replace(",", "','") + "'";

        //修改开票明细状态(0:待开票 1:已开票 -1:已取消)
        saleInvoiceDetailService.updateStateByDetail("1", ids);

        //修改开票单状态(0:待开票 1:已开票 -1:已取消)
        saleInvoiceService.updateStateByInvoice("1", ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/updateStateBySaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/deleteSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/deleteSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("开票单id为空或空字符串！");
            return model;
        }

        SaleInvoice invoiceDB = saleInvoiceService.findSaleInvoiceById(parentId);
        //state:状态(0:待开票 1:已开票 -1:已取消)
        if ("1".equals(invoiceDB.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("该开票单状态(已开票)，不可删除！");
            return model;
        }

        //2. 删除开票单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        saleInvoiceDetailService.deleteByColumnMap(columnMap);

        //3. 删除订单
        saleInvoiceService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/deleteSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消开票单
     * @author 陈刚
     * @date 2019-01-08
     * @throws Exception
     */
    @PostMapping("/sale/saleInvoice/cancelSaleInvoice")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleInvoice() throws Exception {
        logger.info("################/sale/saleInvoice/cancelSaleInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String invoiceId = pageData.getString("id");
        if (invoiceId == null || invoiceId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("开票单id为空或空字符串！");
            return model;
        }

        //状态(0:待开票 1:已开票 -1:已取消)
        SaleInvoice invoice = saleInvoiceService.findSaleInvoiceById(invoiceId);
        if ("1".equals(invoice.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前开票单状态(已开票)，不可取消开票单！");
            return model;
        }

        //取消开票单
        //状态(0:待开票 1:已开票 -1:已取消)
        invoice.setState("-1");
        saleInvoiceService.update(invoice);

        //开票明细状态(0:待开票 1:已开票 -1:已取消)
        saleInvoiceDetailService.updateStateByDetail("-1", invoiceId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/cancelSaleInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/exportExcelSaleInvoices")
    public void exportExcelSaleInvoices() throws Exception {
        logger.info("################/sale/saleInvoice/exportExcelSaleInvoices 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("saleInvoice");
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
        List<Map> dataList = saleInvoiceService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleInvoice";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleInvoice/exportExcelSaleInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2019-01-08
    */
    @PostMapping("/sale/saleInvoice/importExcelSaleInvoices")
    public ResultModel importExcelSaleInvoices(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleInvoice/importExcelSaleInvoices 执行开始 ################# ");
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
        logger.info("################/sale/saleInvoice/importExcelSaleInvoices 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap) throws Exception {
        String parentId = (String)firstRowMap.get("parentId");

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = saleInvoiceDetailService.getDataListPage(findMap);
        if(varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)secondTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("pid",firstRowMap.get("id").toString());
                secondMapList.add(varMap);

            }
        }

        return secondMapList;
    }

}



