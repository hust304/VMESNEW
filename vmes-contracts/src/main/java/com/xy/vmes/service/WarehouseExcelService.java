package com.xy.vmes.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface WarehouseExcelService {

    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  String userId,
                                  Integer index,
                                  Integer maxShowRow);

    String checkExistImportExcelBySelf(List<LinkedHashMap<String, String>> objectList,
                                       Integer index,
                                       Integer maxShowRow);

    String checkExistImportExcelByDatabase(List<LinkedHashMap<String, String>> objectList,
                                           Integer index,
                                           Integer maxShowRow);

    /**
     * 获取添加仓库数据Map结构体- Excel导入数据
     * Map<仓库名称, Excel导入数据>
     *
     * @return
     */
    Map<String, List<Map<String, String>>> findWarehouseMapByImportDataList(List<LinkedHashMap<String, String>> objectList);
    void addImportExcelByMap(Map<String, List<Map<String, String>>> warehouseMap);

}
