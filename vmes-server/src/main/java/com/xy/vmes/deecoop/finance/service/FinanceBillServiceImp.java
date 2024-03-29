package com.xy.vmes.deecoop.finance.service;


import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.finance.dao.FinanceBillMapper;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.entity.FinanceHistory;
import com.xy.vmes.entity.FinancePeriod;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_finance_bill:应收/应付单 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-11-07
*/
@Service
@Transactional(readOnly = false)
public class FinanceBillServiceImp implements FinanceBillService {


    @Autowired
    private FinanceBillMapper financeBillMapper;
    @Autowired
    private FinanceHistoryService financeHistoryService;
    @Autowired
    private FinancePeriodService financePeriodService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void save(FinanceBill financeBill) throws Exception{
        financeBill.setId(Conv.createUuid());
        financeBill.setCdate(new Date());
        financeBill.setUdate(new Date());
        financeBillMapper.insert(financeBill);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void update(FinanceBill financeBill) throws Exception{
        financeBill.setUdate(new Date());
        financeBillMapper.updateById(financeBill);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void updateAll(FinanceBill financeBill) throws Exception{
        financeBill.setUdate(new Date());
        financeBillMapper.updateAllColumnById(financeBill);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    //@Cacheable(cacheNames = "financeBill", key = "''+#id")
    public FinanceBill selectById(String id) throws Exception{
        return financeBillMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void deleteById(String id) throws Exception{
        financeBillMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        financeBillMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<FinanceBill> dataListPage(PageData pd,Pagination pg) throws Exception{
        return financeBillMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<FinanceBill> dataList(PageData pd) throws Exception{
        return financeBillMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return financeBillMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return financeBillMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        financeBillMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<FinanceBill> selectByColumnMap(Map columnMap) throws Exception{
    List<FinanceBill> financeBillList =  financeBillMapper.selectByMap(columnMap);
        return financeBillList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return financeBillMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return financeBillMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBillMapper.getDataListPage(pd);
        } else if (pg != null) {
            return financeBillMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        financeBillMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-11-07
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        financeBillMapper.updateByDefined(pd);
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
    public List<FinanceBill> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<FinanceBill>();
        }

        return this.dataList(pageData);
    }

    public FinanceBill findFinanceBill(PageData object) throws Exception {
        List<FinanceBill> objectList = this.findFinanceBillList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public FinanceBill findFinanceBillById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findFinanceBill(findMap);
    }
    public List<FinanceBill> findFinanceBillList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageFinanceBills(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("FinanceBill");
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

        if (pd.getString("inTypes") != null && pd.getString("inTypes").trim().length() > 0) {
            String inTypes = pd.getString("inTypes").trim();
            inTypes = StringUtil.stringTrimSpace(inTypes);
            inTypes = "'" + inTypes.replace(",", "','") + "'";
            pd.put("inTypes", inTypes);
        }

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
    public void exportExcelFinanceBills(PageData pd) throws Exception{

        List<Column> columnList = columnService.findColumnList("FinanceBill");
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
            fileName = "ExcelFinanceBill";
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
    public ResultModel importExcelFinanceBills(MultipartFile file) throws Exception{
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
    public ResultModel batchAddFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }
        String currentCompanyId = pd.getString("currentCompanyId");
        String type = pd.getString("type");

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pd.getString("isAutoCommit");

        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String period = format.format(new Date());
        for (Map<String, String> mapObject : mapList) {
            String customerId = mapObject.get("id");
            FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(mapObject, new FinanceBill());
//            String code = coderuleService.createCoderCdateByDate(currentCompanyId,"vmes_finance_bill","yyyyMMdd","R");
            String code = coderuleService.createCoderCdateOnShortYearByDate(currentCompanyId,"vmes_finance_bill","R", Common.CODE_RULE_LENGTH_3);
            financeBill.setCode(code);
            financeBill.setPeriod(period);
            financeBill.setCompanyId(currentCompanyId);
            financeBill.setCustomerId(customerId);
            financeBill.setType(type);

            //状态（0：待提交 1：待审核 2：已审核 -1：已取消）
            financeBill.setState("0");
            if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                financeBill.setState("1");
            }

            this.save(financeBill);
        }

        return model;
    }


    @Override
    public ResultModel deleteFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
               if("-1".equals(financeBill.getState())){
                   this.deleteById(financeBill.getId());
               }else{
                   model.putCode(Integer.valueOf(1));
                   model.putMsg("只能删除已取消状态的收款单据！");
                   return model;
               }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("删除目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("删除目标未找到！");
            return model;
        }

        return model;
    }


    @Override
    public ResultModel cancelFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("0".equals(financeBill.getState())){
                    financeBill.setState("-1");
                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只能取消待提交状态的收款单据！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }


    @Override
    public ResultModel recoverFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("-1".equals(financeBill.getState())){
                    financeBill.setState("0");
                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只能恢复已取消状态的收款单据！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }

    @Override
    public ResultModel submitFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("0".equals(financeBill.getState())){
                    financeBill.setState("1");
                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只有待提交状态的收款单才能提交！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }

    @Override
    public ResultModel rebackFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("1".equals(financeBill.getState())){
                    financeBill.setState("0");
                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只有待审核状态的收款单才能撤回！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }

    @Override
    public ResultModel eidtFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("0".equals(financeBill.getState())){
                    //isAutoCommit true:自动提交 false:手动提交
                    String isAutoCommit = pd.getString("isAutoCommit");

                    //状态（0：待提交 1：待审核 2：已审核 -1：已取消）
                    financeBill.setState("0");
                    if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                        financeBill.setState("1");
                    }

                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只有待提交状态的收款单才能修改！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }

    @Override
    public ResultModel comfirmFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String suser = pd.getString("currentUserId");
        FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(pd, new FinanceBill());
        if(financeBill!=null){
            if(!StringUtils.isEmpty(financeBill.getState())){
                if("1".equals(financeBill.getState())){
                    financeBill.setState("2");
                    financeBill.setSdate(new Date());
                    financeBill.setSuser(suser);
                    this.update(financeBill);
                }else{
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("只有待审核状态才能审核！");
                    return model;
                }
            }else{
                model.putCode(Integer.valueOf(1));
                model.putMsg("操作目标未找到！");
                return model;
            }
        }else{
            model.putCode(Integer.valueOf(1));
            model.putMsg("操作目标未找到！");
            return model;
        }

        return model;
    }



    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-11-07
     */
    public List<Map> getFinanceReceiveView(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBillMapper.getFinanceReceiveView(pd);
        } else if (pg != null) {
            return financeBillMapper.getFinanceReceiveView(pd,pg);
        }

        return mapList;
    }

    @Override
    public Map<String,Object>  getFinanceReceiveGroup(PageData pd) throws Exception {
        return  financeBillMapper.getFinanceReceiveGroup(pd);
    }

    @Override
    public ResultModel getFinanceReceiveView(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("FinanceReceiveView");
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
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }
        pd.put("orderStr"," case when nowPlus-nowMinus+beginPlus-beginMinus=0 then null else nowPlus-nowMinus+beginPlus-beginMinus end desc ");

        List<Map> varList = this.getFinanceReceiveView(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

//        Map<String,Object> receiveMap = this.getFinanceReceiveGroup(pd);
//        if(receiveMap!=null){
//            BigDecimal preReceiveAmount = BigDecimal.valueOf(0D);
//            if (receiveMap.get("preReceiveAmount") != null) {
//                preReceiveAmount = (BigDecimal)receiveMap.get("preReceiveAmount");
//            }
//            //四舍五入到2位小数
//            preReceiveAmount = preReceiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            result.put("preReceiveAmount", preReceiveAmount.toString());
//
//            BigDecimal nowReceiveAmount = BigDecimal.valueOf(0D);
//            if (receiveMap.get("nowReceiveAmount") != null) {
//                nowReceiveAmount = (BigDecimal)receiveMap.get("nowReceiveAmount");
//            }
//            //四舍五入到2位小数
//            nowReceiveAmount = nowReceiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            result.put("nowReceiveAmount", nowReceiveAmount.toString());
//        }

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }



    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-11-07
     */
    public List<Map> getFinanceBillDetail(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBillMapper.getFinanceBillDetail(pd);
        } else if (pg != null) {
            return financeBillMapper.getFinanceBillDetail(pd,pg);
        }

        return mapList;
    }

    @Override
    public ResultModel getFinanceBillDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("FinanceBillDetail");
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

        List<Map> varList = this.getFinanceBillDetail(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel unCheckOutFinanceReceive(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        GregorianCalendar gc =new GregorianCalendar();
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMM");
        String companyId = pd.getString("currentCompanyId");
        PageData pageData = new PageData();
        pageData.put("company_id",companyId);
        List<FinancePeriod> financePeriodList = financePeriodService.selectByColumnMap(pageData);
        if(financePeriodList!=null&&financePeriodList.size()>0){
            for(int i=0;i<financePeriodList.size();i++){
                FinancePeriod financePeriod = financePeriodList.get(i);
                if(i==0){
                    financePeriod.getCurrentPeriod();
                    Date preDate = financePeriod.getCurrentPeriodDate();
                    gc.setTime(preDate);
                    gc.add(2,-1);
                    gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
                    Date curDate = gc.getTime();
                    String curPeriod = sdf.format(curDate);
                    financePeriod.setCurrentPeriodDate(curDate);
                    financePeriod.setCurrentPeriod(curPeriod);
                    this.deleteFinanceHistory(financePeriod);
                    financePeriodService.update(financePeriod);
                }else if(i>=1){
                    financePeriodService.deleteById(financePeriod.getId());
                }
            }
        }else{
            this.saveFinancePeriod(companyId);
        }

        return model;
    }

    public void deleteFinanceHistory(FinancePeriod financePeriod) throws Exception {
        PageData pageData = new PageData();
        pageData.put("period",financePeriod.getCurrentPeriod());
        pageData.put("companyId",financePeriod.getCompanyId());
        financeHistoryService.deleteFinanceHistory(pageData);
    }

    public void saveFinancePeriod(String companyId) throws Exception {
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMM");
        Date nowDate = new Date();
        String nowPeriod = sdf.format(nowDate);
        FinancePeriod financePeriod = new FinancePeriod();
        financePeriod.setCompanyId(companyId);
        financePeriod.setCurrentPeriod(nowPeriod);
        financePeriod.setCurrentPeriodDate(nowDate);
        financePeriod.setInitialPeriod(nowPeriod);
        financePeriod.setInitialPeriodDate(nowDate);
        financePeriodService.save(financePeriod);
    }

    public void saveFinanceHistory(Map map) throws Exception {
        FinanceHistory financeHistory = new FinanceHistory();
        String customerId = map.get("id")==null?null:(String)map.get("id");
        financeHistory.setCustomerId(customerId);
        String companyId = map.get("companyId")==null?null:(String)map.get("companyId");
        financeHistory.setCompanyId(companyId);
        String period = map.get("currentPeriod")==null?null:(String)map.get("currentPeriod");
        financeHistory.setPeriod(period);
        BigDecimal beginPlus = map.get("beginPlus")==null? BigDecimal.ZERO:(BigDecimal)map.get("beginPlus");
        financeHistory.setBeginPlus(beginPlus);
        BigDecimal beginMinus = map.get("beginMinus")==null? BigDecimal.ZERO:(BigDecimal)map.get("beginMinus");
        financeHistory.setBeginMinus(beginMinus);
        BigDecimal nowPlus = map.get("nowPlus")==null? BigDecimal.ZERO:(BigDecimal)map.get("nowPlus");
        financeHistory.setNowPlus(nowPlus);
        BigDecimal nowMinus = map.get("nowMinus")==null? BigDecimal.ZERO:(BigDecimal)map.get("nowMinus");
        financeHistory.setNowMinus(nowMinus);
        BigDecimal endPlus = map.get("endPlus")==null? BigDecimal.ZERO:(BigDecimal)map.get("endPlus");
        financeHistory.setEndPlus(endPlus);
        BigDecimal endMinus = map.get("endMinus")==null? BigDecimal.ZERO:(BigDecimal)map.get("endMinus");
        financeHistory.setEndMinus(endMinus);
        BigDecimal overdue = map.get("overdue")==null? BigDecimal.ZERO:(BigDecimal)map.get("overdue");
        financeHistory.setOverdue(overdue);
        financeHistoryService.save(financeHistory);
    }

    @Override
    public ResultModel checkOutFinanceReceive(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        GregorianCalendar gc =new GregorianCalendar();
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMM");
        String companyId = pd.getString("currentCompanyId");
        PageData pageData = new PageData();
        pageData.put("company_id",companyId);
        List<FinancePeriod> financePeriodList = financePeriodService.selectByColumnMap(pageData);
        if(financePeriodList!=null&&financePeriodList.size()>0){
            for(int i=0;i<financePeriodList.size();i++){
                FinancePeriod financePeriod = financePeriodList.get(i);
                if(i==0){

                    //currentPeriod:当前期间(yyyymm) 与系统时间比较
                    //系统时间(yyyymm)
                    String sysMonthStr = DateFormat.date2String(new Date(), "yyyyMM");
                    Date sysMonthDate = DateFormat.dateString2Date(sysMonthStr, "yyyyMM");
                    long sysMonthLong = 0L;
                    if (sysMonthDate != null) {
                        sysMonthLong = sysMonthDate.getTime();
                    }

                    //currentPeriod:当前期间(yyyymm) 加1个月
                    long currentPeriodLong = 0L;
                    String addCurrentPeriodStr = new String();
                    if (financePeriod.getCurrentPeriod() != null && financePeriod.getCurrentPeriod().trim().length() > 0) {
                        String currentPeriodStr = financePeriod.getCurrentPeriod().trim();
                        //当前期间(yyyymm) 加1个月
                        addCurrentPeriodStr = DateFormat.getAddDay(currentPeriodStr, DateFormat.DEFAULT_MONTH, 1, "yyyyMM");

                        Date addCurrentPeriodDate = DateFormat.dateString2Date(addCurrentPeriodStr, "yyyyMM");
                        if (addCurrentPeriodDate != null) {
                            currentPeriodLong = addCurrentPeriodDate.getTime();
                        }
                    }

                    if (sysMonthLong != 0L
                        && currentPeriodLong != 0L
                        && (sysMonthLong < currentPeriodLong)
                    ) {
                        String msgTemp = "结账期间({0})不可大于当前自然月！";
                        String msgStr = MessageFormat.format(msgTemp, addCurrentPeriodStr);
                        model.putCode(Integer.valueOf(1));
                        model.putMsg(msgStr);
                        return model;
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

                    List<Map> varList = this.getFinanceReceiveView(pd,pg);
                    if(varList!=null&&varList.size()>0){
                        for(int j=0;j<varList.size();j++){
                            Map map = varList.get(j);
                            this.saveFinanceHistory(map);
                        }
                    }

                    Date preDate = financePeriod.getCurrentPeriodDate();
                    gc.setTime(preDate);
                    gc.add(2,+1);
                    gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
                    Date curDate = gc.getTime();
                    String curPeriod = sdf.format(curDate);
                    financePeriod.setCurrentPeriodDate(curDate);
                    financePeriod.setCurrentPeriod(curPeriod);
                    financePeriodService.update(financePeriod);


                }else if(i>=1){
                    financePeriodService.deleteById(financePeriod.getId());
                }
            }
        }else{
            this.saveFinancePeriod(companyId);
        }

        return model;
    }

    /**
     *
     * @param businessId  业务单据id
     * @param companyId   企业id
     * @param customerId  客户id
     * @param userId      用户id
     * @param type        付款单类型(vmes_finance_bill.type)
     * @param attribute   付款单属性(vmes_finance_bill.attribute)
     * @param amount
     * @throws Exception
     */
    public void addFinanceBillBySys(String businessId,
                                    String companyId,
                                    String customerId,
                                    String userId,
                                    String type,
                                    String attribute,
                                    BigDecimal amount,
                                    String remark) throws Exception {
        FinanceBill addObject = new FinanceBill();
        addObject.setCompanyId(companyId);
        addObject.setCustomerId(customerId);
        addObject.setBusinessId(businessId);

        addObject.setCuser(userId);
        //suser 审核用户id
        addObject.setSuser(userId);

        //type 单据类型 ( 0:收款单 1:付款单 2:减免单 3:退款单 4:发货账单 5:发退货账单 6:收货账单 7:收退货账单)
        addObject.setType(type);
        //amount 金额
        if (amount != null) {
            addObject.setAmount(amount);
        }

        //付款单属性(vmes_finance_bill.attribute) 反拉业务单据使用
        if (attribute != null && attribute.trim().length() > 0) {
            addObject.setAttribute(attribute);
        }

        //sdate 审核时间
        addObject.setSdate(new Date());

        //state 状态（0：待提交 1：待审核 2：已审核 -1：已取消）
        addObject.setState("2");
        addObject.setRemark(remark);
        //生成付款单编码
        //String code = coderuleService.createCoderCdateByDate(companyId,"vmes_finance_bill","yyyyMMdd","R");
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyId,"vmes_finance_bill","R", Common.CODE_RULE_LENGTH_3);
        addObject.setCode(code);

        //period 收/付款期间(yyyyMM)
        String period = DateFormat.date2String(new Date(), "yyyyMM");
        addObject.setPeriod(period);

        this.save(addObject);
    }
}



