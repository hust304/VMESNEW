package com.xy.vmes.deecoop.assist.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderDetailByRetreatService;
import com.xy.vmes.service.ColumnService;
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
 * 说明：vmes_assist_order_detail:外协订单明细子表 实现类
 * 外协-外协件退货-生成退货(成品退货)
 * 外协-外协件报废-生成报废(成品报废)
 *
 * 创建时间：2020-05-12
 */
@Service
@Transactional(readOnly = false)
public class AssistOrderDetailByRetreatServiceImp implements AssistOrderDetailByRetreatService {
    @Autowired
    private AssistOrderDetailByRetreatMapper orderDetailByRetreatMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findAssistOrderDetailByRetreat(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailByRetreatMapper.findAssistOrderDetailByRetreat(pd);
        } else if (pg != null) {
            return orderDetailByRetreatMapper.findAssistOrderDetailByRetreat(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageAssistOrderDetailByRetreat(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailByRetreat");
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

        List<Map> varList = this.findAssistOrderDetailByRetreat(pd, pg);
        if (varList != null && varList.size() > 0) {
            //businessType 业务类型(retreat:外协退料 discard:外协报废)
            String businessType = pd.getString("businessType");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                //maxCount 最大(退料,报废)
                BigDecimal maxCount = BigDecimal.valueOf(0D);
                if (objectMap.get("maxCount") != null) {
                    maxCount = (BigDecimal)objectMap.get("maxCount");
                }
                //四舍五入到2位小数
                maxCount = maxCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //businessType 业务类型(retreat:外协退料 discard:外协报废)
                if ("retreat".equals(businessType)) {
                    //maxRetreatCount 最大退货数量
                    objectMap.put("maxRetreatCount", maxCount);
                    //editRetreatCount 本次退货数量
                    objectMap.put("editRetreatCount", maxCount);
                } else if ("discard".equals(businessType)) {
                    //maxDiscardCount 最大报废数量
                    objectMap.put("maxDiscardCount", maxCount);
                    //editDiscardCount 本次报废数量
                    objectMap.put("editDiscardCount", maxCount);
                }
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
