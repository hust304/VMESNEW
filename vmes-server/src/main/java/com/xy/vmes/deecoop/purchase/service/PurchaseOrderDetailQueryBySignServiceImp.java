package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.purchase.dao.PurchaseOrderDetailQueryBySignMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.PurchaseOrderDetailQueryBySignService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：采购订单明细查询汇总 实现类
 * 采购-采购收货-生成收货单-收货-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2019-12-31
 */
@Service
@Transactional(readOnly = false)
public class PurchaseOrderDetailQueryBySignServiceImp implements PurchaseOrderDetailQueryBySignService {
    @Autowired
    private PurchaseOrderDetailQueryBySignMapper orderDetailQueryBySignMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiQueryBySign(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailQueryBySignMapper.listOrderDetaiQueryBySign(pd);
        } else if (pg != null) {
            return orderDetailQueryBySignMapper.listOrderDetaiQueryBySign(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageOrderDetailQueryBySign(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("purchaseOrderDetailQueryBySign");
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

        List<Map> varList = this.listOrderDetaiQueryBySign(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }
}
