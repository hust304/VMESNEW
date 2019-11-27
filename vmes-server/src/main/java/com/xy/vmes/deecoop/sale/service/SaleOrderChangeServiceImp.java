package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.sale.dao.SaleOrderChangeMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_saleOrde_change:订单变更记录表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-11-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderChangeServiceImp implements SaleOrderChangeService {
    @Autowired
    private SaleOrderChangeMapper saleOrdeChangeMapper;

    @Autowired
    private SaleOrderDetailChangeService ordeDtlChangeService;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private SaleDeliverDetailByCollectService saleDeliverDetailByCollectService;

    @Autowired
    private SaleReceiveService saleReceiveService;
    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;
    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void save(SaleOrderChange object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleOrdeChangeMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public SaleOrderChange selectById(String id) throws Exception{
        return saleOrdeChangeMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<SaleOrderChange> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleOrderChange> warehouseCheckDetailList = saleOrdeChangeMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void update(SaleOrderChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeChangeMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateAll(SaleOrderChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeChangeMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleOrdeChangeMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleOrdeChangeMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleOrdeChangeMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleOrdeChangeMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    public List<SaleOrderChange> dataList(PageData pd) throws Exception {
        return saleOrdeChangeMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrdeChangeMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrdeChangeMapper.getDataListPage(pd, pg);
        }

        return mapList;
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
    public List<SaleOrderChange> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderChange>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderChange findOrdeChange(PageData object) throws Exception {
        List<SaleOrderChange> objectList = this.findOrdeChangeList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleOrderChange findOrdeChangeById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findOrdeChange(findMap);
    }
    public List<SaleOrderChange> findOrdeChangeList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleOrderChange(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrderChange");
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

        List<Map> varList = this.getDataListPage(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addSaleOrderChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //变更订单id
        String orderId = pageData.getString("orderId");
        //(变更前)发票类型
        String receiptTypeBefore = pageData.getString("receiptTypeBefore");
        //(变更后)发票类型
        String receiptTypeAfter = pageData.getString("receiptTypeAfter");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 创建订单变更记录表
        SaleOrderChange addOrdeChange = new SaleOrderChange();
        addOrdeChange.setCompanyId(companyId);
        addOrdeChange.setCuser(cuser);
        addOrdeChange.setUuser(cuser);

        addOrdeChange.setOrderId(orderId);
        //状态(0:审核中 1:完成:审核通过 2:取消:审核不通过)
        addOrdeChange.setState("0");
        addOrdeChange.setReceiptTypeBefore(receiptTypeBefore);
        addOrdeChange.setReceiptTypeAfter(receiptTypeAfter);
        this.save(addOrdeChange);

        //2. 创建订单明细变更记录表
        //当前系统时间()
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                SaleOrderDetailChange addDtlChange = new SaleOrderDetailChange();
                addDtlChange.setParentId(addOrdeChange.getId());
                addDtlChange.setCuser(cuser);
                addDtlChange.setUuser(cuser);

                //订单明细id orderDtlId
                String orderDtlId = mapObject.get("orderDtlId");
                addDtlChange.setOrderDtlId(orderDtlId);

                //订单订购数量(变更前-订单单位) orderCountBefore
                BigDecimal orderCountBefore = BigDecimal.valueOf(0D);
                String orderCountBeforeStr = mapObject.get("orderCountBefore");
                if (orderCountBeforeStr != null && orderCountBeforeStr.trim().length() > 0) {
                    try {
                        orderCountBefore = new BigDecimal(orderCountBeforeStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                orderCountBefore = orderCountBefore.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setOrderCountBefore(orderCountBefore);


                //订单订购数量(变更后-订单单位) orderCountAfter
                BigDecimal orderCountAfter = BigDecimal.valueOf(0D);
                String orderCountAfterStr = mapObject.get("orderCountAfter");
                if (orderCountAfterStr != null && orderCountAfterStr.trim().length() > 0) {
                    try {
                        orderCountAfter = new BigDecimal(orderCountAfterStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                orderCountAfter = orderCountAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setOrderCountAfter(orderCountAfter);


                //货品单价(变更前) productPriceBefore
                BigDecimal productPriceBefore = BigDecimal.valueOf(0D);
                String productPriceBeforeStr = mapObject.get("productPriceBefore");
                if (productPriceBeforeStr != null && productPriceBeforeStr.trim().length() > 0) {
                    try {
                        productPriceBefore = new BigDecimal(productPriceBeforeStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                productPriceBefore = productPriceBefore.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setProductPriceBefore(productPriceBefore);

                //货品单价(变更后) productPriceAfter
                BigDecimal productPriceAfter = BigDecimal.valueOf(0D);
                String productPriceAfterStr = mapObject.get("productPriceAfter");
                if (productPriceAfterStr != null && productPriceAfterStr.trim().length() > 0) {
                    try {
                        productPriceAfter = new BigDecimal(productPriceAfterStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                productPriceAfter = productPriceAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setProductPriceAfter(productPriceAfter);

                //约定交期(变更前) deliverDateBefore
                Date deliverDateBefore = sysDate;
                String deliverDateBeforeStr = mapObject.get("deliverDateBefore");
                if (deliverDateBeforeStr != null && deliverDateBeforeStr.trim().length() > 0) {
                    Date dateTemp = DateFormat.dateString2Date(deliverDateBeforeStr, DateFormat.DEFAULT_DATE_FORMAT);
                    if (dateTemp != null) {
                        deliverDateBefore = dateTemp;
                    }
                }
                addDtlChange.setDeliverDateBefore(deliverDateBefore);

                //约定交期(变更后) deliverDateAfter
                Date deliverDateAfter = sysDate;
                String deliverDateAfterStr = mapObject.get("deliverDateAfter");
                if (deliverDateAfterStr != null && deliverDateAfterStr.trim().length() > 0) {
                    Date dateTemp = DateFormat.dateString2Date(deliverDateAfterStr, DateFormat.DEFAULT_DATE_FORMAT);
                    if (dateTemp != null) {
                        deliverDateAfter = dateTemp;
                    }
                }
                addDtlChange.setDeliverDateAfter(deliverDateAfter);

                //发货单数量(订单单位) deliverCount
                BigDecimal deliverCount = BigDecimal.valueOf(0D);
                String deliverCountStr = mapObject.get("deliverCount");
                if (deliverCountStr != null && deliverCountStr.trim().length() > 0) {
                    try {
                        deliverCount = new BigDecimal(deliverCountStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                deliverCount = deliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setDeliverCount(deliverCount);

                //完成发货数量(订单单位) endDeliverCount
                BigDecimal endDeliverCount = BigDecimal.valueOf(0D);
                String endDeliverCountStr = mapObject.get("endDeliverCount");
                if (endDeliverCountStr != null && endDeliverCountStr.trim().length() > 0) {
                    try {
                        endDeliverCount = new BigDecimal(endDeliverCountStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                endDeliverCount = endDeliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setEndDeliverCount(endDeliverCount);

                ordeDtlChangeService.save(addDtlChange);
            }
        }

        return model;
    }

    /**
     * 审核通过-订单变更
     * 接口参数:orderChangeId: 销售订单变更id
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel auditPassSaleOrderChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        String orderChangeId = pageData.getString("orderChangeId");
        if (orderChangeId == null || orderChangeId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("销售订单变更id为空或空字符串！");
            return model;
        }
        SaleOrderChange orderChangeDB = this.findOrdeChangeById(orderChangeId);


        //根据(订单变更id) 查询vmes_sale_order_detail_change
        PageData findMap = new PageData();
        findMap.put("parentId", orderChangeId);
        List<Map> mapList = ordeDtlChangeService.getDataListPage(findMap, null);

        //1.根据订单明细变更记录-拆分订单明细: 遍历查询结果集
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {

                //根据订单明细变更记录-拆分订单明细
                Map<String, SaleOrderDetail> valueMap = ordeDtlChangeService.findSaleOrderDetailByChangeMap(objectMap);

                //   返回值:Map<String, SaleOrderDetail>
                //     editOrderDetail: 修改订单明细对象
                //     addOrderDetail:  添加订单明细对象
                if (valueMap != null) {
                    SaleOrderDetail editOrderDetail = valueMap.get("editOrderDetail");
                    if (editOrderDetail != null) {
                        saleOrderDetailService.update(editOrderDetail);
                    }

                    SaleOrderDetail addOrderDetail = valueMap.get("addOrderDetail");
                    if (addOrderDetail != null) {
                        saleOrderDetailService.save(addOrderDetail);
                    }
                }
            }
        }

        //2. 修改订单表(发票类型,订单金额)
        List<SaleOrderDetail> new_orderDtl_list = saleOrderDetailService.findSaleOrderDetailListByParentId(orderChangeDB.getOrderId());
        //获取当前订单总金额:订单明细变更后
        BigDecimal new_orderTotalSum = saleOrderDetailService.findTotalSumByPrice(new_orderDtl_list);

        if (orderChangeDB != null
            && orderChangeDB.getOrderId() != null
            && orderChangeDB.getOrderId().trim().length() > 0
            && orderChangeDB.getReceiptTypeAfter() != null
        ) {
            SaleOrder editOrder = new SaleOrder();
            editOrder.setId(orderChangeDB.getOrderId().trim());
            editOrder.setReceiptType(orderChangeDB.getReceiptTypeAfter());
            if (new_orderTotalSum.doubleValue() != 0D) {
                editOrder.setOrderSum(new_orderTotalSum);
                editOrder.setTotalSum(new_orderTotalSum);
            }
            saleOrderService.update(editOrder);
        }

        //3. 修改订单变更记录表状态
        SaleOrderChange editOrderChange = new SaleOrderChange();
        editOrderChange.setId(orderChangeId);
        //状态(0:审核中 1:完成:审核通过 2:取消:审核不通过)
        editOrderChange.setState("1");
        this.update(editOrderChange);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改当前变更订单明细(锁库数量清零)
        for (SaleOrderDetail orderDtl : new_orderDtl_list) {
            //lockCount 锁定货品数量(计量单位)
            BigDecimal lockCount = BigDecimal.valueOf(0D);
            if (orderDtl.getLockCount() != null) {
                lockCount = orderDtl.getLockCount();
            }

            if (lockCount.doubleValue() != 0D) {
                SaleOrderDetail editDetail = new SaleOrderDetail();
                editDetail.setId(orderDtl.getId());

                //lockCount 锁定货品数量(计量单位)
                editDetail.setLockCount(BigDecimal.valueOf(0D));
                //isLockWarehouse 是否锁定仓库(0:未锁定 1:已锁定)
                editDetail.setIsLockWarehouse("0");

                //versionLockCount 修改锁定库存版本号
                Integer versionLockCount = Integer.valueOf(0);
                if (editDetail.getVersionLockCount() != null) {
                    versionLockCount = Integer.valueOf(editDetail.getVersionLockCount().intValue() + 1);
                }
                editDetail.setVersionLockCount(versionLockCount);

                saleOrderDetailService.update(editDetail);
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //订单明细变更后-重新获取订单明细状态-反写订单状态(订购数量与发货数量比较)

        //根据(订单id) 关联查询(vmes_sale_deliver_detail,vmes_sale_order_detail,vmes_warehouse_out_detail)
        //查询语句: SaleDeliverDetailByCollectMapper.findDeliverDetailByOrderDetail
        Map<String, Map<String, Object>> mapObject = saleDeliverDetailByCollectService.findMapOrderDetaiCountByOrderId(orderChangeDB.getOrderId());
        if (mapObject != null) {
            for (Iterator iterator = mapObject.keySet().iterator(); iterator.hasNext();) {
                String orderDtlId_mapKey = iterator.next().toString().trim();
                Map<String, Object> mapValue = mapObject.get(orderDtlId_mapKey);

                if (mapValue != null) {
                    SaleOrderDetail editOrderDtl = new SaleOrderDetail();
                    editOrderDtl.setId(orderDtlId_mapKey);

                    //orderDtlCount 订单明细数量
                    BigDecimal orderDtlCount = (BigDecimal)mapValue.get("orderDtlCount");

                    //checkCount:=(发货数量-退货数量)
                    BigDecimal checkCount = (BigDecimal)mapValue.get("checkCount");

                    if (checkCount.doubleValue() >= orderDtlCount.doubleValue()) {
                        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成(发货) -1:已取消)
                        editOrderDtl.setState("5");
                    }
                    saleOrderDetailService.update(editOrderDtl);
                }
            }
        }

        //反写订单状态
        SaleOrder editOrderState = new SaleOrder();
        editOrderState.setId(orderChangeDB.getOrderId());
        saleOrderDetailService.updateParentStateByDetailList(editOrderState, null);

        //订单变更后-订单状态
        String OrderState = editOrderState.getState();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改客户账号金额
        //生成负数的付款单
        //1. (负数)付款金额:=0                            变更后订单金额 >= 订单已付金额
        //2. (负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额

        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderChangeDB.getOrderId(), "1");
        Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderChangeDB.getOrderId());

        //订单id-订单已完成付款金额
        BigDecimal receiveSum = BigDecimal.valueOf(0D);
        if (receiveMap != null && receiveMap.get("receiveSum") != null) {
            receiveSum = receiveMap.get("receiveSum");
        }

        //(负数)付款金额
        BigDecimal ReceiveSum = BigDecimal.valueOf(0D);
        //(负数)付款金额:= (变更后订单金额-订单已付金额)   变更后订单金额 <  订单已付金额
        if (new_orderTotalSum.doubleValue() < receiveSum.doubleValue()) {
            ReceiveSum = BigDecimal.valueOf(new_orderTotalSum.doubleValue() - receiveSum.doubleValue());
        }

        if (ReceiveSum.doubleValue() != 0) {
            //四舍五入到2位小数
            ReceiveSum = ReceiveSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            if (ReceiveSum.doubleValue() < 0) {
                //ReceiveSum < 0 退钱给客户
                saleReceiveRecordService.editCustomerBalanceByOrder(
                        customerId,
                        null,
                        //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
                        "4",
                        BigDecimal.valueOf(ReceiveSum.doubleValue() * -1),
                        cuser,
                        "");
            }

            //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
            SaleReceive receive = saleReceiveService.createReceive(customerId,
                    cuser,
                    companyId,
                    "3");
            receive.setReceiveSum(BigDecimal.valueOf(ReceiveSum.doubleValue()));
            saleReceiveService.save(receive);

            //2. 创建收款单明细
            //获取 <订单id, 退货金额>
            SaleReceiveDetail receiveDtl = new SaleReceiveDetail();
            receiveDtl.setOrderId(orderChangeDB.getOrderId());
            //收款单状态(0:待收款 1:已收款 -1:已取消)
            receiveDtl.setState("1");
            //receiveAmount 实收金额
            receiveDtl.setReceiveAmount(BigDecimal.valueOf(ReceiveSum.doubleValue()));
            //discountAmount 折扣金额
            receiveDtl.setDiscountAmount(BigDecimal.valueOf(0D));

            List<SaleReceiveDetail> receiveDtlList = new ArrayList<SaleReceiveDetail>();
            receiveDtlList.add(receiveDtl);
            saleReceiveDetailService.addReceiveDetail(receive, receiveDtlList);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
        orderReceiveMap.clear();
        orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderChangeDB.getOrderId(), "1");
        Map<String, BigDecimal> receiveMap_1 = orderReceiveMap.get(orderChangeDB.getOrderId());

        //订单id-订单已完成付款金额
        receiveSum = BigDecimal.valueOf(0D);
        if (receiveMap_1 != null && receiveMap_1.get("receiveSum") != null) {
            receiveSum = receiveMap_1.get("receiveSum");
        }

        SaleOrder editOrderByPayState = new SaleOrder();
        editOrderByPayState.setId(orderChangeDB.getOrderId());
        if (receiveSum.doubleValue() >= new_orderTotalSum.doubleValue()) {
            //付款完成日期 payDate
            editOrderByPayState.setPayDate(new Date());
            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
            editOrderByPayState.setPayState("2");
            saleOrderService.update(editOrderByPayState);
        } else if (receiveSum.doubleValue() < new_orderTotalSum.doubleValue()) {
            //付款完成日期 payDate
            editOrderByPayState.setPayDate(null);
            //付款状态(0:未付款 1:付款中 2:已付款) pay_state
            editOrderByPayState.setPayState("1");
            saleOrderService.update(editOrderByPayState);
        }

        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        if ("3".equals(OrderState)) {
            SaleOrder editOrder = new SaleOrder();
            editOrder.setId(orderChangeDB.getOrderId());
            if (receiveSum.doubleValue() >= new_orderTotalSum.doubleValue()) {
                //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
                editOrder.setState("4");
                saleOrderService.update(editOrder);
            }
        }

        return model;
    }

    public ResultModel auditDisagreeSaleOrderChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String orderChangeId = pageData.getString("id");
        if (orderChangeId == null || orderChangeId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("销售订单变更id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退回原因为必填项不可为空！");
            return model;
        }

        SaleOrderChange editOrderChange = new SaleOrderChange();
        editOrderChange.setId(orderChangeId);
        //状态(0:审核中 1:完成:审核通过 2:取消:审核不通过)
        editOrderChange.setState("2");
        editOrderChange.setRemark(remark);
        this.update(editOrderChange);

        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //订单变更审核 私有方法

    /**
     * 返回是否发生变更(变更前,变更后)日期
     * true : 发生变更
     * false: 未发生变更
     *
     * @param beforeDate 变更前日期
     * @param afterDate  变更后日期
     * @return
     */
    private boolean isChangeByDate(Date beforeDate, Date afterDate) {
        long beforeDateLong = -1;
        if (beforeDate != null) {
            String dateStr = DateFormat.date2String(beforeDate, DateFormat.DEFAULT_DATE_FORMAT);
            if (dateStr != null && dateStr.trim().length() > 0) {
                Date DateTemp = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT);
                if (DateTemp != null) {
                    beforeDateLong = DateTemp.getTime();
                }
            }
        }

        long afterDateLong = -1;
        if (afterDate != null) {
            String dateStr = DateFormat.date2String(afterDate, DateFormat.DEFAULT_DATE_FORMAT);
            if (dateStr != null && dateStr.trim().length() > 0) {
                Date DateTemp = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT);
                if (DateTemp != null) {
                    afterDateLong = DateTemp.getTime();
                }
            }
        }

        if (beforeDateLong != afterDateLong) {return true;}

        return false;
    }

    /**
     * 返回是否发生变更(变更前,变更后)数值
     * true : 发生变更
     * false: 未发生变更
     *
     * @param beforeBigDecimal 变更前数值
     * @param afterBigDecimal  变更后数值
     * @return
     */
    private boolean isChangeByBigDecimal(BigDecimal beforeBigDecimal, BigDecimal afterBigDecimal) {
        double beforeDouble = -1D;
        if (beforeBigDecimal != null) {
            //四舍五入到2位小数
            beforeBigDecimal = beforeBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            beforeDouble = beforeBigDecimal.doubleValue();
        }

        double afterDouble = -1D;
        if (afterBigDecimal != null) {
            //四舍五入到2位小数
            afterBigDecimal = afterBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            afterDouble = afterBigDecimal.doubleValue();
        }

        if (beforeDouble != afterDouble) {return true;}

        return false;
    }
}



