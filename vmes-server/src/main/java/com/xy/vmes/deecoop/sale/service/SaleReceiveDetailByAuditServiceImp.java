package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveDetailByAuditMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleReceiveDetailByAuditService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleReceiveDetailByAuditServiceImp implements SaleReceiveDetailByAuditService {
    @Autowired
    private SaleReceiveDetailByAuditMapper saleReceiveDetailByAuditMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findReceiveDetailMapList(PageData pd, Pagination pg) {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleReceiveDetailByAuditMapper.findReceiveDetailMapList(pd);
        } else if (pg != null) {
            return saleReceiveDetailByAuditMapper.findReceiveDetailMapList(pd,pg);
        }

        return mapList;
    }

    public List<Map> findReceiveDetailMapList(PageData pd) throws Exception {
        return saleReceiveDetailByAuditMapper.findReceiveDetailMapList(pd);
    }

    public ResultModel findListSaleReceiveDetailByByAudit(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleReceiveDetailByAudit");
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

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.findReceiveDetailMapList(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }
}
