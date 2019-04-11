package com.xy.vmes.deecoop.base.service;

import com.xy.vmes.service.CustomerExcelService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CustomerExcelServiceImp implements CustomerExcelService {
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


        //name 名称
        //genreName 属性
        //typeName 类型
        //provinceName 地区
        //remark 备注




        return null;
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

    public void addImportExcelByList(List<LinkedHashMap<String, String>> objectList) {
        if (objectList == null || objectList.size() == 0) {return;}

        for (int i = 0; i < objectList.size(); i++) {
//name 名称
            //genreName 属性
            //typeName 类型
            //provinceName 地区
            //remark 备注
        }

    }
}
