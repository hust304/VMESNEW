package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.LogInfoMapper;
import com.xy.vmes.entity.LogInfo;
import com.xy.vmes.service.LogInfoService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-28
*/
@Service
@Transactional(readOnly = false)
public class LogInfoServiceImp implements LogInfoService {


    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void save(LogInfo logInfo) throws Exception{
        logInfo.setId(Conv.createUuid());
        logInfo.setCdate(new Date());
        logInfo.setUdate(new Date());
        logInfoMapper.insert(logInfo);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void update(LogInfo logInfo) throws Exception{
        logInfo.setUdate(new Date());
        logInfoMapper.updateAllColumnById(logInfo);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    //@Cacheable(cacheNames = "logInfo", key = "''+#id")
    public LogInfo selectById(String id) throws Exception{
        return logInfoMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void deleteById(String id) throws Exception{
        logInfoMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        logInfoMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<LogInfo> dataListPage(PageData pd,Pagination pg) throws Exception{
        return logInfoMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<LogInfo> dataList(PageData pd) throws Exception{
        return logInfoMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return logInfoMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return logInfoMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        logInfoMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<LogInfo> selectByColumnMap(Map columnMap) throws Exception{
    List<LogInfo> logInfoList =  logInfoMapper.selectByMap(columnMap);
        return logInfoList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return logInfoMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return logInfoMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return logInfoMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-28
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        logInfoMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

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
    public LogInfo createLoginfo(LogInfo object) {
        if (object == null) {object = new LogInfo();}
        object.setCdate(new Date());

        return object;

    }

}



