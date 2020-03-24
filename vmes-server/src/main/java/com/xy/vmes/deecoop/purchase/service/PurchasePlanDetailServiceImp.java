package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchasePlanDetailMapper;
import com.xy.vmes.entity.PurchasePlanDetail;
import com.xy.vmes.entity.PurchasePlanDetailChild;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
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
* 说明：vmes_purchase_plan_detail:采购计划 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-02-28
*/
@Service
@Transactional(readOnly = false)
public class PurchasePlanDetailServiceImp implements PurchasePlanDetailService {
    @Autowired
    private PurchasePlanDetailMapper purchasePlanDetailMapper;
    @Autowired
    private PurchasePlanService purchasePlanService;
    @Autowired
    private PurchasePlanDetailChildService planDetailChildService;

    @Autowired
    private SaleOrderDetailService orderDetailService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void save(PurchasePlanDetail purchasePlanDetail) throws Exception{
        purchasePlanDetail.setId(Conv.createUuid());
        purchasePlanDetail.setCdate(new Date());
        purchasePlanDetail.setUdate(new Date());
        purchasePlanDetailMapper.insert(purchasePlanDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void update(PurchasePlanDetail purchasePlanDetail) throws Exception{
        purchasePlanDetail.setUdate(new Date());
        purchasePlanDetailMapper.updateById(purchasePlanDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void updateAll(PurchasePlanDetail purchasePlanDetail) throws Exception{
        purchasePlanDetail.setUdate(new Date());
        purchasePlanDetailMapper.updateAllColumnById(purchasePlanDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    //@Cacheable(cacheNames = "purchasePlanDetail", key = "''+#id")
    public PurchasePlanDetail selectById(String id) throws Exception{
        return purchasePlanDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePlanDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePlanDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlanDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePlanDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlanDetail> dataList(PageData pd) throws Exception{
        return purchasePlanDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return purchasePlanDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return purchasePlanDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePlanDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<PurchasePlanDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<PurchasePlanDetail> purchasePlanDetailList =  purchasePlanDetailMapper.selectByMap(columnMap);
        return purchasePlanDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return purchasePlanDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return purchasePlanDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePlanDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-02-28
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePlanDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-02-28
     */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        purchasePlanDetailMapper.updateByDefined(pd);
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
    public List<PurchasePlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePlanDetail>();
        }

        return this.dataList(pageData);
    }

    public PurchasePlanDetail findPurchasePlanDetail(PageData object) throws Exception {
        List<PurchasePlanDetail> objectList = this.findPurchasePlanDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchasePlanDetail findPurchasePlanDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchasePlanDetail(findMap);
    }

    public List<PurchasePlanDetail> findPurchasePlanDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchasePlanDetail> findPurchasePlanDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findPurchasePlanDetailList(findMap);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchasePlanDetails(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("PurchasePlanDetail");
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
        List<Map> varList = this.getDataListPage(pd, pg);

        //isNeedChild 是否需要生产明细子表 true:需要
        String isNeedChild = pd.getString("isNeedChild");
        if ("true".equals(isNeedChild) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //planDtlId 生产计划明细id
                String planDtlId = (String)mapObject.get("id");

                List<PurchasePlanDetailChild> planDtlChildList = planDetailChildService.findPlanDetailChildListByPlanDtlId(planDtlId);
                String jsonStr = this.findJsonStringByList(planDtlChildList);
                mapObject.put("jsonStr", jsonStr);

                //Map<"orderCodes", 订单编号>
                //Map<"expectDate", 订单约定交期>
                Map<String, String> valueMap = this.findOrderCodeByList(planDtlChildList);
                mapObject.put("orderCode", valueMap.get("orderCodes"));
                mapObject.put("expectDate", valueMap.get("expectDate"));
            }
        }

        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for (Map<String, Object> mapObject : varList) {
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);
            }
        }

        //pageType 页面类型 edit:修改页面
        String pageType = pd.getString("pageType");
        if ("edit".equals(pageType) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //operType 操作类型(add:添加, edit:修改)
                mapObject.put("operType", "edit");
            }
        }

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
    public void exportExcelPurchasePlanDetails(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("PurchasePlanDetail");
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
            fileName = "ExcelPurchasePlanDetail";
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
    public ResultModel importExcelPurchasePlanDetails(MultipartFile file) throws Exception{
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
    public ResultModel deletePurchasePlanDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchasePlanDetail purchasePlanDetail = this.selectById(id);
        this.deleteById(id);
        purchasePlanService.updateState(purchasePlanDetail.getParentId());
        return model;
    }

    @Override
    public ResultModel recoveryPurchasePlanDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchasePlanDetail purchasePlanDetail = this.selectById(id);
        if(purchasePlanDetail!=null&&"-1".equals(purchasePlanDetail.getState())){
            purchasePlanDetail.setState("0");
            this.update(purchasePlanDetail);
            purchasePlanService.updateState(purchasePlanDetail.getParentId());
        }
        return model;
    }

    @Override
    public ResultModel cancelPurchasePlanDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        if (StringUtils.isEmpty(id)) {
            model.putCode("1");
            model.putMsg("主键ID为空，请求数据异常，请重新操作！");
            return model;
        }
        PurchasePlanDetail purchasePlanDetail = this.selectById(id);
        if(purchasePlanDetail!=null&&("0".equals(purchasePlanDetail.getState())||"2".equals(purchasePlanDetail.getState()))){
            purchasePlanDetail.setState("-1");
            this.update(purchasePlanDetail);
            purchasePlanService.updateState(purchasePlanDetail.getParentId());
        }
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String findJsonStringByList(List<PurchasePlanDetailChild> ObjectList) {
        if (ObjectList == null || ObjectList.size() == 0) {return new String();}

        //orderDetailMap<销售订单明细id, 销售订单明细id>
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (PurchasePlanDetailChild object : ObjectList) {
            //saleOrderDtlId:销售订单明细ID
            String saleOrderDtlId = object.getSaleOrderDtlId();
            if (saleOrderDtlId != null && saleOrderDtlId.trim().length() > 0) {
                orderDetailMap.put(saleOrderDtlId, saleOrderDtlId);
            }
        }

        List<Map<String, String>> childMapList = new ArrayList<>();
        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    Map<String, String> childMap = new LinkedHashMap<>();
                    childMap.put("orderDtlId", mapKey_orderDtlId);
                    childMapList.add(childMap);
                }
            }
        }

        if (childMapList.size() > 0) {
            return YvanUtil.toJson(childMapList);
        }

        return new String();
    }

