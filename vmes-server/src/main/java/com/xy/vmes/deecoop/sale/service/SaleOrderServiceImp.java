package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.*;
import com.xy.vmes.common.util.rabbitmq.sender.ProductStockcountLockSender;
import com.xy.vmes.deecoop.sale.dao.SaleOrderByExportMapper;
import com.xy.vmes.deecoop.sale.dao.SaleOrderMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

/**
 * 说明：vmes_sale_order:订单表 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2018-12-05
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderServiceImp implements SaleOrderService {

    @Autowired
    private SaleOrderMapper saleOrderMapper;
    @Autowired
    private SaleOrderByExportMapper saleOrderByExportMapper;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;
    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;
    @Autowired
    private SaleLockDateService saleLockDateService;
    @Autowired
    private SaleOrderChangeService orderChangeService;

    @Autowired
    private ProductService productService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    SaleReceiveService saleReceiveService;
    @Autowired
    SaleReceiveDetailService saleReceiveDetailService;
    @Autowired
    CustomerService customerService;
    //消息队列
    @Autowired
    private ProductStockcountLockSender sender;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void save(SaleOrder saleOrder) throws Exception{
        saleOrder.setCdate(new Date());
        saleOrder.setUdate(new Date());
        saleOrderMapper.insert(saleOrder);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public SaleOrder selectById(String id) throws Exception{
        return saleOrderMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrder> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleOrder> warehouseCheckDetailList =  saleOrderMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void update(SaleOrder object) throws Exception{
        object.setUdate(new Date());
        saleOrderMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateAll(SaleOrder object) throws Exception{
        object.setUdate(new Date());
        saleOrderMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleOrderMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleOrderMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleOrderMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleOrderMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByOrder(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        saleOrderMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    public void updateStateByOrder(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", "id in (" + ids + ")");

        saleOrderMapper.updateStateByOrder(pageData);
    }
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrder> dataList(PageData pd) throws Exception{
        return saleOrderMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrderMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrderMapper.getDataListPage(pd, pg);
        }

        return mapList;
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
    public List<SaleOrder> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrder>();
        }

        return this.dataList(pageData);
    }

    public SaleOrder findSaleOrder(PageData object) throws Exception{
        List<SaleOrder> objectList = this.findSaleOrderList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleOrder findSaleOrderById(String id) throws Exception{
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrder(findMap);
    }

    public List<SaleOrder> findSaleOrderList(PageData object) throws Exception{
        return this.findDataList(object, null);
    }

    public List<SaleOrder> mapList2OrderList(List<Map<String, String>> mapList, List<SaleOrder> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrder>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrder order = (SaleOrder) HttpUtils.pageData2Entity(mapObject, new SaleOrder());
            objectList.add(order);
        }

        return objectList;
    }

    public List<Map> findListOrderByExport(PageData pd) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        return saleOrderByExportMapper.findListOrderByExport(pd);

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel listPageSaleOrder(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrder");
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

        //设置查询排序
        pd.put("orderStr", "saleOrder.cdate desc");
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
        //遍历查询结果集:获取(changeState:订单变更状态 changeStateName:订单变更状态名称)
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> objectMap : varList) {
                String orderId = (String)objectMap.get("id");

                PageData findMap = new PageData();
                findMap.put("orderId", orderId);
                findMap.put("orderStr", "ordeChange.cdate desc");
                List<Map> orderChangeList = orderChangeService.getDataListPage(findMap, null);
                if (orderChangeList != null && orderChangeList.size() > 0) {
                    Map changeMap = orderChangeList.get(0);

                    String state = new String();
                    if (changeMap.get("state") != null) {
                        state = changeMap.get("state").toString().trim();
                    }
                    objectMap.put("changeState", state);

                    String changeStateName = new String();
                    if (changeMap.get("changeStateName") != null) {
                        changeStateName = changeMap.get("changeStateName").toString().trim();
                    }
                    objectMap.put("changeStateName", changeStateName);
                }

                //isExistChange 是否存在变更 0:不存在变更 1:存在变更
                objectMap.put("isExistChange", "0");
                if (orderChangeList != null && orderChangeList.size() > 0) {
                    objectMap.put("isExistChange", "1");
                }
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel addSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());

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

        //获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);

        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(detailList);
        order.setTotalSum(totalSum);

        //discount_sum:折扣金额
        BigDecimal discountSum = BigDecimal.valueOf(0D);
        if (order.getDiscountSum() != null) {
            discountSum = order.getDiscountSum();
        }
        order.setDiscountSum(discountSum);

        //order_sum:订单金额(合计金额 - 折扣金额)
        //四舍五入到2位小数
        BigDecimal orderSum = BigDecimal.valueOf(totalSum.doubleValue() - order.getDiscountSum().doubleValue()).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        order.setOrderSum(orderSum);

        String parentId = Conv.createUuid();
        order.setId(parentId);

        String companyID = pageData.getString("currentCompanyId");
        order.setCompanyId(companyID);
//        //订单编号
//        //D+yyyyMMdd+00001 = 14位
//        String code = coderuleService.createCoderCdateByDate(companyID,
//                "vmes_sale_order",
//                "yyyyMMdd",
//                "D");

        //订单编号
        //D+yyMMdd+001 = 10位
        String code = this.createOrderCoder(companyID,
                "vmes_sale_order",
                "D");
        order.setSysCode(code);

        //priceType计价类型(1:先计价 2:后计价)
        //2:后计价 无订单总金额 无订单金额
        if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {
            order.setTotalSum(BigDecimal.valueOf(0D));
            order.setOrderSum(BigDecimal.valueOf(0D));
        }

        //状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            order.setState("1");
        }

        this.save(order);

        //2.添加订单明细
        //saleOrderDetailService.addSaleOrderDetail(order, detailList);
        if (detailList != null && detailList.size() > 0) {
            for (SaleOrderDetail detail : detailList) {
                //订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
                detail.setState("0");
                if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                    detail.setState("1");
                }

                detail.setParentId(order.getId());
                detail.setCuser(order.getCuser());
                detail.setSequence((new Date()).getTime());
                //计价类型(1:先计价 2:后计价)
                if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {

                    //计价单位id
                    detail.setPriceUnit(null);
                    //货品数量(计价数量)
                    detail.setPriceCount(BigDecimal.valueOf(0D));
                    //货品单价
                    detail.setProductPrice(BigDecimal.valueOf(0D));
                    //货品金额(订购数量 * 货品单价)
                    detail.setProductSum(BigDecimal.valueOf(0D));
                }

                saleOrderDetailService.save(detail);
            }
        }

        //3.修改客户余额(vmes_customer.balance)
        //advance_sum:预付款(定金)
//        if (order.getAdvanceSum() != null) {
//            String remarkTemp = "订单编号:{0} 预付款:{1}";
//            String remark = MessageFormat.format(remarkTemp,
//                    order.getSysCode(),
//                    order.getAdvanceSum().setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP).toString());
//
//            saleReceiveRecordService.editCustomerBalanceByOrder(
//                    order.getCustomerId(),
//                    null,
//                    //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 5:预付款退款 -1:费用分摊)
//                    "2",
//                    order.getAdvanceSum(),
//                    order.getCuser(),
//                    remark);
//        }



        return model;
    }

    @Override
    public ResultModel updateSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());

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

        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = this.findSaleOrderById(order.getId());
        if (!"0".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可修改！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");

        //获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);

        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(detailList);
        order.setTotalSum(totalSum);

        //discount_sum:折扣金额
        BigDecimal discountSum = BigDecimal.valueOf(0D);
        if (order.getDiscountSum() != null) {
            discountSum = order.getDiscountSum();
        }
        order.setDiscountSum(discountSum);

        //order_sum:订单金额(合计金额 - 折扣金额)
        //四舍五入到2位小数
        BigDecimal orderSum = BigDecimal.valueOf(totalSum.doubleValue() - order.getDiscountSum().doubleValue()).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        order.setOrderSum(orderSum);

        if (detailList != null && detailList.size() > 0) {
            for (SaleOrderDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
                    //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
                    detail.setState("0");
                    if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                        detail.setState("1");
                    }

                    detail.setParentId(order.getId());
                    detail.setCuser(order.getCuser());
                    saleOrderDetailService.save(detail);
                } else {
                    if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
                        detail.setState("1");
                    }
                    saleOrderDetailService.update(detail);
                }
            }
        }

        //2.修改订单表头
        //2:后计价 无订单总金额 无订单金额
        if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {
            order.setTotalSum(BigDecimal.valueOf(0D));
            order.setOrderSum(BigDecimal.valueOf(0D));
        }

        //状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            order.setState("1");
        }

        this.update(order);

//        //3.修改客户余额(vmes_customer.balance)
//        //advance_sum:预付款(定金)
//        BigDecimal new_advanceSum = BigDecimal.valueOf(0D);
//        if (order.getAdvanceSum() != null) {
//            new_advanceSum = order.getAdvanceSum();
//        }
//
//        BigDecimal old_advanceSum = BigDecimal.valueOf(0D);
//        if (order_old.getAdvanceSum() != null) {
//            old_advanceSum = order_old.getAdvanceSum();
//        }
//
//        if ((new_advanceSum.doubleValue() - old_advanceSum.doubleValue()) != 0D) {
//            BigDecimal editBalance = BigDecimal.valueOf(new_advanceSum.doubleValue() - old_advanceSum.doubleValue());
//            //四舍五入到2位小数
//            editBalance = editBalance.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//
//            String remarkTemp = "订单编号:{0} (预付款)变更前:{1} (预付款)变更后{2}";
//            String remark = MessageFormat.format(remarkTemp,
//                    order_old.getSysCode(),
//                    old_advanceSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP).toString(),
//                    new_advanceSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP).toString()
//            );
//            saleReceiveRecordService.editCustomerBalanceByOrder(
//                    order.getCustomerId(),
//                    null,
//                    //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 5:预付款退款 -1:费用分摊)
//                    "2",
//                    editBalance,
//                    order.getCuser(),
//                    remark);
//        }

        return model;
    }

    @Override
    public ResultModel deleteSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = this.findSaleOrderById(parentId);
        if ((!"0".equals(order_old.getState()))&&(!"-1".equals(order_old.getState()))) {
            String msgTemp = "订单状态({0})不可删除！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 删除订单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        saleOrderDetailService.deleteByColumnMap(columnMap);

        //3. 删除订单
        this.deleteById(parentId);
        return model;
    }

    @Override
    public ResultModel recoverySaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = this.findSaleOrderById(parentId);
        if (!"-1".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可恢复！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        mapDetail.put("state", "0");
        saleOrderDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleOrder order = new SaleOrder();
        order.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("0");
        this.update(order);

        return model;
    }

    @Override
    public ResultModel cancelSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = this.findSaleOrderById(parentId);
        if (!"0".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可取消！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        mapDetail.put("state", "-1");
        saleOrderDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleOrder order = new SaleOrder();
        order.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("-1");
        this.update(order);

        return model;
    }

    @Override
    public ResultModel submitSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String orderJsonStr = pageData.getString("orderJsonStr");
        if (orderJsonStr == null || orderJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(orderJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单Json字符串-转换成List错误！");
            return model;
        }

        //获取订单
        String ids = "";
        List<SaleOrder> orderList = this.mapList2OrderList(mapList, null);
        for (SaleOrder order : orderList) {
            if (order.getId() != null && order.getId().trim().length() > 0) {
                ids = ids + order.getId().trim() + ",";
            }
        }
        ids = StringUtil.stringTrimSpace(ids);

        //1. 订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        this.updateStateByOrder("1", ids);

        //2. 订单明细状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        saleOrderDetailService.updateStateByDetail("1", ids);

        return model;
    }

    public ResultModel rebackSaleOrder(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String orderId = pageData.getString("id");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }
        PageData pd = new PageData();
        pd.put("queryStr","deliverDetail.state in ('0','1')");
        pd.put("orderId",orderId);

        Map<String,Object> checkResult = saleOrderMapper.checkIsDeliver(pd);
        if(checkResult!=null){
            Long num = (Long)checkResult.get("num");
            if(num>0){
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前订单已有发货记录，不能退回！");
                return model;
            }
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", orderId);
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        mapDetail.put("state", "0");
        saleOrderDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleOrder order = this.selectById(orderId);
        String orderState = order.getState();
        //state:状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("0");
        this.update(order);


        //advance_sum:预付款(定金)
        if (order.getAdvanceSum() != null&&"2".equals(orderState)) {


            //4.修改客户余额(vmes_customer.balance)
            String remarkTemp = "订单编号:{0} 预付款退款:{1}";
            String remark = MessageFormat.format(remarkTemp,
                    order.getSysCode(),
                    order.getAdvanceSum().setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP).toString());

            saleReceiveRecordService.editCustomerBalanceByOrder(
                    order.getCustomerId(),
                    null,
                    //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 5:预付款退款 -1:费用分摊)
                    "5",
                    order.getAdvanceSum().negate(),
                    order.getCuser(),
                    remark);


            //5.分摊预付款
            SaleReceive saleReceive = new SaleReceive();
            String id = Conv.createUuid();
            String companyID = pageData.getString("currentCompanyId");
            String code = coderuleService.createCoder(companyID, "vmes_sale_receive", "R");
            saleReceive.setId(id);
            saleReceive.setCode(code);
            saleReceive.setType("4");//收款类型(0:预收款 1:普通收款 2:发货退款 3:订单退款 4:预收款退款)
            saleReceive.setCustomerId(order.getCustomerId());
            saleReceive.setReceiveSum(order.getAdvanceSum().negate());
            saleReceive.setCompanyId(companyID);
            saleReceive.setUuser(pageData.getString("cuser"));
            saleReceive.setCuser(pageData.getString("cuser"));
            saleReceiveService.save(saleReceive);

            SaleReceiveDetail detail = new SaleReceiveDetail();
            detail.setParentId(saleReceive.getId());
            detail.setOrderId(order.getId());
            detail.setDiscountAmount(BigDecimal.ZERO);
            detail.setReceiveAmount(order.getAdvanceSum().negate());
            detail.setState("1");//收款单状态(0:待收款 1:已收款 -1:已取消)
            detail.setUuser(pageData.getString("cuser"));
            detail.setCuser(pageData.getString("cuser"));
            saleReceiveDetailService.save(detail);


            Customer customer = customerService.selectById(order.getCustomerId());
            //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
            String remark_1 = "费用分摊：" + customer.getBalance().subtract(customer.getBalance().subtract(order.getAdvanceSum().negate())).setScale(2, BigDecimal.ROUND_HALF_UP);
            this.updateCustomerBalance(
                    customer,
                    customer.getBalance().subtract(order.getAdvanceSum().negate()),
                    pageData.getString("uuser"),
                    "-1",
                    remark_1);

        }


        return model;
    }

    public ResultModel updateSaleOrderByLockCount(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细为空！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //获取企业id对应的锁定库存时长(毫秒)
        Long lockTime = saleLockDateService.findLockDateMillisecondByCompanyId(companyId);

        for (Map<String, String> mapObject : mapList) {
            String detail_id = mapObject.get("id");
            String productId = mapObject.get("productId");


            //(p2n:计价转换计量)///////////////////////////////////////////////////////////////////////////////////////////
            String p2nFormula = mapObject.get("p2nFormula");

            //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
            String p2nIsScale = new String();
            if (mapObject.get("p2nIsScale") != null) {
                p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
            }

            //p2nDecimalCount 小数位数 (最小:0位 最大:4位)
            Integer p2nDecimalCount = Integer.valueOf(2);
            String p2nDecimalCountStr = mapObject.get("p2nDecimalCount");
            if (p2nDecimalCountStr != null) {
                try {
                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //(单据单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
            //变更后-订单锁定数量
            BigDecimal editLockCount = BigDecimal.valueOf(0D);
            String editLockCountStr = mapObject.get("editLockCount");
            if (editLockCountStr != null && editLockCountStr.trim().length() > 0) {
                try {
                    editLockCount = new BigDecimal(editLockCountStr);
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //(计量单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
            //产品锁定库存数量
            BigDecimal productLockCount = BigDecimal.valueOf(0D);
            String productLockCountStr = mapObject.get("productLockCount");
            if (productLockCountStr != null && productLockCountStr.trim().length() > 0) {
                try {
                    productLockCount = new BigDecimal(productLockCountStr);
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //变更前-订单锁定数量(计量单位)
            BigDecimal lockCount = BigDecimal.valueOf(0D);
            String lockCountStr = mapObject.get("lockCount");
            if (lockCountStr != null && lockCountStr.trim().length() > 0) {
                try {
                    lockCount = new BigDecimal(lockCountStr);
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //editLockCount (变更后)订单锁定数量 -- (p2nFormula)计价单位转换计量单位
            editLockCount = EvaluateUtil.countFormulaP2N(editLockCount, p2nFormula);
            editLockCount = StringUtil.scaleDecimal(editLockCount, p2nIsScale, p2nDecimalCount);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            BigDecimal lockCount_new = BigDecimal.valueOf(0D);
            if (editLockCount != null) {lockCount_new = editLockCount;}

            if (lockCount_new.doubleValue() != lockCount.doubleValue()) {
                //1. 修改产品锁定库存数量
                Product product = new Product();
                product.setId(productId);

                BigDecimal lockCount_product = BigDecimal.valueOf(productLockCount.doubleValue() + (lockCount_new.doubleValue() - lockCount.doubleValue()));
                if (lockCount_product.doubleValue() < 0D) {
                    lockCount_product = BigDecimal.valueOf(0D);
                }

                //四舍五入到2位小数
                lockCount_product = lockCount_product.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                product.setLockCount(lockCount_product);
                productService.update(product);

                //2. 修改订单明细产品锁定库存数量
                SaleOrderDetail orderDetail = new SaleOrderDetail();
                orderDetail.setId(detail_id);
                orderDetail.setLockCount(lockCount_new);
                //是否锁定仓库(0:未锁定 1:已锁定) isLockWarehouse is_lock_warehouse
                orderDetail.setIsLockWarehouse("0");
                if (lockCount_new.doubleValue() > 0) {
                    orderDetail.setIsLockWarehouse("1");
                    orderDetail.setLockDate(new Date());
                }

                //versionLockCount
                Integer versionLockCount = null;
                String versionLockCount_str = mapObject.get("versionLockCount");
                if (versionLockCount_str != null && versionLockCount_str.trim().length() > 0) {
                    try {
                        versionLockCount = new Integer(versionLockCount_str.trim());
                    } catch(NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                if (versionLockCount != null) {
                    versionLockCount = Integer.valueOf(versionLockCount.intValue() + 1);
                    orderDetail.setVersionLockCount(versionLockCount);

                    //信息队列信息:(订单明细id,锁定库存版本号,,)
                    String orderDtl_activeMQ_temp = "{0},{1}";
                    String orderDtl_activeMQ_msg = MessageFormat.format(orderDtl_activeMQ_temp,
                            orderDetail.getId(),
                            orderDetail.getVersionLockCount());

                    //发送消息队列信息
                    if (lockTime != null && lockTime.longValue() > 0) {
                        sender.sendMsg(orderDtl_activeMQ_msg, lockTime.intValue());
                    }
                }

                saleOrderDetailService.update(orderDetail);
            }
        }

        return model;
    }


//    @Override
//    public void updateOrderStateCompelete(String id) throws Exception {
//        SaleOrder saleOrder = this.selectById(id);
//        if(saleOrder!=null){
//            //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//            if("3".equals(saleOrder.getState())){
//
//            }
//        }
//    }

    @Override
    public void exportExcelSaleOrder(PageData pd) throws Exception {
        List<Column> columnList = columnService.findColumnList("saleOrderByExport");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        //根据查询条件获取业务数据List
        String ids = pd.getString("ids");
        if (ids != null && ids.trim().length() > 0) {
            if (pd != null) {pd.clear();}

            String inIds = StringUtil.stringTrimSpace(ids);
            pd.put("inIds", inIds);
        } else if (ids == null || ids.trim().length() == 0) {
            pd.put("inIds", null);
        }

        List<Map> dataList = this.findListOrderByExport(pd);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataListNoHideCol(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleOrder";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel addCustomerBalance(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        BigDecimal addBalance = BigDecimal.valueOf(Double.parseDouble(pd.getString("addBalance")));
        Customer Customer = customerService.selectById(pd.getString("id"));

        String remark = "录入收款："+ Customer.getBalance().add(addBalance).subtract(Customer.getBalance()).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.updateCustomerBalance(
                Customer,
                Customer.getBalance().add(addBalance),
                pd.getString("uuser"),
                //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
                "1",
                remark);
        return model;
    }

    @Override
    public ResultModel updateCustomerBalancee(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Customer newCustomer = (Customer) HttpUtils.pageData2Entity(pd, new Customer());
        Customer oldCustomer = customerService.selectById(newCustomer.getId());

        String remarkTemp = "变更前：{0} 变更后：{1}";
        String remark = MessageFormat.format(remarkTemp,
                oldCustomer.getBalance().setScale(2, BigDecimal.ROUND_HALF_UP),
                newCustomer.getBalance().setScale(2, BigDecimal.ROUND_HALF_UP));

        this.updateCustomerBalance(
                oldCustomer,
                newCustomer.getBalance(),
                pd.getString("uuser"),
                //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
                "0",
                remark
        );
        return model;
    }


    @Override
    public void updateCustomerBalance(
            Customer oldCustomer,
            BigDecimal balance,
            String uuser,
            String type,
            String remark) throws Exception {
        PageData pd = new PageData();
        pd.put("id",oldCustomer.getId());
        pd.put("version",oldCustomer.getVersion());
        pd.put("uuser",uuser);
        pd.put("balance",balance);
        customerService.updateCustomerBalance(pd);

        SaleReceiveRecord saleReceiveRecord = new SaleReceiveRecord();
        saleReceiveRecord.setBeforeAmount(oldCustomer.getBalance());
        saleReceiveRecord.setAfterAmount(balance);
        saleReceiveRecord.setAmount(balance.subtract(oldCustomer.getBalance()));
        saleReceiveRecord.setCustomerId(oldCustomer.getId());
        //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
        saleReceiveRecord.setType(type);
        saleReceiveRecord.setRemark(remark);
        saleReceiveRecord.setUuser(uuser);
        saleReceiveRecord.setCuser(uuser);
        saleReceiveRecordService.save(saleReceiveRecord);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取流水号：前缀+短日期(yyyy 后2位) +3位流水号，如D190808001 (10位)
     * 例如: 短日期(2019) 短日期(19)
     * @param companyID
     * @param tableName
     * @param prefix
     * @return
     */
    private String createOrderCoder(String companyID, String tableName, String prefix) {
        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
        //(无需+前缀字符+日期字符+流水号)-W000142
        CoderuleEntity object = new CoderuleEntity();
        //tableName 业务名称(表名)
        object.setTableName(tableName);
        //companyID 公司ID
        object.setCompanyID(companyID);
        //length 指定位数(3)
        object.setLength(Common.CODE_RULE_SALEORDER_LENGTH_DEFAULT);

        //firstName 第一段编码为自定义前缀字符
        object.setFirstName(Common.FIRST_NAME_PREFIX);
        //isNeedPrefix 是否显示前缀字符
        object.setIsNeedPrefix(Boolean.TRUE);
        //prefix 前缀字符
        object.setPrefix(prefix);

        //filling 填充字符(0)
        object.setFilling(Common.CODE_RULE_DEFAULT_FILLING);

        //isNeedDate 是否需求日期并且设置格式
        object.setIsNeedDate(Boolean.TRUE);
        //isNeedShortYear 是否需要短年份 如:2019 得到:19
        object.setNeedShortYear(Boolean.TRUE);

        return coderuleService.findCoderuleByDate(object);
    }
}



