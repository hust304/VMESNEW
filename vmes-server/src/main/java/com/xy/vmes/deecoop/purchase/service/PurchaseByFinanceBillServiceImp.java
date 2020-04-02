package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.finance.dao.FinanceBillMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.FinanceBill;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.FinanceBillService;
import com.xy.vmes.service.PurchaseByFinanceBillService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

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
