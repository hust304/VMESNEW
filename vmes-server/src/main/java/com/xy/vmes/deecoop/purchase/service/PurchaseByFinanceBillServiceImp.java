package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.finance.dao.FinanceBillByPurchaseMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.entity.PurchaseCompanyPeriod;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 说明：vmes_finance_bill:(采购)应付 实现类
 * 创建人：陈刚
 * 创建时间：2020-03-31
 */
@Service
@Transactional(readOnly = false)
public class PurchaseByFinanceBillServiceImp implements PurchaseByFinanceBillService {
    @Autowired
    private FinanceBillService financeBillService;
    @Autowired
    private FinanceBillByPurchaseMapper financeBillByPurchaseMapper;
    @Autowired
    private PurchaseCompanyPeriodService purchaseCompanyPeriodService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    public List<Map> findFinanceBillByPurchaseView(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBillByPurchaseMapper.findFinanceBillByPurchaseView(pd);
        } else if (pg != null) {
            return financeBillByPurchaseMapper.findFinanceBillByPurchaseView(pd, pg);
        }

        return mapList;
    }

    public List<Map> findFinanceBillDetailByPurchase(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return financeBillByPurchaseMapper.findFinanceBillDetailByPurchase(pd);
        } else if (pg != null) {
            return financeBillByPurchaseMapper.findFinanceBillDetailByPurchase(pd, pg);
        }

        return mapList;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ResultModel listPagePurchaseByFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("purchaseByFinanceBill");
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

        if (pd.getString("inTypes") != null && pd.getString("inTypes").trim().length() > 0) {
            String inTypes = pd.getString("inTypes").trim();
            inTypes = StringUtil.stringTrimSpace(inTypes);
            inTypes = "'" + inTypes.replace(",", "','") + "'";
            pd.put("inTypes", inTypes);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = financeBillService.getDataListPage(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel listPageFinanceBillByPurchaseView(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("financeBillByPurchaseView");
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

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        pd.put("companyId", companyId);

        //系统时间(yyyymm)
        String sysMonthStr = DateFormat.date2String(new Date(), "yyyyMM");
        //查询付款期
        String queryPeriod = sysMonthStr;

        //paymentPeriod:当前付款期(yyyymm)
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        PurchaseCompanyPeriod companyPeriod = purchaseCompanyPeriodService.findPurchaseCompanyPeriod(findMap);
        if (companyPeriod != null && companyPeriod.getPaymentPeriod() != null) {
            queryPeriod = companyPeriod.getPaymentPeriod();
        }

        Map<String, String> periodMap = this.findQueryPeriodMap(queryPeriod);
        if (periodMap != null && periodMap.size() > 0) {
            pd.put("period", periodMap.get("period"));
            pd.put("forePeriod", periodMap.get("forePeriod"));
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.findFinanceBillByPurchaseView(pd, pg);
        this.modifyCheckOutFinanceBillByPurchase(varList, queryPeriod);

        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel listPageFinanceBillDetailByPurchase(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("financeBillDetailByPurchase");
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

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        pd.put("companyId", companyId);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        String period = pd.getString("period");
        Map<String, String> periodMap = this.findQueryPeriodMap(period);
        if (periodMap != null && periodMap.size() > 0) {
            pd.put("period", periodMap.get("period"));
            pd.put("forePeriod", periodMap.get("forePeriod"));
        }

        List<Map> varList = this.findFinanceBillDetailByPurchase(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //queryType:history
                String queryType = (String)mapObject.get("queryType");
                if ("history".equals(queryType)) {
                    //amount 库存数量
                    BigDecimal amount = BigDecimal.valueOf(0D);
                    if (mapObject.get("amount") != null) {
                        amount = (BigDecimal)mapObject.get("amount");
                    }
                    //四舍五入到2位小数
                    amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                    if (amount.doubleValue() >= 0) {
                        mapObject.put("paymentAmount", amount);
                    } else if (amount.doubleValue() < 0) {
                        BigDecimal occurAmount = BigDecimal.valueOf(amount.doubleValue() * -1);
                        mapObject.put("occurAmount", occurAmount);
                    }
                }
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    /**
     * 根据查询期间(yyyyMM)获取采购应付查询功能查询条件
     * 返回值Map:
     *   period: 当前期间(yyyyMM)
     *   forePeriod: 当前期间(yyyyMM) -1 个月
     *
     * @param queryPeriod
     * @return
     */
    public Map<String, String> findQueryPeriodMap(String queryPeriod) throws ParseException {
        Map<String, String> queryPeriodMap = new HashMap<>();

        if (queryPeriod != null && queryPeriod.trim().length() > 0) {
            //当前期间
            queryPeriodMap.put("period", queryPeriod);

            //当前期间(yyyyMM) -1 个月
            String forePeriod = DateFormat.getAddDay(queryPeriod, DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
            queryPeriodMap.put("forePeriod", forePeriod);
        }

        return queryPeriodMap;
    }

    public void modifyCheckOutFinanceBillByPurchase(List<Map> queryList, String period) {
        if (queryList == null || queryList.size() == 0) {return;}

        for (Map<String, Object> mapData : queryList) {
            //beginValue 期初值
            BigDecimal beginValue = BigDecimal.valueOf(0D);

            //defaultBeginValue 期初默认值
            BigDecimal defaultBeginValue = BigDecimal.valueOf(-1);
            if (mapData.get("defaultBeginValue") != null) {
                defaultBeginValue = (BigDecimal)mapData.get("defaultBeginValue");
            }

            if (defaultBeginValue.doubleValue() != -1) {
                beginValue = defaultBeginValue;
            } else if (defaultBeginValue.doubleValue() == -1) {
                //historyBeginValue 期初值(上期期末)
                BigDecimal historyBeginValue = BigDecimal.valueOf(-1);
                if (mapData.get("historyBeginValue") != null) {
                    historyBeginValue = (BigDecimal)mapData.get("historyBeginValue");
                }
                if (historyBeginValue.doubleValue() != -1) {
                    beginValue = historyBeginValue;
                }
            }

            //四舍五入到2位小数
            beginValue = beginValue.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            mapData.put("beginValue", beginValue);

            //beginPlus 期初应付 期初值(正数)
            //beginMinus 期初预付 期初值(负数)
            if (beginValue.doubleValue() >= 0) {
                mapData.put("beginPlus", beginValue);
                mapData.put("beginMinus", "0.00");
            } else if (beginValue.doubleValue() < 0) {
                mapData.put("beginPlus", "0.00");
                mapData.put("beginMinus", BigDecimal.valueOf(beginValue.doubleValue() * -1));
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //nowPlus 本期发生
            BigDecimal nowPlus = BigDecimal.valueOf(0D);
            if (mapData.get("nowPlus") != null) {
                nowPlus = (BigDecimal)mapData.get("nowPlus");
            }

            //nowMinus 本期付款
            BigDecimal nowMinus = BigDecimal.valueOf(0D);
            if (mapData.get("nowMinus") != null) {
                nowMinus = (BigDecimal)mapData.get("nowMinus");
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //endValue 期末值:= 期初值 + 本期发生 - 本期付款
            BigDecimal endValue = BigDecimal.valueOf(beginValue.doubleValue() + nowPlus.doubleValue() - nowMinus.doubleValue());
            endValue = endValue.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            mapData.put("endValue", endValue);

            //endPlus 当前应付 期末值(正数)
            //endMinus 当前预付 期末值(负数)
            if (endValue.doubleValue() >= 0) {
                mapData.put("endPlus", endValue);
                mapData.put("endMinus", "0.00");
            } else if (endValue.doubleValue() < 0) {
                mapData.put("endMinus", BigDecimal.valueOf(endValue.doubleValue() * -1));
                mapData.put("endPlus", "0.00");
            }

            //period 期间
            mapData.put("period", period);
        }
    }

    /**
     *
     * @param businessId  业务单据id
     * @param companyId   企业id
     * @param customerId  客户id
     * @param userId      用户id
     * @param type        付款单类型(vmes_finance_bill.type)
     * @param attribute   付款单属性(vmes_finance_bill.attribute)
     * @param amount
     * @throws Exception
     */
    public void addFinanceBillByPurchase(String businessId,
                                         String companyId,
                                         String customerId,
                                         String userId,
                                         String type,
                                         String state,
                                         String attribute,
                                         BigDecimal amount,
                                         String remark) throws Exception {
        FinanceBill addObject = new FinanceBill();
        addObject.setCompanyId(companyId);
        addObject.setCustomerId(customerId);
        addObject.setBusinessId(businessId);

        addObject.setCuser(userId);
        //type 单据类型 ( 0:收款单 1:付款单 2:减免单 3:退款单 4:发货账单 5:发退货账单 6:收货账单 7:收退货账单)
        addObject.setType(type);
        //amount 金额
        if (amount != null) {
            addObject.setAmount(amount);
        }

        //付款单属性(vmes_finance_bill.attribute) 反拉业务单据使用
        if (attribute != null && attribute.trim().length() > 0) {
            addObject.setAttribute(attribute);
        }

        //state 状态(0：待提交 1：待审核 2：已审核 -1：已取消)
        addObject.setState(state);

        //sdate 审核时间
        if ("2".equals(state)) {
            addObject.setSdate(new Date());
            //suser 审核用户id
            addObject.setSuser(userId);
        }

        addObject.setRemark(remark);
        //生成付款单编码
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyId,"finance_bill_purchase","R", Common.CODE_RULE_LENGTH_3);
        addObject.setCode(code);

        //period 收/付款期间(yyyyMM)
        String period = DateFormat.date2String(new Date(), "yyyyMM");
        addObject.setPeriod(period);

        financeBillService.save(addObject);
    }

}
