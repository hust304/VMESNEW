package com.xy.vmes.common.util;

import com.xy.vmes.entity.Column;

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
