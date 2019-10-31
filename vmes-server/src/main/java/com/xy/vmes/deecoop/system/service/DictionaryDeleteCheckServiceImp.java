package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.service.CustomerService;
import com.xy.vmes.service.DictionaryDeleteCheckService;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.ProductUnitService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryDeleteCheckServiceImp implements DictionaryDeleteCheckService {
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private CustomerService customerService;

    /**
     * 删除字典时验证是否允许删除
     * 根据(字典id)查询相关业务表
     *
     * @param id 字典表id
     *
     * @return
     */
    public String checkDeleteDictionary(String id, String companyId) throws Exception {
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {return msgStr;}

        Dictionary dictionary = dictionaryService.findDictionaryById(id);
        if (dictionary == null) {return msgStr;}

        if (Common.DICTIONARY_MAP.get("productUnit").equals(dictionary.getPid())) {
            //字典表id:0ae6e79890db490585e13f34bf00ea4b 计量单位  Common.DICTIONARY_MAP.productUnit

            PageData findMap = new PageData();
            findMap.put("unit", id);

            String sqlStr = new String();
            if (companyId != null && companyId.trim().length() > 0) {
                String sqlStrTemp = "select id from vmes_product where company_id=''{0}''";
                sqlStr = MessageFormat.format(sqlStrTemp, companyId);
            }
            findMap.put("productQueryStr", sqlStr);
            //是否禁用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            List<ProductUnit> objectList = productUnitService.findProductUnitList(findMap);

            if (objectList != null && objectList.size() > 0) {
                String msgTemp = "该字典名称({0})在系统中正在使用";
                msgStr = MessageFormat.format(msgTemp, dictionary.getName());
                return msgStr;
            }

        } else if (Common.DICTIONARY_MAP.get("supplierType").equals(dictionary.getPid())
            || Common.DICTIONARY_MAP.get("customerType").equals(dictionary.getPid())
        ) {
            //字典表id:d28640b12a454246b172c49a604a89f5(字典id)  供应商类型 Common.DICTIONARY_MAP.supplierType:
            //字典表id:a50dcf66b14a440282eed9e26c1d9482(字典id)  客户类型  Common.DICTIONARY_MAP.customerType:

            PageData findMap = new PageData();
            findMap.put("type", id);
            //是否禁用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<Customer> objectList = customerService.findCustomerList(findMap);

            if (objectList != null && objectList.size() > 0) {
                String msgTemp = "该字典名称({0})在系统中正在使用";
                msgStr = MessageFormat.format(msgTemp, dictionary.getName());
                return msgStr;
            }

        }

        return msgStr;
    }
}
