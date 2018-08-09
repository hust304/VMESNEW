package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.LoginfoMapper;
import com.xy.vmes.entity.Loginfo;
import com.xy.vmes.service.LoginfoService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_loginfo:系统日志表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-08-08
*/
@Service
@Transactional(readOnly = false)
public class LoginfoServiceImp implements LoginfoService {
    @Autowired
    private LoginfoMapper loginfoMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public void save(Loginfo loginfo) throws Exception{
        loginfo.setId(Conv.createUuid());
        loginfo.setCdate(new Date());
        loginfoMapper.insert(loginfo);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<Loginfo> dataList(PageData pd) throws Exception{
        return loginfoMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<LinkedHashMap<String, String>> getColumnList() throws Exception{
        return loginfoMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<Map<String, Object>> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return loginfoMapper.getDataListPage(pd,pg);
    }

    /**
     * 获取调用方法名称前缀：
     * 根据Controller调用方法全路径名称(com.xy.vmes.deecoop.system.controller.DepartmentController.addDepartment())
     * @param methodPath
     * @return
     */
    public String findMethodPrefix(String methodPath) {
        if (methodPath == null || methodPath.trim().length() == 0) {return new String();}
        if (methodPath.indexOf("throws java.lang.Exception") != -1) {
            methodPath = methodPath.replace("throws java.lang.Exception", "");
        }

        int maxLength = methodPath.length();
        int beginIndex = methodPath.lastIndexOf(".") + 1;

        //1. 获取调用方法名称
        String method = new String();
        if (beginIndex < maxLength) {
            method = methodPath.substring(beginIndex, maxLength);
        }
        if (method.trim().length() == 0) {return new String();}

        //2. 获取调用方法前缀
        Map<String, String> methodPrefixMap = Common.SYSLOGINFO_METHODPREFIX_MAP;
        for (Iterator iterator = methodPrefixMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            String mapValue = methodPrefixMap.get(mapKey);
            if (method.indexOf(mapKey) != -1) {
                return mapValue;
            }
        }

        return new String();
    }

    /**
     * 获取业务表名：
     * 根据Controller调用方法全路径名称(com.xy.vmes.deecoop.system.controller.DepartmentController.addDepartment())
     * @param methodPath
     * @return
     */
    public String findTable(String methodPath) {
        if (methodPath == null || methodPath.trim().length() == 0) {return new String();}

        Map<String, String> classnameMap = Common.SYSLOGINFO_CLASSNAME2TABLENAME_MAP;
        for (Iterator iterator = classnameMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            String mapValue = classnameMap.get(mapKey);
            if (methodPath.indexOf(mapKey) != -1) {
                return mapValue;
            }
        }

        return new String();
    }

    /**
     * 创建新的日志对象<Loginfo>
     * @return
     */
    public Loginfo createLoginfo(Loginfo object) {
        if (object == null) {object = new Loginfo();}
        object.setCdate(new Date());

        return object;

    }

}



