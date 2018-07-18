package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 接口类
* 创建人：自动生成
* 创建时间：2018-07-18
*/
public interface DepartmentService {


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    void save(Department department) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    void delete(Department department) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    void update(Department department) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    void deleteById(String id) throws Exception;
    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    Department selectById(String id) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    Department findById(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    List<Department> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    List<Department> dataList(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    List<Map> findDataList(PageData pd) throws Exception;
}



