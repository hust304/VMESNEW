package com.xy.vmes.common.util;

import com.xy.vmes.entity.Column;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class ColumnUtil {


    /**
     * 遍历模块栏位表对象List<Column>-获取模块栏位信息List<LinkedHashMap>
     *
     * @param objectList
     * @return
     */
    public static List<LinkedHashMap> listColumnByModelCode(List<Column> objectList) {
        List<LinkedHashMap> columnList = new ArrayList<LinkedHashMap>();
        if (objectList == null || objectList.size() == 0) {return columnList;}

        //按照 serialNumber 升序排列
        orderAcsBySerialNumber(objectList);

        LinkedHashMap<String, Object> columnMap = new LinkedHashMap<String, Object>();
        for (Column column : objectList) {
            String mapKey = column.getTitleKey();
            String mapValue = column.getTitleName();

            //是否隐藏(0:隐藏 1:显示)
            if (!"1".equals(column.getIshide())) {
                mapKey = mapKey + "_hide";
            }

            columnMap.put(mapKey, mapValue);
        }

        columnList.add(columnMap);
        return columnList;
    }

    public static Map<String, String> keyValueMap(List<Column> objectList) {
        Map<String, String> keyValueMap = new HashMap<String, String>();
        if (objectList == null || objectList.size() == 0) {return keyValueMap;}

        for (Column column : objectList) {
            String mapKey = column.getTitleKey();
            keyValueMap.put(mapKey, "");
        }
        return keyValueMap;
    }



    /**
     * 查询结果集List<Map>-按照栏位列表Map的显示顺序-重构结果集List<Map>
     *
     * @param columnList  栏位列表Map<栏位编码, 栏位名称>
     * @param dataList   业务查询结果集Map<栏位编码, Object>
     * @return
     */
    public static List<LinkedHashMap<String, String>> modifyDataList(List<Column> columnList, List<Map> dataList) {
        List<LinkedHashMap<String, String>> dataMapList = new ArrayList<LinkedHashMap<String, String>>();
        if(dataList == null) {return dataMapList;}

        //1. 获取(第一行:栏位编码 第二行: 栏位名称)
        LinkedHashMap<String, String> columnCodeMap = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> columnNameMap = new LinkedHashMap<String, String>();
        for (Column column : columnList) {
            if("0".equals(column.getIshide())){
                columnNameMap.put(column.getTitleKey()+"_hide", column.getTitleName());
                columnCodeMap.put(column.getTitleKey()+"_hide", column.getTitleKey());
            }else {
                columnNameMap.put(column.getTitleKey(), column.getTitleName());
                columnCodeMap.put(column.getTitleKey(), column.getTitleKey());
            }
        }
        dataMapList.add(columnCodeMap);
        dataMapList.add(columnNameMap);

        //获取栏位值
        for (Map dataMap : dataList) {
            LinkedHashMap<String, String> columnValueMap = new LinkedHashMap<String, String>();
            for (Column column : columnList) {
                if(column!=null){
                    String columnMapKey = column.getTitleKey();
                    if(!StringUtils.isEmpty(columnMapKey)){
                        String dataValue = "";
                        Object object = dataMap.get(columnMapKey);
                        if (object != null) {
                            dataValue = object.toString();
                        }

                        if("0".equals(column.getIshide())){
                            columnValueMap.put(columnMapKey+"_hide", dataValue);
                        }else {
                            columnValueMap.put(columnMapKey, dataValue);
                        }


                    }
                }

            }
            dataMapList.add(columnValueMap);
        }

        return dataMapList;
    }



    private static void orderAcsBySerialNumber(List<Column> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                Column object_0 = (Column)arg0;
                Column object_1 = (Column)arg1;
                return object_0.getSerialNumber().compareTo(object_1.getSerialNumber());
            }
        });
    }
}
