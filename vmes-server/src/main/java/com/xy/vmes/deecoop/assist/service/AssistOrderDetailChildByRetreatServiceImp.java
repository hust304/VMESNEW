package com.xy.vmes.deecoop.assist.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailChildByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderDetailChildByRetreatService;
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

@Service
@Transactional(readOnly = false)
public class AssistOrderDetailChildByRetreatServiceImp implements AssistOrderDetailChildByRetreatService {
    @Autowired
    private AssistOrderDetailChildByRetreatMapper orderDetailChildMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    public List<Map> findAssistOrderDetailChildByRetreat(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailChildMapper.findAssistOrderDetailChildByRetreat(pd);
        } else if (pg != null) {
            return orderDetailChildMapper.findAssistOrderDetailChildByRetreat(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageAssistOrderDetailChildByRetreat(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailChildByRetreat");
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

        List<Map> varList = this.findAssistOrderDetailChildByRetreat(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");
            //businessType 业务类型(retreat:外协退料 discard:外协报废)
            String businessType = pd.getString("businessType");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);

                //deliverCount 发货数
                BigDecimal deliverCount = BigDecimal.valueOf(0D);
                if (objectMap.get("deliverCount") != null) {
                    deliverCount = (BigDecimal)objectMap.get("deliverCount");
                }
                //四舍五入到2位小数
                deliverCount = deliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //signCount 签收数
                BigDecimal signCount = BigDecimal.valueOf(0D);
                if (objectMap.get("signCount") != null) {
                    signCount = (BigDecimal)objectMap.get("signCount");
                }
                //四舍五入到2位小数
                signCount = signCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //retreatUserCount 退货数
                BigDecimal retreatUserCount = BigDecimal.valueOf(0D);
                if (objectMap.get("retreatUserCount") != null) {
                    retreatUserCount = (BigDecimal)objectMap.get("retreatUserCount");
                }
                //四舍五入到2位小数
                retreatUserCount = retreatUserCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //retreatCount 退料数
                BigDecimal retreatCount = BigDecimal.valueOf(0D);
                if (objectMap.get("retreatCount") != null) {
                    retreatCount = (BigDecimal)objectMap.get("retreatCount");
                }
                //四舍五入到2位小数
                retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //discardCount 报废数
                BigDecimal discardCount = BigDecimal.valueOf(0D);
                if (objectMap.get("discardCount") != null) {
                    discardCount = (BigDecimal)objectMap.get("discardCount");
                }
                //四舍五入到2位小数
                discardCount = discardCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //maxCount 最大(退料,报废): 发货数 - (签收数 + 退货数 + 退料数 + 报废数)
                BigDecimal maxCount = BigDecimal.valueOf(deliverCount.doubleValue() - (signCount.doubleValue() + retreatUserCount.doubleValue() + retreatCount.doubleValue() + discardCount.doubleValue()));
                if (maxCount.doubleValue() < 0) {
                    maxCount = BigDecimal.valueOf(0D);
                }
                //四舍五入到2位小数
                maxCount = maxCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //businessType 业务类型(retreat:外协退料 discard:外协报废)
                if ("retreat".equals(businessType)) {
                    //maxRetreatCount 最大退料数量
                    objectMap.put("maxRetreatCount", maxCount);
                    //editRetreatCount 本次退料数量
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
