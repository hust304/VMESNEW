package com.xy.vmes.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserExcelService {
    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  Integer index,
                                  Integer maxShowRow);
}
