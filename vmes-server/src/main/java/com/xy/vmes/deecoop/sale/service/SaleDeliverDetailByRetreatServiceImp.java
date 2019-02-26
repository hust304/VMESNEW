package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailByRetreatMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleDeliverDetailByRetreatService;
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

    public List<Map> findDeliverDetailByRetreat(PageData pageData) throws Exception {
        return saleDeliverDetailByRetreatMapper.findDeliverDetailByRetreat(pageData);
    }

    public ResultModel listPageDeliverDetailByRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleDeliverDetailByRetreat");
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

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

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
        pageData.put("orderStr", "detail.order_id asc,detail.cdate asc");
        String orderStr = pageData.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findDeliverDetailByRetreat(pageData);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}
