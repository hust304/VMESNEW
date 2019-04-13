package com.xy.vmes.deecoop.base.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.service.BomExcelService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BomExcelServiceImp implements BomExcelService {
    public String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  String userId,
                                  Integer index,
                                  Integer maxShowRow) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        int maxRow = 0;
        int index_int = 1;
        if (index != null) {
            index_int = index.intValue();
        }

        int maxShowRow_int = 20;
        if (maxShowRow != null) {
            maxShowRow_int = maxShowRow.intValue();
        }

        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！" + Common.SYS_ENDLINE_DEFAULT;

        String msg_name_isnull_1 = "第 {0} 行: ({1})输入为空或空字符串，({2})请至少输入一项！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_name_isnull_2 = "第 {0} 行: ({1})输入错误，({2})输入为空或空字符串，({2})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //companyId 企业ID
            mapObject.put("companyId", companyId);
            mapObject.put("userId", userId);

            //bomCode BOM编码
            String bomCode = mapObject.get("bomCode");
            if (bomCode == null || bomCode.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "BOM编码");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //bomName BOM名称
            String bomName = mapObject.get("bomName");
            if (bomName == null || bomName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "BOM名称");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //prodCode 货品编码
            String prodCode = mapObject.get("prodCode");
            if (prodCode == null || prodCode.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "货品编码");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //ratio 用料比例
            String ratio = mapObject.get("ratio");
            if (ratio == null || ratio.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "用料比例");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if (ratio != null && ratio.trim().length() > 0) {
                try {
                    BigDecimal ratio_big = new BigDecimal(ratio);
                    if (ratio_big.doubleValue() <= 0D) {
                        //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                        String str_error = MessageFormat.format(msg_column_price_error,
                                (i + index_int),
                                "用料比例",
                                ratio);
                        strBuf.append(str_error);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {
                            return strBuf.toString();
                        }
                    } else {
                        //ratio 用料比例 四舍五入到2位小数
                        ratio_big = ratio_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        mapObject.put("ratio", ratio_big.toString());
                    }
                } catch (NumberFormatException e) {
                    //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                    String str_error = MessageFormat.format(msg_column_price_error,
                            (i + index_int),
                            "用料比例",
                            ratio);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {
                        return strBuf.toString();
                    }
                }
            }

            //prodCode_1 一级货品编码
            String prodCode_1 = mapObject.get("prodCode_1");
            //prodCode_2 二级货品编码
            String prodCode_2 = mapObject.get("prodCode_2");
            //prodCode_3 三级货品编码
            String prodCode_3 = mapObject.get("prodCode_3");

            //一级货品编码 二级货品编码 三级货品编码 共有8种组合
            //下面三种情况是允许的
            //一级货品编码(非空) 二级货品编码(空) 三级货品编码(空)
            //一级货品编码(非空) 二级货品编码(非空) 三级货品编码(空)
            //一级货品编码(非空) 二级货品编码(非空) 三级货品编码(非空)

            //下面5种情况是异常非空判断
            if((prodCode_1 == null || prodCode_1.trim().length() == 0)
                    && (prodCode_2 == null || prodCode_2.trim().length() == 0)
                    && (prodCode_3 == null || prodCode_3.trim().length() == 0)
                    ) {
                //String msg_name_isnull_1 = "第 {0} 行: ({1})输入为空或空字符串，({2})请至少输入一项！"
                String str_isnull = MessageFormat.format(msg_name_isnull_1,
                        (i+index_int),
                        "BOM关联货品编码",
                        "一级货品编码,二级货品编码,三级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
            } else if ((prodCode_1 == null || prodCode_1.trim().length() == 0)
                    && (prodCode_2 == null || prodCode_2.trim().length() == 0)
                    && (prodCode_3 != null && prodCode_3.trim().length() > 0)
                    ) {
                //(2)一级货品编码(空) 二级货品编码(空) 三级货品编码(非空)
                //第 {0} 行: (BOM关联货品编码)输入错误，(一级货品编码,二级货品编码)输入为空或空字符串，(一级货品编码,二级货品编码)是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_name_isnull_2,
                        (i+index_int),
                        "BOM关联货品编码",
                        "一级货品编码,二级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if((prodCode_1 == null || prodCode_1.trim().length() == 0)
                    && (prodCode_2 != null && prodCode_2.trim().length() > 0)
                    ) {
                String str_isnull = MessageFormat.format(msg_name_isnull_2,
                        (i+index_int),
                        "BOM关联货品编码",
                        "一级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if((prodCode_1 != null && prodCode_1.trim().length() > 0)
                    && (prodCode_2 == null || prodCode_2.trim().length() == 0)
                    && (prodCode_3 != null && prodCode_3.trim().length() > 0)
                    ) {
                //(5)一级货品编码(空) 二级货品编码(非空) 三级货品编码(空)
                //第 {0} 行: (BOM关联货品编码)输入错误，(二级货品编码)输入为空或空字符串，(二级货品编码)是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_name_isnull_2,
                        (i+index_int),
                        "部门名称",
                        "二级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //remark 备注
        }

        return strBuf.toString();
    }

    public String checkExistImportExcelBySelf(List<LinkedHashMap<String, String>> objectList,
                                              Integer index,
                                              Integer maxShowRow) {
        return null;
    }

    public String checkExistImportExcelByDatabase(List<LinkedHashMap<String, String>> objectList,
                                                  Integer index,
                                                  Integer maxShowRow) {
        return null;
    }

    public void addImportExcelByList(List<LinkedHashMap<String, String>> objectList) {
        if (objectList == null || objectList.size() == 0) {return;}

        for (int i = 0; i < objectList.size(); i++) {

            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //bomCode BOM编码
            //bomName BOM名称
            //prodCode 货品编码
            //ratio 用料比例
            //prodCode_1 一级货品编码
            //prodCode_2 二级货品编码
            //prodCode_3 三级货品编码
            //remark 备注






        }
    }
}
