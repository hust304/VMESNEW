package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.sale.dao.SaleRetreatDetailByEditMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleRetreatDetailByEditService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleRetreatDetailByEditServiceImp implements SaleRetreatDetailByEditService {
    @Autowired
    private SaleRetreatDetailByEditMapper saleRetreatDetailByEditMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findRetreatDetailByEdit(PageData pageData) throws Exception {
        return saleRetreatDetailByEditMapper.findRetreatDetailByEdit(pageData);
    }

    public ResultModel listPageRetreatDetailByEdit(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleRetreatDetailByEdit");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //设置查询排序
        pageData.put("orderStr", "saleOrder.sys_code,deliver.deliver_code,detail.product_id");
        String orderStr = pageData.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pageData.put("orderStr", orderStr);
        }

        List<Map> varList = this.findRetreatDetailByEdit(pageData);
        for (Map<String, Object> mapObj : varList) {
            //receiveAmount 实收金额
            BigDecimal receiveAmount = BigDecimal.valueOf(0D);
            if (mapObj.get("receiveAmount") != null) {
                receiveAmount = (BigDecimal)mapObj.get("receiveAmount");
            }
            //四舍五入到2位小数
            receiveAmount = receiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            mapObj.put("receiveAmount", receiveAmount.toString());

            //orderSum 退货金额
            BigDecimal orderSum = BigDecimal.valueOf(0D);
            if (mapObj.get("orderSum") != null) {
                orderSum = (BigDecimal)mapObj.get("orderSum");
            }
            //四舍五入到2位小数
            orderSum = orderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //(实收金额 <= 退货金额) 退货金额 := 实收金额
            //(实收金额 > 退货金额) 退货金额 := 退货金额
            if (receiveAmount.doubleValue() <= orderSum.doubleValue()) {
                //(实收金额 <= 退货金额) 退货金额 := 实收金额
                mapObj.put("orderSum", receiveAmount.toString());
            } else if (receiveAmount.doubleValue() > orderSum.doubleValue()) {
                //(实收金额 > 退货金额) 退货金额 := 退货金额
                mapObj.put("orderSum", orderSum.toString());
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
