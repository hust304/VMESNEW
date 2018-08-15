package com.xy.vmes.common.util;

import java.util.*;

/**
 * Excel文件导入导出工具类
 */
public class ExcelUtil {
    /**
     * 根据栏位编码(业务表字段','分隔的字符串)-修改业务模块列表属性(隐藏显示属性)
     * 应用场景: 某些业务List列表显示或Excel导入导出列表与业务默认列表不一致
     *
     * 1. 根据栏位编码-重新组装Titl列表显示隐藏属性-显示字段在前::隐藏字段在后
     * 2. 栏位编码(业务表字段','分隔的字符串)不为空-按照栏位编码指定的显示顺序显示或Excel导出
     * 3. 栏位编码为空-按照业务默认显示顺序显示或Excel导出
     *
     * @param fieldCode   导出Excel栏位编码
     * @param columnMap  业务模块列表Map<栏位编码, 栏位名称>
     * @return
     */
    public static LinkedHashMap modifyColumnMap(String fieldCode, LinkedHashMap columnMap) {
        if (columnMap == null) {columnMap = new LinkedHashMap();}

        //1. 重新生成TitlMap-显示字段-隐藏字段
        //LinkedHashMap columnMap = columnList.get(0);
        Map<String, LinkedHashMap> showHideMap = findShowhideColumnMap(fieldCode, columnMap);

        //2. 重新拼装业务Title列表-显示字段在前-隐藏字段在后
        return createColumnMap(showHideMap.get("hideColumnMap"), showHideMap.get("showColumnMap"));
    }


    /**
     * 查询结果集List<Map>-按照栏位列表Map的显示顺序-重构结果集List<Map>
     *
     * @param columnMap  栏位列表Map<栏位编码, 栏位名称>
     * @param dataList   业务查询结果集Map<栏位编码, Object>
     * @return
     */
    public static List<LinkedHashMap<String, String>> modifyDataList(LinkedHashMap columnMap, List<Map> dataList) {
        List<LinkedHashMap<String, String>> dataMapList = new ArrayList<LinkedHashMap<String, String>>();
        if(dataList == null) {return dataMapList;}

        //1. 获取(第一行:栏位编码 第二行: 栏位名称)
        LinkedHashMap<String, String> columnCodeMap = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> columnNameMap = new LinkedHashMap<String, String>();
        for (Iterator iterator = columnMap.keySet().iterator(); iterator.hasNext();) {
            String columnMapKey = iterator.next().toString().trim();
            //获取栏位名称
            String columnName = columnMap.get(columnMapKey).toString();
            columnCodeMap.put(columnMapKey, columnMapKey);
            columnNameMap.put(columnMapKey, columnName);
        }
        dataMapList.add(columnCodeMap);
        dataMapList.add(columnNameMap);

        //获取栏位值
        for (Map dataMap : dataList) {
            LinkedHashMap<String, String> columnValueMap = new LinkedHashMap<String, String>();
            for (Iterator iterator = columnMap.keySet().iterator(); iterator.hasNext();) {
                String columnMapKey = iterator.next().toString().trim();
                //获取栏位编码
                String columnCode = columnMapKey;
                String strTemp = columnMapKey;
                if (strTemp.indexOf("_hide") != -1) {
                    columnCode = strTemp.replace("_hide", "");
                }

                String dataValue = "";
                Object object = dataMap.get(columnCode);
                //Integer
                //Date
                //BigDecimal
                if (object != null) {dataValue = object.toString();}
                columnValueMap.put(columnMapKey, dataValue);
            }
            dataMapList.add(columnValueMap);
        }

        return dataMapList;
    }

    ///////////////////////////////////////////////////
    private static LinkedHashMap createColumnMap(LinkedHashMap hideColumnMap, LinkedHashMap showColumnMap) {
        LinkedHashMap newColumnMap = new LinkedHashMap();

        if (showColumnMap != null) {
            for (Iterator iterator = showColumnMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey = iterator.next().toString().trim();
                String mapValue = showColumnMap.get(mapKey).toString();
                newColumnMap.put(mapKey, mapValue);
            }
        }

        if (hideColumnMap != null) {
            for (Iterator iterator = hideColumnMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey = iterator.next().toString().trim();
                String mapValue = hideColumnMap.get(mapKey).toString();
                newColumnMap.put(mapKey, mapValue);
            }
        }

        return newColumnMap;
    }


    private static Map<String, LinkedHashMap> findShowhideColumnMap(LinkedHashMap columnMap) {
        Map<String, LinkedHashMap> showHideMap = new HashMap<String, LinkedHashMap>();
        if (columnMap == null || columnMap.size() == 0) {return showHideMap;}

        LinkedHashMap hideColumnMap = new LinkedHashMap();
        LinkedHashMap showColumnMap = new LinkedHashMap();
        for (Iterator iterator = columnMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = iterator.next().toString().trim();
            String mapValue = columnMap.get(mapKey).toString();

            //"_hide"(默认字段为隐藏栏位)-修改为显示
            if (mapKey.indexOf("_hide") != -1) {
                hideColumnMap.put(mapKey, mapValue);
            } else if (mapKey.indexOf("_hide") == -1) {
                showColumnMap.put(mapKey, mapValue);
            }
        }

        showHideMap.put("showColumnMap", showColumnMap);
        showHideMap.put("hideColumnMap", hideColumnMap);
        return showHideMap;
    }

    private static Map<String, LinkedHashMap> findShowhideColumnMap(String fieldCode, LinkedHashMap columnMap) {
        Map<String, LinkedHashMap> showHideMap = new HashMap<String, LinkedHashMap>();
        if (columnMap == null || columnMap.size() == 0) {return showHideMap;}

        if (fieldCode == null || fieldCode.trim().length() == 0) {
            return findShowhideColumnMap(columnMap);
        }

        //2.遍历栏位Map<栏位编码, 栏位名称>-重新定义业务列表(隐藏,显示)属性
        String[] fieldArry = fieldCode.split(",");
        LinkedHashMap hideColumnMap = new LinkedHashMap();
        LinkedHashMap showColumnMap = new LinkedHashMap();
        for (Iterator iterator = columnMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = iterator.next().toString().trim();
            String mapValue = columnMap.get(mapKey).toString();

            boolean isExist = false;
            for (int i = 0; i < fieldArry.length; i++) {
                String field = fieldArry[i].trim();
                if (mapKey.indexOf(field) != -1) {
                    isExist = true;
                    break;
                }
            }

            //"_hide"(默认字段为隐藏栏位)-修改为显示
            if (isExist) {
                if (mapKey.indexOf("_hide") != -1) {
                    String newKey = mapKey.replace("_hide", "");
                    showColumnMap.put(newKey, mapValue);
                } else {
                    showColumnMap.put(mapKey, mapValue);
                }
            } else if (!isExist) {
                if (mapKey.indexOf("_hide") == -1) {
                    hideColumnMap.put(mapKey + "_hide", mapValue);
                } else {
                    hideColumnMap.put(mapKey, mapValue);
                }
            }
        }

        showHideMap.put("showColumnMap", showColumnMap);
        showHideMap.put("hideColumnMap", hideColumnMap);
        return showHideMap;
    }


}
