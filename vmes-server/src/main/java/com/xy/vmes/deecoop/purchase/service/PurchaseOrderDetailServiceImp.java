package com.xy.vmes.deecoop.purchase.service;


import com.yvan.common.util.Common;
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

import java.math.BigDecimal;
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
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return purchaseOrderDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchaseOrderDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
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

        //是否需要分页 true:需要分页 false:不需要分页
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public PurchaseOrderDetail findPurchaseOrderDetail(PageData object) throws Exception {
        List<PurchaseOrderDetail> objectList = this.findPurchaseOrderDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchaseOrderDetail findPurchaseOrderDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchaseOrderDetail(findMap);
    }

    public List<PurchaseOrderDetail> findPurchaseOrderDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchaseOrderDetail> findPurchaseOrderDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findPurchaseOrderDetailList(findMap);
    }

    public BigDecimal findTotalSumByDetailList(List<PurchaseOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        double totalSum_double = 0D;
        for (PurchaseOrderDetail detail : objectList) {

            //amount 采购金额
            double amount_double = 0D;
            if (detail.getAmount() != null) {
                amount_double = detail.getAmount().doubleValue();
            }

            totalSum_double = totalSum_double + amount_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    public List<Map<String, Object>> findOrderDetaiByCollect(PageData pageData) throws Exception {
        return purchaseOrderDetailMapper.findOrderDetaiByCollect(pageData);
    }
    /**
     * 按采购订单id-获取采购订单明细信息
     * <采购订单明细id, 采购订单明细信息Map>
     *     发货信息Map
     *         orderDtlCount:     采购订单明细采购数量
     *         orderDtlAmount:    采购订单明细采购金额
     *         orderDtlSignCount: 采购订单明细签收数量
     *         checkCount: 验证数量(签收数量-退货数量)
     *
     * 根据采购订单id-获取(采购订单明细id,采购数量,签收数量)
     *
     * @param orderIds  采购订单id
     * @return
     */
    public Map<String, Map<String, Object>> findMapOrderDetaiCountByOrderId(String orderIds) throws Exception {
        Map<String, Map<String, Object>> mapObject = new HashMap<String, Map<String, Object>>();
        if (orderIds == null || orderIds.trim().length() == 0) {return mapObject;}

        PageData findMap = new PageData();
        orderIds = StringUtil.stringTrimSpace(orderIds);
        orderIds = "'" + orderIds.replace(",", "','") + "'";
        findMap.put("orderIds", orderIds);

        List<Map<String, Object>> mapList = this.findOrderDetaiByCollect(findMap);
        if (mapList == null || mapList.size() == 0) {return mapObject;}

        for (Map<String, Object> mapObj : mapList) {
            Map<String, Object> mapValue = new HashMap<String, Object>();

            //采购订单明细id orderDtlId
            String orderDtlId = (String)mapObj.get("orderDtlId");
            //采购订单id orderId
            String orderId = (String)mapObj.get("orderId");
            mapValue.put("orderId", orderId);

            //采购订单明细采购数量 orderDtlCount
            BigDecimal orderDtlCount = (BigDecimal)mapObj.get("orderDtlCount");
            mapValue.put("orderDtlCount", orderDtlCount);

            //采购订单明细采购金额 orderDtlAmount
            BigDecimal orderDtlAmount = (BigDecimal)mapObj.get("orderDtlAmount");
            mapValue.put("orderDtlAmount", orderDtlAmount);

            //checkCount 验证数量(签收数量-退货数量)
            BigDecimal checkCount = (BigDecimal)mapObj.get("checkCount");
            mapValue.put("checkCount", checkCount);

            //采购订单明细(签收数量) orderDtlSignCount
            BigDecimal orderDtlSignCount = BigDecimal.valueOf(0D);
            if (mapObj.get("orderDtlSignCount") != null) {
                try {
                    orderDtlSignCount = (BigDecimal)mapObj.get("orderDtlSignCount");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mapValue.put("orderDtlSignCount", orderDtlSignCount);

            mapObject.put(orderDtlId, mapValue);
        }

        return mapObject;
    }

    /**
     * 采购订单明细状态，在采购订单明细List<PurchaseOrderDetail>中是否全部相同
     *   true : 全部相同，在入库单明细List
     *   false: 一条或多条不同，在入库单明细List
     *
     * @param state       明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
     * @param objectList  订单明细List<SaleOrderDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, List<PurchaseOrderDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        for (PurchaseOrderDetail detail : objectList) {
            String dtl_state = detail.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if (!state.trim().equals(dtl_state.trim())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取Map结构体
     * 遍历JsonMapList-根据货品属性(productGenre)-返回Map结构体
     * 1.货品属性:productGenre:备件   添加到:warehouseList
     * 2.货品属性:productGenre:非备件 添加到:spareList
     *
     * Map<String, List<Map<String, String>>>
     *     warehouseList: 复杂版仓库,简版仓库
     *     spareList:     备件库
     *
     * @param jsonMapList 页面JsonMapList
     * @return
     */
    public Map<String, List<Map<String, String>>> findMapByProductGenre(List<Map<String, String>> jsonMapList) {
        Map<String, List<Map<String, String>>> mapValue = new HashMap<String, List<Map<String, String>>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return mapValue;}

        List<Map<String, String>> warehouseList = new ArrayList<>();
        List<Map<String, String>> spareList = new ArrayList<>();
        for (Map<String, String> mapObject : jsonMapList) {
            //productGenre 货品属性
            String productGenre = mapObject.get("productGenre");

            //备件:productGenreSpare:384cfd1329e648618b5a237ce1038bab
            if (Common.DICTIONARY_MAP.get("productGenreSpare").equals(productGenre)) {
                //货品属性:productGenre:备件 ==> spareList备件库
                spareList.add(mapObject);
            } else {
                //货品属性:productGenre:非备件 ==> warehouseList 复杂版仓库,简版仓库
                warehouseList.add(mapObject);
            }
        }

        mapValue.put("warehouseList", warehouseList);
        mapValue.put("spareList", spareList);
        return mapValue;
    }

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByIn(List<Map<String, String>> jsonMapList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return productByInMap;}

        for (Map<String, String> mapObject : jsonMapList) {
            String productId = mapObject.get("productId");

            //退回数量 retreatCount := inCount 入库数量
            BigDecimal retreatCount = BigDecimal.valueOf(0D);
            String retreatCountStr = mapObject.get("retreatCount");
            if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
                try {
                    retreatCount = new BigDecimal(retreatCountStr);
                    //四舍五入到2位小数
                    retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", retreatCount);

            productByInMap.put(productId, productMap);
        }

        return productByInMap;
    }

    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> jsonMapList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return productByInMap;}

        for (Map<String, String> mapObject : jsonMapList) {
            //id 采购订单明细id
            String taskDtlId = mapObject.get("orderDetailId");
            //productId 货品id
            String productId = mapObject.get("productId");

            //退回数量 retreatCount := inCount 入库数量
            BigDecimal retreatCount = BigDecimal.valueOf(0D);
            String retreatCountStr = mapObject.get("retreatCount");
            if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
                try {
                    retreatCount = new BigDecimal(retreatCountStr);
                    //四舍五入到2位小数
                    retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", retreatCount);

            productByInMap.put(taskDtlId, productMap);
        }

        return productByInMap;
    }


}



