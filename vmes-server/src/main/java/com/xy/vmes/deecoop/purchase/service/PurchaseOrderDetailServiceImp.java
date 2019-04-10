package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.deecoop.purchase.dao.PurchaseOrderDetailMapper;
import com.xy.vmes.entity.PurchaseOrderDetail;
import com.xy.vmes.entity.PurchasePlanDetail;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_purchase_order_detail:采购订单明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-03-05
*/
@Service
@Transactional(readOnly = false)
public class PurchaseOrderDetailServiceImp implements PurchaseOrderDetailService {


    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;
    @Autowired
    private PurchasePlanService purchasePlanService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void save(PurchaseOrderDetail purchaseOrderDetail) throws Exception{
        purchaseOrderDetail.setId(Conv.createUuid());
        purchaseOrderDetail.setCdate(new Date());
        purchaseOrderDetail.setUdate(new Date());
        purchaseOrderDetailMapper.insert(purchaseOrderDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void update(PurchaseOrderDetail purchaseOrderDetail) throws Exception{
        purchaseOrderDetail.setUdate(new Date());
        purchaseOrderDetailMapper.updateById(purchaseOrderDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateAll(PurchaseOrderDetail purchaseOrderDetail) throws Exception{
        purchaseOrderDetail.setUdate(new Date());
        purchaseOrderDetailMapper.updateAllColumnById(purchaseOrderDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    //@Cacheable(cacheNames = "purchaseOrderDetail", key = "''+#id")
    public PurchaseOrderDetail selectById(String id) throws Exception{
        return purchaseOrderDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteById(String id) throws Exception{
        purchaseOrderDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchaseOrderDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrderDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return purchaseOrderDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrderDetail> dataList(PageData pd) throws Exception{
        return purchaseOrderDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return purchaseOrderDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return purchaseOrderDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchaseOrderDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrderDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<PurchaseOrderDetail> purchaseOrderDetailList =  purchaseOrderDetailMapper.selectByMap(columnMap);
        return purchaseOrderDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return purchaseOrderDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return purchaseOrderDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchaseOrderDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchaseOrderDetailMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        purchaseOrderDetailMapper.updateByDefined(pd);
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
    public List<PurchaseOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseOrderDetail>();
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
    public ResultModel listPagePurchaseOrderDetails(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("PurchaseOrderDetail");
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
//        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelPurchaseOrderDetails(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("PurchaseOrderDetail");
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
            fileName = "ExcelPurchaseOrderDetail";
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
    public ResultModel importExcelPurchaseOrderDetails(MultipartFile file) throws Exception{
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
    public ResultModel deletePurchaseOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchaseOrderDetail purchaseOrderDetail = this.selectById(id);
        if(purchaseOrderDetail!=null){
            if("0".equals(purchaseOrderDetail.getState())){
                String planDetailId = purchaseOrderDetail.getPlanId();
                if(!StringUtils.isEmpty(planDetailId)){
                    PurchasePlanDetail purchasePlanDetail = purchasePlanDetailService.selectById(planDetailId);
                    //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                    if(purchasePlanDetail!=null&&"3".equals(purchasePlanDetail.getState())){
                        purchasePlanDetail.setState("2");
                        purchasePlanDetailService.update(purchasePlanDetail);
                        purchasePlanService.updateState(purchasePlanDetail.getParentId());
                    }
                }
                this.deleteById(id);
                purchaseOrderService.updateState(purchaseOrderDetail.getParentId());
            }
            if("-1".equals(purchaseOrderDetail.getState())){
                this.deleteById(id);
                purchaseOrderService.updateState(purchaseOrderDetail.getParentId());
            }
        }

        return model;
    }

    @Override
    public ResultModel recoveryPurchaseOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchaseOrderDetail purchaseOrderDetail = this.selectById(id);
        if(purchaseOrderDetail!=null&&"-1".equals(purchaseOrderDetail.getState())){

            String planDetailId = purchaseOrderDetail.getPlanId();
            if(!StringUtils.isEmpty(planDetailId)){
                PurchasePlanDetail purchasePlanDetail = purchasePlanDetailService.selectById(planDetailId);
                if(purchasePlanDetail!=null){
                    if("2".equals(purchasePlanDetail.getState())){
                        purchaseOrderDetail.setState("0");
                        this.update(purchaseOrderDetail);
                        purchaseOrderService.updateState(purchaseOrderDetail.getParentId());
                        //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        purchasePlanDetail.setState("3");
                        purchasePlanDetailService.update(purchasePlanDetail);
                        purchasePlanService.updateState(purchasePlanDetail.getParentId());
                    }else if("4".equals(purchasePlanDetail.getState())){
                        model.putCode("2");
                        model.putMsg("当前采购订单明细关联的计划明细已完成，不能恢复！");
                        return model;
                    }else if("3".equals(purchasePlanDetail.getState())){
                        model.putCode("3");
                        model.putMsg("当前采购订单明细关联的计划明细正在执行中，不能恢复！");
                        return model;
                    }else if("1".equals(purchasePlanDetail.getState())){
                        model.putCode("4");
                        model.putMsg("当前采购订单明细关联的计划明细未审核，不能恢复！");
                        return model;
                    }else if("0".equals(purchasePlanDetail.getState())){
                        model.putCode("5");
                        model.putMsg("当前采购订单明细关联的计划明细未提交，不能恢复！");
                        return model;
                    }else if("-1".equals(purchasePlanDetail.getState())){
                        model.putCode("6");
                        model.putMsg("当前采购订单明细关联的计划明细已取消，不能恢复！");
                        return model;
                    }

                }

            }else {
                purchaseOrderDetail.setState("0");
                this.update(purchaseOrderDetail);
                purchaseOrderService.updateState(purchaseOrderDetail.getParentId());
            }

        }

        return model;
    }

    @Override
    public ResultModel cancelPurchaseOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchaseOrderDetail purchaseOrderDetail = this.selectById(id);
        if(purchaseOrderDetail!=null&&("0".equals(purchaseOrderDetail.getState())||"2".equals(purchaseOrderDetail.getState()))){
            purchaseOrderDetail.setState("-1");
            this.update(purchaseOrderDetail);
            purchaseOrderService.updateState(purchaseOrderDetail.getParentId());

            String planDetailId = purchaseOrderDetail.getPlanId();
            if(!StringUtils.isEmpty(planDetailId)){
                PurchasePlanDetail purchasePlanDetail = purchasePlanDetailService.selectById(planDetailId);
                //(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                purchasePlanDetail.setState("2");
                purchasePlanDetailService.update(purchasePlanDetail);
                purchasePlanService.updateState(purchasePlanDetail.getParentId());
            }
        }
        return model;
    }
}



