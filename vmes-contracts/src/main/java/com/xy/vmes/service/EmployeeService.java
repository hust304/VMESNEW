package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Employee;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 接口类
* 创建人：自动生成
* 创建时间：2018-07-20
*/
public interface EmployeeService {


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void save(Employee employee) throws Exception;


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void update(Employee employee) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void deleteById(String id) throws Exception;
    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    Employee selectById(String id) throws Exception;



    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<Employee> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<Employee> dataList(PageData pd) throws Exception;


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<Map> findDataList(PageData pd) throws Exception;
}



