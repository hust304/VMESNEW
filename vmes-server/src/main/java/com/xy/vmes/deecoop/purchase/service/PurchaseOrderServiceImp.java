package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.purchase.dao.PurchaseOrderMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_purchase_order:采购订单 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-03-05
*/
@Service
@Transactional(readOnly = false)
public class PurchaseOrderServiceImp implements PurchaseOrderService {


    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private PurchaseSignService purchaseSignService;
    @Autowired
    private PurchaseSignDetailService purchaseSignDetailService;
    @Autowired
    private FileService fileService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void save(PurchaseOrder purchaseOrder) throws Exception{
        purchaseOrder.setId(Conv.createUuid());
        purchaseOrder.setCdate(new Date());
        purchaseOrder.setUdate(new Date());
        purchaseOrderMapper.insert(purchaseOrder);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void update(PurchaseOrder purchaseOrder) throws Exception{
        purchaseOrder.setUdate(new Date());
        purchaseOrderMapper.updateById(purchaseOrder);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateAll(PurchaseOrder purchaseOrder) throws Exception{
        purchaseOrder.setUdate(new Date());
        purchaseOrderMapper.updateAllColumnById(purchaseOrder);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    //@Cacheable(cacheNames = "purchaseOrder", key = "''+#id")
    public PurchaseOrder selectById(String id) throws Exception{
        return purchaseOrderMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteById(String id) throws Exception{
        purchaseOrderMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchaseOrderMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrder> dataListPage(PageData pd,Pagination pg) throws Exception{
        return purchaseOrderMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrder> dataList(PageData pd) throws Exception{
        return purchaseOrderMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return purchaseOrderMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return purchaseOrderMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchaseOrderMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<PurchaseOrder> selectByColumnMap(Map columnMap) throws Exception{
    List<PurchaseOrder> purchaseOrderList =  purchaseOrderMapper.selectByMap(columnMap);
        return purchaseOrderList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return purchaseOrderMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return purchaseOrderMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchaseOrderMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchaseOrderMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-03-05
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        purchaseOrderMapper.updateByDefined(pd);
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
    public List<PurchaseOrder> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseOrder>();
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
    public ResultModel listPagePurchaseOrders(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("PurchaseOrder");
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
    public void exportExcelPurchaseOrders(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("PurchaseOrder");
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
            fileName = "ExcelPurchaseOrder";
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
    public ResultModel importExcelPurchaseOrders(MultipartFile file) throws Exception{
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
    public ResultModel deletePurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        Map columnMap = new HashMap();
        columnMap.put("parent_id",id);
        purchaseOrderDetailService.deleteByColumnMap(columnMap);
        this.deleteById(id);
        return model;
    }

    @Override
    public ResultModel recoveryPurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"' ");
        pageData.put("updateStr"," state = '0' ");
        purchaseOrderDetailService.updateByDefined(pageData);

        PurchaseOrder purchaseOrder = this.selectById(id);
        purchaseOrder.setState("0");
        this.update(purchaseOrder);
        return model;
    }

    @Override
    public ResultModel cancelPurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"' ");
        pageData.put("updateStr"," state = '-1' ");
        purchaseOrderDetailService.updateByDefined(pageData);

        PurchaseOrder purchaseOrder = this.selectById(id);
        purchaseOrder.setState("-1");
        this.update(purchaseOrder);
        return model;
    }

    @Override
    public ResultModel submitPurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String ids = pageData.getString("ids");
        if (StringUtils.isEmpty(ids)) {
            model.putCode("1");
            model.putMsg("请至少选择一条记录！");
            return model;
        }

        pageData.put("queryStr"," id in ('"+ids+"') ");
        pageData.put("updateStr"," state = '1' ");
        this.updateByDefined(pageData);
        pageData.put("queryStr"," parent_id in ('"+ids+"') ");
        pageData.put("updateStr"," state = '1' ");
        purchaseOrderDetailService.updateByDefined(pageData);
        return model;
    }

    @Override
    public ResultModel auditPurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String ids = pageData.getString("ids");
        if (StringUtils.isEmpty(ids)) {
            model.putCode("1");
            model.putMsg("请至少选择一条记录！");
            return model;
        }

        pageData.put("queryStr"," id in ('"+ids+"') ");
        pageData.put("updateStr"," state = '2' ");
        this.updateByDefined(pageData);
        pageData.put("queryStr"," parent_id in ('"+ids+"') ");
        pageData.put("updateStr"," state = '2' ");
        purchaseOrderDetailService.updateByDefined(pageData);
        return model;
    }

    @Override
    public ResultModel rebackPurchaseOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        pageData.put("queryStr"," parent_id = '"+id+"' ");
        pageData.put("updateStr"," state = '0' ");
        purchaseOrderDetailService.updateByDefined(pageData);

        PurchaseOrder purchaseOrder = this.selectById(id);
        purchaseOrder.setState("0");
        this.update(purchaseOrder);
        return model;
    }


    @Override
    public ResultModel signPurchaseOrder(PageData pd) throws Exception {

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
            model.putMsg("采购签收单明细Json字符串-转换成List错误！");
            return model;
        }

        String companyID = pd.getString("currentCompanyId");


        WarehouseIn warehouseIn = (WarehouseIn) HttpUtils.pageData2Entity(pd, new WarehouseIn());
        warehouseIn.setId(Conv.createUuid());
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setCompanyId(companyID);
        //入库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_in", "I");
        warehouseIn.setCode(code);
        warehouseInService.save(warehouseIn);

        PurchaseSign purchaseSign =  new PurchaseSign();
        purchaseSign.setSdate(new Date());
        purchaseSign.setSignId(warehouseIn.getMakeId());
        purchaseSign.setCompanyId(companyID);
        purchaseSignService.save(purchaseSign);

        String purchaseOrderId = null;
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                WarehouseInDetail warehouseInDetail = (WarehouseInDetail)HttpUtils.pageData2Entity(detailMap, new WarehouseInDetail());
                warehouseInDetail.setId(Conv.createUuid());
                warehouseInDetail.setState("0");
                warehouseInDetail.setParentId(warehouseIn.getId());
                warehouseInDetail.setCuser(warehouseIn.getCuser());
                //获取批次号
                //PC+yyyyMMdd+00001 = 15位
                code = coderuleService.createCoderCdateByDate(warehouseIn.getCompanyId(),
                        "vmes_warehouse_in_detail",
                        "yyyyMMdd",
                        "PC");
                warehouseInDetail.setCode(code);
                //生成二维码
                String qrcode = fileService.createQRCode("warehouseIn", warehouseInDetail.getId());
                warehouseInDetail.setQrcode(qrcode);
                warehouseInDetailService.save(warehouseInDetail);

                String orderDetailId = detailMap.get("orderDetailId");
                PurchaseSignDetail purchaseSignDetail = new PurchaseSignDetail();
                purchaseSignDetail.setInDetailId(warehouseInDetail.getId());
                purchaseSignDetail.setOrderDetailId(orderDetailId);
                purchaseSignDetail.setArriveCount(warehouseInDetail.getCount());
                purchaseSignDetail.setProductId(warehouseInDetail.getProductId());
                purchaseSignDetail.setParentId(purchaseSign.getId());
                purchaseSignDetail.setCuser(purchaseSign.getCuser());
                purchaseSignDetail.setUuser(purchaseSign.getUuser());
                purchaseSignDetailService.save(purchaseSignDetail);
                PurchaseOrderDetail purchaseOrderDetail = purchaseOrderDetailService.selectById(orderDetailId);
                purchaseOrderId = purchaseOrderDetail.getParentId();
                BigDecimal arriveCount = purchaseOrderDetail.getArriveCount().add(warehouseInDetail.getCount());
                purchaseOrderDetail.setArriveCount(arriveCount);
                if(arriveCount.compareTo(BigDecimal.ZERO)>=0){
                    if(arriveCount.compareTo(purchaseOrderDetail.getCount())>=0){
                        purchaseOrderDetail.setState("4");
                    }else{
                        purchaseOrderDetail.setState("3");
                    }
                }else{
                    purchaseOrderDetail.setState("2");
                }
                purchaseOrderDetailService.update(purchaseOrderDetail);
            }
        }
        this.updateState(purchaseOrderId);
        return model;
    }

