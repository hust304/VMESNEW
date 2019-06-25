package com.xy.vmes.service;

import com.xy.vmes.entity.WarehouseProduct;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface WarehouseProductExcelService {

    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  Integer index,
                                  Integer maxShowRow);

    String checkColumnImportExcelBySpare(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  Integer index,
                                  Integer maxShowRow);


    String checkColumnImportExcelByDataBase(List<LinkedHashMap<String, String>> objectList,
                                            String companyId,
                                            Integer index,
                                            Integer maxShowRow,
                                            Map<String, String> warehouseMap,
                                            Map<String, String> productMap);
    String checkColumnImportExcelByDataBaseBySpare(List<LinkedHashMap<String, String>> objectList,
                                            String companyId,
                                            Integer index,
                                            Integer maxShowRow,
                                            Map<String, String> productMap);



    void findWarehouseProductMapByExcelDataList(List<LinkedHashMap<String, String>> objectList,
                                                Map<String, WarehouseProduct> warehouseProductMap,
                                                Map<String, String> warehouseMap,
                                                Map<String, String> productMap);

    void addWarehouseProduct(Map<String, WarehouseProduct> warehouseProductMap, String companyId, String userId) throws Exception;
    void addWarehouseProductBySpare(Map<String, WarehouseProduct> warehouseProductMap, String companyId, String userId) throws Exception;
}
