package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.finance.dao.FinanceBillMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.FinanceBillService;
import com.xy.vmes.service.PurchaseByFinanceBillService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ResultModel listPagePurchaseByFinanceBill(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("FinanceBill");
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

}
