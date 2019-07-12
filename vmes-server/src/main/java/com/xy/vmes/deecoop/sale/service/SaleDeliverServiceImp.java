package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_deliver:发货表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Service
@Transactional(readOnly = false)
public class SaleDeliverServiceImp implements SaleDeliverService {

    @Autowired
    private SaleDeliverMapper saleDeliverMapper;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleDeliverDetailByCollectService saleDeliverDetailByCollectService;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    SaleReceiveDetailService saleReceiveDetailService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-15
    */
    @Override
    public void save(SaleDeliver saleDeliver) throws Exception{
        saleDeliver.setId(Conv.createUuid());
        saleDeliver.setCdate(new Date());
        saleDeliver.setUdate(new Date());
        saleDeliverMapper.insert(saleDeliver);
    }

    public void save(String id, SaleDeliver saleDeliver) throws Exception{
        saleDeliver.setId(id);
        saleDeliver.setCdate(new Date());
        saleDeliver.setUdate(new Date());
        saleDeliverMapper.insert(saleDeliver);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public SaleDeliver selectById(String id) throws Exception{
        return saleDeliverMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliver> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleDeliver> warehouseCheckDetailList =  saleDeliverMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void update(SaleDeliver object) throws Exception{
        object.setUdate(new Date());
        saleDeliverMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateAll(SaleDeliver object) throws Exception{
        object.setUdate(new Date());
        saleDeliverMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleDeliverMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleDeliverMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleDeliverMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleDeliverMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByDeliver(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        saleDeliverMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliver> dataList(PageData pd) throws Exception{
        return saleDeliverMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleDeliverMapper.getDataListPage(pd,pg);
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
    public List<SaleDeliver> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleDeliver>();
        }

        return this.dataList(pageData);
    }

    public SaleDeliver findSaleDeliver(PageData object) throws Exception {
        List<SaleDeliver> objectList = this.findSaleDeliverList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleDeliver findSaleDeliverById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleDeliver(findMap);
    }

    public List<SaleDeliver> findSaleDeliverList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ////////////////////////////////////////////////////////////////

    /**
     * 验证客户是否相同，订单明细生成发货单
     * model_code = 'saleOrderDetail'
     *
     * @param mapList
     * @return
     */
    public String checkCustomerByOrderDetailList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String msgTemp = "第 {0} 行: 勾选的数据(客户名称)不相同" + Common.SYS_ENDLINE_DEFAULT;

        Map<String, String> customerMap = new HashMap<String, String>();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> detailMap = mapList.get(i);
            String customerId = detailMap.get("customerId");

            if (customerMap.size() == 0) {
                customerMap.put(customerId, customerId);
            } else if (customerMap.size() > 0 && customerMap.get(customerId) == null) {
                String msg_Str = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msg_Str);
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            msgBuf.append("请通过查询条件过滤出相同客户名称的订单！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }

    /**
     * 验证计价类型(1:先计价 2:后计价)是否相同，订单明细生成发货单
     *
     * @param mapList
     * @return
     */
    public String checkPricetypeByOrderDetailList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String msgTemp = "第 {0} 行: 勾选的数据(计价类型1:先计价 2:后计价)不相同" + Common.SYS_ENDLINE_DEFAULT;

        Map<String, String> priceTypeMap = new HashMap<String, String>();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> detailMap = mapList.get(i);
            String priceType = detailMap.get("priceType");

            if (priceTypeMap.size() == 0) {
                priceTypeMap.put(priceType, priceType);
            } else if (priceTypeMap.size() > 0 && priceTypeMap.get(priceType) == null) {
                String msg_Str = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msg_Str);
            }
        }

        return msgBuf.toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public ResultModel listPageSaleDeliver(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleDeliver");
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
        Map result = new HashMap();
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //结算状态 1:已结算 0:未结算
        String sumStateQueryStr = new String();
        String sumState = pd.getString("sumState");
        if ("1".equals(sumState)) {
            sumStateQueryStr = sumStateQueryStr + "detail.sum > 0 ";

        } else if ("0".equals(sumState)) {
            sumStateQueryStr = sumStateQueryStr + "detail.sum = 0";
        }
        pd.put("sumStateQueryStr", sumStateQueryStr);

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public ResultModel addSaleDeliver(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String priceType = pageData.getString("priceType");
        if (priceType == null || priceType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("计价类型(priceType)为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //验证勾选的订单明细(客户)是否相同
        String msgStr = this.checkCustomerByOrderDetailList(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        msgStr = this.checkPricetypeByOrderDetailList(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String customerId = mapList.get(0).get("customerId");
        String customerName = mapList.get(0).get("customerName");

        //获取订单明细
        //1. 本次发货数量(计价单位)
        //2. 公式:P(计价单位) 转换 N(计量单位)
        //3. count:订购数量(计价数量) -- 本次发货数量(计价单位)
        //   productCount:货品数量(计量数量) --本次发货数量(计量单位)
        List<SaleOrderDetailEntity> orderDtlList = saleDeliverDetailService.mapList2OrderDetailList(mapList, null);

        //1. 创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(customerId,
                customerName,
                cuser,
                companyId,
                Common.DICTIONARY_MAP.get("saleOut"));

//        //获取实体仓库id
//        PageData findMap = new PageData();
//        findMap.put("companyId", companyId);
//        findMap.put("layer", "2");
//        findMap.put("isEntity", "true");
//        findMap.put("isdisable", "1");
//        findMap.put("mapSize", Integer.valueOf(findMap.size()));
//        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);

        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
        warehouseOutService.save(warehouseOut);

        List<WarehouseOutDetail> outDtlList = saleOrderDetailService.orderDtlList2OutDtlList(orderDtlList, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut.getId(),warehouseOut.getCuser(), outDtlList);
        //订单明细id --> 出库明细id -- <订单明细id, 出库明细id>Map
        Map<String, String> orderDtl2OutDtlMap = new HashMap<String, String>();
        for (WarehouseOutDetail outDtl : outDtlList) {
            orderDtl2OutDtlMap.put(outDtl.getBusinessId(), outDtl.getId());
        }

        //2. 创建发货单
        SaleDeliver saleDeliver = new SaleDeliver();
        String deliverId = Conv.createUuid();
        saleDeliver.setId(deliverId);
        //发货单编号
        String code = coderuleService.createCoder(companyId, "vmes_sale_deliver", "F");
        saleDeliver.setPriceType(priceType);
        saleDeliver.setDeliverCode(code);
        saleDeliver.setCustomerId(customerId);
        saleDeliver.setCompanyId(companyId);
        //state:状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("0");
        saleDeliver.setMakeId(cuser);
        saleDeliver.setCuser(cuser);

        List<SaleDeliverDetail> deliverDtlList = saleOrderDetailService.orderDtlList2DeliverDtllList(orderDtlList, null);
        saleDeliverDetailService.addDeliverDetail(saleDeliver, deliverDtlList, orderDtl2OutDtlMap);

        BigDecimal totalSum = saleDeliverDetailService.findTotalSumByDetailList(deliverDtlList);
        saleDeliver.setTotalSum(totalSum);
        this.save(deliverId, saleDeliver);

        //3. 反写订单明细
        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            String orderDtl_id = orderDtl.getId();
            SaleOrderDetail orderDetail = new SaleOrderDetail();
            orderDetail.setId(orderDtl_id);
            //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
            orderDetail.setState("4");
            saleOrderDetailService.update(orderDetail);
        }

        return model;
    }

    /**
     * 修改发货单信息-发货单状态为已发货
     * 1. 发货单id查询该发货单对应的出库单-出库状态是否全部已完成
     * 2. 修改发货单信息(经办人,物流公司,车牌号)等字段
     * 3. 修改(发货单,发货单明细)状态:已发货
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel updateSaleDeliverByDeliverType(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String priceType = pageData.getString("priceType");
        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        //1. 验证当前出库单id-对应的出库明细状态(是否全部完成出库)
        try {
            Boolean isAllOut = saleDeliverDetailService.checkIsAllOutByDeliverId(deliverId);
            if (isAllOut != null && !isAllOut.booleanValue()) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前发货明细对应的出库明细状态(待派单,执行中,已取消)，必须全部出库完成！");
                return model;
            }
        } catch (ApplicationException e) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(e.getMessage());
            return model;
        }

        SaleDeliver saleDeliver = (SaleDeliver)HttpUtils.pageData2Entity(pageData, new SaleDeliver());
        saleDeliver.setId(deliverId);
        //状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("1");
        this.update(saleDeliver);

        //发货单id获取发货明细List
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
            //发货状态(0:待发货 1:已发货 -1:已取消)
            deliverDetail.setState("1");
            deliverDetail.setDeliverDate(new Date());
            saleDeliverDetailService.update(deliverDetail);
        }

        String orderDtlIds = saleDeliverDetailService.findOrderDtlIdsByDeliverDtlList(deliverDtlList);
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            orderDtlIds = StringUtil.stringTrimSpace(orderDtlIds);
            orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
        }

        //根据发货单id-获取(订单明细id,订购数量,发货数量,发货金额)
        //发货明细状态(0:待发货 1:已发货 -1:已取消)
        Map<String, Map<String, BigDecimal>> orderDtlMap = saleDeliverDetailByCollectService.findMapOrderDetaiCountByDeliverId(
                deliverId,
                "1",
                "3",
                orderDtlIds);


        //遍历发货单明细List-修改发货明细对应的订单明细状态
        Map<String, String> orderIdMap = new HashMap<String, String>();
        StringBuffer orderIdsBuf = new StringBuffer();

        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
            String orderId = deliverDetail.getOrderId();
            orderIdMap.put(orderId, orderId);
            orderIdsBuf.append(orderId).append(",");

            SaleOrderDetail orderDetail = new SaleOrderDetail();
            String orderDetaiId = deliverDetail.getOrderDetaiId();
            orderDetail.setId(orderDetaiId);

            //修改订单明细状态
            Map<String, BigDecimal> valueMap = orderDtlMap.get(orderDetaiId);
            if (valueMap != null) {
                //订单明细订购数量 orderCount
                BigDecimal orderCount = valueMap.get("orderCount");

                //checkCount 验证数量(发货数量-退货数量)
                BigDecimal checkCount = valueMap.get("checkCount");
                //checkSum:=(发货金额-退货金额)
                BigDecimal checkSum = valueMap.get("checkSum");

                //price_type:计价类型(1:先计价 2:后计价)
                //2:后计价 反写订单明细,反写订单总金额
                if (priceType != null && "2".equals(priceType.trim())) {
                    orderDetail.setPriceUnit(deliverDetail.getPriceUnit());

                    //订单明细货品金额:=(发货金额-退货金额)
                    BigDecimal productSum = BigDecimal.valueOf(0D);
                    if (checkSum != null) {
                        productSum = checkSum;
                    }
                    orderDetail.setProductSum(productSum);

                    //货品单价 productPrice
                    BigDecimal productPrice = BigDecimal.valueOf(0D);
                    if (checkCount != null && checkCount.doubleValue() != 0 && checkSum != null) {
                        productPrice = BigDecimal.valueOf(checkSum.doubleValue() / checkCount.doubleValue());
                        //四舍五入到2位小数
                        productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        orderDetail.setProductPrice(productPrice);
                    }

//                    if (deliverDetail.getProductPrice() != null) {
//                        productPrice = deliverDetail.getProductPrice();
//                    }
//                    orderDetail.setProductPrice(productPrice);
                }

                if (checkCount.doubleValue() >= orderCount.doubleValue()) {
                    //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
                    orderDetail.setState("5");
                }
            }

            saleOrderDetailService.update(orderDetail);
        }

        //查询付款单明细 vmes_sale_receive_detail
        //收款明细状态(0:待收款 1:已收款 -1:已取消)
        //获取订单付款信息<订单id, 订单付款信息Map> - (receiveSum: 付款金额)
        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderIdsBuf.toString(), "1");

        //反写订单状态
        if (orderIdMap.size() > 0) {
            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext();) {
                String orderId = (String)iterator.next();

                //修改订单明细状态
                List<SaleOrderDetail> detailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
                saleOrderDetailService.updateDetailStateByOrderId(orderId, detailList);

                //orderTotalSum 订单金额
                SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
                BigDecimal orderTotalSum = orderDB.getOrderSum();

                //设定发货完成时间
                orderDB.setCurrentDeliverDate(new Date());
                saleOrderService.update(orderDB);

                //price_type:计价类型(1:先计价 2:后计价)
                if ("2".equals(orderDB.getPriceType())) {
                    //totalSum 合计金额
                    BigDecimal totalSum = saleOrderDetailService.findTotalSumByPrice(detailList);

                    SaleOrder editOrder = new SaleOrder();
                    editOrder.setId(orderId);
                    //四舍五入到2位小数
                    totalSum = totalSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    editOrder.setTotalSum(totalSum);
                    editOrder.setOrderSum(totalSum);
                    //discountSum 折扣金额
                    editOrder.setDiscountSum(BigDecimal.valueOf(0D));
                    orderTotalSum = totalSum;
                    saleOrderService.update(editOrder);
                }

                SaleOrder parent = new SaleOrder();
                parent.setId(orderId);
                saleOrderDetailService.updateParentStateByDetailList(parent, detailList);

                //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
                if (saleOrderDetailService.isAllExistStateByDetailList("5", detailList)) {
                    if (orderReceiveMap.get(orderId) != null) {
                        Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);

                        //订单id-订单已完成付款金额
                        BigDecimal receiveSum = BigDecimal.valueOf(0D);
                        if (receiveMap.get("receiveSum") != null) {
                            receiveSum = receiveMap.get("receiveSum");
                        }
                        SaleOrder editOrder = new SaleOrder();
                        editOrder.setId(orderId);
                        if (receiveSum.doubleValue() >= orderTotalSum.doubleValue()) {
                            //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
                            editOrder.setState("4");
                            saleOrderService.update(editOrder);
                        }
                    }
                }
            }
        }

        return model;
    }


    @Override
    public ResultModel deleteSaleDeliver(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String deliverId = pd.getString("id");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }
        //状态(0:待发货 1:已发货 -1:已取消)
        SaleDeliver saleDeliver = this.findSaleDeliverById(deliverId);
        if (!"-1".equals(saleDeliver.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("只有已取消状态的发货单才能删除！");
            return model;
        }

        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
            saleDeliverDetailService.deleteById(deliverDetail.getId());
        }
        this.deleteById(deliverId);
        return model;
    }

    public ResultModel cancelSaleDeliver(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String deliverId = pageData.getString("id");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        //状态(0:待发货 1:已发货 -1:已取消)
        SaleDeliver saleDeliver = this.findSaleDeliverById(deliverId);
        if ("1".equals(saleDeliver.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前发货单状态(已发货)，不可取消发货单！");
            return model;
        }

        //验证发货单是否允许取消
        //出库单明细状态(状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        String msgStr = saleDeliverDetailService.checkOutDetailStateByCancelDeliver(pageData);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        //1. 取消出库单
        String outParentIds = saleDeliverDetailService.findOutIdsByDeliverId(deliverId);
        if (outParentIds != null && outParentIds.trim().length() > 0) {
            //取消出库单状态(0:未完成 1:已完成 -1:已取消)

            warehouseOutService.updateStateByOut("-1", outParentIds);

            //取消出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            warehouseOutDetailService.updateStateByDetail("-1", outParentIds);
        }

        //2. 清除订单明细与发货明细的关联关系
        //saleDeliverDetailService.updateOrderDetailByCancelDeliver(deliverId);

        //取消发货单
        //状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("-1");
        this.update(saleDeliver);

        //发货单id获取发货明细List
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
            //发货状态(0:待发货 1:已发货 -1:已取消)
            deliverDetail.setState("-1");
            deliverDetail.setDeliverDate(null);
            saleDeliverDetailService.update(deliverDetail);
            String orderDetaiId = deliverDetail.getOrderDetaiId();
            SaleOrderDetail saleOrderDetail = saleOrderDetailService.selectById(orderDetaiId);
            saleOrderDetail.setState("3");
            saleOrderDetailService.update(saleOrderDetail);
        }

        return model;
    }

    public ResultModel checkIsAllOutByDeliverId(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        try {
            Boolean isAllOut = saleDeliverDetailService.checkIsAllOutByDeliverId(deliverId);
            if (isAllOut != null && isAllOut.booleanValue()) {
                model.set("isAllOut", "true");
            } else {
                model.set("isAllOut", "false");
            }
        } catch (ApplicationException e) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(e.getMessage());
        }

        return model;
    }

    public ResultModel checkIsNullDeliverSumByDeliverId(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        boolean isNull = false;
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
        if (deliverDtlList != null && deliverDtlList.size() > 0) {
            for (SaleDeliverDetail deliverDetail : deliverDtlList) {
                if (deliverDetail.getSum() == null || deliverDetail.getSum().doubleValue() == 0D) {
                    isNull = true;
                    break;
                }
            }
        }

        if (isNull) {
            model.set("isNullDeliverSum", "true");
        } else {
            model.set("isNullDeliverSum", "false");
        }

        return model;
    }

    public ResultModel checkIsAllNotNullDeliverSumByDeliverId(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        boolean isAllNotNull = true;
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
        if (deliverDtlList != null && deliverDtlList.size() > 0) {
            for (SaleDeliverDetail deliverDetail : deliverDtlList) {
                if (deliverDetail.getSum() == null || deliverDetail.getSum().doubleValue() == 0D) {
                    isAllNotNull = false;
                    break;
                }
            }
        }

        if (isAllNotNull) {
            model.set("isAllNotNullDeliverSum", "true");
        } else {
            model.set("isAllNotNullDeliverSum", "false");
        }

        return model;
    }


    public void exportExcelSaleDelivers(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("saleDeliver");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
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
            fileName = "ExcelSaleDeliver";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    public ResultModel importExcelSaleDelivers(MultipartFile file) throws Exception {
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
}



