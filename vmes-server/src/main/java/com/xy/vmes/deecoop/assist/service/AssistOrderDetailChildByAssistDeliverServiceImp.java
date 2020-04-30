package com.xy.vmes.deecoop.assist.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailChildByAssistDeliverMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderDetailChildByAssistDeliverService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_order_detail_child:外协订单明细子表 实现类
 * 外协-发货管理-生成发货单 (订单明细中-生成发货单)
 * 创建人：陈刚
 * 创建时间：2020-04-19
 */
@Service
@Transactional(readOnly = false)
public class AssistOrderDetailChildByAssistDeliverServiceImp implements AssistOrderDetailChildByAssistDeliverService {
    @Autowired
    private AssistOrderDetailChildByAssistDeliverMapper orderDetailChildMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    public List<Map> findAssistOrderDetailChildByDeliver(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailChildMapper.findAssistOrderDetailChildByDeliver(pd);
        } else if (pg != null) {
            return orderDetailChildMapper.findAssistOrderDetailChildByDeliver(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageAssistOrderDetailChildByDeliver(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailChildByDeliver");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
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

        List<Map> varList = this.findAssistOrderDetailChildByDeliver(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);

                //maxDeliverCount 最大发货
                BigDecimal maxDeliverCount = BigDecimal.valueOf(0D);
                if (objectMap.get("maxDeliverCount") != null) {
                    maxDeliverCount = (BigDecimal)objectMap.get("maxDeliverCount");
                }
                //四舍五入到2位小数
                maxDeliverCount = maxDeliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //editDeliverCount 本次发货
                objectMap.put("editDeliverCount", maxDeliverCount);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public List<Map<String, Object>> checkAssistOrderDetailChildByDeliver(PageData pd) {
        return orderDetailChildMapper.checkAssistOrderDetailChildByDeliver(pd);
    }
}
