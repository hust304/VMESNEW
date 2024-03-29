package com.xy.vmes.service;

import com.xy.vmes.entity.WarehouseProduct;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface WarehouseProductExcelBySimpleService {
    /**
     * 导入字段非空判断-(库存数量)数字判断-(仓库类型,货品属性)字典表判断
     * @param objectList
     * @param companyId
     * @param index
     * @param maxShowRow
     * @return
     */
    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  Integer index,
                                  Integer maxShowRow);

    /**
     * 添加系统基础表
     * 1. 仓库表
     * 2. 货品表
     * 3. 字典表(计量单位)
     * @param objectList
     * @param companyId
     */
    void addSystemBaseTableImportExcel(List<LinkedHashMap<String, String>> objectList,
                                       LinkedHashMap<String, String> titleMap,
                                       Integer maxParmInt,
                                       String companyId,
                                       String userId) throws Exception;

    /**
     * 获取货品自定义属性(parm1-parm150)
     * @param objectMap
     */
    void findProductParameter(Map<String, String> objectMap);
    void findExcelMap2ProductMap(Map<String, String> excelMap, Map<String, String> productMap);
    int findMaxNotNullProductParm(LinkedHashMap<String, String> tieleMap);
    boolean isNeedProductParm(LinkedHashMap<String, String> tieleMap, Integer maxParmInt);

    void findWarehouseProductMapByExcelDataList(List<LinkedHashMap<String, String>> objectList,
                                                Map<String, WarehouseProduct> warehouseProductMap,
                                                String companyId) throws Exception;

    void addWarehouseProduct(Map<String, WarehouseProduct> warehouseProductMap, String companyId, String userId) throws Exception;


}
