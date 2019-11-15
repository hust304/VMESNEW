package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.service.WarehouseProductExcelByWcService;
import com.yvan.common.util.Common;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class WarehouseProductExcelByWcServiceImp implements WarehouseProductExcelByWcService {
    /**
     * 导入字段非空判断-(id)列非空判断
     * 第一列(id)为空:被视为非法行
     * 导入前置条件: 财务-库存查询-导出(按钮) 导出的Excel文件
     *
     * @param objectList
     * @return
     */
    public String checkColumnByIdImportExcel(List<LinkedHashMap<String, String>> objectList) {
        StringBuffer strBuf = new StringBuffer();

        List<Map<String, String>> dataList = new ArrayList<>();
        for (Map<String, String> mapObject : objectList) {
            //id 第一列(id)隐藏列
            String id = mapObject.get("id");
            if (id != null && id.trim().length() > 0) {
                dataList.add(mapObject);
            }
        }

        if (dataList.size() < objectList.size()) {
            strBuf.append("该导入文件非法含有异常行数据，请先(财务-库存查询-导出按钮)执行Excel导出！");
        }

        return strBuf.toString();
    }

    /**
     * 导入字段非空判断-(单价)非空判断-(单价)数字判断
     * @param objectList
     * @param index
     * @param maxShowRow
     * @return
     */
    public String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  Integer index,
                                  Integer maxShowRow) {
        StringBuffer strBuf = new StringBuffer();

        int index_int = 1;
        if (index != null) {
            index_int = index.intValue();
        }

        int maxShowRow_int = 20;
        if (maxShowRow != null) {
            maxShowRow_int = maxShowRow.intValue();
        }

        //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的2位小数)！" + Common.SYS_ENDLINE_DEFAULT;

        int maxRow = 0;
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //price 单价
            String price = mapObject.get("price");
            if (price != null && price.trim().length() > 0) {
                price = price.trim();
                try {
                    //全数字
                    BigDecimal bigDecimal = new BigDecimal(price);
                    //四舍五入到2位小数
                    bigDecimal = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    mapObject.put("price", bigDecimal.toString());

                } catch (NumberFormatException e) {
                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                    String str_error = MessageFormat.format(msg_column_error,
                            (i+index_int),
                            "单价",
                            price);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                }
            }
        }

        return strBuf.toString();
    }
}
