package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.yvan.PageData;
import com.yvan.Tree;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_department:系统部门表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-23
*/
public interface DepartmentService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    void save(Department department) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    void update(Department department) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    Department selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    List<Department> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    List<Department> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    List<Map> findDataList(PageData pd) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    Department findDepartment(PageData object);

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    List<Department> findDepartmentList(PageData object);

    /**
     * 根据部门对象<Department>当前部门节点下面所有节点生成树形结构
     * 1. <Department>对象为空时-生成整棵树-(pid:=root)开始-部门级别(0-5)
     * 2. <Department>对象is not null
     * (允许为空)Department.id    当前部门id
     * (允许为空)Department.code  当前部门编码
     * (允许为空)Department.name  当前部门名称
     * (允许为空)Department.id1   当前部门(id_1)-公司id
     * (允许为空)Department.layer 当前部门级别
     * 3. (id,id1,code,name,layer) 不可同时为空
     * pid is not null pid对应的部门+pid下面所有子部门
     * pid is null (code,layer) is not null or (name,layer) is not null
     * <p>
     * <p>
     * <p>
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     * @param detp 允许为空-<Department>对象(vmes_department:系统部门表)
     * @return
     */
    Tree<Department> findTree(Department detp);

    /**
     * 获取部门id字符串-(','分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    String findDeptidByDeptList(List<Department> objectList);

    /**
     * 获取部门最大级别-遍历部门List<Department>
     *
     * 创建人：陈刚
     * 创建时间：2018-07-24
     * @param objectList
     * @return
     */
    Integer findMaxLayerByDeptList(List<Department> objectList);
}



