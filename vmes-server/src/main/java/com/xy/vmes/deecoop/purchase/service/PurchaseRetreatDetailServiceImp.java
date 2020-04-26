package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.service.*;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.deecoop.purchase.dao.PurchaseRetreatDetailMapper;
import com.xy.vmes.entity.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_purchase_retreat_detail:退货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-05-09
*/
@Service
@Transactional(readOnly = false)
public class PurchaseRetreatDetailServiceImp implements PurchaseRetreatDetailService {

    @Autowired
    private PurchaseRetreatDetailMapper purchaseRetreatDetailMapper;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;


    @Autowired
    private ColumnService columnService;

    @Autowired
    private SystemToolService systemToolService;
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-05-09
    */
    @Override
    public void save(PurchaseRetreatDetail purchaseRetreatDetail) throws Exception{
        purchaseRetreatDetail.setId(Conv.createUuid());
        purchaseRetreatDetail.setCdate(new Date());
        purchaseRetreatDetail.setUdate(new Date());
        purchaseRetreatDetailMapper.insert(purchaseRetreatDetail);
    }

    public void saveDetail(PurchaseRetreatDetail object) throws Exception {
        object.setId(Conv.createUuid());
        purchaseRetreatDetailMapper.insert(object);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public PurchaseRetreatDetail selectById(String id) throws Exception{
        return purchaseRetreatDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public List<PurchaseRetreatDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchaseRetreatDetail> warehouseCheckDetailList =  purchaseRetreatDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void update(PurchaseRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        purchaseRetreatDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void updateAll(PurchaseRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        purchaseRetreatDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchaseRetreatDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchaseRetreatDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchaseRetreatDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchaseRetreatDetailMapper.updateToDisableByIds(ids);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-09
     */
    @Override
    public List<PurchaseRetreatDetail> dataList(PageData pd) throws Exception{
        return purchaseRetreatDetailMapper.dataList(pd);
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
            return purchaseRetreatDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchaseRetreatDetailMapper.getDataListPage(pd,pg);
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
    public List<PurchaseRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseRetreatDetail>();
        }

        return this.dataList(pageData);
    }

    public PurchaseRetreatDetail findPurchaseRetreatDetail(PageData object) throws Exception {
        List<PurchaseRetreatDetail> objectList = this.findPurchaseRetreatDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchaseRetreatDetail findPurchaseRetreatDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchaseRetreatDetail(findMap);
    }

    public List<PurchaseRetreatDetail> findPurchaseRetreatDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchaseRetreatDetail> findPurchaseRetreatDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findPurchaseRetreatDetailList(findMap);
    }

    public List<PurchaseRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<PurchaseRetreatDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<PurchaseRetreatDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            PurchaseRetreatDetail detail = (PurchaseRetreatDetail) HttpUtils.pageData2Entity(mapObject, new PurchaseRetreatDetail());

            //单价 price
            BigDecimal price = BigDecimal.valueOf(0D);
            String price_str = mapObject.get("price");
            if (price_str != null && price_str.trim().length() > 0) {
                try {
                    price = new BigDecimal(price_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到4位小数
            price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setPrice(price);

            //退货金额 := 退货数量(count) * 单价(price)
            BigDecimal amount = BigDecimal.valueOf(detail.getCount().doubleValue() * price.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setAmount(amount);

            objectList.add(detail);
        }

        return objectList;
    }

    public BigDecimal findTotalSumByDetailList(List<PurchaseRetreatDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (PurchaseRetreatDetail detail : objectList) {
            //amount 退货金额
            double amount_double = 0D;
            if (detail.getAmount() != null) {
                amount_double = detail.getAmount().doubleValue();
            }

            totalSum_double = totalSum_double + amount_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    public WarehouseOutDetail retreatDetail2OutDetail(PurchaseRetreatDetail retreatDetail, WarehouseOutDetail outDetail) {
        if (outDetail == null) {outDetail = new WarehouseOutDetail();}
        if (retreatDetail == null) {return outDetail;}

        //productId 产品ID
        outDetail.setProductId(retreatDetail.getProductId());
        //count 入库数量 退货数量:count
        outDetail.setCount(retreatDetail.getCount());
        //businessId 业务id(退货明细id)
        outDetail.setBusinessId(retreatDetail.getId());

        return outDetail;
    }
    public List<WarehouseOutDetail> retreatDtlList2OutDtlList(List<PurchaseRetreatDetail> retreatDtlList, Map<String, String> productMap, List<WarehouseOutDetail> outDtlList) {
        if (outDtlList == null) {outDtlList = new ArrayList<WarehouseOutDetail>();}
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return outDtlList;}

        for (PurchaseRetreatDetail retreatDtl : retreatDtlList) {
            WarehouseOutDetail outDetail = this.retreatDetail2OutDetail(retreatDtl, null);

            //productId 产品ID
            String productId = outDetail.getProductId();

            //p2nFormula (计价单位转换计量单位公式)
            String p2nFormula = "";
            if (productMap != null
                && productMap.get(productId) != null
                && productMap.get(productId).trim().length() > 0
            ) {
                p2nFormula = productMap.get(productId).trim();
            }

            //采购数量 - 转换计量单位 - 单位换算公式(p2nFormula)
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            try {
                BigDecimal bigDecimal = EvaluateUtil.countFormulaP2N(outDetail.getCount(), p2nFormula);
                if (bigDecimal != null) {prodCount = bigDecimal;}
            } catch (Exception e) {
                e.printStackTrace();
            }
            outDetail.setCount(prodCount);

            outDtlList.add(outDetail);
        }

        return outDtlList;
    }

    public String findOrderDtlIdsByRetreatDtlList(List<PurchaseRetreatDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (PurchaseRetreatDetail object : objectList) {
            String orderDtlId = object.getOrderDetailId();
            if (orderDtlId != null && orderDtlId.trim().length() > 0)  {
                strBuf.append(orderDtlId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strTemp;
    }

    /**
     * 获取 <采购订单明细id,<订单明细退货信息Map>
     *     订单明细退货信息Map
     *         count:退货数量
     *         amount:退货金额(订单明细-退货金额)
     * @param objectList
     * @return
     */
    public Map<String, Map<String, BigDecimal>> findOrderDtlRetreatCountMap(List<PurchaseRetreatDetail> objectList) {
        Map<String, Map<String, BigDecimal>> mapObject = new HashMap<String, Map<String, BigDecimal>>();
        if (objectList == null || objectList.size() == 0) {return mapObject;}

        for (PurchaseRetreatDetail object : objectList) {
            String orderDtlId = object.getOrderDetailId();

            Map<String, BigDecimal> retreatMap = new HashMap<String, BigDecimal>();
            //count 退货数量
            BigDecimal count = object.getCount();
            retreatMap.put("count", count);

            //amount 退货金额
            BigDecimal amount = object.getAmount();
            retreatMap.put("amount", amount);

            mapObject.put(orderDtlId, retreatMap);
        }

        return mapObject;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        purchaseRetreatDetailMapper.updateStateByDetail(pageData);
    }

    public void addPurchaseRetreatDetail(PurchaseRetreat parentObj, List<PurchaseRetreatDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (PurchaseRetreatDetail detail : objectList) {
            //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
            detail.setState(parentObj.getState());
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            detail.setCdate(parentObj.getCdate());
            detail.setUdate(parentObj.getCdate());
            this.saveDetail(detail);
        }
    }

    public void updateOrderDetailByRetreat(Map<String, Map<String, BigDecimal>> orderDtlRetreatMap, List<PurchaseOrderDetail> orderDtlList) throws Exception {
        if (orderDtlRetreatMap == null || orderDtlRetreatMap.size() == 0) {return;}
        if (orderDtlList == null || orderDtlList.size() == 0) {return;}

        for (PurchaseOrderDetail orderDetail : orderDtlList) {
            PurchaseOrderDetail orderDetailEdit = new PurchaseOrderDetail();

            String orderId = orderDetail.getParentId();

            String orderDtlId = orderDetail.getId();
            orderDetailEdit.setId(orderDtlId);

            //count 采购数量
            BigDecimal count = BigDecimal.valueOf(0D);
            if (orderDetail.getCount() != null) {
                count = orderDetail.getCount();
            }

            //amount 采购金额
            BigDecimal amount = BigDecimal.valueOf(0D);
            if (orderDetail.getAmount() != null) {
                amount = orderDetail.getAmount();
            }

            //count 退货数量
            Map<String, BigDecimal> retreatMap = orderDtlRetreatMap.get(orderDtlId);
            BigDecimal retreatCount = BigDecimal.valueOf(0D);
            if (retreatMap.get("count") != null) {
                retreatCount = retreatMap.get("count");
            }

            //amount 退货金额
            BigDecimal retreatAmount = BigDecimal.valueOf(0D);
            if (retreatMap.get("amount") != null) {
                retreatAmount = retreatMap.get("amount");
            }

            count = BigDecimal.valueOf(count.doubleValue() - retreatCount.doubleValue());
            //四舍五入到2位小数
            count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDetailEdit.setCount(count);

            amount = BigDecimal.valueOf(amount.doubleValue() - retreatAmount.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDetailEdit.setAmount(amount);

            purchaseOrderDetailService.update(orderDetailEdit);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageRetreatDetail(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchaseRetreatDetail");
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
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for (Map<String, Object> mapObject : varList) {
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}

