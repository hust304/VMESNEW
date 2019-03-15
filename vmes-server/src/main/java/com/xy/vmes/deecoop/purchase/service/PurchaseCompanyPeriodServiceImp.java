package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.deecoop.purchase.dao.PurchaseCompanyPeriodMapper;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.xy.vmes.service.PurchaseCompanyPeriodService;

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
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_purchase_company_period:采购企业付款期设定 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-03-12
*/
@Service
@Transactional(readOnly = false)
public class PurchaseCompanyPeriodServiceImp implements PurchaseCompanyPeriodService {
    @Autowired
    private PurchaseCompanyPeriodMapper purchaseCompanyPeriodMapper;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void save(PurchaseCompanyPeriod object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        purchaseCompanyPeriodMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public PurchaseCompanyPeriod selectById(String id) throws Exception{
        return purchaseCompanyPeriodMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchaseCompanyPeriod> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchaseCompanyPeriod> warehouseCheckDetailList =  purchaseCompanyPeriodMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void update(PurchaseCompanyPeriod object) throws Exception{
        object.setUdate(new Date());
        purchaseCompanyPeriodMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateAll(PurchaseCompanyPeriod object) throws Exception{
        object.setUdate(new Date());
        purchaseCompanyPeriodMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchaseCompanyPeriodMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchaseCompanyPeriodMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchaseCompanyPeriodMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchaseCompanyPeriodMapper.updateToDisableByIds(ids);
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
    public List<PurchaseCompanyPeriod> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseCompanyPeriod>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchaseCompanyPeriod> dataList(PageData pd) throws Exception{
        return purchaseCompanyPeriodMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    public List<Map> getDataListPage(PageData pd) throws Exception{
        return purchaseCompanyPeriodMapper.getDataListPage(pd);
    }
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchaseCompanyPeriodMapper.getDataListPage(pd, pg);
    }

    public PurchaseCompanyPeriod findPurchaseCompanyPeriod(PageData object) throws Exception {
        List<PurchaseCompanyPeriod> objectList = this.findPurchaseCompanyPeriodList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public List<PurchaseCompanyPeriod> findPurchaseCompanyPeriodList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public PurchaseCompanyPeriod findPurchaseCompanyPeriodByCompanyId(String companyId) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);

        return this.findPurchaseCompanyPeriod(findMap);
    }

    public void updatePaymentPeriodByCompanyId(String companyId, String paymentPeriod) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return;}
        if (paymentPeriod == null || paymentPeriod.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("paymentPeriod", paymentPeriod);
        pageData.put("companyId", companyId);

        purchaseCompanyPeriodMapper.updatePaymentPeriod(pageData);

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchaseCompanyPeriod(PageData pd) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchaseCompanyPeriod");
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
        List<Map> varList = this.getDataListPage(pd);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel listPagePurchaseCompanyPeriod(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchaseCompanyPeriod");
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

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public ResultModel findPaymentPeriodByCompanyId(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //paymentPeriod 当前付款期(yyyymm)
        PurchaseCompanyPeriod companyPeriod = this.findPurchaseCompanyPeriodByCompanyId(companyId);
        if (companyPeriod == null || companyPeriod.getPaymentPeriod() == null || companyPeriod.getPaymentPeriod().trim().length() == 0) {
            model.putCode("1");
            model.putMsg("您所在的企业无当前付款期间，请与管理员联系！");
            return model;
        }
        String paymentPeriod = companyPeriod.getPaymentPeriod().trim();

        model.set("paymentPeriod", paymentPeriod);
        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelPurchaseCompanyPeriods(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("purchaseCompanyPeriod");
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
            fileName = "ExcelPurchaseCompanyPeriod";
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
    public ResultModel importExcelPurchaseCompanyPeriods(MultipartFile file) throws Exception{
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


}



