package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleInvoiceMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_invoice:发票 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-01-08
*/
@Service
@Transactional(readOnly = false)
public class SaleInvoiceServiceImp implements SaleInvoiceService {


    @Autowired
    private SaleInvoiceMapper saleInvoiceMapper;
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
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    @Override
    public void save(SaleInvoice saleInvoice) throws Exception{
        saleInvoice.setId(Conv.createUuid());
        saleInvoice.setCdate(new Date());
        saleInvoice.setUdate(new Date());
        saleInvoiceMapper.insert(saleInvoice);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public SaleInvoice selectById(String id) throws Exception{
        return saleInvoiceMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoice> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleInvoice> warehouseCheckDetailList =  saleInvoiceMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void update(SaleInvoice object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateAll(SaleInvoice object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleInvoiceMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleInvoiceMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleInvoiceMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleInvoiceMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<SaleInvoice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleInvoice>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoice> dataList(PageData pd) throws Exception{
        return saleInvoiceMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleInvoiceMapper.getDataListPage(pd,pg);
    }

    public void updateStateByInvoice(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", ids);

        saleInvoiceMapper.updateStateByInvoice(pageData);
    }

    public SaleInvoice findSaleInvoice(PageData object) throws Exception{
        List<SaleInvoice> objectList = this.findSaleInvoiceList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleInvoice findSaleInvoiceById(String id) throws Exception{
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleInvoice(findMap);
    }

    public List<SaleInvoice> findSaleInvoiceList(PageData object) throws Exception{
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////
    public ResultModel listPageSaleInvoice(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
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

        return model;
    }

    public ResultModel addSaleInvoice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

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

        return model;
    }

    public ResultModel updateSaleInvoice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

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

        return model;
    }

    public ResultModel updateStateBySaleInvoice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

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

        return model;
    }

    public ResultModel deleteSaleInvoice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

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

        return model;
    }

    public ResultModel cancelSaleInvoice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

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

        return model;
    }

    public void exportExcelSaleInvoices(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("saleInvoice");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

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

    }
    public ResultModel importExcelSaleInvoices(MultipartFile file) throws Exception {
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

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改

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



