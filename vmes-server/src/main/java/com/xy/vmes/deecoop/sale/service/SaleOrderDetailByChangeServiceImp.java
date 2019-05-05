package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByChangeMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByChangeService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByChangeServiceImp implements SaleOrderDetailByChangeService {
    @Autowired
    private SaleOrderDetailByChangeMapper saleOrderDetailByChangeMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiByChange(PageData pd) throws Exception {
        return saleOrderDetailByChangeMapper.listOrderDetaiByChange(pd);
    }

    public ResultModel listPageOrderDetaiByChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByChange");
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

        //设置查询排序
        pageData.put("orderStr", "orderDtl.cdate asc");
        String orderStr = pageData.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.listOrderDetaiByChange(pageData);
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

        for (Map<String, String> mapObject : varMapList) {
            //计价类型(1:先计价 2:后计价)
            String priceType = mapObject.get("priceType");
            if ("2".equals(priceType)) {
                BigDecimal prod_productPrice = BigDecimal.valueOf(0D);
                String prod_productPrice_str = mapObject.get("prod_productPrice");
                if (prod_productPrice_str != null && prod_productPrice_str.trim().length() > 0) {
                    try {
                        prod_productPrice = new BigDecimal(prod_productPrice_str);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                prod_productPrice = prod_productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                mapObject.put("productPrice", prod_productPrice.toString());
            }
        }

        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }
}