    //Map<"orderCodes", 订单编号>
    //Map<"expectDate", 订单约定交期>
    private Map<String, String> findOrderCodeByList(List<PurchasePlanDetailChild> ObjectList) throws Exception {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("orderCodes", new String());
        valueMap.put("expectDate", new String());

        if (ObjectList == null || ObjectList.size() == 0) {return valueMap;}

        //orderDetailMap<销售订单明细id, 销售订单明细id>
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (PurchasePlanDetailChild object : ObjectList) {
            //saleOrderDtlId:销售订单明细ID
            String saleOrderDtlId = object.getSaleOrderDtlId();
            if (saleOrderDtlId != null && saleOrderDtlId.trim().length() > 0) {
                orderDetailMap.put(saleOrderDtlId, saleOrderDtlId);
            }
        }

        StringBuffer orderDtlIdBuf = new StringBuffer();
        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    orderDtlIdBuf.append(mapKey_orderDtlId).append(",");
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (orderDtlIdBuf != null && orderDtlIdBuf.toString().trim().length() > 0) {
            String orderDtlIds = StringUtil.stringTrimSpace(orderDtlIdBuf.toString().trim());
            orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("ids", orderDtlIds);
            List<Map> tableMapList = orderDetailService.getDataListPage(findMap, null);

            //获取订单编号
            StringBuffer orderCodeBuf = new StringBuffer();
            if (tableMapList != null && tableMapList.size() > 0) {
                for (Map<String, Object> mapData : tableMapList) {
                    String sysCode = (String)mapData.get("sysCode");
                    if (sysCode != null && sysCode.trim().length() > 0) {
                        orderCodeBuf.append(sysCode).append(",");
                    }
                }
            }

            //orderCodes 订单编号
            String orderCodes = new String();
            if (orderCodeBuf != null && orderCodeBuf.toString().trim().length() > 0) {
                orderCodes = StringUtil.stringTrimSpace(orderCodeBuf.toString().trim());
            }
            valueMap.put("orderCodes", orderCodes);

//            //获取最小订单约定交期 expectDate(yyyy-MM-dd)
//            //long minExpectDateLong = -1;
//            if (tableMapList != null && tableMapList.size() > 0) {
//                for (int i = 0; i < tableMapList.size(); i++) {
//                    Map<String, Object> mapData = tableMapList.get(i);
//
//                    String expectDateStr = (String)mapData.get("expectDate");
//                    Date expectDate = DateFormat.dateString2Date(expectDateStr, DateFormat.DEFAULT_DATE_FORMAT);
//                    long expectL = expectDate.getTime();
//
//                    if (i == 0) {
//                        minExpectDateLong = expectL;
//                    } else if (i > 0) {
//                        if (expectL < minExpectDateLong) {minExpectDateLong = expectL;}
//                    }
//                }
//            }

//            String expectDateStr = new String();
//            if (minExpectDateLong != -1) {
//                Date expectDate = new Date(minExpectDateLong);
//                expectDateStr = DateFormat.date2String(expectDate, DateFormat.DEFAULT_DATE_FORMAT);
//            }
//            valueMap.put("expectDate", expectDateStr);
        }

        return valueMap;
    }
}



