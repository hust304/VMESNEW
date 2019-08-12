package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.deecoop.purchase.dao.PurchasePlanMapper;
import com.xy.vmes.entity.PurchasePlan;
import com.xy.vmes.entity.PurchasePlanDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.PurchasePlanDetailService;
import com.xy.vmes.service.PurchasePlanService;

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
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_purchase_plan:采购计划 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-02-28
*/
@Service
@Transactional(readOnly = false)
public class PurchasePlanServiceImp implements PurchasePlanService {


    @Autowired
    private PurchasePlanMapper purchasePlanMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;
    @Autowired
    private CoderuleService coderuleService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void save(PurchasePlan purchasePlan) throws Exception{
        purchasePlan.setId(Conv.createUuid());
        purchasePlan.setCdate(new Date());
        purchasePlan.setUdate(new Date());
        purchasePlanMapper.insert(purchasePlan);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void update(PurchasePlan purchasePlan) throws Exception{
        purchasePlan.setUdate(new Date());
        purchasePlanMapper.updateById(purchasePlan);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void updateAll(PurchasePlan purchasePlan) throws Exception{
        purchasePlan.setUdate(new Date());
        purchasePlanMapper.updateAllColumnById(purchasePlan);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    //@Cacheable(cacheNames = "purchasePlan", key = "''+#id")
    public PurchasePlan selectById(String id) throws Exception{
        return purchasePlanMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePlanMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePlanMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlan> dataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePlanMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlan> dataList(PageData pd) throws Exception{
        return purchasePlanMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return purchasePlanMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return purchasePlanMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePlanMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlan> selectByColumnMap(Map columnMap) throws Exception{
    List<PurchasePlan> purchasePlanList =  purchasePlanMapper.selectByMap(columnMap);
        return purchasePlanList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return purchasePlanMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return purchasePlanMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePlanMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePlanMapper.updateToDisableByIds(ids);
    }


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-02-28
     */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        purchasePlanMapper.updateByDefined(pd);
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
    public List<PurchasePlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePlan>();
        }

        return this.dataList(pageData);
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchasePlans(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("PurchasePlan");
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

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelPurchasePlans(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("PurchasePlan");
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
            fileName = "ExcelPurchasePlan";
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
    public ResultModel importExcelPurchasePlans(MultipartFile file) throws Exception{
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
    public ResultModel checkPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String prodIds = pageData.getString("prodIds");
        pageData.put("queryStr"," detail.product_id in ("+prodIds+") and detail.state in ('0','1','2','3') ");
        List<Map> purchasePlanDetailList = purchasePlanDetailService.getDataList(pageData);
        String productNames = "";
        if(purchasePlanDetailList!=null&&purchasePlanDetailList.size()>0){
            for(int i=0;i<purchasePlanDetailList.size();i++){
                Map purchasePlanDetail = purchasePlanDetailList.get(i);
                if(purchasePlanDetail!=null&&purchasePlanDetail.get("productName")!=null){
                   String productName = (String)purchasePlanDetail.get("productName");
                   if(!StringUtils.isEmpty(productName)){
                       if(StringUtils.isEmpty(productNames)){
                           productNames = productName;
                       }else {
                           if(productNames.indexOf(productName)<0){
                               productNames = productNames +","+ productName;
                           }
                       }
                   }
                }
            }
        }

        if(!StringUtils.isEmpty(productNames)){
            model.putMsg("货品（"+productNames+"）已在采购计划中，是否继续？");
        }
        return model;
    }

    @Override
    public ResultModel addPurchasePlan(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        PurchasePlan purchasePlan = (PurchasePlan)HttpUtils.pageData2Entity(pd, new PurchasePlan());
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购计划明细Json字符串-转换成List错误！");
            return model;
        }
        String companyID = pd.getString("currentCompanyId");
        String code = coderuleService.createCoderCdateByDate(companyID,
                "vmes_purchase_plan",
                "yyyyMMdd",
                "P");
        purchasePlan.setCode(code);
        purchasePlan.setCompanyId(companyID);

        //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
        purchasePlan.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pd.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            purchasePlan.setState("1");
        }
        this.save(purchasePlan);

        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail) HttpUtils.pageData2Entity(detailMap, new PurchasePlanDetail());
                purchasePlanDetail.setParentId(purchasePlan.getId());
                String reasonId = purchasePlanDetail.getReason();
                if(StringUtils.isEmpty(reasonId)){
                    purchasePlanDetail.setReason("350135d34d1b43aeb4e2977061632045");//齐套分析预采
                }
                purchasePlanDetail.getProductId();
                //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                purchasePlanDetail.setState("0");
                purchasePlanDetail.setCuser(purchasePlan.getCuser());
                purchasePlanDetail.setUuser(purchasePlan.getUuser());
                purchasePlanDetailService.save(purchasePlanDetail);
            }
        }
        return model;
    }

    @Override
    public ResultModel editPurchasePlan(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        PurchasePlan purchasePlan = (PurchasePlan)HttpUtils.pageData2Entity(pd, new PurchasePlan());
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购计划明细Json字符串-转换成List错误！");
            return model;
        }
        this.update(purchasePlan);
        Map columnMap = new HashMap();
        columnMap.put("parent_id",purchasePlan.getId());
        purchasePlanDetailService.deleteByColumnMap(columnMap);
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                PurchasePlanDetail purchasePlanDetail = (PurchasePlanDetail) HttpUtils.pageData2Entity(detailMap, new PurchasePlanDetail());
                purchasePlanDetail.setParentId(purchasePlan.getId());
                //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                purchasePlanDetail.setState("0");
                purchasePlanDetail.setCuser(purchasePlan.getCuser());
                purchasePlanDetail.setUuser(purchasePlan.getUuser());
                purchasePlanDetailService.save(purchasePlanDetail);
            }
        }
        return model;
    }

    @Override
    public ResultModel cancelPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"'  and state in ('0','2')  ");
        pageData.put("updateStr"," state = '-1' ");
        purchasePlanDetailService.updateByDefined(pageData);

