package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByChangeMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByChangeService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByChangeServiceImp implements SaleOrderDetailByChangeService {
    @Autowired
    private SaleOrderDetailByChangeMapper saleOrderDetailByChangeMapper;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

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

        //设置查询排序
        String orderStr = pageData.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr);
        }

        List<Map> varList = this.listOrderDetaiByChange(pageData);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pageData.getString("prodColumnKey");
            for (Map<String, Object> mapObject : varList) {
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }
}
