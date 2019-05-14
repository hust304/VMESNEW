package com.xy.vmes.deecoop.purchase.service;


import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.purchase.dao.PurchaseRetreatMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

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

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addPurchaseRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //采购订单id
        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购订单id为空或空字符串！");
            return model;
        }

        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

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
        retreat.setSupplierId(supplierId);
        retreat.setOrderId(orderId);
        //获取退货总金额
        BigDecimal totalSum = purchaseRetreatDetailService.findTotalSumByDetailList(retreatDtlList);
        retreat.setTotalSum(totalSum);
        //realityTotal 实际退货金额
        retreat.setRealityTotal(totalSum);

        //状态(1:待审核 2:待退货 3:已完成 -1:已取消)
        retreat.setState("1");
        String companyID = pageData.getString("currentCompanyId");
        retreat.setCompanyId(companyID);

        String cuser = pageData.getString("cuser");
        retreat.setCuser(cuser);

        //退货单编号
        //D+yyyyMMdd+00001 = 14位
        String code = coderuleService.createCoderCdateByDate(companyID,
                "vmes_purchase_retreat",
                "yyyyMMdd",
                "PT");
        retreat.setSysCode(code);
        this.save(retreat);

        //2. 退货单明细
        purchaseRetreatDetailService.addPurchaseRetreatDetail(retreat, retreatDtlList);

        return model;
    }

    public ResultModel auditPassPurchaseRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = pageData.getString("currentCompanyId");
        String supplierId = pageData.getString("supplierId");
        String supplierName = pageData.getString("supplierName");
        String cuser = pageData.getString("cuser");

        //退货单id retreatId
        String retreatId = pageData.getString("retreatId");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无列表数据！");
            return model;
        }

        List<Map<String, String>> retreatDtlMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (retreatDtlMapList == null || retreatDtlMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //根据(退货单id)-获取退货单明细List
        List<PurchaseRetreatDetail> retreatDtlList = purchaseRetreatDetailService.findPurchaseRetreatDetailListByParentId(retreatId);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(supplierId,
                supplierName,
                cuser,
                companyId,
                Common.DICTIONARY_MAP.get("purchaseOut"));
        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
        warehouseOutService.save(warehouseOut);

        //创建出库单明细
        List<WarehouseOutDetail> outDtlList = purchaseRetreatDetailService.retreatDtlList2OutDtlList(retreatDtlList, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, outDtlList);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //<退货单明细id, 出库明细id>Map
        Map<String, String> retreatDtl2OutDtlMap = new HashMap<String, String>();
        for (WarehouseOutDetail outDtl : outDtlList) {
            retreatDtl2OutDtlMap.put(outDtl.getBusinessId(), outDtl.getId());
        }

        //修改退货单明细(退货单明细(关联)入库单明细)
        for (Map<String, String> mapObject : retreatDtlMapList) {
            PurchaseRetreatDetail detailEdit = new PurchaseRetreatDetail();

            //id: 退货单明细id,
            String retreatDtl_id = mapObject.get("id");
            detailEdit.setId(retreatDtl_id);

            //count: 退货数量
            BigDecimal count = BigDecimal.valueOf(0D);
            String count_str = mapObject.get("count");
            if (count_str != null && count_str.trim().length() > 0) {
                try {
                    count = new BigDecimal(count_str.trim());
                    //四舍五入到2位小数
                    count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            detailEdit.setCount(count);

            //price: 货品单价
            BigDecimal price = BigDecimal.valueOf(0D);
            String price_str = mapObject.get("price");
            if (price_str != null && price_str.trim().length() > 0) {
                try {
                    price = new BigDecimal(price_str.trim());
                    //四舍五入到2位小数
                    price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //amount: 退货金额
            BigDecimal amount = BigDecimal.valueOf(count.doubleValue() * price.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detailEdit.setAmount(amount);

            if (retreatDtl2OutDtlMap != null
                    && retreatDtl2OutDtlMap.get(retreatDtl_id) != null
                    && retreatDtl2OutDtlMap.get(retreatDtl_id).trim().length() > 0
                    ) {
                detailEdit.setOutDetailId(retreatDtl2OutDtlMap.get(retreatDtl_id).trim());
            }

            //退货单明细状态(1:待审核 2:待退货 3:已完成 -1:已取消)
            detailEdit.setState("3");

            purchaseRetreatDetailService.update(detailEdit);
        }

        PurchaseRetreat retreatEdit = new PurchaseRetreat();
        retreatEdit.setId(retreatId);
        //审核人ID
        retreatEdit.setAuditId(cuser);
        //状态(1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatEdit.setState("3");
        this.update(retreatEdit);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 修改订单明细和订单
        //获取 <采购订单明细id, <采购订单明细退货信息Map(count:退货数量,amount:退货金额)>
        Map<String, Map<String, BigDecimal>> orderDtlRetreatMap = purchaseRetreatDetailService.findOrderDtlRetreatCountMap(retreatDtlList);
        if (orderDtlRetreatMap == null || orderDtlRetreatMap.size() == 0) {
            return model;
        }

        //获取采购订单明细id字符串-(','逗号分隔字符串)
        String orderDtlIds = purchaseRetreatDetailService.findOrderDtlIdsByRetreatDtlList(retreatDtlList);
        if (orderDtlIds == null || orderDtlIds.trim().length() == 0) {
            return model;
        }

        PageData findMap = new PageData();
        orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
        findMap.put("ids", orderDtlIds);
        List<PurchaseOrderDetail> orderDtlList = purchaseOrderDetailService.findPurchaseOrderDetailList(findMap);
        if (orderDtlList == null || orderDtlList.size() == 0) {
            return model;
        }

        //修改采购订单明细-变更订单明细(订购数量,货品金额)
        purchaseRetreatDetailService.updateOrderDetailByRetreat(orderDtlRetreatMap, orderDtlList);

        //修改采购订单



//        for (Iterator iterator = orderMap.keySet().iterator(); iterator.hasNext();) {
//            SaleOrder orderEdit = new SaleOrder();
//
//            String orderId = (String) iterator.next();
//            orderEdit.setId(orderId);
//
//            List<PurchaseOrderDetail> orderDetailList = purchaseOrderDetailService.findPurchaseOrderDetailListByParentId(orderId);
//            if (orderDetailList == null || orderDetailList.size() == 0) {continue;}
//
//            //采购订单明细总金额
//            BigDecimal totalSum = purchaseOrderDetailService.findTotalSumByDetailList(orderDetailList);
//
//            //discount 折扣金额
//            //orderEdit.setDiscountSum(BigDecimal.valueOf(0D));
//            //total 合计金额 (采购订单明细总金额)
//            //orderEdit.setTotalSum(totalSum);
//            //amount 采购金额 (合计金额 - 折扣金额)
//            orderEdit.setOrderSum(totalSum);
//
//            String remark = "";
//            SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
//            if (orderDB.getRemark() != null && orderDB.getRemark().trim().length() > 0) {
//                remark = orderDB.getRemark().trim();
//            }
//
//            String tempStr = "退货单审核通过：修改订单数量和订单金额{0}";
//            String msgStr = MessageFormat.format(
//                    tempStr,
//                    DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT)
//            );
//            remark = remark + msgStr;
//            orderEdit.setRemark(remark);
//
//            saleOrderService.update(orderEdit);
//        }

        return model;
    }


}