//        PurchasePlan purchasePlan = this.selectById(id);
//        purchasePlan.setState("-1");
//        this.update(purchasePlan);
        this.updateState(id);
        return model;
    }

    @Override
    public ResultModel recoveryPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"'  and state = '-1'  ");
        pageData.put("updateStr"," state = '0' ");
        purchasePlanDetailService.updateByDefined(pageData);

//        PurchasePlan purchasePlan = this.selectById(id);
//        purchasePlan.setState("0");
//        this.update(purchasePlan);
        this.updateState(id);
        return model;
    }

    @Override
    public ResultModel deletePurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        Map columnMap = new HashMap();
        columnMap.put("parent_id",id);
        purchasePlanDetailService.deleteByColumnMap(columnMap);
        this.deleteById(id);
        return model;
    }

    @Override
    public ResultModel rebackPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String remark = pageData.getString("remark");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"' and state = '1'  ");
        pageData.put("updateStr"," state = '0' ");
        purchasePlanDetailService.updateByDefined(pageData);

//        PurchasePlan purchasePlan = this.selectById(id);
//        purchasePlan.setState("0");
//        this.update(purchasePlan);
        this.updateState(id,remark);
        return model;
    }

    @Override
    public ResultModel submitPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String ids = pageData.getString("ids");
        if (StringUtils.isEmpty(ids)) {
            model.putCode("1");
            model.putMsg("请至少选择一条记录！");
            return model;
        }

        pageData.put("queryStr"," id in ('"+ids+"')  and state = '0' ");
        pageData.put("updateStr"," state = '1' ");
        this.updateByDefined(pageData);
        pageData.put("queryStr"," parent_id in ('"+ids+"')  and state = '0' ");
        pageData.put("updateStr"," state = '1' ");
        purchasePlanDetailService.updateByDefined(pageData);
        return model;
    }

    @Override
    public ResultModel auditPurchasePlan(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String ids = pageData.getString("ids");
        if (StringUtils.isEmpty(ids)) {
            model.putCode("1");
            model.putMsg("请至少选择一条记录！");
            return model;
        }

        pageData.put("queryStr"," id in ('"+ids+"')  and state = '1' ");
        pageData.put("updateStr"," state = '2' ");
        this.updateByDefined(pageData);
        pageData.put("queryStr"," parent_id in ('"+ids+"') and state = '1'  ");
        pageData.put("updateStr"," state = '2' ");
        purchasePlanDetailService.updateByDefined(pageData);
        return model;
    }

    @Override
    public void updateState(String id,String remark) throws Exception {
        PurchasePlan purchasePlan = this.selectById(id);
        purchasePlan.setRemark(remark);
        //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
        int yqx = 0;//已取消
        int dtj = 0;//待提交
        int dsh = 0;//待审核
        int dzx = 0;//待执行
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(purchasePlan!=null){
            Map columnMap = new HashMap();
            columnMap.put("parent_id",id);
            List<PurchasePlanDetail> detailList = purchasePlanDetailService.selectByColumnMap(columnMap);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    PurchasePlanDetail purchasePlanDetail = detailList.get(i);
                    if("-1".equals(purchasePlanDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(purchasePlanDetail.getState())){
                        dtj = dtj + 1;
                    }else if("1".equals(purchasePlanDetail.getState())){
                        dsh = dsh + 1;
                    }else if("2".equals(purchasePlanDetail.getState())){
                        dzx = dzx + 1;
                    }else if("3".equals(purchasePlanDetail.getState())){
                        zxz = zxz + 1;
                    }else if("4".equals(purchasePlanDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前单据没有明细则自动删除当前单据
                this.deleteById(id);
                return;
            }
            //该单据明细状态全是已取消状态，则说明当前单据状态为已取消
            if(yqx>0&&dtj==0&&dsh==0&&dzx==0&&zxz==0&&ywc==0){
                purchasePlan.setState("-1");//已取消
            }
            //该单据明细状态全是已完成和已取消状态，则说明当前单据状态为已完成
            else if(ywc>0&&dtj==0&&dsh==0&&dzx==0&&zxz==0){
                purchasePlan.setState("4");//已完成
            }
            //该单据明细状态全是待提交和已取消状态，则说明当前单据状态为待提交
            else if(dtj>0&&ywc==0&&dsh==0&&dzx==0&&zxz==0){
                purchasePlan.setState("0");//待提交
            }
            //该单据明细状态全是待审核和已取消状态，则说明当前单据状态为待审核
            else if(dsh>0&&dtj==0&&ywc==0&&dzx==0&&zxz==0){
                purchasePlan.setState("1");//待审核
            }
            //该单据明细状态存在待执行且不存在执行中，则说明当前单据状态为待执行
            else if(dzx>0&&zxz==0){
                purchasePlan.setState("2");//待执行
            }
            //该单据明细状态存在执行中，则说明当前单据状态为执行中
            else if(zxz>0){
                purchasePlan.setState("3");//执行中
            }
            this.update(purchasePlan);
        }

    }

    @Override
    public void updateState(String id) throws Exception {
        PurchasePlan purchasePlan = this.selectById(id);
        //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
        int yqx = 0;//已取消
        int dtj = 0;//待提交
        int dsh = 0;//待审核
        int dzx = 0;//待执行
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(purchasePlan!=null){
            Map columnMap = new HashMap();
            columnMap.put("parent_id",id);
            List<PurchasePlanDetail> detailList = purchasePlanDetailService.selectByColumnMap(columnMap);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    PurchasePlanDetail purchasePlanDetail = detailList.get(i);
                    if("-1".equals(purchasePlanDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(purchasePlanDetail.getState())){
                        dtj = dtj + 1;
                    }else if("1".equals(purchasePlanDetail.getState())){
                        dsh = dsh + 1;
                    }else if("2".equals(purchasePlanDetail.getState())){
                        dzx = dzx + 1;
                    }else if("3".equals(purchasePlanDetail.getState())){
                        zxz = zxz + 1;
                    }else if("4".equals(purchasePlanDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前单据没有明细则自动删除当前单据
                this.deleteById(id);
                return;
            }
            //该单据明细状态全是已取消状态，则说明当前单据状态为已取消
            if(yqx>0&&dtj==0&&dsh==0&&dzx==0&&zxz==0&&ywc==0){
                purchasePlan.setState("-1");//已取消
            }
            //该单据明细状态全是已完成和已取消状态，则说明当前单据状态为已完成
            else if(ywc>0&&dtj==0&&dsh==0&&dzx==0&&zxz==0){
                purchasePlan.setState("4");//已完成
            }
            //该单据明细状态全是待提交和已取消状态，则说明当前单据状态为待提交
            else if(dtj>0&&ywc==0&&dsh==0&&dzx==0&&zxz==0){
                purchasePlan.setState("0");//待提交
            }
            //该单据明细状态全是待审核和已取消状态，则说明当前单据状态为待审核
            else if(dsh>0&&dtj==0&&ywc==0&&dzx==0&&zxz==0){
                purchasePlan.setState("1");//待审核
            }
            //该单据明细状态存在待执行且不存在执行中，则说明当前单据状态为待执行
            else if(dzx>0&&zxz==0){
                purchasePlan.setState("2");//待执行
            }
            //该单据明细状态存在执行中，则说明当前单据状态为执行中
            else if(zxz>0){
                purchasePlan.setState("3");//执行中
            }
            this.update(purchasePlan);
        }

    }
}



