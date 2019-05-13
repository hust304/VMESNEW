package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.purchase.dao.PurchaseOrderDetailByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.PurchaseOrderDetailByRetreatService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class PurchaseOrderDetailByRetreatServiceImp implements PurchaseOrderDetailByRetreatService {
    @Autowired
    private PurchaseOrderDetailByRetreatMapper purchaseOrderDetailByRetreatMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findOrderDetailByRetreat(PageData pd) throws Exception {
        return purchaseOrderDetailByRetreatMapper.findOrderDetailByRetreat(pd);
    }
    public ResultModel listPageOrderDetailByRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("purchaseOrderDetailByRetreat");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pageData.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        List<Map> varList = this.findOrderDetailByRetreat(pageData);

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }
}