    @Override
    public ResultModel addPurchaseOrder(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        PurchaseOrder purchaseOrder = (PurchaseOrder)HttpUtils.pageData2Entity(pd, new PurchaseOrder());
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购订单明细Json字符串-转换成List错误！");
            return model;
        }
        String companyID = pd.getString("currentCompanyId");
        String code = coderuleService.createCoderCdateByDate(companyID,
                "vmes_purchase_order",
                "yyyyMMdd",
                "O");
        purchaseOrder.setCode(code);
        purchaseOrder.setCompanyId(companyID);
        //(0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消)
        purchaseOrder.setState("0");
        this.save(purchaseOrder);
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                PurchaseOrderDetail purchaseOrderDetail = (PurchaseOrderDetail) HttpUtils.pageData2Entity(detailMap, new PurchaseOrderDetail());
                purchaseOrderDetail.setParentId(purchaseOrder.getId());
                //(0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消)
                purchaseOrderDetail.setState("0");
                purchaseOrderDetail.setCuser(purchaseOrder.getCuser());
                purchaseOrderDetail.setUuser(purchaseOrder.getUuser());
                purchaseOrderDetailService.save(purchaseOrderDetail);
            }
        }
        return model;
    }

    @Override
    public ResultModel editPurchaseOrder(PageData pd)  throws Exception {
        ResultModel model = new ResultModel();
        PurchaseOrder purchaseOrder = (PurchaseOrder)HttpUtils.pageData2Entity(pd, new PurchaseOrder());
        String dtlJsonStr = pd.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购订单明细Json字符串-转换成List错误！");
            return model;
        }
        this.update(purchaseOrder);
        Map columnMap = new HashMap();
        columnMap.put("parent_id",purchaseOrder.getId());
        purchaseOrderDetailService.deleteByColumnMap(columnMap);
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                PurchaseOrderDetail purchaseOrderDetail = (PurchaseOrderDetail) HttpUtils.pageData2Entity(detailMap, new PurchaseOrderDetail());
                purchaseOrderDetail.setParentId(purchaseOrder.getId());
                //(0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消)
                purchaseOrderDetail.setState("0");
                purchaseOrderDetail.setCuser(purchaseOrder.getCuser());
                purchaseOrderDetail.setUuser(purchaseOrder.getUuser());
                purchaseOrderDetailService.save(purchaseOrderDetail);
            }
        }
        return model;
    }


    @Override
    public void updateState(String id) throws Exception {
        PurchaseOrder purchaseOrder = this.selectById(id);
        //0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消
        //0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消
        int yqx = 0;//已取消
        int dtj = 0;//待提交
        int dsh = 0;//待审核
        int cgz = 0;//采购中
        int bfqs = 0;//部分签收
        int ywc = 0;//已完成
        if(purchaseOrder!=null){
            Map columnMap = new HashMap();
            columnMap.put("parent_id",id);
            List<PurchaseOrderDetail> detailList = purchaseOrderDetailService.selectByColumnMap(columnMap);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    PurchaseOrderDetail purchaseOrderDetail = detailList.get(i);
                    if("-1".equals(purchaseOrderDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(purchaseOrderDetail.getState())){
                        dtj = dtj + 1;
                    }else if("1".equals(purchaseOrderDetail.getState())){
                        dsh = dsh + 1;
                    }else if("2".equals(purchaseOrderDetail.getState())){
                        cgz = cgz + 1;
                    }else if("3".equals(purchaseOrderDetail.getState())){
                        bfqs = bfqs + 1;
                    }else if("4".equals(purchaseOrderDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前单据没有明细则自动删除当前单据
                this.deleteById(id);
                return;
            }
            //该单据明细状态全是已取消状态，则说明当前单据状态为已取消
            if(yqx>0&&dtj==0&&dsh==0&&cgz==0&&ywc==0&&bfqs==0){
                purchaseOrder.setState("-1");//已取消
            }
            //该单据明细状态全是已完成和已取消状态，则说明当前单据状态为已完成
            else if(ywc>0&&dtj==0&&dsh==0&&cgz==0&&bfqs==0){
                purchaseOrder.setState("3");//已完成
            }
            //该单据明细状态全是待提交和已取消状态，则说明当前单据状态为待提交
            else if(dtj>0&&ywc==0&&dsh==0&&cgz==0&&bfqs==0){
                purchaseOrder.setState("0");//待提交
            }
            //该单据明细状态全是待审核和已取消状态，则说明当前单据状态为待审核
            else if(dsh>0&&dtj==0&&ywc==0&&cgz==0&&bfqs==0){
                purchaseOrder.setState("1");//待审核
            }
            //该单据明细状态存在采购中，则说明当前单据状态为采购中
            else if(cgz>0||bfqs>0){
                purchaseOrder.setState("2");//采购中
            }
            this.update(purchaseOrder);
        }

    }


}



