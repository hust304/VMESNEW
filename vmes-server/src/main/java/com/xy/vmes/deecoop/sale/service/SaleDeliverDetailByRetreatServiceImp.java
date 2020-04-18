package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleDeliverDetailByRetreatService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleDeliverDetailByRetreatServiceImp implements SaleDeliverDetailByRetreatService {
    @Autowired
    private SaleDeliverDetailByRetreatMapper saleDeliverDetailByRetreatMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    public List<Map> findDeliverDetailByRetreat(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleDeliverDetailByRetreatMapper.findDeliverDetailByRetreat(pd);
        } else if (pg != null) {
            return saleDeliverDetailByRetreatMapper.findDeliverDetailByRetreat(pd,pg);
        }

        return mapList;
    }

    public ResultModel listPageDeliverDetailByRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pageData);

        List<Column> columnList = columnService.findColumnList("saleDeliverDetailByRetreat");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pageData.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pageData.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pageData.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //获取订单ID参数
        String deliverDtlIds = pageData.getString("deliverDtlIds");
        if (deliverDtlIds == null || deliverDtlIds.trim().length() == 0) {
            pageData.put("queryStr", "1=2");
        } else {
            deliverDtlIds = StringUtil.stringTrimSpace(deliverDtlIds);
            deliverDtlIds = "'" + deliverDtlIds.replace(",", "','") + "'";
            pageData.put("ids", deliverDtlIds);
        }

        //设置查询排序
        pageData.put("orderStr", "detail.order_id,detail.parent_id,detail.product_id");
        String orderStr = pageData.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pageData.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.findDeliverDetailByRetreat(pageData, pg);
        if(varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pageData.getString("prodColumnKey");
            for (Map<String, Object> mapObject : varList) {
                //货品信息
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}
