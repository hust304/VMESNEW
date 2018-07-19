package com.xy.vmes.service;

import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.TreeEntity;
import com.yvan.Tree;
import com.yvan.platform.RestException;
import java.util.List;

/**
 * 当前部门节点和该部门节点下所有子部门-的树形结构
 * 1. 查询(vmes_department:系统部门表)-查询次数(当前部门节点-最低层叶子部门节点)层数
 * 2. 每次递归查询pid-(通过','逗号分隔的字符串)-得到下一层部门节点List集合-存入对应的层的List结构体中
 * 3. 递归结束条件()
 *
 * 部门树结构生成
 * 创建人：陈刚
 * 创建时间：2018-07-19
 */
public interface DepartmentTreeService {
    List<Department> getList_0();
    List<Department> getList_1();
    List<Department> getList_2();
    List<Department> getList_3();
    List<Department> getList_4();
    List<Department> getList_5();

    /**
     * 初始化方法
     * 创建人：陈刚
     * 创建时间：2018-07-19
     */
    void initialization();


    void findDeptTree(String pids) throws RestException;


    /**
     * 创建人：陈刚
     * 创建时间：2018-07-19
     */
    TreeEntity dept2Tree(Department dept, TreeEntity tree);
}
