package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.annotations.TableField;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Bom;
import com.xy.vmes.entity.Product;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
public class BomExcelServiceImp implements BomExcelService {
    @Autowired
    private ProductService productService;
    @Autowired
    private BomService bomService;
    @Autowired
    private BomTreeService bomTreeService;
    @Autowired
    private CoderuleService coderuleService;

    private String separator = ",";
    private Map<String, String> prodCodeKeyMap;

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

        String msg_ratio_isnull = "第 {0} 行: ({1})输入为空或空字符串，当填写({2})是，({3})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //获取当前企业全部<货品编码, 货品id>Map
        this.finalProdCodeKeyMapByCompanyId(companyId);
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //companyId 企业ID
            mapObject.put("companyId", companyId);
            mapObject.put("userId", userId);

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

//            //ratio 用料比例
//            String ratio = mapObject.get("ratio");
//            if (ratio == null || ratio.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "用料比例");
//                strBuf.append(str_isnull);
//
//                maxRow = maxRow + 1;
//                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//            } else if (ratio != null && ratio.trim().length() > 0) {
//                try {
//                    BigDecimal ratio_big = new BigDecimal(ratio);
//                    if (ratio_big.doubleValue() <= 0D) {
//                        //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
//                        String str_error = MessageFormat.format(msg_column_price_error,
//                                (i + index_int),
//                                "用料比例",
//                                ratio);
//                        strBuf.append(str_error);
//
//                        maxRow = maxRow + 1;
//                        if (maxShowRow_int <= maxRow) {
//                            return strBuf.toString();
//                        }
//                    } else {
//                        //ratio 用料比例 四舍五入到2位小数
//                        ratio_big = ratio_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                        mapObject.put("ratio", ratio_big.toString());
//                    }
//                } catch (NumberFormatException e) {
//                    //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
//                    String str_error = MessageFormat.format(msg_column_price_error,
//                            (i + index_int),
//                            "用料比例",
//                            ratio);
//                    strBuf.append(str_error);
//
//                    maxRow = maxRow + 1;
//                    if (maxShowRow_int <= maxRow) {
//                        return strBuf.toString();
//                    }
//                }
//            }

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
                        "BOM关联货品编码",
                        "二级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //prodCode_1 一级货品编码 ratio_1  一级用料比例
            String ratio_1 = mapObject.get("ratio_1");
            if (prodCode_1 != null && prodCode_1.trim().length() > 0
                    && (ratio_1 == null || ratio_1.trim().length() == 0)
                    ) {
                //String msg_ratio_isnull = "第 {0} 行: ({1})输入为空或空字符串，当填写({2})是，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_ratio_isnull,
                        (i+index_int),
                        "一级用料比例",
                        "一级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if (ratio_1 != null && ratio_1.trim().length() > 0) {
                try {
                    BigDecimal ratio_big = new BigDecimal(ratio_1);
                    if (ratio_big.doubleValue() <= 0D) {
                        //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                        String str_error = MessageFormat.format(msg_column_price_error,
                                (i + index_int),
                                "一级用料比例",
                                ratio_1);
                        strBuf.append(str_error);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {
                            return strBuf.toString();
                        }
                    } else {
                        //ratio_1  一级用料比例 四舍五入到2位小数
                        ratio_big = ratio_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        mapObject.put("ratio_1", ratio_big.toString());
                    }
                } catch (NumberFormatException e) {
                    //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                    String str_error = MessageFormat.format(msg_column_price_error,
                            (i + index_int),
                            "一级用料比例",
                            ratio_1);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {
                        return strBuf.toString();
                    }
                }
            }

            //prodCode_2 二级货品编码 ratio_2  二级用料比例
            String ratio_2 = mapObject.get("ratio_2");
            if (prodCode_2 != null && prodCode_2.trim().length() > 0
                    && (ratio_2 == null || ratio_2.trim().length() == 0)
                    ) {
                //String msg_ratio_isnull = "第 {0} 行: ({1})输入为空或空字符串，当填写({2})是，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_ratio_isnull,
                        (i+index_int),
                        "二级用料比例",
                        "二级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if (ratio_2 != null && ratio_2.trim().length() > 0) {
                try {
                    BigDecimal ratio_big = new BigDecimal(ratio_2);
                    if (ratio_big.doubleValue() <= 0D) {
                        //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                        String str_error = MessageFormat.format(msg_column_price_error,
                                (i + index_int),
                                "二级用料比例",
                                ratio_2);
                        strBuf.append(str_error);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {
                            return strBuf.toString();
                        }
                    } else {
                        //ratio_2  二级用料比例 四舍五入到2位小数
                        ratio_big = ratio_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        mapObject.put("ratio_2", ratio_big.toString());
                    }
                } catch (NumberFormatException e) {
                    //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                    String str_error = MessageFormat.format(msg_column_price_error,
                            (i + index_int),
                            "二级用料比例",
                            ratio_2);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {
                        return strBuf.toString();
                    }
                }
            }

            //prodCode_3 三级货品编码 ratio_3  三级用料比例
            String ratio_3 = mapObject.get("ratio_3");
            if (prodCode_3 != null && prodCode_3.trim().length() > 0
                && (ratio_3 == null || ratio_3.trim().length() == 0)
            ) {
                //String msg_ratio_isnull = "第 {0} 行: ({1})输入为空或空字符串，当填写({2})是，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_ratio_isnull,
                        (i+index_int),
                        "三级用料比例",
                        "三级货品编码");
                strBuf.append(str_isnull);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if (ratio_3 != null && ratio_3.trim().length() > 0) {
                try {
                    BigDecimal ratio_big = new BigDecimal(ratio_3);
                    if (ratio_big.doubleValue() <= 0D) {
                        //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                        String str_error = MessageFormat.format(msg_column_price_error,
                                (i + index_int),
                                "三级用料比例",
                                ratio_3);
                        strBuf.append(str_error);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {
                            return strBuf.toString();
                        }
                    } else {
                        //ratio_3  三级用料比例 四舍五入到2位小数
                        ratio_big = ratio_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                        mapObject.put("ratio_3", ratio_big.toString());
                    }
                } catch (NumberFormatException e) {
                    //String msg_column_price_error = "第 {0} 行: {1}:{2} 输入错误，请输大于零的整数或小数！"
                    String str_error = MessageFormat.format(msg_column_price_error,
                            (i + index_int),
                            "三级用料比例",
                            ratio_3);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {
                        return strBuf.toString();
                    }
                }
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

    /**
     * 获取添加BOM及BOMTree数据Map结构体- Excel导入数据
     * Map<(货品编码,BOM名称,userId,companyId), Excel导入数据>
     *
     * @return
     */
    public Map<String, List<Map<String, String>>> findBomMapByImportDataList(List<LinkedHashMap<String, String>> objectList) {
        Map<String, List<Map<String, String>>> bomMap = new LinkedHashMap<String, List<Map<String, String>>>();
        if (objectList == null || objectList.size() == 0) {return bomMap;}

        for (LinkedHashMap<String, String> mapData : objectList) {
            //prodCode 货品编码
            String prodCode = mapData.get("prodCode");
            //bomName BOM名称
            String bomName = mapData.get("bomName");
            String userId = mapData.get("userId");
            String companyId = mapData.get("companyId");
            String bomMapKey = prodCode + this.separator + bomName + this.separator + userId + this.separator + companyId;

            if (bomMap.get(bomMapKey) == null) {
                List<Map<String, String>> valueList = new ArrayList<Map<String, String>>();
                valueList.add(mapData);
                bomMap.put(bomMapKey, valueList);
            } else if (bomMap.get(bomMapKey) != null) {
                List<Map<String, String>> valueList = bomMap.get(bomMapKey);
                valueList.add(mapData);
            }
        }

        return bomMap;
    }

    public void addImportExcelByMap(Map<String, List<Map<String, String>>> bomMap) {
        if (bomMap == null || bomMap.size() == 0) {return;}

        for (Iterator iterator = bomMap.keySet().iterator(); iterator.hasNext();) {
            //mapKey: 货品编码,BOM名称,userId,companyId
            String mapKey = (String) iterator.next();
            String[] strArry = mapKey.split(this.separator);

            String prodCode = strArry[0];
            String bomName = strArry[1];
            String userId = strArry[2];
            String companyId = strArry[3];

            Bom bom = new Bom();
            bom.setCuser(userId);
            bom.setCompanyId(companyId);
            bom.setName(bomName);
            //获取BOM编码
            String code = coderuleService.createCoder(companyId,"vmes_bom","B");
            bom.setCode(code);

            //isdefault 是否默认(0:非默认 1:默认)
            bom.setIsdefault("1");
            if (bomMap.get(mapKey) != null) {
                bom.setIsdefault("0");
            }

            List<Map<String, String>> bomValueList = bomMap.get(mapKey);
            Map<String, String> bomValueMap = this.findBomValueMap(bomValueList);

            try {
                //1. 添加 vmes_bom 表
                bomService.save(bom);

                String bomId = bom.getId();
                String prodId = prodCodeKeyMap.get(prodCode);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }




//            //bomName BOM名称
//            String bomName = mapObject.get("bomName");
//            //prodCode 货品编码
//            String prodCode = mapObject.get("prodCode");
//            //ratio 用料比例
//            String ratio = mapObject.get("ratio");
//            //prodCode_1 一级货品编码
//            String prodCode_1 = mapObject.get("prodCode_1");
//            //prodCode_2 二级货品编码
//            String prodCode_2 = mapObject.get("prodCode_2");
//            //prodCode_3 三级货品编码
//            String prodCode_3 = mapObject.get("prodCode_3");
//            //remark 备注
//            String remark = mapObject.get("remark");


    }

    private void finalProdCodeKeyMapByCompanyId(String companyId) {
        this.prodCodeKeyMap = new HashMap<String, String>();

        if (companyId == null || companyId.trim().length() == 0) {return;}

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Product> productList = productService.findProductList(findMap);
        if (productList == null || productList.size() == 0) {return;}

        for (Product product : productList) {
            this.prodCodeKeyMap.put(product.getCode(), product.getId());
        }
    }

    private Map<String, String> findBomValueMap(List<Map<String, String>> mapLiet) {
        Map<String, String> bomValueMap = new LinkedHashMap<String, String>();
        if (mapLiet == null || mapLiet.size() == 0) {return bomValueMap;}

        for (Map<String, String> mapData : mapLiet) {
            StringBuffer bomValue_prodCode_key = new StringBuffer();

            //prodCode_1 一级货品编码
            String prodCode_1 = mapData.get("prodCode_1");
            //ratio_1  一级用料比例
            String ratio_1 = mapData.get("ratio_1");
            if (prodCode_1 != null && prodCode_1.trim().length() > 0) {
                bomValue_prodCode_key.append(":::")
                        .append(prodCode_1)
                        .append(this.separator)
                        .append(ratio_1);
            }

            //prodCode_2 二级货品编码
            String prodCode_2 = mapData.get("prodCode_2");
            //ratio_2  二级用料比例
            String ratio_2 = mapData.get("ratio_2");
            if (prodCode_2 != null && prodCode_2.trim().length() > 0) {
                bomValue_prodCode_key.append(":::")
                        .append(prodCode_2)
                        .append(this.separator)
                        .append(ratio_2);
            }

            //prodCode_3 三级货品编码
            String prodCode_3 = mapData.get("prodCode_3");
            //ratio_3  三级用料比例
            String ratio_3 = mapData.get("ratio_3");
            if (prodCode_3 != null && prodCode_3.trim().length() > 0) {
                bomValue_prodCode_key.append(":::")
                        .append(prodCode_3)
                        .append(this.separator)
                        .append(ratio_3);
            }

            String strTemp = bomValue_prodCode_key.toString();
            if (strTemp.indexOf(":::") != -1) {
                strTemp = strTemp.substring(strTemp.indexOf(":::") + ":::".length(), strTemp.length());
            }

            bomValueMap.put(strTemp, strTemp);
        }

        return bomValueMap;
    }
}
