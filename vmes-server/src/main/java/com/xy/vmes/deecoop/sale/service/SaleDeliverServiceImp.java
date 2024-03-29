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
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

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
    private SaleDeliverOutDetailService saleDeliverOutDetailService;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;

    @Autowired
    private FinanceBillService financeBillService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private RoleMenuService roleMenuService;
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
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleDeliverMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleDeliverMapper.getDataListPage(pd,pg);
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
    public ResultModel listPageSaleDeliver(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

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

        //isNeedInfo:是否需要显示(出库详情,发货详情):'true'
        String isNeedInfo = pd.getString("isNeedInfo");

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        if ("true".equals(isNeedInfo) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //发货详情(按钮) 是否显示
                //isShowDeliver:发货详情 1:显示 0:不显示
                mapObject.put("isShowDeliver", "0");

                //根据vmes_sale_deliver.type 是否为空:发货类型(1:发货 2:送货 3:客户自提)
                String type = (String)mapObject.get("type");
                if (type != null && type.trim().length() > 0) {
                    //isShowDeliver:发货详情 1:显示 0:不显示
                    mapObject.put("isShowDeliver", "1");
                }

                ///////////////////////////////////////////////////////
                //出库详情(按钮) 是否显示
                //isShowOut:出库详情 1:显示 0:不显示
                mapObject.put("isShowOut", "0");

                String deliverId = (String)mapObject.get("id");
                //SQL查询语句:SaleDeliverOutDetailMapper.findOutDetailByOrderDetail
                List<Map<String, Object>> mapList = saleDeliverOutDetailService.findDeliverDetailListByDeliverId(deliverId);
                if (mapList != null && mapList.size() > 0) {
                    for (Map<String, Object> mapObj : mapList) {
                        //出库执行数量:executeCount
                        //BigDecimal executeCount = BigDecimal.valueOf(0D);
                        if (mapObj.get("executeCount") != null && ((BigDecimal)mapObj.get("executeCount")).doubleValue() > 0) {
                            //isShowOut:出库详情 1:显示 0:不显示
                            mapObject.put("isShowOut", "1");
                            break;
                        }
                    }
                }
                ///////////////////////////////////////////////////////
                //结算(按钮) 是否显示
                //isShowPrice:结算 1:显示 0:不显示
                mapObject.put("isShowPrice", "1");
                List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.findSaleDeliverDetailListByParentId(deliverId);
                if (deliverDtlList != null && deliverDtlList.size() > 0) {
                    boolean isAllNotPrice = true;
                    for (SaleDeliverDetail deliverDetail : deliverDtlList) {
                        if (deliverDetail.getSum() == null || deliverDetail.getSum().doubleValue() == 0D) {
                            isAllNotPrice = false;
                            break;
                        }
                    }
                    if (isAllNotPrice) {
                        mapObject.put("isShowPrice", "0");
                    }
                }

                ///////////////////////////////////////////////////////
//                BigDecimal pieceCount = BigDecimal.valueOf(0D);
//                if (mapObject.get("pieceCount") != null) {
//                    pieceCount = (BigDecimal)mapObject.get("pieceCount");
//                }
//
//                if (pieceCount.doubleValue() == 0) {
//                    BigDecimal pieceCountSum = BigDecimal.valueOf(0D);
//                    if (deliverDtlList != null && deliverDtlList.size() > 0) {
//                        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
//                            BigDecimal pieceCountDtl = BigDecimal.valueOf(0D);
//                            if (deliverDetail.getPieceCount() != null) {
//                                pieceCountDtl = deliverDetail.getPieceCount();
//                            }
//                            pieceCountSum = BigDecimal.valueOf(pieceCountSum.doubleValue() + pieceCountDtl.doubleValue());
//                        }
//                    }
//                    pieceCount = pieceCountSum;
//                }
//
//                //四舍五入到2位小数
//                pieceCount = pieceCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                mapObject.put("pieceCount", pieceCount);
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addSaleDeliver(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //创建(复杂版,简版)仓库-出库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String cuser = pageData.getString("cuser");

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        //业务相关参数////////////////////////////////////////////////////////////////////////////////////////////////////////
        String priceType = pageData.getString("priceType");
        if (priceType == null || priceType.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("计价类型(priceType)为空或空字符串！");
            return model;
        }

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

        //获取订单明细
        //1. 本次发货数量(计价单位)
        //2. 公式:P(计价单位) 转换 N(计量单位)
        //3. count:订购数量(计价数量) -- 本次发货数量(计价单位)
        //   productCount:货品数量(计量数量) --本次发货数量(计量单位)
        List<SaleOrderDetailEntity> orderDtlList = saleDeliverDetailService.mapList2OrderDetailList(mapList, null);

        //生成出库单//////////////////////////////////////////////////////////////////////////////////////////////////
        //发货单编号
        String deliverCode = this.createDeliverCoder(companyId, "vmes_sale_deliver", "F");
        String customerId = mapList.get(0).get("customerId");
        String customerName = mapList.get(0).get("customerName");

        Map<String, Map<String, Object>> businessByOutMap = saleDeliverDetailService.findProductBusinessMapByOut(orderDtlList);
        if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseOutCreateService.createWarehouseOutBusinessByComplex(customerId,
                    customerName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //9459be975cd94ada8443cdf32f52c2be 销售发货出库:saleOut
                    Common.DICTIONARY_MAP.get("saleOut"),
                    deliverCode,
                    businessByOutMap);
        } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseOutCreateService.createWarehouseOutBusinessBySimple(customerId,
                    customerName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //9459be975cd94ada8443cdf32f52c2be 销售发货出库:saleOut
                    Common.DICTIONARY_MAP.get("saleOut"),
                    deliverCode,
                    businessByOutMap);
        }

        //2. 创建发货单
        SaleDeliver saleDeliver = new SaleDeliver();
        String deliverId = Conv.createUuid();
        saleDeliver.setId(deliverId);
        saleDeliver.setPriceType(priceType);
        saleDeliver.setDeliverCode(deliverCode);

        saleDeliver.setCustomerId(customerId);
        saleDeliver.setCompanyId(companyId);
        //state:状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("0");
        saleDeliver.setMakeId(cuser);
        saleDeliver.setCuser(cuser);

        List<SaleDeliverDetail> deliverDtlList = saleOrderDetailService.orderDtlList2DeliverDtllList(orderDtlList, null);
        saleDeliverDetailService.addDeliverDetailByBusinessMap(saleDeliver, deliverDtlList, businessByOutMap);

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

        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        String cuser = pageData.getString("cuser");
        String linkName = pageData.getString("custAddressName");
        String mobile = pageData.getString("custMobile");


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

        //设定发货单明细(发货件数)
        String deliverDtlJsonStr = pageData.getString("deliverDtlJsonStr");
        if (deliverDtlJsonStr != null && deliverDtlJsonStr.trim().length() > 0) {
            List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(deliverDtlJsonStr);
            for (Map<String, String> mapObject : mapList) {
                SaleDeliverDetail editDeliverDtl = (SaleDeliverDetail)HttpUtils.pageData2Entity(mapObject, new SaleDeliverDetail());

                BigDecimal pieceCount = BigDecimal.valueOf(0D);
                if (editDeliverDtl.getPieceCount() != null) {
                    pieceCount = editDeliverDtl.getPieceCount();
                }
                //四舍五入到0位小数
                pieceCount = pieceCount.setScale(0, BigDecimal.ROUND_HALF_UP);
                editDeliverDtl.setPieceCount(pieceCount);

                saleDeliverDetailService.update(editDeliverDtl);
            }
        }

        SaleDeliver saleDeliver = (SaleDeliver)HttpUtils.pageData2Entity(pageData, new SaleDeliver());
        saleDeliver.setId(deliverId);
        saleDeliver.setLinkName(linkName);
        saleDeliver.setMobile(mobile);
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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //该发货单-对应的全部(订单,订单明细)
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
        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
            String orderId = deliverDetail.getOrderId();
            orderIdMap.put(orderId, orderId);

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

                if (checkCount.doubleValue() >= orderCount.doubleValue()) {
                    //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
                    orderDetail.setState("5");
                }
            }

            saleOrderDetailService.update(orderDetail);
        }

        //反写订单状态
        if (orderIdMap.size() > 0) {
            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext(); ) {
                SaleOrder editOrder = new SaleOrder();

                String orderId = (String)iterator.next();
                editOrder.setId(orderId);

                //设定最近一次发货的发货日期
                editOrder.setCurrentDeliverDate(new Date());

                saleOrderDetailService.updateParentStateByDetailList(editOrder, null);
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //创建付款单(vmes_finance_bill)
        //amount 金额
        //获取当前发货单金额
        BigDecimal deliverTotalSum = saleDeliverDetailService.findTotalSumByDetailList(deliverDtlList);
        String remark = "发货单号："+saleDeliver.getDeliverCode();
        financeBillService.addFinanceBillBySys(deliverId,
                companyId,
                customerId,
                cuser,
                //type 单据类型 ( 0:收款单 1:付款单 2:减免单 3:退款单 4:发货账单 5:发退货账单 6:收货账单 7:收退货账单)
                "4",
                null,
                deliverTotalSum,
                remark);

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


//    public void exportExcelSaleDelivers(PageData pd, Pagination pg) throws Exception {
//        List<Column> columnList = columnService.findColumnList("saleDeliver");
//        if (columnList == null || columnList.size() == 0) {
//            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
//        }
//
//        //根据查询条件获取业务数据List
//        String ids = (String)pd.getString("ids");
//        String queryStr = "";
//        if (ids != null && ids.trim().length() > 0) {
//            ids = StringUtil.stringTrimSpace(ids);
//            ids = "'" + ids.replace(",", "','") + "'";
//            queryStr = "id in (" + ids + ")";
//        }
//        pd.put("queryStr", queryStr);
//
//        pg.setSize(100000);
//        List<Map> dataList = this.getDataListPage(pd, pg);
//
//        //查询数据转换成Excel导出数据
//        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
//        HttpServletResponse response = HttpUtils.currentResponse();
//
//        //查询数据-Excel文件导出
//        String fileName = pd.getString("fileName");
//        if (fileName == null || fileName.trim().length() == 0) {
//            fileName = "ExcelSaleDeliver";
//        }
//
//        //导出文件名-中文转码
//        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
//        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
//    }

//    public ResultModel importExcelSaleDelivers(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//
//        return model;
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取流水号：前缀+短日期(yyyy 后2位) +3位流水号，如F190808001 (10位)
     * 例如: 短日期(2019) 短日期(19)
     * @param companyID
     * @param tableName
     * @param prefix
     * @return
     */
    private String createDeliverCoder(String companyID, String tableName, String prefix) {
        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
        //(无需+前缀字符+日期字符+流水号)-W000142
        CoderuleEntity object = new CoderuleEntity();
        //tableName 业务名称(表名)
        object.setTableName(tableName);
        //companyID 公司ID
        object.setCompanyID(companyID);
        //length 指定位数(3)
        object.setLength(Common.CODE_RULE_SALEDELIVER_LENGTH_DEFAULT);

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

