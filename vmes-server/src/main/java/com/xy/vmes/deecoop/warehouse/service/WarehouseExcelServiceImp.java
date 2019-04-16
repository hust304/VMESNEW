package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.WarehouseExcelService;
import com.xy.vmes.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.*;

@Service
public class WarehouseExcelServiceImp implements WarehouseExcelService {
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private WarehouseService warehouseService;

    private String separator = ",";
    public static final Map<String, String> columnname_index_map = new HashMap<String, String>() {{
        put("1", "一级名称");
        put("2", "二级名称");
        put("3", "三级名称");
        put("4", "四级名称");
        put("5", "五级名称");
        put("6", "六级名称");
    }};

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


        //获取全部 仓库类型
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("warehouseType"), null);
        Map<String, String> entityTypeNameKeyMap = dictionaryService.getNameKeyMap();

        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;


        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //companyId 企业ID
            mapObject.put("companyId", companyId);
            mapObject.put("userId", userId);

            //name_0 仓库名称(实体)
            String name_0 = mapObject.get("name_0");
            if (name_0 == null || name_0.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "仓库名称");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //entityTypeName 仓库类型
            String entityTypeName = mapObject.get("entityTypeName");
            if (entityTypeName == null || entityTypeName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "仓库类型");
                strBuf.append(str_isnull);

                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            } else if (entityTypeName != null && entityTypeName.trim().length() > 0) {
                if (entityTypeNameKeyMap != null && entityTypeNameKeyMap.size() > 0 && entityTypeNameKeyMap.get(entityTypeName) == null) {
                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，在系统中不存在！"
                    String str_error = MessageFormat.format(msg_column_error,
                            (i+index_int),
                            "仓库类型",
                            entityTypeName);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                } else if (entityTypeNameKeyMap != null && entityTypeNameKeyMap.size() > 0 && entityTypeNameKeyMap.get(entityTypeName) != null) {
                    //entityType 仓库类型id
                    mapObject.put("entityType", entityTypeNameKeyMap.get(entityTypeName));
                }
            }

            //name_1 一级名称
            //name_2 二级名称
            //name_3 三级名称
            //name_4 四级名称
            //name_5 五级名称
            //name_6 六级名称

            String msgStr = this.checkChildName(mapObject, (i+index_int));
            if (msgStr != null && msgStr.trim().length() > 0) {
                strBuf.append(msgStr);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

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
     * 获取添加仓库数据Map结构体- Excel导入数据
     * Map<(仓库名称,userId,companyId), Excel导入数据>
     *
     * @return
     */
    public Map<String, List<Map<String, String>>> findWarehouseMapByImportDataList(List<LinkedHashMap<String, String>> objectList) {
        Map<String, List<Map<String, String>>> warehouseMap = new LinkedHashMap<String, List<Map<String, String>>>();
        if (objectList == null || objectList.size() == 0) {return warehouseMap;}

        for (LinkedHashMap<String, String> mapData : objectList) {
            //name_0 仓库名称(实体)
            String name_0 = mapData.get("name_0");
            String userId = mapData.get("userId");
            String companyId = mapData.get("companyId");
            String warehouseMapKey = name_0 + this.separator + userId + this.separator + companyId;

            if (warehouseMap.get(warehouseMapKey) == null) {
                List<Map<String, String>> valueList = new ArrayList<Map<String, String>>();
                valueList.add(mapData);
                warehouseMap.put(warehouseMapKey, valueList);
            } else if (warehouseMap.get(warehouseMapKey) != null) {
                List<Map<String, String>> valueList = warehouseMap.get(warehouseMapKey);
                valueList.add(mapData);
            }
        }

        return warehouseMap;
    }

    public void addImportExcelByMap(Map<String, List<Map<String, String>>> warehouseMap) {
        if (warehouseMap == null || warehouseMap.size() == 0) {return;}

        for (Iterator iterator = warehouseMap.keySet().iterator(); iterator.hasNext();) {
            Map<String, String> add_dataMap = new HashMap<String, String>();
            List<String> add_nameList = new ArrayList<String>();

            //mapKey: 仓库名称,userId,companyId
            String mapKey = (String) iterator.next();
            String[] strArry = mapKey.split(this.separator);
            String name_0 = strArry[0];
            add_dataMap.put("name_0", name_0);
            add_nameList.add(name_0);

            String userId = strArry[1];
            add_dataMap.put("userId", userId);

            String companyId = strArry[2];
            add_dataMap.put("companyId", companyId);

            List<Map<String, String>> valueList = warehouseMap.get(mapKey);
            //仓库类型id,name_1,name_2,name_3,name_4,name_5,name_6
            Map<String, String> valueMap = this.findWarehouseValueMap(valueList);
            for (Iterator iterator_1 = valueMap.keySet().iterator(); iterator_1.hasNext();) {
                String valueKey = (String) iterator_1.next();
                String[] valueArry = valueKey.split(this.separator);
                for (int i = 0; i < valueArry.length; i++) {
                    if (0 == i) {
                        //entityType 仓库类型id
                        add_dataMap.put("entityType", valueArry[i]);
                    } else if (0 < i) {
                        String childName = valueArry[i];
                        if (childName != null && childName.trim().length() > 0) {
                            add_nameList.add(childName);
                        }
                    }
                }
            }

            try {
                //插入 仓库表 vmes_warehouse
                warehouseService.addWarehouseByNameList(null,
                        add_dataMap,
                        add_nameList,
                        add_nameList.size());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //name_0 仓库名称(实体)
    //entityTypeName 仓库类型
    //name_1 一级名称
    //name_2 二级名称
    //name_3 三级名称
    //name_4 四级名称
    //name_5 五级名称
    //name_6 六级名称

    //////////////////////////////////////////////////////////////////////////////////
    private String checkChildName(Map<String, String> rowDataMap, int rowIndex) {
        if (rowDataMap == null || rowDataMap.size() == 0) {return new String();}

        String msg_column_isnull_1 = "第 {0} 行: ({1})到({2})请至少填写一项！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_isnull_2 = "第 {0} 行: 已填写({1})，那么({2})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_isnull_3 = "第 {0} 行: 已填写({1})，那么({2})到({3})列都是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;


        int max_notnull_index = 0;
        for (Iterator iterator = rowDataMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            String name = rowDataMap.get(mapKey);

            if (mapKey != null && mapKey.trim().length() > 0 && name != null && name.trim().length() > 0) {
                if (mapKey.indexOf("1") != -1) {
                    max_notnull_index = 1;
                } else if (mapKey.indexOf("2") != -1) {
                    max_notnull_index = 2;
                } else if (mapKey.indexOf("3") != -1) {
                    max_notnull_index = 3;
                } else if (mapKey.indexOf("4") != -1) {
                    max_notnull_index = 4;
                } else if (mapKey.indexOf("5") != -1) {
                    max_notnull_index = 5;
                } else if (mapKey.indexOf("6") != -1) {
                    max_notnull_index = 6;
                }
            }
        }

        if (0 == max_notnull_index) {
            //String msg_column_isnull_1 = "第 {0} 行: ({1})到({2})请至少填写一项！"
            String str_error = MessageFormat.format(msg_column_isnull_1,
                    rowIndex,
                    this.columnname_index_map.get(Integer.valueOf(1).toString()),
                    this.columnname_index_map.get(Integer.valueOf(columnname_index_map.size()).toString()));
            return str_error;
        } else if (2 == max_notnull_index) {
            for (Iterator iterator = rowDataMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey = (String) iterator.next();
                String name = rowDataMap.get(mapKey);

                if (mapKey != null && mapKey.trim().length() > 0) {
                    String index_str = mapKey.replace("name_", "");
                    Integer indexByData = null;
                    try {
                        indexByData = Integer.valueOf(index_str);
                    } catch (NumberFormatException e) {
                        //e.printStackTrace();
                    }
                    if (indexByData == null || indexByData < 1) {continue;}

                    if (indexByData < max_notnull_index && (name == null || name.trim().length() == 0)) {
                        //String msg_column_isnull_2 = "第 {0} 行: 已填写({1})，那么({2})是必填字段不可为空！"
                        String str_error = MessageFormat.format(msg_column_isnull_2,
                                rowIndex,
                                this.columnname_index_map.get(Integer.valueOf(2).toString()),
                                this.columnname_index_map.get(Integer.valueOf(1).toString()));
                        return str_error;
                    }
                }
            }
        } else if (3 <= max_notnull_index) {
            for (Iterator iterator = rowDataMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey = (String) iterator.next();
                String name = rowDataMap.get(mapKey);

                if (mapKey != null && mapKey.trim().length() > 0) {
                    String index_str = mapKey.replace("name_", "");
                    Integer indexByData = null;
                    try {
                        indexByData = Integer.valueOf(index_str);
                    } catch (NumberFormatException e) {
                        //e.printStackTrace();
                    }
                    if (indexByData == null || indexByData < 1) {continue;}

                    if (indexByData < max_notnull_index && (name == null || name.trim().length() == 0)) {
                        //String msg_column_isnull_3 = "第 {0} 行: 已填写({1})，那么({2})到({3})列都是必填字段不可为空！"
                        String str_error = MessageFormat.format(msg_column_isnull_3,
                                rowIndex,
                                this.columnname_index_map.get(Integer.valueOf(max_notnull_index).toString()),
                                this.columnname_index_map.get(Integer.valueOf(1).toString()),
                                this.columnname_index_map.get(Integer.valueOf(max_notnull_index-1).toString()));
                        return str_error;
                    }
                }
            }
        }

        return new String();
    }

    private Map<String, String> findWarehouseValueMap(List<Map<String, String>> mapLiet) {
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        if (mapLiet == null || mapLiet.size() == 0) {return valueMap;}

        for (Map<String, String> mapData : mapLiet) {
            StringBuffer value_key = new StringBuffer();

            //entityTypeName 仓库类型 entityType 仓库类型id
            String entityType = mapData.get("entityType");
            value_key.append(this.separator).append(entityType);

            //name_1 一级名称
            String name_1 = mapData.get("name_1");
            if (name_1 != null && name_1.trim().length() > 0) {
                value_key.append(this.separator).append(name_1);
            }

            //name_2 二级名称
            String name_2 = mapData.get("name_2");
            if (name_2 != null && name_2.trim().length() > 0) {
                value_key.append(this.separator).append(name_2);
            }

            //name_3 三级名称
            String name_3 = mapData.get("name_3");
            if (name_3 != null && name_3.trim().length() > 0) {
                value_key.append(this.separator).append(name_3);
            }

            //name_4 四级名称
            String name_4 = mapData.get("name_4");
            if (name_4 != null && name_4.trim().length() > 0) {
                value_key.append(this.separator).append(name_4);
            }

            //name_5 五级名称
            String name_5 = mapData.get("name_5");
            if (name_5 != null && name_5.trim().length() > 0) {
                value_key.append(this.separator).append(name_5);
            }

            //name_6 六级名称
            String name_6 = mapData.get("name_6");
            if (name_6 != null && name_6.trim().length() > 0) {
                value_key.append(this.separator).append(name_6);
            }

            String strTemp = value_key.toString();
            if (strTemp.indexOf(this.separator) != -1) {
                strTemp = strTemp.substring(strTemp.indexOf(this.separator) + this.separator.length(), strTemp.length());
            }

            valueMap.put(strTemp, strTemp);
        }

        return valueMap;
    }

}
