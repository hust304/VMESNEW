package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.purchase.dao.PurchaseRetreatDetailMapper;
import com.xy.vmes.entity.PurchaseRetreat;
import com.xy.vmes.entity.PurchaseRetreatDetail;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.PurchaseRetreatDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
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
    private ColumnService columnService;
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
            String price_str = mapObject.get("price");
            BigDecimal price = BigDecimal.valueOf(0D);
            if (price_str != null && price_str.trim().length() > 0) {
                try {
                    price = new BigDecimal(price_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

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
    public List<WarehouseOutDetail> retreatDtlList2OutDtlList(List<PurchaseRetreatDetail> retreatDtlList, List<WarehouseOutDetail> outDtlList) {
        if (outDtlList == null) {outDtlList = new ArrayList<WarehouseOutDetail>();}
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return outDtlList;}

        for (PurchaseRetreatDetail retreatDtl : retreatDtlList) {
            WarehouseOutDetail outDetail = this.retreatDetail2OutDetail(retreatDtl, null);
            outDtlList.add(outDetail);
        }

        return outDtlList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        purchaseRetreatDetailMapper.updateStateByDetail(pageData);
    }

    public void addPurchaseRetreatDetail(PurchaseRetreat parentObj, List<PurchaseRetreatDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (PurchaseRetreatDetail detail : objectList) {
            //退货明细状态 明细状态(1:待审核 2:待退货 3:已完成 -1:已取消)
            detail.setState("1");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
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
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



