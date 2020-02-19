package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByPurchasePlanMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByPurchasePlanService;
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
 * 说明：销售订单明细查询 实现类
 * 采购-采购计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-01-20
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByPurchasePlanServiceImp implements SaleOrderDetailByPurchasePlanService {
    @Autowired
    private SaleOrderDetailByPurchasePlanMapper orderDetailByPurchasePlanMapper;

    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiByPurchasePlan(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailByPurchasePlanMapper.listOrderDetaiByPurchasePlan(pd);
        } else if (pg != null) {
            return orderDetailByPurchasePlanMapper.listOrderDetaiByPurchasePlan(pd,pg);
        }

        return mapList;
    }

    public ResultModel listPageOrderDetaiByPurchasePlan(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByPurchasePlan");
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

        if (pd.getString("orderDtlIds") != null) {
            String orderDtlIds = pd.getString("orderDtlIds").toString().trim();
            if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
                orderDtlIds = StringUtil.stringTrimSpace(orderDtlIds);
                orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
                pd.put("orderDtlIds", orderDtlIds);
            }
        }

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

        List<Map> varList = this.listOrderDetaiByPurchasePlan(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);
                //purchasePlanCount 计划数量
                objectMap.put("purchasePlanCount", "0.00");

                //isNeedPurchase 是否需要采购(0:不需要 1:需要)
                String isNeedPurchase = new String("0");
                if (objectMap.get("isNeedPurchase") != null
                    && "0,1".indexOf(objectMap.get("isNeedPurchase").toString().trim()) != 0
                ) {
                    isNeedPurchase = objectMap.get("isNeedPurchase").toString().trim();
                }
                objectMap.put("isNeedPurchase", isNeedPurchase);
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}
