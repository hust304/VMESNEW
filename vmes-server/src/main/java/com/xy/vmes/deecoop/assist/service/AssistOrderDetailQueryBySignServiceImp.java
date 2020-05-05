package com.xy.vmes.deecoop.assist.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailQueryBySignMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderDetailQueryBySignService;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssistOrderDetailQueryBySignServiceImp implements AssistOrderDetailQueryBySignService {
    @Autowired
    private AssistOrderDetailQueryBySignMapper orderDetailQueryBySignMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map<String, Object>> findCheckAssistOrderDetaiBySign(PageData pd) {
        return orderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign(pd);
    }

    public List<Map> listAssistOrderDetaiQueryBySign(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailQueryBySignMapper.listAssistOrderDetaiQueryBySign(pd);
        } else if (pg != null) {
            return orderDetailQueryBySignMapper.listAssistOrderDetaiQueryBySign(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageAssistOrderDetaiQueryBySign(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailQueryBySign");
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

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.listAssistOrderDetaiQueryBySign(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }
}
