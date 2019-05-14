package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchasePaymentDetailMapper;
import com.xy.vmes.entity.PurchasePayment;
import com.xy.vmes.entity.PurchasePaymentDetail;
import com.xy.vmes.service.PurchasePaymentDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_purchase_payment_detail:采购订单付款单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-05-14
*/
@Service
@Transactional(readOnly = false)
public class PurchasePaymentDetailServiceImp implements PurchasePaymentDetailService {
    @Autowired
    private PurchasePaymentDetailMapper purchasePaymentDetailMapper;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-05-14
    */
    @Override
    public void save(PurchasePaymentDetail purchasePaymentDetail) throws Exception{
        purchasePaymentDetail.setId(Conv.createUuid());
        purchasePaymentDetail.setCdate(new Date());
        purchasePaymentDetail.setUdate(new Date());
        purchasePaymentDetailMapper.insert(purchasePaymentDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public PurchasePaymentDetail selectById(String id) throws Exception{
        return purchasePaymentDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public List<PurchasePaymentDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchasePaymentDetail> warehouseCheckDetailList =  purchasePaymentDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void update(PurchasePaymentDetail object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void updateAll(PurchasePaymentDetail object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePaymentDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePaymentDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePaymentDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePaymentDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public List<PurchasePaymentDetail> dataList(PageData pd) throws Exception{
        return purchasePaymentDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-05-14
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return purchasePaymentDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchasePaymentDetailMapper.getDataListPage(pd,pg);
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
    public List<PurchasePaymentDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePaymentDetail>();
        }

        return this.dataList(pageData);
    }

    public PurchasePaymentDetail findPurchasePaymentDetail(PageData object) throws Exception {
        List<PurchasePaymentDetail> objectList = this.findPurchasePaymentDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchasePaymentDetail findPurchasePaymentDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchasePaymentDetail(findMap);
    }

    public List<PurchasePaymentDetail> findPurchasePaymentDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchasePaymentDetail> findPurchasePaymentDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findPurchasePaymentDetailList(findMap);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addPaymentDetail(PurchasePayment parentObj, List<PurchasePaymentDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (PurchasePaymentDetail detail : objectList) {
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchasePaymentDetails(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchasePaymentDetail");
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



