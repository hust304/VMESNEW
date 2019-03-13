package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.purchase.dao.PurchasePaymentHistoryMapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.xy.vmes.entity.PurchasePaymentHistory;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.PurchaseCompanyPeriodService;
import com.xy.vmes.service.PurchasePaymentHistoryService;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

/**
 * 说明：vmes_purchase_payment_history:供应商账期汇总 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2019-03-11
 */
@Service
@Transactional(readOnly = false)
public class PurchasePaymentHistoryImp implements PurchasePaymentHistoryService {
    @Autowired
    private PurchasePaymentHistoryMapper purchasePaymentHistoryMapper;
    @Autowired
    private PurchaseCompanyPeriodService purchaseCompanyPeriodService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void save(PurchasePaymentHistory object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        purchasePaymentHistoryMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public PurchasePaymentHistory selectById(String id) throws Exception{
        return purchasePaymentHistoryMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentHistory> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchasePaymentHistory> warehouseCheckDetailList =  purchasePaymentHistoryMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void update(PurchasePaymentHistory object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentHistoryMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateAll(PurchasePaymentHistory object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentHistoryMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePaymentHistoryMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePaymentHistoryMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePaymentHistoryMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePaymentHistoryMapper.updateToDisableByIds(ids);
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
    public List<PurchasePaymentHistory> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePaymentHistory>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentHistory> dataList(PageData pd) throws Exception{
        return purchasePaymentHistoryMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<Map> findListPurchasePaymentHistoryByPaymentPeriod(PageData pd,Pagination pg) throws Exception{
        return purchasePaymentHistoryMapper.findListPurchasePaymentHistoryByPaymentPeriod(pd, pg);
    }

    public List<PurchasePaymentHistory> mapList2PaymentHistoryList(List<Map<String, String>> mapList, List<PurchasePaymentHistory> objectList) {
        if (objectList == null) {objectList = new ArrayList<PurchasePaymentHistory>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            PurchasePaymentHistory paymentHistory = (PurchasePaymentHistory) HttpUtils.pageData2Entity(mapObject, new PurchasePaymentHistory());
            objectList.add(paymentHistory);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param pd    查询参数对象PageData
     * @param pg    分页参数对象Pagination
     * @return      返回对象ResultModel
     * @throws Exception
     */
    public ResultModel listPagePurchasePaymentHistory(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchasePaymentHistory");
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

        //获取当前付款期间
        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //paymentPeriod 当前付款期(yyyymm)
        PurchaseCompanyPeriod companyPeriod = purchaseCompanyPeriodService.findPurchaseCompanyPeriodByCompanyId(companyId);
        if (companyPeriod == null || companyPeriod.getPaymentPeriod() == null || companyPeriod.getPaymentPeriod().trim().length() == 0) {
            model.putCode("1");
            model.putMsg("您所在的企业无当前付款期间，请与管理员联系！");
            return model;
        }
        String paymentPeriod = companyPeriod.getPaymentPeriod();
        pd.put("dateByNow", paymentPeriod);

        //当前付款期(前一个月)
        String dateByBefore = DateFormat.getAddDay(paymentPeriod, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
        pd.put("dateByBefore", dateByBefore);

        pd.put("paymentPeriod", paymentPeriod);

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.findListPurchasePaymentHistoryByPaymentPeriod(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    public ResultModel addPurchasePaymentHistory(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        //获取当前付款期间
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //paymentPeriod 当前付款期(yyyymm)
        PurchaseCompanyPeriod companyPeriod = purchaseCompanyPeriodService.findPurchaseCompanyPeriodByCompanyId(companyId);
        if (companyPeriod == null || companyPeriod.getPaymentPeriod() == null || companyPeriod.getPaymentPeriod().trim().length() == 0) {
            model.putCode("1");
            model.putMsg("您所在的企业无当前付款期间，请与管理员联系！");
            return model;
        }
        String paymentPeriod = companyPeriod.getPaymentPeriod();

        String listJsonStr = pageData.getString("listJsonStr");
        if (listJsonStr == null || listJsonStr.trim().length() == 0) {
            String remark = "备注：是否设定供应商付款初期值，如果未设定请与企业管理员联系！";
            String msgTemp = "您所在的企业当前付款期间({0})无供应商！" + Common.SYS_ENDLINE_DEFAULT + remark + Common.SYS_ENDLINE_DEFAULT;

            String msgStr = MessageFormat.format(msgTemp, paymentPeriod);
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(listJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        List<PurchasePaymentHistory> paymentHistoryList = this.mapList2PaymentHistoryList(mapList, null);
        for (PurchasePaymentHistory paymentHistory : paymentHistoryList) {
            paymentHistory.setCuser(cuser);
            this.save(paymentHistory);
        }

        //当前付款期间(后一个月)
        String paymentPeriodAfter = DateFormat.getAddDay(paymentPeriod, DateFormat.DEFAULT_MONTH, 1, "yyyyMM");
        purchaseCompanyPeriodService.updatePaymentPeriodByCompanyId(companyId, paymentPeriodAfter);

        return model;
    }

}
