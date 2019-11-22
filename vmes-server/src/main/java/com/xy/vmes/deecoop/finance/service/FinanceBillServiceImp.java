package com.xy.vmes.deecoop.finance.service;


import com.xy.vmes.deecoop.finance.dao.FinanceBillMapper;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.FinanceBillService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String period = format.format(new Date());
        for (Map<String, String> mapObject : mapList) {
            String customerId = mapObject.get("id");
            FinanceBill financeBill = (FinanceBill) HttpUtils.pageData2Entity(mapObject, new FinanceBill());
            String code = coderuleService.createCoderCdateByDate(currentCompanyId,"vmes_finance_bill","yyyyMMdd","R");
            financeBill.setCode(code);
            financeBill.setPeriod(period);
            financeBill.setCompanyId(currentCompanyId);
            financeBill.setCustomerId(customerId);
            financeBill.setType(type);
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
    public ResultModel getFinanceReceiveView(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
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
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getFinanceReceiveView(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

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
}



