package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.*;
import com.xy.vmes.deecoop.purchase.dao.PurchaseRetreatMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.DateUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_purchase_retreat:退货单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-05-09
*/
@Service
@Transactional(readOnly = false)
public class PurchaseRetreatServiceImp implements PurchaseRetreatService {

    @Autowired
    private PurchaseRetreatMapper purchaseRetreatMapper;

    @Autowired
    private PurchaseRetreatDetailService purchaseRetreatDetailService;
    @Autowired
    private PurchaseSignDetailByRetreatService purchaseSignDetailByRetreatService;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

    @Autowired
    private PurchasePaymentService purchasePaymentService;
    @Autowired
    private PurchasePaymentDetailService purchasePaymentDetailService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-05-09
    */
    @Override
    public void save(PurchaseRetreat purchaseRetreat) throws Exception{
        purchaseRetreat.setId(Conv.createUuid());
        purchaseRetreat.setCdate(new Date());
        purchaseRetreat.setUdate(new Date());
        purchaseRetreatMapper.insert(purchaseRetreat);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public PurchaseRetreat selectById(String id) throws Exception{
        return purchaseRetreatMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public List<PurchaseRetreat> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchaseRetreat> warehouseCheckDetailList =  purchaseRetreatMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void update(PurchaseRetreat object) throws Exception{
        object.setUdate(new Date());
        purchaseRetreatMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void updateAll(PurchaseRetreat object) throws Exception{
        object.setUdate(new Date());
        purchaseRetreatMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchaseRetreatMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchaseRetreatMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchaseRetreatMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchaseRetreatMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    public List<PurchaseRetreat> dataList(PageData pd) throws Exception{
        return purchaseRetreatMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return purchaseRetreatMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchaseRetreatMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateStateByRetreat(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", "id in (" + ids + ")");

        purchaseRetreatMapper.updateStateByRetreat(pageData);
    }

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
    public List<PurchaseRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseRetreat>();
        }

        return this.dataList(pageData);
    }

    public PurchaseRetreat findPurchaseRetreat(PageData object) throws Exception {
        List<PurchaseRetreat> objectList = this.findPurchaseRetreatList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchaseRetreat findPurchaseRetreatById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchaseRetreat(findMap);
    }

    public List<PurchaseRetreat> findPurchaseRetreatList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    /**
//     * 修改订单明细和订单
//     * 修改采购订单明细-变更订单明细(订购数量,货品金额)
//     *
//     * @param valueMap 入口参数
//     * 参数说明:
//     * Map<String, Object>
//     *   retreatId:          退货单id
//     *   realityTotal:       退货金额
//     *   orderDtlRetreatMap: 采购订单明细退货信息
//     *   orderDtlList:       采购订单明细
//     */
//    public void updatePurchaseOrder(Map<String, Object> valueMap) throws Exception {
//        if (valueMap == null) {return;}
//
//        //修改采购订单明细-变更订单明细(订购数量,货品金额)
//        Map<String, Map<String, BigDecimal>> orderDtlRetreatMap = (Map<String, Map<String, BigDecimal>>)valueMap.get("orderDtlRetreatMap");
//        List<PurchaseOrderDetail> orderDtlList = (List<PurchaseOrderDetail>)valueMap.get("orderDtlList");
//        purchaseRetreatDetailService.updateOrderDetailByRetreat(orderDtlRetreatMap, orderDtlList);
//
//        BigDecimal realityTotal = (BigDecimal)valueMap.get("realityTotal");
//        //退货单id(retreatId) 获取退货单对象
//        String retreatId = (String)valueMap.get("retreatId");
//        PurchaseRetreat retreat = this.findPurchaseRetreatById(retreatId);
//        PurchaseOrder orderDB = purchaseOrderService.selectById(retreat.getOrderId());
//        if (orderDB == null) {return;}
//
//        List<PurchaseOrderDetail> orderDetailList = purchaseOrderDetailService.findPurchaseOrderDetailListByParentId(retreat.getOrderId());
//        if (orderDetailList != null && orderDetailList.size() > 0) {
//            PurchaseOrder orderEdit = new PurchaseOrder();
//            orderEdit.setId(retreat.getOrderId());
//
//            //采购订单明细总金额
//            BigDecimal totalSum = purchaseOrderDetailService.findTotalSumByDetailList(orderDetailList);
//            //total 合计金额 (采购订单明细总金额)
//            orderEdit.setTotal(totalSum);
//
//            //amount_old (变更前)采购金额(合计金额 - 折扣金额)
//            BigDecimal amount_old = BigDecimal.valueOf(0D);
//            if (orderDB.getAmount() != null) {
//                amount_old = orderDB.getAmount();
//            }
//
//            //变更后 采购金额((变更前)采购金额 - realityTotal_big实际退货金额)
//            //realityTotal_big 实际退货金额 审核界面获得
//            BigDecimal amount_new = BigDecimal.valueOf(amount_old.doubleValue() - realityTotal.doubleValue());
//            //四舍五入到2位小数
//            amount_new = amount_new.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            orderEdit.setAmount(amount_new);
//
//            //discount 折扣金额 (合计金额 - 采购金额)
//            BigDecimal discount = BigDecimal.valueOf(totalSum.doubleValue() - amount_new.doubleValue());
//            //四舍五入到2位小数
//            discount = discount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            orderEdit.setDiscount(discount);
//
//            String remarkTemp = "采购订单编号:{0} 于({1})发生退货";
//            String remark = MessageFormat.format(remarkTemp,
//                    orderDB.getCode(),
//                    DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT)
//            );
//            orderEdit.setRemark(remark);
//
//            purchaseOrderService.update(orderEdit);
//        }
//    }

//    /**
//     * 创建(负值)的付款单
//     *
//     * @param realityTotal 金额
//     * @param supplierId   供应商id
//     * @param companyId    企业id
//     * @param orderId      采购订单id
//     * @param cuser        用户id
//     */
//    public void createPurchasePaymentByMinus(BigDecimal realityTotal,
//                                             String supplierId,
//                                             String companyId,
//                                             String orderId,
//                                             String cuser) throws Exception {
//        //付款单类型(1:订单付款 2:订单退款)
//        PurchasePayment payment = purchasePaymentService.createPayment(supplierId,
//                cuser,
//                companyId,
//                "2");
//        //付款金额 paymentSum := realityTotal_big
//        payment.setPaymentSum(BigDecimal.valueOf(realityTotal.doubleValue() * -1));
//        purchasePaymentService.save(payment);
//
//        //2. 创建收款单明细
//        //获取 <订单id, 退货金额>
//        PurchasePaymentDetail paymentDtl = new PurchasePaymentDetail();
//        paymentDtl.setOrderId(orderId);
//        //状态(0:待付款 1:已付款 -1:已取消)
//        paymentDtl.setState("1");
//        //paymentSum 实付金额
//        paymentDtl.setPaymentSum(BigDecimal.valueOf(realityTotal.doubleValue() * -1));
//        //discountAmount 折扣金额
//        paymentDtl.setDiscountAmount(BigDecimal.valueOf(0D));
//
//        List<PurchasePaymentDetail> paymentDtlList_1 = new ArrayList<PurchasePaymentDetail>();
//        paymentDtlList_1.add(paymentDtl);
//        purchasePaymentDetailService.addPaymentDetail(payment, paymentDtlList_1);
//    }

//    /**
//     * 创建(正值)的付款单
//     *
//     * @param realityTotal 金额
//     * @param supplierId   供应商id
//     * @param companyId    企业id
//     * @param orderId      采购订单id
//     * @param cuser        用户id
//     */
//    public void createPurchasePaymentByPlus(BigDecimal realityTotal,
//                                            String supplierId,
//                                            String companyId,
//                                            String orderId,
//                                            String cuser) throws Exception {
//        //付款单类型(1:订单付款 2:订单退款)
//        PurchasePayment payment = purchasePaymentService.createPayment(supplierId,
//                cuser,
//                companyId,
//                "1");
//        //付款金额 paymentSum := amount 采购订单.采购金额(合计金额 - 折扣金额)
//        payment.setPaymentSum(realityTotal);
//        purchasePaymentService.save(payment);
//
//        //2. 创建收款单明细
//        //获取 <订单id, 退货金额>
//        PurchasePaymentDetail paymentDtl = new PurchasePaymentDetail();
//        paymentDtl.setOrderId(orderId);
//        //状态(0:待付款 1:已付款 -1:已取消)
//        paymentDtl.setState("1");
//        //paymentSum 实付金额
//        paymentDtl.setPaymentSum(realityTotal);
//        //discountAmount 折扣金额
//        paymentDtl.setDiscountAmount(BigDecimal.valueOf(0D));
//
//        List<PurchasePaymentDetail> paymentDtlList = new ArrayList<PurchasePaymentDetail>();
//        paymentDtlList.add(paymentDtl);
//        purchasePaymentDetailService.addPaymentDetail(payment, paymentDtlList);
//    }

    /**
     * 生成采购退货单-采购质量检验(退货)
     * @param cuser      用户id
     * @param companyId  企业id
     * @param objectMap  质量检验jsonMap
     */
    public String createRetreatByQuality(String cuser, String companyId, Map<String, String> objectMap) throws Exception {
        PurchaseRetreat addRetreat = new PurchaseRetreat();
        addRetreat.setCuser(cuser);
        addRetreat.setCompanyId(companyId);

        String supplierId = new String();
        if (objectMap.get("supplierId") != null) {
            supplierId = objectMap.get("supplierId").trim();
        }
        addRetreat.setSupplierId(supplierId);
        addRetreat.setType(Common.DICTIONARY_MAP.get("retreatQualityByPurchase"));
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        addRetreat.setState("3");
        //退货完成日期 retreatDate
        addRetreat.setRetreatDate(new Date());

        addRetreat.setTotalSum(BigDecimal.valueOf(0D));
        addRetreat.setRealityTotal(BigDecimal.valueOf(0D));
        addRetreat.setAuditId(Common.SYS_COMPANYAPPLICATION_ADMIN_USER_ID);

//        //退货单编号
//        //D+yyyyMMdd+00001 = 14位
//        String code = coderuleService.createCoderCdateByDate(companyId,
//                "vmes_purchase_retreat",
//                "yyyyMMdd",
//                "PR");

        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyId,
                "vmes_purchase_retreat",
                "PR",
                Common.CODE_RULE_LENGTH_3);
        addRetreat.setSysCode(code);
        this.save(addRetreat);

        PurchaseRetreatDetail addRetreatDtl = new PurchaseRetreatDetail();
        addRetreatDtl.setParentId(addRetreat.getId());
        addRetreatDtl.setState(addRetreat.getState());
        addRetreatDtl.setCuser(addRetreat.getCuser());

        String orderUnit = new String();
        if (objectMap.get("orderUnit") != null) {
            orderUnit = objectMap.get("orderUnit").trim();
        }
        addRetreatDtl.setUnit(orderUnit);

        String productId = new String();
        if (objectMap.get("productId") != null) {
            productId = objectMap.get("productId").trim();
        }
        addRetreatDtl.setProductId(productId);

        //count:退货数量: retreatCount (检验)退货数量
        BigDecimal retreatCount = BigDecimal.valueOf(0D);
        String retreatCountStr = objectMap.get("retreatCount");
        if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
            try {
                retreatCount = new BigDecimal(retreatCountStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        retreatCount = retreatCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        addRetreatDtl.setCount(retreatCount);
        addRetreatDtl.setAmount(BigDecimal.valueOf(0D));

        purchaseRetreatDetailService.save(addRetreatDtl);

        return addRetreatDtl.getId();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageRetreat(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchaseRetreat");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        //isNeedSign 是否需要显示(签收单号)
        String isNeedSign = pd.getString("isNeedSign");
        List<Map> varList = this.getDataListPage(pd, pg);
        if ("true".equals(isNeedSign) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                String retreatId = (String)mapObject.get("id");
                //(退货单id) Sql查询:PurchaseSignDetailByRetreatMapper.findPurchaseSignDetailByRetreat
                String signCode = purchaseSignDetailByRetreatService.findSignCodeByRetreatId(retreatId);
                mapObject.put("signCode", signCode);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addPurchaseRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

//        //采购订单id
//        String orderId = pageData.getString("orderId");
//        if (orderId == null || orderId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("采购订单id为空或空字符串！");
//            return model;
//        }

        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        //退货类型
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货类型id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无退货列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货明细Json字符串-转换成List错误！");
            return model;
        }

        List<PurchaseRetreatDetail> retreatDtlList = purchaseRetreatDetailService.mapList2DetailList(mapList, null);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //1. 退货单
        PurchaseRetreat retreat = new PurchaseRetreat();
        retreat.setType(type);
        retreat.setSupplierId(supplierId);
        //retreat.setOrderId(orderId);
        retreat.setRemark(remark);
        //获取退货总金额
        BigDecimal totalSum = purchaseRetreatDetailService.findTotalSumByDetailList(retreatDtlList);
        retreat.setTotalSum(totalSum);
        //realityTotal 实际退货金额
        retreat.setRealityTotal(totalSum);

        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            retreat.setState("1");
        }

        String companyID = pageData.getString("currentCompanyId");
        retreat.setCompanyId(companyID);

        String cuser = pageData.getString("cuser");
        retreat.setCuser(cuser);

        //退货单编号
        //D+yyyyMMdd+00001 = 14位
//        String code = coderuleService.createCoderCdateByDate(companyID,
//                "vmes_purchase_retreat",
//                "yyyyMMdd",
//                "PR");

        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_purchase_retreat",
                "PR",
                Common.CODE_RULE_LENGTH_3);
        retreat.setSysCode(code);
        this.save(retreat);

        //2. 退货单明细
        purchaseRetreatDetailService.addPurchaseRetreatDetail(retreat, retreatDtlList);

        return model;
    }

//    public ResultModel auditPassPurchaseRetreat(PageData pageData) throws Exception {
//        ResultModel model = new ResultModel();
//
//        String companyId = pageData.getString("currentCompanyId");
//        String supplierId = pageData.getString("supplierId");
//        String supplierName = pageData.getString("supplierName");
//        String cuser = pageData.getString("cuser");
//
//        //退货单id retreatId
//        String retreatId = pageData.getString("retreatId");
//        if (retreatId == null || retreatId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("退货单id为空或空字符串！");
//            return model;
//        }
//
//        //退货总额:实际退货金额
//        String realityTotal = pageData.getString("realityTotal");
//        if (realityTotal == null || realityTotal.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("退货总额为空或空字符串！");
//            return model;
//        }
//
//        String dtlJsonStr = pageData.getString("dtlJsonStr");
//        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("无列表数据！");
//            return model;
//        }
//
//        List<Map<String, String>> retreatDtlMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
//        if (retreatDtlMapList == null || retreatDtlMapList.size() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("Json字符串-转换成List错误！");
//            return model;
//        }
//
//        //验证退货单订单明细(单位) 单位换算公式 是否正确
//        String msgStr = this.checkPurchaseRetreatAudit(retreatDtlMapList);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr + "请于管理员联系，维护正确的单位换算公式！");
//            return model;
//        }
//
//        //根据(退货单id)-获取退货单明细List
//        List<PurchaseRetreatDetail> retreatDtlList = purchaseRetreatDetailService.findPurchaseRetreatDetailListByParentId(retreatId);
//        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}
//
//        //创建出库单
//        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(supplierId,
//                supplierName,
//                cuser,
//                companyId,
//                Common.DICTIONARY_MAP.get("purchaseOut"));
//        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
//        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
//        warehouseOutService.save(warehouseOut);
//
//        //创建出库单明细
//        //获取货品信息Map<货品id, 计价转换计量公式p2nFormula>
//        Map<String, String> productMap = this.findProductMap(retreatDtlMapList);
//        List<WarehouseOutDetail> outDtlList = purchaseRetreatDetailService.retreatDtlList2OutDtlList(retreatDtlList, productMap, null);
//        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut.getId(),warehouseOut.getCuser(), outDtlList);
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //<退货单明细id, 出库明细id>Map
//        Map<String, String> retreatDtl2OutDtlMap = new HashMap<String, String>();
//        for (WarehouseOutDetail outDtl : outDtlList) {
//            retreatDtl2OutDtlMap.put(outDtl.getBusinessId(), outDtl.getId());
//        }
//
//        //修改退货单明细(退货单明细(关联)入库单明细)
//        for (Map<String, String> mapObject : retreatDtlMapList) {
//            PurchaseRetreatDetail detailEdit = new PurchaseRetreatDetail();
//
//            //id: 退货单明细id,
//            String retreatDtl_id = mapObject.get("id");
//            detailEdit.setId(retreatDtl_id);
//
//            //count: 退货数量
//            BigDecimal count = BigDecimal.valueOf(0D);
//            String count_str = mapObject.get("count");
//            if (count_str != null && count_str.trim().length() > 0) {
//                try {
//                    count = new BigDecimal(count_str.trim());
//                    //四舍五入到2位小数
//                    count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            detailEdit.setCount(count);
//
//            //price: 货品单价
//            BigDecimal price = BigDecimal.valueOf(0D);
//            String price_str = mapObject.get("price");
//            if (price_str != null && price_str.trim().length() > 0) {
//                try {
//                    price = new BigDecimal(price_str.trim());
//                    //四舍五入到2位小数
//                    price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //amount: 退货金额
//            BigDecimal amount = BigDecimal.valueOf(count.doubleValue() * price.doubleValue());
//            //四舍五入到2位小数
//            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            detailEdit.setAmount(amount);
//
//            if (retreatDtl2OutDtlMap != null
//                    && retreatDtl2OutDtlMap.get(retreatDtl_id) != null
//                    && retreatDtl2OutDtlMap.get(retreatDtl_id).trim().length() > 0
//                    ) {
//                detailEdit.setOutDetailId(retreatDtl2OutDtlMap.get(retreatDtl_id).trim());
//            }
//
//            //退货单明细状态(1:待审核 2:待退货 3:已完成 -1:已取消)
//            detailEdit.setState("3");
//
//            purchaseRetreatDetailService.update(detailEdit);
//        }
//
//        PurchaseRetreat retreatEdit = new PurchaseRetreat();
//        retreatEdit.setId(retreatId);
//        //审核人ID
//        retreatEdit.setAuditId(cuser);
//        //状态(1:待审核 2:待退货 3:已完成 -1:已取消)
//        retreatEdit.setState("3");
//
//        //实际退货金额 审核界面获得
//        BigDecimal realityTotal_big = BigDecimal.valueOf(0D);
//        if (realityTotal != null && realityTotal.trim().length() > 0) {
//            try {
//                realityTotal_big = new BigDecimal(realityTotal);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//        if (realityTotal_big.doubleValue() != 0) {
//            //四舍五入到2位小数
//            realityTotal_big = realityTotal_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            retreatEdit.setRealityTotal(realityTotal_big);
//        }
//
//        this.update(retreatEdit);
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //获取 <采购订单明细id, <采购订单明细退货信息Map(count:退货数量,amount:退货金额)>
//        Map<String, Map<String, BigDecimal>> orderDtlRetreatMap = purchaseRetreatDetailService.findOrderDtlRetreatCountMap(retreatDtlList);
//        if (orderDtlRetreatMap == null || orderDtlRetreatMap.size() == 0) {
//            return model;
//        }
//
//        //获取采购订单明细id字符串-(','逗号分隔字符串)
//        String orderDtlIds = purchaseRetreatDetailService.findOrderDtlIdsByRetreatDtlList(retreatDtlList);
//        if (orderDtlIds == null || orderDtlIds.trim().length() == 0) {
//            return model;
//        }
//
//        PageData findMap = new PageData();
//        orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
//        findMap.put("ids", orderDtlIds);
//        List<PurchaseOrderDetail> orderDtlList = purchaseOrderDetailService.findPurchaseOrderDetailList(findMap);
//        if (orderDtlList == null || orderDtlList.size() == 0) {
//            return model;
//        }
//
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        PurchaseRetreat retreat = this.findPurchaseRetreatById(retreatId);
//        PurchaseOrder order_old = purchaseOrderService.selectById(retreat.getOrderId());
//
//        //根据退货类型
//        //retreatRefund: f69839bbf2394846a65894f0da120df9 退货退款
//        //retreatChange: c90c2081328c427e8d65014d98335601 退货换货
//        if (Common.DICTIONARY_MAP.get("retreatRefund").equals(retreat.getType())) {
//            //退货类型:= (f69839bbf2394846a65894f0da120df9)退货退款
//            //修改采购订单明细-变更订单明细(订购数量,货品金额)
//            this.updatePurchaseOrder(retreatId,
//                    realityTotal_big,
//                    orderDtlRetreatMap,
//                    orderDtlList);
//
//            //采购订单变更前状态
//            //采购订单状态(0:待提交 1:待审核 2:采购中 3:已完成 -1:已取消)
//            if ("3".equals(order_old.getState())) {
//                //创建(负值)的付款单
//                this.createPurchasePaymentByMinus(realityTotal_big,
//                        supplierId,
//                        companyId,
//                        retreat.getOrderId(),
//                        cuser);
//            }
//        }
//        //修改采购(订单,订单明细)状态
//        this.updatePurchaseOrderByState(retreat.getOrderId(), orderDtlList);
//
//        return model;
//    }

    public ResultModel auditDisagreePurchaseRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        //退货单id retreatId
        String retreatId = pageData.getString("retreatId");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        //当前登录用户姓名
        String userName = "";
        if (pageData.getString("userName") != null && pageData.getString("userName").trim().length() > 0) {
            userName = pageData.getString("userName").trim();
        }

        PurchaseRetreat retreatEdit = new PurchaseRetreat();
        retreatEdit.setId(retreatId);
//        String msgTemp = "审核退回:{0}{3}审核人:{1}{3}审核时间:{2}";
//        String remarkStr = MessageFormat.format(msgTemp,
//                remark,
//                userName,
//                DateUtils.toDateStr(new Date()),
//                Common.SYS_ENDLINE_DEFAULT);

        String msgTemp = "审核退回：{0}";
        String remarkStr = MessageFormat.format(msgTemp, remark);
        retreatEdit.setRemark(remarkStr);
        //退货单状态(1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatEdit.setState("-1");
        //审核人ID
        retreatEdit.setAuditId(cuser);
        this.update(retreatEdit);

        //退货单明细状态(1:待审核 2:待退货 3:已完成 -1:已取消)
        purchaseRetreatDetailService.updateStateByDetail("-1", retreatId);

        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////
    /**
     * 返回货品出库Map
     * 货品出库Map<业务id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:   出库明细id
     *     outCount:   出库数量
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByOut(List<Map<String, String>> jsonMapList) {
        Map<String, Map<String, Object>> productByOutMap = new HashMap<String, Map<String, Object>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return productByOutMap;}

        for (Map<String, String> mapObject : jsonMapList) {
            String productId = mapObject.get("productId");

            //退货数量 count := outCount 出库数量
            BigDecimal count = BigDecimal.valueOf(0D);
            String countStr = mapObject.get("count");
            if (countStr != null && countStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(countStr);
                    //四舍五入到2位小数
                    count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //p2nFormula (计价单位转换计量单位公式)
            String p2nFormula = "";
            if (mapObject.get("p2nFormula") != null && mapObject.get("p2nFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("p2nFormula").toString().trim();
            }

            //采购数量 - 转换计量单位 - 单位换算公式(p2nFormula)
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            try {
                BigDecimal bigDecimal = EvaluateUtil.countFormulaP2N(count, p2nFormula);
                if (bigDecimal != null) {prodCount = bigDecimal;}
            } catch (Exception e) {
                e.printStackTrace();
            }

            //退货单明细id
            String businessId = mapObject.get("id");

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("outDtlId", null);
            productMap.put("outCount", prodCount);

            productByOutMap.put(businessId, productMap);
        }

        return productByOutMap;
    }

    /**
     * 返回货品入库Map
     * 货品出库Map<业务id, 货品Map<String, Object>>
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

            //退货换货数量 count := inCount 入库数量
            BigDecimal count = BigDecimal.valueOf(0D);
            String countStr = mapObject.get("count");
            if (countStr != null && countStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(countStr);
                    //四舍五入到2位小数
                    count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //p2nFormula (计价单位转换计量单位公式)
            String p2nFormula = "";
            if (mapObject.get("p2nFormula") != null && mapObject.get("p2nFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("p2nFormula").toString().trim();
            }

            //采购数量 - 转换计量单位 - 单位换算公式(p2nFormula)
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            try {
                BigDecimal bigDecimal = EvaluateUtil.countFormulaP2N(count, p2nFormula);
                if (bigDecimal != null) {prodCount = bigDecimal;}
            } catch (Exception e) {
                e.printStackTrace();
            }

            //退货单明细id
            String businessId = mapObject.get("id");

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", prodCount);

            productByInMap.put(businessId, productMap);
        }

        return productByInMap;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    /**
//     * 修改订单明细和订单
//     * 修改采购订单明细-变更订单明细(订购数量,货品金额)
//     *
//     * @param retreatId
//     * @param realityTotal
//     * @param orderDtlRetreatMap
//     * @param orderDtlList
//     */
//    private void updatePurchaseOrder(String retreatId,
//                                     BigDecimal realityTotal,
//                                     Map<String, Map<String, BigDecimal>> orderDtlRetreatMap,
//                                     List<PurchaseOrderDetail> orderDtlList) throws Exception {
//        //2. 修改采购订单明细-变更订单明细(订购数量,货品金额)
//        purchaseRetreatDetailService.updateOrderDetailByRetreat(orderDtlRetreatMap, orderDtlList);
//
//        //退货单id(retreatId) 获取退货单对象
//        PurchaseRetreat retreat = this.findPurchaseRetreatById(retreatId);
//        PurchaseOrder orderDB = purchaseOrderService.selectById(retreat.getOrderId());
//        if (orderDB == null) {return;}
//
//        List<PurchaseOrderDetail> orderDetailList = purchaseOrderDetailService.findPurchaseOrderDetailListByParentId(retreat.getOrderId());
//        if (orderDetailList != null && orderDetailList.size() > 0) {
//            PurchaseOrder orderEdit = new PurchaseOrder();
//            orderEdit.setId(retreat.getOrderId());
//
//            //采购订单明细总金额
//            BigDecimal totalSum = purchaseOrderDetailService.findTotalSumByDetailList(orderDetailList);
//            //total 合计金额 (采购订单明细总金额)
//            orderEdit.setTotal(totalSum);
//
//            //amount_old (变更前)采购金额(合计金额 - 折扣金额)
//            BigDecimal amount_old = BigDecimal.valueOf(0D);
//            if (orderDB.getAmount() != null) {
//                amount_old = orderDB.getAmount();
//            }
//
//            //变更后 采购金额((变更前)采购金额 - realityTotal_big实际退货金额)
//            //realityTotal_big 实际退货金额 审核界面获得
//            BigDecimal amount_new = BigDecimal.valueOf(amount_old.doubleValue() - realityTotal.doubleValue());
//            //四舍五入到2位小数
//            amount_new = amount_new.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            orderEdit.setAmount(amount_new);
//
//            //discount 折扣金额 (合计金额 - 采购金额)
//            BigDecimal discount = BigDecimal.valueOf(totalSum.doubleValue() - amount_new.doubleValue());
//            //四舍五入到2位小数
//            discount = discount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            orderEdit.setDiscount(discount);
//
//            String remarkTemp = "采购订单编号:{0} 于({1})发生退货";
//            String remark = MessageFormat.format(remarkTemp,
//                    orderDB.getCode(),
//                    DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT)
//            );
//            orderEdit.setRemark(remark);
//
//            purchaseOrderService.update(orderEdit);
//        }
//    }

    /**
     * 修改采购(订单,订单明细)状态
     *
     * @param orderId
     * @param orderDtlList
     * @throws Exception
     */
    private void updatePurchaseOrderByState(String orderId,
                                            List<PurchaseOrderDetail> orderDtlList) throws Exception {
        //按采购订单id-获取<采购订单明细id, 采购订单明细信息Map> - (orderDtlCount:采购订单明细采购数量, checkCount: 验证数量(签收数量-退货数量))
        Map<String, Map<String, Object>> orderDtlMap = purchaseOrderDetailService.findMapOrderDetaiCountByOrderId(orderId);
        for (PurchaseOrderDetail orderDtl : orderDtlList) {
            PurchaseOrderDetail orderDetailEdit = new PurchaseOrderDetail();

            String orderDtl_id = orderDtl.getId();
            orderDetailEdit.setId(orderDtl_id);

            Map<String, Object> valueMap = orderDtlMap.get(orderDtl_id);
            //orderDtlCount:采购订单明细采购数量,
            BigDecimal orderDtlCount = (BigDecimal)valueMap.get("orderDtlCount");
            //checkCount: 验证数量(签收数量-退货数量)
            BigDecimal checkCount = (BigDecimal)valueMap.get("checkCount");
            //orderDtlSignCount: 采购订单明细签收数量
            BigDecimal orderDtlSignCount = (BigDecimal)valueMap.get("orderDtlSignCount");

            //明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
            if (orderDtlSignCount.doubleValue() == 0 || checkCount.doubleValue() == 0) {
                orderDetailEdit.setState("2");
            } else if (checkCount.doubleValue() >= orderDtlCount.doubleValue()) {
                orderDetailEdit.setState("4");
            } else if (checkCount.doubleValue() < orderDtlCount.doubleValue()) {
                orderDetailEdit.setState("3");
            }

            purchaseOrderDetailService.update(orderDetailEdit);
        }

        //

        //修改采购订单状态
        purchaseOrderService.updateState(orderId);
    }

    private String checkPurchaseRetreatAudit(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //(计量单位)(库存数量,库存可用数量) 单位换算公式(n2pFormula) (计价单位)(库存数量,库存可用数量)
        String msgTemp = "第 {0} 行：单位：{1} 单位换算公式：{2} 退货数量代入该公式计算错误！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> mapObject = mapList.get(i);

            //p2nFormula (计量单位转换计价单位公式)
            String p2nFormula = "";
            if (mapObject.get("p2nFormula") != null && mapObject.get("p2nFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("p2nFormula").toString().trim();
            }

            BigDecimal testValue = null;
            try {
                testValue = EvaluateUtil.countFormulaP2N(BigDecimal.valueOf(1D), p2nFormula);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //单位名称 unitName
            String unitName = mapObject.get("unitName");
            if (testValue == null) {
                String msgStr = MessageFormat.format(msgTemp,
                        Integer.valueOf(i+1).toString(),
                        unitName,
                        p2nFormula);
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }

    /**
     * 根据退货列表List(页面提交)-获取货品信息Map<货品id, 计价转换计量公式p2nFormula>
     * @param mapList
     * @return
     */
    private Map<String, String> findProductMap(List<Map<String, String>> mapList) {
        Map<String, String> productMap = new HashMap<String, String>();
        if (mapList == null || mapList.size() == 0) {return productMap;}

        for (Map<String, String> mapObj : mapList) {
            String productId = mapObj.get("productId");
            String p2nFormula = mapObj.get("p2nFormula");

            productMap.put(productId, p2nFormula);
        }

        return productMap;
    }

}



