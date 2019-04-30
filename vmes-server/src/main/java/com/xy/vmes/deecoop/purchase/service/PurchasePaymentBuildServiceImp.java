package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.purchase.dao.PurchasePaymentBuildMapper;
import com.xy.vmes.entity.PurchasePaymentBuild;
import com.xy.vmes.service.PurchasePaymentBuildService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_purchase_payment_build:供应商付款初期设定 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-03-11
*/
@Service
@Transactional(readOnly = false)
public class PurchasePaymentBuildServiceImp implements PurchasePaymentBuildService {

    @Autowired
    private PurchasePaymentBuildMapper purchasePaymentBuildMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void save(PurchasePaymentBuild object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        purchasePaymentBuildMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public PurchasePaymentBuild selectById(String id) throws Exception{
        return purchasePaymentBuildMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentBuild> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchasePaymentBuild> warehouseCheckDetailList =  purchasePaymentBuildMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void update(PurchasePaymentBuild object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentBuildMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateAll(PurchasePaymentBuild object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentBuildMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePaymentBuildMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePaymentBuildMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePaymentBuildMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePaymentBuildMapper.updateToDisableByIds(ids);
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
    public List<PurchasePaymentBuild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePaymentBuild>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentBuild> dataList(PageData pd) throws Exception{
        return purchasePaymentBuildMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePaymentBuildMapper.getDataListPage(pd, pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception{
        return purchasePaymentBuildMapper.getDataListPage(pd);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchasePaymentBuild(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("purchasePaymentBuild");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public ResultModel editPaymentBuild(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        //付款期间 paymentPeriodDate
        String paymentPeriodDate_str = pageData.getString("paymentPeriodDate");
        if (paymentPeriodDate_str == null || paymentPeriodDate_str.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("付款期间为必填项不可为空！");
            return model;
        }

        //付款类型 paymentType
        String paymentType = pageData.getString("paymentType");
        if (paymentType == null || paymentType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("付款类型为必填项不可为空！");
            return model;
        }

        //金额 paymentSum
        String paymentSum_str = pageData.getString("paymentSum");
        if (paymentSum_str == null || paymentSum_str.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("金额为必填项不可为空！");
            return model;
        }

        PurchasePaymentBuild paymentBuild = new PurchasePaymentBuild();
        //供应商ID supplierId
        paymentBuild.setSupplierId(supplierId);

        //付款期间 paymentPeriodDate(yyyy-MM-dd)
        Date paymentPeriodDate = DateFormat.dateString2Date(paymentPeriodDate_str, DateFormat.DEFAULT_DATE_FORMAT);
        paymentPeriodDate_str = DateFormat.date2String(paymentPeriodDate, "yyyy-MM");
        paymentPeriodDate_str = paymentPeriodDate_str + "-" + "01";
        paymentPeriodDate = DateFormat.dateString2Date(paymentPeriodDate_str, DateFormat.DEFAULT_DATE_FORMAT);
        paymentBuild.setPaymentPeriodDate(paymentPeriodDate);

        //付款期间(yyyymm)
        String paymentPeriod = DateFormat.date2String(paymentBuild.getPaymentPeriodDate(), "yyyyMM");
        paymentBuild.setPaymentPeriod(paymentPeriod);

        BigDecimal paymentSum = BigDecimal.valueOf(0D);
        try {
            paymentSum = new BigDecimal(paymentSum_str);
            //四舍五入到2位小数
            paymentSum = paymentSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            paymentBuild.setBeginValue(paymentSum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //付款类型 paymentType(应付款: plus 预付款:minus)
        paymentBuild.setBeginPlus(BigDecimal.valueOf(0D));
        paymentBuild.setBeginMinus(BigDecimal.valueOf(0D));
        if ("plus".equals(paymentType)) {
            paymentBuild.setBeginPlus(paymentSum);
        } else if ("minus".equals(paymentType)) {
            paymentBuild.setBeginMinus(paymentSum);
            paymentBuild.setBeginValue(BigDecimal.valueOf(paymentSum.doubleValue() * -1));
        }

        paymentBuild.setRemark("");
        String remark = pageData.getString("remark");
        if (remark != null && remark.trim().length() > 0) {
            paymentBuild.setRemark(remark.trim());
        }

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            String cuser = pageData.getString("cuser");
            paymentBuild.setCuser(cuser);
            this.save(paymentBuild);
        } else if (id != null && id.trim().length() > 0) {
            paymentBuild.setId(id);
            this.update(paymentBuild);
        }

        return model;
    }

    public ResultModel checkIsAllBuildSupplierPayment(String companyId) throws Exception {
        ResultModel model = new ResultModel();

        PageData pageData = new PageData();
        pageData.put("currentCompanyId", companyId);

        List<Map> mapList = this.getDataListPage(pageData);
        Boolean isBuild = this.isAllBuildByMapList(mapList);
        if (isBuild == null || !isBuild.booleanValue()) {
            model.set("isAllBuild", "false");
        } else if (isBuild.booleanValue()) {
            model.set("isAllBuild", "true");
        }

        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelPurchasePaymentBuilds(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("purchasePaymentBuild");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);
        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelPurchasePaymentBuild";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }


    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel importExcelPurchasePaymentBuilds(MultipartFile file) throws Exception{
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

    private Boolean isAllBuildByMapList(List<Map> mapList) {
        if (mapList == null || mapList.size() == 0) {return Boolean.FALSE;}

        for (Map<String, Object> mapObject : mapList) {
            //isBuild Y:已设定 N:未设定
            String isBuild_str = (String)mapObject.get("isBuild");
            if ("N".equals(isBuild_str)) {
                return Boolean.FALSE;
            }

        }

        return Boolean.TRUE;
    }


}



