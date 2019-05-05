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

import java.math.BigDecimal;
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
    public List<Map> findListPurchasePaymentHistoryByPaymentPeriod(PageData pd) throws Exception {
        return purchasePaymentHistoryMapper.findListPurchasePaymentHistoryByPaymentPeriod(pd);
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

    public void deletePurchasePaymentHistory(String companyId, String paymentPeriod) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        pageData.put("paymentPeriod", paymentPeriod);
        purchasePaymentHistoryMapper.deleteTableByCompanyId(pageData);
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
        if (companyPeriod == null || companyPeriod.getInitialPeriod() == null || companyPeriod.getInitialPeriod().trim().length() == 0) {
            model.putCode("1");
            model.putMsg("您所在的企业无初始付款期间，请在(采购-基础-设定首次付款期间)设定，与企业管理员联系！");
            return model;
        }

        String paymentPeriod = companyPeriod.getPaymentPeriod();
        pd.put("dateByNow", paymentPeriod);

        //当前付款期(前一个月)
        String dateByBefore = DateFormat.getAddDay(paymentPeriod, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
        pd.put("dateByBefore", dateByBefore);
        pd.put("paymentPeriod", paymentPeriod);

        String periodType_str = pd.getString("periodType");
        if ("history".equals(periodType_str)) {
            pd.put("paymentPeriod", null);

            String beginDate = "";
            if (pd.getString("beginDate") != null && pd.getString("beginDate").trim().length() > 0) {
                beginDate = pd.getString("beginDate").trim();
                Date beginDate_date = DateFormat.dateString2Date(beginDate + "-01", DateFormat.DEFAULT_DATE_FORMAT);
                String beginDate_str = DateFormat.date2String(beginDate_date, "yyyyMM");
                if (beginDate_str != null && beginDate_str.trim().length() > 0) {
                    beginDate = beginDate_str;
                }
            }
            pd.put("beginDate", beginDate);

            String endDate = "";
            if (pd.getString("endDate") != null && pd.getString("endDate").trim().length() > 0) {
                endDate = pd.getString("endDate").trim();
                Date endDate_date = DateFormat.dateString2Date(endDate + "-01", DateFormat.DEFAULT_DATE_FORMAT);
                String endDate_str = DateFormat.date2String(endDate_date, "yyyyMM");
                if (endDate_str != null && endDate_str.trim().length() > 0) {
                    endDate = endDate_str;
                }
            }
            pd.put("endDate", endDate);
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.findListPurchasePaymentHistoryByPaymentPeriod(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        //遍历查询结果集
        for (Map<String, String> mapObject : varMapList) {
            //periodType 付款结转类型('paymentPeriod':当前付款期间 'history':结转历史数据)
            String periodType = mapObject.get("periodType");
            if (periodType == null || "history".equals(periodType)) {continue;}

            //isPaymentBuild 是否设定供应商付款初期值(vmes_purchase_payment_build)(Y:已设定 N:未设定)
            String isPaymentBuild = mapObject.get("isPaymentBuild");
            if ("Y".equals(isPaymentBuild)) {
                String buildBeginValue_str = mapObject.get("buildBeginValue");

                BigDecimal buildBeginValue_Big = BigDecimal.valueOf(0D);
                if (buildBeginValue_str != null && buildBeginValue_str.trim().length() > 0) {
                    try {
                        buildBeginValue_Big = new BigDecimal(buildBeginValue_str);
                        //四舍五入到2位小数
                        buildBeginValue_Big = buildBeginValue_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    if (buildBeginValue_Big.doubleValue() > 0) {
                        //beginPlus 应付款(期初)
                        mapObject.put("beginPlus", buildBeginValue_Big.toString());
                    } else if (buildBeginValue_Big.doubleValue() < 0) {
                        //beginMinus 预付款(期初)
                        buildBeginValue_Big = BigDecimal.valueOf(buildBeginValue_Big.doubleValue() * -1);
                        mapObject.put("beginMinus", buildBeginValue_Big.toString());
                    }
                }

                //nowOrderSum 采购订单金额(本期)
                String nowOrderSum_str = mapObject.get("nowOrderSum");
                BigDecimal nowOrderSum_Big = BigDecimal.valueOf(0D);
                if (nowOrderSum_str != null && nowOrderSum_str.trim().length() > 0) {
                    try {
                        nowOrderSum_Big = new BigDecimal(nowOrderSum_str);
                        //四舍五入到2位小数
                        nowOrderSum_Big = nowOrderSum_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //nowPaymentSum 付款金额(本期)
                String nowPaymentSum_str = mapObject.get("nowPaymentSum");
                BigDecimal nowPaymentSum_Big = BigDecimal.valueOf(0D);
                if (nowPaymentSum_str != null && nowPaymentSum_str.trim().length() > 0) {
                    try {
                        nowPaymentSum_Big = new BigDecimal(nowPaymentSum_str);
                        //四舍五入到2位小数
                        nowPaymentSum_Big = nowPaymentSum_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                //endValue 付款值(期末) := (本期)订单金额 - (本期)付款 + (初期)应付款-(初期)预付款
                BigDecimal endValue_Big = BigDecimal.valueOf(nowOrderSum_Big.doubleValue() - nowPaymentSum_Big.doubleValue() + buildBeginValue_Big.doubleValue());
                //四舍五入到2位小数
                endValue_Big = endValue_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                mapObject.put("endValue", endValue_Big.toString());
            }


            //endValue 付款值(期末)
            String endValue_str = mapObject.get("endValue");
            BigDecimal endValue_Big = BigDecimal.valueOf(0D);
            if (endValue_str != null && endValue_str.trim().length() > 0) {
                try {
                    endValue_Big = new BigDecimal(endValue_str);
                    //四舍五入到2位小数
                    endValue_Big = endValue_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                //endPlus 应付款(期末)
                mapObject.put("endPlus", "0.00");
                //endMinus 预付款(期末)
                mapObject.put("endMinus", "0.00");
                if (endValue_Big.doubleValue() > 0) {
                    //endPlus 应付款(期末)
                    mapObject.put("endPlus", endValue_Big.toString());
                } else if (endValue_Big.doubleValue() < 0) {
                    endValue_Big = BigDecimal.valueOf(endValue_Big.doubleValue() * -1);
                    //四舍五入到2位小数
                    endValue_Big = endValue_Big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    //endMinus 预付款(期末)
                    mapObject.put("endMinus", endValue_Big.toString());
                }
            }
        }

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
            model.putMsg("您所在的企业无当前付款期间，请在(采购-基础-设定首次付款期间)设定，与企业管理员联系！");
            return model;
        }
        String paymentPeriod = companyPeriod.getPaymentPeriod();

        String listJsonStr = pageData.getString("listJsonStr");
//        if (listJsonStr == null || listJsonStr.trim().length() == 0) {
//            String remark = "备注：是否设定供应商付款初期值，如果未设定请与企业管理员联系！";
//            String msgTemp = "您所在的企业当前付款期间({0})无供应商！" + Common.SYS_ENDLINE_DEFAULT + remark + Common.SYS_ENDLINE_DEFAULT;
//
//            String msgStr = MessageFormat.format(msgTemp, paymentPeriod);
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

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

    public ResultModel backPurchasePaymentHistory(PageData pageData) throws Exception {
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
            model.putMsg("您所在的企业无当前付款期间，请在(采购-基础-设定首次付款期间)设定，与企业管理员联系！");
            return model;
        }
        String paymentPeriod = companyPeriod.getPaymentPeriod();

        //当前付款期间(前一个月)
        String paymentPeriodBefore = DateFormat.getAddDay(paymentPeriod, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");

        //删除结转历史数据-(企业id,当前付款期间)
        this.deletePurchasePaymentHistory(companyId, paymentPeriodBefore);

        purchaseCompanyPeriodService.updatePaymentPeriodByCompanyId(companyId, paymentPeriodBefore);

        return model;
    }

}
