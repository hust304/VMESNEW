package com.xy.vmes.service;

import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.entity.WarehouseProduct;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售-客户货品单价-Excel导入 Service接口类
 * 创建人：陈刚
 * 创建时间：2019-10-25
 */
public interface SaleUnitPriceExcelService {
    /**
     * 导入字段非空判断-(客户单价)数字判断-(货品属性)字典表判断
     * 必填字段: 客户名称,货品名称,规格型号,货品属性,单位,客户单价
     *
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
     * 1. 客户表
     * 2. 货品表
     * 3. 字典表(计量单位)
     * @param objectList
     * @param companyId
     */
    void addSystemBaseTableImportExcel(List<LinkedHashMap<String, String>> objectList,
                                       String companyId,
                                       String userId,
                                       Map<String, String> sysCustomerMap,
                                       Map<String, String> sysUnitMap,
                                       Map<String, String> sysProductMap) throws Exception;

    void findSaleUnitPriceMapByExcelList(List<LinkedHashMap<String, String>> objectList,
                                         Map<String, SaleUnitPrice> saleUnitPriceMap,
                                         Map<String, String> sysCustomerMap,
                                         Map<String, String> sysUnitMap,
                                         Map<String, String> sysProductMap) throws Exception;

    void addSaleUnitPrice(Map<String, SaleUnitPrice> saleUnitPriceMap, String companyId, String userId) throws Exception;
}
