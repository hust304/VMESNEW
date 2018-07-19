package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.yvan.PageData;
import com.yvan.Tree;
import com.yvan.platform.RestException;

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
    void save(Department department);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    void delete(Department department);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    void update(Department department);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    void deleteById(String id);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    Department selectById(String id);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    Department findById(PageData pd);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    List<Department> dataListPage(PageData pd, Pagination pg);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    List<Department> dataList(PageData pd);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    List<LinkedHashMap> findColumnList();

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    List<Map> findDataList(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    Department findDepartmentById(String id);

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    List<Department> findDepartmentListByPid(String pid);

    /**
     * 根据部门对象<Department>当前部门节点下面所有节点生成树形结构
     * 1. <Department>对象为空时-生成整棵树-(pid:=root)开始-部门级别(0-5)
     * 2. <Department>对象is not null
     * (允许为空)Department.pid   上级部门id
     * (允许为空)Department.code  上级部门编码
     * (允许为空)Department.name  上级部门名称
     * (允许为空)Department.layer 上级部门级别
     * 3. (pid,code,name,layer) 不可同时为空
     * pid is not null pid对应的部门+pid下面所有子部门
     * pid is null (code,layer) is not null or (name,layer) is not null
     * <p>
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     * @param detp 允许为空-<Department>对象(vmes_department:系统部门表)
     * @return
     */
    public Tree<Department> findTree(Department detp);

    /**
     * 获取部门id字符串-(','分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    String findDeptidByDeptList(List<Department> objectList);
}



