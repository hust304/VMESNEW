package com.xy.vmes.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface EmployeeExcelBySimpleService {
    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  String userId,
                                  Integer index,
                                  Integer maxShowRow);

    /**
     * 添加系统基础表
     * 1. 添加部门
     * 2. 添加部门岗位
     * 3. 字典表(政治面貌)
     * @param objectList
     * @param companyId
     */
    void addSystemBaseTableImportExcel(List<LinkedHashMap<String, String>> objectList,
                                       String companyId,
                                       String userId) throws Exception;
}
