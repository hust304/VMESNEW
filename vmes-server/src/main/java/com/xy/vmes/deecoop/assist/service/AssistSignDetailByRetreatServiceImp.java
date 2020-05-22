package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.assist.dao.AssistSignDetailByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistSignDetailByRetreatService;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
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
 * 说明：vmes_assist_sign_detail:外协签收明细 实现类
 * 外协-外协件退货-生成退货(成品退货)
 *
 * 创建时间：2020-05-12
 */
@Service
@Transactional(readOnly = false)
public class AssistSignDetailByRetreatServiceImp implements AssistSignDetailByRetreatService {
    @Autowired
    private AssistSignDetailByRetreatMapper signDetailByRetreatMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findAssistSignDetailByRetreat(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return signDetailByRetreatMapper.findAssistSignDetailByRetreat(pd);
        } else if (pg != null) {
            return signDetailByRetreatMapper.findAssistSignDetailByRetreat(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageAssistSignDetailByRetreat(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistSignDetailByRetreat");
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

        List<Map> varList = this.findAssistSignDetailByRetreat(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i=0; i < varList.size(); i++) {
                Map<String, Object> objectMap = varList.get(i);

                //maxRetreatCount 最大退货
                BigDecimal maxRetreatCount = BigDecimal.valueOf(0D);
                if (objectMap.get("maxRetreatCount") != null) {
                    maxRetreatCount = (BigDecimal)objectMap.get("maxRetreatCount");
                }
                //四舍五入到2位小数
                maxRetreatCount = maxRetreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("maxRetreatCount", maxRetreatCount);

                //editRetreatCount 本次退货数量
                objectMap.put("editRetreatCount", maxRetreatCount);
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
