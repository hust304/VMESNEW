package com.xy.vmes.deecoop.finance.service;


import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.finance.dao.FinanceBaseMapper;
import com.xy.vmes.entity.FinanceBase;
import com.xy.vmes.entity.FinancePeriod;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.FinanceBaseService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.FinancePeriodService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_finance_base:应收应付初始化 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-11-05
*/
@Service
@Transactional(readOnly = false)
public class FinanceBaseServiceImp implements FinanceBaseService {

    @Autowired
    private FinancePeriodService financePeriodService;
    @Autowired
    private FinanceBaseMapper financeBaseMapper;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void save(FinanceBase financeBase) throws Exception{
        financeBase.setId(Conv.createUuid());
        financeBase.setCdate(new Date());
        financeBase.setUdate(new Date());
        financeBaseMapper.insert(financeBase);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void update(FinanceBase financeBase) throws Exception{
        financeBase.setUdate(new Date());
        financeBaseMapper.updateById(financeBase);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void updateAll(FinanceBase financeBase) throws Exception{
        financeBase.setUdate(new Date());
        financeBaseMapper.updateAllColumnById(financeBase);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    //@Cacheable(cacheNames = "financeBase", key = "''+#id")
    public FinanceBase selectById(String id) throws Exception{
        return financeBaseMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void deleteById(String id) throws Exception{
        financeBaseMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        financeBaseMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<FinanceBase> dataListPage(PageData pd,Pagination pg) throws Exception{
        return financeBaseMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<FinanceBase> dataList(PageData pd) throws Exception{
        return financeBaseMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return financeBaseMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return financeBaseMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        financeBaseMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<FinanceBase> selectByColumnMap(Map columnMap) throws Exception{
    List<FinanceBase> financeBaseList =  financeBaseMapper.selectByMap(columnMap);
        return financeBaseList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return financeBaseMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return financeBaseMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBaseMapper.getDataListPage(pd);
        } else if (pg != null) {
            return financeBaseMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        financeBaseMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-05
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        financeBaseMapper.updateByDefined(pd);
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
    public List<FinanceBase> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<FinanceBase>();
        }

        return this.dataList(pageData);
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageFinanceBases(PageData pd) throws Exception{
        ResultModel model = new ResultModel();

        String modelCode = new String("FinanceBase");
        if (pd.getString("modelCode") != null && pd.getString("modelCode").trim().length() > 0) {
            modelCode = pd.getString("modelCode").trim();
        }

        List<Column> columnList = columnService.findColumnList(modelCode);
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    public void exportExcelFinanceBases(PageData pd) throws Exception{

        List<Column> columnList = columnService.findColumnList("FinanceBase");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }
        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
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
        List<Map> dataList = this.getDataListPage(pd, null);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelFinanceBase";
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
    public ResultModel importExcelFinanceBases(MultipartFile file) throws Exception{
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

    @Override
    public ResultModel addFinanceBase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date currentDate = new Date();
        String priod = sdf.format(currentDate);
        FinanceBase financeBase = (FinanceBase)HttpUtils.pageData2Entity(pd, new FinanceBase());
        String currentCompanyId = pd.getString("currentCompanyId");
        financeBase.setCompanyId(currentCompanyId);
        financeBase.setPeriod(priod);
        financeBase.setPeriodDate(currentDate);

        this.setFinanceBaseValue(pd,financeBase,model);
        this.saveFinancePeriod(financeBase);
        this.save(financeBase);

        return model;
    }

    private void saveFinancePeriod( FinanceBase financeBase) throws Exception {
        PageData pd = new PageData();
        pd.put("company_id",financeBase.getCompanyId());
        List<FinancePeriod> financePeriodList = financePeriodService.selectByColumnMap(pd);
        if(financePeriodList!=null&&financePeriodList.size()>0){
            for(int i=0;i<financePeriodList.size();i++){
                FinancePeriod financePeriod = financePeriodList.get(i);
                if(i==0){
                    financeBase.setPeriod(financePeriod.getCurrentPeriod());
                    financeBase.setPeriodDate(financePeriod.getCurrentPeriodDate());
                }else if(i>=1){
                    financePeriodService.deleteById(financePeriod.getId());
                }
            }
        }else{
            FinancePeriod financePeriod = new FinancePeriod();
            financePeriod.setCompanyId(financeBase.getCompanyId());
            financePeriod.setCurrentPeriod(financeBase.getPeriod());
            financePeriod.setCurrentPeriodDate(financeBase.getPeriodDate());
            financePeriod.setInitialPeriod(financeBase.getPeriod());
            financePeriod.setInitialPeriodDate(financeBase.getPeriodDate());
            financePeriodService.save(financePeriod);
        }

    }

    private void setFinanceBaseValue(PageData pd, FinanceBase financeBase, ResultModel model) {
        String amountStr = pd.getString("amount");
        if(!StringUtils.isEmpty(amountStr)){
            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(amountStr));
            String recevieType = pd.getString("recevieType");
            if(!StringUtils.isEmpty(recevieType)){
                if("plus".equals(recevieType)){
                    financeBase.setBeginPlus(amount);
                    financeBase.setBeginMinus(BigDecimal.ZERO);
                    financeBase.setBeginValue(amount);
                }else if("minus".equals(recevieType)){
                    financeBase.setBeginPlus(BigDecimal.ZERO);
                    financeBase.setBeginMinus(amount);
                    financeBase.setBeginValue(amount.negate());
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("收款类型错误！");
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("收款类型不能为空！");
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("收款金额不能为空！");
        }

    }


    @Override
    public ResultModel eidtFinanceBase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date currentDate = new Date();
        String priod = sdf.format(currentDate);
        FinanceBase financeBase = (FinanceBase)HttpUtils.pageData2Entity(pd, new FinanceBase());
        String currentCompanyId = pd.getString("currentCompanyId");
        financeBase.setCompanyId(currentCompanyId);
        financeBase.setPeriod(priod);
        financeBase.setPeriodDate(currentDate);
        this.setFinanceBaseValue(pd,financeBase,model);
        this.saveFinancePeriod(financeBase);
        this.update(financeBase);
        return model;
    }

    @Override
    public ResultModel deleteFinanceBase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        FinanceBase financeBase = (FinanceBase)HttpUtils.pageData2Entity(pd, new FinanceBase());
        if(financeBase!=null){
            this.deleteById(financeBase.getId());
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("删除目标未找到！");
        }
        return model;
    }

    @Override
    public ResultModel initialFinanceSale(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        financeBaseMapper.initialFinanceSale(pd);
        return model;
    }

    public ResultModel initialFinancePurchase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        financeBaseMapper.initialFinancePurchase(pd);
        return model;
    }

    @Override
    public ResultModel isDisableSaleInit(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        model.put("disableSaleInit","1");
        String currentCompanyId = pd.getString("currentCompanyId");
        pd = new PageData();
        pd.put("company_id",currentCompanyId);
        List<FinancePeriod> financePeriodList = financePeriodService.selectByColumnMap(pd);
        if(financePeriodList!=null&&financePeriodList.size()>0){
            for(int i=0;i<financePeriodList.size();i++){
                FinancePeriod financePeriod = financePeriodList.get(i);
                if(i==0){
                    model.put("disableSaleInit",financePeriod.getDisablesaleinit());
                }else if(i>=1){
                    financePeriodService.deleteById(financePeriod.getId());
                }
            }
        }

        return model;
    }

    @Override
    public ResultModel setDisableSaleInit(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String currentCompanyId = pd.getString("currentCompanyId");
        pd = new PageData();
        pd.put("company_id",currentCompanyId);
        List<FinancePeriod> financePeriodList = financePeriodService.selectByColumnMap(pd);
        if(financePeriodList!=null&&financePeriodList.size()>0){
            for(int i=0;i<financePeriodList.size();i++){
                FinancePeriod financePeriod = financePeriodList.get(i);
                if(i==0){
                    financePeriod.setDisablesaleinit("0");
                    financePeriodService.update(financePeriod);
                    model.put("disableSaleInit","0");
                }else if(i>=1){
                    financePeriodService.deleteById(financePeriod.getId());
                }
            }
        }else{
            model.put("disableSaleInit","1");
        }
        return model;
    }


    @Override
    public ResultModel batchAddFinanceBase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        //type:类型(0:应收 1:应付)
        String type = new String("0");
        if (pd.getString("type") != null && pd.getString("type").trim().length() > 0) {
            type = pd.getString("type").trim();
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }
        String currentCompanyId = pd.getString("currentCompanyId");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date currentDate = new Date();
        String priod = sdf.format(currentDate);

        for (Map<String, String> mapObject : mapList) {
            FinanceBase financeBase = (FinanceBase) HttpUtils.pageData2Entity(mapObject, new FinanceBase());
            if(financeBase!=null){
                if(financeBase.getBeginMinus()!=null){
                    if(financeBase.getBeginMinus().compareTo(BigDecimal.ZERO)>0){
                        financeBase.setBeginValue(financeBase.getBeginMinus().negate());
                    }else{
                        financeBase.setBeginValue(financeBase.getBeginPlus());
                    }

                    financeBase.setType(type);
                    financeBase.setCompanyId(currentCompanyId);
                    financeBase.setPeriod(priod);
                    financeBase.setPeriodDate(currentDate);
                    if(StringUtils.isEmpty(financeBase.getId())){
                        this.saveFinancePeriod(financeBase);
                        this.save(financeBase);
                    }else{
                        this.update(financeBase);
                    }
                }
            }
        }
        return model;
    }


}



